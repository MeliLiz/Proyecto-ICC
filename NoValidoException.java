public class NoValidoException extends RuntimeException{
    public NoValidoException(String mensaje){
        super(mensaje);
    }

    public NoValidoException(){
        super();
    }

}