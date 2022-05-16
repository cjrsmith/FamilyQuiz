import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.Timer;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 */
public class Game extends JFrame implements ActionListener
{
    private int time = 30;
    private JFrame frame;
    private JLabel title = new JLabel("Family quarantine quiz");
    private JLabel bonus = new JLabel("* Bonus round *");
    private JLabel teams = new JLabel("Teams");
    private JLabel safe = new JLabel("Safe");
    private JLabel p1 = new JLabel("Player 1");
    private JLabel p2 = new JLabel("Player 2");
    private JLabel p3 = new JLabel("Player 3");
    private JLabel p4 = new JLabel("Player 4");
    private JLabel p5 = new JLabel("Player 5");
    private JLabel p6 = new JLabel("Player 6");
    private JLabel safePerson = new JLabel("This person is safe for this round");
    private JLabel category = new JLabel("Name as many ...");
    private JLabel abbie, kev, megan, pip, grandad, connor, anna;
    private JLabel abbieP = new JLabel("");
    private JLabel kevP = new JLabel("");
    private JLabel meganP = new JLabel("");
    private JLabel pipP = new JLabel("");
    private JLabel grandadP = new JLabel("");
    private JLabel connorP = new JLabel("");
    private JLabel annaP = new JLabel("");
    private JLabel timeLabel = new JLabel(time + " seconds");
    private JLabel abbieC = new JLabel("");
    private JLabel kevC = new JLabel("");
    private JLabel meganC = new JLabel("");
    private JLabel pipC = new JLabel("");
    private JLabel grandadC = new JLabel("");
    private JLabel connorC = new JLabel("");
    private JLabel annaC = new JLabel("");
    private JLabel info1 = new JLabel("->Wild card info<-");
    private JLabel info2 = new JLabel("+1, +2, +3, +4 = Increase your points by this number.");
    private JLabel info3 = new JLabel("-1, -2, -3, -4 = Decrease someones points by this number.");
    private JLabel info4 = new JLabel("A = Increase your points by any number up to 5.");
    private JLabel info5 = new JLabel("J = Decrease someones points by any number up to 5.");

    private JPanel p1Panel = new JPanel();
    private JPanel p2Panel = new JPanel();
    private JPanel p3Panel = new JPanel();
    private JPanel p4Panel = new JPanel();
    private JPanel p5Panel = new JPanel();
    private JPanel p6Panel = new JPanel();
    private JPanel infoPanel = new JPanel();
    private JPanel blankPanel = new JPanel();

    private JButton generate = new JButton("Generate teams");
    private JButton split1 = new JButton("Split");
    private JButton steal1 = new JButton("Steal");
    private JButton split2 = new JButton("Split");
    private JButton steal2 = new JButton("Steal");
    private JButton split3 = new JButton("Split");
    private JButton steal3 = new JButton("Steal");
    private JButton split4 = new JButton("Split");
    private JButton steal4 = new JButton("Steal");
    private JButton split5 = new JButton("Split");
    private JButton steal5 = new JButton("Steal");
    private JButton split6 = new JButton("Split");
    private JButton steal6 = new JButton("Steal");
    private JButton play = new JButton("Play");
    private JButton points = new JButton("See points");
    private JButton wildCards = new JButton("See Wild Cards");

    private JTextField pointsBox1 = new JTextField(2);
    private JTextField pointsBox2 = new JTextField(2);
    private JTextField pointsBox3 = new JTextField(2);

    private ArrayList<String> pPlayers = new ArrayList<String>();
    private ArrayList<String> players = new ArrayList<String>();
    private ArrayList<String> safePlayers = new ArrayList<String>();
    private ArrayList<String> list = new ArrayList<String>();
    private ArrayList<String> used = new ArrayList<String>();
    private Random rand = new Random();
    private Timer countdown;

    private int playerCount = 7;

    private double pb1 = 0;
    private double pb2 = 0;
    private double pb3 = 0;

    private double abP = 0;
    private double keP = 0;
    private double meP = 0;
    private double piP = 0;
    private double grP = 0;
    private double coP = 0;
    private double anP = 0;

    private boolean finished = false;
    private boolean p1Clicked = false;
    private boolean p2Clicked = false;
    private boolean p3Clicked = false;
    private boolean p4Clicked = false;
    private boolean p5Clicked = false;
    private boolean p6Clicked = false;

