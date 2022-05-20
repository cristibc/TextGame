public class WindowManager {
    GUI gui;
    public WindowManager(GUI gameGUI){
        gui = gameGUI;
    }

    public void showSplashScreen(){
        gui.splashScreen.setVisible(true);
        gui.window.setVisible(true);
    }

    public void startGame(){
    gui.window.getContentPane().removeAll();
    gui.window.repaint();
    gui.window.setContentPane(gui.mainText);
    gui.window.setVisible(true);
    }
}
