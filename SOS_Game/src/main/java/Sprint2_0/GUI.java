package Sprint2_0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{

    private JPanel panelPrincipal;
    private JPanel PanelGeneral;
    private JRadioButton juegoSimpleRadioButton;
    private JRadioButton juegoGeneralRadioButton;
    private JTextField txtBorderSize;
    private JRadioButton sRadioButtonRojo;
    private JRadioButton sRadioButtonAzul;
    private JRadioButton oRadioButtonRojo;
    private JRadioButton oRadioButtonAzul;
    private JButton newGameButton;
    private JLabel lblAzul;
    private JLabel lblRojo;
    private PanelBoard pane;
    private int TAM_CELDA=100;
    private int ANCHO;
    private int LARGO;
    private int NUM_CELDAS;
    public GUI()
    {
        initComponents();
        actionListener();
        BotonesJuegoNuevo();
        BotonesJugadorAzul();
        BotonesJugadorRojo();

    }

    public void BotonesJuegoNuevo()
    {
        ButtonGroup GroupJuegoIniciado=new ButtonGroup();
        GroupJuegoIniciado.add(juegoSimpleRadioButton);
        GroupJuegoIniciado.add(juegoGeneralRadioButton);
    }
    public void BotonesJugadorAzul()
    {
        ButtonGroup GroupJugadorAzul=new ButtonGroup();
        GroupJugadorAzul.add(sRadioButtonAzul);
        GroupJugadorAzul.add(oRadioButtonAzul);
    }
    public void BotonesJugadorRojo()
    {
        ButtonGroup GroupJugadorRojo=new ButtonGroup();
        GroupJugadorRojo.add(sRadioButtonRojo);
        GroupJugadorRojo.add(oRadioButtonRojo);
    }
    public void actionListener()
    {
        /*
        1.1 <Tamaño de tablero permitido>
        1.2 <Tamaño de tablero no permitido>
         */
        txtBorderSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NUM_CELDAS = Character.getNumericValue(txtBorderSize.getText().charAt(0));
                //la condicional if me determina si el tamaño escogido es permitido
                if(juegoGeneralRadioButton.isSelected()==true || juegoSimpleRadioButton.isSelected()==true) {
                    NUM_CELDAS = Character.getNumericValue(txtBorderSize.getText().charAt(0));
                    if (NUM_CELDAS > 2 & NUM_CELDAS < 6) {
                        add(pane, BorderLayout.SOUTH);
                        pane.setBackground(Color.WHITE);
                        pane.setVisible(true);

                        lblAzul.setVisible(true);
                        lblRojo.setVisible(true);
                        sRadioButtonAzul.setVisible(true);
                        oRadioButtonAzul.setVisible(true);
                        sRadioButtonRojo.setVisible(true);
                        oRadioButtonRojo.setVisible(true);

                        txtBorderSize.setFocusable(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "TAMAÑO DEL TABLERO NO PERMITIDO");
                    }
                }else JOptionPane.showMessageDialog(null, "SELECIONE UN MODO DE JUEGO");
            }
        });
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtBorderSize.setFocusable(true);
                txtBorderSize.setText("");

                lblAzul.setVisible(false);
                lblRojo.setVisible(false);
                sRadioButtonAzul.setVisible(false);
                oRadioButtonAzul.setVisible(false);
                sRadioButtonRojo.setVisible(false);
                oRadioButtonRojo.setVisible(false);

                pane.setVisible(false);

                JOptionPane.showMessageDialog(null, "Ingrese el tamaño del tablero en el que desee jugar");
            }
        });

        juegoSimpleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"HA ELEGIDO EL MODO DE JUEGO SIMPLE");
            }
        });
        juegoGeneralRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"HA ELEGIDO EL MODO DE JUEGO GENERAL");
            }
        });
    }
    public void initComponents()
    {
        ANCHO=TAM_CELDA*6;
        LARGO=TAM_CELDA*6;

        pane = new PanelBoard();

        setTitle("SOS GAME");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(ANCHO,LARGO));
        add(PanelGeneral,BorderLayout.CENTER);

        lblAzul.setVisible(false);
        lblRojo.setVisible(false);
        sRadioButtonAzul.setVisible(false);
        oRadioButtonAzul.setVisible(false);
        sRadioButtonRojo.setVisible(false);
        oRadioButtonRojo.setVisible(false);

        add(pane,BorderLayout.SOUTH);
        pane.setVisible(false);
        setVisible(true);

        pack();
    }
    public class PanelBoard extends JPanel {
        public PanelBoard() {
            setPreferredSize(new Dimension(ANCHO, LARGO-200));
            setBackground(Color.BLACK);
        }
        @Override
        public void paintComponent(Graphics g) {
            g.setColor(Color.BLACK);

            for( int filas=1; filas<NUM_CELDAS; filas++)
            {
                g.fillRoundRect(0,filas*(LARGO-200)/NUM_CELDAS,ANCHO,6, 6,6);
            }

            for( int colum=1; colum<NUM_CELDAS; colum++)
            {
                g.fillRoundRect(colum*ANCHO/NUM_CELDAS,0,6,ANCHO, 6,6);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
    }
}
