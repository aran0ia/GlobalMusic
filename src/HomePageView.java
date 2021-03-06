import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class for the homepage (for customer and organization type of users).
 *
 */

public class HomePageView {

	private JButton searchButton;
    private JButton myAccountButton;
    private JButton bookingsButton;
    private JButton changePassButton ;
    private JFrame frame;


    /**
     * Create the frame
     */
    public HomePageView() {
        initialize();
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Global Music");
        frame.setBounds(100, 100, 1280, 690);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);

        /*
         * Container for creating the 4 panels in one frame.
         * With CardLayout.
         */
        Container c = new Container();
        c.setBounds(250,50,1000,550);
        c.setLayout(new CardLayout());
        JPanel search = new SearchEventsPanel();
        JPanel pass = new ChangePasswordView();
        c.add("Search",search);
        c.add("History",new BookingsHistoryView());
        c.add("MyAccount", new MyAccountView());
        c.add("Password",pass);
        ((CardLayout)c.getLayout()).first(c);
        frame.add(c);

        /*
            Each of the 4 following buttons loads the corresponding
            panel on the container's cardLayout, disables itself and activates
            the rest of the buttons
         */

        searchButton = new JButton("Search events");
        searchButton.addActionListener(e -> {
            ((CardLayout)c.getLayout()).show(c,"Search");

            searchButton.setEnabled(false);
            myAccountButton.setEnabled(true);
            changePassButton.setEnabled(true);
            bookingsButton.setEnabled(true);
        });
        searchButton.setForeground(SystemColor.inactiveCaption);
        searchButton.setFont(new Font("Open Sans", Font.PLAIN, 20));
        searchButton.setBounds(27, 111, 200, 53);
        searchButton.setOpaque(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setToolTipText("See upcoming or search for your favorite events");
        searchButton.setBorderPainted(false);
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setEnabled(false);
        frame.getContentPane().add(searchButton);

        myAccountButton = new JButton("My Account");
        myAccountButton.addActionListener(e -> {
            ((CardLayout)c.getLayout()).show(c,"MyAccount");
            searchButton.setEnabled(true);
            myAccountButton.setEnabled(false);
            changePassButton.setEnabled(true);
            bookingsButton.setEnabled(true);

        });
        myAccountButton.setForeground(SystemColor.inactiveCaption);
        myAccountButton.setFont(new Font("Open Sans", Font.PLAIN, 20));
        myAccountButton.setOpaque(false);
        myAccountButton.setContentAreaFilled(false);
        myAccountButton.setBorderPainted(false);
        myAccountButton.setBounds(27, 189, 200, 53);
        myAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        myAccountButton.setToolTipText("Edit your personal details");
        frame.getContentPane().add(myAccountButton);
        
        changePassButton = new JButton("Change Password");
        changePassButton.addActionListener(e -> {

            ((CardLayout)c.getLayout()).show(c,"Password");
            searchButton.setEnabled(true);
            myAccountButton.setEnabled(true);
            changePassButton.setEnabled(false);
            bookingsButton.setEnabled(true);
        });
        changePassButton.setForeground(SystemColor.inactiveCaption);
        changePassButton.setFont(new Font("Open Sans", Font.PLAIN, 20));
        changePassButton.setOpaque(false);
        changePassButton.setContentAreaFilled(false);
        changePassButton.setBorderPainted(false);
        changePassButton.setBounds(27, 268, 200, 53);
        changePassButton.setToolTipText("Update security details");
        changePassButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.getContentPane().add(changePassButton);

        bookingsButton = new JButton("My bookings");
        bookingsButton.addActionListener(e -> {
            //Check if the card is a BookingHistoryView object and refreshes the data on the table
            for (Component card : c.getComponents()){
                if (card instanceof BookingsHistoryView){
                    ((BookingsHistoryView) card).refreshTableData();
                    }
            }
            ((CardLayout)c.getLayout()).show(c,"History");

            searchButton.setEnabled(true);
            myAccountButton.setEnabled(true);
            changePassButton.setEnabled(true);
            bookingsButton.setEnabled(false);
        });
        bookingsButton.setForeground(SystemColor.inactiveCaption);
        bookingsButton.setFont(new Font("Open Sans", Font.PLAIN, 20));
        bookingsButton.setOpaque(false);
        bookingsButton.setContentAreaFilled(false);
        bookingsButton.setBorderPainted(false);
        bookingsButton.setBounds(27, 346, 200, 53);
        bookingsButton.setToolTipText("View your booked events");
        bookingsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.getContentPane().add(bookingsButton);

        //Load the LoginView
        JButton logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(e -> {
            new LoginView();
            frame.setVisible(false);
        });
        logOutButton.setBounds(27, 426, 200, 53);
        logOutButton.setForeground(SystemColor.inactiveCaption);
        logOutButton.setFont(new Font("Open Sans", Font.PLAIN, 20));
        logOutButton.setOpaque(false);
        logOutButton.setContentAreaFilled(false);
        logOutButton.setBorderPainted(false);
        logOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.getContentPane().add(logOutButton);
        

        
        
       //Exit the application
        JButton exitButton = new JButton("X");
        exitButton.setForeground(SystemColor.inactiveCaption);
        exitButton.addActionListener(e -> {
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Exit?", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        exitButton.setFont(new Font("Open Sans", Font.PLAIN, 25));
        exitButton.setBorderPainted(false);
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBounds(1205, 13, 63, 53);
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.getContentPane().add(exitButton);

        //Minimize the application
        JButton minimizeButton = new JButton("___");
        minimizeButton.setForeground(SystemColor.inactiveCaption);
        minimizeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                frame.setExtendedState(JFrame.ICONIFIED);
            }
        });
        minimizeButton.setOpaque(false);
        minimizeButton.setContentAreaFilled(false);
        minimizeButton.setBorderPainted(false);
        minimizeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        minimizeButton.setBounds(1154, 20, 63, 38);
        frame.getContentPane().add(minimizeButton);

        JSeparator separator = new JSeparator();
        separator.setBackground(SystemColor.inactiveCaption);
        separator.setOpaque(true);
        separator.setBounds(60, 148, 130, 3);
        frame.getContentPane().add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBackground(SystemColor.inactiveCaption);
        separator_1.setOpaque(true);
        separator_1.setBounds(66, 227, 120, 3);
        frame.getContentPane().add(separator_1);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBackground(SystemColor.inactiveCaption);
        separator_2.setOpaque(true);
        separator_2.setBounds(35, 306, 190, 3);
        frame.getContentPane().add(separator_2);
        
        JSeparator separator_3 = new JSeparator();
        separator_3.setOpaque(true);
        separator_3.setBackground(SystemColor.inactiveCaption);
        separator_3.setBounds(66, 384, 120, 3);
        frame.getContentPane().add(separator_3);
        
        JSeparator separator_4 = new JSeparator();
        separator_4.setBackground(SystemColor.inactiveCaption);
        separator_4.setOpaque(true);
        separator_4.setBounds(76, 465, 100, 3);
        frame.getContentPane().add(separator_4);
        
        
        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(Main.IMAGE_DIR+"Logo.jpg"));
        lblLogo.setBounds(186, 583, 200, 96);
        frame.getContentPane().add(lblLogo);
        //frame.getRootPane().setDefaultButton(searchButton1);
        
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(new ImageIcon(Main.IMAGE_DIR+"Silhouette-Rock-Concert-Wallpaper1.jpg"));
        backgroundLabel.setBounds(0, 0, 1280, 690);
        frame.getContentPane().add(backgroundLabel);

    }
}