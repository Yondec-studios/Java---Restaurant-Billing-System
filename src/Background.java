import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Background extends JFrame implements ActionListener {
    // CREATED OBJECTS
    JLabel mainText = new JLabel();
    JLabel topImage = new JLabel();
    JLabel footerText = new JLabel();
    JLabel footerUpText = new JLabel();
    JButton loginButton = new JButton();
    JButton createOneButton = new JButton();
    ImageIcon image = new ImageIcon("./Images/topImageNew.png");

    // CONSTRUCTOR
    Background() {
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(1080, 720);
        this.setTitle("Restaurant Billing System");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(209, 235, 255));
        this.add(mainText);
        this.add(loginButton);
        this.add(createOneButton);
        this.add(footerText);
        this.add(footerUpText);
        this.add(topImage);

        //IMAGE
        topImage.setBounds(440,80,200,200);
        topImage.setIcon(image);

        // TOPIC CUSTOMIZATION
        mainText.setText("RESTAURANT BILLING SYSTEM");
        mainText.setForeground(new Color(18, 84, 136));
        mainText.setFont(new Font("Poppins", Font.BOLD, 40));
        mainText.setBounds(0, 220, 1080, 200);
        mainText.setHorizontalAlignment(JLabel.CENTER);

        // LOGIN BUTTON CUSTOMIZATION
        loginButton.setText("Log In");
        loginButton.setBackground(new Color(55, 202, 236));
        loginButton.setForeground(new Color(0, 0, 0));
        loginButton.setFont(new Font("Calibri", Font.BOLD, 19));
        loginButton.setBounds(390, 400, 100, 40);
        loginButton.setFocusable(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder(3,0,0,0));
        loginButton.addActionListener(this);

        // CREATE ACCOUNT BUTTON
        createOneButton.setText("Create One");
        createOneButton.setBackground(new Color(55, 202, 236));
        createOneButton.setForeground(new Color(0, 0, 0));
        createOneButton.setFont(new Font("Calibri", Font.BOLD, 19));
        createOneButton.setBounds(500, 400, 180, 40);
        createOneButton.setFocusable(false);
        createOneButton.setBorder(BorderFactory.createEmptyBorder(3,0,0,0));
        createOneButton.addActionListener(this);

        // FOOTER TEXT FIELD
        footerText.setText("Faculty of Science | University of Kelaniya");
        footerText.setForeground(new Color(100, 100, 100));
        footerText.setFont(new Font("Calibri", Font.BOLD, 18));
        footerText.setBounds(0, 600, 1080, 100);
        footerText.setHorizontalAlignment(JLabel.CENTER);

        footerUpText.setText("BECS 12243");
        footerUpText.setForeground(new Color(100, 100, 100));
        footerUpText.setFont(new Font("Calibri", Font.BOLD, 18));
        footerUpText.setBounds(0, 575, 1080, 100);
        footerUpText.setHorizontalAlignment(JButton.CENTER);
    }

    // BUTTON ACTIONS
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
            dispose();
            new Login();
        }
        if(e.getSource() == createOneButton){
            dispose();
            new CreateOne();
        }
    }
}