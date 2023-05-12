package Sprint3_0;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testVictoria {
    Tablero tablero;

    @Before
    public void initTablero()
    {
        tablero = new Tablero(3,3);
    }

    /**
     * CRITERIO DE ACEPTACION 6.1
     */
    @Test
    public void testVictoriaJuegoSimple(){
        tablero.setModo(Tablero.ModoDeJuego.SIMPLE);
        //turno A
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,1);
        //turno R
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,0);
        //turno A
        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(1,1);
        //turno R
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,0);
        //turno A
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,1);
        assertEquals("",tablero.getEstadoActual(), Tablero.EstadoDeJuego.AZUL_GANA);
    }

    /**
     * CRITERIO DE ACEPTACION 6.2
     */
    @Test
    public void testEmpateJuegoSimple()
    {
        tablero.setModo(Tablero.ModoDeJuego.SIMPLE);
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,0);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,1);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,2);

        tablero.RealizarMovimiento(1,0);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(1,1);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(1,2);

        tablero.RealizarMovimiento(2,0);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,1);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,2);

        //SI EL ESTADO SIGUE EN DRAW ENTONCES ES UN EMPATE EN UN JUEGO SIMPLE
        assertEquals("", tablero.getEstadoActual(), Tablero.EstadoDeJuego.DRAW);

    }
}
