package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeScreen extends JFrame {
    // Tạo gradient panel tùy chỉnh
    class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            int w = getWidth();
            int h = getHeight();
            Color color1 = new Color(0, 150, 255);
            Color color2 = new Color(135, 206, 250);
            GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, w, h);
        }
    }
    
    
    
    public WelcomeScreen() {
        setTitle("Chào Mừng - Hệ Thống Đặt Vé Máy Bay");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Tạo panel chính với gradient
        GradientPanel mainPanel = new GradientPanel();
        mainPanel.setLayout(new BorderLayout());
        
        // Panel trung tâm với hiệu ứng trong suốt
        JPanel centerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Vẽ hình chữ nhật trong suốt với bo góc
                g2d.setColor(new Color(255, 255, 255, 200));
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            }
        };
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);
        
        // Logo với animation
        JLabel logoLabel = new JLabel("A") {
            private float angle = 0;
            {
                Timer timer = new Timer(50, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        angle += 0.05f;
                        if (angle > 2 * Math.PI) angle = 0;
                        setLocation((int)(Math.sin(angle) * 5) + getX(), getY());
                    }
                });
                timer.start();
            }
        };
        logoLabel.setFont(new Font("Segoe UI", Font.BOLD, 100));
        logoLabel.setForeground(new Color(25, 118, 210));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Tiêu đề với font đẹp
        JLabel welcomeLabel = new JLabel("CHÀO MỪNG ĐẾN VỚI");
        welcomeLabel.setFont(new Font("Montserrat", Font.BOLD, 36));
        welcomeLabel.setForeground(new Color(51, 51, 51));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel systemLabel = new JLabel("HỆ THỐNG ĐẶT VÉ MÁY BAY") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                
                // Tạo hiệu ứng đổ bóng
                g2d.setColor(new Color(0, 0, 0, 50));
                g2d.drawString(getText(), 2, getHeight() - 2);
                
                g2d.setColor(new Color(25, 118, 210));
                g2d.drawString(getText(), 0, getHeight() - 4);
            }
        };
        systemLabel.setFont(new Font("Montserrat", Font.BOLD, 42));
        systemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Slogan với font nghiêng đẹp
        JLabel sloganLabel = new JLabel("Hành trình của bạn - Sự lựa chọn của chúng tôi");
        sloganLabel.setFont(new Font("Dancing Script", Font.BOLD, 28));
        sloganLabel.setForeground(new Color(70, 70, 70));
        sloganLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Nút bắt đầu với hiệu ứng hover
        JButton startButton = new JButton("BẮT ĐẦU ĐẶT VÉ") {
            {
                setContentAreaFilled(false);
                setFocusPainted(false);
                setBorderPainted(false);
            }
            
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                if (getModel().isPressed()) {
                    g2d.setColor(new Color(0, 91, 150));
                } else if (getModel().isRollover()) {
                    g2d.setColor(new Color(30, 144, 255));
                } else {
                    g2d.setColor(new Color(25, 118, 210));
                }
                
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                
                g2d.setColor(Color.WHITE);
                g2d.setFont(new Font("Montserrat", Font.BOLD, 16));
                FontMetrics fm = g2d.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(getText())) / 2;
                int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
                g2d.drawString(getText(), x, y);
            }
        };
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setMaximumSize(new Dimension(250, 50));
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        startButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Chuyển đến màn hình đặt vé"));
        
        // Thêm các thành phần vào panel trung tâm với padding
        centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        centerPanel.add(logoLabel);
        centerPanel.add(Box.createVerticalStrut(30));
        centerPanel.add(welcomeLabel);
        centerPanel.add(Box.createVerticalStrut(15));
        centerPanel.add(systemLabel);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(sloganLabel);
        centerPanel.add(Box.createVerticalStrut(40));
        centerPanel.add(startButton);
        
        // Thêm panel trung tâm vào panel chính với margin
        mainPanel.add(Box.createHorizontalStrut(100), BorderLayout.WEST);
        mainPanel.add(Box.createHorizontalStrut(100), BorderLayout.EAST);
        mainPanel.add(Box.createVerticalStrut(50), BorderLayout.NORTH);
        mainPanel.add(Box.createVerticalStrut(50), BorderLayout.SOUTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        // Thêm panel chính vào frame
        add(mainPanel);
    }
    
    public static void main(String[] args) {
        new WelcomeScreen().setVisible(true);

    }
}