import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  

public class LoginImageViewer {  
    private String username = "admin";  
    private String password = "admin";  
    private JTextField txtUsername;  
    private JPasswordField txtPassword;  
    private JFrame mainFrame;  

    public static void main(String[] args) {  
        LoginImageViewer app = new LoginImageViewer();  
        app.showLoginScreen();  
    }  

    public void showLoginScreen() {  
        mainFrame = new JFrame("Login System");  
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        mainFrame.setSize(400, 200);  

        JPanel panel = new JPanel();  
        panel.setLayout(new GridLayout(3, 2, 10, 10));  

        JLabel lblUsername = new JLabel("Username:");     
        JLabel lblPassword = new JLabel("Password:");  
        txtUsername = new JTextField(20);  
        txtPassword = new JPasswordField(20);  

        JButton btnLogin = new JButton("Login");  
        btnLogin.addActionListener(new LoginListener());  

        JButton btnCancel = new JButton("Cancel");  
        btnCancel.addActionListener(new CancelListener());  

        panel.add(lblUsername);  
        panel.add(txtUsername);  
        panel.add(lblPassword);  
        panel.add(txtPassword);  
        panel.add(btnLogin);  
        panel.add(btnCancel);  

        mainFrame.getContentPane().add(panel);  
        mainFrame.setVisible(true);  
    }  

    private void showImageViewer() {  
        mainFrame.dispose();  // Close the login screen  

        JFrame frame = new JFrame("Image Viewer");  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setSize(600, 400);  

        JLabel imageLabel = new JLabel("No Image Selected", SwingConstants.CENTER);  
        imageLabel.setPreferredSize(new Dimension(500, 300));  

        JButton btnLoadImage = new JButton("Load Image");  
        btnLoadImage.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent event) {  
                JFileChooser fileChooser = new JFileChooser();  
                int returnValue = fileChooser.showOpenDialog(null);  
                if (returnValue == JFileChooser.APPROVE_OPTION) {  
                    String path = fileChooser.getSelectedFile().getPath();  
                    imageLabel.setIcon(new ImageIcon(path));  
                    imageLabel.setText("");  
                }  
            }  
        });  

        JPanel panel = new JPanel();  
        panel.add(btnLoadImage);  

        frame.getContentPane().add(BorderLayout.CENTER, imageLabel);  
        frame.getContentPane().add(BorderLayout.SOUTH, panel);  

        frame.setVisible(true);  
    }  

    private class LoginListener implements ActionListener {  
        public void actionPerformed(ActionEvent event) {  
            if (username.equals(txtUsername.getText()) && password.equals(new String(txtPassword.getPassword()))) {  
                JOptionPane.showMessageDialog(null, "Login Granted!");  
                showImageViewer();  
            } else {  
                JOptionPane.showMessageDialog(null, "Login Denied");  
            }  
        }  
    }  

    private class CancelListener implements ActionListener {  
        public void actionPerformed(ActionEvent event) {  
            txtUsername.setText("");  
            txtPassword.setText("");  
            txtUsername.requestFocus();  
        }  
    }  
}
