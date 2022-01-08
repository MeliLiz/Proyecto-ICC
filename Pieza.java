public class Pieza{
    protected int coordenadaX;
    protected int coordenadaY;
    protected String tipo;
    protected String color;
    protected boolean activa;
    protected int numero;
    protected int numMov;

    public Pieza(int xc, int yc, String tipo, String color){
        setCoordenadaX(xc);
        setCoordenadaY(yc);
        setTipo(tipo);
        setColor(color);
        activa = true;
        numMov = 0;
    }

    public Pieza(int xc, int yc, String tipo, String color, int num){
        setCoordenadaX(xc);
        setCoordenadaY(yc);
        setTipo(tipo);
        setColor(color);
        setNumero(num);
        activa = true;
        numMov = 0;
    }

    public void setNumMov(int n){
        if(n<0){
            //error
        }else{
            numMov = n;
        }
    }

    public void setNumero(int num){
        if(num>0 && num<9){
            numero = num;
        }else{
            throw new RuntimeException("Numero no valido");
        }
    }

    public int getNumero(){
        return numero;
    }

    public void setCoordenadaX(int x){
        if(x<6 && x>=0){
            coordenadaX=x;
        }else{
                throw new RuntimeException("Coordenada x no valida");
            
            
        }
    }

    public void setCoordenadaY(int y){
        if(y<6 && y>=0){
            coordenadaY=y;
        }else{
            try{
                throw new RuntimeException();
            }catch(RuntimeException e){
                System.out.println("Coordenada no valida");
            }
        }
    }

    public void setTipo(String tipo){
        tipo = tipo.strip().toLowerCase();
        if(tipo.equals("torre")||tipo.equals("rey")||tipo.equals("reina")||tipo.equals("peon")||tipo.equals("caballo")){
            this.tipo=tipo;
        }else{
            try{
                throw new RuntimeException();
            }catch(RuntimeException e){
                System.out.println("Tipo no valido");
            }
        }
    }

    public void setColor(String color){
        color = color.strip().toLowerCase();
        if(color.equals("blanco")||color.equals("negro")){
            this.color=color;
        }else{
            try{
                throw new RuntimeException();
            }catch(RuntimeException e){
                System.out.println("Color no valido");
            }
        }
    }

    public void setActividad(boolean activo){
        activa = activo;
    }

    public int getCoordenadaX(){
        return coordenadaX;
    }

    public int getCoordenadaY(){
        return coordenadaY;
    }

    public String getTipo(){
        return tipo;
    }

    public String getColor(){
        return color;
    }

    public boolean getActividad(){
        return activa;
    }

    public int getNumPieza(){
        return numero;
    }

    public int getNumMov(){
        return numMov;
    }

    public String toString(){
        return tipo + numero + color; 
    }


    public boolean equals(Object pieza){
        Pieza pz = (Pieza) pieza;
        return coordenadaX==pz.coordenadaX && coordenadaY==pz.coordenadaY&& tipo.equals(pz.tipo)&& color.equals(pz.color)&& activa==pz.activa;
    }

    public boolean validarPieza(){
        if (this.activa){
            return true;
        }else{
            return false;
        }
    }

    //Metodo para mover una pieza
    public void mover(int cx, int cy, Pieza[][] arreglo){
        int x = getCoordenadaX();
        int y = getCoordenadaY();
        setCoordenadaX(cx);
        setCoordenadaY(cy);
        arreglo[cx][cy] = arreglo[x][y];
        arreglo[x][y]=null;
        numMov+=1;
    }

    //requiere la matriz el arreglo con el nombre de las piezas en la forma caballoblanco y el arreglo con el numero de piezas que coinsida con el nombre
    public void reemplaza(int cx, int cy, Pieza[][] arreglo, String[] piezas, int[] numpiezas){
        String nombre = arreglo[cx][cy].tipo +arreglo[cx][cy].color;
        numpiezas[buscar(piezas, nombre)]-=1;
        arreglo[cx][cy].setActividad(false);
        //ver pieza, color, restar piezas, quitar actividad de la pieza   arreglo con nombre y color
        mover(cx,cy,arreglo);
    }

    //Busca un String en un arreglo
    public static int buscar(String[] arreglo, String buscado){
        int m=0;
        for(int i=0; i<arreglo.length; i++){
            if(arreglo[i].equals(buscado)){
                m=i;
            }
        }
        return m;
    }

}