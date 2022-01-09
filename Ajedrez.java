import java.util.Scanner;
import java.util.Random;

public class Ajedrez {
    public static void main(String[] args) {

        // Hacemos scanner
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Random random = new Random();

        if (args.length == 0) {
            menu(scan1);
        } else if (args.length == 1) {
            // jugar con la computadora
        } else if (args.length == 2) {
            String jugador1blanco = args[0];
            String jugador2negro = args[1];

            System.out.println("\n" + jugador1blanco + " jugará con las piezas blancas");
            System.out.println(jugador2negro + " jugará con las piezas negras");

            // Creamos tablero
            Pieza[][] arreglo = hacerTablero();
            // Creamos arreglo con el nombre de las piezas
            String[] piezas = { "torreblanco", "caballoblanco", "reyblanco", "reinablanco", "peonblanco", "torrenegro",
                    "caballonegro", "reynegro", "reinanegro", "peonnegro" };
            // Creamos el arreglo con el número de piezas
            int[] numpiezas = { 2, 2, 1, 1, 6, 2, 2, 1, 1, 6 };

            // Imprimimos el tablero
            // System.out.println(visualizarTablero(arreglo));

            // repetir hasta que algun jugador se quede sin piezas de algún tipo
            int ceros = -1;
            boolean turnoblanco = true;
            int movimientos = 10;
            juego: do {
                /*
                 * if (turnoblanco) {
                 * System.out.println("\nTurno de " + jugador1blanco + "\n");
                 * } else {
                 * System.out.println("\nTurno de " + jugador2negro + "\n");
                 * }
                 */
                preguntaymueve(arreglo, piezas, numpiezas, scan1, scan2, turnoblanco, jugador1blanco, jugador2negro);
                ceros = buscarNum(numpiezas, 0);
                if (ceros != -1) {
                    System.out.print("\nEl juego terminó, ganó ");
                    if (turnoblanco) {
                        System.out.print(jugador1blanco);
                    } else {
                        System.out.print(jugador2negro);
                    }
                    break juego;
                }
                turnoblanco = !turnoblanco;
                movimientos -= 1;
            } while (ceros == -1 && movimientos != 0);
            if (movimientos == 0) {
                System.out.println("Se acabaron los movimientos posibles, gana ");
                if (random.nextInt(2) == 1) {
                    System.out.println(jugador1blanco);
                } else {
                    System.out.println(jugador2negro);
                }
            }
        } else {
            System.out.println("\nNumero de argumentos no valido");
        }
    }

    public static Pieza[][] hacerTablero() {
        Pieza[][] arreglo = new Pieza[6][6];
        // Creamos las piezas
        Torre torre1B = new Torre(0, 0, "blanco", 1);
        Torre torre2B = new Torre(0, 5, "blanco", 2);
        Torre torre1N = new Torre(5, 0, "negro", 1);
        ;
        Torre torre2N = new Torre(5, 5, "negro", 2);
        ;
        Caballo caballo1B = new Caballo(0, 1, "blanco", 1);
        Caballo caballo2B = new Caballo(0, 4, "blanco", 2);
        Caballo caballo1N = new Caballo(5, 1, "negro", 1);
        Caballo caballo2N = new Caballo(5, 4, "negro", 2);
        Rey rey1B = new Rey(0, 2, "blanco", 1);
        Rey rey1N = new Rey(5, 2, "negro", 1);
        Reina reina1B = new Reina(0, 3, "blanco", 1);
        Reina reina1N = new Reina(5, 3, "negro", 1);
        Peon peon1B = new Peon(1, 0, "blanco", 1);
        Peon peon2B = new Peon(1, 1, "blanco", 2);
        Peon peon3B = new Peon(1, 2, "blanco", 3);
        Peon peon4B = new Peon(1, 3, "blanco", 4);
        Peon peon5B = new Peon(1, 4, "blanco", 5);
        Peon peon6B = new Peon(1, 5, "blanco", 6);
        Peon peon1N = new Peon(4, 0, "negro", 1);
        Peon peon2N = new Peon(4, 1, "negro", 2);
        Peon peon3N = new Peon(4, 2, "negro", 3);
        Peon peon4N = new Peon(4, 3, "negro", 4);
        Peon peon5N = new Peon(4, 4, "negro", 5);
        Peon peon6N = new Peon(4, 5, "negro", 6);

        // Llenamos el tablero con piezas
        arreglo[0][0] = torre1B;
        arreglo[0][1] = caballo1B;
        arreglo[0][2] = rey1B;
        arreglo[0][3] = reina1B;
        arreglo[0][4] = caballo2B;
        arreglo[0][5] = torre2B;
        arreglo[1][0] = peon1B;
        arreglo[1][1] = peon2B;
        arreglo[1][2] = peon3B;
        arreglo[1][3] = peon4B;
        arreglo[1][4] = peon5B;
        arreglo[1][5] = peon6B;
        arreglo[5][0] = torre1N;
        arreglo[5][1] = caballo1N;
        arreglo[5][2] = rey1N;
        arreglo[5][3] = reina1N;
        arreglo[5][4] = caballo2N;
        arreglo[5][5] = torre2N;
        arreglo[4][0] = peon1N;
        arreglo[4][1] = peon2N;
        arreglo[4][2] = peon3N;
        arreglo[4][3] = peon4N;
        arreglo[4][4] = peon5N;
        arreglo[4][5] = peon6N;

        return arreglo;
    }

