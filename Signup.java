import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;
import java.util.Random;

public class Signup extends JFrame {
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

    Font inputFont = new Font("Consolas", Font.PLAIN, 15); // Define custom font
    Font borderTitleFont = new Font("AGENCY FB", Font.BOLD, 15); // Define custom font
    JTextField userIdField = new JTextField();
    JTextField nameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JTextField emailField = new JTextField();
    JTextField phoneField = new JTextField();
    JTextField addressField = new JTextField();
    JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Others"});
    JButton submitButton = new JButton("Sign Up");

    public Signup() {
        setTitle("Sign Up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 720);
        setLayout(new BorderLayout());

        containerPanel.setBorder(BorderFactory.createEmptyBorder(50, 200, 50, 200));

        JLabel titleLabel = new JLabel("Sign Up");
        titleLabel.setFont(new Font("AGENCY FB", Font.BOLD, 36));
        titleLabel.setForeground(Color.decode("#f44336"));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        containerPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setOpaque(false);
        formPanel.setLayout(new GridLayout(9, 1, 0, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        generateRandomUserId();
        userIdField.setEditable(false);
        TitledBorder userIdFieldBorder = BorderFactory.createTitledBorder("User ID:");
        userIdField.setFont(inputFont);
        userIdFieldBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        userIdFieldBorder.setTitleColor(Color.DARK_GRAY);
        userIdField.setBorder(userIdFieldBorder);
        userIdField.setFont(inputFont);

        formPanel.add(userIdField);



        TitledBorder nameFieldBorder = BorderFactory.createTitledBorder("Name:");
        nameFieldBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        nameField.setBorder(nameFieldBorder);
        nameFieldBorder.setTitleColor(Color.DARK_GRAY);

        nameField.setFont(inputFont);
        formPanel.add(nameField);

        TitledBorder emailFieldBorder = BorderFactory.createTitledBorder("Email:");
        emailFieldBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        emailField.setBorder(emailFieldBorder);
        emailField.setFont(inputFont);
        formPanel.add(emailField);

        phoneField.setBorder(BorderFactory.createTitledBorder("Phone"));
        TitledBorder phoneFieldBorder = BorderFactory.createTitledBorder("Phone:");
        phoneFieldBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        phoneField.setBorder(phoneFieldBorder);
        phoneField.setFont(inputFont);
        formPanel.add(phoneField);

        addressField.setBorder(BorderFactory.createTitledBorder("Address"));
        TitledBorder addressFieldBorder = BorderFactory.createTitledBorder("Address:");
        addressFieldBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        addressField.setBorder(emailFieldBorder);
        addressField.setFont(inputFont);
        formPanel.add(addressField);

        TitledBorder genderComboBoxBorder = BorderFactory.createTitledBorder("Gender:");
        genderComboBoxBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        genderComboBox.setBorder(emailFieldBorder);
        genderComboBox.setFont(inputFont);
        formPanel.add(genderComboBox);

        TitledBorder passwordFieldBorder = BorderFactory.createTitledBorder("Password:");
        passwordFieldBorder.setTitleFont(borderTitleFont);
        passwordField.setBorder(passwordFieldBorder);
        passwordField.setFont(inputFont);
        formPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));


        submitButton.setBackground(Color.decode("#4CAF50"));
        submitButton.setFont(borderTitleFont);
        submitButton.setForeground(Color.white);
        submitButton.setPreferredSize(new Dimension(200, 40));
        buttonPanel.setSize(new Dimension(220, 40));
        buttonPanel.add(submitButton);
        formPanel.add(buttonPanel);

        containerPanel.add(formPanel, BorderLayout.CENTER);
        add(containerPanel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.decode("#f44336"));
        backButton.setForeground(Color.white);
        backButton.setPreferredSize(new Dimension(200, 40));
        buttonPanel.add(backButton);
        backButton.setFont(borderTitleFont);
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        containerPanel.add(footerPanel, BorderLayout.SOUTH);
        footerPanel.setBackground(new Color(0, 30, 3,150)); // Semi-transparent black background
        JLabel contactLabel = new JLabel("notice: please remember your userId for login");
        contactLabel.setFont(inputFont);
        contactLabel.setForeground(Color.white);
        contactLabel.setHorizontalAlignment(JLabel.LEADING);
        footerPanel.add(contactLabel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);



        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Objects.equals(emailField.getText(), "")) {
                    JOptionPane.showMessageDialog(null, "Enter email!", "Message", JOptionPane.WARNING_MESSAGE);
                } else {
                    dispose();
                    new Login();

                    String url = "jdbc:mysql://localhost:3306/lostandfound";
                    String username = "root";
                    String Password = "";
                    try {
                        // 1. Load the database driver
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        String pass = passwordField.getText();
                        String name = nameField.getText();
                        String email = emailField.getText();
                        String phone = phoneField.getText();
                        String address = addressField.getText();
                        String gender = Objects.requireNonNull(genderComboBox.getSelectedItem()).toString();

                        // 2. Establish a connection
                        Connection connection = DriverManager.getConnection(url, username, Password);

                        // 3. Create a prepared statement
                        String insertQuery = "INSERT INTO userdata (username, password, email, phone, address, gender) VALUES (?, ?, ?, ?, ?, ?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

                        // 4. Set parameters for the prepared statement
                        preparedStatement.setString(1, generateRandomUserId());
                        preparedStatement.setString(2, pass);
                        preparedStatement.setString(3, email);
                        preparedStatement.setString(4, phone);
                        preparedStatement.setString(5, address);
                        preparedStatement.setString(6, gender);

                        // 5. Execute the statement to insert data
                        int rowsAffected = preparedStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "User added:\n" + "Name: " + name + "\nEmail: " + email, "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to add user", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                        // 6. Close the resources
                        preparedStatement.close();
                        connection.close();
                    } catch (ClassNotFoundException | SQLException x) {
                        x.printStackTrace();
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


    public String generateRandomUserId() {
        Random random = new Random();
        int randomUserId = 100000 + random.nextInt(100000); // Generate random ID
        // Check for uniqueness (this is just an example, replace it with your actual check)
        while (isUserIdExists(randomUserId)) {
            randomUserId = 100000 + random.nextInt(100000); // Regenerate until unique

        }
        userIdField.setText(String.valueOf(randomUserId));
        return String.valueOf(randomUserId);
    }

    // Simulate checking if the user ID exists (replace with your actual implementation)
     boolean isUserIdExists(int userId) {
        String url = "jdbc:mysql://localhost:3306/lostandfound";
        String username = "root";
        String password = "";
        try {
            // 1. Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT COUNT(*) FROM userdata WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);

            // 2. Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next(); // Move to the first row
            int count = resultSet.getInt(1); // Get the count of records

            // 3. Return true if the ID already exists, false otherwise
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(Signup::new);
    }

}

