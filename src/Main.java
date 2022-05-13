import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;


public class Main {
    JFrame window;
    Container cont;
    JPanel splashScreen, splashButton, mainText, mainSelector;
    JLabel splashTitle;
    JTextArea mainTextArea;
    JButton startGameButton, choice1, choice2, choice3, choice4;
    Font gameFont = null;
    Font gameFontSmall = null;

    StartHandler sHandler = new StartHandler();

    public static void main(String[] args) {
        new Main();


    }

    public Main() {
        ImportFont();
        window = new JFrame();
        window.setSize(900, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.getContentPane().setBackground(Color.darkGray);
        window.setLayout(null);
        window.setVisible(true);
        cont = window.getContentPane();

        splashScreen = new JPanel();
        splashScreen.setBounds(150, 150, 600, 100);
        splashScreen.setBackground(Color.darkGray);

        splashTitle = new JLabel("Dungeon Masters");
        splashTitle.setForeground(Color.white);
        splashTitle.setFont(gameFont);

        splashButton = new JPanel();
        splashButton.setBounds(325, 300, 250, 100);
        splashButton.setBackground(Color.darkGray);

        startGameButton = new JButton("Begin Adventure");
        startGameButton.setFont(gameFontSmall);
        startGameButton.setBackground(Color.lightGray);
        startGameButton.setForeground(Color.black);
        startGameButton.setFocusPainted(false);
        startGameButton.addActionListener(sHandler);

        splashScreen.add(splashTitle);
        splashButton.add(startGameButton);

        cont.add(splashScreen);
        cont.add(splashButton);
    }

    public void beginGame() {
        window.getContentPane().removeAll();
        window.repaint();

        mainText = new JPanel();
        mainText.setLayout(new BorderLayout());

        mainSelector = new JPanel();
        mainSelector.setLayout(new BoxLayout(mainSelector, BoxLayout.Y_AXIS));

        choice1 = ChoiceButton("choice 1");
        choice2 = ChoiceButton("choice 2");
        choice3 = ChoiceButton("choice 3");
        choice4 = ChoiceButton("choice 4");

        mainSelector.add(Box.createRigidArea(new Dimension(0, 15)));
        mainSelector.add(choice1);
        mainSelector.add(Box.createRigidArea(new Dimension(0, 15)));
        mainSelector.add(choice2);
        mainSelector.add(Box.createRigidArea(new Dimension(0, 15)));
        mainSelector.add(choice3);
        mainSelector.add(Box.createRigidArea(new Dimension(0, 15)));
        mainSelector.add(choice4);

        mainTextArea = new JTextArea();
        mainTextArea.setText(" Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
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
        upperPanel.setPreferredSize(new Dimension(100, 50));
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

        window.setContentPane(mainText);
        window.setVisible(true);

    }

    public JButton ChoiceButton(String text){
        JButton choice;
        choice = new JButton(text);
        choice.setBackground(Color.lightGray);
        choice.setForeground(Color.black);
        choice.setFocusPainted(false);
        choice.setFont(gameFontSmall);
        choice.setAlignmentX(Component.CENTER_ALIGNMENT);
        choice.setMaximumSize(new Dimension(300, 50));
        return choice;
    }

    public void ImportFont(){
        // Font, move to another place, tidy up

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

        // -------------- End Font
    }
    public class StartHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            beginGame();
        }
    }

}