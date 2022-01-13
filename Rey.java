/**
 * Clase que representa al rey en ajedrez
 * @author Melissa Lizbeth Fernandez Blancas
 * @version 1
 * @see Pieza
 */
public class Rey extends Pieza {
    /**
     * Metodo constructor
     * @param x Coordenada X del rey en el tablero
     * @param y Coordenada Y del rey en el tablero
     * @param color Color de la pieza
     * @param num Num de pieza
     */
    public Rey(int x, int y, String color, int num) {
        super(x, y, "rey", color, num);
    }

    // Método que valida si el movimiento del peón es válido y de serlo mueve la
    // pieza y come
    /**
     * Metodo que valida si el movimiento del rey es valido y de serlo mueve la pieza, en su caso, come a la pieza de distinto color que esta en esa casilla
     * @param cx Coordenada x a donde se quiere mover la pieza
     * @param cy Coordenada y a donde se quiere mover la pieza
     * @param arreglo El tablero
     * @param piezas El arreglo con el nombre de las piezas
     * @param numpiezas El arreglo con el numero de cada pieza
     * @return boolean True si pudo mover la pieza, false en otro caso
     */
    public boolean validarMov(int cx, int cy, Pieza[][] arreglo, String[] piezas, int[] numpiezas) {
        if ((cy == coordenadaY + 1 && cx == coordenadaX) || (cy == coordenadaY - 1 && cx == coordenadaX)
                || (cx == coordenadaX + 1 && cy == coordenadaY) || (cx == coordenadaX - 1 && cy == coordenadaY)||(cx == coordenadaX +1 && cy == coordenadaY+1)||(cx == coordenadaX + 1 && cy == coordenadaY-1)||(cx == coordenadaX - 1 && cy == coordenadaY+1)||(cx == coordenadaX - 1 && cy == coordenadaY-1)) {
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

}