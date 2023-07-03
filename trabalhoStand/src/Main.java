import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {



    public static Utilizador inserirUtilizador(){
        Scanner ler = new Scanner(System.in);
        String nome,  login, password, tipo;
        int nif;
        double saldo;


        do {
            System.out.println("Nome do utilizador: ");
            nome = ler.nextLine();
            if (nome.length() < 4) {
                System.out.println("O nome de utilizador deve ter pelo menos 6 carateres.");
            }
        } while (nome.length() < 4);



        System.out.println("Login: ");
        login = ler.nextLine();
        System.out.print("Password: ");
        password = ler.nextLine();

        System.out.println("Tipo de utilizador: ");
        System.out.println("Por favor digite cliente / dono / admin:");
        tipo = ler.nextLine();

        do {
            System.out.println("Insira o seu NIF (9 dígitos):");
            nif = ler.nextInt();
            if (String.valueOf(nif).length() != 9) {
                System.out.println("O NIF deve ter 9 dígitos!");
            }
        } while (String.valueOf(nif).length() != 9);


        System.out.println("Saldo: ");
        saldo = ler.nextInt();

        Utilizador utilizador = new Utilizador(nome, login, password, tipo, nif, saldo);


        return(utilizador);

    }



    private static Utilizador fazerLogin(ArrayList<Utilizador> utilizadores) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome de utilizador: ");
        String login = scanner.nextLine();
        System.out.print("Informe a senha: ");
        String password = scanner.nextLine();

        for (Utilizador user : utilizadores) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                System.out.println("Login efetuado com sucesso como " + user.getTipo());
                return user;
            }
        }
        System.out.println("Usuário ou senha inválidos");
        return null;
    }



    public static void main(String[] args) {
	// write your code here


        int opcao1, opcao2, opcao3, opcaoA;


        Utilizador utilizador, uNovo;
        Admin admin, aNovo;

        int indiceUtilizador, nif, indiceVeiculo, indiceReserva, indiceAdmin, ano;

        Veiculo veiculo, vNovo;
        ComprarVeiculo comprarVeiculo;
        Venda venda;
        double saldo;
        Scanner scanner = new Scanner(System.in);
        Date date;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);

        String matricula, data_reserva, nome, marca, modelo, estado, password, login, tipo;

        float preco;
        boolean encontrou = false;
        Scanner ler = new Scanner (System.in);


        Repositorio repo;
        repo = Repositorio.getRepositorio();
        if(repo.getUtilizadores().size() == 0){
            Utilizador u1 = new Utilizador();
            Repositorio.getRepositorio().getUtilizadores().add(u1.getNif(), u1);

        }



        do {
            System.out.println("\033[1mOpcao       Descricao                   \033[0m");
            System.out.println("\033[1m--------    --------------------------\033[0m");
            System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "1", "Registar Utilizador");
            System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "2", "Login");
            System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "3", "Sair");

            opcao1 = ler.nextInt();

            switch (opcao1) {
                case 1:
//Inserir Utilizador
                    utilizador = inserirUtilizador();
                    if (utilizador != null)
//verificar se o nif existe
                        encontrou = false;

                    for(Utilizador u: repo.utilizadores){
                        if(utilizador.getNif() == u.getNif()){
                            encontrou = true;
                        }
                    }
                    if(encontrou == true){
                        System.out.println("Nif ja existente!\n");
                    }
                    else{
                        repo.utilizadores.add(utilizador);
                    }
                    break;

                case 2:
                    indiceUtilizador = -1;
                    Utilizador usuarioAtual = fazerLogin((repo.utilizadores));
                    if (usuarioAtual != null) {



                        if (usuarioAtual.getTipo().equals("cliente")){
                            do {

                                System.out.println("\033[1mOpção       Descrição                   \033[0m");
                                System.out.println("\033[1m--------    --------------------------\033[0m");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "1", " Visualizar Perfil");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "2", "Editar Perfil");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "3", "Listar Veiculos ");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "4", "Listar Veiculos pela matricula ");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "5", "Reservar visita para um veiculo ");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "6", "Comprar um veiculo ");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "0", "Sair");


                                System.out.print("Opcao: ");
                                opcao2 = ler.nextInt();
                                switch (opcao2) {
                                    case 1:
//Visualizar Perfil
                                        System.out.println("Perfil: ");
                                        System.out.println(usuarioAtual.toString());
                                        break;
                                    case 2:
//Editar Perfil
                                        System.out.println("Editar perfil: ");

                                        System.out.println("Os dados atuais sao estes: ");
                                        System.out.println(usuarioAtual.toString());
                                        uNovo = usuarioAtual;
                                        System.out.println("Insira o nome que deseja");
                                        nome = ler.next();
                                        uNovo.setNome(nome);

                                        System.out.println("Insira o login que deseja");
                                        login = ler.next();
                                        uNovo.setLogin(login);
                                        System.out.println("Insira a password que deseja");
                                        password = ler.next();
                                        uNovo.setPassword(password);

                                        repo.utilizadores.set(indiceUtilizador, uNovo);
                                        utilizador = uNovo;
                                        break;
                                    case 3:
//Listar Veiculos
                                        System.out.println("Listar veiculos: ");
                                        for (Veiculo v: repo.veiculos){
                                            System.out.println(v.toString());
                                        }
                                        break;
                                    case 4:
//Informacao do veiculo



                                        while (true) {
                                            System.out.print("Insira a matrícula da viatura (xx-xx-xx): ");
                                            matricula = ler.nextLine();

                                            if (matricula.matches("[A-Za-z]{2}-[A-Za-z]{2}-[A-Za-z]{2}")) {
                                                // Matrícula é válida
                                                System.out.println("Matrícula válida: " + matricula);
                                                break;
                                            } else {
                                                System.out.println("Matrícula inválida, por favor tente novamente.");
                                            }
                                        }


                                        for (Veiculo v : repo.veiculos){
                                            if(v.getMatricula().equals(matricula))
                                                System.out.println(v.toString());
                                        }
                                        break;
                                    case 5:
//Reservar veiculo
                                        System.out.println("Reservar Viatura: ");

                                        System.out.println("Lista de veiculos: ");
                                        for (Veiculo v: repo.veiculos){
                                            if(v.getEstado().equals("Disponivel"))
                                            System.out.println(v.toString());
                                        }



                                        System.out.println("Insira a matricula");
                                        matricula = ler.next();
//verificar se veiculo esta disponivel
                                        for (Veiculo v: repo.veiculos){
                                            if(v.getMatricula().equals(matricula) && v.getEstado().equals("Disponivel")){

                                                System.out.println("Insira a data");


                                                while (true) {
                                                    System.out.print("Introduza a data da reserva (dd/mm/yyyy): ");
                                                    String input = scanner.nextLine();
                                                    try {
                                                        date = formatter.parse(input);
                                                        break;
                                                    } catch (ParseException e) {
                                                        System.out.println("Data inválida. Por favor, introduza uma data no formato dd/mm/yyyy.");
                                                    }
                                                }
                                                System.out.println("Data da reserva: " + formatter.format(date));


                                                data_reserva = ler.next();
                                                usuarioAtual.reservarVeiculo(matricula, data_reserva);
                                                v.setEstado("Reservado");
                                        }
                                            }



                                        break;

                                    case 6:

// listar os veículos do sistema
                                        ComprarVeiculo compra = new ComprarVeiculo(repo.veiculos, repo.utilizadores);

                                            compra.verificaVeiculos();

                                            compra.lista();

                                            // percorrer a lista de clientes e chamar o método comprar para cada um deles

                                                // criar um objeto da classe ComprarVeiculo


                                                // chamar o método comprar do objeto compra
                                                compra.comprar();


                                            // perguntar ao utilizador se quer continuar a utilizar o sistema ou sair
                                        break;

                                    case 0:
                                        break;
                                    default:
                                        System.out.println("Opcao Invalida!");
                                        break;
                                }
                            } while (opcao2 != 0);
                        }
                        else if(usuarioAtual.getTipo().equals("dono")){
                            do {


                                System.out.println("\033[1mOpção       Descrição                   \033[0m");
                                System.out.println("\033[1m--------    --------------------------\033[0m");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "1", "Registar Viaturas");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "2", "Listar Viaturas");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "3", "Listar reservas por validar ");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "4", "Editar uma viatura");

                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "5", "Editar reservas");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "6", "Listar visitas agendadas ");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "7", "Listar clientes");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "8", "Listar dados de um cliente");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "0", "Logout");


                                System.out.print("Opcao: ");
                                opcao3 = ler.nextInt();
                                switch (opcao3) {
                                    case 1:
//Registar viaturas
                                        System.out.println("Registar Viatura: ");

                                        System.out.println("Insira a marca do veiculo");
                                        marca = ler.next();


                                        while (true) {
                                            matricula = ler.nextLine();

                                            if (matricula.matches("[A-Za-z]{2}-[A-Za-z]{2}-[A-Za-z]{2}")) {
                                                // Matrícula é válida
                                                System.out.println("Matrícula válida: " + matricula);
                                                break;
                                            } else {
                                                System.out.println("Matrícula inválida, por favor tente novamente.");
                                            }
                                        }
                                        System.out.println("Insira o modelo do veiculo");
                                        modelo = ler.next();

                                        System.out.println("Insira o ano do automovel");
                                        ano = ler.nextInt();

                                        System.out.println("Insira o estado do veiculo (Disponivel/ Reservado/ Vendido)");
                                        estado = ler.next();
                                        System.out.println("Insira o preco do veiculo");
                                        preco = ler.nextFloat();

                                        veiculo = new Veiculo(marca, modelo, matricula, preco, estado, ano);
                                        encontrou = false;

                                        for(Veiculo v: repo.veiculos){
                                            if(veiculo.getMatricula().equals(v.getMatricula())){
                                                encontrou = true;
                                            }
                                        }
                                        if(encontrou == true){
                                            System.out.println("Matricula ja existente!\n");
                                        }
                                        else{
                                            repo.veiculos.add(veiculo);
                                        }
                                        break;
                                    case 2:
//Listar Viaturas
                                        System.out.println("Veiculos listados: ");
                                        for (Veiculo v: repo.veiculos){
                                            System.out.println(v.toString());
                                        }
                                        break;
                                    case 3:
//Listar reservas por validar
                                        System.out.println("Reservas listadas: ");
                                        for(Utilizador u: repo.utilizadores){
                                            for(Reserva r: u.getReservas()){
                                                if(r.getEstado().equals("Por validar"))
                                                    System.out.println(u.toString());
                                            }
                                        }
                                        break;
                                    case 4:
//Editar Viatura
                                        System.out.println("Editar veiculo: ");
                                        System.out.println("Insira a matricula");
                                        matricula = ler.next();
                                        for(Veiculo v: repo.veiculos){
                                            if(v.getMatricula().equals(matricula)){
                                                System.out.println("Os dados atuais sao estes: ");
                                                System.out.println(v.toString());
                                                vNovo = new Veiculo();
                                                System.out.println("Insira nova marca");
                                                marca = ler.next();
                                                System.out.println("Insira novo modelo");
                                                modelo = ler.next();
                                                System.out.println("Insira ano");
                                                ano = ler.nextInt();

                                                System.out.println("\n\n");
                                                while (true){
                                                    System.out.println("Insira nova matricula");
                                                    matricula = ler.next();

                                                    if (matricula.matches("[A-Za-z]{2}-[A-Za-z]{2}-[A-Za-z]{2}")) {
                                                        // Matrícula é válida
                                                        System.out.println("Matrícula válida: " + matricula);
                                                        break;
                                                    } else {
                                                        System.out.println("Matrícula inválida, por favor tente novamente.");
                                                    }
                                                }




                                                System.out.println("Insira novo preco");

                                                preco = ler.nextFloat();
                                                System.out.println("Insira novo estado (Disponivel/ Reservado/ Vendido)");
                                                estado = ler.next();
                                                vNovo = new Veiculo(marca, modelo, matricula, preco, estado, ano);
                                                indiceVeiculo = repo.veiculos.indexOf(v);
                                                repo.veiculos.set(indiceVeiculo, vNovo);
                                            }
                                        }
                                        break;
                                    case 5:
//Editar reservas
                                        System.out.println("Insira a matricula");
                                        matricula = ler.next();
                                        for(Utilizador u: repo.utilizadores){
                                            repo.reservas = u.getReservas();
                                            indiceUtilizador = repo.utilizadores.indexOf(u);
                                            for(Reserva r: repo.reservas){
                                                if(r.getMatricula().equals(matricula)){
                                                    indiceReserva = repo.reservas.indexOf(r);
                                                    System.out.println("Insira novo estado (Por validar, Validada, Cancelada)");
                                                    estado = ler.next();
                                                    System.out.println("Insira nova data");
                                                    data_reserva = ler.next();
                                                    r.setEstado(estado);
                                                    r.setData_reserva(data_reserva);
                                                    repo.reservas.set(indiceReserva, r);
                                                }
                                            }
                                            u.setReservas(repo.reservas);
                                            repo.utilizadores.set(indiceUtilizador, u);
                                        }
                                        break;

                                    case 6:
//Listar visitas agendadas

                                        System.out.println("Visitas listadas:\n\n ");
                                        for(Utilizador u: repo.utilizadores){
                                            for(Reserva r: u.getReservas()){
                                                if(r.getEstado().equals("Validada")){
                                                    System.out.println("\nMatricula: " + r.getMatricula());
                                                    System.out.println("\nNome cliente: " + r.getlogin());
                                                    System.out.println("\nData reserva: " + r.getData_reserva());
                                                    System.out.println("\n\n");
                                                }
                                            }
                                        }
                                        break;
                                    case 7:
//Listar clientes
                                        System.out.println("Listar clientes: ");
                                        for(Utilizador u:  repo.utilizadores){
                                            if(u.getTipo().equals("cliente"))
                                                System.out.println(u.toString());
                                        }
                                        break;
                                    case 8:
//Listar dados de um cliente
                                        System.out.println("Dados do cliente: ");
                                        System.out.println("Insira o Nome do cliente");
                                        nome = ler.nextLine();
                                        encontrou = false;
                                        for(Utilizador u : repo.utilizadores){
                                            if(u.getNome() == (nome)){
                                                encontrou = true;
                                                System.out.println(u.toString());
                                            } }
                                        if(encontrou == false){
                                            System.out.println("Não existe nenhum utilizador com esse nome!");
                                        }
                                        break;
                                    case 0:
                                        break;
                                    default:
                                        System.out.println("Opcao Invalida!");
                                        break;
                                }
                            } while (opcao3 != 0);
                        }else if(usuarioAtual.getTipo().equals("admin")){

                            do {
                                System.out.println("\033[1mOpção       Menu Admin                   \033[0m");
                                System.out.println("\033[1m--------    --------------------------\033[0m");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "1", "Visualizar Perfil");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "2", "Listar Clientes");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "3", "Listar Donos ");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "4", "Editar Perfil ");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "5", "Listar Veiculos ");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "6", "Registar um veiculo ");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "7", "Registar um veiculo ");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "8", "Registar Cliente ");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "9", "Registar Admin ");
                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "10", "Registar Dono ");

                                System.out.printf("\033[1m%-10s    %-25s\033[0m\n", "0", "Logout");
                                System.out.println("\n*****************************************");
                                System.out.print("Opcao: ");
                                opcaoA = ler.nextInt();
                                switch (opcaoA) {
                                    case 1:
//Visualizar Perfil
                                        System.out.println("Perfil: ");
                                        System.out.println(usuarioAtual.toString());
                                        break;
                                    case 2:

                                        System.out.println("Listar clientes: ");
                                        for(Utilizador u:  repo.utilizadores){
                                            if(u.getTipo().equals("cliente"))
                                                System.out.println(u.toString());
                                        }

                                        break;
                                    case 3:
                                        System.out.println("Listar Donos: ");
                                        for(Utilizador u:  repo.utilizadores){
                                            if(u.getTipo().equals("dono do stand"))
                                                System.out.println(u.toString());
                                        }
//Listar Veiculos
                                        break;
                                    case 4:
//Informacao do veiculo

                                        System.out.println("Editar perfil Admin: ");

                                        System.out.println("Os dados atuais sao estes: ");
                                        System.out.println(usuarioAtual.toString());
                                        uNovo = usuarioAtual;
                                        System.out.println("Insira o nome que deseja");
                                        nome = ler.next();
                                        uNovo.setNome(nome);

                                        System.out.println("Insira o login que deseja");
                                        login = ler.next();
                                        uNovo.setLogin(login);
                                        System.out.println("Insira a password que deseja");
                                        password = ler.next();
                                        uNovo.setPassword(password);

                                        repo.utilizadores.set(indiceUtilizador, uNovo);
                                        usuarioAtual = uNovo;

                                        break;
                                    case 5:
//Reservar veiculo
                                        System.out.println("Veiculos listados: ");
                                        for (Veiculo v: repo.veiculos){
                                            System.out.println(v.toString());
                                        }






                                        break;
                                    case 6:
//Historico reservas
                                        System.out.println("Registar Viatura: ");

                                        System.out.println("Insira a marca do veiculo");
                                        marca = ler.next();


                                        while (true) {
                                            matricula = ler.nextLine();

                                            if (matricula.matches("[A-Za-z]{2}-[A-Za-z]{2}-[A-Za-z]{2}")) {
                                                // Matrícula é válida
                                                System.out.println("Matrícula válida: " + matricula);
                                                break;
                                            } else {
                                                System.out.println("Matrícula inválida, por favor tente novamente.");
                                            }
                                        }
                                        System.out.println("Insira o modelo do veiculo");
                                        modelo = ler.next();

                                        System.out.println("Insira o ano do veiculo");
                                        ano = ler.nextInt();

                                        System.out.println("Insira o estado do veiculo (Disponivel/ Reservado/ Vendido)");
                                        estado = ler.next();
                                        System.out.println("Insira o preco do veiculo");
                                        preco = ler.nextFloat();

                                        veiculo = new Veiculo(marca, modelo, matricula, preco, estado, ano);
                                        encontrou = false;

                                        for(Veiculo v: repo.veiculos){
                                            if(veiculo.getMatricula().equals(v.getMatricula())){
                                                encontrou = true;
                                            }
                                        }
                                        if(encontrou == true){
                                            System.out.println("Matricula ja existente!\n");
                                        }
                                        else{
                                            repo.veiculos.add(veiculo);
                                        }
                                        break;

                                    case 7:
                                        System.out.println("Insira a nome");
                                        String nomeU = ler.next();
                                        for (Utilizador u : repo.utilizadores) {

                                            if (u.getNome().equals(nomeU))
                                                System.out.println(u.toString());

                                        }
                                        break;

                                    case 8:

                                        System.out.println("Registar Cliente: ");

                                        do {
                                            System.out.println("Nome do utilizador: ");
                                            nome = ler.nextLine();
                                            if (nome.length() < 4) {
                                                System.out.println("O nome de utilizador deve ter pelo menos 6 carateres.");
                                            }
                                        } while (nome.length() < 4);



                                        System.out.println("Login: ");
                                        login = ler.nextLine();
                                        System.out.print("Password: ");
                                        password = ler.nextLine();

                                        System.out.println("Tipo de utilizador: ");
                                        System.out.println("Por favor digite cliente / dono / admin:");
                                        tipo = ler.nextLine();

                                        do {
                                            System.out.println("Insira o seu NIF (9 dígitos):");
                                            nif = ler.nextInt();
                                            if (String.valueOf(nif).length() != 9) {
                                                System.out.println("O NIF deve ter 9 dígitos!");
                                            }
                                        } while (String.valueOf(nif).length() != 9);


                                        System.out.println("Saldo: ");
                                        saldo = ler.nextInt();


                                    utilizador = new Utilizador(nome, login, password, tipo, nif, saldo);
                                        encontrou = false;

                                        for(Utilizador u: repo.utilizadores){
                                            if(utilizador.getLogin().equals(u.getLogin())){
                                                encontrou = true;
                                            }
                                        }
                                        if(encontrou == true){
                                            System.out.println("Cliente ja existente!\n");
                                        }
                                        else{
                                            repo.utilizadores.add(utilizador);
                                        }


                                        break;

                                    case 9:

                                        System.out.println("Registar Admin: ");

                                        do {
                                            System.out.println("Nome do utilizador: ");
                                            nome = ler.nextLine();
                                            if (nome.length() < 4) {
                                                System.out.println("O nome de utilizador deve ter pelo menos 6 carateres.");
                                            }
                                        } while (nome.length() < 4);



                                        System.out.println("Login: ");
                                        login = ler.nextLine();
                                        System.out.print("Password: ");
                                        password = ler.nextLine();

                                        System.out.println("Tipo de utilizador: ");
                                        System.out.println("Por favor digite cliente / dono / admin:");
                                        tipo = ler.nextLine();

                                        do {
                                            System.out.println("Insira o seu NIF (9 dígitos):");
                                            nif = ler.nextInt();
                                            if (String.valueOf(nif).length() != 9) {
                                                System.out.println("O NIF deve ter 9 dígitos!");
                                            }
                                        } while (String.valueOf(nif).length() != 9);


                                        System.out.println("Saldo: ");
                                        saldo = ler.nextInt();


                                        utilizador = new Utilizador(nome, login, password, tipo, nif, saldo);
                                        encontrou = false;

                                        for(Utilizador u: repo.utilizadores){
                                            if(utilizador.getLogin().equals(u.getLogin())){
                                                encontrou = true;
                                            }
                                        }
                                        if(encontrou == true){
                                            System.out.println("Admin ja existente!\n");
                                        }
                                        else{
                                            repo.utilizadores.add(utilizador);
                                        }

                                        break;
                                    case 10:

                                        System.out.println("Registar Dono: ");

                                        do {
                                            System.out.println("Nome do utilizador: ");
                                            nome = ler.nextLine();
                                            if (nome.length() < 4) {
                                                System.out.println("O nome de utilizador deve ter pelo menos 6 carateres.");
                                            }
                                        } while (nome.length() < 4);



                                        System.out.println("Login: ");
                                        login = ler.nextLine();
                                        System.out.print("Password: ");
                                        password = ler.nextLine();

                                        System.out.println("Tipo de utilizador: ");
                                        System.out.println("Por favor digite cliente / dono / admin:");
                                        tipo = ler.nextLine();

                                        do {
                                            System.out.println("Insira o seu NIF (9 dígitos):");
                                            nif = ler.nextInt();
                                            if (String.valueOf(nif).length() != 9) {
                                                System.out.println("O NIF deve ter 9 dígitos!");
                                            }
                                        } while (String.valueOf(nif).length() != 9);


                                        System.out.println("Saldo: ");
                                        saldo = ler.nextInt();


                                        utilizador = new Utilizador(nome, login, password, tipo, nif, saldo);
                                        encontrou = false;

                                        for(Utilizador u: repo.utilizadores){
                                            if(utilizador.getLogin().equals(u.getLogin())){
                                                encontrou = true;
                                            }
                                        }
                                        if(encontrou == true){
                                            System.out.println("Dono ja existente!\n");
                                        }
                                        else{
                                            repo.utilizadores.add(utilizador);
                                        }

                                        break;


                                    case 0:
                                        break;
                                    default:
                                        System.out.println("Opcao Invalida!");
                                        break;
                                }
                            } while (opcaoA != 0);

                    }
                    }
                    break;
                            case 3:
                                System.out.println("sair");
                                break;

                default:
                    System.out.println("Opcao Invalida!");
                    break;
            }
        } while (opcao1 != 0);

    }
}
