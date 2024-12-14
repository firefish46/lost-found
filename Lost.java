import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Lost extends JFrame {

    public Lost() {
        JFrame frame = new JFrame("Lost");

        setTitle("Report Lost Item");
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

        containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 200, 0, 200));

        Font inputFont = new Font("Consolas", Font.PLAIN, 15); // Define custom font
        Font borderTitleFont = new Font("AGENCY FB", Font.BOLD, 15); // Define custom font
        TitledBorder itemCategoryBorder = BorderFactory.createTitledBorder("Item Category");
        itemCategoryBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        itemCategoryBorder.setTitleColor(Color.black);    // Optional: Set the title color

        JLabel titleLabel = new JLabel("Report Lost Item");
        titleLabel.setFont(new Font("AGENCY FB", Font.BOLD, 36));
        titleLabel.setForeground(Color.decode("#4AF50"));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        containerPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.white);
        formPanel.setLayout(new GridLayout(11, 1, 0, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 20));
        frame.add(formPanel);
        JTextField idField = new JTextField();
        idField.setPreferredSize(new Dimension(400, 40));
        idField.setFont(inputFont);
        TitledBorder itemNameBorder = BorderFactory.createTitledBorder("Item Name:");
        itemNameBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        itemNameBorder.setTitleColor(Color.DARK_GRAY);
        idField.setBorder(itemNameBorder);
        formPanel.add(idField);

        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(400, 40));
        TitledBorder nameFieldBorder = BorderFactory.createTitledBorder("Name:");
        nameField.setFont(inputFont);
        nameFieldBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        nameFieldBorder.setTitleColor(Color.DARK_GRAY);
        nameField.setBorder(nameFieldBorder);
        formPanel.add(nameField);

        JTextField phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(400, 40));
        TitledBorder phoneFieldBorder = BorderFactory.createTitledBorder("Phone:");
        phoneField.setFont(inputFont);
        phoneFieldBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        phoneFieldBorder.setTitleColor(Color.DARK_GRAY);
        phoneField.setBorder(phoneFieldBorder);
        formPanel.add(phoneField);

        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(400, 40));
        TitledBorder emailFieldBorder = BorderFactory.createTitledBorder("Email:");
        emailField.setFont(inputFont);
        emailFieldBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        emailFieldBorder.setTitleColor(Color.DARK_GRAY);
        emailField.setBorder(emailFieldBorder);
        formPanel.add(emailField);

        JTextField imeiField = new JTextField();
        imeiField.setPreferredSize(new Dimension(400, 40));
        TitledBorder imeiFieldBorder = BorderFactory.createTitledBorder("IMEI No");
        imeiField.setFont(inputFont);
        imeiFieldBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        imeiFieldBorder.setTitleColor(Color.DARK_GRAY);
        imeiField.setBorder(imeiFieldBorder);

        JTextField founderIdField = new JTextField();
        founderIdField.setPreferredSize(new Dimension(400, 40));
        TitledBorder  founderIdBorder = BorderFactory.createTitledBorder("ID NO:");
        founderIdField.setFont(inputFont);
        founderIdBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        founderIdBorder.setTitleColor(Color.DARK_GRAY);
        founderIdField.setBorder(founderIdBorder);

        JTextField vehicleRegNoField = new JTextField();
        vehicleRegNoField.setPreferredSize(new Dimension(400, 40));

        TitledBorder vehicleRegNoFieldBorder = BorderFactory.createTitledBorder("Vehicle Registration Number:");
        vehicleRegNoField.setFont(inputFont);
        vehicleRegNoFieldBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        vehicleRegNoFieldBorder.setTitleColor(Color.DARK_GRAY);
        vehicleRegNoField.setBorder(vehicleRegNoFieldBorder);



        String[] item_list = {"Phone", "Vehicle", "ID Card", "Wallet", "Keys", "Jewelry", "Electronics", "Clothing", "Accessories", "Books", "Documents", "Others"};
        JComboBox<String> itemcatagory = new JComboBox<>(item_list);
        itemcatagory.setPreferredSize(new Dimension(400, 50));
        itemcatagory.setBorder(itemCategoryBorder);
        itemcatagory.setFont(inputFont);
        formPanel.add(itemcatagory);

        String[] colorField = {"Red", "Green", "Blue", "Yellow", "Black", "White", "Other"};
        JComboBox<String> itemcolor = new JComboBox<>(colorField);
        itemcolor.setPreferredSize(new Dimension(400, 50));
        itemcolor.setFont(inputFont);
        TitledBorder itemcolorBorder = BorderFactory.createTitledBorder("Item Color:");
        itemcolorBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        itemcolorBorder.setTitleColor(Color.DARK_GRAY);
        itemcolor.setBorder(itemcolorBorder);
        formPanel.add(itemcolor);

        JTextField locationField = new JTextField();
        locationField.setPreferredSize(new Dimension(400, 40));
        TitledBorder locationFieldBorder = BorderFactory.createTitledBorder("Vitem current Location:");
        locationField.setFont(inputFont);
        locationFieldBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        locationFieldBorder.setTitleColor(Color.DARK_GRAY);
        locationField.setBorder(locationFieldBorder);
        formPanel.add(locationField);

        JTextArea shortDescriptionArea = new JTextArea();
        shortDescriptionArea.setRows(2);
        TitledBorder shortDescriptionAreaBorder = BorderFactory.createTitledBorder("Short Description:");
        shortDescriptionArea.setFont(inputFont);
        shortDescriptionAreaBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        shortDescriptionAreaBorder.setTitleColor(Color.DARK_GRAY);
        shortDescriptionArea.setBorder(shortDescriptionAreaBorder);
        formPanel.add(shortDescriptionArea);

        JTextField foundDateField = new JTextField();
        foundDateField.setPreferredSize(new Dimension(400, 40));

        TitledBorder foundDateFieldBorder = BorderFactory.createTitledBorder("lost Date:");
        foundDateField.setFont(inputFont);
        foundDateFieldBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        foundDateFieldBorder.setTitleColor(Color.DARK_GRAY);
        foundDateField.setBorder(foundDateFieldBorder);
        formPanel.add(foundDateField);
