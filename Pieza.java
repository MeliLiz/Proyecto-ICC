/**
 * Clase Pieza que representa a una pieza en el tablero
 * @author Melissa Lizbeth Fernandez Blancas
 * @version 1
 */
public abstract class Pieza {
    //Atributos de las piezas
    protected int coordenadaX;
    protected int coordenadaY;
    protected String tipo;
    protected String color;
    protected boolean activa;
    protected int numero;
    protected int numMov;

    /**
     * Metodo constructor sin el numero de pieza
     * @param xc Coordenada X
     * @param yc Coordenada Y
     * @param tipo Tipo de pieza
     * @param color Color de pieza
     */
    public Pieza(int xc, int yc, String tipo, String color) {
        setCoordenadaX(xc);
        setCoordenadaY(yc);
        setTipo(tipo);
        setColor(color);
        activa = true;
        numMov = 0;
    }

    /**
     * Metodo constructor con el numero de pieza
     * @param xc Coordenada X
     * @param yc Coordenada Y
     * @param tipo Tipo de pieza
     * @param color Color de pieza
     * @param num Numero de pieza
     */
    public Pieza(int xc, int yc, String tipo, String color, int num) {
        setCoordenadaX(xc);
        setCoordenadaY(yc);
        setTipo(tipo);
        setColor(color);
        setNumero(num);
        activa = true;
        numMov = 0;
    }

    /**
     * Metodo para modificar el numero de movimiento
     * @param n El nuevo numero de movimiento
     * @throws NoValidoException Error si el numero es menor a 0
     */
    public void setNumMov(int n) throws NoValidoException {
        if (n < 0) {
            throw new NoValidoException("Numero de movimiento no valido");
        } else {
            numMov = n;
        }
    }

    /**
     * Metodo para modificar el numero de pieza
     * @param num El nuevo numero de pieza
     * @throws NoValidoException Error si el numero de pieza es menor a 1 o mayor a 8
     */
    public void setNumero(int num) throws NoValidoException {
        if (num > 0 && num < 9) {
            numero = num;
        } else {
            throw new NoValidoException("Numero de pieza no valido");
        }
    }

    /**
     * Metodo para obtener el numero de pieza
     * @return int El numero de pieza
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Metodo para modificar la coordenada X de la pieza
     * @param x La nueva coordenada X
     * @throws NoValidoException Error si la coordenada dada es mayor a 5 o menor a 0
     */
    public void setCoordenadaX(int x) throws NoValidoException {
        if (x < 6 && x >= 0) {
            coordenadaX = x;
        } else {
            throw new NoValidoException("Coordenada x no valida");
        }
    }

    /**
     * Metodo para modificar la coordenada Y de la pieza
     * @param y La nueva coordenada Y
     * @throws NoValidoException Error si la coordenada dada es mayor a 5 o menor a 0
     */
    public void setCoordenadaY(int y) throws NoValidoException {
        if (y < 6 && y >= 0) {
            coordenadaY = y;
        } else {
            throw new NoValidoException("Coordenada y no valida");
        }
    }

    /**
     * Metodo para modificar el tipo de pieza
     * @param tipo El nuevo tipo de pieza
     * @throws NoValidoException Error si el tipo de pieza no es torre, caballo, rey, reina o peon
     */
    public void setTipo(String tipo) throws NoValidoException {
        tipo = tipo.strip().toLowerCase();
        if (tipo.equals("torre") || tipo.equals("rey") || tipo.equals("reina") || tipo.equals("peon")
                || tipo.equals("caballo")) {
            this.tipo = tipo;
        } else {
            throw new NoValidoException("Tipo de pieza no valida");
        }
    }

    /**
     * Metodo para modificar el color de la pieza
     * @param color El nuevo color de pieza
     * @throws NoValidoException Error si el color no es blanco o negro
     */
    public void setColor(String color) throws NoValidoException {
        color = color.strip().toLowerCase();
        if (color.equals("blanco") || color.equals("negro")) {
            this.color = color;
        } else {
            /*try {
                throw new RuntimeException();
            } catch (RuntimeException e) {
                System.out.println("Color no valido");
            }*/
            throw new NoValidoException("Color de pieza no valido");
        }
    }

    /**
     * Metodo para modificar el estado de la pieza (activa o inactiva)
     * @param activo Nueva actividad de la pieza
     */
    public void setActividad(boolean activo) {
        activa = activo;
    }

    /**
     * Metodo para obtener la coordenada X de la pieza
     * @return int La coordenada X
     */
    public int getCoordenadaX() {
        return coordenadaX;
    }

    /**
     * Metodo para obtener la coordenada Y de la pieza
     * @return int La coordenada Y
     */
    public int getCoordenadaY() {
        return coordenadaY;
    }

