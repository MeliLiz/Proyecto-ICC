import java.util.Scanner;

public class Ajedrez{
    public static void main(String[] args){

        //Hacemos scanner
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        //Creamos tablero
        Pieza[][] arreglo = new Pieza[6][6];

        //Creamos arreglo con el nombre de las piezas
        String[] piezas = {"torreblanco","caballoblanco","reyblanco","reinablanco","peonblanco","torrenegro","caballonegro","reynegro","reinanegro","peonnegro"};
        //Creamos el arreglo con el número de piezas
        int[] numpiezas = {2,2,1,1,6,2,2,1,1,6};

        //Creamos las piezas
        Torre torre1B = new Torre(0,0,"blanco",1);
        Torre torre2B = new Torre(0,5,"blanco",2);
        Torre torre1N = new Torre(5,0,"negro",1);;
        Torre torre2N = new Torre(5,5,"negro",2);;
        Caballo caballo1B = new Caballo(0,1,"blanco",1);
        Caballo caballo2B = new Caballo(0,4,"blanco",2);
        Caballo caballo1N = new Caballo(5,1,"negro",1);
        Caballo caballo2N = new Caballo(5,4,"negro",2);
        Rey rey1B = new Rey(0,2,"blanco",1);
        Rey rey1N = new Rey(5,2,"negro",1);
        Reina reina1B = new Reina(0,3,"blanco",1);
        Reina reina1N = new Reina(5,3,"negro",1);
        Peon peon1B = new Peon(1,0,"blanco",1);
        Peon peon2B = new Peon(1,1,"blanco",2);
        Peon peon3B = new Peon(1,2,"blanco",3);
        Peon peon4B = new Peon(1,3,"blanco",4);
        Peon peon5B = new Peon(1,4,"blanco",5);
        Peon peon6B = new Peon(1,5,"blanco",6);
        Peon peon1N = new Peon(4,0,"negro",1);
        Peon peon2N = new Peon(4,1,"negro",2);
        Peon peon3N = new Peon(4,2,"negro",3);
        Peon peon4N = new Peon(4,3,"negro",4);
        Peon peon5N = new Peon(4,4,"negro",5);
        Peon peon6N = new Peon(4,5,"negro",6);

        //Llenamos el tablero con piezas
        arreglo[0][0]= torre1B;
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
        arreglo[5][5] =torre2N;
        arreglo[4][0] = peon1N;
        arreglo[4][1] = peon2N;
        arreglo[4][2] =peon3N;
        arreglo[4][3] =peon4N;
        arreglo[4][4] =peon5N;
        arreglo[4][5] =peon6N;

        //Imprimimos el tablero
        System.out.println(visualizarTablero(arreglo));

        int w = 0;
        int m;
        int k;

        //se repite la pregunta hasta que se responda con una pieza valida
        do{
            System.out.println("¿Que pieza quieres mover? ()"); //Pregunta pieza
            String respuesta = scan1.nextLine();//Guarda respuesta
            respuesta = respuesta.strip().toLowerCase();
            boolean esta = buscar(arreglo, respuesta); //Busca si la pieza esta en el tablero

            //si la pieza esta en el tablero
            if(esta){

                int[] arr = regresarPosPieza(arreglo, respuesta); //arrreglo con las coordenadas de la posicion de la pieza en el tablero
                boolean piezaValida = arreglo[arr[0]][arr[1]].validarPieza();//se valida que la pieza esta activa

                //Si la pieza esta activa, preguntar movimiento deseado de la pieza
                if(piezaValida){

                    boolean x = true;
                    while (x){

                        boolean y = true;
                        int columna=-1;
                        int fila = -1;
                        while (y){ //trycatch
                            System.out.println("Ingresa el numero de columna(0-5 de izquierda a derecha)");
                            columna = scan2.nextInt();
                            if (columna<0||columna>5){
                                System.out.println("Columna no valida");
                            }else{
                                y=false;
                            }
                        }
                        y=true;
                        while(y){//trycatch
                            System.out.println("Ingresa el numero de fila(0-5 de arriba a abajo)");
                            fila = scan2.nextInt();
                            if (fila<0||fila>5){
                                System.out.println("Fila no valida");
                            }else{
                                y=false;
                            }
                        }

                        String tipoPz = arreglo[arr[0]][arr[1]].tipo;//obtenemos el tipo de pieza que es

                        //Dependiendo el tipo de pieza, hacemos las validaciones correspondientes
                        switch(tipoPz){
                            case "torre":
                                Torre torr = (Torre) arreglo[arr[0]][arr[1]];
                                if(torr.validar(fila, columna, arreglo, piezas, numpiezas)){
                                    x=false;
                                }else{
                                    System.out.println("\nMovimiento no valido\n");
                                }
                                /*if(torr.validarMov(fila, columna)){
                                    if(torr.movSinEstorbo(fila, columna, arreglo)){
                                        torr.mover(fila, columna, arreglo);
                                        x=false;
                                    }else{
                                        int dep = torr.hayPieza(fila,columna,arreglo);
                                        if(dep==2){
                                            System.out.println("\nCoordenadas no válidas\n");
                                        }else if(dep==3){
                                            torr.reemplaza(fila, columna, arreglo, piezas, numpiezas);
                                            x=false;
                                        }
                                    }
                                }*/
                            break;
                            case "caballo":
                                Caballo cab = (Caballo) arreglo[arr[0]][arr[1]];
                                if(cab.validarMov(fila, columna, arreglo, piezas, numpiezas)){
                                    x=false;
                                }else{
                                    System.out.println("\nMovimiento no válido\n");
                                }
                            break;
                            case "rey":
                                Rey rey = (Rey) arreglo[arr[0]][arr[1]];
                                if(rey.validarMov(fila, columna, arreglo, piezas, numpiezas)){
                                    x=false;
                                }else{
                                    System.out.println("\nMovimiento no válido\n");
                                }
                            break;
                            case "reina":
                                Reina reina = (Reina) arreglo[arr[0]][arr[1]];
                                break;
                            case "peon":
                                Peon peon = (Peon) arreglo[arr[0]][arr[1]];
                                if (!peon.validarMov(fila, columna, arreglo, piezas, numpiezas)){
                                    System.out.println("\nMovimiento inválido\n");
                                }else{
                                    x=false;
                                }
                            break;
                            default:
                        }

                    }
                }else {
                    System.out.println("\nPieza no valida\n");
                    w=1;
                }
            }else{
                System.out.println("\nPieza no valida\n");
                w=1;
            }
        }while(w==1);
        
    }

    //Método para buscar una pieza en el tablero
    public static boolean buscar(Pieza[][] arreglo, String buscado){
        for(int i=0; i<arreglo.length; i++){
            for(int j=0; j<arreglo[0].length;j++){
                if(arreglo[i][j]!=null){
                    Pieza pz = (Pieza)arreglo[i][j];
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

    //Matodo que regresa las coordenadas de la posición de la pieza en el tablero
    public static int[] regresarPosPieza(Pieza[][] arreglo, String b){
        int m=0;
        int k=0;
        for(int i=0; i<arreglo.length; i++){
            for(int j=0; j<arreglo[0].length;j++){
                if(arreglo[i][j]!=null){
                    Pieza pz = (Pieza)arreglo[i][j];
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

    //Método para imprimir cómo se ve el tablero
    public static String visualizarTablero(Pieza[][] arreglo){
        for(int i=0; i<arreglo.length; i++){
            for(int j=0; j<arreglo[0].length; j++){
                if (arreglo[i][j]==null){
                    System.out.print("  ----------  ");
                }else{
                    System.out.print(arreglo[i][j] + "   ");
                }
            }
            System.out.println();
        }
        return " ";
    }
}