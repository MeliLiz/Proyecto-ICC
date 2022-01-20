/**
 * Clase para hacer excepciones
 * @author Melissa Lizbeth Fernandez Blancas
 * @version 1
 */
public class NoValidoException extends RuntimeException{
    /**
     * Constructor que recibe el mensaje a mostrar
     * @param mensaje El mensaje a mostrar
     */
    public NoValidoException(String mensaje){
        super(mensaje);
    }

    /**
     * Constructor sin parametros
     */
    public NoValidoException(){
        super();
    }

}