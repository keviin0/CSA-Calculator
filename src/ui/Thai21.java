package ui;

import util.Math;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Thai21 extends JFrame {
    private final JLabel Thai21Background = new JLabel("");

    // Game Variables
    private boolean playerTurn = true;
    private boolean computerTurn = false;
    private int totalFlags = 21;

    // Player Variables
    private int userChoice;

    // Computer Variables
    private int computerChoice;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CalculatorUI frame = new CalculatorUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Thai21() {
        getContentPane().setBackground(new Color(250, 200, 250));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 418, 315);
        getContentPane().setLayout(null);
        Thai21Background.setForeground(Color.WHITE);
        Thai21Background.setFont(new Font("Lucida Grande", Font.PLAIN, 72));
        Thai21Background.setHorizontalAlignment(SwingConstants.RIGHT);
        Thai21Background.setBounds(18, 6, 377, 67);
        getContentPane().add(Thai21Background);
    }
}
