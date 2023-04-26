package Sprint2_0;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testMovimiento{
    private Tablero tablero =
            new Tablero(4,4);

    // Criterio de aceptación 4.1 y 11.1
    @Test
    public void testMovimientoValidoModoSimple() {

        assertEquals("", tablero.getContenidoDeLasCeldasDelTablero(0, 0), Tablero.ContenidoDeLasCeldasDelTablero.VACIO);
        assertEquals("", tablero.getTurno(),'A');
    }
    //Criterio de aceptacion 4.2 y 11.2
    @Test
    public void testMovimientoInvalidoModoSimple(){
        tablero.setSeleccion('S');
        tablero.hacerMovimiento(0,0);
        assertEquals("", tablero.getContenidoDeLasCeldasDelTablero(0, 0), Tablero.ContenidoDeLasCeldasDelTablero.SIMBOLO_AZUL_S);
        assertEquals("", tablero.getTurno(),'R');
    }
    /*
    // Criterio de aceptación 5.1
    @Test
    public void testSiguienteTurnoModoSimple(){
        assertEquals("",tablero.getSOS(),0);
    }
    // Criterio de aceptación 6.1
    @Test
    public void testFinDelJuegoModoSimplePorFormarSOS() {
        assertEquals("SOS", tablero.getSOS(), 0);
    }
    // Criterio de aceptación 6.2
    @Test
    public void testFinDelJuegoModoSimpleEmpate() {
        assertEquals("T", tablero.isTableroLleno(), 0);


    }

     */
}
