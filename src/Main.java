import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Main {
    JFrame window;
    Container cont;
    JPanel splashScreen;
    JLabel splashTitle;
    // Basic font, replaced by custom font
    // Font titleFont = new Font("Times New Roman", Font.PLAIN, 28);

    public static void main(String[] args) {
        new Main ();

    }

    public Main() {

        // Font, move to another place, tidy up
        Font gameFont = null;
        try {
            gameFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("font.ttf").openStream());
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        genv.registerFont(gameFont);
    // font size
        gameFont = gameFont.deriveFont(40f);

        // -------------- End Font
        window = new JFrame();
        window.setSize(900, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.getContentPane().setBackground(Color.darkGray);
        window.setLayout(null);
        cont = window.getContentPane();

        splashScreen = new JPanel();
        splashScreen.setBounds(150, 150, 600, 200);
        splashScreen.setBackground(Color.darkGray);

        splashTitle = new JLabel("Dungeon Masters");
        splashTitle.setForeground(Color.white);
        splashTitle.setFont(gameFont);
        splashScreen.add(splashTitle);
        cont.add(splashScreen);


    }



}