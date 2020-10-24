package ui;
import javax.swing.*;
import java.awt.*;
import util.APIRequest;

public class Anime extends JFrame {

    private final JLabel animeArea = new JLabel("Seasonal anime retriever");
    private JTextArea yearArea; //Text input for year
    private JTextArea seasonArea; //Text input for season
    private static String ENTER = "Enter"; //Submit button

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Anime frame = new Anime();
                frame.setSize(300,300);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Anime(){
        Container c = getContentPane();
        JPanel p = new JPanel();
        JButton b = new JButton("Submit"); //Submit button

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        c.add(animeArea); //Add label to container
        yearArea = new JTextArea("Year",1, 10);
        p.add(yearArea); //Add text area for year to panel
        seasonArea = new JTextArea("Season",1, 10);
        p.add(seasonArea); //Add text area for season to panel
        p.add(b); //Add button to panel
        c.add(p); //add panel to container

        b.addActionListener(e -> {
            try {
                int year = Integer.parseInt(yearArea.getText()); //Retrieve text from yearArea and store in variable typecasted to int
                String season = seasonArea.getText();  //Retrieve text from season Area
                String response = APIRequest.get(year, season); //Send to model code
                System.out.println(response);
            }catch(Exception f){
                JOptionPane.showMessageDialog(new JFrame(), "Make sure the year is an int and the season is a valid season", "Dialog",
                        JOptionPane.ERROR_MESSAGE); //Error message popup if exception thronw from try
            }
        });
        //TODO: Throw custom exception if not a valid season or year.

    }


}
