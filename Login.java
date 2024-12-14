import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class Login extends JFrame {

    public Login() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 720);
        setLayout(new BorderLayout());

        JPanel containerPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                ImageIcon backgroundImage = new ImageIcon("background2.jpg");
                // Draw the background image
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        containerPanel.setBorder(BorderFactory.createEmptyBorder(100, 300, 150, 300));

        Font inputFont = new Font("Consolas", Font.PLAIN, 20); // Define custom font
        Font borderTitleFont = new Font("AGENCY FB", Font.BOLD, 15); // Define custom font
        Font borderTitleFont2 = new Font("AGENCY FB", Font.BOLD, 20);
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("AGENCY FB", Font.BOLD, 36));
        titleLabel.setForeground(Color.decode("#f44336"));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        containerPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.white);
        formPanel.setLayout(new GridLayout(4, 1, 0, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(40, 20, 40, 20));

        JTextField userIdField = new JTextField();

        TitledBorder userIdFieldBorder = BorderFactory.createTitledBorder("User ID :");
        userIdFieldBorder.setTitleFont(borderTitleFont);
        userIdField.setBorder(userIdFieldBorder);

        formPanel.add(userIdField);
        userIdField.setFont(inputFont);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
        TitledBorder passwordFieldBorder = BorderFactory.createTitledBorder("Password:");
        passwordFieldBorder.setTitleFont(borderTitleFont);
        passwordField.setBorder(passwordFieldBorder);

        passwordField.setFont(inputFont);
        formPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton submitButton = new JButton("Login");
        submitButton.setBackground(Color.decode("#4CAF50"));
        submitButton.setForeground(Color.white);
        submitButton.setPreferredSize(new Dimension(200, 40));
        submitButton.setFont(borderTitleFont2);
        buttonPanel.add(submitButton);
        formPanel.add(buttonPanel);

        containerPanel.add(formPanel, BorderLayout.CENTER);
        add(containerPanel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.decode("#f4f4f4"));
        JLabel backLabel = new JLabel("Back to Homepage");
        backLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        backLabel.setForeground(Color.decode("#f44336"));
        footerPanel.add(backLabel);
        JButton backButton = new JButton("Back");
        backButton.setFont(borderTitleFont);
        backButton.setBackground(Color.decode("#f44336"));
        backButton.setForeground(Color.white);
        backButton.setPreferredSize(new Dimension(100, 30));
        footerPanel.add(backButton);
        containerPanel.add(footerPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Objects.equals(userIdField.getText(), "")) {
                    JOptionPane.showMessageDialog(null, "enter user id!", "message!", JOptionPane.WARNING_MESSAGE);
                } else if (Objects.equals(userIdField.getText(), "userid")) {
                    JOptionPane.showMessageDialog(null, "change user id!", "message!", JOptionPane.ERROR_MESSAGE);
                } else {
                    String url = "jdbc:mysql://localhost:3306/lostandfound";
                    String UserName = "root";
                    String Password = "";

                    try {
                        // 1. Load the database driver
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        // 2. Establish a connection
                        Connection connection = DriverManager.getConnection(url, UserName, Password);

                        String uname = userIdField.getText();
                        String pas = passwordField.getText();

                        // SQL statement to check user credentials
                        String query = "SELECT * FROM userdata WHERE username = ? AND password = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, uname);
                        preparedStatement.setString(2, pas);

                        // Execute the query
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if (resultSet.next()) {
                            dispose();
                            System.out.println("Login successful!");
                            Homepage home = new Homepage();
                            home.title.setText("WELCOME  TO LOST & FOUND");
                            home.signUpButton.setVisible(false);
                            home.profile.setText("USER:  " + userIdField.getText() + " ");
                            home.headerPanel.add(home.profile, BorderLayout.EAST);
                            home.profile.setBackground(new Color(0xcaa110));
                            home.profile.setForeground(new Color(0xFFFFFF));

                            JOptionPane.showMessageDialog(null, "LOG IN SUCCESSFULLY", "done", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again", "falied", JOptionPane.ERROR_MESSAGE);
                            System.out.println("Invalid username or password. Please try again." + uname + "::" + pas);
                        }

                        // Close resources
                        resultSet.close();
                        preparedStatement.close();
                        connection.close();

                    } catch (SQLException A) {
                        A.printStackTrace();
                        System.out.println("Database connection or query execution error.");
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Homepage();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new);
    }
}
