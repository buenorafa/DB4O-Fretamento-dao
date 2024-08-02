package daodb4o;

import java.util.ArrayList;
import java.util.List;

import com.db4o.query.Query;

import modelo.Motorista;

public class DAOMotorista extends DAO<Motorista> {
	public Motorista read (Object chave) {
		String cnh = (String) chave;
		Query q = manager.query();
		q.constrain(Motorista.class);
		q.descend("cnh").constrain(cnh);
		List<Motorista> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
		
	}
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	//			Consultas de Motorista
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	public List<Motorista> maisDeNViagens(int n){
		Query q = manager.query();
		q.constrain(Motorista.class);
		
		List<Motorista> motoristaMaisdeNViagens = new ArrayList<>();
		List<Motorista> motoristas = q.execute();
		//System.out.println(motoristas);

		for (Motorista m  : motoristas) {
			if (m.getViagens().size() > n) {
				//System.out.println(m.getViagens());
				motoristaMaisdeNViagens.add(m);
			}
		}
		return motoristaMaisdeNViagens;
	}
}