    private String p1Choice = "";
    private String p2Choice = "";
    private String p3Choice = "";
    private String p4Choice = "";
    private String p5Choice = "";
    private String p6Choice = "";

    private WildCard wc;

    public Game()
    {
        pPlayers.add("Abbie");
        pPlayers.add("Kev");
        pPlayers.add("Megan");
        pPlayers.add("Pip");
        pPlayers.add("Grandad");
        pPlayers.add("Connor");
        pPlayers.add("Anna");
        importFile();
        frame = new JFrame("Bonus round");
        makeFrame();
        wc = new WildCard();
    }

    public void makeFrame()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        countdown = new Timer(1000, this);

        abbie = new JLabel("Abbie");
        kev = new JLabel("Kev");
        megan = new JLabel("Megan");
        pip = new JLabel("Pip");
        grandad = new JLabel("Grandad");
        connor = new JLabel("Connor");
        anna = new JLabel("Anna");

        Font titleFont = new Font("Copperplate", Font.BOLD, 38);
        Font bonusFont = new Font("American Typewriter", Font.BOLD, 38);
        Font teamsFont = new Font("American Typewriter", Font.BOLD, 28);
        Font safeFont = new Font("American Typewriter", Font.BOLD, 28);
        Font playerFont = new Font("American Typewriter", Font.BOLD, 24);
        Font categoryFont = new Font("American Typewriter", Font.BOLD, 32);
        Font infoFont = new Font("American Typewriter", Font.BOLD, 16);

        title.setFont(titleFont);
        bonus.setFont(bonusFont);
        teams.setFont(teamsFont);
        safe.setFont(safeFont);
        p1.setFont(playerFont);
        p2.setFont(playerFont);
        p3.setFont(playerFont);
        p4.setFont(playerFont);
        p5.setFont(playerFont);
        p6.setFont(playerFont);
        safePerson.setFont(playerFont);
        info1.setFont(infoFont);
        timeLabel.setFont(playerFont);
        abbie.setFont(playerFont);
        kev.setFont(playerFont);
        megan.setFont(playerFont);
        pip.setFont(playerFont);
        grandad.setFont(playerFont);
        connor.setFont(playerFont);
        anna.setFont(playerFont);
        abbieP.setFont(playerFont);
        kevP.setFont(playerFont);
        meganP.setFont(playerFont);
        pipP.setFont(playerFont);
        grandadP.setFont(playerFont);
        connorP.setFont(playerFont);
        annaP.setFont(playerFont);
        abbieC.setFont(playerFont);
        kevC.setFont(playerFont);
        meganC.setFont(playerFont);
        pipC.setFont(playerFont);
        grandadC.setFont(playerFont);
        connorC.setFont(playerFont);
        annaC.setFont(playerFont);
        category.setFont(categoryFont);

        p1.setForeground(Color.BLUE);
        p2.setForeground(Color.BLUE);
        p3.setForeground(Color.BLUE);
        p4.setForeground(Color.BLUE);
        p5.setForeground(Color.BLUE);
        p6.setForeground(Color.BLUE);
        safePerson.setForeground(Color.BLUE);

