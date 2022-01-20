public class Tablero{
    protected Pieza[][] arreglo = new Pieza[6][6];
    /*Torre torre1B;
    Torre torre2B;
       Torre torre1N;
       Torre torre2N;
       Caballo caballo1B;
       Caballo caballo2B;
       Caballo caballo1N;
       Caballo caballo2N;
       Rey rey1B;
       Rey rey1N;
       Reina reina1B;
       Reina reina1N;
       Peon peon1B;
       Peon peon2B;
       Peon peon3B;
       Peon peon4B;
       Peon peon5B;
       Peon peon6B;
       Peon peon1N;
       Peon peon2N;
       Peon peon3N;
       Peon peon4N;
       Peon peon5N;
       Peon peon6N;*/


    public Tablero(){
        /*Torre torre1B = new Torre(0,0,"blanco",1);
        Torre torre2B = new Torre(0,5,"blanco",2);
        Torre torre1N = new Torre(5,0,"negro",1);
        Torre torre2N = new Torre(5,5,"negro",2);
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
        Peon peon6N = new Peon(4,5,"negro",6);*/
        Pieza torre1B = new Torre(0,0,"blanco",1);
        Pieza torre2B = new Torre(0,5,"blanco",2);
        Pieza torre1N = new Torre(5,0,"negro",1);
        Pieza torre2N = new Torre(5,5,"negro",2);
        Pieza caballo1B = new Caballo(0,1,"blanco",1);
        Pieza caballo2B = new Caballo(0,4,"blanco",2);
        Pieza caballo1N = new Caballo(5,1,"negro",1);
        Pieza caballo2N = new Caballo(5,4,"negro",2);
        Pieza rey1B = new Rey(0,2,"blanco",1);
        Pieza rey1N = new Rey(5,2,"negro",1);
        Pieza reina1B = new Reina(0,3,"blanco",1);
        Pieza reina1N = new Reina(5,3,"negro",1);
        Pieza peon1B = new Peon(1,0,"blanco",1);
        Pieza peon2B = new Peon(1,1,"blanco",2);
        Pieza peon3B = new Peon(1,2,"blanco",3);
        Pieza peon4B = new Peon(1,3,"blanco",4);
        Pieza peon5B = new Peon(1,4,"blanco",5);
        Pieza peon6B = new Peon(1,5,"blanco",6);
        Pieza peon1N = new Peon(4,0,"negro",1);
        Pieza peon2N = new Peon(4,1,"negro",2);
        Pieza peon3N = new Peon(4,2,"negro",3);
        Pieza peon4N = new Peon(4,3,"negro",4);
        Pieza peon5N = new Peon(4,4,"negro",5);
        Pieza peon6N = new Peon(4,5,"negro",6);
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
    }

    /**
     * Metodo para imprimir el tablero
     */
    public void visualizarTablero() {
        System.out.println();
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(i+"   ");
            for (int j = 0; j < arreglo[0].length; j++) {
                if (arreglo[i][j] == null) {
                    System.out.print("----(" + j + "," + i + ")---- " + "   ");
                } else {
                    System.out.print(arreglo[i][j] + "   ");
                }
            }
            System.out.println("\n");
        }
        int[] num = {0,1,2,3,4,5};
        System.out.print("    ");
        for(int i=0;i<num.length;i++){
            System.out.print("    "+i+"   ");
            System.out.print("         ");
        }
        System.out.println("\n");
        //return " ";
    }//FIN DE VISUALIZAR TABLERO
    

    /*public void iniciaTablero(){
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
    }*/

    /*public String visualizar(){
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
    }*/

    public Pieza[][] getTablero(){
        return arreglo;
    }
}