package Sprint2_0;

public class Tablero {
    public enum ContenidoDeLasCeldasDelTablero {VACIO, SIMBOLO_AZUL_O, SIMBOLO_AZUL_S, SIMBOLO_ROJO_S,SIMBOLO_ROJO_O};

    public enum EstadoDeJuego {EN_TURNO, COLOCANDO, AZUL_GANA, ROJO_GANA};
    public ContenidoDeLasCeldasDelTablero celdas[][];
    public char turno;
    public char seleccion;
    private int NumFilas;

    private int NumColumnas;

    public Tablero(int NumFilas, int NumColumnas)
    {

        this.NumFilas=NumFilas;
        this.NumColumnas=NumColumnas;

        celdas = new ContenidoDeLasCeldasDelTablero[NumFilas][NumColumnas];

        for(int filas=0; filas<NumFilas;filas++)
            for (int columnas=0; columnas<NumColumnas;columnas++)
                celdas[filas][columnas]= ContenidoDeLasCeldasDelTablero.VACIO;
        turno='A';
    }

    public int getNumFilas(){
        return NumFilas;
    }
    public int getNumColumnas(){
        return NumColumnas;
    }
    public ContenidoDeLasCeldasDelTablero getContenidoDeLasCeldasDelTablero(int filas, int columnas) {
        if(filas >= 0 && filas < NumFilas && columnas >= 0 && columnas < NumColumnas)
            return celdas[filas][columnas];
        else return null;
    }
    public void hacerMovimiento(int filas, int columnas) {
        if(filas>=0 && filas<NumFilas && columnas>=0 && columnas<NumColumnas && celdas[filas][columnas]==ContenidoDeLasCeldasDelTablero.VACIO)
        {
            if(turno=='A')
            {
                if(seleccion=='O')
                {
                    celdas[filas][columnas]=ContenidoDeLasCeldasDelTablero.SIMBOLO_AZUL_O;
                }
                else {
                    if (seleccion == 'S') {
                        celdas[filas][columnas] = ContenidoDeLasCeldasDelTablero.SIMBOLO_AZUL_S;
                    }
                }
                turno='R';
            }else
            if(turno=='R')
            {
                turno='A';
                if(seleccion=='O') {
                    celdas[filas][columnas]=ContenidoDeLasCeldasDelTablero.SIMBOLO_ROJO_O;
                }
                else
                if(seleccion=='S') {
                    celdas[filas][columnas]=ContenidoDeLasCeldasDelTablero.SIMBOLO_ROJO_S;
                }
                turno='A';
            }
        }
    }
    public char getTurno()
    {
        return turno;
    }
    public void setTurno(char turno)
    {
        this.turno=turno;
    }
    public char getSelccion()
    {
        return seleccion;
    }
    public void setSeleccion(char seleccion)
    {
        this.seleccion=seleccion;
    }
}
