import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.Pattern;


/**
 * Class that creates a frame for creating a new customer user
 *
 */
public class RegisterView {
    private JFrame frame;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField addressOneField;
    private JTextField addressTwoField;
    private JTextField townField;
    private JTextField postcodeField;
    private JTextField emailField;
    private JTextField phoneNoField;
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField confirmPasswordField;
    private JTextField orgNameField;
    private JTextField orgEmailField;
    private JTextField cardNoField;
    private JTextField CVVField;
    private JTextField webAddressField;
    static boolean checkType = false;
    private CreditCardIconsPanel cardIconPanel;


    /**
     * Create the frame.
     */
    public RegisterView() {
        initialize();
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Open Sans", Font.BOLD, 11));
        frame.getContentPane().setForeground(new Color(128, 128, 128));
        frame.setResizable(false);
        frame.setTitle("Global Music");
        frame.setBounds(100, 100, 1280, 690);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);



        JLabel lblEmailInvalid = new JLabel("Email Already Exists");
        lblEmailInvalid.setForeground(Color.RED);
        lblEmailInvalid.setBounds(119, 361, 124, 14);
        frame.getContentPane().add(lblEmailInvalid);
        lblEmailInvalid.setVisible(false);


        JLabel lblBetweenAnd = new JLabel("(between 5 and 16 characters)");
        lblBetweenAnd.setForeground(SystemColor.inactiveCaption);
        lblBetweenAnd.setBounds(119, 475, 209, 14);
        frame.getContentPane().add(lblBetweenAnd);
        lblBetweenAnd.setVisible(true);


        JLabel lblUsernameAlreadyExists = new JLabel("Username Already Exists");
        lblUsernameAlreadyExists.setForeground(Color.RED);
        lblUsernameAlreadyExists.setBounds(119, 437, 150, 14);
        frame.getContentPane().add(lblUsernameAlreadyExists);
        lblUsernameAlreadyExists.setVisible(false);


        JLabel lblIncorrectPassword = new JLabel("Incorrect Password");
        lblIncorrectPassword.setForeground(Color.RED);
        lblIncorrectPassword.setBounds(119, 513, 124, 14);
        frame.getContentPane().add(lblIncorrectPassword);
        lblIncorrectPassword.setVisible(false);


        JLabel lblIncorrectPassword_1 = new JLabel("Incorrect Password");
        lblIncorrectPassword_1.setForeground(Color.RED);
        lblIncorrectPassword_1.setBounds(393, 513, 137, 14);
        frame.getContentPane().add(lblIncorrectPassword_1);
        lblIncorrectPassword_1.setVisible(false);

        JLabel lblTitleLabel = new JLabel("Please fill in all the fields marked with *");
        lblTitleLabel.setForeground(SystemColor.activeCaption);
        lblTitleLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
        lblTitleLabel.setBounds(38, 23, 638, 32);
        frame.getContentPane().add(lblTitleLabel);
        lblTitleLabel.setVisible(true);


        JLabel lblInvalidCardNumber = new JLabel("Invalid Number");
        lblInvalidCardNumber.setForeground(Color.RED);
        lblInvalidCardNumber.setBounds(119, 582, 100, 14);
        frame.getContentPane().add(lblInvalidCardNumber);
        lblInvalidCardNumber.setVisible(false);


        JLabel lblInvalidCVV = new JLabel("Invalid Number");
        lblInvalidCVV.setForeground(Color.RED);
        lblInvalidCVV.setBounds(393, 582, 110, 14);
        frame.getContentPane().add(lblInvalidCVV);
        lblInvalidCVV.setVisible(false);


        JLabel lblAllFields = new JLabel("All * fields are required !");
        lblAllFields.setFont(new Font("Open Sans", Font.BOLD, 14));
        lblAllFields.setForeground(Color.RED);
        lblAllFields.setBounds(976, 561, 214, 14);
        frame.getContentPane().add(lblAllFields);
        lblAllFields.setVisible(false);

