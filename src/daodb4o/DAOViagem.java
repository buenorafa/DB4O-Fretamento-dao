package daodb4o;

import java.util.Date;
import java.util.List;

import com.db4o.query.Query;

import modelo.Veiculo;
import modelo.Viagem;

public class DAOViagem extends DAO<Viagem> {
	public Viagem read (Object chave) {
		String id = (String) chave;
		Query q = manager.query();
		q.constrain(Viagem.class);
		q.descend("id").constrain(id);
		List<Viagem> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
		
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	//			Consultas de Viagem
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	public List<Viagem> viagensNaData(Date data){
		Query q;
		q = manager.query();
		q.constrain(Viagem.class);
		q.descend("data").constrain(data);
		return q.execute();
	}
	
	public List<Viagem> viagensPorPlacaECNH(String placa, String cnh){
		Query q;
		q = manager.query();
		q.constrain(Viagem.class);
		q.descend("veiculo").descend("placa").constrain(placa);
		q.descend("motorista").descend("cnh").constrain(cnh);
		return q.execute();
	}

}
