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
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
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
		
		String result = "\nVeiculo placa=" + placa + ",  modelo=" + modelo + "\n";
		
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
