import java.util.Scanner;
import java.util.Random;

public class prueba {
    public static void main(String[] args) {
        /*
         * Torre torre = new Torre(5, 4, "blanco", 1);
         * System.out.println("hola");
         * try{
         * torre.setCoordenadaX(7);
         * }catch(RuntimeException e){
         * System.out.println("no");
         * }
         */

        /*
         * Pieza[][] arreglo = new Pieza[6][5];
         * Torre torre = new Torre(5, 4, "blanco", 1);
         * arreglo[5][4] = torre;
         * System.out.println(arreglo[5][4]);
         */

        /*
         * Scanner scan = new Scanner(System.in);
         * Tablero tablero = new Tablero();
         * tablero.iniciaTablero();
         * System.out.println(tablero.visualizar());
         * tablero.peon1N.getActividad();
         * // tablero.torre1B.
         * // tablero.arreglo[][]
         * String r = "hola";
         * boolean h = true;
         * do {
         * System.out.println("Ingresa un número");
         * String respuesta = scan.nextLine();
         * if (respuesta.equals("h")) {
         * r = respuesta;
         * h = false;
         * }
         * } while (h);
         * System.out.println(r);
         */

        /*
         * public Pieza[][] hacerTablero(){
         * Pieza[][] arreglo = new Pieza[6][6];
         * //Creamos las piezas
         * Torre torre1B = new Torre(0,0,"blanco",1);
         * Torre torre2B = new Torre(0,5,"blanco",2);
         * Torre torre1N = new Torre(5,0,"negro",1);;
         * Torre torre2N = new Torre(5,5,"negro",2);;
         * Caballo caballo1B = new Caballo(0,1,"blanco",1);
         * Caballo caballo2B = new Caballo(0,4,"blanco",2);
         * Caballo caballo1N = new Caballo(5,1,"negro",1);
         * Caballo caballo2N = new Caballo(5,4,"negro",2);
         * Rey rey1B = new Rey(0,2,"blanco",1);
         * Rey rey1N = new Rey(5,2,"negro",1);
         * Reina reina1B = new Reina(0,3,"blanco",1);
         * Reina reina1N = new Reina(5,3,"negro",1);
         * Peon peon1B = new Peon(1,0,"blanco",1);
         * Peon peon2B = new Peon(1,1,"blanco",2);
         * Peon peon3B = new Peon(1,2,"blanco",3);
         * Peon peon4B = new Peon(1,3,"blanco",4);
         * Peon peon5B = new Peon(1,4,"blanco",5);
         * Peon peon6B = new Peon(1,5,"blanco",6);
         * Peon peon1N = new Peon(4,0,"negro",1);
         * Peon peon2N = new Peon(4,1,"negro",2);
         * Peon peon3N = new Peon(4,2,"negro",3);
         * Peon peon4N = new Peon(4,3,"negro",4);
         * Peon peon5N = new Peon(4,4,"negro",5);
         * Peon peon6N = new Peon(4,5,"negro",6);
         * 
         * //Llenamos el tablero con piezas
         * arreglo[0][0]= torre1B;
         * arreglo[0][1] = caballo1B;
         * arreglo[0][2] = rey1B;
         * arreglo[0][3] = reina1B;
         * arreglo[0][4] = caballo2B;
         * arreglo[0][5] = torre2B;
         * arreglo[1][0] = peon1B;
         * arreglo[1][1] = peon2B;
         * arreglo[1][2] = peon3B;
         * arreglo[1][3] = peon4B;
         * arreglo[1][4] = peon5B;
         * arreglo[1][5] = peon6B;
         * arreglo[5][0] = torre1N;
         * arreglo[5][1] = caballo1N;
         * arreglo[5][2] = rey1N;
         * arreglo[5][3] = reina1N;
         * arreglo[5][4] = caballo2N;
         * arreglo[5][5] =torre2N;
         * arreglo[4][0] = peon1N;
         * arreglo[4][1] = peon2N;
         * arreglo[4][2] =peon3N;
         * arreglo[4][3] =peon4N;
         * arreglo[4][4] =peon5N;
         * arreglo[4][5] =peon6N;
         * 
         * return arreglo;
         * }
         */

        /*Random random = new Random();
        System.out.println(random.nextInt(2));*/
        int i=5;
        i=multiplica(i);

        System.out.println(i);

            /* despues de juego: do
                 * if (turnoblanco) {
                 * System.out.println("\nTurno de " + jugador1blanco + "\n");
                 * } else {
                 * System.out.println("\nTurno de " + jugador2negro + "\n");
                 * }
                 */




                 /*
                 Al terminar el if
                 int ceros = -1;
            boolean turnoblanco = true;
            int movimientos = 10;
            juego: do {
                preguntaymueve(arreglo, piezas, numpiezas, scan1, scan2, turnoblanco, jugador1blanco, jugador2negro);
                ceros = buscarNum(numpiezas, 0);
                if (ceros != -1) {
                    System.out.print("\nEl juego ha terminado, el ganador es "+ jugador1blanco);
                    break juego;
                }
                turnoblanco = !turnoblanco;
                movimientos -= 1;
                if (movimientos == 0) {
                    System.out.println("Se acabaron los movimientos posibles, gana ");
                    if (random.nextInt(2) == 1) {
                        System.out.println(jugador1blanco);
                    } else {
                        System.out.println(jugador2negro);
                    }
                }
                if(!turnoblanco){
                    computadora(arreglo, piezas, numpiezas, scan1, scan2, turnoblanco, jugador1blanco, jugador2negro);
                }
                ceros = buscarNum(numpiezas, 0);
                if (ceros != -1) {
                    System.out.print("\nEl juego ha terminado, el ganador es "+ jugador2negro);
                    break juego;
                }
                turnoblanco = !turnoblanco;
                movimientos -= 1;
            } while (movimientos != 0);
            if (movimientos == 0) {
                System.out.println("Se acabaron los movimientos posibles, gana ");
                if (random.nextInt(2) == 1) {
                    System.out.println(jugador1blanco);
                } else {
                    System.out.println(jugador2negro);
                }
            }*/







            /**
     * Metodo para crear el tablero de ajedrez
     * @return  Pieza[][] El tablero
     */
    /*public static Pieza[][] hacerTablero() {
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
    }*/







    /*else if (args.length == 2) {
            String jugador1blanco = args[0];
            String jugador2negro = args[1];

            System.out.println("\n" + jugador1blanco + " jugará con las piezas blancas");
            System.out.println(jugador2negro + " jugará con las piezas negras");

            // Creamos tablero
            //Pieza[][] arreglo = hacerTablero();
            Tablero tab = new Tablero();
            Pieza[][] arreglo = tab.getTablero();
            // Creamos arreglo con el nombre de las piezas
            String[] piezas = { "torreblanco", "caballoblanco", "reyblanco", "reinablanco", "peonblanco", "torrenegro",
                    "caballonegro", "reynegro", "reinanegro", "peonnegro" };
            // Creamos el arreglo con el numero de piezas
            int[] numpiezas = { 2, 2, 1, 1, 6, 2, 2, 1, 1, 6 };

            // Imprimimos el tablero
            // System.out.println(visualizarTablero(arreglo));

            // repetir hasta que algun jugador se quede sin piezas de algún tipo
            int ceros = -1;
            boolean turnoblanco = true;
            int movimientos = 10;
            juego: do {
                preguntaymueve(arreglo, piezas, numpiezas, scan1, scan2, turnoblanco, jugador1blanco, jugador2negro);
                ceros = buscarNum(numpiezas, 0);
                if (ceros != -1) {
                    System.out.println(visualizarTablero(arreglo));
                    System.out.print("\nEl juego terminó, ganó ");
                    if (turnoblanco) {
                        System.out.print(jugador1blanco+"\n");
                    } else {
                        System.out.print(jugador2negro+"\n");
                    }
                    
                    break juego;
                }
                turnoblanco = !turnoblanco;
                movimientos -= 1;
            } while (movimientos != 0);
            if (movimientos == 0) {
                System.out.println("Se acabaron los movimientos posibles, gana ");
                if (random.nextInt(2) == 1) {
                    System.out.println(jugador1blanco);
                } else {
                    System.out.println(jugador2negro);
                }
            }
        }*/


// Despues del if else para asignar jugadores

        // jugar con la computadora
            //String jugador1blanco = args[0];
            //String jugador2negro = "Computadora";



            //Para crear tablero
//Pieza[][] arreglo = hacerTablero();




/*
Antes del switch tipoPieza


y = true;
                        while (y) { // trycatch
                            System.out.println("Ingresa el numero de columna(0-5 de izquierda a derecha)");
                            columna = scan2.nextInt();
                            if (columna < 0 || columna > 5) {
                                System.out.println("Columna no valida");
                            } else {
                                y = false;
                            }
                        }*/

                        //String tipoPz = arreglo[arr[0]][arr[1]].tipo;// obtenemos el tipo de pieza que es
                        // System.out.println(tipoPz);
    }

    public static int multiplica(int x){
        x=x*2;
        return x;
    }
}