package modelo;

import java.util.ArrayList;

public class Veiculo {

	private String placa;
	private String modelo;
	private ArrayList<Viagem> viagens = new ArrayList<>();
	
	public Veiculo(String placa, String modelo) {
		this.placa = placa;
		this.modelo = modelo;
	}
	
	public String getPlaca() {
		return placa;
	}

	public String getModelo() {
		return modelo;
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
