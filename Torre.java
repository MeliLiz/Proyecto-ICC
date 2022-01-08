//se mueve por filas y columnas
public class Torre extends Pieza{

    //Método constructor
    public Torre(int x, int y, String color, int num){
        super(x, y, "torre", color, num);
    }

    //Método que valida si el movimiento está en el rango permitido según la torre
    public boolean validarMov(int cx, int cy){
        int coordX = this.coordenadaX;
        int coordY = this.coordenadaY;
        if((coordX == cx && coordY!=cy)||(coordX!=cx && coordY==cy)){
            return true;
        }else{
            return false;
        }
    }

    //regresa false si hay pieza en el camino y true si no la hay
    public boolean movSinEstorbo(int cx, int cy, Pieza[][] arreglo){
            if (coordenadaX==cx){
                int resta = cy-coordenadaY;
                if(resta>0){
                    boolean n=true;
                    for(int i=coordenadaY; i<cy; i++){
                        if(arreglo[cx][i]!=null){
                            n=false;
                        }
                    }
                    return n;
                } else{ //Si la resta es <0
                    boolean n=true;
                    for(int i=cy;i<coordenadaY;i++){
                        if(arreglo[cx][i]!=null){
                            n=false;
                        }
                    }
                    return n;
                }
            }else if(coordenadaY==cy){
                int resta = cx-coordenadaX;
                if(resta>0){
                    boolean n=true;
                    for (int i=coordenadaX;i<cx;i++){
                        if(arreglo[i][cy]!=null){
                            n=false;
                        }
                    }
                    return n;
                }else{
                    boolean n=true;
                    for(int i=cx; i<coordenadaX;i++){
                        if (arreglo[i][cy]!=null){
                            n = false;
                        }
                    }
                    return n;
                }
            }else{
                return false;
            }
    }

    //regresa 1 si se pudo mover la pieza, 2 si hay una pieza del mismo color y 3 hay pieza del otro color
    public int hayPieza(int cx, int cy, Pieza[][] arreglo){
        if(arreglo[cx][cy]==null){
            mover(cx, cy, arreglo);
            return 1;
        }else{
            if(arreglo[cx][cy].getColor().equals(color)){
                return 2;
            }else{
               return 3;
            }
        }

    }

    //Validación completa del movimiento
    public boolean validar(int cx, int cy, Pieza[][] arreglo, String[] piezas, int[] numpiezas){
        if(validarMov(cx, cy)){
            if(movSinEstorbo(cx, cy, arreglo)){
                mover(cx, cy, arreglo);
                return true;
            }else{
                if(hayPieza(cx, cy, arreglo)==2){
                    return false;
                }else if(hayPieza(cx, cy, arreglo)==3){
                    reemplaza(cx, cy, arreglo, piezas, numpiezas);
                    return true;
                }else{
                    return true;
                }
            }
        }else{
            return false;
        }
    }
}