package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.RegisterController;

public class RegistrationForm extends JFrame {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	private JButton registerButton, cancelButton;

	public RegistrationForm() {
		setTitle("Đăng ký tài khoản");
		setSize(500, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		// Main panel với BorderLayout

		RegisterController actionListener = new RegisterController(this);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(new Color(240, 240, 240));

		JPanel titlePanel = new JPanel(new BorderLayout());
		titlePanel.setBackground(new Color(41, 128, 185));
		titlePanel.setPreferredSize(new Dimension(500, 80));

		JLabel titleLabel = new JLabel("ĐĂNG KÝ", SwingConstants.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		titleLabel.setForeground(Color.WHITE);
		ImageIcon icon = new ImageIcon(RegistrationForm.class.getResource("/img/Travel-Airplane-icon.png"));
		titleLabel.setIcon(new ImageIcon(icon.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));

		JPanel paddedTitlePanel = new JPanel(new BorderLayout());
		paddedTitlePanel.setBackground(new Color(0, 153, 153));
		paddedTitlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		paddedTitlePanel.add(titleLabel, BorderLayout.CENTER);

		titlePanel.add(paddedTitlePanel, BorderLayout.CENTER);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridBagLayout());
		centerPanel.setBackground(new Color(240, 240, 240));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 20, 10, 20);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		Font labelFont = new Font("Arial", Font.PLAIN, 14);
		Font fieldFont = new Font("Arial", Font.PLAIN, 14);
		Dimension fieldDimension = new Dimension(250, 30);

		JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		usernamePanel.setBackground(new Color(240, 240, 240));
		JLabel userLabel = new JLabel("Tên đăng nhập:");
		userLabel.setFont(labelFont);
		userLabel.setPreferredSize(new Dimension(120, 30));
		usernameField = new JTextField();
		styleTextField(usernameField, fieldFont, fieldDimension);
		usernamePanel.add(userLabel);
		usernamePanel.add(usernameField);
		gbc.gridx = 0;
		gbc.gridy = 0;
		centerPanel.add(usernamePanel, gbc);

		// Password row
		JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		passwordPanel.setBackground(new Color(240, 240, 240));
		JLabel passLabel = new JLabel("Mật khẩu:");
		passLabel.setFont(labelFont);
		passLabel.setPreferredSize(new Dimension(120, 30));
		passwordField = new JPasswordField();
		styleTextField(passwordField, fieldFont, fieldDimension);
		passwordPanel.add(passLabel);
		passwordPanel.add(passwordField);
		gbc.gridx = 0;
		gbc.gridy = 1;
		centerPanel.add(passwordPanel, gbc);

		// Confirm Password row
		JPanel confirmPasswordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		confirmPasswordPanel.setBackground(new Color(240, 240, 240));
		JLabel confirmPassLabel = new JLabel("Nhập lại mật khẩu:");
		confirmPassLabel.setFont(labelFont);
		confirmPassLabel.setPreferredSize(new Dimension(120, 30));
		confirmPasswordField = new JPasswordField();
		styleTextField(confirmPasswordField, fieldFont, fieldDimension);
		confirmPasswordPanel.add(confirmPassLabel);
		confirmPasswordPanel.add(confirmPasswordField);
		gbc.gridx = 0;
		gbc.gridy = 2;
		centerPanel.add(confirmPasswordPanel, gbc);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		buttonPanel.setBackground(new Color(240, 240, 240));

		registerButton = new JButton("Đăng ký");
		styleButton(registerButton, new Color(0, 153, 153));

		cancelButton = new JButton("Hủy");
		styleButton(cancelButton, new Color(231, 76, 60));

		buttonPanel.add(registerButton);
		buttonPanel.add(cancelButton);

		registerButton.addActionListener(actionListener);
		cancelButton.addActionListener(actionListener);

		mainPanel.add(titlePanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		// Add actions
		getRootPane().setDefaultButton(registerButton);
//		registerButton.addActionListener(new xulybutton());
//		cancelButton.addActionListener(new xulybutton());

		add(mainPanel);
		setVisible(true);
	}

	private void styleTextField(JTextField field, Font font, Dimension dimension) {
		field.setFont(font);
		field.setPreferredSize(dimension);
		field.setBorder(BorderFactory.createCompoundBorder(new LineBorder(new Color(200, 200, 200)),
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
	}

	private void styleButton(JButton button, Color backgroundColor) {
		button.setPreferredSize(new Dimension(100, 30));
		button.setFont(new Font("Arial", Font.BOLD, 14));
		button.setForeground(Color.WHITE);
		button.setBackground(backgroundColor);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// Hover effect
		button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				button.setBackground(backgroundColor.darker());
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				button.setBackground(backgroundColor);
			}
		});
	}

	private void showError(String message) {
		JOptionPane.showMessageDialog(this, message, "Lỗi", JOptionPane.ERROR_MESSAGE);
	}

	private void clearFields() {
		usernameField.setText("");
		passwordField.setText("");
		confirmPasswordField.setText("");
	}

	public String getRegisUserName() {
		return usernameField.getText();
	}

	public String getRegisPass() {
		return new String(passwordField.getPassword());
	}

	public String getRegisConfirmPass() {
		return new String(confirmPasswordField.getPassword());
	}

}