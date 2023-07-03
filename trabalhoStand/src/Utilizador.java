import java.io.Serializable;
import java.util.ArrayList;

public class Utilizador  implements Serializable {

    private String nome;
    private String apelido;
    private String login;
    private String password;
    private String tipo;
    private int nif;
    private double saldo;
    private ArrayList<Reserva> reservas;


    public Utilizador(String nome,  String login, String password, String tipo, int nif, double saldo){
        this.nome=nome;
        this.nif=nif;
        this.login=login;
        this.password=password;
        this.tipo=tipo;
        this.saldo=saldo;
        this.reservas = new ArrayList<Reserva>();
    }
    public Utilizador(){
        this.nome="";
        this.apelido="";
        this.nif=0;
        this.login="";
        this.password="";
        this.tipo="";
        this.saldo= 0.0;

        this.reservas = new ArrayList<Reserva>();
    }

    public void reservarVeiculo(String matricula, String data_reserva){
        Reserva reserva;

        reserva = new Reserva(this.login , matricula, "Por validar", data_reserva);
        reservas.add(reserva);
    }

    public void setNome(String nome){

        this.nome = nome;
    }

    public void setNif(int nif){

        this.nif = nif;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getNome(){
        return this.nome;
    }
    public int getNif(){
        return this.nif;
    }
    public String getLogin(){
        return this.login;
    }
    public String getPassword(){
        return this.password;
    }
    public String getTipo(){
        return this.tipo;
    }


    public void deposito(double quantidade){
        saldo = saldo + quantidade;

    }

    public void retirar(double quantidade){

        if(quantidade<=saldo){
            saldo = saldo - quantidade;
        }
        else{
            System.out.println("insuficiente fundos");
        }

    }





    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Reserva> getReservas(){
        return this.reservas;
    }
    public String listReservas(){
        int i;
        String s= "reservas: \n";
        for(i=0; i<reservas.size(); i++){
            s+= "\n\tMatricula: " +reservas.get(i).getMatricula();
            s+= "\n\tData: " +reservas.get(i).getData_reserva();
            s+= "\n\tMatricula: " +reservas.get(i).getEstado();
            s+= "\n\n\n";
        }
        return null;
    }







    @Override
    public String toString(){
        String s = "\n\nUtilizador: ";
        s += "\n\tNome: " +nome;
        s += "\n\tApelido: " +apelido;
        s += "\n\tlogin: " +login;
        s += "\n\tpassword: " +password;
        s += "\n\ttipo: " +tipo;
        s += "\n\tsaldo: " +saldo;



        s += "\n\tReservas: ";
        for(Reserva r: reservas){
            s += "\t\tMatricula: " + r.getMatricula();
            s += "\t\tData reserva: " + r.getData_reserva();
            s += "\t\tEstado da reserva: " + r.getEstado();
            s += "\n\n";
        }
        return s;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
    }




}
