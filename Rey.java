//todas direcciones una casilla a la vez
public class Rey extends Pieza {
    public Rey(int x, int y, String color, int num) {
        super(x, y, "rey", color, num);
    }

    // Método que valida si el movimiento del peón es válido y de serlo mueve la
    // pieza y come
    public boolean validarMov(int cx, int cy, Pieza[][] arreglo, String[] piezas, int[] numpiezas) {
        if ((cy == coordenadaY + 1 && cx == coordenadaX) || (cy == coordenadaY - 1 && cx == coordenadaX)
                || (cx == coordenadaX + 1 && cy == coordenadaY) || (cx == coordenadaX - 1 && cy == coordenadaY)) {
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