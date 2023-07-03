import java.util.ArrayList;

public class RegistoVendas {

    private ArrayList<Venda> vendas;

    public RegistoVendas() {
        vendas = new ArrayList<Venda>();
    }

    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }

    public void listarVendas() {
        for (Venda venda : vendas) {
            System.out.println(venda);
        }
    }

    // Outros métodos...


}
