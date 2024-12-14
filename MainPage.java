import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {

    private JPanel jPanel1;
    private JPanel Right;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel Left;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField jTextField1;
    private JLabel jLabel3;
    private JPasswordField jPasswordField1;
    private JButton jButton1;
    private JLabel jLabel4;
    private JButton jButton2;

    public MainPage() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        Right = new JPanel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        Left = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jLabel3 = new JLabel();
        jPasswordField1 = new JPasswordField();
        jButton1 = new JButton();
        jLabel4 = new JLabel();
        jButton2 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setPreferredSize(new Dimension(800, 500));

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setPreferredSize(new Dimension(800, 500));
        jPanel1.setLayout(null);

        Right.setBackground(new Color(0, 102, 102));
        Right.setPreferredSize(new Dimension(400, 500));

        jLabel5.setIcon(new ImageIcon("C:\\Users\\Rahemet\\Documents\\NetBeansProjects\\LoginAndSignUp\\src\\Icon\\logo.png"));

        jLabel6.setFont(new Font("Showcard Gothic", Font.BOLD, 24));
        jLabel6.setForeground(new Color(255, 255, 255));
        jLabel6.setText("Company Name");

        jLabel7.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
        jLabel7.setForeground(new Color(204, 204, 204));
        jLabel7.setText("copyright © company name All rights reserved");

        GroupLayout RightLayout = new GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
                RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                                .addGap(0, 81, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(40, 40, 40))
                        .addGroup(RightLayout.createSequentialGroup()
                                .addGroup(RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(RightLayout.createSequentialGroup()
                                                .addGap(103, 103, 103)
                                                .addComponent(jLabel6))
                                        .addGroup(RightLayout.createSequentialGroup()
                                                .addGap(145, 145, 145)
                                                .addComponent(jLabel5)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
                RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(RightLayout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(jLabel5)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(78, 78, 78))
        );

        jPanel1.add(Right);
        Right.setBounds(0, 0, 400, 500);

        Left.setBackground(new Color(255, 255, 255));
        Left.setMinimumSize(new Dimension(400, 500));

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 36));
        jLabel1.setForeground(new Color(0, 102, 102));
        jLabel1.setText("LOGIN");

        jLabel2.setBackground(new Color(102, 102, 102));
        jLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel2.setText("Email");

        jTextField1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jTextField1.setForeground(new Color(102, 102, 102));

        jLabel3.setBackground(new Color(102, 102, 102));
        jLabel3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel3.setText("Password");

        jButton1.setBackground(new Color(0, 102, 102));
        jButton1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setText("Login");

        jLabel4.setText("I don't have an account");

        jButton2.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        jButton2.setText("Sign Up");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

            }
        });

        GroupLayout LeftLayout = new GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
                LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(LeftLayout.createSequentialGroup()
                                .addGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(LeftLayout.createSequentialGroup()
                                                .addGap(138, 138, 138)
                                                .addComponent(jLabel1))
                                        .addGroup(LeftLayout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel2)
                                                                .addComponent(jTextField1)
                                                                .addComponent(jLabel3)
                                                                .addComponent(jPasswordField1, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(LeftLayout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton2)))))
                                .addContainerGap(27, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
                LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(LeftLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel1)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jButton2))
                                .addContainerGap(77, Short.MAX_VALUE))
        );

        jPanel1.add(Left);
        Left.setBounds(400, 0, 400, 500);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 149, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("LOGIN");

        pack();
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainPage::new);
    }
}
