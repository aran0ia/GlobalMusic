import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.Color;

/**
 * Class that creates a frame for adding a new agent
 *
 */

public class NewAgentView {

	private JFrame frame;
	private JTextField nameTxtField;
	private JTextField phoneTxtField;
	private JTextField emailTxtField;


	/**
	 * Create the frame
	 */
	public NewAgentView() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0,0,432,253);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
		JLabel windowTitleLabel = new JLabel("Agent details");
		windowTitleLabel.setFont(new Font("Open Sans", Font.PLAIN, 16));
		windowTitleLabel.setForeground(SystemColor.inactiveCaption);
		windowTitleLabel.setBounds(12, 13, 125, 20);
		frame.getContentPane().add(windowTitleLabel);
		
		JLabel nameLabel = new JLabel("Name*");
		nameLabel.setForeground(SystemColor.inactiveCaption);
		nameLabel.setBounds(123, 80, 56, 16);
		frame.getContentPane().add(nameLabel);
		
		JLabel emailLabel = new JLabel("E-mail");
		emailLabel.setForeground(SystemColor.inactiveCaption);
		emailLabel.setBounds(123, 138, 56, 16);
		frame.getContentPane().add(emailLabel);
		
		JLabel phoneLabel = new JLabel("Phone No");
		phoneLabel.setForeground(SystemColor.inactiveCaption);
		phoneLabel.setBounds(123, 109, 56, 16);
		frame.getContentPane().add(phoneLabel);
		
		nameTxtField = new JTextField();
		nameTxtField.setBorder(new MatteBorder(3, 3, 3, 3, SystemColor.inactiveCaption));
		nameTxtField.setBackground(SystemColor.inactiveCaption);
		nameTxtField.setBounds(191, 77, 116, 22);
		frame.getContentPane().add(nameTxtField);
		nameTxtField.setColumns(10);
		
		phoneTxtField = new JTextField();
		phoneTxtField.setBorder(new MatteBorder(3, 3, 3, 3, SystemColor.inactiveCaption));
		phoneTxtField.setBackground(SystemColor.inactiveCaption);
		phoneTxtField.setBounds(191, 106, 116, 22);
		frame.getContentPane().add(phoneTxtField);
		phoneTxtField.setColumns(10);
		
		emailTxtField = new JTextField();
		emailTxtField.setBorder(new MatteBorder(3, 3, 3, 3, SystemColor.inactiveCaption));
		emailTxtField.setBackground(SystemColor.inactiveCaption);
		emailTxtField.setBounds(191, 135, 116, 22);
		frame.getContentPane().add(emailTxtField);
		emailTxtField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.inactiveCaption);
		separator.setOpaque(true);
		separator.setBounds(113, 227, 56, 3);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOpaque(true);
		separator_1.setBackground(SystemColor.inactiveCaption);
		separator_1.setBounds(250, 227, 70, 3);
		frame.getContentPane().add(separator_1);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setForeground(SystemColor.inactiveCaption);
        cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancelButton.setBounds(98, 204, 85, 25);
		cancelButton.setOpaque(false);
        cancelButton.setContentAreaFilled(false);
        cancelButton.setBorderPainted(false);
        //close the frame, no agents added
        cancelButton.addActionListener(e -> frame.dispose());
		frame.getContentPane().add(cancelButton);

		/*
			Create new agent object(adds to the database as well) after checking all nessecary fields are filled
			Add new agent name to the combobox that called this frame and set it as selected value
		 */
		JButton addButton = new JButton("Add agent");
		addButton.addActionListener(arg0 -> {
			if (nameTxtField.getText() == null | nameTxtField.getText().equals(""))
				JOptionPane.showMessageDialog(null,"Please fill in all the * fields.");

			else {
				Agent agent = new Agent(nameTxtField.getText().replace("'", "''"),phoneTxtField.getText().replace("'", "''"),emailTxtField.getText().replace("'", "''"));
				JOptionPane.showMessageDialog(null,"Agent added.");
				DefaultComboBoxModel model = new DefaultComboBoxModel(agent.getAgentsList().toArray());
				model.insertElementAt("-Add new Agent-",0);
				NewBandView.agentComboBox.setModel(model);
				NewBandView.agentComboBox.setSelectedIndex(model.getSize()-1);
				frame.dispose();
			}
		});
		addButton.setBounds(235, 205, 97, 25);
		addButton.setForeground(SystemColor.inactiveCaption);
		addButton.setOpaque(false);
        addButton.setContentAreaFilled(false);
        addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addButton.setBorderPainted(false);
		frame.getContentPane().add(addButton);
		
		JLabel backgroundLabel = new JLabel("New label");
		backgroundLabel.setIcon(new ImageIcon(Main.IMAGE_DIR+"rsz_silhouette-Rock-Concert-Wallpaper1.jpg"));
		backgroundLabel.setBounds(0, 0, 432, 253);
		frame.getContentPane().add(backgroundLabel);		
	}
}
