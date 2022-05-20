public class Gameplay {
    Main main;
    GUI gui;
    WindowManager wm;
    Player p1 = new Player();
    Mob mob;
    public  Gameplay(Main m, GUI guiManager, WindowManager wManager){
        main = m;
        gui = guiManager;
        wm = wManager;

    }
    public void startLoadout(){
        p1.setCurrentHp(8);
        p1.setWeapon("Bare Fists");
        p1.setWeaponDamage(3);
        gui.playerHP = p1.getCurrentHp();
        gui.playerWeapon = p1.getWeapon();
        gui.healthLabelValue.setText(String.valueOf(gui.playerHP));
        gui.weaponLabelValue.setText(gui.playerWeapon);
    }

    public void nextSelect(String nextSelect){
        switch(nextSelect){
            case "goBackStart": startGameText(); break;
            case "goOutside": goOutside(); break;
            case "takeKey": takeKey(); break;
            case "tryDoor": tryDoor(); break;
            case "goBackStart2": goBackStart2(); break;
            case "openTrapdoor": openTrapdoor(); break;
            case "goDeeper": goDeeper(); break;
        }
    }

    public void startGameText(){
        gui.mainTextArea.setText("You wake up and find yourself surrounded by darkness. A shimmering light passes through" +
                " the ceiling, revealing an old wooden door. There is a key on the table, it might fit the door." +
                " What do you do? ");
        gui.choice1.setText("Try Door");
        gui.choice2.setText("Take Key");
        gui.choice3.setText("");
        gui.choice4.setText("");

        main.next1 = "tryDoor";
        main.next2 = "takeKey";
        main.next3 = "";
        main.next4 = "";

    }
    public void tryDoor(){
        gui.mainTextArea.setText("The door won't budge. It seems like it needs a key of some sort.");
        gui.choice1.setText("<");
        gui.choice2.setText("");
        gui.choice3.setText("");
        gui.choice4.setText("");

        main.next1 = "goBackStart";
        main.next2 = "takeKey";
        main.next3 = "";
        main.next4 = "";

    }

    public void takeKey(){
        gui.mainTextArea.setText("You took the key.");
        gui.choice1.setText("Use key.");
        gui.choice2.setText("");
        gui.choice3.setText("");
        gui.choice4.setText("");

        main.next1 = "goOutside";
        main.next2 = "";
        main.next3 = "";
        main.next4 = "";

    }

    public void goOutside(){
        gui.mainTextArea.setText("You push the key into the old rusted keyhole. A faint crackle can be heard. You open" +
                " the door and feel a slight sense of freedom. The moonlight is still faint, you can barely make out" +
                " a trapdoor in front of you.");
        gui.choice1.setText("Open trapdoor");
        gui.choice2.setText("Go Back inside");
        gui.choice3.setText("");
        gui.choice4.setText("");

        main.next1 = "openTrapdoor";
        main.next2 = "goBackStart2";
        main.next3 = "";
        main.next4 = "";

    }

    public void goBackStart2(){
        gui.mainTextArea.setText("A shimmering light passes through" +
                " the ceiling, revealing an old wooden door. There is a key in the door. ");
        gui.choice1.setText("Go Outside");
        gui.choice2.setText("");
        gui.choice3.setText("");
        gui.choice4.setText("");

        main.next1 = "goOutside";
        main.next2 = "";
        main.next3 = "";
        main.next4 = "";
    }

    public void openTrapdoor(){
        gui.mainTextArea.setText("You open the squeaky trapdoor and climb inside. There are steps going down" +
                " and torches light the way. It smells of mold and century-old stone.");
        gui.choice1.setText("Go deeper");
        gui.choice2.setText("");
        gui.choice3.setText("");
        gui.choice4.setText("");

        main.next1 = "goDeeper";
        main.next2 = "";
        main.next3 = "";
        main.next4 = "";

    }

    public void goDeeper(){
        p1.setCurrentHp(6);
        updateStats();
        gui.mainTextArea.setText("You descend slowly into the circular tunnel. You hear squeaking coming from below. " +
                "Bats are rushing to go outside. You try to defend yourself but you only have your hands to protect you." +
                " (You take 2 damage)");
        gui.choice1.setText("Thanks for playing");
        gui.choice2.setText("");
        gui.choice3.setText("");
        gui.choice4.setText("");


        main.next1 = "";
        main.next2 = "";
        main.next3 = "";
        main.next4 = "";
    }



public void updateStats(){
    gui.playerHP = p1.getCurrentHp();
    gui.playerWeapon = p1.getWeapon();
    gui.healthLabelValue.setText(String.valueOf(gui.playerHP));
    gui.weaponLabelValue.setText(gui.playerWeapon);
}


}
