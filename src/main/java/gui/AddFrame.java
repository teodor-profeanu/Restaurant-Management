package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddFrame extends JFrame {

    public static final int WIDTH=400;
    public static final int HEIGHT=640;


    private JTextField titleField;
    private JTextField ratingField;
    private JTextField caloriesField;
    private JTextField proteinField;
    private JTextField fatField;
    private JTextField sodiumField;
    private JTextField priceField;
    private JLabel title;
    private JPanel panel;
    ArrayList<JPanel> lines;
    private JButton add;
    private JLabel errorLabel;

    public AddFrame(boolean isModify){
        getContentPane().setBackground(Constants.BACKGROUND);
        lines=new ArrayList<>();

        //this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(WIDTH,HEIGHT);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        this.setResizable(false);
        panel=new JPanel();
        panel.setBackground(Constants.BACKGROUND);
        panel.setBounds(0,0,WIDTH,HEIGHT);
        panel.setLayout(null);
        this.setContentPane(panel);

        title=new JLabel("Add item");
        title.setFont(Constants.TITLE);
        title.setBounds(Constants.center(title,panel),40,300,50);
        panel.add(title);

        JLabel titleLabel=new JLabel("Title");
        titleLabel.setFont(Constants.PLAIN);
        titleLabel.setBounds(50,130,200,30);
        panel.add(titleLabel);

        titleField=new JTextField();
        titleField.setFont(Constants.PLAIN);
        titleField.setBounds(150,130,200,30);
        titleField.setVisible(true);
        titleField.setBorder(Constants.EMPTY_BORDER);
        panel.add(titleField);

        JPanel line1=new JPanel();
        line1.setBackground(Constants.GRAY);
        line1.setBounds(150,160,200,1);
        panel.add(line1);
        lines.add(line1);

        JLabel ratingLabel=new JLabel("Rating");
        ratingLabel.setFont(Constants.PLAIN);
        ratingLabel.setBounds(50,180,200,30);
        panel.add(ratingLabel);

        ratingField=new JTextField();
        ratingField.setFont(Constants.PLAIN);
        ratingField.setBounds(150,180,200,30);
        ratingField.setVisible(true);
        ratingField.setBorder(Constants.EMPTY_BORDER);
        panel.add(ratingField);

        JPanel line2=new JPanel();
        line2.setBackground(Constants.GRAY);
        line2.setBounds(150,210,200,2);
        panel.add(line2);
        lines.add(line2);

        JLabel caloriesLabel=new JLabel("Calories");
        caloriesLabel.setFont(Constants.PLAIN);
        caloriesLabel.setBounds(50,230,200,30);
        panel.add(caloriesLabel);

        caloriesField=new JTextField();
        caloriesField.setFont(Constants.PLAIN);
        caloriesField.setBounds(150,230,200,30);
        caloriesField.setVisible(true);
        caloriesField.setBorder(Constants.EMPTY_BORDER);
        panel.add(caloriesField);

        JPanel line3=new JPanel();
        line3.setBackground(Constants.GRAY);
        line3.setBounds(150,260,200,1);
        panel.add(line3);
        lines.add(line3);

        JLabel proteinLabel=new JLabel("Proteins");
        proteinLabel.setFont(Constants.PLAIN);
        proteinLabel.setBounds(50,280,200,30);
        panel.add(proteinLabel);

        proteinField=new JTextField();
        proteinField.setFont(Constants.PLAIN);
        proteinField.setBounds(150,280,200,30);
        proteinField.setVisible(true);
        proteinField.setBorder(Constants.EMPTY_BORDER);
        panel.add(proteinField);

        JPanel line4=new JPanel();
        line4.setBackground(Constants.GRAY);
        line4.setBounds(150,310,200,2);
        panel.add(line4);
        lines.add(line4);

        JLabel fatLabel=new JLabel("Fats");
        fatLabel.setFont(Constants.PLAIN);
        fatLabel.setBounds(50,330,200,30);
        panel.add(fatLabel);

        fatField=new JTextField();
        fatField.setFont(Constants.PLAIN);
        fatField.setBounds(150,330,200,30);
        fatField.setVisible(true);
        fatField.setBorder(Constants.EMPTY_BORDER);
        panel.add(fatField);

        JPanel line5=new JPanel();
        line5.setBackground(Constants.GRAY);
        line5.setBounds(150,360,200,1);
        panel.add(line5);
        lines.add(line5);

        JLabel sodiumLabel=new JLabel("Sodium");
        sodiumLabel.setFont(Constants.PLAIN);
        sodiumLabel.setBounds(50,380,200,30);
        panel.add(sodiumLabel);

        sodiumField=new JTextField();
        sodiumField.setFont(Constants.PLAIN);
        sodiumField.setBounds(150,380,200,30);
        sodiumField.setVisible(true);
        sodiumField.setBorder(Constants.EMPTY_BORDER);
        panel.add(sodiumField);

        JPanel line6=new JPanel();
        line6.setBackground(Constants.GRAY);
        line6.setBounds(150,410,200,2);
        panel.add(line6);
        lines.add(line6);

        JLabel priceLabel=new JLabel("Price");
        priceLabel.setFont(Constants.PLAIN);
        priceLabel.setBounds(50,430,200,30);
        panel.add(priceLabel);

        priceField=new JTextField();
        priceField.setFont(Constants.PLAIN);
        priceField.setBounds(150,430,200,30);
        priceField.setVisible(true);
        priceField.setBorder(Constants.EMPTY_BORDER);
        panel.add(priceField);

        JPanel line7=new JPanel();
        line7.setBackground(Constants.GRAY);
        line7.setBounds(150,460,200,1);
        panel.add(line7);
        lines.add(line7);

        errorLabel=new JLabel("Invalid input!");
        errorLabel.setFont(Constants.SMALL);
        errorLabel.setForeground(Constants.RED);
        errorLabel.setBounds(Constants.center(300,panel),480,300,20);
        errorLabel.setVisible(false);
        panel.add(errorLabel);

        add=new JButton("Add");
        add.setForeground(Color.WHITE);
        add.setBackground(Constants.GREEN);
        add.setFont(Constants.PLAIN);
        add.setBounds(Constants.center(150,panel),530,150,35);
        add.setBorder(Constants.EMPTY_BORDER);
        panel.add(add);

        if(isModify)
            makeModifyFrame();

        revalidate();
        repaint();
    }

    public void makeModifyFrame(){
        title.setText("Modify Item");
        title.setBounds(Constants.center((int)title.getPreferredSize().getWidth(),panel),40,300,50);
        add.setText("Modify");
    }

    public void colorLines(String message){
        for(JPanel line:lines){
            line.setBackground(Constants.GRAY);
        }
        errorLabel.setVisible(false);
        if(message==null)
            return;
        if(message.contains("title")){
            lines.get(0).setBackground(Constants.RED);
        }
        if(message.contains("rating")){
            lines.get(1).setBackground(Constants.RED);
        }
        if(message.contains("calorie")){
            lines.get(2).setBackground(Constants.RED);
        }
        if(message.contains("protein")){
            lines.get(3).setBackground(Constants.RED);
        }
        if(message.contains("fat")){
            lines.get(4).setBackground(Constants.RED);
        }
        if(message.contains("sodium")){
            lines.get(5).setBackground(Constants.RED);
        }
        if(message.contains("price")){
            lines.get(6).setBackground(Constants.RED);
        }

        errorLabel.setText(message);
        errorLabel.setVisible(true);
    }
    public void colorLines(){
        for(JPanel line:lines){
            line.setBackground(Constants.GREEN);
        }
        errorLabel.setVisible(false);

    }

    public JTextField getTitleField() {
        return titleField;
    }

    public JTextField getRatingField() {
        return ratingField;
    }

    public JTextField getCaloriesField() {
        return caloriesField;
    }

    public JTextField getProteinField() {
        return proteinField;
    }

    public JTextField getFatField() {
        return fatField;
    }

    public JTextField getSodiumField() {
        return sodiumField;
    }

    public JTextField getPriceField() {
        return priceField;
    }

    public JButton getAdd() {
        return add;
    }
}
