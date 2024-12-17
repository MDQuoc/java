package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import controller.LoginController;
import model.SavePass;
import model.User;

public class LoginForm extends JFrame {
	private Timer timer;
	private Color[] colors = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE,
			Color.MAGENTA };
	private int colorIndex = 0;
	private ImageIcon icon;
	private JButton loginButton, registerButton, cancelButton;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private User user;
	private JCheckBox rememberCheckBox;
	private SavePass savepass = new SavePass(LoginForm.class);

	public LoginForm() {
		// Set up frame
		setTitle("Employee Management System");
		setSize(700, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());

		// Left Panel with Background Image and Text Overlay
		// Initialize leftPanel with background image
		JPanel leftPanel = new JPanel() {
			private Image img;

			{
				img = new ImageIcon("src/img/Airplane.gif").getImage();
				if (img == null) {
					img = new ImageIcon(getClass().getResource("/img/Airplane.gif")).getImage();
				}
			}

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (img != null) {
					g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
				}
			}
		};
		LoginController action = new LoginController(this);
		leftPanel.setPreferredSize(new Dimension(350, 300));
		leftPanel.setLayout(new GridBagLayout());

		// Constraints for the first label in the center
		GridBagConstraints gbcleft = new GridBagConstraints();
		gbcleft.gridx = 0;
		gbcleft.gridy = 0;
		gbcleft.anchor = GridBagConstraints.CENTER;
		gbcleft.insets = new Insets(0, 0, 100, 0); // Adjust padding to position the text vertically

		// First label with multi-line text
		JLabel overlayText = new JLabel("<html>Hệ thống đặt vé máy bay</html>", SwingConstants.CENTER);
		overlayText.setFont(new Font("Arial Unicode MS", Font.BOLD, 24));
		overlayText.setForeground(Color.BLACK);

		leftPanel.add(overlayText, gbcleft);

		// Constraints for the second label at the bottom
		GridBagConstraints gbcBottom = new GridBagConstraints();
		gbcBottom.gridx = 0;
		gbcBottom.gridy = 1;
		gbcBottom.anchor = GridBagConstraints.SOUTH;
		gbcBottom.insets = new Insets(150, 0, 0, 0);

		// Second label for additional information at the bottom
		JLabel bottomLabel = new JLabel("(Cảm ơn bạn đã sử dụng dịch vụ của nhóm 23)", SwingConstants.CENTER);
		bottomLabel.setFont(new Font("Courier new", Font.BOLD, 12));
		this.add(bottomLabel);
		timer = new Timer(200, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				bottomLabel.setForeground(colors[colorIndex]);
				colorIndex = (colorIndex + 1) % colors.length;
			}
		});
		timer.start();

		leftPanel.add(bottomLabel, gbcBottom);

		// Right Panel for Login Form
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridBagLayout());

		JLabel welcomeLabel = new JLabel("Đăng nhập");
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
		welcomeLabel.setForeground(new Color(0, 102, 102));
		icon = new ImageIcon(LoginForm.class.getResource("/img/travel.png"));
		welcomeLabel.setIcon(new ImageIcon(icon.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));

		JLabel usernameLabel = new JLabel("<html>Tài Khoản:</html>");
		usernameLabel.setFont(new Font("Script MT Bold", Font.BOLD, 16));

		JLabel passwordLabel = new JLabel("<html>Mật Khẩu:</html>");
		passwordLabel.setFont(new Font("Script MT Bold", Font.BOLD, 16));

		// Username and Password fields
		usernameField = new JTextField();
		usernameField.setPreferredSize(new Dimension(150, 30));
		passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(150, 30));

		// Remember Me Checkbox
		rememberCheckBox = new JCheckBox("Ghi nhớ");

		// Login, Cancel, and Register Buttons
		loginButton = new JButton("Đăng nhập");
		loginButton.setBackground(new Color(0, 153, 153));
		loginButton.setForeground(Color.WHITE);

		cancelButton = new JButton("Hủy");
		cancelButton.setBackground(new Color(204, 0, 0));
		cancelButton.setForeground(Color.WHITE);

		registerButton = new JButton("Đăng ký");
		registerButton.setBackground(new Color(0, 153, 153));
		registerButton.setForeground(Color.WHITE);

		// Adding components to Right Panel
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		rightPanel.add(welcomeLabel, gbc);

		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridy = 1;
		rightPanel.add(usernameLabel, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		rightPanel.add(usernameField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.EAST;
		rightPanel.add(passwordLabel, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		rightPanel.add(passwordField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		rightPanel.add(rememberCheckBox, gbc);

		// Panel for buttons (Login, Cancel, Register)
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
		buttonPanel.add(loginButton);
		buttonPanel.add(registerButton);
		buttonPanel.add(cancelButton);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		rightPanel.add(buttonPanel, gbc);

		// Action Listeners for Buttons
		loginButton.addActionListener(action);
		registerButton.addActionListener(action);
		cancelButton.addActionListener(action);

		boolean isChecked = savepass.getCheckboxState("remember_checkbox", false);
		rememberCheckBox.setSelected(isChecked);
		if (isChecked) {
			usernameField.setText(savepass.getUsername());
			passwordField.setText(savepass.getPassword());

		}
		rememberCheckBox.addItemListener(e -> {
			savepass.saveCheckboxState("remember_checkbox", rememberCheckBox.isSelected());
		});
		// đặt nút đăng nhập mặc định là enter
		getRootPane().setDefaultButton(loginButton);

		buttonPanel.setBackground(new Color(127, 255, 212));

		rightPanel.setBackground(new Color(127, 255, 212));
		welcomeLabel.setOpaque(true);
		welcomeLabel.setBackground(new Color(127, 255, 212));

		usernameLabel.setOpaque(true);
		usernameLabel.setBackground(new Color(127, 255, 212));

		passwordLabel.setOpaque(true);
		passwordLabel.setBackground(new Color(127, 255, 212));

		usernameField.setBackground(new Color(255, 255, 255));
		passwordField.setBackground(new Color(255, 255, 255));

		rememberCheckBox.setOpaque(true);
		rememberCheckBox.setBackground(new Color(127, 255, 212));

		// Add panels to the frame
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.CENTER);
		setVisible(true);
		setFocusable(true);

	}

	public String getUserName() {
		return usernameField.getText() + "";
	}

	public String getPassword() {
		return new String(passwordField.getPassword()) + "";
	}

	public boolean getCheckBox() {
		return rememberCheckBox.isSelected();
	}

	public void getRememberCheckBox() {

	}

	public void setUserName(String name) {
		usernameField.setText(name);
	}

	public void setPassword(String pass) {
		usernameField.setText(pass);
	}

}
