import java.util.Scanner;

public class Ajedrez{
    public static void main(String[] args){
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Tablero tablero = new Tablero();
        tablero.iniciaTablero();
        System.out.println(tablero.visualizar());
        int w = 0;
        int m;
        int k;
        do{
            System.out.println("¿Que pieza quieres mover? ()");
            String respuesta = scan1.nextLine();
            respuesta = respuesta.strip().toLowerCase();
            boolean esta = buscar(tablero, respuesta);
            if(esta){
                int[] arr = regresarPieza(tablero, respuesta);
                boolean piezaValida = tablero.arreglo[arr[0]][arr[1]].validarPieza();
                System.out.println(piezaValida);
                /*if(piezaValida){
                    String tipoPz = pz.tipo;
                    switch(tipoPz){
                        case "torre":
                        case "caballo":
                        case "rey":
                        case "reina":
                        case "peon":
                        default:
                    }
                }else {
                    w=1;
                }*/
            }else{
                System.out.println("Pieza no valida");
                w=1;
            }
        }while(w==1);
        
    }

    public static boolean buscar(Tablero tablero, String buscado){
        Pieza[][] arreglo = tablero.getArreglo();
        for(int i=0; i<arreglo.length; i++){
            for(int j=0; j<arreglo[0].length;j++){
                if(tablero.arreglo[i][j]!=null){
                    Pieza pz = (Pieza)tablero.arreglo[i][j];
                    String tipo = pz.getTipo();
                    int num = pz.getNumero();
                    String color = pz.getColor();
                    String nombrePieza = tipo+num+color;
                    if(buscado.equals(nombrePieza)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int[] regresarPieza(Tablero tablero, String b){
        Pieza[][] arreglo = tablero.getArreglo();
        int m=0;
        int k=0;
        for(int i=0; i<arreglo.length; i++){
            for(int j=0; j<arreglo[0].length;j++){
                if(tablero.arreglo[i][j]!=null){
                    Pieza pz = (Pieza)tablero.arreglo[i][j];
                    String tipo = pz.getTipo();
                    int num = pz.getNumero();
                    String color = pz.getColor();
                    String nombrePieza = tipo+num+color;
                    if(b.equals(nombrePieza)){
                        m=i;
                        k=j;
                    }
                }
            }
        }
        int[] arr= new int[2];
        arr[0] = m;
        arr[1] =k;
        return arr;
    }
}