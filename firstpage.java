import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class firstpage extends JFrame {

    public firstpage() {
        setTitle("welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 720);
        setLayout(new BorderLayout());
setLocationRelativeTo(null);
        // Create a panel for the image
        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load your image here
                ImageIcon imageIcon = new ImageIcon("welcome1.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        add(imagePanel, BorderLayout.CENTER);

        // Create a button panel for the footer
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#333"));
        JButton backButton = new JButton("Click Here To continue");
        backButton.setBackground(Color.decode("#FFE81C"));
        backButton.setForeground(Color.black);
        backButton.setPreferredSize(new Dimension(200, 40));

        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listener to the button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Homepage(); // Replace with the appropriate constructor if needed
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(firstpage::new);
    }
}
