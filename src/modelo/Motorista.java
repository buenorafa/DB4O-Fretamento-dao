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
	public String getNome() {
		return nome;
	}
	public ArrayList<Viagem> getViagens(){
		return viagens;
	}
	
	public void adicionar(Viagem v) {
		viagens.add(v);
		
	}
	public void remover(Viagem v) {
		viagens.remove(v);
	}
	
	
		

}
