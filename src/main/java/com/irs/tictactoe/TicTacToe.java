package com.irs.tictactoe;

import java.awt.EventQueue;

/**
 * Clase principal del juego TIC-TAC-TOE.
 * 
 * @author IRS
 * @version 1.0.0
 */
public class TicTacToe {
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TicTacToeFrame frame = new TicTacToeFrame();
            }
        });
    }
}