        JPanel titlePanel = new JPanel();
        JPanel bonusPanel = new JPanel();
        JPanel generatePanel = new JPanel();
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(1,2));
        JPanel teamPanel = new JPanel();
        JPanel safePanel = new JPanel();
        JPanel teamAPanel = new JPanel();
        teamPanel.setLayout(new BoxLayout(teamPanel, BoxLayout.Y_AXIS));
        teamAPanel.setLayout(new GridLayout(3,3,3,3));
        JPanel teamATitlePanel = new JPanel();
        JPanel pointsBox1Panel = new JPanel();
        JPanel pointsBox2Panel = new JPanel();
        JPanel pointsBox3Panel = new JPanel();
        p1Panel.setLayout(new BoxLayout(p1Panel, BoxLayout.Y_AXIS));
        p2Panel.setLayout(new BoxLayout(p2Panel, BoxLayout.Y_AXIS));
        p3Panel.setLayout(new BoxLayout(p3Panel, BoxLayout.Y_AXIS));
        p4Panel.setLayout(new BoxLayout(p4Panel, BoxLayout.Y_AXIS));
        p5Panel.setLayout(new BoxLayout(p5Panel, BoxLayout.Y_AXIS));
        p6Panel.setLayout(new BoxLayout(p6Panel, BoxLayout.Y_AXIS));
        JPanel safeTitlePanel = new JPanel();

        JPanel playPanel = new JPanel();
        JPanel categoryPanel = new JPanel();
        JPanel timerPanel = new JPanel();
        JPanel leaderBoardPanel = new JPanel();
        JPanel lbTitlePanel = new JPanel();
        JPanel lbPanel = new JPanel();
        lbPanel.setLayout(new GridLayout(3,7,3,3));

        titlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.setPreferredSize(new Dimension(1500, 50));
        titlePanel.setMaximumSize(new Dimension(1500,50));

        bonusPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bonusPanel.setPreferredSize(new Dimension(1500, 50));
        bonusPanel.setMaximumSize(new Dimension(1500,50));

        generatePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        generatePanel.setPreferredSize(new Dimension(1500, 50));
        generatePanel.setMaximumSize(new Dimension(1500,50));

        playerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerPanel.setPreferredSize(new Dimension(900, 330));
        playerPanel.setMaximumSize(new Dimension(900,330));

        teamPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        teamPanel.setPreferredSize(new Dimension(450, 330));
        teamPanel.setMaximumSize(new Dimension(450,330));

        teamAPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        teamAPanel.setPreferredSize(new Dimension(450, 300));
        teamAPanel.setMaximumSize(new Dimension(450,300));

        teamATitlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        teamATitlePanel.setPreferredSize(new Dimension(450, 40));
        teamATitlePanel.setMaximumSize(new Dimension(450,40));

        p1Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        p1Panel.setPreferredSize(new Dimension(150, 10));
        p1Panel.setMaximumSize(new Dimension(150,10));

        p2Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        p2Panel.setPreferredSize(new Dimension(150, 10));
        p2Panel.setMaximumSize(new Dimension(150,10));

        p3Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        p3Panel.setPreferredSize(new Dimension(150, 10));
        p3Panel.setMaximumSize(new Dimension(150,10));

        p4Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        p4Panel.setPreferredSize(new Dimension(150, 10));
        p4Panel.setMaximumSize(new Dimension(150,10));

        p5Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        p5Panel.setPreferredSize(new Dimension(150, 10));
        p5Panel.setMaximumSize(new Dimension(150,10));

        p6Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        p6Panel.setPreferredSize(new Dimension(150, 10));
        p6Panel.setMaximumSize(new Dimension(150,10));

        pointsBox1Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        pointsBox1Panel.setPreferredSize(new Dimension(100, 10));
        pointsBox1Panel.setMaximumSize(new Dimension(100,10));

        pointsBox2Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        pointsBox2Panel.setPreferredSize(new Dimension(100, 10));
        pointsBox2Panel.setMaximumSize(new Dimension(100,10));

        pointsBox3Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        pointsBox3Panel.setPreferredSize(new Dimension(100, 10));
        pointsBox3Panel.setMaximumSize(new Dimension(100,10));

        safePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        safePanel.setPreferredSize(new Dimension(450, 300));
        safePanel.setMaximumSize(new Dimension(450,300));

        safeTitlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        safeTitlePanel.setPreferredSize(new Dimension(450, 40));
        safeTitlePanel.setMaximumSize(new Dimension(450,40));

        infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.setPreferredSize(new Dimension(435, 120));
        infoPanel.setMaximumSize(new Dimension(435,120));

        blankPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        blankPanel.setPreferredSize(new Dimension(435, 45));
        blankPanel.setMaximumSize(new Dimension(435,45));

        playPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        playPanel.setPreferredSize(new Dimension(1500, 50));
        playPanel.setMaximumSize(new Dimension(1500,50));

        categoryPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        categoryPanel.setPreferredSize(new Dimension(1500, 70));
        categoryPanel.setMaximumSize(new Dimension(1500,70));

        timerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        timerPanel.setPreferredSize(new Dimension(1500, 50));
        timerPanel.setMaximumSize(new Dimension(1500,50));

        leaderBoardPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leaderBoardPanel.setPreferredSize(new Dimension(900, 200));
        leaderBoardPanel.setMaximumSize(new Dimension(900,200));

        lbTitlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbTitlePanel.setPreferredSize(new Dimension(900, 30));
        lbTitlePanel.setMaximumSize(new Dimension(900,30));

        lbPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbPanel.setPreferredSize(new Dimension(900, 100));
        lbPanel.setMaximumSize(new Dimension(900,100));

        frame.getContentPane().setBackground(Color.YELLOW);
        titlePanel.setBackground(Color.GREEN);
        bonusPanel.setBackground(Color.GREEN);
        generatePanel.setBackground(Color.GREEN);
        playerPanel.setBackground(Color.GREEN);
        teamPanel.setBackground(Color.YELLOW);
        safePanel.setBackground(Color.YELLOW);
        safeTitlePanel.setBackground(Color.YELLOW);
        blankPanel.setBackground(Color.YELLOW);
        teamAPanel.setBackground(Color.YELLOW);
        teamATitlePanel.setBackground(Color.YELLOW);
        p1Panel.setBackground(Color.YELLOW);
        p2Panel.setBackground(Color.YELLOW);
        p3Panel.setBackground(Color.YELLOW);
        p4Panel.setBackground(Color.YELLOW);
        p5Panel.setBackground(Color.YELLOW);
        p6Panel.setBackground(Color.YELLOW);
        pointsBox1Panel.setBackground(Color.YELLOW);
        pointsBox2Panel.setBackground(Color.YELLOW);
        pointsBox3Panel.setBackground(Color.YELLOW);
        playPanel.setBackground(Color.GREEN);
        categoryPanel.setBackground(Color.GREEN);
        timerPanel.setBackground(Color.GREEN);
        leaderBoardPanel.setBackground(Color.YELLOW);
        lbPanel.setBackground(Color.YELLOW);
        lbTitlePanel.setBackground(Color.YELLOW);

        frame.getContentPane().add(titlePanel);
        titlePanel.add(title);
        frame.getContentPane().add(bonusPanel);
        bonusPanel.add(bonus);
        frame.getContentPane().add(generatePanel);
        generatePanel.add(generate);
        frame.getContentPane().add(playerPanel);
        playerPanel.add(teamPanel);
        playerPanel.add(safePanel);
        teamPanel.add(teamATitlePanel);
        teamATitlePanel.add(teams);
        teamPanel.add(teamAPanel);
        safePanel.add(safeTitlePanel);
        safeTitlePanel.add(safe);
        safePanel.add(safePerson);
        safePanel.add(blankPanel);
        safePanel.add(infoPanel);
        infoPanel.add(info1);
        infoPanel.add(info2);
        infoPanel.add(info3);
        infoPanel.add(info4);
        infoPanel.add(info5);
        teamAPanel.add(p1Panel);
        p1Panel.add(split1);
        p1Panel.add(steal1);
        p1Panel.add(p1);
        teamAPanel.add(p2Panel);
        p2Panel.add(split2);
        p2Panel.add(steal2);
        p2Panel.add(p2);
        teamAPanel.add(pointsBox1Panel);
        pointsBox1Panel.add(pointsBox1);
        teamAPanel.add(p3Panel);
        p3Panel.add(split3);
        p3Panel.add(steal3);
        p3Panel.add(p3);
        teamAPanel.add(p4Panel);
        p4Panel.add(split4);
        p4Panel.add(steal4);
        p4Panel.add(p4);
        teamAPanel.add(pointsBox2Panel);
        pointsBox2Panel.add(pointsBox2);
        teamAPanel.add(p5Panel);
        p5Panel.add(split5);
        p5Panel.add(steal5);
        p5Panel.add(p5);
        teamAPanel.add(p6Panel);
        p6Panel.add(split6);
        p6Panel.add(steal6);
        p6Panel.add(p6);
        teamAPanel.add(pointsBox3Panel);
        pointsBox3Panel.add(pointsBox3);
        frame.getContentPane().add(playPanel);
        playPanel.add(play);
        frame.getContentPane().add(categoryPanel);
        categoryPanel.add(category);
        frame.getContentPane().add(timerPanel);
        timerPanel.add(timeLabel);
        frame.getContentPane().add(leaderBoardPanel);
        leaderBoardPanel.add(lbTitlePanel);
        lbTitlePanel.add(points);
        lbTitlePanel.add(wildCards);
        leaderBoardPanel.add(lbPanel);
        lbPanel.add(abbie);
        lbPanel.add(kev);
        lbPanel.add(megan);
        lbPanel.add(pip);
        lbPanel.add(grandad);
        lbPanel.add(connor);
        lbPanel.add(anna);
        lbPanel.add(abbieP);
        lbPanel.add(kevP);
        lbPanel.add(meganP);
        lbPanel.add(pipP);
        lbPanel.add(grandadP);
        lbPanel.add(connorP);
        lbPanel.add(annaP);
        lbPanel.add(abbieC);
        lbPanel.add(kevC);
        lbPanel.add(meganC);
        lbPanel.add(pipC);
        lbPanel.add(grandadC);
        lbPanel.add(connorC);
        lbPanel.add(annaC);

        generate.addActionListener(this);
        split1.addActionListener(this);
        split2.addActionListener(this);
        split3.addActionListener(this);
        split4.addActionListener(this);
        split5.addActionListener(this);
        split6.addActionListener(this);
        steal1.addActionListener(this);
        steal2.addActionListener(this);
        steal3.addActionListener(this);
        steal4.addActionListener(this);
        steal5.addActionListener(this);
        steal6.addActionListener(this);
        play.addActionListener(this);
        points.addActionListener(this);
        wildCards.addActionListener(this);

        frame.setSize(1500,900);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source == points){
            generatePoints();
        }
        if(source == wildCards){
            generateCards();
        }
        if(finished == false){
            if(source == generate){
                generate();
            }
            else if(source == play){
                play();
                if(time > 0){
                    countdown.start();
                    timeLabel.setText(time + " seconds");
                }
            }
            else if(source == countdown){
                timeLabel.setText(time + " seconds");
                if(time == 0){
                    countdown.stop();
                    time = 30;
                }
                else{
                    time--;
                }
            }
            else if(source == split1 || source == steal1){
                p1Clicked = true;
                if(source == split1){
                    p1Choice = "Split";
                    p1Panel.setBackground(Color.GREEN);
                }
                else if(source == steal1){
                    p1Choice = "Steal";
                    p1Panel.setBackground(Color.RED);
                }
                if(p1Check() == true && p2Check() == true){
                    pb1 = Integer.parseInt(pointsBox1.getText());
                    if(p1Choice == "Split" && p2Choice == "Split"){
                        setPoints(p1.getText(), pb1/2);
                        setPoints(p2.getText(), pb1/2);
                    }
                    else if(p1Choice == "Split" && p2Choice == "Steal"){
                        setPoints(p1.getText(), 0);
                        setPoints(p2.getText(), pb1);
                    }
                    else if(p1Choice == "Steal" && p2Choice == "Split"){
                        setPoints(p1.getText(), pb1);
                        setPoints(p2.getText(), 0);
                    }
                    else if(p1Choice == "Steal" && p2Choice == "Steal"){
                        setPoints(p1.getText(), 0);
                        setPoints(p2.getText(), 0);
                    }

                }
            }
            else if(source == split2 || source == steal2){
                p2Clicked = true;
                if(source == split2){
                    p2Choice = "Split";
                    p2Panel.setBackground(Color.GREEN);
                }
                else if(source == steal2){
                    p2Choice = "Steal";
                    p2Panel.setBackground(Color.RED);
                }
                if(p1Check() == true && p2Check() == true){
                    pb1 = Integer.parseInt(pointsBox1.getText());
                    if(p1Choice == "Split" && p2Choice == "Split"){
                        setPoints(p1.getText(), pb1/2);
                        setPoints(p2.getText(), pb1/2);
                    }
                    else if(p1Choice == "Split" && p2Choice == "Steal"){
                        setPoints(p1.getText(), 0);
                        setPoints(p2.getText(), pb1);
                    }
                    else if(p1Choice == "Steal" && p2Choice == "Split"){
                        setPoints(p1.getText(), pb1);
                        setPoints(p2.getText(), 0);
                    }
                    else if(p1Choice == "Steal" && p2Choice == "Steal"){
                        setPoints(p1.getText(), 0);
                        setPoints(p2.getText(), 0);
                    }

                }
            }
            else if(source == split3 || source == steal3){
                p3Clicked = true;
                if(source == split3){
                    p3Choice = "Split";
                    p3Panel.setBackground(Color.GREEN);
                }
                else if(source == steal3){
                    p3Choice = "Steal";
                    p3Panel.setBackground(Color.RED);
                }
                if(p3Check() == true && p4Check() == true){
                    pb2 = Integer.parseInt(pointsBox2.getText());
                    if(p3Choice == "Split" && p4Choice == "Split"){
                        setPoints(p3.getText(), pb2/2);
                        setPoints(p4.getText(), pb2/2);
                    }
                    else if(p3Choice == "Split" && p4Choice == "Steal"){
                        setPoints(p3.getText(), 0);
                        setPoints(p4.getText(), pb2);
                    }
                    else if(p3Choice == "Steal" && p4Choice == "Split"){
                        setPoints(p3.getText(), pb2);
                        setPoints(p4.getText(), 0);
                    }
                    else if(p3Choice == "Steal" && p4Choice == "Steal"){
                        setPoints(p3.getText(), 0);
                        setPoints(p3.getText(), 0);
                    }
                }
            }
            else if(source == split4 || source == steal4){
                p4Clicked = true;
                if(source == split4){
                    p4Choice = "Split";
                    p4Panel.setBackground(Color.GREEN);
                }
                else if(source == steal4){
                    p4Choice = "Steal";
                    p4Panel.setBackground(Color.RED);
                }
                if(p3Check() == true && p4Check() == true){
                    pb2 = Integer.parseInt(pointsBox2.getText());
                    if(p3Choice == "Split" && p4Choice == "Split"){
                        setPoints(p3.getText(), pb2/2);
                        setPoints(p4.getText(), pb2/2);
                    }
                    else if(p3Choice == "Split" && p4Choice == "Steal"){
                        setPoints(p3.getText(), 0);
                        setPoints(p4.getText(), pb2);
                    }
                    else if(p3Choice == "Steal" && p4Choice == "Split"){
                        setPoints(p3.getText(), pb2);
                        setPoints(p4.getText(), 0);
                    }
                    else if(p3Choice == "Steal" && p4Choice == "Steal"){
                        setPoints(p3.getText(), 0);
                        setPoints(p3.getText(), 0);
                    }
                }
            }
            else if(source == split5 || source == steal5){
                p5Clicked = true;
                if(source == split5){
                    p5Choice = "Split";
                    p5Panel.setBackground(Color.GREEN);
                }
                else if(source == steal5){
                    p5Choice = "Steal";
                    p5Panel.setBackground(Color.RED);
                }
                if(p5Check() == true && p6Check() == true){
                    pb3 = Integer.parseInt(pointsBox3.getText());
                    if(p5Choice == "Split" && p6Choice == "Split"){
                        setPoints(p5.getText(), pb3/2);
                        setPoints(p6.getText(), pb3/2);
                    }
                    else if(p5Choice == "Split" && p6Choice == "Steal"){
                        setPoints(p5.getText(), 0);
                        setPoints(p6.getText(), pb3);
                    }
                    else if(p5Choice == "Steal" && p6Choice == "Split"){
                        setPoints(p5.getText(), pb3);
                        setPoints(p6.getText(), 0);
                    }
                    else if(p5Choice == "Steal" && p6Choice == "Steal"){
                        setPoints(p5.getText(), 0);
                        setPoints(p6.getText(), 0);
                    }
                }
            }
            else if(source == split6 || source == steal6){
                p6Clicked = true;
                if(source == split6){
                    p6Choice = "Split";
                    p6Panel.setBackground(Color.GREEN);
                }
                else if(source == steal6){
                    p6Choice = "Steal";
                    p6Panel.setBackground(Color.RED);
                }
                if(p5Check() == true && p6Check() == true){
                    pb3 = Integer.parseInt(pointsBox3.getText());
                    if(p5Choice == "Split" && p6Choice == "Split"){
                        setPoints(p5.getText(), pb3/2);
                        setPoints(p6.getText(), pb3/2);
                    }
                    else if(p5Choice == "Split" && p6Choice == "Steal"){
                        setPoints(p5.getText(), 0);
                        setPoints(p6.getText(), pb3);
                    }
                    else if(p5Choice == "Steal" && p6Choice == "Split"){
                        setPoints(p5.getText(), pb3);
                        setPoints(p6.getText(), 0);
                    }
                    else if(p5Choice == "Steal" && p6Choice == "Steal"){
                        setPoints(p5.getText(), 0);
                        setPoints(p6.getText(), 0);
                    }
                }
            }
        }
    }

    public void generate()
    {
        players.add("Abbie");
        players.add("Kev");
        players.add("Megan");
        players.add("Pip");
        players.add("Grandad");
        players.add("Connor");
        players.add("Anna");
        p1Clicked = false;
        p2Clicked = false;
        p3Clicked = false;
        p4Clicked = false;
        p5Clicked = false;
        p6Clicked = false;
        p1Panel.setBackground(Color.YELLOW);
        p2Panel.setBackground(Color.YELLOW);
        p3Panel.setBackground(Color.YELLOW);
        p4Panel.setBackground(Color.YELLOW);
        p5Panel.setBackground(Color.YELLOW);
        p6Panel.setBackground(Color.YELLOW);

        p1Choice = "";
        p2Choice = "";
        p3Choice = "";
        p4Choice = "";
        p5Choice = "";
        p6Choice = "";
        pointsBox1.setText("");
        pointsBox2.setText("");
        pointsBox3.setText("");
        pb1 = 0;
        pb2 = 0;
        pb3 = 0;
        if(safePlayers.size() < 7)
        {
            int p = 6;
            int i = rand.nextInt(playerCount);
            while(safePlayers.contains(players.get(i))){
                i = rand.nextInt(playerCount);
            }
            safePerson.setText(players.get(i));
            safePlayers.add(players.get(i));
            players.remove(i);

            i = rand.nextInt(p);
            p1.setText(players.get(i));
            players.remove(i);
            p--;
            i = rand.nextInt(p);
            p2.setText(players.get(i));
            players.remove(i);
            p--;
            i = rand.nextInt(p);
            p3.setText(players.get(i));
            players.remove(i);
            p--;
            i = rand.nextInt(p);
            p4.setText(players.get(i));
            players.remove(i);
            p--;
            i = rand.nextInt(p);
            p5.setText(players.get(i));
            players.remove(i);
            p--;
            i = rand.nextInt(p);
            p6.setText(players.get(i));
            players.remove(i);
            p--;
        }
        else{
            finished = true;
        }
    }

    public void play()
    {
        int i = rand.nextInt(list.size());
        while(used.contains(list.get(i))){
            i = rand.nextInt(list.size());
        }
        category.setText("Name as many " + list.get(i));
        used.add(list.get(i));
    }

    public void generatePoints()
    {
        abbieP.setText(Double.toString(abP));
        kevP.setText(Double.toString(keP));
        meganP.setText(Double.toString(meP));
        pipP.setText(Double.toString(piP));
        grandadP.setText(Double.toString(grP));
        connorP.setText(Double.toString(coP));
        annaP.setText(Double.toString(anP));
    }

    public boolean p1Check()
    {
        if(p1Clicked == true){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean p2Check()
    {
        if(p2Clicked == true){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean p3Check()
    {
        if(p3Clicked == true){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean p4Check()
    {
        if(p4Clicked == true){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean p5Check()
    {
        if(p5Clicked == true){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean p6Check()
    {
        if(p6Clicked == true){
            return true;
        }
        else {
            return false;
        }
    }

    public void importFile()
    {
        try{
            File myObj = new File("scategories.txt");
            Scanner sc = new Scanner(myObj);
            while(sc.hasNextLine()){
                String data = sc.nextLine();
                list.add(data);
            }
            sc.close();
        } catch(FileNotFoundException e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public void setPoints(String name, double i)
    {
        if(name == "Abbie"){
            abP = abP + i;
        }
        else if(name == "Kev"){
            keP = keP + i;
        }
        else if(name == "Megan"){
            meP = meP + i;
        }
        else if(name == "Pip"){
            piP = piP + i;
        }
        else if(name == "Grandad"){
            grP = grP + i;
        }
        else if(name == "Connor"){
            coP = coP + i;
        }
        else if(name == "Anna"){
            anP = anP + i;
        }
    }

    public void generateCards()
    {
        for(String p : pPlayers){
            if(p == "Abbie"){
                String c = wc.getCard(p);
                abbieC.setText(c);
            }
            else if(p == "Kev"){
                String c = wc.getCard(p);
                kevC.setText(c);
            }
            else if(p == "Megan"){
                String c = wc.getCard(p);
                meganC.setText(c);
            }
            else if(p == "Pip"){
                String c = wc.getCard(p);
                pipC.setText(c);
            }
            else if(p== "Grandad"){
                String c = wc.getCard(p);
                grandadC.setText(c);
            }
            else if(p == "Connor"){
                String c = wc.getCard(p);
                connorC.setText(c);
            }
            else if(p == "Anna"){
                String c = wc.getCard(p);
                annaC.setText(c);
            }
        }
    }
}
