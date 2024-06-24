package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import modelo.Viagem;

public class DAOViagem extends DAO<Viagem> {
	public Viagem read (Object chave) {
		String id = (String) chave;
		Query q = manager.query();
		q.constrain(Viagem.class);
		q.descend(id).constrain(chave);
		List<Viagem> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
		
	}

}
