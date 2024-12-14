import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemDetails extends JFrame implements ActionListener {
    JFrame mainFrame = new JFrame("Item Details");
    JPanel FRAME = new JPanel();
    JLabel TITLE = new JLabel();
    JLabel productFounder = new JLabel();
    JLabel productName = new JLabel();
    JLabel FounderPhone = new JLabel();
    JLabel Address = new JLabel();
    JLabel email = new JLabel();
    JLabel founderid = new JLabel("Student ID:");
    JLabel itemcolor = new JLabel();
    JLabel date = new JLabel();
    JLabel description = new JLabel();
    JButton homepage = new JButton("<BACK");
    ImageIcon contact = new ImageIcon("phone-call.png");
    ImageIcon addressimage = new ImageIcon("home-address.png");
    ImageIcon founderimage = new ImageIcon("face-scan.png");
    ImageIcon calendar = new ImageIcon("calendar.png");
    ImageIcon email_image = new ImageIcon("gmail.png");
    ImageIcon ur_item = new ImageIcon("mobile-phone .png");
    ImageIcon description_image = new ImageIcon("description.png");
    ImageIcon homepage_image = new ImageIcon("homepage.png");
    JLabel contact_image = new JLabel();
    JLabel addressLabel = new JLabel();
    JLabel founder = new JLabel();
    JLabel found_date = new JLabel();
    JLabel your_item = new JLabel();
    JLabel founder_email = new JLabel();
    JLabel founder_id = new JLabel();
    JLabel item_description = new JLabel();
    Font inputFont = new Font("Consolas", Font.PLAIN, 15); // Define custom font
    Font borderTitleFont = new Font("AGENCY FB", Font.BOLD, 15); // Define custom font
    ItemDetails() {
        mainFrame.setSize(1080, 720);
        FRAME.setSize(480, 620);
        int centerX = (mainFrame.getWidth()/2)-(FRAME.getWidth()/2);
        FRAME.setBorder(BorderFactory.createLineBorder(Color.black));
        mainFrame.setLocationRelativeTo(null);
        homepage.setBackground(new Color(0xFF8100));
        FRAME.setBackground(new Color(0x7B9377));
        mainFrame.setContentPane(new JLabel(new ImageIcon("background2.jpg")));
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setLayout(null);
        FRAME.setLayout(null);  // Use null layout for absolute positioning
        mainFrame.add(FRAME);
        FRAME.setBounds(centerX, 20,480, 620);

        // Adding components to the frame
        FRAME.add(TITLE);
        FRAME.add(productFounder);
        FRAME.add(productName);
        FRAME.add(FounderPhone);
        FRAME.add(Address);
        FRAME.add(homepage);
        FRAME.add(founderid);
        FRAME.add(date);
        FRAME.add(email);
        FRAME.add(description);
        FRAME.add(contact_image);
        FRAME.add(founder_email);
        FRAME.add(founder_id);
        FRAME.add(founder);
        FRAME.add(addressLabel);
        FRAME.add(found_date);
        FRAME.add(your_item);
        FRAME.add(item_description);
        FRAME.add(homepage);

        // Styling labels
        TITLE.setFont(new Font("AGENCY FB", Font.BOLD, 30));
        founderid.setFont(borderTitleFont);
        productFounder.setFont(borderTitleFont);
        productName.setFont(borderTitleFont);
        Address.setFont(borderTitleFont);
        FounderPhone.setFont(borderTitleFont);
        email.setFont(borderTitleFont);
        itemcolor.setFont(borderTitleFont);
        date.setFont(borderTitleFont);
        description.setFont(borderTitleFont);
        homepage.setFont(inputFont);

        // Setting bounds for components
        TITLE.setBounds((FRAME.getWidth()/2)-100, 10, 400, 40);

        // Founder Section
        founder_id.setBounds(10, 70, 32, 52);
        founderid.setBounds(10, 70, 400, 60);
        founderid.setBackground(new Color(149, 149, 142));
        founder.setBounds(10, 130, 32, 52);
        productFounder.setBounds(50, 125, 400, 70);
        productFounder.setBackground(new Color(149, 149, 142));

        // Item Section
        your_item.setBounds(10, 190, 32, 52);
        productName.setBounds(50, 185, 400, 70);
        productName.setBackground(new Color(149, 149, 142));

        addressLabel.setBounds(10, 250, 32, 52);
        Address.setBounds(50, 245, 400, 70);
        Address.setBackground(new Color(149, 149, 142));

        // Contact Section
        contact_image.setBounds(10, 310, 32, 52);
        FounderPhone.setBounds(50, 305, 400, 70);
        FounderPhone.setBackground(new Color(149, 149, 142));

        founder_email.setBounds(10, 370, 32, 52);
        email.setBounds(50, 365, 400, 60);
        email.setBackground(new Color(149, 149, 142));

        // Found Date Section
        found_date.setBounds(10, 430, 32, 52);
        date.setBounds(50, 425, 400, 70);
        date.setBackground(new Color(149, 149, 142));

        itemcolor.setBounds(50, 490, 400, 70);
        itemcolor.setBackground(new Color(149, 149, 142));

        // Description Section
        item_description.setBounds(10, 560, 32, 52);
        description.setBounds(10, 500, 400, 70);
        description.setBackground(new Color(149, 149, 142));

        // Homepage Button
        homepage.setBounds(15, 15, 64, 64);
        homepage.setSize(new Dimension(80,30));
        homepage.setFocusable(false);
     //   homepage.setIcon(homepage_image);

        // Setting icons for components
        contact_image.setIcon(contact);
        founder.setIcon(founderimage);
        found_date.setIcon(calendar);
        addressLabel.setIcon(addressimage);
        founder_email.setIcon(email_image);
        your_item.setIcon(ur_item);
        item_description.setIcon(description_image);

        // Setting text for components
        TITLE.setText("LOST & FOUND");
        productFounder.setText("Founder: ");
        productName.setText("Your item: ");
        Address.setText("Address: ");
        date.setText("Found date: ");
        email.setText("Email: ");
        FounderPhone.setText("contact:");
        itemcolor.setText("Item color: ");
        description.setText("Description: ");

        homepage.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homepage) {
            mainFrame.dispose();
            Homepage homepage2 = new Homepage();
        }
    }

    public static void main(String[] args) {
        new ItemDetails();
    }
}
