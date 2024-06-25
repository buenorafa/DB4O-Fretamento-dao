package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Viagem {
    private String id;
    private Date data;
    private Veiculo veiculo;
    private Motorista motorista;
    private String destino;

    public Viagem(Date data, Veiculo veiculo, Motorista motorista, String destino) {
        this.data = data;
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.destino = destino;
        this.id = geraId(data, veiculo.getPlaca(), motorista.getCnh());
    }

    public static String geraId(Date data, String placa, String cnh) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyMMdd");
        String formattedDate = dateFormatter.format(data);
        return formattedDate + placa + cnh;
    }

    public String getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

//    public void setData(Date data) {
//        this.data = data;
//        this.id = geraId(data, veiculo.getPlaca(), motorista.getCnh());  // Atualiza o ID quando a data muda
//    }

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
    

    // Método para obter a data como uma string no formato dd-MM-yyyy
    public String getDataAsString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(data);
    }
}