        //Exit the application
        JButton btnExitButton = new JButton("X");
        btnExitButton.addActionListener(e -> {
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Exit?", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                System.exit(0);
                }
        });
        btnExitButton.setFont(new Font("Open Sans", Font.PLAIN, 25));
        btnExitButton.setForeground(SystemColor.inactiveCaption);
        btnExitButton.setBounds(1205, 13, 63, 53);
        btnExitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnExitButton.setOpaque(false);
        btnExitButton.setBorderPainted(false);
        btnExitButton.setContentAreaFilled(false);
        frame.getContentPane().add(btnExitButton);
        
        //Minimize the application
        JButton minimizeButton = new JButton("___");
        minimizeButton.addActionListener(arg0 -> {
        });
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



        JLabel lblTitle = new JLabel("Title");
        lblTitle.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblTitle.setForeground(SystemColor.inactiveCaption);
        lblTitle.setBounds(38, 66, 56, 16);
        frame.getContentPane().add(lblTitle);
        lblTitle.setVisible(true);


        JComboBox<String> titleComboBox = new JComboBox<>();
        titleComboBox.setBackground(SystemColor.activeCaption);
        titleComboBox.setToolTipText("");
        titleComboBox.setMaximumRowCount(2);
        titleComboBox.setBounds(119, 67, 56, 17);
        titleComboBox.addItem("Mr.");
        titleComboBox.addItem("Ms.");
        titleComboBox.setEditable(false);
        frame.getContentPane().add(titleComboBox);
        titleComboBox.setVisible(true);


        JLabel lblFirstName = new JLabel("First Name *");
        lblFirstName.setForeground(SystemColor.inactiveCaption);
        lblFirstName.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblFirstName.setBounds(38, 130, 82, 16);
        frame.getContentPane().add(lblFirstName);
        lblFirstName.setVisible(true);


        firstNameField = new JTextField();
        firstNameField.setBackground(SystemColor.activeCaption);
        firstNameField.setBorder(new MatteBorder(2, 2, 2, 2, SystemColor.activeCaption));
        firstNameField.setBounds(119, 129, 150, 20);
        frame.getContentPane().add(firstNameField);
        firstNameField.setColumns(10);
        firstNameField.setVisible(true);


        JLabel lblLastName = new JLabel("Last Name *");
        lblLastName.setForeground(SystemColor.inactiveCaption);
        lblLastName.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblLastName.setBounds(301, 130, 82, 16);
        frame.getContentPane().add(lblLastName);
        lblLastName.setVisible(true);


        lastNameField = new JTextField();
        lastNameField.setBackground(SystemColor.activeCaption);
        lastNameField.setBorder(new MatteBorder(2, 2, 2, 2, SystemColor.activeCaption));
        lastNameField.setBounds(393, 129, 150, 20);
        frame.getContentPane().add(lastNameField);
        lastNameField.setColumns(10);
        lastNameField.setVisible(true);


        JLabel lblAddressOne = new JLabel("Address 1 *");
        lblAddressOne.setForeground(SystemColor.inactiveCaption);
        lblAddressOne.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblAddressOne.setBounds(38, 200, 100, 16);
        frame.getContentPane().add(lblAddressOne);
        lblAddressOne.setVisible(true);


        addressOneField = new JTextField();
        addressOneField.setBackground(SystemColor.activeCaption);
        addressOneField.setBorder(new MatteBorder(2, 2, 2, 2, SystemColor.activeCaption));
        addressOneField.setBounds(119, 199, 150, 20);
        frame.getContentPane().add(addressOneField);
        addressOneField.setColumns(10);
        addressOneField.setVisible(true);


        JLabel lblAddressTwo = new JLabel("Address 2");
        lblAddressTwo.setForeground(SystemColor.inactiveCaption);
        lblAddressTwo.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblAddressTwo.setBounds(301, 200, 82, 16);
        frame.getContentPane().add(lblAddressTwo);
        lblAddressTwo.setVisible(true);


        addressTwoField = new JTextField();
        addressTwoField.setText("");
        addressTwoField.setBackground(SystemColor.activeCaption);
        addressTwoField.setBorder(new MatteBorder(2, 2, 2, 2, SystemColor.activeCaption));
        addressTwoField.setBounds(393, 199, 150, 20);
        frame.getContentPane().add(addressTwoField);
        addressTwoField.setColumns(10);
        addressTwoField.setVisible(true);


        JLabel lblTown = new JLabel("Town *");
        lblTown.setForeground(SystemColor.inactiveCaption);
        lblTown.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblTown.setBounds(38, 269, 71, 16);
        frame.getContentPane().add(lblTown);
        lblTown.setVisible(true);


        townField = new JTextField();
        townField.setBackground(SystemColor.activeCaption);
        townField.setBorder(new MatteBorder(2, 2, 2, 2, SystemColor.activeCaption));
        townField.setBounds(119, 268, 150, 20);
        frame.getContentPane().add(townField);
        townField.setColumns(10);
        townField.setVisible(true);


        JLabel lblPostCode = new JLabel("Post Code *");
        lblPostCode.setForeground(SystemColor.inactiveCaption);
        lblPostCode.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblPostCode.setBounds(301, 269, 82, 16);
        frame.getContentPane().add(lblPostCode);
        lblPostCode.setVisible(true);


        postcodeField = new JTextField();
        postcodeField.setBackground(SystemColor.activeCaption);
        postcodeField.setBorder(new MatteBorder(2, 2, 2, 2,  SystemColor.activeCaption));
        postcodeField.setBounds(393, 268, 150, 20);
        frame.getContentPane().add(postcodeField);
        postcodeField.setColumns(10);
        postcodeField.setVisible(true);


        JLabel lblEmail = new JLabel("E-mail *");
        lblEmail.setForeground(SystemColor.inactiveCaption);
        lblEmail.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblEmail.setBounds(38, 344, 56, 14);
        frame.getContentPane().add(lblEmail);
        lblEmail.setVisible(true);


        emailField = new JTextField();
        emailField.setBackground(SystemColor.activeCaption);
        emailField.setBorder(new MatteBorder(2, 2, 2, 2, SystemColor.activeCaption));
        emailField.setBounds(119, 342, 150, 20);
        frame.getContentPane().add(emailField);
        emailField.setColumns(10);
        emailField.setVisible(true);
        //check if entered value is formatted as email and then if it exists already in the database
        emailField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {}
            public void focusLost(FocusEvent e) {
                String email = emailField.getText();
                //Regex source: emailregex.com
                Pattern emailRegex = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)" +
                        "*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\" +
                        "[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+" +
                        "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" +
                        "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:" +
                        "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])");
                User user = new User();
                if(!emailRegex.matcher(email).matches()){
                    lblEmailInvalid.setText("Invalid email address");
                    lblEmailInvalid.setVisible(true);
                    emailField.setText("");
                }
                else if (user.checkFieldInDB("Email",email.replace("'", "''"))) {
                    lblEmailInvalid.setText("Email already exists");
                    lblEmailInvalid.setVisible(true);
                    emailField.setText("");
                }
                else {lblEmailInvalid.setVisible(false);}

            }
        });


        JLabel lblPhoneNo = new JLabel("Phone No");
        lblPhoneNo.setForeground(SystemColor.inactiveCaption);
        lblPhoneNo.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblPhoneNo.setBounds(301, 344, 71, 14);
        frame.getContentPane().add(lblPhoneNo);
        lblPhoneNo.setVisible(true);


        phoneNoField = new JTextField();
        phoneNoField.setText("");
        phoneNoField.setBackground(SystemColor.activeCaption);
        phoneNoField.setBorder(new MatteBorder(2, 2, 2, 2, SystemColor.activeCaption));
        phoneNoField.setBounds(393, 342, 150, 20);
        frame.getContentPane().add(phoneNoField);
        phoneNoField.setColumns(10);
        phoneNoField.setVisible(true);


        JLabel lblUsername = new JLabel("Username *");
        lblUsername.setForeground(SystemColor.inactiveCaption);
        lblUsername.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblUsername.setBounds(38, 418, 100, 14);
        frame.getContentPane().add(lblUsername);
        lblUsername.setVisible(true);


        usernameField = new JTextField();
        usernameField.setBackground(SystemColor.activeCaption);
        usernameField.setBorder(new MatteBorder(2, 2, 2, 2, SystemColor.activeCaption));
        usernameField.setBounds(119, 416, 150, 20);
        frame.getContentPane().add(usernameField);
        usernameField.setColumns(10);
        usernameField.setVisible(true);
        //Check if username already exists in database
        usernameField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {}
            public void focusLost(FocusEvent e) {
                User user = new User();
                User.username = usernameField.getText().replace("'", "");
                if (user.checkFieldInDB("Username",User.username)) {
                    lblUsernameAlreadyExists.setVisible(true);
                    usernameField.setText("");
                }
                else {lblUsernameAlreadyExists.setVisible(false);}


            }
        });


        JLabel lblPassword = new JLabel("Password *");
        lblPassword.setForeground(SystemColor.inactiveCaption);
        lblPassword.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblPassword.setBounds(38, 496, 100, 14);
        frame.getContentPane().add(lblPassword);
        lblPassword.setVisible(true);


        passwordField = new JTextField();
        passwordField.setBackground(SystemColor.activeCaption);
        passwordField.setBorder(new MatteBorder(2, 2, 2, 2, SystemColor.activeCaption));
        passwordField.setBounds(119, 494, 150, 20);
        frame.getContentPane().add(passwordField);
        passwordField.setColumns(10);
        passwordField.setVisible(true);
        //Check if entered value meets requirements
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().length()<5 || passwordField.getText().length()>16){
                    lblIncorrectPassword.setVisible(true);
                    passwordField.setText(""); }
                else{lblIncorrectPassword.setVisible(false);}
            }
        });


        JLabel lblConfirmPassword = new JLabel("Conf Password *");
        lblConfirmPassword.setForeground(SystemColor.inactiveCaption);
        lblConfirmPassword.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblConfirmPassword.setBounds(283, 496, 124, 14);
        frame.getContentPane().add(lblConfirmPassword);
        lblConfirmPassword.setVisible(true);


        confirmPasswordField = new JTextField();
        confirmPasswordField.setBackground(SystemColor.activeCaption);
        confirmPasswordField.setBorder(new MatteBorder(2, 2, 2, 2, SystemColor.activeCaption));
        confirmPasswordField.setBounds(393, 494, 150, 20);
        frame.getContentPane().add(confirmPasswordField);
        confirmPasswordField.setColumns(10);
        confirmPasswordField.setVisible(true);
        //Check if entered value matched the passwordfield
        confirmPasswordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                if (!passwordField.getText().equals(confirmPasswordField.getText())){
                    lblIncorrectPassword_1.setVisible(true);
                    confirmPasswordField.setText(""); }
                else{lblIncorrectPassword_1.setVisible(false);}
            }
        });


        JLabel lblOrganizationName = new JLabel("Organization Name *");
        lblOrganizationName.setForeground(SystemColor.inactiveCaption);
        lblOrganizationName.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblOrganizationName.setBounds(628, 194, 188, 20);
        frame.getContentPane().add(lblOrganizationName);
        lblOrganizationName.setVisible(false);


        JLabel lblOrganizationEmail = new JLabel("Organization Email");
        lblOrganizationEmail.setForeground(SystemColor.inactiveCaption);
        lblOrganizationEmail.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblOrganizationEmail.setBounds(958, 196, 129, 17);
        frame.getContentPane().add(lblOrganizationEmail);
        lblOrganizationEmail.setVisible(false);


        JLabel lblPaymentMethod = new JLabel("Payment Method");
        lblPaymentMethod.setForeground(SystemColor.inactiveCaption);
        lblPaymentMethod.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblPaymentMethod.setBounds(965, 267, 137, 14);
        frame.getContentPane().add(lblPaymentMethod);
        lblPaymentMethod.setVisible(false);


        JLabel lblWebAddress = new JLabel("Web Address");
        lblWebAddress.setForeground(SystemColor.inactiveCaption);
        lblWebAddress.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblWebAddress.setBounds(628, 267, 124, 14);
        frame.getContentPane().add(lblWebAddress);
        lblWebAddress.setVisible(false);


        JLabel lblCardNumber = new JLabel("Card Number *");
        lblCardNumber.setForeground(SystemColor.inactiveCaption);
        lblCardNumber.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblCardNumber.setBounds(10, 565, 110, 14);
        frame.getContentPane().add(lblCardNumber);
        lblCardNumber.setVisible(true);


        JLabel lblCvv = new JLabel("CVV *");
        lblCvv.setForeground(SystemColor.inactiveCaption);
        lblCvv.setFont(new Font("Open Sans", Font.BOLD, 13));
        lblCvv.setBounds(330, 565, 56, 14);
        frame.getContentPane().add(lblCvv);
        lblCvv.setVisible(true);


        orgNameField = new JTextField();
        orgNameField.setBackground(SystemColor.activeCaption);
        orgNameField.setBorder(new MatteBorder(2, 2, 2, 2, SystemColor.activeCaption));
        orgNameField.setBounds(771, 195, 150, 20);
        frame.getContentPane().add(orgNameField);
        orgNameField.setColumns(10);
        orgNameField.setVisible(false);


        orgEmailField = new JTextField();
        orgEmailField.setText("");
        orgEmailField.setBackground(SystemColor.activeCaption);
        orgEmailField.setBorder(new MatteBorder(2, 2, 2, 2, SystemColor.activeCaption));
        orgEmailField.setBounds(1097, 195, 150, 20);
        frame.getContentPane().add(orgEmailField);
        orgEmailField.setColumns(10);
        orgEmailField.setVisible(false);


        JComboBox<String> paymentComboBox = new JComboBox<>();
        paymentComboBox.setBackground(SystemColor.activeCaption);
        paymentComboBox.setBounds(1096, 265, 151, 20);
        paymentComboBox.setMaximumRowCount(2);
        paymentComboBox.addItem("On Booking");
        paymentComboBox.addItem("Monthly Invoice");
        paymentComboBox.setEditable(false);
        frame.getContentPane().add(paymentComboBox);
        paymentComboBox.setVisible(false);

        //create new mini panel with all acceptable credit card icons
        cardIconPanel = new CreditCardIconsPanel(119,543);
        frame.add(cardIconPanel);

        cardNoField = new JTextField();
        cardNoField.setBackground(SystemColor.activeCaption);
        cardNoField.setBorder(new MatteBorder(2, 2, 2, 2, SystemColor.activeCaption));
        cardNoField.setBounds(119, 563, 180, 20);
        frame.getContentPane().add(cardNoField);
        cardNoField.setColumns(10);
        cardNoField.setVisible(true);
        //Validate card Number and show respective card Icon on cardIconPanel
        cardNoField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                boolean validNo = cardIconPanel.checkAndRepaint(cardNoField.getText());
                if (!validNo){
                    lblInvalidCardNumber.setText("Invalid Card No");
                    lblInvalidCardNumber.setVisible(true);
                    cardNoField.setText("");
                }
                else{lblInvalidCardNumber.setVisible(false);}
            }
        });

        CVVField = new JTextField();
        CVVField.setBackground(SystemColor.activeCaption);
        CVVField.setBorder(new MatteBorder(2, 2, 2, 2, SystemColor.activeCaption));
        CVVField.setBounds(393, 563, 150, 20);
        frame.getContentPane().add(CVVField);
        CVVField.setColumns(10);
        CVVField.setVisible(true);
        //Check if entered value is 3 digits long
        CVVField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                try{
                    Integer.parseInt(CVVField.getText());
                    if (!(CVVField.getText().length()==3)){
                        lblInvalidCVV.setText("Invalid CVV Number");
                        lblInvalidCVV.setVisible(true);
                    } else {
                    	lblInvalidCVV.setVisible(false);
                    }
                }
                catch(NumberFormatException k){
                    lblInvalidCVV.setVisible(true);
                    CVVField.setText("");}
            }
        });

        webAddressField = new JTextField();
        webAddressField.setBackground(SystemColor.activeCaption);
        webAddressField.setBorder(new MatteBorder(2, 2, 2, 2, SystemColor.activeCaption));
        webAddressField.setBounds(771, 265, 150, 20);
        frame.getContentPane().add(webAddressField);
        webAddressField.setColumns(10);
        webAddressField.setVisible(false);


        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Corporate Organization");
        chckbxNewCheckBox_1.setBorder(new MatteBorder(3, 3, 3, 3, SystemColor.activeCaption));
        chckbxNewCheckBox_1.setBackground(SystemColor.activeCaption);
        chckbxNewCheckBox_1.setForeground(SystemColor.inactiveCaptionBorder);
        chckbxNewCheckBox_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //If user selects it, fields for registering organization details become available
        chckbxNewCheckBox_1.addActionListener(arg0 -> {
            if(chckbxNewCheckBox_1.isSelected()) {
                lblOrganizationName.setVisible(true);
                orgNameField.setVisible(true);
                lblOrganizationEmail.setVisible(true);
                orgEmailField.setVisible(true);
                lblPaymentMethod.setVisible(true);
                paymentComboBox.setVisible(true);
                lblWebAddress.setVisible(true);
                webAddressField.setVisible(true);
            }
            else {
                lblOrganizationName.setVisible(false);
                orgNameField.setVisible(false);
                lblOrganizationEmail.setVisible(false);
                orgEmailField.setVisible(false);
                lblPaymentMethod.setVisible(false);
                paymentComboBox.setVisible(false);
                lblWebAddress.setVisible(false);
                webAddressField.setVisible(false);
            }
        });
        chckbxNewCheckBox_1.setFont(new Font("Open Sans", Font.BOLD, 13));
        chckbxNewCheckBox_1.setBounds(771, 129, 188, 23);
        frame.getContentPane().add(chckbxNewCheckBox_1);
        chckbxNewCheckBox_1.setVisible(true);


        /*
        Check if user registers as corporate and set user type accordingly
        Check if all necessary fields are filled
        Create new User object and add to the database
         */
        JButton btnRegisterButton = new JButton("Register");
        btnRegisterButton.setForeground(SystemColor.inactiveCaption);
        btnRegisterButton.setFont(new Font("Open Sans", Font.PLAIN, 20));
        btnRegisterButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegisterButton.setOpaque(false);
        btnRegisterButton.setBorderPainted(false);
        btnRegisterButton.setContentAreaFilled(false);
        btnRegisterButton.setBounds(981, 516, 140, 40);
        frame.getContentPane().add(btnRegisterButton);
        btnRegisterButton.setVisible(true);
        btnRegisterButton.addActionListener(e -> {
            ArrayList<JTextField> textFieldArray;
            textFieldArray = new ArrayList<>();
            textFieldArray.add(firstNameField);
            textFieldArray.add(lastNameField);
            textFieldArray.add(addressOneField);
            textFieldArray.add(townField);
            textFieldArray.add(postcodeField);
            textFieldArray.add(emailField);
            textFieldArray.add(usernameField);
            textFieldArray.add(passwordField);
            textFieldArray.add(confirmPasswordField);
            textFieldArray.add(cardNoField);
            textFieldArray.add(CVVField);

            if (chckbxNewCheckBox_1.isSelected()){
                textFieldArray.add(orgNameField);
                RegisterView.checkType = true;
            }
            boolean checker = true;
            for(JTextField field : textFieldArray) {
                if (field.getText().equals("")) {
                    checker = false;
                    field.setBackground(new Color(255, 228, 225));
                } else {
                    field.setBackground(SystemColor.inactiveCaption);
                }
            }
            if (checker){
                User newUser = new User(Long.parseLong(cardNoField.getText().replace("'", "''")),Integer.parseInt(CVVField.getText().replace("'", "''")),
                        titleComboBox.getSelectedItem().toString(), firstNameField.getText().replace("'", "''"), lastNameField.getText().replace("'", "''"),
                        addressOneField.getText().replace("'", "''"), addressTwoField.getText().replace("'", "''"), townField.getText().replace("'", "''"),
                        postcodeField.getText().replace("'", "''"),usernameField.getText().replace("'", "''"), passwordField.getText().replace("'", "''"),
                        emailField.getText().replace("'", "''"), phoneNoField.getText().replace("'", "''"),orgNameField.getText().replace("'", "''"),
                        webAddressField.getText().replace("'", "''"), orgEmailField.getText().replace("'", "''"),
                        paymentComboBox.getSelectedItem().toString());
                newUser.insertCustomerData();
                JOptionPane.showMessageDialog(null,"Registration successful! Please Login!");
                new LoginView();
                frame.setVisible(false); }
            else{lblAllFields.setVisible(true);}
        });

        //Back to LoginView, no changes saved
        JButton btnCancelButton = new JButton("Cancel");
        btnCancelButton.addActionListener(arg0 -> {
            new LoginView();
            frame.setVisible(false);
        });
        btnCancelButton.setBounds(766, 516, 120, 40);
        btnCancelButton.setForeground(SystemColor.inactiveCaption);
        btnCancelButton.setFont(new Font("Open Sans", Font.PLAIN, 20));
        btnCancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCancelButton.setOpaque(false);
        btnCancelButton.setBorderPainted(false);
        btnCancelButton.setContentAreaFilled(false);
        frame.getContentPane().add(btnCancelButton);
        btnCancelButton.setVisible(true);


        JSeparator separator = new JSeparator();
        separator.setBounds(786, 549, 90, 3);
        separator.setBackground(SystemColor.inactiveCaption);
        separator.setForeground(SystemColor.inactiveCaption);
        separator.setOpaque(true);
        frame.getContentPane().add(separator);

        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(993, 549, 100, 3);
        separator_1.setBackground(SystemColor.inactiveCaption);
        separator_1.setForeground(SystemColor.inactiveCaption);
        separator_1.setOpaque(true);
        frame.getContentPane().add(separator_1);
        
        
        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(Main.IMAGE_DIR+"Logo.jpg"));
        lblLogo.setBounds(186, 583, 200, 96);
        frame.getContentPane().add(lblLogo);


        JLabel lblImageLabel = new JLabel("Image");
        lblImageLabel.setFont(new Font("Open Sans", Font.PLAIN, 11));
        lblImageLabel.setForeground(Color.BLACK);
        lblImageLabel.setIcon(new ImageIcon(Main.IMAGE_DIR+"Silhouette-Rock-Concert-Wallpaper1.jpg"));
        lblImageLabel.setBounds(0, 0, 1297, 693);
        frame.getContentPane().add(lblImageLabel);


    }
}
