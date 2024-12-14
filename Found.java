import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.TitledBorder;

public class Found extends JFrame {

    public Found() {
        setTitle("Report Found Item");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 720);
        setLayout(new GridLayout());
        setLocationRelativeTo(null);
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
        containerPanel.setBackground(Color.decode("#f4f4f4"));
        containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 200, 0, 200));

        JLabel titleLabel = new JLabel("Report Found Item");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.decode("#4CAF50"));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        containerPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.white);
        formPanel.setLayout(new GridLayout(11, 1, 2, 0));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 20));

        Font borderTitleFont = new Font("AGENCY FB", Font.BOLD, 15); // Define custom font for titles
        Font inputFont = new Font("Consolas", Font.PLAIN, 15); // Define custom font for input fields

        // Custom titled border for item name field
        JTextField idField = new JTextField();
        TitledBorder idFieldBorder = BorderFactory.createTitledBorder("Item Name:");
        idFieldBorder.setTitleFont(borderTitleFont);
        idFieldBorder.setTitleColor(Color.BLACK);
        idField.setBorder(idFieldBorder);
        idField.setPreferredSize(new Dimension(400, 40));
        idField.setFont(inputFont); // Apply font to input field
        formPanel.add(idField);

        // Custom titled border for founder name field
        JTextField nameField = new JTextField();
        TitledBorder nameFieldBorder = BorderFactory.createTitledBorder("FOUNDER NAME:");
        nameFieldBorder.setTitleFont(borderTitleFont);
        nameFieldBorder.setTitleColor(Color.BLACK);
        nameField.setBorder(nameFieldBorder);
        nameField.setPreferredSize(new Dimension(300, 40));
        nameField.setFont(inputFont); // Apply font to input field
        formPanel.add(nameField);

        // Custom titled border for founder phone field
        JTextField phoneField = new JTextField();
        TitledBorder phoneFieldBorder = BorderFactory.createTitledBorder("Founder Phone:");
        phoneFieldBorder.setTitleFont(borderTitleFont);
        phoneFieldBorder.setTitleColor(Color.BLACK);
        phoneField.setBorder(phoneFieldBorder);
        phoneField.setPreferredSize(new Dimension(200, 40));
        phoneField.setFont(inputFont); // Apply font to input field
        formPanel.add(phoneField);

        // Custom titled border for email field
        JTextField emailField = new JTextField();
        TitledBorder emailFieldBorder = BorderFactory.createTitledBorder("Email:");
        emailFieldBorder.setTitleFont(borderTitleFont);
        emailFieldBorder.setTitleColor(Color.BLACK);
        emailField.setBorder(emailFieldBorder);
        emailField.setPreferredSize(new Dimension(350, 40));
        emailField.setFont(inputFont); // Apply font to input field
        formPanel.add(emailField);

        // Custom titled border for IMEI field
        JTextField imeiField = new JTextField();
        TitledBorder imeiFieldBorder = BorderFactory.createTitledBorder("IMEI No");
        imeiFieldBorder.setTitleFont(borderTitleFont);
        imeiFieldBorder.setTitleColor(Color.BLACK);
        imeiField.setBorder(imeiFieldBorder);
        imeiField.setPreferredSize(new Dimension(250, 40));
        imeiField.setFont(inputFont); // Apply font to input field

        // Custom titled border for founder ID field
        JTextField founderIdField = new JTextField();
        TitledBorder founderIdFieldBorder = BorderFactory.createTitledBorder("ID NO");
        founderIdFieldBorder.setTitleFont(borderTitleFont);
        founderIdFieldBorder.setTitleColor(Color.BLACK);
        founderIdField.setBorder(founderIdFieldBorder);
        founderIdField.setPreferredSize(new Dimension(300, 40));
        founderIdField.setFont(inputFont); // Apply font to input field

        // Custom titled border for vehicle registration field
        JTextField vehicleRegNoField = new JTextField();
        TitledBorder vehicleRegNoFieldBorder = BorderFactory.createTitledBorder("Vehicle Registration Number");
        vehicleRegNoFieldBorder.setTitleFont(borderTitleFont);
        vehicleRegNoFieldBorder.setTitleColor(Color.BLACK);
        vehicleRegNoField.setBorder(vehicleRegNoFieldBorder);
        vehicleRegNoField.setPreferredSize(new Dimension(250, 40));
        vehicleRegNoField.setFont(inputFont); // Apply font to input field

        // Custom titled border for item category combo box
        String[] item_list = {"Phone", "Vehicle", "ID Card", "Wallet", "Keys", "Jewelry", "Electronics", "Clothing", "Accessories", "Books", "Documents", "Others"};
        JComboBox<String> itemcatagory = new JComboBox<>(item_list);
        itemcatagory.setPreferredSize(new Dimension(200, 60));
        TitledBorder itemCategoryBorder = BorderFactory.createTitledBorder("Item Category");
        itemCategoryBorder.setTitleFont(borderTitleFont);
        itemCategoryBorder.setTitleColor(Color.BLACK);
        itemcatagory.setBorder(itemCategoryBorder);
        itemcatagory.setSelectedItem(null);
        itemcatagory.setFont(inputFont); // Apply font to combo box
        formPanel.add(itemcatagory);

        // Custom titled border for item color combo box
        String[] colorField = {"Red", "Green", "Blue", "Yellow", "Black", "White", "Other"};
        JComboBox<String> itemcolor = new JComboBox<>(colorField);
        TitledBorder itemColorBorder = BorderFactory.createTitledBorder("Item Color");
        itemColorBorder.setTitleFont(borderTitleFont);
        itemColorBorder.setTitleColor(Color.BLACK);
        itemcolor.setBorder(itemColorBorder);
        itemcolor.setSelectedItem(null);
        itemcolor.setPreferredSize(new Dimension(150, 50));
        itemcolor.setFont(inputFont); // Apply font to combo box
        formPanel.add(itemcolor);

        // Custom titled border for location field
        JTextField locationField = new JTextField();
        TitledBorder locationFieldBorder = BorderFactory.createTitledBorder("item current Location");
        locationFieldBorder.setTitleFont(borderTitleFont);
        locationFieldBorder.setTitleColor(Color.BLACK);
        locationField.setBorder(locationFieldBorder);
        locationField.setPreferredSize(new Dimension(100, 40));
        locationField.setFont(inputFont); // Apply font to input field
        formPanel.add(locationField);

        // Custom titled border for short description area
        JTextArea shortDescriptionArea = new JTextArea();
        TitledBorder shortDescriptionAreaBorder = BorderFactory.createTitledBorder("Short Description");
        shortDescriptionAreaBorder.setTitleFont(borderTitleFont);
        shortDescriptionAreaBorder.setTitleColor(Color.BLACK);
        shortDescriptionArea.setBorder(shortDescriptionAreaBorder);
        shortDescriptionArea.setRows(5);
        shortDescriptionArea.setPreferredSize(new Dimension(150, 80));
        shortDescriptionArea.setFont(inputFont); // Apply font to text area
        formPanel.add(shortDescriptionArea);

        // Custom titled border for found date field
        JTextField foundDateField = new JTextField();
        TitledBorder foundDateFieldBorder = BorderFactory.createTitledBorder("Found Date");
        foundDateFieldBorder.setTitleFont(borderTitleFont);
        foundDateFieldBorder.setTitleColor(Color.BLACK);
        foundDateField.setBorder(foundDateFieldBorder);
        foundDateField.setPreferredSize(new Dimension(100, 40));
        foundDateField.setFont(inputFont); // Apply font to input field
        formPanel.add(foundDateField);

        // Add an ItemListener to itemcatagory
        itemcatagory.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Check if the selected category is "Phone"
                if ("Phone".equals(itemcatagory.getSelectedItem())) {
                    // If "Phone" is selected, add the IMEI No field
                    formPanel.add(imeiField);
                } else {
                    // If a category other than "Phone" is selected, remove the IMEI No field
                    formPanel.remove(imeiField);
                }

                if ("ID Card".equals(itemcatagory.getSelectedItem())) {
                    formPanel.add(founderIdField);
                } else {
                    formPanel.remove(founderIdField);
                }

                if ("Vehicle".equals(itemcatagory.getSelectedItem())) {
                    formPanel.add(vehicleRegNoField);
                } else {
                    formPanel.remove(vehicleRegNoField);
                }

                formPanel.repaint();
                formPanel.revalidate();
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.decode("#4CAF50"));
        submitButton.setForeground(Color.white);
        submitButton.setPreferredSize(new Dimension(200, 40));

        containerPanel.add(formPanel, BorderLayout.CENTER);
        add(containerPanel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.decode("#f4f4f4"));
        JButton backButton = new JButton("Back to Homepage");
        backButton.setBackground(Color.decode("#f44336"));
        backButton.setForeground(Color.white);
        backButton.setPreferredSize(new Dimension(200, 40));
        footerPanel.add(backButton);
        footerPanel.add(submitButton);
        containerPanel.add(footerPanel, BorderLayout.SOUTH);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Homepage();
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Homepage();
                String url = "jdbc:mysql://localhost:3306/lostandfound";
                String Username = "root";
                String Password = "";

                try {
                    // 1. Load the database driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    String item = idField.getText();
                    String founder_name = nameField.getText();
                    String phone_no = phoneField.getText();
                    String email_no = emailField.getText();
                    int colors = itemcolor.getSelectedIndex();
                    String locations = locationField.getText();
                    String founder_id = founderIdField.getText();
                    String description = shortDescriptionArea.getText();
                    String found_date = foundDateField.getText();
                    int category = itemcatagory.getSelectedIndex();
                    String imei = imeiField.getText();

                    // 2. Establish a connection
                    Connection connection = DriverManager.getConnection(url, Username, Password);

                    // 3. Create a prepared statement
                    String insertQuery = "INSERT INTO found_item (item1, foundername2, founderphone3, email4, itemcolor5, location6, founderid7, description8, founddate9, itemcatagory) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

                    // 4. Set parameters for the prepared statement
                    preparedStatement.setString(1, item);
                    preparedStatement.setString(2, founder_name);
                    preparedStatement.setString(3, phone_no);
                    preparedStatement.setString(4, email_no);
                    preparedStatement.setInt(5, colors);
                    preparedStatement.setString(6, locations);
                    preparedStatement.setString(7, founder_id);
                    preparedStatement.setString(8, description);
                    preparedStatement.setString(9, found_date);
                    preparedStatement.setInt(10, category);

                    // 5. Execute the statement to insert data
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Data inserted successfully!");
                    } else {
                        System.out.println("Failed to insert data.");
                    }

                    // 6. Close the resources
                    preparedStatement.close();
                    connection.close();
                } catch (ClassNotFoundException | SQLException A) {
                    A.printStackTrace();
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Found::new);
    }
}
