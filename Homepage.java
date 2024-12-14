import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage extends JFrame {

    JLabel profile = new JLabel();
    JLabel title = new JLabel("Welcome to Lost and Found");
    JButton signUpButton = new JButton("Sign Up");
    JPanel headerPanel = new JPanel();
    Font borderTitleFont = new Font("AGENCY FB", Font.BOLD, 30);
    Font h2font = new Font("AGENCY FB", Font.BOLD, 15);
    public Homepage() {
        setTitle("Lost and Found portal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFont(borderTitleFont);
        setSize(1080, 720);
        setLocationRelativeTo(null);
        setContentPane(new JLabel(new ImageIcon("background2.jpg"))); // Assuming bg.jpg is in the root of your project

        setLayout(new BorderLayout());

        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(0, 0, 0, 150)); // Semi-transparent black background

        title.setForeground(Color.white);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(borderTitleFont);
        headerPanel.add(title, BorderLayout.CENTER);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(h2font);
        loginButton.setFocusable(false);
        loginButton.setBackground(new Color(0x7DBD7C)); // Custom green color
        headerPanel.add(loginButton, BorderLayout.WEST);


        JButton signUpButton = new JButton("Signup ");
        signUpButton.setFont(h2font);
        signUpButton.setFocusable(false);
        signUpButton.setBackground(new Color(230, 38, 30)); // Custom red color

        headerPanel.add(signUpButton, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());
        containerPanel.setBackground(new Color(0, 0, 0, 50)); // Semi-transparent black background

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton lostButton = new JButton("Lost");
        lostButton.setBackground(new Color(0xF0EA5463, true)); // Custom red color
        lostButton.setPreferredSize(new Dimension(200, 100));
        lostButton.setFont(borderTitleFont);
        buttonPanel.add(lostButton, gbc);
        lostButton.setFocusable(false);

        JButton searchButton = new JButton("Search");
        searchButton.setBackground(new Color(241, 132, 12)); // Custom blue color
        searchButton.setPreferredSize(new Dimension(200, 100));
        searchButton.setFont(borderTitleFont);
        buttonPanel.add(searchButton, gbc);
        searchButton.setFocusable(false);

        JButton foundButton = new JButton("Found");
        foundButton.setBackground(new Color(0x8AAF48)); // Custom green color
        foundButton.setPreferredSize(new Dimension(200, 100));
        foundButton.setFont(borderTitleFont);
        buttonPanel.add(foundButton, gbc);
        foundButton.setFocusable(false);

        containerPanel.add(buttonPanel, BorderLayout.CENTER);
        add(containerPanel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BorderLayout());
        footerPanel.setBackground(new Color(0, 0, 0, 150)); // Semi-transparent black background
        JLabel contactLabel = new JLabel("Contact: lostandfound@gmail.com");
        contactLabel.setForeground(Color.white);
        contactLabel.setHorizontalAlignment(JLabel.CENTER);
        footerPanel.add(contactLabel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Signup s = new Signup();
            }
        });

        lostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Lost();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Search();
            }
        });

        foundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Found();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Homepage::new);
    }
}