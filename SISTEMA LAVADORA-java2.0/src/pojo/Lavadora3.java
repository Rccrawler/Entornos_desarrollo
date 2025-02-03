package pojo;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Lavadora3 {

    private String Plan_de_lavado;
    private double Capacidad;
    private Integer Capacidad_max = 8;//kilos de masimos a llenar
    private double Llena;
    private int Temperatura;
    private String Puerta_estado = "cerrado";
    private double Agua_disponible = 1; //seria un sesor el que conprobara si se dispone de agua
    private float Contador_tiempo_lavado;
    private String Estado_lavado = "nome";
    private String Pantalla = "nome";
    private int RPM;
    private int Detergente = 40;//mililitros deterjente que hay en el cajetin
    private final int Detergente_max = 170;
    private String Modelo = "Fagor clasic";
    private String Estado_cajetin = "cerrado";

    private ArrayList<String> listaPrendas = new ArrayList<>(); //guardaremos la ropa que contien la lavadora

    public void Añadir_Prenda(String prenda){//hañadir que cada bez que se hañada una prenda tanvien el peso
        if(Puerta_estado.equals("abierto")){
            this.listaPrendas.add(prenda);
        }else {
            System.out.println("no se puede meter la ropa porque la puerta esta cerada");
        }
    }

    public void Quitar_prenda(String prenda){
        if(Puerta_estado.equals("abierto")) {
            this.listaPrendas.remove(prenda);
        }else {
            System.out.println("no se puede quitar la ropa porque la puerta esta cerada");
        }
    }

    public void ResetearListaPrendas() {
        if(Puerta_estado.equals("abierto")) {
            this.listaPrendas.clear(); // Limpia el ArrayList
            System.out.println("Se ha baciado la lavadora");
        }else {
            System.out.println("no se puede quitar la ropa porque la puerta esta cerada");
        }
    }

    public void MostrarPrendas() {
        if (listaPrendas.isEmpty()) {
            System.out.println("No hay prendas en la lavadora.");
        } else {
            System.out.println("Prendas en la lavadora:");
            for (String prenda : listaPrendas) {
                System.out.println(prenda);
            }
        }
    }

    public void Lavadora(Integer Capacidad, String Plan_de_lavado, int Temperatura){
        System.out.println("");
        System.out.println("T1000");
        Pantalla = "Parametros";
        System.out.println("Registrando configuracion: "+"Capacidad: "+ Capacidad +"Plan_de_lavado: "+ Plan_de_lavado +"Temperatura: "+ Temperatura);
        this.Capacidad = Capacidad;
        this.Plan_de_lavado = Plan_de_lavado;
        this.Temperatura = Temperatura;

        // Verificar y asignar valores por defecto si son inválidos
        if (Capacidad == null || Capacidad <= 0) {
            this.Capacidad = Capacidad_max; // Valor por defecto
            System.out.println("Capacidad no especificada o inválida. Asignando valor por defecto: 7 Kg.");
        } else {
            this.Capacidad = Capacidad;
        }

        if (Plan_de_lavado == null || Plan_de_lavado.isEmpty()) {
            this.Plan_de_lavado = "corto"; // Valor por defecto
            System.out.println("Plan de lavado no especificado. Asignando valor por defecto: corto.");
        } else {
            this.Plan_de_lavado = Plan_de_lavado;
        }

        if (Temperatura <= 0 || Temperatura > 90) {
            this.Temperatura = 40; // Valor por defecto
            System.out.println("Temperatura no especificada o inválida. Asignando valor por defecto: 40°C.");
        } else {
            this.Temperatura = Temperatura;
        }

        System.out.println("Registrando configuración: " +
                "Capacidad: " + this.Capacidad + " Kg, " +
                "Plan de lavado: " + this.Plan_de_lavado + ", " +
                "Temperatura: " + this.Temperatura + "°C.");
    }

    public void Abrir_lavadora(){
        if (!Estado_lavado.equals("lavando") && !Estado_lavado.equals("centrifugando")) {
            Pantalla = "Puerta abierta";
            System.out.println("Puerta abierta");
            this.Puerta_estado = "abierto";
        }else{
            Pantalla = "Error se esta lavando esperese ha que hacabe";
            System.out.println("Error se esta lavando esperese ha que hacabe");
        }
    }

    public void Llenar_lavadora(double ropa_Kg){
        if(Puerta_estado.equals("abierto")){
            this.Capacidad = Capacidad + ropa_Kg;
            System.out.println("Llenando lavadora con: "+ ropa_Kg+ " Kgs");
        }else {
            System.out.print("La puerta esta cerrada");
        }
    }

    public void Baciar_lavadora(double _ropa_Kg){
        if(Puerta_estado.equals("abierto")){
            this.Capacidad = Capacidad-_ropa_Kg;
            System.out.println("vaciando lavadora: -"+ _ropa_Kg+ " Kgs");
        }else {
            System.out.print("La puerta esta cerrada");
        }
    }


    public void Cerrar_lavadora(){
        Pantalla = "Puerta cerrada";
        System.out.println("Puerta cerrada");
        this.Puerta_estado = "cerrado";
    }

    public void Abrir_cajetin(){
        if(Estado_cajetin.equals("cerrado")){
            this.Estado_cajetin = "abierto";
            System.out.println("Cajetin abierto");
        }else {
            System.out.println("El cajetin lla esta abierto");
        }
    }

    public void Introducir_Deterjente(Integer cantidad){
        if(Estado_cajetin.equals("abierto")){
            if (cantidad <= Detergente_max){
                this.Detergente = Detergente+cantidad;
                System.out.println("Detergente introducido: "+ cantidad + " ml");
            }else{
                System.out.println("Error: No se puede introducir más de " + Detergente_max + " ml de detergente.");
            }
        }else {
            System.out.println("El cajetin no esta avierto no se puede introducir deterjente");
        }
    }

    public void Cerrar_cajetin(){
        if(Estado_cajetin.equals("abierto")){
            this.Estado_cajetin = "cerrado";
            System.out.println("Cajetin Cerrado");
        }else {
            System.out.println("El cajetin lla esta cerrado");
        }
    }

    public ArrayList<String> getListaPrendas(){
        return this.listaPrendas;
    }


    public void Iniciar_lavadora(){
        if (this.Plan_de_lavado == null) {
            this.Plan_de_lavado = "corto"; // asigna un valor por defecto
            System.out.println("Como no se encontro el plan de labado se predefinio en corto");
        }
        if(Agua_disponible == 1){
            if(!Estado_lavado.equals("lavando") && !Estado_lavado.equals("centrifugando")){
                if(Estado_cajetin.equals("cerrado")){
                    if(Detergente >= 5){
                        if(Capacidad <= Capacidad_max){
                            if(Puerta_estado.equals("cerrado")){
                                System.out.println("      ___________");
                                System.out.println("     |           |");
                                System.out.println("     |  LAVANDO  |");
                                System.out.println("     |  ~ ~ ~ ~  |");
                                System.out.println("     | ~ ~ ~ ~ ~ |");
                                System.out.println("     |  ~ ~ ~ ~  |");
                                System.out.println("     |___________|");
                                Iniciar_lavadora_lavado();
                            }else{
                                System.out.println("La puerta esta avierta");
                                Pantalla = "La puerta esta avierta";
                            }
                        }else{
                            System.out.println("Se supera la capacidad maxima: "+ Capacidad_max);
                            Pantalla = "Se supera la capacidad maxima: "+ Capacidad_max;
                        }
                    }else{
                        System.out.println("No queda detergente");
                        Pantalla = "No queda detergente";
                    }
                }else {
                    System.out.println("El cajetin de el deterjente esta abierto");
                    Pantalla = "El cajetin de el deterjente esta abierto";
                }
            }else{
                System.out.println("Sesta labando por haora");
                Pantalla = "Sesta labando por haora";
            }
        }else{
            System.out.println("No hay agua error");
            Pantalla = "No hay agua error";
        }
    }

    private void Iniciar_lavadora_lavado() {
        if (Plan_de_lavado.equals("corto")) {
            System.out.println("Iniciando lavado corto...");
            Estado_lavado = "lavando";
            Pantalla = "Lavando - Programa corto";
            try {
                sleep(5000); // Simula 5 segundos de lavado
            } catch (InterruptedException e) {
                System.out.println("Error en el programa de lavado corto.");
            }
            RPM = 800;
            this.Detergente = Detergente -5;
            System.out.println("Centrifugando a " + RPM + " RPM...");
            Estado_lavado = "centrifugando";
            try {
                sleep(2000); // Simula 2 segundos de centrifugado
            } catch (InterruptedException e) {
                System.out.println("Error en el centrifugado del programa corto.");
            }
            Terminar_lavadora();
        } else if (Plan_de_lavado.equals("largo")) {
            System.out.println("Iniciando lavado largo...");
            Estado_lavado = "lavando";
            Pantalla = "Lavando - Programa largo";
            try {
                sleep(10000); // Simula 10 segundos de lavado
            } catch (InterruptedException e) {
                System.out.println("Error en el programa de lavado largo.");
            }
            RPM = 1200;
            this.Detergente = Detergente -5;
            System.out.println("Centrifugando a " + RPM + " RPM...");
            Estado_lavado = "centrifugando";
            try {
                sleep(5000); // Simula 5 segundos de centrifugado
            } catch (InterruptedException e) {
                System.out.println("Error en el centrifugado del programa largo.");
            }
            Terminar_lavadora();
        } else {
            System.out.println("Ese programa no existe, error.");
            Pantalla = "Ese programa no existe, error.";
        }
    }

    public void Terminar_lavadora() {
        RPM = 0;
        System.out.println("Lavado terminado.");
        Estado_lavado = "terminado";
        Pantalla = "Lavado finalizado.";
        Puerta_estado = "cerrado"; // La puerta sigue cerrada tras finalizar el programa
    }

    public void Detener_lavadora(){
        if(Estado_lavado.equals("lavando") || Estado_lavado.equals("centrifugando")){
            RPM = 0;
            System.out.println("Lavado abortado");
            Estado_lavado = "terminado";
            Pantalla = "Lavado abortado";
            Puerta_estado = "cerrado"; // La puerta sigue cerrada tras finalizar el programa
        }
    }

    public void VerEstado(){
        if(!Estado_lavado.equals("null")){
            System.out.println("Modelo "+ Modelo);
            System.out.println("Estado "+ Estado_lavado);
            System.out.println("Plan de lavado "+ Plan_de_lavado);
            System.out.println("Capacidad "+ Capacidad);
            System.out.println("Capacidad maxima "+ Capacidad_max);
            System.out.println("Capacidad maxima "+ Llena);
            System.out.println("Temperatura "+ Temperatura);
            System.out.println("Puerta estado "+ Puerta_estado);
            System.out.println("Agua_disponible = 1; //seria un sesor el que conprobara si se dispone de agua "+ Agua_disponible);
            if(Contador_tiempo_lavado == 0.0f){
                System.out.println("Contador tienpo lavado: 0:00");
            }else {
                System.out.println("Contador tienpo lavado: "+ Contador_tiempo_lavado);
            }
            System.out.println("Estado lavado "+ Estado_lavado);
            System.out.println("Estado cajetin: "+ Estado_cajetin);
            System.out.println("Detergente: "+ Detergente);
            System.out.println("Detergente_max: "+ Detergente_max);
            for (String prenda : listaPrendas) {
                System.out.println(prenda);
            }
            System.out.println(Pantalla);
        }
    }

    public void ComprobaciondeErores() throws InterruptedException {
        System.out.print("Revison harware");
        sleep(2000);
    }

}
