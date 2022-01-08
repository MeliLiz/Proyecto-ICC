//hacia adelante una casilla. En el primer movimiento se puede mover 2 casilllas
//capturar piezas diagonales
//pueden ascender a cualquier otra pieza
public class Peon extends Pieza{

    public Peon(int x, int y, String color, int num){
        super(x, y, "peon", color);
        setNumero(num);
    }

    public void setNumero(int numero){
        if(numero>0 || numero<7){
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