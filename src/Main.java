import java.awt.*;

/**
 * Class for running the main frame of the application.
 * @author x64
 *
 */
public class Main {

    final static String IMAGE_DIR = "Images/";
    final static String ARTIST_IMAGE_DIR = "Images/Artist_Images/";
    final static String EVENT_IMAGE_DIR = "Images/Event_Images/";
    final static String CARD_ICON_DIR = "Images/Card_Icons/";


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginView window = new LoginView();
                    //window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
