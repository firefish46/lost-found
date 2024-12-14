import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Search extends JFrame implements ActionListener {

    JTextField searchField = new JTextField();
    String[] item_list = {"Phone", "Vehicle", "ID Card", "Wallet", "Keys", "Jewelry", "Electronics", "Clothing", "Accessories", "Books", "Documents", "Others"};
    JComboBox itemcatagory = new JComboBox(item_list);
    JComboBox<String> colorField;

    JButton searchButton = new JButton("Search");
    JButton backButton = new JButton("Back to Homepage");

    Font inputFont = new Font("Consolas", Font.PLAIN, 15); // Define custom font
    Font borderTitleFont = new Font("AGENCY FB", Font.BOLD, 20); // Define custom font
    public Search() {
        setTitle("Search Lost and Found Items");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 720);
        setLayout(new BorderLayout());
setLocationRelativeTo(null);
        JPanel containerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                ImageIcon backgroundImage = new ImageIcon("background2.jpg");
                // Draw the background image
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        containerPanel.setLayout(new BorderLayout());
        containerPanel.setBorder(BorderFactory.createEmptyBorder(100, 300, 100, 300));

        JLabel titleLabel = new JLabel("Search Lost  Items");
        titleLabel.setFont(new Font("AGENCY FB", Font.BOLD, 36));
        titleLabel.setForeground(Color.decode("#4CAF50"));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        containerPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.white);
        formPanel.setLayout(new GridLayout(5, 2, 0, 15));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        searchField.setPreferredSize(new Dimension(400, 40));
        TitledBorder searchFieldBorder = BorderFactory.createTitledBorder("itemName:");
        searchFieldBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        searchFieldBorder.setTitleColor(Color.DARK_GRAY);
        searchField.setBorder(searchFieldBorder);
        searchField.setFont(inputFont);
        formPanel.add(searchField);

        itemcatagory.setPreferredSize(new Dimension(400, 40));
        TitledBorder itemcatagoryBorder = BorderFactory.createTitledBorder("Item Category:");
        itemcatagoryBorder.setTitleFont(borderTitleFont); // Set the custom font for the title
        itemcatagoryBorder.setTitleColor(Color.DARK_GRAY);
        itemcatagory.setBorder(itemcatagoryBorder);
        formPanel.add(itemcatagory);

        String[] colorOptions = {"Red", "Green", "Blue", "Yellow", "Black", "White", "Other"};
        colorField = new JComboBox<>(colorOptions);
        colorField.setPreferredSize(new Dimension(400, 40));
        colorField.setBorder(BorderFactory.createTitledBorder("Item Color"));
        colorField.setFont(inputFont);
        itemcatagory.setFont(inputFont);
        formPanel.add(colorField);
        searchButton.setBackground(Color.decode("#4CAF50"));
        searchButton.setForeground(Color.white);
        searchButton.setPreferredSize(new Dimension(400, 40));
        searchButton.setFont(borderTitleFont);
        formPanel.add(searchButton);

        containerPanel.add(formPanel, BorderLayout.CENTER);
        add(containerPanel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.decode("#f4f4f4"));

        backButton.setBackground(Color.decode("#f44336"));
        backButton.setForeground(Color.white);
        backButton.setPreferredSize(new Dimension(200, 40));
        backButton.setFont(borderTitleFont);
        footerPanel.add(backButton);
        containerPanel.add(footerPanel, BorderLayout.SOUTH);

        backButton.addActionListener(this);
        searchButton.addActionListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Search::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
            new Homepage();
        }
        if (e.getSource() == searchButton) {

            String url = "jdbc:mysql://localhost:3306/lostandfound";
            String UserName = "root";
            String Password = "";

            try {
                // 1. Load the database driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // 2. Establish a connection
                Connection connection = DriverManager.getConnection(url, UserName, Password);

                String productName = searchField.getText();
                int category = itemcatagory.getSelectedIndex();
                String color = colorField.getSelectedItem().toString(); // Get the selected color


                StringBuilder queryBuilder = new StringBuilder("SELECT * FROM  found_item WHERE item1 = ?  AND itemcatagory = ? AND itemcolor5 = ?");




                PreparedStatement preparedStatement = connection.prepareStatement(queryBuilder.toString());
                preparedStatement.setString(1, productName);
                preparedStatement.setString(2, color);
                preparedStatement.setInt(3, category);

                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    dispose();
                    System.out.println("Item found");
                    ItemDetails D = new ItemDetails();

                    String itemname = resultSet.getString("item1");
                    String NaMe = resultSet.getString("foundername2");
                    String founderphone = resultSet.getString("founderphone3");
                    String email = resultSet.getString("email4");
                    String location6 = resultSet.getString("location6");
                    String founderid7 = resultSet.getString("founderid7");
                    String description8 = resultSet.getString("description8");
                    String founddate9 = resultSet.getString("founddate9");

                    D.productFounder.setText("Founder:  " + NaMe);
                    D.productName.setText("Your item: " + itemname);
                    D.Address.setText("ADDRESS: " + location6);
                    D.FounderPhone.setText("Contact: " + founderphone);
                    D.email.setText("Email:  " + email);
                    D.itemcolor.setText("Item color: " + color);
                    D.founderid.setText("STUDENT ID: " + founderid7);
                    D.description.setText("Description : " + description8);
                    D.date.setText("Found date : " + founddate9);

                    JOptionPane.showMessageDialog(null, "Item Found!", "Done", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Item not found.", "Failed", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Item not found: " + productName + "::" + category);
                }

                // Close resources
                resultSet.close();
                preparedStatement.close();
                connection.close();

            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
                System.out.println("Database connection or query execution error.");
            }
        }
    }
}
