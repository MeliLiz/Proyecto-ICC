//en L, 2 horizontal, 1 vertical. Puede saltar sobre cualquier pieza
public class Caballo extends Pieza{

    public Caballo(int x, int y, String color, int num){
        super(x, y, "caballo", color, num);
    }

    /*public boolean validarMov(int cx, int cy){
        int coordX = this.coordenadaX;
        int coordY = this.coordenadaY;
    }*/

    public boolean validarMov(int cx, int cy,Pieza[][] arreglo, String [] piezas, int[] numpiezas){
        if ((cx==coordenadaX+2 && cy==coordenadaY+1)||(cx==coordenadaX+2 && cy==coordenadaY-1)||(cx==coordenadaX-2 && cy==coordenadaY+1)||(cx==coordenadaX-2 && cy==coordenadaY-1)||(cx==coordenadaX+1 && cy==coordenadaY+2)||(cx==coordenadaX+1 && cy==coordenadaY-2)||(cx==coordenadaX-1 && cy==coordenadaY+2)||(cx==coordenadaX-1 && cy==coordenadaY-2)){
            if(sePudoMover(cx, cy, arreglo)){
                return true;
            }else{
                if(arreglo[cx][cy].color.equals(color)){
                    return false;
                }else{
                    reemplaza(cx, cy, arreglo, piezas, numpiezas);
                    return true;
                }
            }
        }else{
            return false;
        }
    }
    
    //regresa 1 si se pudo mover la pieza, 2 si no se puede mover
    public boolean sePudoMover(int cx, int cy, Pieza[][] arreglo){
        if(arreglo[cx][cy]==null){
            mover(cx, cy, arreglo);
            return true;
        }else{
            return false;
        }

    }
}