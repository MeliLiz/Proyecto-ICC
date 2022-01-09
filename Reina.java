//todas direcciones
public class Reina extends Pieza {
    public Reina(int x, int y, String color, int numero) {
        super(x, y, "reina", color, numero);
    }

    /*
     * public boolean validarMov(int cx, int cy){
     * int coordX = this.coordenadaX;
     * int coordY = this.coordenadaY;
     * }
     */

    // Metodo que valida si el movimiento del peon es valido y de serlo mueve la
    // pieza y come
    public boolean validarMov(int cx, int cy, Pieza[][] arreglo) {
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
                    for (int i = cy + 1; i < coordenadaY; i++) {
                        if (arreglo[i][i] != null) {
                            g = false;
                        }
                    }
                    return g;
                } else if (restax < 0 && restay > 0) {
                    boolean g = true;
                    for (int i = coordenadaY + 1; i < cy; i++) {
                        if (arreglo[i][i] != null) {
                            g = false;
                        }
                    }
                    return g;
                } else if (restax > 0 && restay < 0) {
                    boolean g = true;
                    for (int i = cy + 1; i < coordenadaY; i++) {
                        if (arreglo[i][i] != null) {
                            g = false;
                        }
                    }
                    return g;
                } else {// si restax>0&&restay>0
                    boolean g = true;
                    for (int i = coordenadaY + 1; i < cy; i++) {
                        if (arreglo[i][i] != null) {
                            g = false;
                        }
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
    public boolean validar(int cx, int cy, Pieza[][] arreglo, String[] piezas, int[] numpiezas) {
        if (validarMov(cx, cy, arreglo)) {
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