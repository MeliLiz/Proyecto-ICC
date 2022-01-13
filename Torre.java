/**
 * Clase Torre que represenata una torre en ajedrez
 * @author Melissa Lizbeth Fernandez Blancas
 * @version 1
 * @see Pieza
 */
//se mueve por filas y columnas
public class Torre extends Pieza {

    /**
     * Metodo constructor
     * @param x Coordenada X
     * @param y Coordenada Y
     * @param color Color de la pieza
     * @param num Numero de pieza
     */
    public Torre(int x, int y, String color, int num) {
        super(x, y, "torre", color, num);
    }

    /**
     * Metodo que  valida si el movimiento esta en el rango de movimiento permitido segun la torre
     * @param cx Coordenada x a mmover la pieza
     * @param cy Coordenada y a mover la pieza
     * @return boolean True si es una posicion permitida, false en otro caso
     */
    public boolean validar(int cx, int cy) {
        int coordX = this.coordenadaX;
        int coordY = this.coordenadaY;
        if ((coordX == cx && coordY != cy) || (coordX != cx && coordY == cy)) {
            // System.out.println("V");
            return true;
        } else {
            // System.out.println("f");
            return false;
        }
    }

    // regresa false si hay pieza en el camino y true si no la hay
    /**
     * Metodo que nos permite saber si hay piezas en el camino
     * @param cx Coordenada x a mover la torre
     * @param cy Coordenada y a mover la torre
     * @param arreglo El tablero
     * @return boolean  Regresa true si no hay piezas entre la posicion actual de la torre y la nueva posicion dada
     */
    public boolean movSinEstorbo(int cx, int cy, Pieza[][] arreglo) {
        if (this.coordenadaX == cx) {
            int resta = cy - this.coordenadaY;
            if (resta > 0) {
                boolean n = true;
                for (int i = this.coordenadaY + 1; i < cy; i++) {
                    if (arreglo[cx][i] != null) {
                        n = false;
                    }
                }
                // System.out.println("1");
                return n;
            } else { // Si la resta es <0
                boolean n = true;
                for (int i = cy + 1; i < this.coordenadaY; i++) {
                    if (arreglo[cx][i] != null) {
                        n = false;
                    }
                }
                // System.out.println("2");
                return n;
            }
        } else if (this.coordenadaY == cy) {
            int resta = cx - this.coordenadaX;
            if (resta > 0) {
                boolean n = true;
                for (int i = this.coordenadaX + 1; i < cx; i++) {
                    // System.out.println(arreglo[i][cy]);
                    if (arreglo[i][cy] != null) {
                        n = false;
                        // System.out.println("pasa");
                    }
                }
                //System.out.println("3");
                System.out.println(n);
                return n;
            } else {
                boolean n = true;
                for (int i = cx + 1; i < this.coordenadaX; i++) {
                    if (arreglo[i][cy] != null) {
                        n = false;
                    }
                    // System.out.println(n);
                }
                // System.out.println("4");
                return n;
            }
        } else {
            //System.out.println("5");
            return false;
        }
    }

    // regresa 1 si se pudo mover la pieza, 2 si hay una pieza del mismo color y 3
    // hay pieza del otro color
    /**
     * Metodo para saber si hay una pieza en la coordenada destino de la torre. Si no la hay, mueve a la torre.
     * @param cx Nueva coordenada X
     * @param cy Nueva coordenada y
     * @param arreglo Tablero
     * @return int Regresa 1 se se pudo mover la pieza, 2 si hay un a pieza del misco color en la nueva coordenada y 3 si hay pieza de diferente color en la nueva coordenada
     */
    public int hayPieza(int cx, int cy, Pieza[][] arreglo) {
        if (arreglo[cx][cy] == null) {
            mover(cx, cy, arreglo);
            return 1;
        } else {
            if (arreglo[cx][cy].getColor().equals(this.color)) {
                return 2;
            } else {
                return 3;
            }
        }

    }

    /**
     * Metodo que valida el movimiento, de ser posible mueve la pieza o come a la pieza de distinto color que esta en la nueva coordenada
     * Validacion completa del movimiento
     * @param cx Nueva coordenada X
     * @param cy Nueva coordenada Y 
     * @param arreglo El tablero
     * @param piezas Arreglo con el nombre de las piezas
     * @param numpiezas Arreglo con el numero de cada pieza
     * @return boolean True si el movimiento es valido y movio o reemplazo otra pieza. False en otro caso
     */
    public boolean validarMov(int cx, int cy, Pieza[][] arreglo, String[] piezas, int[] numpiezas) {
        if (validar(cx, cy)) {
            if (movSinEstorbo(cx, cy, arreglo)) {
                if (hayPieza(cx, cy, arreglo) == 2) {
                    //System.out.println("haypzdel mismo color");
                    return false;
                } else if (hayPieza(cx, cy, arreglo) == 3) {
                    reemplaza(cx, cy, arreglo, piezas, numpiezas);
                    //System.out.println("haypzde dif color color");
                    return true;
                } else {
                    //System.out.println("else");
                    return true;
                }
            } else {
                //System.out.println("otro else");
                return false;
            }
        } else {
            //System.out.println("regresa false");
            return false;
        }
    }
}