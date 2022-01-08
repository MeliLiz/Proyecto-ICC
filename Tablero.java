public class Tablero{
    protected Pieza[][] arreglo = new Pieza[6][6];
    protected Torre torre1B;
    protected Torre torre2B;
    protected Torre torre1N;
    protected Torre torre2N;
    protected Caballo caballo1B;
    protected Caballo caballo2B;
    protected Caballo caballo1N;
    protected Caballo caballo2N;
    protected Rey rey1B;
    protected Rey rey1N;
    protected Reina reina1B;
    protected Reina reina1N;
    protected Peon peon1B;
    protected Peon peon2B;
    protected Peon peon3B;
    protected Peon peon4B;
    protected Peon peon5B;
    protected Peon peon6B;
    protected Peon peon1N;
    protected Peon peon2N;
    protected Peon peon3N;
    protected Peon peon4N;
    protected Peon peon5N;
    protected Peon peon6N;


    public Tablero(){
        torre1B = new Torre(0,0,"blanco",1);
        torre2B = new Torre(0,5,"blanco",2);
        torre1N = new Torre(5,0,"negro",1);
        torre2N = new Torre(5,5,"negro",2);
        caballo1B = new Caballo(0,1,"blanco",1);
        caballo2B = new Caballo(0,4,"blanco",2);
        caballo1N = new Caballo(5,1,"negro",1);
        caballo2N = new Caballo(5,4,"negro",2);
        rey1B = new Rey(0,2,"blanco",1);
        rey1N = new Rey(5,2,"negro",1);
        reina1B = new Reina(0,3,"blanco",1);
        reina1N = new Reina(5,3,"negro",1);
        peon1B = new Peon(1,0,"blanco",1);
        peon2B = new Peon(1,1,"blanco",2);
        peon3B = new Peon(1,2,"blanco",3);
        peon4B = new Peon(1,3,"blanco",4);
        peon5B = new Peon(1,4,"blanco",5);
        peon6B = new Peon(1,5,"blanco",6);
        peon1N = new Peon(4,0,"negro",1);
        peon2N = new Peon(4,1,"negro",2);
        peon3N = new Peon(4,2,"negro",3);
        peon4N = new Peon(4,3,"negro",4);
        peon5N = new Peon(4,4,"negro",5);
        peon6N = new Peon(4,5,"negro",6);
    }
    

    public void iniciaTablero(){
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

    public String visualizar(){
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

    public Pieza[][] getArreglo(){
        return arreglo;
    }
}