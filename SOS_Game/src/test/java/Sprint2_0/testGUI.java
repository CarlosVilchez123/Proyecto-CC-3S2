package Sprint2_0;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testGUI {

    @Test
    public void testBorderSize()
    {
       GUI gui=new GUI();
       try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /*Implementamos un test que nos permite poder visualizar
    * el tablero sin ninguna lógica implementada
    * Tomado como referencia el juego de Tic Tac TOe*/
    @Test
    public void testTableroVacio()
    {
        new GUI();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}