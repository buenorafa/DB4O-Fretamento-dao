package modelo; 

import java.util.ArrayList;

public class Motorista {
	private String cnh;
	private String nome;
	private ArrayList<Viagem> viagens = new ArrayList<>();
	
	public Motorista(String cnh, String nome) {
		this.cnh = cnh;
		this.nome = nome;
	}
	
	public String getCnh() {
		return cnh;
	}
	
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Viagem> getViagens(){
		return viagens;
	}
	
	public void adicionar(Viagem viagem) {
		viagens.add(viagem);
		
	}
	
	public void remover(Viagem viagem) {
		viagens.remove(viagem);
	}
	
	@Override
	public String toString() {
		String result = "Motorista nome=" + nome + ", cnh=" + cnh + "\n";
		
		if (viagens.size() > 1) {
			result+= "data das viagens: ";
		} else {
			result+= "data da viagem: ";
		}
		
		for (Viagem v : viagens) 
			result+= "\n" + v.getData();
		
		return result; 
	}
}
