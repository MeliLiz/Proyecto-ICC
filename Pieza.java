public class Pieza{
    protected int coordenadaX;
    protected int coordenadaY;
    protected String tipo;
    protected String color;
    protected boolean activa;
    protected int numero;

    public Pieza(int xc, int yc, String tipo, String color){
        setCoordenadaX(xc);
        setCoordenadaY(yc);
        setTipo(tipo);
        setColor(color);
        activa = true;
    }

    public Pieza(int xc, int yc, String tipo, String color, int num){
        setCoordenadaX(xc);
        setCoordenadaY(yc);
        setTipo(tipo);
        setColor(color);
        setNumero(num);
        activa = true;
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

}