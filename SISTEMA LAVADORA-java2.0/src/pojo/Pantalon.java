package pojo;

public class Pantalon {

    private String Tipo = "Pantalon";
    private String Color = "azul";
    private final double Peso = 0.55; //peso en kgs
    private int Nivel_Suciedad = 2;
    private String lavadora_esta;

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

}
