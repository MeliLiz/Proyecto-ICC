//se mueve por filas y columnas
public class Torre extends Pieza {

    // Método constructor
    public Torre(int x, int y, String color, int num) {
        super(x, y, "torre", color, num);
    }

    // Método que valida si el movimiento está en el rango permitido según la torre
    public boolean validarMov(int cx, int cy) {
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
                System.out.println("3");
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
            System.out.println("5");
            return false;
        }
    }

    // regresa 1 si se pudo mover la pieza, 2 si hay una pieza del mismo color y 3
    // hay pieza del otro color
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

    // Validación completa del movimiento
    public boolean validar(int cx, int cy, Pieza[][] arreglo, String[] piezas, int[] numpiezas) {
        if (validarMov(cx, cy)) {
            if (movSinEstorbo(cx, cy, arreglo)) {
                if (hayPieza(cx, cy, arreglo) == 2) {
                    System.out.println("haypzdel mismo color");
                    return false;
                } else if (hayPieza(cx, cy, arreglo) == 3) {
                    reemplaza(cx, cy, arreglo, piezas, numpiezas);
                    System.out.println("haypzde dif color color");
                    return true;
                } else {
                    System.out.println("else");
                    return true;
                }
            } else {
                System.out.println("otro else");
                return false;
            }
        } else {
            System.out.println("regresa false");
            return false;
        }
    }
}