    // Método para buscar una pieza en el tablero
    public static boolean buscar(Pieza[][] arreglo, String buscado) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                if (arreglo[i][j] != null) {
                    Pieza pz = (Pieza) arreglo[i][j];
                    String tipo = pz.getTipo();
                    int num = pz.getNumero();
                    String color = pz.getColor();
                    String nombrePieza = tipo + num + color;
                    if (buscado.equals(nombrePieza)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Busca un String en un arreglo, regresa la posicion en que se encuentra el
    // numero. Si no, regresa -1
    public static int buscarNum(int[] arreglo, int buscado) {
        int m = -1;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == buscado) {
                m = i;
            }
        }
        return m;
    }

    // Matodo que regresa las coordenadas de la posición de la pieza en el tablero
    public static int[] regresarPosPieza(Pieza[][] arreglo, String b) {
        int m = 0;
        int k = 0;
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                if (arreglo[i][j] != null) {
                    Pieza pz = (Pieza) arreglo[i][j];
                    String tipo = pz.getTipo();
                    int num = pz.getNumero();
                    String color = pz.getColor();
                    String nombrePieza = tipo + num + color;
                    if (b.equals(nombrePieza)) {
                        m = i;
                        k = j;
                    }
                }
            }
        }
        int[] arr = new int[2];
        arr[0] = m;
        arr[1] = k;
        return arr;
    }

    // Método para imprimir cómo se ve el tablero
    public static String visualizarTablero(Pieza[][] arreglo) {
        System.out.println();
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                if (arreglo[i][j] == null) {
                    System.out.print(" --(" + i + "," + j + ")----  ");
                } else {
                    System.out.print(arreglo[i][j] + "   ");
                }
            }
            System.out.println("\n");
        }
        return " ";
    }

    public static void preguntaymueve(Pieza[][] arreglo, String[] piezas, int[] numpiezas, Scanner scan1,
            Scanner scan2, boolean turnoblanco, String jugador1blanco, String jugador2negro) {
        int w = 0;
        int m;
        int k;
        boolean x = true;

        if (turnoblanco) {
            System.out.println("\nTurno de " + jugador1blanco + "\n");
        } else {
            System.out.println("\nTurno de " + jugador2negro + "\n");
        }

        // Se repite hasta ingresar un movimiento válido
        do {
            // se repite la pregunta hasta que se responda con una pieza valida

            pieza: do {
                System.out.println(visualizarTablero(arreglo));
                System.out.println("¿Que pieza quieres mover? (Ingresa nombre completo)"); // Pregunta pieza
                String respuesta = scan1.nextLine();// Guarda respuesta
                respuesta = respuesta.strip().toLowerCase();
                boolean esta = buscar(arreglo, respuesta); // Busca si la pieza esta en el tablero

                // si la pieza esta en el tablero
                outerloop: if (esta) {

                    int[] arr = regresarPosPieza(arreglo, respuesta); // arrreglo con las coordenadas de la posicion de
                                                                      // la pieza en el tablero
                    boolean piezaValida = arreglo[arr[0]][arr[1]].validarPieza();// se valida que la pieza esta activa

                    if (turnoblanco) {
                        if (arreglo[arr[0]][arr[1]].color.equals("negro")) {
                            System.out.println("No puedes mover esta pieza");
                            break outerloop;
                        }
                    } else {
                        if (arreglo[arr[0]][arr[1]].color.equals("blanco")) {
                            System.out.println("No puedes mover esta pieza");
                            break outerloop;
                        }
                    }

                    // Si la pieza esta activa, preguntar movimiento deseado de la pieza
                    if (piezaValida) {
                        boolean y = true;
                        int columna = -1;
                        int fila = -1;
                        while (y) {// trycatch
                            System.out.println("Ingresa el numero de fila(0-5 de arriba a abajo)");
                            fila = scan2.nextInt();
                            if (fila < 0 || fila > 5) {
                                System.out.println("Fila no valida");
                            } else {
                                y = false;
                            }
                        }

                        y = true;
                        while (y) { // trycatch
                            System.out.println("Ingresa el numero de columna(0-5 de izquierda a derecha)");
                            columna = scan2.nextInt();
                            if (columna < 0 || columna > 5) {
                                System.out.println("Columna no valida");
                            } else {
                                y = false;
                            }
                        }

                        String tipoPz = arreglo[arr[0]][arr[1]].tipo;// obtenemos el tipo de pieza que es
                        // System.out.println(tipoPz);

                        // Dependiendo el tipo de pieza, hacemos las validaciones correspondientes
                        switch (tipoPz) {
                            case "torre":
                                Torre torr = (Torre) arreglo[arr[0]][arr[1]];
                                // System.out.println("Por validar");
                                if (torr.validar(fila, columna, arreglo, piezas, numpiezas)) {
                                    x = false;
                                    break pieza;
                                } else {
                                    System.out.println("\nMovimiento no valido\n");
                                }
                                break;
                            case "caballo":
                                Caballo cab = (Caballo) arreglo[arr[0]][arr[1]];
                                if (cab.validarMov(fila, columna, arreglo, piezas, numpiezas)) {
                                    x = false;
                                    break pieza;
                                } else {
                                    System.out.println("\nMovimiento no válido\n");
                                }
                                break;
                            case "rey":
                                Rey rey = (Rey) arreglo[arr[0]][arr[1]];
                                if (rey.validarMov(fila, columna, arreglo, piezas, numpiezas)) {
                                    x = false;
                                    break pieza;
                                } else {
                                    System.out.println("\nMovimiento no válido\n");
                                }
                                break;
                            case "reina":
                                Reina reina = (Reina) arreglo[arr[0]][arr[1]];
                                if (reina.validar(fila, columna, arreglo, piezas, numpiezas)) {
                                    x = false;
                                    break pieza;
                                } else {
                                    System.out.println("\nMovimiento no válido\n");
                                }
                                break;
                            case "peon":
                                Peon peon = (Peon) arreglo[arr[0]][arr[1]];
                                if (peon.validarMov(fila, columna, arreglo, piezas, numpiezas)) {
                                    x = false;
                                    // Si el peon esta en la ultima fila
                                    if (peon.coordenadaX == 5 || peon.coordenadaX == 0) {
                                        boolean s = true;
                                        String r = "";
                                        // Se repetira hasta que la respuesta sea torre, caballo o reina
                                        do {
                                            System.out.println(
                                                    "A que pieza quieres promover al peon?(torre/caballo/reina)");
                                            String resp = scan1.nextLine().toLowerCase().strip();
                                            if (resp.equals("torre") || resp.equals("caballo")
                                                    || resp.equals("reina")) {
                                                r = resp;
                                                s = false;
                                            } else {
                                                System.out.print("\nRespuesta no valida\n");
                                            }
                                        } while (s);
                                        // Peon promocion = (Peon) arreglo[arr[0]][arr[1]];
                                        peon.promover(r, arreglo, piezas, numpiezas);
                                    }
                                    break pieza;
                                } else {
                                    System.out.println("\nMovimiento invalido\n");
                                }
                                break;
                            default:
                        }
                        // System.out.println(visualizarTablero(arreglo));

                    } else {
                        System.out.println("\nPieza no valida\n");
                        w = 1;
                    }
                } else {
                    System.out.println("\nPieza no valida\n");
                    w = 1;
                }
                // System.out.println(visualizarTablero(arreglo));
            } while (x);
        } while (w == 1);
    }

    public static void menu(Scanner scan1) {
        System.out.println("\nExtintion Chess\n***Menu***");
        System.out.println("¿Qué quieres hacer? (Ingresa la letra)");
        System.out.println("\n(I) Ver instrucciones");
        System.out.println("(G)Ver participantes");// 3 participante de menor a mayor
        System.out.println("(S)Salir");
        boolean h = true;
        do {
            String respuesta = scan1.nextLine().strip().toLowerCase();
            sw: switch (respuesta) {
                case "i":
                    // imprimir instrucciones
                    h = false;
                    break;
                case "g":
                    // listar participantes
                    h = false;
                    break;
                case "s":
                    h = false;
                    System.exit(0);
                    break;
                default:
                    break sw;

            }
        } while (h);
    }
}