import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        // Pengaturan Frame
        setTitle("Login");
        setSize(1166, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel Utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        add(mainPanel, BorderLayout.CENTER);

        // Panel Gambar
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.DARK_GRAY);
        imagePanel.setPreferredSize(new Dimension(400, 700));

       JLabel imageLabel = new JLabel(new ImageIcon(getClass().getResource("/shoes.png"))); // Ganti dengan gambar sepatu
        imagePanel.add(imageLabel);
        mainPanel.add(imagePanel, BorderLayout.WEST);

        // Panel Form Login
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Sign In / Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        loginPanel.add(titleLabel, gbc);

        JLabel rfidLabel = new JLabel("Please tap your RFID card on the reader to log in.");
        rfidLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        rfidLabel.setForeground(Color.GRAY);
        gbc.gridy = 1;
        loginPanel.add(rfidLabel, gbc);

        JButton rfidButton = new JButton("Click Here");
        gbc.gridy = 2;
        loginPanel.add(rfidButton, gbc);

        JLabel orLabel = new JLabel("- OR -");
        orLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 3;
        loginPanel.add(orLabel, gbc);

        JTextField usernameField = new JTextField(15);
        usernameField.setBorder(BorderFactory.createTitledBorder("Username"));
        gbc.gridy = 4; gbc.gridwidth = 2;
        loginPanel.add(usernameField, gbc);

        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
        gbc.gridy = 5;
        loginPanel.add(passwordField, gbc);

        JCheckBox rememberMe = new JCheckBox("Remember me");
        gbc.gridy = 6; gbc.gridwidth = 1;
        loginPanel.add(rememberMe, gbc);

        JLabel forgotPassword = new JLabel("Forgot Password?");
        forgotPassword.setForeground(Color.BLUE);
        forgotPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridx = 1;
        loginPanel.add(forgotPassword, gbc);

        JButton loginButton = new JButton("LOGIN");
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        gbc.gridy = 7; gbc.gridx = 0; gbc.gridwidth = 2;
        loginPanel.add(loginButton, gbc);

        JLabel registerLabel = new JLabel("Belum memiliki akun? Daftar");
        registerLabel.setForeground(Color.BLUE);
        registerLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridy = 8;
        loginPanel.add(registerLabel, gbc);

        mainPanel.add(loginPanel, BorderLayout.CENTER);

        // Action Login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("admin123")) {
                    JOptionPane.showMessageDialog(null, "Login Berhasil!");
                } else {
                    JOptionPane.showMessageDialog(null, "Username atau Password Salah", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}
