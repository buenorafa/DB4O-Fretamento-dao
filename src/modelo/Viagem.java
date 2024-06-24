package modelo;


public class Viagem {
	private String id;
	private String data;
	private Veiculo veiculo;
	private Motorista motorista;
	private String destino;
	
	
	public Viagem(String data,Veiculo veiculo, Motorista motorista, String destino){
		this.data = data;
		this.veiculo = veiculo;
		this.motorista = motorista;
		this.destino = destino; 
		this.id = this.data + this.motorista.getCnh() + this.veiculo.getPlaca();
	}
	
	public Viagem(String data, Veiculo veiculo, Motorista motorista) {
		this.data = data;
		this.veiculo = veiculo;
		this.motorista = motorista;
		this.destino = ""; 
		this.id = this.data + this.motorista.getCnh() + this.veiculo.getPlaca();
	}
	
	public String getId(){
		return id;
	}	
	public String getData() {
		return data;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
}
