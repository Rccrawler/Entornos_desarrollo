import pojo.*;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {// las prendas se deben poder utilizar en todas las labadoras haunque se añada a una en concreto

    //static boolean infinito = true;
    private static final Scanner scanner = new Scanner(System.in);
    static String Lavadora_elegida ="No selecioada";
    static Lavadora1 lavadora1 = new Lavadora1();
    static Lavadora2 lavadora2 = new Lavadora2();
    static Lavadora3 lavadora3 = new Lavadora3();

    private static final HashMap<String, Prenda> prendas = new HashMap<>(); // Mapa de prendas dinámicas

    public static void Menu_Elegir_lavadora() {
        String opcion;

        do {
            System.out.println("   ");
            System.out.println("= Lavadora: " + Lavadora_elegida + " =");
            System.out.println("=== Menú Principal ===");
            System.out.println("<     1. Lavadora1   >");
            System.out.println("<     2. Lavadora2   >");
            System.out.println("<     3. Lavadora3   >");
            System.out.println("<     4. Salir       >");
            System.out.println("<     5. Apagar      >");
            System.out.println("======================");
            System.out.print("Elige una opción: ");
            opcion = scanner.next();

            switch (opcion) {
                case "1":
                    System.out.println("Has seleccionado la Lavadora1.");
                    Lavadora_elegida = "Lavadora1";
                    Menu_Elegir_Accion();
                    break;
                case "2":
                    System.out.println("Has seleccionado la Lavadora2.");
                    Lavadora_elegida = "Lavadora2";
                    Menu_Elegir_Accion();
                    break;
                case "3":
                    System.out.println("Has seleccionado la Lavadora3.");
                    Lavadora_elegida = "Lavadora3";
                    Menu_Elegir_Accion();
                    break;
                case "4":
                    System.out.println("Saliendo del programa...");
                    break;
                case "5":
                    System.out.println("Apagado");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (true);//opcion != 4 && opcion != 3 && opcion != 2 && opcion != 1
    }

    public static void Menu_Elegir_Accion() {
        String opcion;

        do {
            System.out.println("   ");
            System.out.println("= Lavadora: "+ Lavadora_elegida +" =");//hacer que se pueda ber la ropa que tiene la labadora
            System.out.println("===     Menú Principal    ===");
            System.out.println("< 1.  Abrir Lavadora        >");
            System.out.println("< p.  Elegir plan de lavado >");
            System.out.println("< 2.  Llenar Lavadora       >");
            System.out.println("< 3.  Baciar_lavadora       >");
            System.out.println("< 4.  Cerrar_lvadora        >");
            System.out.println("< 5.  Iniciar_lavadora      >");       //hañadir funcionamiento cajetin de jabon
            System.out.println("< 6.  Detener_lavadora      >");
            System.out.println("< e.  Ropa(Canviar)         >");
            System.out.println("< 7.  VerEstado             >");//tanvien te dice las prendas de el interiror
            System.out.println("< 8.  Abrir cajetin         >");
            System.out.println("< 9.  Introducir deterjente >");
            System.out.println("< 10. Cerrar cajetin        >");
            System.out.println("< 11.  Atras                >");
            System.out.println("< 12.  Apagar               >");
            System.out.println("=============================");
            System.out.print("Elige una opción: ");
            opcion = scanner.next();

            switch (opcion) {
                case "1":
                    System.out.println("Has seleccionado Abrir lavadora.");
                    if (Lavadora_elegida.equals("Lavadora1")){
                        System.out.print(Lavadora_elegida+": ");
                        lavadora1.Abrir_lavadora();
                    } else if (Lavadora_elegida.equals("Lavadora2")){
                        System.out.print(Lavadora_elegida+": ");
                        lavadora2.Abrir_lavadora();
                    } else if (Lavadora_elegida.equals("Lavadora3")) {
                        System.out.print(Lavadora_elegida+": ");
                        lavadora3.Abrir_lavadora();
                    }
                    break;
                case "p":
                    //lavadora1.Lavadora(10, "corto", 35); antes se ponia ha si

                    System.out.println("Has seleccionado Plan de lavado");
                    System.out.println("Elige Capacidad:");
                    Integer Capacidad = scanner.nextInt();
                    System.out.println("Elegir Plan de lavado:");
                    String Plan_de_lavado = scanner.next();
                    System.out.print("Elegir temperatura:");
                    int Temperatura = scanner.nextInt();

                    if (Lavadora_elegida.equals("Lavadora1")){
                        System.out.print(Lavadora_elegida+": ");
                        lavadora1.Lavadora(Capacidad, Plan_de_lavado, Temperatura);
                    } else if (Lavadora_elegida.equals("Lavadora2")){
                        System.out.print(Lavadora_elegida+": ");
                        lavadora2.Lavadora(Capacidad, Plan_de_lavado, Temperatura);
                    } else if (Lavadora_elegida.equals("Lavadora3")) {
                        System.out.print(Lavadora_elegida+": ");
                        lavadora3.Lavadora(Capacidad, Plan_de_lavado, Temperatura);
                    }
                    break;
                case "2":
                    System.out.print(Lavadora_elegida+": ");
                    System.out.println("   ");
                    System.out.println("Has seleccionado Llenar Lavadora.");
                    System.out.println("===   Menú Principal  ===");
                    AtomicInteger aus = new AtomicInteger();
                    int contador = 1; // Inicializamos el contador en 1
                    for (Map.Entry<String, Prenda> entry : prendas.entrySet()) {
                        System.out.println(contador + ". " + entry.getKey() + " -> " + entry.getValue());
                        contador++; // Incrementamos el contador después de cada iteración
                    }
                    System.out.println("=========================");
                    System.out.println("Seleciona el numero de la ropa a introducir");
                    Integer Respuesta = scanner.nextInt();

                    int contador2 = 1;
                    String nombreSeleccionado = null;
                    // Buscar el nombre según el número seleccionado
                    for (Map.Entry<String, Prenda> entry : prendas.entrySet()) {
                        if (contador2 == Respuesta) { // Si el contador coincide con la respuesta
                            nombreSeleccionado = entry.getKey(); // Guardar el nombre en la variable
                            break; // Salir del bucle porque ya encontramos el elemento
                        }
                        contador2++; // Incrementar el contador
                    }

                    if (nombreSeleccionado != null) {
                        System.out.println("Has seleccionado: " + nombreSeleccionado);
                    } else {
                        System.out.println("Número inválido. Inténtalo de nuevo.");
                        break;
                    }

                    //hañade las prendas
                    switch (Lavadora_elegida) {
                        case "Lavadora1":
                            lavadora1.Añadir_Prenda(nombreSeleccionado);
                            break;
                        case "Lavadora2":
                            lavadora2.Añadir_Prenda(nombreSeleccionado);
                            break;
                        case "Lavadora3":
                            lavadora3.Añadir_Prenda(nombreSeleccionado);
                            break;
                        default:
                            System.out.println("Opción no válida, intenta de nuevo.");
                    }

                    break;
                case "3":// bacia todo lo que tenga
                    System.out.print(Lavadora_elegida+": ");
                    System.out.println("Has seleccionado Baciar lavadora");
                    switch (Lavadora_elegida) {
                        case "Lavadora1":
                            lavadora1.MostrarPrendas();
                            lavadora1.ResetearListaPrendas();
                            break;
                        case "Lavadora2":
                            lavadora2.MostrarPrendas();
                            lavadora2.ResetearListaPrendas();
                            break;
                        case "Lavadora3":
                            lavadora3.MostrarPrendas();
                            lavadora3.ResetearListaPrendas();
                            break;
                        default:
                            System.out.println("Opción no válida, intenta de nuevo.");
                    }
                    break;
                case "4":
                    System.out.println("Has seleccionado Cerrar Lavadora");
                    if (Lavadora_elegida.equals("Lavadora1")){
                        System.out.print(Lavadora_elegida+": ");
                        lavadora1.Cerrar_lavadora();
                    } else if (Lavadora_elegida.equals("Lavadora2")){
                        System.out.print(Lavadora_elegida+": ");
                        lavadora2.Cerrar_lavadora();
                    } else if (Lavadora_elegida.equals("Lavadora3")) {
                        System.out.print(Lavadora_elegida+": ");
                        lavadora3.Cerrar_lavadora();
                    }
                    break;
                case "5":
                    System.out.println("Has seleccionado Iniciar lavadora");
                    if (Lavadora_elegida.equals("Lavadora1")){
                        System.out.print(Lavadora_elegida + ": ");
                        lavadora1.Iniciar_lavadora();
                        for(String nombrePrenda : lavadora1.getListaPrendas()){
                            prendas.get(nombrePrenda).setNivel_Suciedad(0);
                        }
                    } else if (Lavadora_elegida.equals("Lavadora2")){
                        System.out.print(Lavadora_elegida + ": ");
                        lavadora2.Iniciar_lavadora();
                        for(String nombrePrenda : lavadora2.getListaPrendas()){
                            prendas.get(nombrePrenda).setNivel_Suciedad(0);
                        }
                    } else if (Lavadora_elegida.equals("Lavadora3")){
                        System.out.print(Lavadora_elegida + ": ");
                        lavadora3.Iniciar_lavadora();
                        for(String nombrePrenda : lavadora3.getListaPrendas()){
                            prendas.get(nombrePrenda).setNivel_Suciedad(0);
                        }
                    }
                    break;

                case "6":
                    System.out.println("Has seleccionado Detener_lavadora");
                    if (Lavadora_elegida.equals("Lavadora1")){
                        System.out.print(Lavadora_elegida+": ");
                        lavadora1.Detener_lavadora();
                    } else if (Lavadora_elegida.equals("Lavadora2")){
                        System.out.print(Lavadora_elegida+": ");
                        lavadora2.Detener_lavadora();
                    } else if (Lavadora_elegida.equals("Lavadora3")) {
                        System.out.print(Lavadora_elegida+": ");
                        lavadora3.Detener_lavadora();
                    }
                    break;
                case "e":
                    System.out.println("Has seleccionado Editar_ropa");
                    ConfiguracionRopa();
                    break;
                case "7":
                    System.out.println("Has seleciona VerEstado");
                    if (Lavadora_elegida.equals("Lavadora1")){
                        System.out.print(Lavadora_elegida+": ");
                        lavadora1.VerEstado();
                    } else if (Lavadora_elegida.equals("Lavadora2")){
                        System.out.print(Lavadora_elegida+": ");
                        lavadora2.VerEstado();
                    } else if (Lavadora_elegida.equals("Lavadora3")) {
                        System.out.print(Lavadora_elegida+": ");
                        lavadora3.VerEstado();
                    }
                    break;
                case "8":
                    System.out.println("Has selecionado Abrir cajetin");
                    if (Lavadora_elegida.equals("Lavadora1")){
                        System.out.print(Lavadora_elegida+": ");
                        lavadora1.Abrir_cajetin();
                    } else if (Lavadora_elegida.equals("Lavadora2")){
                        System.out.print(Lavadora_elegida+": ");
                        lavadora2.Abrir_cajetin();
                    } else if (Lavadora_elegida.equals("Lavadora3")) {
                        System.out.print(Lavadora_elegida+": ");
                        lavadora3.Abrir_cajetin();
                    }
                    break;
                case "9":
                    System.out.println("Has selecionado Introducir deterjente");
                    if (Lavadora_elegida.equals("Lavadora1")){
                        System.out.print(Lavadora_elegida+": ");
                        System.out.println("Introduce la cantidad:");
                        Integer cantidad = scanner.nextInt();
                        lavadora1.Introducir_Deterjente(cantidad);
                        cantidad = 0;
                    } else if (Lavadora_elegida.equals("Lavadora2")){
                        System.out.print(Lavadora_elegida+": ");
                        System.out.println("Introduce la cantidad:");
                        Integer cantidad = scanner.nextInt();
                        lavadora2.Introducir_Deterjente(cantidad);
                        cantidad = 0;
                    } else if (Lavadora_elegida.equals("Lavadora3")) {
                        System.out.print(Lavadora_elegida+": ");
                        System.out.println("Introduce la cantidad:");
                        Integer cantidad = scanner.nextInt();
                        lavadora3.Introducir_Deterjente(cantidad);
                        cantidad = 0;
                    }
                    break;
                case "10":
                    System.out.println("Has selecionado Cerrar cajetin");
                    if (Lavadora_elegida.equals("Lavadora1")){
                        System.out.print(Lavadora_elegida+": ");
                        lavadora1.Cerrar_cajetin();
                    } else if (Lavadora_elegida.equals("Lavadora2")){
                        System.out.print(Lavadora_elegida+": ");
                        lavadora2.Cerrar_cajetin();
                    } else if (Lavadora_elegida.equals("Lavadora3")) {
                        System.out.print(Lavadora_elegida+": ");
                        lavadora3.Cerrar_cajetin();
                    }
                    break;
                case "11":
                    Menu_Elegir_lavadora();
                    break;
                case "12":
                    System.out.println("Apagado");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (true);//opcion != 4 && opcion != 3 && opcion != 2 && opcion != 1

    }



    public static void ConfiguracionRopa() {    //falta modificar la suciedad de las prendas
        String opcion;
        do {
            System.out.println("   ");
            System.out.println("===    Menú Principal   ===");
            System.out.println("< 1. Añadir prenda        >");
            System.out.println("< 2. Ver prendas          >");
            System.out.println("< 3. Modificar suciedad   >");
            System.out.println("< 4. Atras                >");
            System.out.println("< 5. Salir                >");
            System.out.print("Elige una opción: ");
            opcion = scanner.next();

            switch (opcion) {
                case "1":
                    System.out.println("Has seleccionado Añadir prenda.");
                    anadirPrenda();
                    break;
                case "2":
                    System.out.println("Lista de prendas en la lavadora:");
                    prendas.forEach((nombre, prenda) -> {
                        System.out.println(nombre + " -> " + prenda);
                    });
                    break;
                case "3":
                    System.out.print("Ingresa el nombre de la prenda: ");
                    String nombre = scanner.next();
                    if (prendas.containsKey(nombre)) {
                        System.out.print("Ingresa el nuevo nivel de suciedad (1-10): ");
                        int nuevoNivel = scanner.nextInt();
                        prendas.get(nombre).setNivel_Suciedad(nuevoNivel); // Llama al método correcto
                        System.out.println("Nivel de suciedad actualizado.");
                    } else {
                        System.out.println("Prenda no encontrada.");
                    }
                    break;


                case "4":
                    System.out.println("Volviendo al menú principal...");
                    return; // Salir del método
                case "5":
                    System.out.println("Saliendo...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (true);
    }

    private static void anadirPrenda() {
        System.out.print("Ingresa el nombre de la prenda: ");
        String nombrePrenda = scanner.next();

        System.out.print("Tipo de prenda (ej: Camisa, Pantalón): ");
        String tipo = scanner.next();

        System.out.print("Color de la prenda: ");
        String color = scanner.next();

        System.out.print("Peso (en kg): ");
        double peso = scanner.nextDouble();

        System.out.print("Nivel de suciedad (1-10): ");
        int nivelSuciedad = scanner.nextInt();

        // Crear una nueva instancia de la prenda
        Prenda nuevaPrenda = new Prenda();
        nuevaPrenda.Prenda_Atributos(tipo, color, peso, nivelSuciedad);

        // Agregar al mapa de prendas
        prendas.put(nombrePrenda, nuevaPrenda);
        System.out.println("Prenda añadida exitosamente: " + nombrePrenda);
    }


    public static void main(String[] args) throws InterruptedException {


        Prenda Calcetines = new Prenda();
        Calcetines.Prenda_Atributos("Calcetin", "Rojo", 0.3, 5);
        prendas.put("Calcetines", Calcetines);         // Nombre prenda

        Prenda Camisa = new Prenda();
        Camisa.Prenda_Atributos("Camisa", "Blanca", 0.5, 2);
        prendas.put("Camisa", Camisa);

        Prenda Pantalon = new Prenda();
        Pantalon.Prenda_Atributos("Pantalón", "Azul", 1.2, 4);
        prendas.put("Pantalon", Pantalon);

        Prenda Sudadera = new Prenda();
        Sudadera.Prenda_Atributos("Sudadera", "Negra", 1.0, 3);
        prendas.put("Sudadera", Sudadera);

        Prenda Bufanda = new Prenda();
        Bufanda.Prenda_Atributos("Bufanda", "Gris", 0.4, 1);
        prendas.put("Bufanda", Bufanda);

        Prenda Gorro = new Prenda();
        Gorro.Prenda_Atributos("Gorro", "Verde", 0.3, 2);
        prendas.put("Gorro", Gorro);

        Prenda Guantes = new Prenda();
        Guantes.Prenda_Atributos("Guantes", "Negros", 0.2, 5);
        prendas.put("Guantes", Guantes);

        Prenda Camiseta = new Prenda();
        Camiseta.Prenda_Atributos("Camiseta", "Amarilla", 0.6, 3);
        prendas.put("Camiseta", Camiseta);

        Prenda Chaleco = new Prenda();
        Chaleco.Prenda_Atributos("Chaleco", "Beige", 0.8, 2);
        prendas.put("Chaleco", Chaleco);

        Prenda Shorts = new Prenda();
        Shorts.Prenda_Atributos("Shorts", "Marrón", 0.7, 4);
        prendas.put("Shorts", Shorts);


        Menu_Elegir_lavadora();
        System.exit(0);
        //borrar testo de despues

        Manta manta = new Manta();
        Calcetines calcetines = new Calcetines();
        Pantalon pantalon = new Pantalon();
        Jersey jersey = new Jersey();

        /*
        //Lavadora1 lavadora1 = new Lavadora1();
            System.out.println("----------------------------------------------");
            lavadora1.ComprobaciondeErores();
            lavadora1.Lavadora(10, "corto", 35);
            lavadora1.Abrir_lavadora();
            lavadora1.Llenar_lavadora(6);
            manta.Depositar_en_la_labaora("Lavadora1");
            lavadora1.Cerrar_lavadora();
            lavadora1.Iniciar_lavadora();
            lavadora1.Abrir_lavadora();
            lavadora1.VerEstado();
            lavadora1.Abrir_lavadora();
            lavadora1.Baciar_lavadora(6);
            manta.Sacar_de_la_labadora();
            lavadora1.Cerrar_lavadora();

        //Lavadora2 lavadora2 = new Lavadora2();
            System.out.println("----------------------------------------------");
            lavadora2.ComprobaciondeErores();
            lavadora2.Lavadora(10, "corto", 35);
            lavadora2.Abrir_lavadora();
            lavadora2.Llenar_lavadora(5);
            calcetines.Depositar_en_la_labaora("Lavadora2");
            lavadora2.Cerrar_lavadora();
            lavadora2.Iniciar_lavadora();
            lavadora2.VerEstado();
            lavadora2.Abrir_lavadora();
            lavadora2.Baciar_lavadora(6);
            lavadora2.Cerrar_lavadora();

        //Lavadora3 lavadora3 = new Lavadora3();
            System.out.println("----------------------------------------------");
            lavadora3.ComprobaciondeErores();
            lavadora3.Abrir_lavadora();
            lavadora3.Llenar_lavadora(10);
            pantalon.Depositar_en_la_labaora("Lavadora3");
            jersey.Depositar_en_la_labaora("Lavadora3");
            lavadora3.Cerrar_lavadora();
            lavadora3.Iniciar_lavadora();
            lavadora3.VerEstado();
            lavadora3.Abrir_lavadora();
            lavadora3.Baciar_lavadora(10);
            lavadora3.Cerrar_lavadora();


         */
        }
    }