//hacia adelante una casilla. En el primer movimiento se puede mover 2 casilllas
//capturar piezas diagonales
//pueden ascender a cualquier otra pieza
public class Peon extends Pieza{

    public Peon(int x, int y, String color, int num){
        super(x, y, "peon", color,num);
    }

    //Método que valida si el movimiento del peón es válido y de serlo mueve la pieza y come
    public boolean validarMov(int cx, int cy,Pieza[][] arreglo, String [] piezas, int[] numpiezas){
        String col = color;
        if(cy==coordenadaY){        
            switch(col){
                case "blanco":
                    if(numMov==0){
                        if(cx==(coordenadaX+2)&&arreglo[coordenadaX+1][cy]==null&&sePudoMover(cx, cy, arreglo)){
                            return true;
                        }else if(cx==(coordenadaX+1)&&sePudoMover(cx, cy, arreglo)){
                            return true;
                        }else{
                            return false;
                        }
                    }else{
                        if(cx==(coordenadaX+1)&&sePudoMover(cx, cy, arreglo)){
                            return true;
                        }else{
                            return false;
                        }
                    }
                case "negro":
                if(numMov==0){
                    if(cx==(coordenadaX-2)&&arreglo[coordenadaX-1][cy]==null&&sePudoMover(cx, cy, arreglo)){
                        return true;
                    }else if(cx==(coordenadaX-1)&&sePudoMover(cx, cy, arreglo)){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    if(cx==(coordenadaX-1)&&sePudoMover(cx, cy, arreglo)){
                        return true;
                    }else{
                        return false;
                    }
                }
                default: return false;
            }
        } else if((coordenadaY+1==cy || coordenadaY-1==cy)&&(coordenadaX+1==cx||coordenadaX-1==cx)){
            switch(color){
                case "blanco":
                        if(cx==(coordenadaX+1) && arreglo[cx][cy]==null){
                            return false;
                        }else if(cx==(coordenadaX+1) && arreglo[cx][cy]!=null){
                            if(arreglo[cx][cy].color.equals("negro")){
                                reemplaza(cx,cy,arreglo,piezas,numpiezas);
                                return true;
                            }else{
                                return false;
                            }
                        }else{
                            return false;
                        }
                case "negro":
                    if(cx==(coordenadaX-1) && arreglo[cx][cy]==null){
                        return false;
                    }else if(cx==(coordenadaX-1) && arreglo[cx][cy]!=null){
                        if(arreglo[cx][cy].color.equals("blanco")){
                            reemplaza(cx,cy,arreglo,piezas,numpiezas);
                            return true;
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                default: return false;
            }
        }else{
            return false;
        }
    }

    //regresa 1 si se pudo mover la pieza, 2 si no se puede mover
    public boolean sePudoMover(int cx, int cy, Pieza[][] arreglo){
        if(arreglo[cx][cy]==null){
            mover(cx, cy, arreglo);
            return true;
        }else{
            return false;
        }

    }
}