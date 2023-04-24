package Sprint2_0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
    private Container content;
    private JPanel panelPrincipal;
    private JPanel PanelGeneral;
    private JRadioButton juegoNuevoRadioButton;
    private JRadioButton juegoGeneralRadioButton;
    private JTextField txtBorderSize;
    private JRadioButton sRadioButtonRojo;
    private JRadioButton sRadioButtonAzul;
    private JRadioButton oRadioButtonRojo;
    private JRadioButton oRadioButtonAzul;
    private JButton newGameButton;
    private PanelBoard pane;
    private int TAM_CELDA=100;
    private int ANCHO;
    private int LARGO;
    private int NUM_CELDAS;
    public GUI()
    {
        initComponents();
        actionListener();

    }
    public void actionListener()
    {
        txtBorderSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NUM_CELDAS = Character.getNumericValue(txtBorderSize.getText().charAt(0));
                add(pane,BorderLayout.SOUTH);
                pane.setBackground(Color.WHITE);
                pane.setVisible(true);
                txtBorderSize.setFocusable(false);
            }
        });
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtBorderSize.setFocusable(true);
                txtBorderSize.setText("");
                pane.setVisible(false);
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
