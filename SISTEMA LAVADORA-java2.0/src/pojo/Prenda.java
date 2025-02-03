package pojo;

public class Prenda {
    private String Tipo;
    private String Color;
    private double Peso; //peso en kgs
    private int Nivel_Suciedad;

    private String lavadora_esta;// procurar quitar baraible

    public void Prenda_Atributos(String tipo, String color, double peso, int nivel_suciedad){
        this.Tipo = tipo;
        this.Color = color;
        this.Peso = peso;
        this.Nivel_Suciedad = nivel_suciedad;
    }

    public void Depositar_en_la_labaora(String lavadora){
        if (lavadora.equals("Lavadora1")) {
            this.lavadora_esta = lavadora;
            Lavadora1 lavadora1 = new Lavadora1();
            lavadora1.Llenar_lavadora(Peso);
        } else if (lavadora.equals("Lavadora2")) {
            this.lavadora_esta = lavadora;
            Lavadora2 lavadora2 = new Lavadora2();
            lavadora2.Llenar_lavadora(Peso);
        } else if (lavadora.equals("Lavadora3")) {
            this.lavadora_esta = lavadora;
            Lavadora3 lavadora3 = new Lavadora3();
            lavadora3.Llenar_lavadora(Peso);
        }else {
            System.out.println("Esa labadora no existe");
        }
    }
    public void Sacar_de_la_labadora(){
        if(lavadora_esta.equals("Lavadora1")){
            this.lavadora_esta = "null";
            Lavadora1 lavadora1 = new Lavadora1();
            lavadora1.Baciar_lavadora(Peso);
        } else if (lavadora_esta.equals("Lavadora2")) {
            this.lavadora_esta = "null";
            Lavadora2 lavadora2 = new Lavadora2();
            lavadora2.Baciar_lavadora(Peso);
        } else if (lavadora_esta.equals("Lavadora3")) {
            this.lavadora_esta = "null";
            Lavadora3 lavadora3 = new Lavadora3();
            lavadora3.Baciar_lavadora(Peso);
        }else{
            System.out.println("Los calcetines no estan en la lavadora");
        }
    }

    public void setNivel_Suciedad(int nuevoNivel) {
        if(nuevoNivel >= 1 && nuevoNivel <= 10) {
            this.Nivel_Suciedad = nuevoNivel;
        } else {
            System.out.println("Nivel de suciedad inválido. Debe estar entre 1 y 10.");
        }
    }


    @Override
    public String toString() {
        return "Prenda{" +
                "Tipo='" + Tipo + '\'' +
                ", Color='" + Color + '\'' +
                ", Peso=" + Peso +
                ", Nivel_Suciedad=" + Nivel_Suciedad +
                '}';

    }

}
