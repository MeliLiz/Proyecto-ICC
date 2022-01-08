//todas direcciones
public class Reina extends Pieza{
    public Reina(int x, int y, String color, int numero){
        super(x, y, "reina", color);
        setNumero(numero);
    }
    public void setNumero(int numero){
        if(numero>0 || numero<8){
            this.numero = numero;
        }else{
            try{
                throw new RuntimeException();
            }catch(RuntimeException e){
                System.out.println("Numero de torre no valido");
            }
        }
    }
}