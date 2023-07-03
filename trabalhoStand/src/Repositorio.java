import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class    Repositorio  implements Serializable {

    private static Repositorio repo = null;



    public ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();
    public ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    public  ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    public ArrayList<Admin> admins = new ArrayList<Admin>();
    public ArrayList<Venda> vendas = new ArrayList<Venda>();




    public Repositorio (){};


    public ArrayList<Utilizador> getUtilizadores() {
        return utilizadores;
    }
    public ArrayList<Veiculo> getVeiculos(){ return veiculos;}
    public ArrayList<Reserva> getReservas(){return reservas;}
    public ArrayList<Admin> getAdmins() {
        return admins;
    }
    public ArrayList<Venda> getVendas() {
        return vendas;
    }




    public static Repositorio getRepositorio(){


        if (repo == null)
            repo = new Repositorio();


        return repo;
    }


}
