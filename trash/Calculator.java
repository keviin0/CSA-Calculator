package calculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator{

    private JFrame frame;
    //private int butRow = 0;
    private int butColumn = 6;

    public Calculator()
    {
        gui();
    }

    public void gui()
    {
        frame = new JFrame("CSA Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600, 800);
        frame.setResizable(true);
        frame.setMinimumSize(new Dimension(320, 475));
        
        frame.add(new NumPanel());
    }

    class NumPanel extends JPanel 
    {
        private int numbers = 0;

        public NumPanel() {
            //*Numbers 1 - 9
            GridLayout butGrid = new GridLayout(0, butColumn);
            setLayout(butGrid);
            for(int row = 2; row < 5; row++) {
                for(int column = 0; column < butColumn -1; column++){
                    numbers++;
                    JButton tempBut = new JButton(Integer.toString(numbers));
                    add(tempBut).setLocation(row, column);
                    tempBut.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("I was clicked!");
                        }         
                    });                    
                }
            }

        }

    }

    public static void main(String[] args){
        new Calculator();
    }

}