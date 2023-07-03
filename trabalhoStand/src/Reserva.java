public class Reserva {

    private String login;
    private String matricula;
    private String estado; //Por validar, validada, cancelada
    private String data_reserva;

    public Reserva(String login , String matricula, String estado, String data_reserva){

        this.login=login;
        this.matricula=matricula;
        this.estado=estado;
        this.data_reserva=data_reserva;
    }
    public void setlogin(String  login){
        this.login = login;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    public void setData_reserva(String data_reserva){
        this.data_reserva = data_reserva;
    }
    public String getlogin(){
        return this.login;
    }

    public String getMatricula(){
        return this.matricula;
    }
    public String getEstado(){
        return this.estado;
    }
    public String getData_reserva(){
        return this.data_reserva;
    }


}
