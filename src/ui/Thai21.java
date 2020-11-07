package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JToolTip;
import javax.swing.PopupFactory;

public class Thai21 extends JFrame{
    private JPanel mainPanel;
    private JButton mStartButton;
    private JLabel mTurnLabel;
    private JButton mOneFlag;
    private JButton mTwoFlag;
    private JButton mThreeFlag;
    private JLabel mUserOptions;
    private JLabel mFlagsLeftLabel;

    // Game Variables
    private boolean mUserTurn = true;
    private boolean mGameRunning = false;
    final int MAX_FLAGS = 21;

    private int mRemainingFlags = MAX_FLAGS;

    private Timer timer;
    private Popup popup;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Thai21 frame = new Thai21();
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
        setContentPane(mainPanel);


        // Set up your action controls
        mStartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You have started the game!");

                startGame();
            }
        });

        mOneFlag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                takeFlag(1);
            }
        });

        mTwoFlag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                takeFlag(2);
            }
        });

        mThreeFlag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                takeFlag(3);
            }
        });

        updateTurnLabel();
        updateButtons();
        updateFlagsLeft();

    }

    private void takeFlag(int numFlags)
    {
        if( mUserTurn ) {
            if( timer != null ) {
                timer.stop();
            }
            if(popup != null ) {
                popup.hide();
            }
        }

        mRemainingFlags -= numFlags;
        mFlagsLeftLabel.setText(Integer.toString(mRemainingFlags));

        if (mRemainingFlags <= 0)
        {
            mRemainingFlags = 0;
            endGame();
        }
        else
        {
            mUserTurn = !mUserTurn;
            updateTurnLabel();
            updateFlagsLeft();

            //handle computer turn
            if (!mUserTurn)
            {

                int flagsTaken = mRemainingFlags;

                if (mRemainingFlags > 3)
                {
                    Random rand = new Random();

                    flagsTaken = rand.nextInt(3);
                    takeFlag(flagsTaken);
                }
                else
                {
                    takeFlag(mRemainingFlags);
                }

                popup = PopupFactory.getSharedInstance().
                        getPopup(mainPanel,
                                new JLabel("Computer has taken " + flagsTaken + "."),
                                110,
                                130);
                popup.show();
                // create a timer to hide the popup later
                timer = new Timer(2000, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        popup.hide();
                    }
                });
                timer.start();
            }


        }

    }

    private void endGame()
    {
        if(timer != null)
        {
            timer.stop();
        }

        if(popup != null )
        {
            popup.hide();
        }

        String message = (mUserTurn ? "User" : "Computer") + " has won!";
        JOptionPane.showMessageDialog(null, message);

        mGameRunning = false;
        mRemainingFlags = MAX_FLAGS;
        mUserTurn = true;

        updateTurnLabel();
        updateButtons();
        updateFlagsLeft();
    }

    private void updateButtons()
    {
        mOneFlag.setEnabled(false);
        mTwoFlag.setEnabled(false);
        mThreeFlag.setEnabled(false);
        mStartButton.setEnabled(false);

        if (!mGameRunning)
        {
            mStartButton.setEnabled(true);
            return;
        }

        if (mRemainingFlags == 1)
        {
            mOneFlag.setEnabled(true);
        }
        else if (mRemainingFlags == 2)
        {
            mOneFlag.setEnabled(true);
            mTwoFlag.setEnabled(true);

        }
        else
        {
            mOneFlag.setEnabled(true);
            mTwoFlag.setEnabled(true);
            mThreeFlag.setEnabled(true);

        }

    }

    private void startGame()
    {
        mStartButton.setEnabled(false);
        updateTurnLabel();
        mGameRunning = true;

        updateButtons();

    }

    private void updateTurnLabel() {

        mTurnLabel.setText(mUserTurn ? "User Turn" : "Computer Turn");

    }

    private void updateFlagsLeft()
    {
        mFlagsLeftLabel.setText("Flags left: " + mRemainingFlags );
    }

}
