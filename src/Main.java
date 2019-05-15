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
    final static String INVOICES_DIR = "Images/Invoices/";


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new LoginView();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
