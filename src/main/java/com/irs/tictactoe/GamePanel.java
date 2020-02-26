package com.irs.tictactoe;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel de la ventana del juego.
 * 
 * @author IRS
 * @version 1.0.0
 */
public class GamePanel extends JPanel {
    
    public static final String INDEX_KEY = "INDEX";
    public static final String OWNER_KEY = "OWNER";
    
    private JButton[][] buttons;
    private GameListener listener;
    private Integer turn;
    private Integer count;
    private TicTacToeFrame parent;
    
    public GamePanel(TicTacToeFrame parent) {
        this.parent = parent;
        
        setLayout(new GridLayout(3, 3));
        
        buttons = new JButton[3][3];
        listener = new GameListener(this);
        turn = 1;
        count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].putClientProperty(INDEX_KEY, new Integer[] {i, j});
                buttons[i][j].putClientProperty(OWNER_KEY, null);
                buttons[i][j].addActionListener(listener);
                add(buttons[i][j]);
            }
        }
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    public void setButtons(JButton[][] buttons) {
        this.buttons = buttons;
    }

    public TicTacToeFrame getParent() {
        return parent;
    }
        
    public void init() {
        turn = 1;
        count = 0;
        parent.getStatusBar().setText("Player1's Turn");
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].putClientProperty(GamePanel.INDEX_KEY, new Integer[] {i, j});
                buttons[i][j].putClientProperty(GamePanel.OWNER_KEY, null);
                buttons[i][j].setIcon(null);
                buttons[i][j].setEnabled(true);
            }
        }
    }
}
