package gui;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    public static final int WIDTH=400;
    public static final int HEIGHT=550;


    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel line1;
    private JPanel line2;
    private JButton login;
    private JButton register;
    private JLabel errorLabel;
    private JLabel title;
    private JPanel panel;

    public LoginFrame(boolean isRegister){
        getContentPane().setBackground(Constants.BACKGROUND);
        if(isRegister){
            this.setVisible(false);
            this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        }
        else{
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);
        this.setLayout(null);
        this.setResizable(false);
        panel=new JPanel();
        panel.setBackground(Constants.BACKGROUND);
        panel.setBounds(0,0,WIDTH,HEIGHT);
        panel.setLayout(null);
        this.setContentPane(panel);

        title=new JLabel("Welcome");
        title.setFont(Constants.TITLE);
        title.setBounds(Constants.center(title,panel),40,200,50);
        panel.add(title);

        JLabel userLabel=new JLabel("Username");
        userLabel.setFont(Constants.SMALL);
        userLabel.setBounds(Constants.center(300,panel),130,200,20);
        panel.add(userLabel);

        usernameField=new JTextField();
        usernameField.setFont(Constants.PLAIN);
        usernameField.setBounds(Constants.center(300,panel),150,300,30);
        usernameField.setVisible(true);
        usernameField.setBorder(Constants.EMPTY_BORDER);
        panel.add(usernameField);

        line1=new JPanel();
        line1.setBackground(Constants.GRAY);
        line1.setBounds(Constants.center(300,panel),180,300,1);
        panel.add(line1);

        JLabel passLabel=new JLabel("Password");
        passLabel.setFont(Constants.SMALL);
        passLabel.setBounds(Constants.center(300,panel),230,200,20);
        panel.add(passLabel);

        passwordField=new JPasswordField();
        passwordField.setFont(Constants.PLAIN);
        passwordField.setBounds(Constants.center(300,panel),250,300,30);
        passwordField.setVisible(true);
        passwordField.setBorder(Constants.EMPTY_BORDER);
        panel.add(passwordField);

        errorLabel=new JLabel("Username doesn't exist!");
        errorLabel.setFont(Constants.SMALL);
        errorLabel.setForeground(Constants.RED);
        errorLabel.setBounds(Constants.center(300,panel),305,300,20);
        errorLabel.setVisible(false);
        panel.add(errorLabel);

        line2=new JPanel();
        line2.setBackground(Constants.GRAY);
        line2.setBounds(Constants.center(300,panel),280,300,1);
        panel.add(line2);

        login=new JButton("Login");
        login.setForeground(Color.WHITE);
        login.setBackground(Constants.GREEN);
        login.setFont(Constants.PLAIN);
        login.setBounds(Constants.center(150,panel),355,150,35);
        login.setBorder(Constants.EMPTY_BORDER);
        panel.add(login);

        JLabel or=new JLabel("or");
        or.setFont(Constants.PLAIN);
        or.setForeground(Constants.GRAY);
        or.setBounds(Constants.center(or,panel),400,200,25);
        panel.add(or);

        register=new JButton("Register");
        register.setForeground(Color.WHITE);
        register.setBackground(Constants.GREEN);
        register.setFont(Constants.PLAIN);
        register.setBounds(Constants.center(150,panel),435,150,35);
        register.setBorder(Constants.EMPTY_BORDER);
        panel.add(register);

        if(isRegister){
            makeRegisterFrame();
            panel.remove(or);
        }

        revalidate();
        repaint();
    }

    public void makeRegisterFrame(){
        title.setText("Register");
        panel.remove(login);
        register.setBounds(Constants.center(150,panel),355,150,35);
        this.setSize(WIDTH,460);
    }

    public void colorLines(String message){
        if(message!=null&&message.length()>0){
            errorLabel.setText(message);
            errorLabel.setVisible(true);
            if(message.contains("sername")){
                line1.setBackground(Constants.RED);
                line2.setBackground(Constants.RED);
            }
            if(message.contains("assword")){
                line1.setBackground(Constants.GRAY);
                line2.setBackground(Constants.RED);
            }
        }
        else{
            errorLabel.setVisible(false);
            line1.setBackground(Constants.GREEN);
            line2.setBackground(Constants.GREEN);
        }

        revalidate();
        repaint();
    }

    public void refresh(){
        passwordField.setText("");
        usernameField.setText("");
        line1.setBackground(Constants.GRAY);
        line2.setBackground(Constants.GRAY);
    }


    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return String.valueOf(passwordField.getPassword());
    }

    public JButton getLogin() {
        return login;
    }

    public JButton getRegister() {
        return register;
    }
}
