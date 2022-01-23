/**
 * Clase Ajedrez para jugar Extintion Chess
 * @author Melissa Lizbeth Fernandez Blancas
 * @version 1
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileWriter;
import java.io.RandomAccessFile;

public class Ajedrez {

    /**
     * Metodo principal
     * @param args Nombre de una o dos personas que jugaran
     */
    public static void main(String[] args) {

        String jugador1blanco;
        String jugador2negro;

        if (args.length == 0) {
            menu();
        } else if (args.length == 1 || args.length ==2) {
            int movimientos = seleccionarNivel();
            //Si jugamos con la computadora
            if(args.length==1){
                jugador1blanco = args[0];
                jugador2negro = "Computadora";
            }else{ //Si hay 2 jugadores
                jugador1blanco = args[0];
                jugador2negro = args[1];
            }
            jugar(movimientos, jugador1blanco,jugador2negro);
        } else {
            System.out.println("\nNumero de argumentos no valido\nPara ver instrucciones teclee \"java Ajedrez\" y seleccione la opcion i\n");
        }
    }//FIN DEL MAIN

    /**
     * Metodo para seleccionar el nivel a jugar
     * @return int El numero de movimientos dependiendo del nivel que se elija
     */
    public static int seleccionarNivel(){
        Scanner scan = new Scanner(System.in);
        boolean si = true;
        int nivel;
        int movimientos=0;
        do{
            System.out.println("\nSelecciona el nivel\n");
            System.out.println("(1) Nivel 1 (20 movimientos)");
            System.out.println("(2) Nivel 2 (40 movimientos)");
            System.out.println("(3) Nivel 3 (100 movimientos)");
            try{
                nivel = scan.nextInt();
                if(nivel==1||nivel==2||nivel==3){
                    if(nivel==1){
                        movimientos=20;
                        si=false;
                    }else if(nivel==2){
                        movimientos=40;
                    }else{
                        movimientos=100;
                    }
                    si=false;
                }else{
                    System.out.println("No es una opcion valida");
                }
            }catch(Exception e){
                System.out.println("Respuesta no valida");
                scan.next();
            }
        }while(si);
        //scan.close();
        return movimientos; 
    }//FIN DE SELECCIONAR NIVEL

    /**
     * Metodo para jugar
     * @param movimientos El numero de movimientos con los que se juega
     * @param jugador1blanco El nombre del jugador 1
     * @param jugador2negro El nombre del jugador 2
     */
    public static void jugar(int movimientos, String jugador1blanco, String jugador2negro){

        Jugador n1=new Jugador(jugador1blanco);
        Jugador n2=new Jugador(jugador2negro);
        Date date = new Date();
        String fecha = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Random random = new Random();

            System.out.println("\n" + jugador1blanco + " jugara con las piezas blancas");
            System.out.println(jugador2negro + " jugara con las piezas negras");

            // Creamos tablero
            Tablero tab = new Tablero();
            Pieza[][] arreglo = tab.getTablero();
            // Creamos arreglo con el nombre de las piezas
            String[] piezas = { "torreblanco", "caballoblanco", "reyblanco", "reinablanco", "peonblanco", "torrenegro",
                    "caballonegro", "reynegro", "reinanegro", "peonnegro" };
            // Creamos el arreglo con el numero de piezas
            int[] numpiezas = { 2, 2, 1, 1, 6, 2, 2, 1, 1, 6 };

            // repetir hasta que algun jugador se quede sin piezas de algun tipo
            int ceros = -1;
            boolean turnoblanco = true;
            juego: do {
                
                preguntaymueve(arreglo, piezas, numpiezas, scan1, scan2, turnoblanco, jugador1blanco, jugador2negro, tab);
                ceros = buscarNum(numpiezas, 0);
                if (ceros != -1) {
                    tab.visualizarTablero();
                    String pzd = piezas[ceros];
                    System.out.println("Se eliminaron todas las fichas " + pzd);
                    System.out.print("\nEl juego ha terminado, el ganador es ");
                    if (turnoblanco) {
                        System.out.print(jugador1blanco+"\n");
                        n1.setGana(true);
                    } else {
                        System.out.print(jugador2negro+"\n");
                        n2.setGana(true);
                    }
                    fecha=formatter.format(date);
                    break juego;
                }
                turnoblanco = !turnoblanco;
                movimientos -= 1;
            } while (ceros == -1 && movimientos != 0);
            if (movimientos == 0) {
                tab.visualizarTablero();
                System.out.println("Se acabaron los movimientos posibles, gana ");
                if (random.nextInt(2) == 1) {
                    System.out.println(jugador1blanco);
                    n1.setGana(true);
                } else {
                    System.out.println(jugador2negro);
                    n2.setGana(true);
                }
                fecha=formatter.format(date);
            }
            try {
                //Crear un objeto File para crear o abrir acceso a un archivo 
                File archivo = new File("juego.txt");
                //Crear objeto FileWriter para escribir en el archivo
                FileWriter escribir = new FileWriter(archivo, true);
                //Escribimos en el archivo con el metodo write 
                escribir.write("\n"+fecha+"     ");
                escribir.write(n1.nombre+"   ");
                if(n1.gana){
                    escribir.write("Ganador");
                }else{
                    escribir.write("No ganador");
                }
                escribir.write("     "+n2.nombre+"   ");
                if(n2.gana){
                    escribir.write("Ganador");
                }else{
                    escribir.write("No ganador");
                }
                //Cerramos la conexion
                escribir.close();
            } //Si existe un problema al escribir
            catch (Exception e) {
                System.out.println("Error al escribir");
            }
    }//FIN DE JUGAR

    /**
     * Metodo para buscar una pieza en el tablero
     * @param arreglo El tablero
     * @param buscado   el nombre de la pieza buscada
     * @return boolean Verdadero si la pieza esta en el tablero, falso en otro caso
     */
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
    }//FIN DE BUSCAR

    /**
     * Metodo para buscar un entero en un arreglo
     * @param arreglo El arreglo donde se busca
     * @param buscado El numero a buscar
     * @return int La posicion en la que se encuentra el numero. Si no se encuentra, regresa -1
     */
    public static int buscarNum(int[] arreglo, int buscado) {
        int m = -1;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == buscado) {
                m = i;
            }
        }
        return m;
    }//FIN DE BUSCAR NUM

    /**
     * Metodo que regresa las coordenadas de la posicion de una pieza en el tablero
     * @param arreglo El tablero donde se busca
     * @param b La pieza a buscar
     * @return  int[] En la posicion 0 se regresa la coordenada x y en la posicion 1 se regresa la coordenada y
     */
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
    }//FIN DE REGRESAR POS PIEZA

    /**
     * Metodo para hacer las validaciones dependiendo de la pieza a mover
     * @param arreglo El arreglo
     * @param piezas El arreglo con el nombre de las piezas
     * @param numpiezas El arreglo con el numero de cada pieza
     * @param scan1 Un scanner
     * @param scan2 Un scanner
     * @param turnoblanco Si es turno de las piezas blancas o de las negras
     * @param jugador1blanco Jugador 1
     * @param jugador2negro Jugador 2
     * @param tab El tablero
     */
    public static void preguntaymueve(Pieza[][] arreglo, String[] piezas, int[] numpiezas, Scanner scan1,
            Scanner scan2, boolean turnoblanco, String jugador1blanco, String jugador2negro, Tablero tab) {

        Random random =new Random();
        //int w = 0;
        int m;
        int k;
        boolean x = true;

        if (turnoblanco) {
            System.out.println("\nTurno de " + jugador1blanco + "\n");
        } else {
            System.out.println("\nTurno de " + jugador2negro + "\n");
        }
            // se repite la pregunta hasta que se responda con una pieza valida

            pieza: do {

                boolean esta =false;
                String pzElegida = "";
                if(jugador2negro.equals("Computadora")&&!turnoblanco){

                }else{
                    tab.visualizarTablero();
                    //System.out.println(tab.visualizarTablero());
                }
                //System.out.println(visualizarTablero(arreglo));
                if(jugador2negro.equals("Computadora") && !turnoblanco){
                    String [] pzas = {"torre1negro","torre2negro","caballo1negro","caballo2negro","reina1negro","rey1negro","peon1negro","peon2negro","peon3negro","peon4negro","peon5negro","peon6negro"}; 
                    int numRandom = random.nextInt(12);
                    pzElegida = pzas[numRandom];
                    System.out.println(pzElegida); //////////////////////////////////////////////////////////////////////7
                    esta = buscar(arreglo, pzElegida);
                }else{
                System.out.println("Pieza a mover: (Ingresa nombre completo)"); // Pregunta pieza
                pzElegida = scan1.nextLine().strip().toLowerCase();;// Guarda respuesta
                esta = buscar(arreglo, pzElegida); // Busca si la pieza esta en el tablero
                }

                // si la pieza esta en el tablero
                outerloop: if (esta) {

                    int[] arr = regresarPosPieza(arreglo, pzElegida); // arrreglo con las coordenadas de la posicion de
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

                        String tipoPz = arreglo[arr[0]][arr[1]].tipo;
                        int columna = -1;
                        int fila = -1;

                        boolean y = true;
                        while (y) {// trycatch
                            if(jugador2negro.equals("Computadora")&&!turnoblanco){
                                int[] elegidos = calculaMov(tipoPz, arr, random);
                                fila = elegidos[0];
                                columna = elegidos[1];
                                System.out.println("("+fila+","+columna+")");/////////////////////////////////////////////////
                            }else{
                                boolean z=true;
                                do{
                                    System.out.println("Ingresa el numero de columna(0-5 de izquierda a derecha)");
                                    try{
                                        columna = scan2.nextInt();
                                        z=false;
                                    }catch(Exception e){
                                        System.out.println("Respuesta no valida");
                                    }
                                    
                                }while(z);
                                z=true;
                                do{
                                    System.out.println("Ingresa el numero de fila(0-5 de arriba a abajo)");
                                    try{
                                        fila = scan2.nextInt();
                                        z=false;
                                    }catch(Exception e){
                                        System.out.println("Respuesta no valida");
                                    }
                                }while(z);       
                            }
                            if (fila < 0 || fila > 5|| columna < 0 || columna > 5) { //Verifica si el numero esta dentro del rango del tablero
                                if(jugador2negro.equals("Computadora")&&!turnoblanco){
                                    System.out.println("Calculando posicion");
                                }else{
                                    System.out.println("Coordenadas no validas");
                                }    
                            } else {
                                y = false;
                            }
                        }

                        // Dependiendo el tipo de pieza, hacemos las validaciones correspondientes
                        switch (tipoPz) {
                            case "torre":
                                Torre torr = (Torre) arreglo[arr[0]][arr[1]];
                                // System.out.println("Por validar");
                                if (torr.validarMov(fila, columna, arreglo, piezas, numpiezas)) {
                                    x = false;
                                    break pieza;
                                } else {
                                    if(jugador2negro.equals("Computadora")&&!turnoblanco){
                                    }else{
                                        System.out.println("\nMovimiento no valido\n");
                                    }   
                                }
                                break;
                            case "caballo":
                                Caballo cab = (Caballo) arreglo[arr[0]][arr[1]];
                                if (cab.validarMov(fila, columna, arreglo, piezas, numpiezas)) {
                                    x = false;
                                    break pieza;
                                } else {
                                    if(jugador2negro.equals("Computadora")&&!turnoblanco){
                                    }else{
                                        System.out.println("\nMovimiento no valido\n");
                                    } 
                                }
                                break;
                            case "rey":
                                Rey rey = (Rey) arreglo[arr[0]][arr[1]];
                                if (rey.validarMov(fila, columna, arreglo, piezas, numpiezas)) {
                                    x = false;
                                    break pieza;
                                } else {
                                    if(jugador2negro.equals("Computadora")&&!turnoblanco){
                                    }else{
                                        System.out.println("\nMovimiento no valido\n");
                                    } 
                                }
                                break;
                            case "reina":
                                Reina reina = (Reina) arreglo[arr[0]][arr[1]];
                                if (reina.validarMov(fila, columna, arreglo, piezas, numpiezas)) {
                                    x = false;
                                    break pieza;
                                } else {
                                    if(jugador2negro.equals("Computadora")&&!turnoblanco){
                                    }else{
                                        System.out.println("\nMovimiento no valido\n");
                                    } 
                                }
                                break;
                            case "peon":
                                Peon peon = (Peon) arreglo[arr[0]][arr[1]];
                                if (peon.validarMov(fila, columna, arreglo, piezas, numpiezas)) {
                                    x = false;

                                    // Si el peon esta en la ultima fila
                                    if (peon.coordenadaX == 5 || peon.coordenadaX == 0) {

                                        String r = "";

                                        if(jugador2negro.equals("Computadora")&&!turnoblanco){
                                            boolean g = random.nextBoolean();
                                            if(g){
                                                r = "reina";
                                            }else{
                                                r = "caballo";
                                            }
                                        }else{
                                            // Se repetira hasta que la respuesta sea torre, caballo o reina
                                            boolean s = true;
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
                                        }
                                        
                                        // Peon promocion = (Peon) arreglo[arr[0]][arr[1]];
                                        Pieza nueva = peon.promover(r, arreglo, piezas, numpiezas);
                                        String t = nueva.tipo;
                                        int xx=nueva.coordenadaX;
                                        int yy=nueva.coordenadaY;
                                        String c = nueva.color;
                                        int num = nueva.numero;
                                        arreglo[xx][yy]=null;
                                        switch(t){
                                            case "torre":
                                                Torre nt= new Torre(xx,yy,c,num);
                                                arreglo[xx][yy]=nt;
                                            break;
                                            case "reina":
                                                Reina nr=new Reina(xx,yy,c,num);
                                                arreglo[xx][yy]=nr;
                                            break;
                                            case "caballo":
                                                Caballo nc=new Caballo(xx,yy,c,num);
                                                arreglo[xx][yy]=nc;
                                            break;
                                        }
                                    }
                                    break pieza;
                                } else {
                                    if(jugador2negro.equals("Computadora")&&!turnoblanco){
                                    }else{
                                        System.out.println("\nMovimiento no valido\n");
                                    } 
                                }
                                break;
                            default:
                        }
                    } else {
                        if(jugador2negro.equals("Computadora")&&!turnoblanco){
                        }else{
                            System.out.println("\nPieza no valida\n");
                        } 
                    }
                } else {
                    if(jugador2negro.equals("Computadora")&&!turnoblanco){
                    }else{
                        System.out.println("\nPieza no valida\n");
                    } 
                }
            } while (x);
    }//FIN DE PREGUNTA Y MUEVE

    /**
     * Menu de opciones
     */
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nExtintion Chess\n***Menu***");
        System.out.println("Selecciona una opcion (Ingresa la letra)");
        System.out.println("\n(I) Ver instrucciones");
        System.out.println("(J) Jugar");
        System.out.println("(P) Participantes recientes");// 3 participante de menor a mayor
        System.out.println("(S) Salir");
        boolean h = true;
        do {
            String respuesta = sc.nextLine().strip().toLowerCase();
            sw: switch (respuesta) {
                case "i":
                    // imprimir instrucciones
                    try{
                        File f = new File ("Reglas.txt");
                        Scanner s = new Scanner(f);
                        while (s.hasNextLine()){
                            System.out.println(s.nextLine());
                        }
                        System.out.println("\nPresione cualquier tecla seguida de enter para volver al menu");
                        sc.next();
                        menu();
                        //s.close();
                    }catch(FileNotFoundException e){
                        System.out.println("El archivo no existe");
                    }
                    h = false;
                    break;
                case "p":
                    try{
                        File f = new File ("juego.txt");
                        Scanner s = new Scanner(f);
                        System.out.println(tail(f, 3));
                    }catch(FileNotFoundException e){
                        System.out.println("No hay jugadores recientes");
                    }
                    finally{
                        System.out.println("\nPresione cualquier tecla seguida de enter para volver al menu");
                        sc.next();
                        menu();
                    }
                    h = false;
                    break;
                case "s":
                    h = false;
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                case "j":
                    int mov = seleccionarNivel();
                    String jugador1;
                    String jugador2="";
                    boolean comp=true;
                    do{
                        System.out.println("Jugar con computadora(si/no)");
                        String compu = sc.nextLine().strip().toLowerCase();
                        if(compu.equals("si")){
                            jugador2 = "Computadora";
                            comp = false;
                        }else if(compu.equals("no")){
                            System.out.println("Ingresa el nombre del jugador2");
                            jugador2=sc.nextLine();
                            comp=false;
                        }else{
                            System.out.println("Respuesta no valida");
                        }

                    }while(comp);
                    
                    System.out.println("Ingresa el nombre del jugador1");
                    jugador1=sc.nextLine();
                    
                    jugar(mov,jugador1,jugador2);
                    System.exit(0);
                    break;
                default:
                    break sw;
            }
        } while (h);
    }//FIN DE MENU

    /**
     * Metodo para imprimir las ultimas 3 lineas del archivo con datos de los jugadores
     * @param file El archivo a leer
     * @param lines El numero de lineas a leer desde el final
     * @return Lineas del archivo
     */
    public static String tail(File file, int lines) { 
        RandomAccessFile fileHandler = null; 
        try { 
            fileHandler = new java.io.RandomAccessFile( file, "r" ); 
            long fileLength = fileHandler.length() - 1; 
            StringBuilder sb = new StringBuilder(); 
            int line = 0; 
            for(long filePointer = fileLength; filePointer != -1; filePointer--){ 
                fileHandler.seek( filePointer ); 
                int readByte = fileHandler.readByte(); 
                if( readByte == 0xA ) { 
                    if (filePointer < fileLength) { 
                        line = line + 1; } 
                } else if( readByte == 0xD ) { 
                    if (filePointer < fileLength-1) { 
                        line = line + 1; 
                    }      
                }
                if (line >= lines) { 
                    break; 
                } 
                sb.append( ( char ) readByte ); 
            } 
            String lastLine = sb.reverse().toString(); 
            return lastLine; 
        } catch(FileNotFoundException e ) { 
            e.printStackTrace(); 
            return null; 
        } catch(IOException e ) { 
            e.printStackTrace(); return null; 
        } finally { 
            if (fileHandler != null ) 
            try { 
                fileHandler.close(); 
            } catch (IOException e) { 
            } 
        } 
    }//FIN DE TAIL

    /**
     * Metodo para calcular movimmientos posibles dependiendo del tipo de pieza
     * @param tipoPz el nombre del tipo de pieza
     * @param arr El arreglo con la posicion de la pieza en el tablero
     * @param random Un random
     * @return  int[] arreglo con las posiciones elegidas. En la posicion 0 esta la coordenada x y en 1 esta la coordenada y
     */
    public static int[] calculaMov(String tipoPz, int[] arr, Random random){
        int[] posicionesElegidas = new int[2];
        int randomcol;
        int randomreng;
        switch (tipoPz){
            case "torre":
                boolean arrabderizq=random.nextBoolean();//verdadero se mueve a los lados, si falso arriba abajo
                boolean masmenos =random.nextBoolean();
                int numpos=random.nextInt(6);
                if(arrabderizq){
                    posicionesElegidas[0]=arr[0];
                    if(masmenos){
                        posicionesElegidas[1]=arr[1]+numpos;
                    }else{
                        posicionesElegidas[1]=arr[1]-numpos;
                    }
                }else{
                    posicionesElegidas[1]=arr[1];
                    if(masmenos){
                        posicionesElegidas[0]=arr[0]+numpos;
                    }else{
                        posicionesElegidas[0]=arr[0]-numpos;
                    }
                }
            break;
            case "caballo":
                int x;
                int y;
                int signo = random.nextInt(3);
                boolean unodos = random.nextBoolean();
                if(unodos){
                    x=1;
                    y=2;
                }else{
                    x=2;
                    y=1;
                }
                switch(signo){
                    case 0:
                        x=-x;
                    break;
                    case 1:
                        y=-y;
                    break;
                    case 2:
                        x=-x;
                        y=-y;
                    break;
                    default:
                    break;
                }
            break;
            case "rey":
                
                do{
                    randomcol = random.nextInt(3);
                    randomreng = random.nextInt(3);
                }while(randomcol==0&&randomreng==0);

                if(randomcol==2){
                    posicionesElegidas[1] = arr[1]-1;
                }else{
                    posicionesElegidas[1] = arr[1]+randomcol;
                }
                if(randomreng==2){
                    posicionesElegidas[0] = arr[0]-1;
                }else{
                    posicionesElegidas[0] = arr[0]+randomcol;
                }
            break;
            case "reina":
                boolean horverdiag = random.nextBoolean();
                if(horverdiag){
                boolean aabderizq=random.nextBoolean();//verdadero se mueve a los lados, si falso arriba abajo
                boolean menosmas =random.nextBoolean();
                int posnum=random.nextInt(6);
                if(aabderizq){
                    posicionesElegidas[0]=arr[0];
                    if(menosmas){
                        posicionesElegidas[1]=arr[1]+posnum;
                    }else{
                        posicionesElegidas[1]=arr[1]-posnum;
                    }
                }else{
                    posicionesElegidas[1]=arr[1];
                    if(menosmas){
                        posicionesElegidas[0]=arr[0]+posnum;
                    }else{
                        posicionesElegidas[0]=arr[0]-posnum;
                    }
                }
                }else{
                    int posqueen = random.nextInt(5);
                    boolean siggueen=random.nextBoolean();
                    if(siggueen){
                        posqueen=-posqueen;
                    }
                    posicionesElegidas[0]=arr[0]+posqueen;
                    posicionesElegidas[1]=arr[1]+posqueen;
                }
            break;
            case "peon":
                posicionesElegidas[0] = arr[0]-1;
                randomcol = random.nextInt(3);
                if(randomcol==2){
                    posicionesElegidas[1] = arr[1]-1;
                }else{
                    posicionesElegidas[1] = arr[1]+randomcol;
                }
            break;
        }
        return posicionesElegidas;
    }//FIN DE CALCULA MOV
}