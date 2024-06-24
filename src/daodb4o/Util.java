package daodb4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;


import modelo.Motorista;
import modelo.Veiculo;
import modelo.Viagem;

public class Util {
	private static ObjectContainer manager=null;
	
	public static ObjectContainer conectarBanco() {
		if (manager != null)
			return manager; //ja tem uma conexao
		
		//---------------------------------------------------------------
		//configurar, criar e abrir banco local (pasta do projeto)
		//---------------------------------------------------------------
		EmbeddedConfiguration config =  Db4oEmbedded.newConfiguration(); 
		
		config.common().messageLevel(0);  // mensagens na tela 0(desliga),1,2,3...
		
		// habilitar cascata na altera��o, remo��o e leitura
		config.common().objectClass(Motorista.class).cascadeOnDelete(false);
		config.common().objectClass(Motorista.class).cascadeOnUpdate(true);
		config.common().objectClass(Motorista.class).cascadeOnActivate(true);
		config.common().objectClass(Veiculo.class).cascadeOnDelete(false);
		config.common().objectClass(Veiculo.class).cascadeOnUpdate(true);
		config.common().objectClass(Veiculo.class).cascadeOnActivate(true);
		config.common().objectClass(Viagem.class).cascadeOnDelete(false);
		config.common().objectClass(Viagem.class).cascadeOnUpdate(true);
		config.common().objectClass(Viagem.class).cascadeOnActivate(true);
		// indexacao de atributos
		config.common().objectClass(Motorista.class).objectField("cnh").indexed(true);
		config.common().objectClass(Veiculo.class).objectField("placa").indexed(true);
		config.common().objectClass(Viagem.class).objectField("id").indexed(true);
		
		//conexao local
		manager = Db4oEmbedded.openFile(config, "banco.db4o");
		return manager;
		
	}
	
	public static void desconectar() {
		if(manager!=null) {
			manager.close();
			manager=null;
		}
	}

	
}




