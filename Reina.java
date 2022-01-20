/**
 * Clase que representa a la reina de Ajedrez
 * @author Melissa Lizbeth Fernandez Blancas
 * @version 1
 * @see Pieza
 */
public class Reina extends Pieza {

    /**
     * Metodo constructor
     * @param x La coordenada X
     * @param y La coordenada Y
     * @param color El color de la pieza
     * @param numero El numero de pieza
     */
    public Reina(int x, int y, String color, int numero) {
        super(x, y, "reina", color, numero);
    }

    /**
     * Metodo que valida el movimiento del peon. 
     * @param cx Coordenada x de la posicion a donde se movera la pieza
     * @param cy Coordenada y de la posicion a donde se movera la pieza
     * @param arreglo El tablero
     * @return boolean Si el movimiento es valido, regresa true, en otro caso false
     */
    public boolean validar(int cx, int cy, Pieza[][] arreglo) {
        if ((cy == coordenadaY && cx != coordenadaX) || (cx == coordenadaX && cy != coordenadaY)
                || (Math.abs(coordenadaX - cx) == Math.abs(coordenadaY - cy))) {
            // Ver si hay fichas hasta una casilla antes de la deseada
            // Caso2
            if (coordenadaX == cx && cy != coordenadaY) {
                int resta = cy - coordenadaY;
                if (resta > 0) {
                    boolean n = true;
                    for (int i = coordenadaY + 1; i < cy; i++) {
                        if (arreglo[cx][i] != null) {
                            n = false;
                        }
                    }
                    return n;
                } else { // Si la resta es <0
                    boolean n = true;
                    for (int i = cy + 1; i < coordenadaY; i++) {
                        if (arreglo[cx][i] != null) {
                            n = false;
                        }
                    }
                    return n;
                }
            } else if (coordenadaY == cy && coordenadaX != cx) { // Caso 1
                int resta = cx - coordenadaX;
                if (resta > 0) {
                    boolean n = true;
                    for (int i = coordenadaX + 1; i < cx; i++) {
                        if (arreglo[i][cy] != null) {
                            n = false;
                        }
                    }
                    return n;
                } else {
                    boolean n = true;
                    for (int i = cx + 1; i < coordenadaX; i++) {
                        if (arreglo[i][cy] != null) {
                            n = false;
                        }
                    }
                    return n;
                }
            } else if ((Math.abs(coordenadaX - cx) == Math.abs(coordenadaY - cy))) {
                int restax = cx - coordenadaX;
                int restay = cy - coordenadaY;
                if (restax < 0 && restay < 0) {
                    boolean g = true;
                    int c=1;
                    for (int i = cy + 1; i < coordenadaY; i++) {////////////////////////////////////////////////
                        if (arreglo[cx+c][cy+c] != null) {
                            g = false;
                        }
                        c+=1;
                    }
                    return g;
                } else if (restax < 0 && restay > 0) {///////////////////////////////////////////////////
                    boolean g = true;
                    int c=1;
                    for (int i = coordenadaY + 1; i < cy; i++) {
                        if (arreglo[coordenadaX-c][coordenadaY+c] != null) {
                            g = false;
                        }
                        c+=1;
                    }
                    return g;
                } else if (restax > 0 && restay < 0) {
                    boolean g = true;
                    int c=1;
                    for (int i = cy + 1; i < coordenadaY; i++) {
                        if (arreglo[cx-c][cy+c] != null) {
                            g = false;
                        }
                        c+=1;
                    }
                    return g;
                } else {// si restax>0&&restay>0
                    boolean g = true;
                    int c=1;
                    for (int i = coordenadaY + 1; i < cy; i++) {
                        if (arreglo[coordenadaX+c][coordenadaY+c] != null) {
                            g = false;
                        }
                        c+=1;
                    }
                    return g;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // True si la pieza se mueve, false si no es mov valido
    /**
     * Metodo que mueve a la reina si el movimiento es valido y en su caso come a la pieza del color contrario que esta en la casilla
     * @param cx Coordenada X a mover la pieza
     * @param cy Coordenada Y a mover la pieza
     * @param arreglo El tablero
     * @param piezas El arreglo con el nombre de las piezas
     * @param numpiezas El arreglo con el numero de cada pieza
     * @return boolean Si se pudo mover la pieza regresa true, false en otro caso
     */
    public boolean validarMov(int cx, int cy, Pieza[][] arreglo, String[] piezas, int[] numpiezas) {
        if (validar(cx, cy, arreglo)) {
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

    /**
     * Metodo para representar a la reina en forma de String
     * @return String Representacion en String de la reina
     */
    @Override
    public String toString() {
        if(this.color.equals("blanco")){
            return tipo + numero + color+"  ";
        }else{
            return tipo + numero + color+"   ";
        }   
    }
}