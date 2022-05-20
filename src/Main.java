import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



public class Main {

    GUI gui = new GUI();
    ChoiceHandler cHandler = new ChoiceHandler();
    WindowManager wm = new WindowManager(gui);
    Gameplay gameplay = new Gameplay(this, gui, wm);
    String next1, next2, next3, next4;

    public static void main(String[] args) {
        new Main();

    }

    public Main() {
        gui.createGUI(cHandler);
        Audit("createGUI");
        wm.showSplashScreen();
        Audit("showSplashScreen");

        List<Mob> mobs = Mob.readMobsFromCSV("C:\\Users\\Chris\\Desktop\\TextGame\\src\\mobs.csv");
        Audit("ListMobs");

        mobs.forEach(System.out::println);
    }


    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch(yourChoice){
                case "start": gameplay.startLoadout(); gameplay.startGameText(); wm.startGame();break;
                case "c1":gameplay.nextSelect(next1);break;
                case "c2":gameplay.nextSelect(next2);break;
                case "c3":gameplay.nextSelect(next3);break;
                case "c4":gameplay.nextSelect(next4);break;
            }

        }
    }

    public void Audit(String audit) {
        try {
            LocalDateTime theTime = LocalDateTime.now();
            DateTimeFormatter theFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedTime = theTime.format(theFormat);
            File auditFile = new File("C:\\Users\\Chris\\Desktop\\TextGame\\src\\audit.csv");
            FileWriter fileWriter = new FileWriter(auditFile, true);

            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write(String.join(",", audit, formattedTime));
            writer.newLine();

            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