itemcatagory.setSelectedItem(null);
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
                // Repaint and revalidate the formPanel to reflect the changes
                formPanel.repaint();
                formPanel.revalidate();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton submitButton = new JButton("Submit>");
        submitButton.setBackground(Color.decode("#4CAF50"));
        submitButton.setForeground(Color.white);
        submitButton.setPreferredSize(new Dimension(150, 30));
        submitButton.setFont(borderTitleFont);
        buttonPanel.add(submitButton);


        containerPanel.add(formPanel, BorderLayout.CENTER);
        add(containerPanel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.decode("#f4f4f4"));
        JButton backButton = new JButton("< Homepage");
        backButton.setBackground(Color.decode("#f44336"));
        backButton.setForeground(Color.white);
        backButton.setPreferredSize(new Dimension(150, 30));
        backButton.setFont(borderTitleFont);
        footerPanel.add(backButton);
        containerPanel.add(footerPanel, BorderLayout.SOUTH);
        footerPanel.add(buttonPanel);
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
                    String lost_name = nameField.getText();
                    String phoneno = phoneField.getText();
                    String emailno = emailField.getText();
                    int colors = itemcolor.getSelectedIndex();
                    String locations = locationField.getText();
                    String lostid = founderIdField.getText();
                    String description = shortDescriptionArea.getText();
                    String lostdate = foundDateField.getText();
                    int catagory = itemcatagory.getSelectedIndex();
                    String imei = imeiField.getText();

                    // 2. Establish a connection
                    Connection connection = DriverManager.getConnection(url, Username, Password);

                    // 3. Create a prepared statement
                    String insertQuery = "INSERT INTO lost_item (item1, lostname2, lostphone3, email4, itemcolor5, location6, lostid7, description8, lostdate9, itemcatagory, imei11, idno12, vr13) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

                    // 4. Set parameters for the prepared statement
                    preparedStatement.setString(1, item);
                    preparedStatement.setString(2, lost_name);
                    preparedStatement.setString(3, phoneno);
                    preparedStatement.setString(4, emailno);
                    preparedStatement.setInt(5, colors);
                    preparedStatement.setString(6, locations);
                    preparedStatement.setString(7, lostid);
                    preparedStatement.setString(8, description);
                    preparedStatement.setString(9, lostdate);
                    preparedStatement.setInt(10, catagory);
                    preparedStatement.setString(11, imei);
                    preparedStatement.setString(12, ""); // idno12
                    preparedStatement.setString(13, ""); // vr13

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
        SwingUtilities.invokeLater(Lost::new);
    }
}
