package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.border.*;

public class ProfileForm extends JFrame {
    private JTextField idField, nameField, phoneField, emailField, usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> genderComboBox;
    private JButton editButton, changePasswordButton;

    public ProfileForm() {
        setTitle("Hồ Sơ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create header panel with gradient background
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(255, 182, 182),
                    getWidth(), 0, new Color(255, 140, 140));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        headerPanel.setPreferredSize(new Dimension(800, 60));

        // Add profile icon and "HỒ SƠ" text to header
        JLabel headerLabel = new JLabel("HỒ SƠ",JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(Color.WHITE);
        
        headerPanel.add(headerLabel);

        // Create main content panel
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        mainPanel.setBackground(new Color(240, 240, 240));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Left panel - Form
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        formPanel.setOpaque(false);
        
        // Add form components
        formPanel.add(createLabel("Căn cước/CMND:"));
        idField = createTextField("044200003153");
        formPanel.add(idField);

        formPanel.add(createLabel("Tên khách hàng:"));
        nameField = createTextField("Phạm Ngọc Hưng");
        formPanel.add(nameField);

        formPanel.add(createLabel("Số điện thoại:"));
        phoneField = createTextField("0979336861");
        formPanel.add(phoneField);

        formPanel.add(createLabel("Email:"));
        emailField = createTextField("phamngochung2000@gmail.com");
        formPanel.add(emailField);

        formPanel.add(createLabel("Giới tính:"));
        String[] genders = {"Nam", "Nữ"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBackground(Color.WHITE);
        formPanel.add(genderComboBox);

        formPanel.add(createLabel("Tên Đăng Nhập:"));
        JPanel usernamePanel = new JPanel(new BorderLayout(5, 0));
        usernamePanel.setOpaque(false);
        usernameField = createTextField("hung2k");
        editButton = new JButton("Sửa");
        editButton.setBackground(Color.WHITE);
        usernamePanel.add(usernameField, BorderLayout.CENTER);
        usernamePanel.add(editButton, BorderLayout.EAST);
        formPanel.add(usernamePanel);

        formPanel.add(createLabel("Mật khẩu:"));
        JPanel passwordPanel = new JPanel(new BorderLayout(5, 0));
        passwordPanel.setOpaque(false);
        passwordField = new JPasswordField("********");
        changePasswordButton = new JButton("Đổi mật khẩu");
        changePasswordButton.setBackground(Color.WHITE);
        passwordPanel.add(passwordField, BorderLayout.CENTER);
        passwordPanel.add(changePasswordButton, BorderLayout.EAST);
        formPanel.add(passwordPanel);

        // Right panel - Image display area
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        
  
         JLabel imageLabel = new JLabel();
         String absolutePath = "E:/ProjectCTDL/project/src/img/home.jpg";
         ImageIcon imageIcon = new ImageIcon(absolutePath);
         imageLabel.setIcon(imageIcon);
         imagePanel.add(imageLabel);
        // Add panels to main panel
         
        mainPanel.add(formPanel);
        mainPanel.add(imagePanel);

        // Add header and main panel to frame
        add(headerPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        // Set frame properties
        setSize(800, 500);
        setLocationRelativeTo(null);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        return label;
    }

    private JTextField createTextField(String text) {
        JTextField field = new JTextField(text);
        field.setBackground(Color.WHITE);
        return field;
    }

    

    public static void main(String[] args) {
        
            new ProfileForm().setVisible(true);
       
    }
}