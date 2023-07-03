import java.io.Serializable;
import java.util.ArrayList;

public class Admin extends Utilizador{


    public Admin(String nome, String login, String password, String tipo, int nif, double saldo) {
        super(nome, login, password, tipo, nif, saldo);
    }
}
