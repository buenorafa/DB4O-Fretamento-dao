package regras_negocio;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import daodb4o.DAO;
import daodb4o.DAOMotorista;
import daodb4o.DAOVeiculo;
import daodb4o.DAOViagem;

import modelo.Motorista;
import modelo.Veiculo;
import modelo.Viagem;

public class Fachada {
	private Fachada() {}
	
	private static DAOMotorista daomotorista = new DAOMotorista();
	private static DAOVeiculo daoveiculo = new DAOVeiculo();
	private static DAOViagem daoviagem = new DAOViagem();
	
	
	public static void inicializar() {
		DAO.open();
	}

	public static void finalizar() {
		DAO.close();
	}
	
	
	public static void criarMotorista(String cnh, String nome) throws Exception {
		DAO.begin();
		Motorista motorista = daomotorista.read(cnh);
		if(motorista != null) {
			DAO.rollback();
			throw new Exception("Criar motorista - CNH já existe: " + cnh);
		}
		motorista = new Motorista(cnh, nome);
		daomotorista.create(motorista);
		DAO.commit();
		
	}
	
	public static void criarVeiculo(String placa, String modelo) throws Exception {
		DAO.begin();
		Veiculo veiculo = daoveiculo.read(placa);
		if(veiculo != null) {
			DAO.rollback();
			throw new Exception("Criar veiculo - Placa já existe: " + placa);
		}
		veiculo = new Veiculo(placa, modelo);
		daoveiculo.create(veiculo);
		DAO.commit();
		
	}
	
	private static Date criarData(String data) throws Exception {
		 String[] DATE_FORMATS = {
			        "dd-MM-yyyy",
			        "yyyy-MM-dd",
			        "MM/dd/yyyy",
			        "dd/MM/yyyy"
			    };
		 for (String format : DATE_FORMATS) {
	            try {
	                SimpleDateFormat dateFormat = new SimpleDateFormat(format);
	                return dateFormat.parse(data);
	            } catch (ParseException e) {
	                // Ignorar e tentar o próximo formato
	            }
	        }
	        // Se nenhum formato for válido, retornar null ou lançar exceção
	        return null;
	}
	public static void criarViagem(String data, String placa, String cnh, String destino) throws Exception {
		DAO.begin();
		Date dataConv = criarData(data);
		if(dataConv == null) {
			throw new Exception("Criar viagem - Formato de data inválido: "+ data);
		}
		String id = Viagem.geraId(dataConv, placa, cnh);
		Viagem viagem = daoviagem.read(id);
		if(viagem != null) {
			DAO.rollback();
			throw new Exception("Criar viagem - Viagem já existe! ID: " + id);
		}
		Veiculo veiculo = daoveiculo.read(placa);
		if(veiculo == null) {
			DAO.rollback();
			throw new Exception("Criar viagem - Veiculo não existe! Placa: "+placa);
		} else {
			for(Viagem v : veiculo.getViagens()) {
				if( v.getData() == dataConv) {
					DAO.rollback();
					// REGRA DE NEGÓCIO
					throw new Exception("Criar Viagem - Não pode haver 2 viagens do mesmo carro na mesma data!\n"+
					"ID: "+ v.getId());
				}
						
			}
		}
		Motorista motorista = daomotorista.read(cnh);
		if(motorista == null) {
			throw new Exception("Criar viagem - Motorista não existe! CNH: "+cnh);
		}
		viagem = new Viagem(dataConv, veiculo, motorista, destino);
		daoviagem.create(viagem);
		DAO.commit();
	}
	
	



}
