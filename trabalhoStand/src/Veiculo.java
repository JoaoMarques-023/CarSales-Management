import java.io.Serializable;

public class Veiculo  implements Serializable {


    private String matricula;
    private String marca;
    private String modelo;
    private float preco;
    private String estado;
    private int ano;


    public Veiculo(String marca, String modelo, String matricula, float preco, String estado, int ano){
        this.matricula=matricula;
        this.marca=marca;
        this.modelo=modelo;
        this.preco=preco;
        this.estado=estado;
        this.ano=ano;
    }
    public Veiculo(){
        this.matricula="";
        this.marca="";
        this.modelo="";
        this.preco=0;
        this.estado="";
        this.ano=0;
    }

    public int getAno() {
        return ano;
    }



    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public void setPreco(float preco){
        this.preco=preco;

    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    public String getMarca(){
        return this.marca;
    }
    public String getMatricula(){
        return this.matricula;
    }
    public String getModelo(){
        return this.modelo;
    }
    public float getPreco(){
        return this.preco;
    }
    public String getEstado(){
        return this.estado;
    }







    @Override
    public String toString(){
        String s = "\nUtilizador: ";
        s += "\n\tMarca: " +marca;
        s += "\n\tModelo: " +modelo;
        s += "\n\tMatricula: " +matricula;
        s += "\n\tAno: " +ano;

        s += "\n\tEstado: " +estado;
        return s;
    }



}
