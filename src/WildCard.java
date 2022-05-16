import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class WildCard extends JFrame implements MouseListener
{
    private HashMap<String, String> list = new HashMap<String, String>();
    private ArrayList<String> cards = new ArrayList<String>();
    private JFrame frame;
    private JLabel title = new JLabel("Wild card");
    private JLabel card = new JLabel("...");
    private JLabel name = new JLabel("Please enter name");

    private JPanel tPanel = new JPanel();
    private JPanel nPanel = new JPanel();
    private JPanel cPanel = new JPanel();

    private JTextField nameField = new JTextField(20);

    private Random rand = new Random();
    private boolean clicked = false;
    private String sCard = "";

    public WildCard()
    {
        cards.add("+1");
        cards.add("-1");
        cards.add("+2");
        cards.add("-2");
        cards.add("+3");
        cards.add("-3");
        cards.add("+4");
        cards.add("-4");
        cards.add("A");
        cards.add("J");
        frame = new JFrame("Wild Card");
        makeFrame();
    }

    public void makeFrame()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        Font titleFont = new Font("Copperplate", Font.BOLD, 36);
        Font nameFont = new Font("American Typewriter", Font.BOLD, 28);
        Font cardFont = new Font("American Typewriter", Font.BOLD, 100);

        title.setFont(titleFont);
        name.setFont(nameFont);
        card.setFont(cardFont);

        tPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tPanel.setPreferredSize(new Dimension(400,50));
        tPanel.setMaximumSize(new Dimension(400,50));

        nPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nPanel.setPreferredSize(new Dimension(400, 100));
        nPanel.setMaximumSize(new Dimension(400,100));

        cPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cPanel.setPreferredSize(new Dimension(400, 300));
        cPanel.setMaximumSize(new Dimension(400,300));

        frame.getContentPane().add(tPanel);
        tPanel.add(title);
        frame.getContentPane().add(nPanel);
        nPanel.add(name);
        nPanel.add(nameField);
        frame.getContentPane().add(cPanel);
        cPanel.add(card);

        tPanel.setBackground(Color.GREEN);
        nPanel.setBackground(Color.GREEN);
        cPanel.setBackground(Color.GREEN);

        cPanel.addMouseListener(this);

        frame.setSize(400,420);
        frame.setVisible(true);
    }

    public String getCard(String name)
    {
        String c = list.get(name);
        return c;
    }

    public void mouseClicked(MouseEvent e)
    {
        JPanel source = (JPanel) e.getSource();
        if(cards.size() >= 0){
            if(clicked == false){
                int i = rand.nextInt(cards.size());
                card.setText(cards.get(i));
                sCard = cards.get(i);
                cards.remove(i);
                clicked = true;
            }
            else if(clicked == true){
                card.setText("...");
                list.put(nameField.getText(), sCard);
                nameField.setText("");
                clicked = false;
            }
        }
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }

    public void mousePressed(MouseEvent e)
    {
    }

    public void mouseReleased(MouseEvent e)
    {
    }

}
