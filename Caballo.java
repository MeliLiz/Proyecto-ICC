/**
 * Clase que representa al caballo de ajedrez
 * @author Melissa Lizbeth Fernández Blancas
 * @version 1
 * @see Pieza
 */
//en L, 2 horizontal, 1 vertical. Puede saltar sobre cualquier pieza
public class Caballo extends Pieza {

    /**
     * Metodo constructor
     * @param x Coordenada x en el tablero
     * @param y Coordenada y en el tablero
     * @param color Color de pieza
     * @param num El numero de caballo
     */
    public Caballo(int x, int y, String color, int num) {
        super(x, y, "caballo", color, num);
    }

    /**
     * Metodo para validar el movimiento del caballo y de ser posible lo mueve o en su caso, reemplaza a la pieza que estaba en ese lugar
     * @param cx Coordenada x a la que se quiere mover el caballo
     * @param cy Coordenada y a la que se quiere mover el caballo
     * @param arreglo El tablero
     * @param piezas El arreglo con el nombre de las piezas
     * @param numpiezas El arreglo con el numero de cada pieza
     * @return  boolean Si el ovimiento es valido regresa verdadero, en otro cas falso
     */
    public boolean validarMov(int cx, int cy, Pieza[][] arreglo, String[] piezas, int[] numpiezas) {
        if ((cx == coordenadaX + 2 && cy == coordenadaY + 1) || (cx == coordenadaX + 2 && cy == coordenadaY - 1)
                || (cx == coordenadaX - 2 && cy == coordenadaY + 1) || (cx == coordenadaX - 2 && cy == coordenadaY - 1)
                || (cx == coordenadaX + 1 && cy == coordenadaY + 2) || (cx == coordenadaX + 1 && cy == coordenadaY - 2)
                || (cx == coordenadaX - 1 && cy == coordenadaY + 2)
                || (cx == coordenadaX - 1 && cy == coordenadaY - 2)) {
            if (sePudoMover(cx, cy, arreglo)) {
                return true;
            } else {
                if (arreglo[cx][cy].color.equals(color)) {
                    return false;
                } else {
                    reemplaza(cx, cy, arreglo, piezas, numpiezas);
                    return true;
                }
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if(this.color.equals("blanco")){
            return tipo + numero + color;
        }else{
            return tipo + numero + color+" ";
        }
            
    }
}