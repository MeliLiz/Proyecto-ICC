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

    }

    public static int multiplica(int x){
        x=x*2;
        return x;
    }
}