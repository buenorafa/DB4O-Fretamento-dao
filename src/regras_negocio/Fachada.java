package regras_negocio;

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
	
//	public static void criarViagem(String data, String placa, String motorista, String destino) throws Exception {
//		DAO.begin();
//
//	}



}
