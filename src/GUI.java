import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;


public class GUI {
    JFrame window;
    Container cont;
    JPanel splashScreen, splashButton, mainText, mainSelector, playerPanel;
    JLabel splashTitle, healthLabel, healthLabelValue, weaponLabel, weaponLabelValue;
    JTextArea mainTextArea;
    JButton startGameButton, choice1, choice2, choice3, choice4;
    Font gameFont = null;
    Font gameFontSmall = null;
    int playerHP;
    String playerWeapon;

public void createGUI(Main.ChoiceHandler cHandler){
    // Importing a custom font
    ImportFont();
    // Creating a  GUI Window of fixed size
    window = new JFrame();
    window.setSize(900, 600);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setLocationRelativeTo(null);
    window.getContentPane().setBackground(Color.darkGray);
    window.setLayout(null);
    cont = window.getContentPane();

    // Creating panels of fixed size containing the splash screen text and button
    splashScreen = new JPanel();
    splashScreen.setBounds(150, 150, 600, 100);
    splashScreen.setBackground(Color.darkGray);

    splashTitle = new JLabel("Dungeon Masters");
    splashTitle.setForeground(Color.white);
    splashTitle.setFont(gameFont);
    // Creating the main menu
    splashButton = new JPanel();
    splashButton.setBounds(325, 300, 250, 100);
    splashButton.setBackground(Color.darkGray);

    startGameButton = new JButton("Begin Adventure");
    startGameButton.setFont(gameFontSmall);
    startGameButton.setBackground(Color.lightGray);
    startGameButton.setForeground(Color.black);
    startGameButton.setFocusPainted(false);
    startGameButton.addActionListener(cHandler);
    startGameButton.setActionCommand("start");

    splashScreen.add(splashTitle);
    splashButton.add(startGameButton);

    cont.add(splashScreen);
    cont.add(splashButton);

    //Creating the game menu and buttons

    mainText = new JPanel();
    mainText.setLayout(new BorderLayout());

    mainSelector = new JPanel();
    mainSelector.setLayout(new BoxLayout(mainSelector, BoxLayout.Y_AXIS));

    choice1 = ChoiceButton();
    choice2 = ChoiceButton();
    choice3 = ChoiceButton();
    choice4 = ChoiceButton();

    choice1.addActionListener(cHandler);
    choice2.addActionListener(cHandler);
    choice3.addActionListener(cHandler);
    choice4.addActionListener(cHandler);

    choice1.setActionCommand("c1");
    choice2.setActionCommand("c2");
    choice3.setActionCommand("c3");
    choice4.setActionCommand("c4");

    mainSelector.add(Box.createRigidArea(new Dimension(0, 15)));
    mainSelector.add(choice1);
    mainSelector.add(Box.createRigidArea(new Dimension(0, 15)));
    mainSelector.add(choice2);
    mainSelector.add(Box.createRigidArea(new Dimension(0, 15)));
    mainSelector.add(choice3);
    mainSelector.add(Box.createRigidArea(new Dimension(0, 15)));
    mainSelector.add(choice4);

    mainTextArea = new JTextArea();
    mainTextArea.setEditable(false);
    mainTextArea.setBackground(Color.black);
    mainTextArea.setForeground(Color.white);
    mainTextArea.setFont(gameFontSmall);
    mainTextArea.setLineWrap(true);
    mainTextArea.setWrapStyleWord(true);
    mainTextArea.setEditable(false);

    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel upperPanel = new JPanel();

    leftPanel.setPreferredSize(new Dimension(60, 50));
    rightPanel.setPreferredSize(new Dimension(50, 50));
    upperPanel.setPreferredSize(new Dimension(100, 70));
    mainSelector.setPreferredSize(new Dimension(50, 275));

    leftPanel.setBackground(Color.darkGray);
    rightPanel.setBackground(Color.darkGray);
    upperPanel.setBackground(Color.darkGray);
    mainSelector.setBackground(Color.darkGray);

    mainText.add(mainTextArea, BorderLayout.CENTER);
    mainText.add(leftPanel, BorderLayout.WEST);
    mainText.add(rightPanel, BorderLayout.EAST);
    mainText.add(upperPanel, BorderLayout.NORTH);
    mainText.add(mainSelector, BorderLayout.SOUTH);

    playerPanel = new JPanel();
    playerPanel.setLayout(new GridLayout(1,4));
    playerPanel.setBackground(Color.darkGray);
    upperPanel.add(playerPanel);

    healthLabel = new JLabel("HP: ");
    healthLabel.setFont(gameFontSmall);
    healthLabel.setForeground(Color.white);
    playerPanel.add(healthLabel);
    healthLabel.setHorizontalAlignment(JLabel.RIGHT);

    healthLabelValue = new JLabel();
    healthLabelValue.setFont(gameFontSmall);
    healthLabelValue.setForeground(Color.white);
    playerPanel.add(healthLabelValue);
    healthLabelValue.setHorizontalAlignment(JLabel.LEFT);

    weaponLabel = new JLabel("Weapon: ");
    weaponLabel.setFont(gameFontSmall);
    weaponLabel.setForeground(Color.white);
    weaponLabel.setHorizontalAlignment(JLabel.RIGHT);
    playerPanel.add(weaponLabel);


    weaponLabelValue = new JLabel();
    weaponLabelValue.setFont(gameFontSmall);
    weaponLabelValue.setForeground(Color.white);
    weaponLabelValue.setHorizontalAlignment(JLabel.LEFT);
    playerPanel.add(weaponLabelValue);


    }

    public JButton ChoiceButton(){
        JButton choice;
        choice = new JButton();
        choice.setBackground(Color.lightGray);
        choice.setForeground(Color.black);
        choice.setFocusPainted(false);
        choice.setFont(gameFontSmall);
        choice.setAlignmentX(Component.CENTER_ALIGNMENT);
        choice.setMaximumSize(new Dimension(300, 50));
        return choice;
    }
    public void ImportFont(){
        try {
            gameFont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getResource("font.ttf")).openStream());
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        genv.registerFont(gameFont);
        // font size
        gameFont = gameFont.deriveFont(50f);
        gameFontSmall = gameFont.deriveFont(20f);

    }

//    public void playerStats(){
////        Player p1 = new Player();
////        playerHP = p1.getMaxHP();
////        playerWeapon = p1.getWeapon();
////        healthLabelValue.setText(String.valueOf(playerHP));
////        weaponLabelValue.setText(playerWeapon);
//
//        startGame();
//    }
//
//    public void startGame(){
//        mainTextArea.setText("You wake up and find yourself surrounded by darkness. A shimmering light passes through" +
//                " the ceiling, revealing an old wooden door. There is a key on the table, it might fit the door." +
//                " What do you do? ");
//
////        Room starter = new Room("startRoom", "An empty place, there isn't much here", "Garden");
////        Room garden = new Room("garden", "The outside garden");
////        starter.put()
//
//    }
}
