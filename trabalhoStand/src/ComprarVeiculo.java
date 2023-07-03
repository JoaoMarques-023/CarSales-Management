import java.util.ArrayList;
import java.util.Scanner;

public class ComprarVeiculo {

    // um atributo para guardar a lista de veículos disponíveis
    private ArrayList<Veiculo> veiculos;

    // um atributo para guardar a lista de clientes
    private ArrayList<Utilizador> utilizadores;

    public ComprarVeiculo(ArrayList<Veiculo> veiculos, ArrayList<Utilizador> utilizadores) {
        this.veiculos = veiculos;
        this.utilizadores = utilizadores;
    }


    public void verificaVeiculos() {
        if (veiculos.isEmpty()) {
        System.out.println("Não há veículos disponíveis no sistema.");
        return;
    }
    }

public void lista(){
    // listar os veículos do sistema

    System.out.println("Reservar Viatura: ");



    System.out.println("Veículos do sistema:");
    for (int i = 0; i < veiculos.size(); i++) {
        Veiculo v = veiculos.get(i);
        if(v.getEstado().equals("Disponivel"))
        System.out.println((i+1) + ". " + v.getMarca() + " - Matrícula: " + v.getMatricula() + " - Preço: " + v.getPreco() + " - Estado: " + v.getEstado());
    }
}

    public void comprar() {


        // pedir ao utilizador para escolher o veículo que quer comprar
        System.out.println("Escolha o veículo que quer comprar (introduza o número):");
        Scanner sc = new Scanner(System.in);
        int opcao = sc.nextInt();

        // obter o veículo escolhido
        Veiculo veiculoEscolhido = veiculos.get(opcao - 1);

        // obter o saldo do cliente
        Utilizador utilizador = utilizadores.get(0);

        double saldo = utilizador.getSaldo();

        // verificar se o saldo é suficiente para comprar o veículo
        if (saldo < veiculoEscolhido.getPreco()) {
            System.out.println("Saldo insuficiente!");
        } else {
            // remover o veículo da lista e informar o utilizador da compra com sucesso
            veiculos.remove(veiculoEscolhido);
            System.out.println("Veículo " + veiculoEscolhido.getMarca() + " comprado com sucesso!");

            double novoSaldo = utilizador.getSaldo() -veiculoEscolhido.getPreco(); // valor é a quantidade a ser adicionada ou subtraida do saldo

            utilizador.setSaldo(novoSaldo);



        }
    }


}


