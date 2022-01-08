//se mueve por filas y columnas
public class Torre extends Pieza{

    public Torre(int x, int y, String color, int num){
        super(x, y, "torre", color, num);
    }

    public boolean mover(){
        int x =getCoordenadaX();
        int y = getCoordenadaY();
    }


    public boolean validarPieza(Torre torre, int cx, int cy){
        if (torre.activa){
            return true;
        }else{
            return false;
        }
    }

    public boolean validarMov(int cx, int cy){
        int coordX = this.coordenadaX;
        int coordY = this.coordenadaY;
        if((coordX == cx && coordY!=cy)||(coordX!=cx && coordY==cy)){
            return true;
        }else{
            return false;
        }
    }

    public int[] movimientosValidos(int cx, int cy){
            int[] movimientos = {0,1,2,3,4};
            return movimientos; 
    }

    public boolean validar(Torre torre, int cx, int cy){
        
        if(validarPieza(torre, cx, cy) && validarMov(cx, cy)){
            if (coordenadaX==cx){
                int resta = cy-coordenadaY;
                if(resta>0){
                    for(int i=coordenadaY; i<cy; i++){
                        tablero[0][1] = torre;
                    }
                }
            }
        }
    }
}