    /**
     * Metodo para obtener el tipo de pieza
     * @return String El tipo de pieza
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo para obtener el color de la pieza
     * @return String El color de la pieza
     */
    public String getColor() {
        return color;
    }

    /**
     * Metodo para obtener la actividad de la pieza
     * @return boolean La actividad de la pieza
     */
    public boolean getActividad() {
        return activa;
    }

    /**
     * Metodo para obtener el numero de pieza
     * @return int El numero de pieza
     */
    public int getNumPieza() {
        return numero;
    }

    /**
     * Metodo para obtener el numero de movimiento
     * @return int El numero de movimiento de la pieza
     */
    public int getNumMov() {
        return numMov;
    }

    /**
     * Metodo para representar a la pieza en forma de cadena
     * @return String La representacion pieza en forma de String
     */
    @Override
    public String toString() {
        return tipo + numero + color;
    }

    /**
     * Metodo para saber si una pieza es igual a otra
     * @return boolean Si la pieza es igual regresa true, en otro caso false
     */
    @Override
    public boolean equals(Object pieza) {
        Pieza pz = (Pieza) pieza;
        return coordenadaX == pz.coordenadaX && coordenadaY == pz.coordenadaY && tipo.equals(pz.tipo)
                && color.equals(pz.color) && activa == pz.activa;
    }

    /**
     * Metodo para saber si la pieza esta activa o no
     * @return boolean Si la pieza esta activa regresa true, en otro caso false
     */
    public boolean validarPieza() {
        if (this.activa) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo para mover una pieza
     * @param cx Nueva coordenada X
     * @param cy Nueva coordenada Y
     * @param arreglo El tablero
     */
    public void mover(int cx, int cy, Pieza[][] arreglo) {
        int x = getCoordenadaX();
        int y = getCoordenadaY();
        try{
            setCoordenadaX(cx);
        }catch(NoValidoException e){
            System.out.println("Error: " + e.getMessage());
            System.exit(-1);
        }

        try{
            setCoordenadaY(cy);
        }catch(NoValidoException e){
            System.out.println("Error: " + e.getMessage());
            System.exit(-1);
        }
        arreglo[cx][cy] = arreglo[x][y];
        arreglo[x][y] = null;
        numMov += 1;
    }

    // requiere la matriz el arreglo con el nombre de las piezas en la forma
    // caballoblanco y el arreglo con el numero de piezas que coinsida con el nombre
    /**
     * Metodo que reemplaza una pieza en el tablero con otra
     * @param cx Coordenada x donde se reemplazara la pieza
     * @param cy Coordenada y donde se reemplazara la pieza
     * @param arreglo El tablero
     * @param piezas El arreglo con el nombre de las piezas
     * @param numpiezas El arreglo con el numero de cada pieza
     */
    public void reemplaza(int cx, int cy, Pieza[][] arreglo, String[] piezas, int[] numpiezas) {
        String nombre = arreglo[cx][cy].tipo + arreglo[cx][cy].color;
        numpiezas[buscar(piezas, nombre)] -= 1;
        arreglo[cx][cy].setActividad(false);
        // ver pieza, color, restar piezas, quitar actividad de la pieza arreglo con
        // nombre y color
        mover(cx, cy, arreglo);
    }

    /**
     * Metodo que busca un String en un arreglo
     * @param arreglo El arreglo donde se buscara
     * @param buscado El String buscado
     * @return int La posicion del String en el arreglo
     */
    public static int buscar(String[] arreglo, String buscado) {
        int m = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i].equals(buscado)) {
                m = i;
            }
        }
        return m;
    }

    /**
     * Metodo para saber si una pieza se puede mover y en su caso la mueve
     * @param cx Coordenada x a donde se movera la pieza
     * @param cy Coordenada y a donde se movera la pieza
     * @param arreglo El tablero
     * @return boolean Si la pieza se movio regresa true, en otro caso false
     */
    public boolean sePudoMover(int cx, int cy, Pieza[][] arreglo) {
        if (arreglo[cx][cy] == null) {
            mover(cx, cy, arreglo);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Metodo abstracto para validar el movimiento de la pieza
     * @param cx Coordenada x a mover la pieza
     * @param cy Coordenada y a mover la pieza
     * @param arreglo El arreglo del tablero
     * @param piezas El arreglo que contiene el nombre de las piezas
     * @param numpiezas El arreglo que contiene el numero de cada pieza
     * @return boolean True si el movimiento es valido, false en otro caso
     */
    public abstract boolean validarMov(int cx, int cy, Pieza[][] arreglo, String[] piezas, int[] numpiezas);
}