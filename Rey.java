//todas direcciones una casilla a la vez
public class Rey extends Pieza{
    public Rey(int x, int y, String color, int num){
        super(x, y, "rey", color);
        setNumero(num);
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