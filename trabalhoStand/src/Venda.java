import java.util.Date;

public class Venda {

        private Veiculo veiculo;
        private Date data;
        private double precoFinal;

        // Construtor
        public Venda(Veiculo veiculo, Date data, double precoFinal) {
            this.veiculo = veiculo;
            this.data = data;
            this.precoFinal = precoFinal;
        }

        // Getters e setters
        public Veiculo getVeiculo() {
            return veiculo;
        }

        public void setVeiculo(Veiculo veiculo) {
            this.veiculo = veiculo;
        }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }
// Métodos para outros atributos...


    public double calcularPrecoFinal() {
        double precoSemImpostos = veiculo.getPreco();
        double valorImpostos = precoSemImpostos * 0.21; // 21% de impostos
        double valorDespesas = 1000; // Outras despesas fixas

        return precoSemImpostos + valorImpostos + valorDespesas;
    }















    }


