package com.irs.tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Listener de los eventos de los elementos (botones, etc) de la ventana del juego.
 * 
 * @author IRS
 * @version 1.0.0
 */
public class GameListener implements ActionListener {

    private final GamePanel panel;
    
    /**
     * Constructor.
     * 
     * @param panel Panel que contiene los elementos origen de los eventos.
     */ 
    public GameListener(GamePanel panel) {
        this.panel = panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        panel.setCount(panel.getCount() + 1);
        
        JButton b = (JButton) e.getSource();
        Integer[] index = (Integer[]) b.getClientProperty(GamePanel.INDEX_KEY);
                
        b.putClientProperty(GamePanel.OWNER_KEY, panel.getTurn());
        b.setIcon(new ImageIcon(getClass().getClassLoader().getResource(panel.getTurn() + ".gif")));
        b.setEnabled(false);
        
        boolean result = checkVictoryCondition(index);
        if (result) {
            JOptionPane.showMessageDialog(null, "Player " + panel.getTurn() + " Wins");
            panel.init();
        } else {
            if (panel.getTurn() == 1) {
                panel.setTurn(2);
                panel.getParent().getStatusBar().setText("Player2's Turn");
            } else {
                panel.setTurn(1);
                panel.getParent().getStatusBar().setText("Player1's Turn");
            }
        }
        
        if (panel.getCount() == 9) {
            JOptionPane.showMessageDialog(null, "Match is a draw!");
            panel.init();
        }
    }
    
    public Integer getOwnwer(JButton b) {
        return (Integer) b.getClientProperty(GamePanel.OWNER_KEY);
    }
    
    // Imprime el mapa de botones para su diagnostico
    public void printButtonMap(Integer[][] buttonMap) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {     
                System.out.print("[" + (buttonMap[i][j] == null ? " " : buttonMap[i][j]) + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean checkVictoryCondition(Integer[] index) {
        Integer[][] buttonMap = new Integer[][] {
            {getOwnwer(panel.getButtons()[0][0]), getOwnwer(panel.getButtons()[0][1]), getOwnwer(panel.getButtons()[0][2]) },
            {getOwnwer(panel.getButtons()[1][0]), getOwnwer(panel.getButtons()[1][1]), getOwnwer(panel.getButtons()[1][2]) },
            {getOwnwer(panel.getButtons()[2][0]), getOwnwer(panel.getButtons()[2][1]), getOwnwer(panel.getButtons()[2][2]) }
        };
        printButtonMap(buttonMap);
                
        Integer a = index[0];
        Integer b = index[1];
        int i;
        int j;
             
        // Comprobamos fila
        for (i = 0; i < 3; i++) {
            /*
            if (getOwnwer(panel.getButtons()[a][i]).intValue() != getOwnwer(panel.getButtons()[a][b]).intValue()) {
                break;
            }
            */
            if (getOwnwer(panel.getButtons()[a][i]) != getOwnwer(panel.getButtons()[a][b])) {
                break;
            }
        }
        if (i == 3) {
            return true;
        }
        
        // Comprobamos columna
        for(i = 0; i < 3; i++) {
            /*
            if (getOwnwer(panel.getButtons()[i][b]).intValue() != getOwnwer(panel.getButtons()[a][b]).intValue()) {
                break;
            }
            */
            if (getOwnwer(panel.getButtons()[i][b]) != getOwnwer(panel.getButtons()[a][b])) {
                break;
            }
        }
        if (i == 3) {
            return true;
        }
        
        // Comprobamos la diagonal
        if ((a == 2 && b == 2) || (a == 0 && b == 0) || (a == 1 && b == 1) || (a == 0 && b == 2) ||(a == 2 && b == 0)) {
            // Diagonal izquierda
            for (i = 0; i < 3; i++) {
                /*
                if (getOwnwer(panel.getButtons()[i][i]).intValue() != getOwnwer(panel.getButtons()[a][b]).intValue()) {
                    break;
                }
                */
                if (getOwnwer(panel.getButtons()[i][i]) != getOwnwer(panel.getButtons()[a][b])) {
                    break;
                }
            }
            if (i == 3) {
                return true;
            }
            
            // Diagonal derecha
            /*
            if ((getOwnwer(panel.getButtons()[0][2]).intValue() == getOwnwer(panel.getButtons()[a][b]).intValue()) && 
                    (getOwnwer(panel.getButtons()[1][1]).intValue() == getOwnwer(panel.getButtons()[a][b]).intValue()) &&
                    (getOwnwer(panel.getButtons()[2][0]).intValue() == getOwnwer(panel.getButtons()[a][b]).intValue())) {
                return true;
            }
            */
            for (i = 0, j = 2; i < 3; i++, j--) {
                if (getOwnwer(panel.getButtons()[i][j]) != getOwnwer(panel.getButtons()[a][b])) {
                    break;
                }
            }
            if (i == 3) {
                return true;
            }
        }
        
        return false;
    }
}
