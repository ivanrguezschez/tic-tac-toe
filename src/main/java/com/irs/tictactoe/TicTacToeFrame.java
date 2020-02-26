package com.irs.tictactoe;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * JFrame de la ventana del juego.
 * 
 * @author IRS
 * @version 1.0.0
 */
public class TicTacToeFrame extends JFrame {

    private JTextField statusBar;
    private GamePanel panel;
    
    /**
     * Constructor.
     */
    public TicTacToeFrame() {
        setLayout(new BorderLayout());
        
        panel = new GamePanel(this);
        
        add(panel, BorderLayout.CENTER);
        
        statusBar = new JTextField("Player1's Turn");
        statusBar.setEditable(false);
        
        add(statusBar, BorderLayout.SOUTH);
        
        setTitle("Tic Tac Toe!");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 400, 300, 300);
    }

    public JTextField getStatusBar() {
        return statusBar;
    }
}
