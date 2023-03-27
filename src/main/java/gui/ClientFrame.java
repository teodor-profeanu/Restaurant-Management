package gui;

import business.MenuItem;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.util.List;

public class ClientFrame extends JFrame {

    public static final int WIDTH=1200;
    public static final int HEIGHT=700;

    private JTextField keyword;
    private JTextField ratingMin;
    private JTextField ratingMax;
    private JTextField caloriesMin;
    private JTextField caloriesMax;
    private JTextField proteinMax;
    private JTextField proteinMin;
    private JTextField fatMin;
    private JTextField fatMax;
    private JTextField sodiumMin;
    private JTextField sodiumMax;
    private JTextField priceMin;
    private JTextField priceMax;
    private JPanel panel;
    private JButton search;
    private JButton order;
    private JList list;
    private JScrollPane scrollPane;
    private int idClient;

    public ClientFrame(int idClient){
        getContentPane().setBackground(Constants.BACKGROUND);
        this.idClient=idClient;

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

        JPanel line=new JPanel();
        line.setBackground(Constants.GRAY);
        line.setBounds(350,30,1,600);
        panel.add(line);

        JLabel keywordLabel=new JLabel("Keyword:");
        keywordLabel.setFont(Constants.SMALL);
        keywordLabel.setBounds(50,30,250,20);
        panel.add(keywordLabel);

        keyword=new JTextField();
        keyword.setFont(Constants.PLAIN);
        keyword.setBounds(50,50,250,30);
        keyword.setVisible(true);
        keyword.setBorder(Constants.EMPTY_BORDER);
        panel.add(keyword);

        JPanel line1=new JPanel();
        line1.setBackground(Constants.GRAY);
        line1.setBounds(50,80,250,1);
        panel.add(line1);

        JLabel ratingLabel=new JLabel("Rating between:");
        ratingLabel.setFont(Constants.SMALL);
        ratingLabel.setBounds(50,100,250,20);
        panel.add(ratingLabel);

        JLabel and1=new JLabel("and");
        and1.setFont(Constants.PLAIN);
        and1.setForeground(Constants.GRAY);
        and1.setBounds(50+Constants.center((int)and1.getPreferredSize().getWidth(),250),125,150,20);
        panel.add(and1);

        ratingMin=new JTextField();
        ratingMin.setFont(Constants.PLAIN);
        ratingMin.setBounds(50,120,(250-(int)and1.getPreferredSize().getWidth())/2-15,30);
        ratingMin.setVisible(true);
        ratingMin.setBorder(Constants.EMPTY_BORDER);
        panel.add(ratingMin);

        ratingMax=new JTextField();
        ratingMax.setFont(Constants.PLAIN);
        ratingMax.setBounds(50+(250-(int)and1.getPreferredSize().getWidth())/2+(int)and1.getPreferredSize().getWidth()+15,120,(250-(int)and1.getPreferredSize().getWidth())/2-15,30);
        ratingMax.setVisible(true);
        ratingMax.setBorder(Constants.EMPTY_BORDER);
        panel.add(ratingMax);

        JPanel line2=new JPanel();
        line2.setBackground(Constants.GRAY);
        line2.setBounds(50,150,250,2);
        panel.add(line2);

        JLabel caloriesLabel=new JLabel("Calories between:");
        caloriesLabel.setFont(Constants.SMALL);
        caloriesLabel.setBounds(50,170,250,20);
        panel.add(caloriesLabel);

        JLabel and2=new JLabel("and");
        and2.setFont(Constants.PLAIN);
        and2.setForeground(Constants.GRAY);
        and2.setBounds(50+Constants.center((int)and2.getPreferredSize().getWidth(),250),195,150,20);
        panel.add(and2);

        caloriesMin=new JTextField();
        caloriesMin.setFont(Constants.PLAIN);
        caloriesMin.setBounds(50,190,(250-(int)and1.getPreferredSize().getWidth())/2-15,30);
        caloriesMin.setVisible(true);
        caloriesMin.setBorder(Constants.EMPTY_BORDER);
        panel.add(caloriesMin);

        caloriesMax=new JTextField();
        caloriesMax.setFont(Constants.PLAIN);
        caloriesMax.setBounds(50+(250-(int)and1.getPreferredSize().getWidth())/2+(int)and1.getPreferredSize().getWidth()+15,190,(250-(int)and1.getPreferredSize().getWidth())/2-15,30);
        caloriesMax.setVisible(true);
        caloriesMax.setBorder(Constants.EMPTY_BORDER);
        panel.add(caloriesMax);

        JPanel line3=new JPanel();
        line3.setBackground(Constants.GRAY);
        line3.setBounds(50,220,250,1);
        panel.add(line3);

        JLabel proteinLabel=new JLabel("Proteins between:");
        proteinLabel.setFont(Constants.SMALL);
        proteinLabel.setBounds(50,240,250,20);
        panel.add(proteinLabel);

        JLabel and3=new JLabel("and");
        and3.setFont(Constants.PLAIN);
        and3.setForeground(Constants.GRAY);
        and3.setBounds(50+Constants.center((int)and3.getPreferredSize().getWidth(),250),265,150,20);
        panel.add(and3);

        proteinMin=new JTextField();
        proteinMin.setFont(Constants.PLAIN);
        proteinMin.setBounds(50,260,(250-(int)and1.getPreferredSize().getWidth())/2-15,30);
        proteinMin.setVisible(true);
        proteinMin.setBorder(Constants.EMPTY_BORDER);
        panel.add(proteinMin);

        proteinMax=new JTextField();
        proteinMax.setFont(Constants.PLAIN);
        proteinMax.setBounds(50+(250-(int)and1.getPreferredSize().getWidth())/2+(int)and1.getPreferredSize().getWidth()+15,260,(250-(int)and1.getPreferredSize().getWidth())/2-15,30);
        proteinMax.setVisible(true);
        proteinMax.setBorder(Constants.EMPTY_BORDER);
        panel.add(proteinMax);

        JPanel line4=new JPanel();
        line4.setBackground(Constants.GRAY);
        line4.setBounds(50,290,250,2);
        panel.add(line4);

        JLabel fatLabel=new JLabel("Fats between:");
        fatLabel.setFont(Constants.SMALL);
        fatLabel.setBounds(50,310,250,20);
        panel.add(fatLabel);

        JLabel and4=new JLabel("and");
        and4.setFont(Constants.PLAIN);
        and4.setForeground(Constants.GRAY);
        and4.setBounds(50+Constants.center((int)and4.getPreferredSize().getWidth(),250),335,150,20);
        panel.add(and4);

        fatMin=new JTextField();
        fatMin.setFont(Constants.PLAIN);
        fatMin.setBounds(50,330,(250-(int)and1.getPreferredSize().getWidth())/2-15,30);
        fatMin.setVisible(true);
        fatMin.setBorder(Constants.EMPTY_BORDER);
        panel.add(fatMin);

        fatMax=new JTextField();
        fatMax.setFont(Constants.PLAIN);
        fatMax.setBounds(50+(250-(int)and1.getPreferredSize().getWidth())/2+(int)and1.getPreferredSize().getWidth()+15,330,(250-(int)and1.getPreferredSize().getWidth())/2-15,30);
        fatMax.setVisible(true);
        fatMax.setBorder(Constants.EMPTY_BORDER);
        panel.add(fatMax);

        JPanel line5=new JPanel();
        line5.setBackground(Constants.GRAY);
        line5.setBounds(50,360,250,1);
        panel.add(line5);

        JLabel sodiumLabel=new JLabel("Sodium between:");
        sodiumLabel.setFont(Constants.SMALL);
        sodiumLabel.setBounds(50,380,250,20);
        panel.add(sodiumLabel);

        JLabel and5=new JLabel("and");
        and5.setFont(Constants.PLAIN);
        and5.setForeground(Constants.GRAY);
        and5.setBounds(50+Constants.center((int)and5.getPreferredSize().getWidth(),250),405,150,20);
        panel.add(and5);

        sodiumMin=new JTextField();
        sodiumMin.setFont(Constants.PLAIN);
        sodiumMin.setBounds(50,400,(250-(int)and1.getPreferredSize().getWidth())/2-15,30);
        sodiumMin.setVisible(true);
        sodiumMin.setBorder(Constants.EMPTY_BORDER);
        panel.add(sodiumMin);

        sodiumMax=new JTextField();
        sodiumMax.setFont(Constants.PLAIN);
        sodiumMax.setBounds(50+(250-(int)and1.getPreferredSize().getWidth())/2+(int)and1.getPreferredSize().getWidth()+15,400,(250-(int)and1.getPreferredSize().getWidth())/2-15,30);
        sodiumMax.setVisible(true);
        sodiumMax.setBorder(Constants.EMPTY_BORDER);
        panel.add(sodiumMax);

        JPanel line6=new JPanel();
        line6.setBackground(Constants.GRAY);
        line6.setBounds(50,430,250,2);
        panel.add(line6);

        JLabel priceLabel=new JLabel("Price between:");
        priceLabel.setFont(Constants.SMALL);
        priceLabel.setBounds(50,450,250,20);
        panel.add(priceLabel);

        JLabel and6=new JLabel("and");
        and6.setFont(Constants.PLAIN);
        and6.setForeground(Constants.GRAY);
        and6.setBounds(50+Constants.center((int)and6.getPreferredSize().getWidth(),250),475,150,20);
        panel.add(and6);

        priceMin=new JTextField();
        priceMin.setFont(Constants.PLAIN);
        priceMin.setBounds(50,470,(250-(int)and1.getPreferredSize().getWidth())/2-15,30);
        priceMin.setVisible(true);
        priceMin.setBorder(Constants.EMPTY_BORDER);
        panel.add(priceMin);

        priceMax=new JTextField();
        priceMax.setFont(Constants.PLAIN);
        priceMax.setBounds(50+(250-(int)and1.getPreferredSize().getWidth())/2+(int)and1.getPreferredSize().getWidth()+15,470,(250-(int)and1.getPreferredSize().getWidth())/2-15,30);
        priceMax.setVisible(true);
        priceMax.setBorder(Constants.EMPTY_BORDER);
        panel.add(priceMax);

        JPanel line7=new JPanel();
        line7.setBackground(Constants.GRAY);
        line7.setBounds(50,500,250,1);
        panel.add(line7);

        search=new JButton("Search");
        search.setForeground(Color.WHITE);
        search.setBackground(Constants.GREEN);
        search.setFont(Constants.PLAIN);
        search.setBounds(50+Constants.center(150,250),530,150,35);
        search.setBorder(Constants.EMPTY_BORDER);
        panel.add(search);

        order=new JButton("Order");
        order.setForeground(Color.WHITE);
        order.setBackground(Constants.GREEN);
        order.setFont(Constants.PLAIN);
        order.setBounds(50+Constants.center(150,250),595,150,35);
        order.setBorder(Constants.EMPTY_BORDER);
        panel.add(order);

        JLabel productsTitle=new JLabel("Menu Items");
        productsTitle.setFont(Constants.TITLE);
        productsTitle.setBounds(300+Constants.center((int)productsTitle.getPreferredSize().getWidth(),WIDTH-300),30,300,50);
        panel.add(productsTitle);

        scrollPane=new JScrollPane();
        scrollPane.setBounds(400,120,WIDTH-450,HEIGHT-120-50-25);
        scrollPane.setBorder(Constants.EMPTY_BORDER);
        scrollPane.setBackground(Constants.BACKGROUND);
        scrollPane.getHorizontalScrollBar().setBackground(Constants.BACKGROUND);
        scrollPane.getVerticalScrollBar().setBackground(Constants.BACKGROUND);
        scrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Constants.GREEN;
            }
        });
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Constants.GREEN;
            }
        });
        panel.add(scrollPane);

        revalidate();
        repaint();
    }

    public void updateList(List<MenuItem> menuItems){
        if(menuItems==null||menuItems.size()==0){
            JPanel empty=new JPanel();
            empty.setBackground(Constants.BACKGROUND);
            empty.setBounds(0,0,WIDTH-450,HEIGHT-120-50-25);
            empty.setLayout(null);
            JLabel noItems=new JLabel("No items found");
            noItems.setFont(Constants.PLAIN);
            noItems.setBounds(Constants.center((int)noItems.getPreferredSize().getWidth(),empty)-25,150,300,50);
            empty.add(noItems);
            scrollPane.setViewportView(empty);
            return;
        }
        JList list=new JList(menuItems.toArray());
        list.setFont(Constants.SMALL);
        list.setBounds(0,0,WIDTH-450,HEIGHT-120-50-25);
        scrollPane.setViewportView(list);
        this.list=list;
        revalidate();
        repaint();
    }

    public String getKeyword() {
        return keyword.getText();
    }

    public double getRatingMin() {
        try{
            return Double.parseDouble(ratingMin.getText());
        }catch (Exception exception){
            return -1;
        }
    }

    public double getRatingMax() {
        try{
            return Double.parseDouble(ratingMax.getText());
        }catch (Exception exception){
            return -1;
        }
    }

    public int getCaloriesMin() {
        try{
            return Integer.parseInt(caloriesMin.getText());
        }catch (Exception exception){
            return -1;
        }
    }

    public int getCaloriesMax() {
        try{
            return Integer.parseInt(caloriesMax.getText());
        }catch (Exception exception){
            return -1;
        }
    }

    public int getProteinMax() {
        try{
            return Integer.parseInt(proteinMax.getText());
        }catch (Exception exception){
            return -1;
        }
    }

    public int getProteinMin() {
        try{
            return Integer.parseInt(proteinMin.getText());
        }catch (Exception exception){
            return -1;
        }
    }

    public int getFatMin() {
        try{
            return Integer.parseInt(fatMin.getText());
        }catch (Exception exception){
            return -1;
        }
    }

    public int getFatMax() {
        try{
            return Integer.parseInt(fatMax.getText());
        }catch (Exception exception){
            return -1;
        }
    }

    public int getSodiumMin() {
        try{
            return Integer.parseInt(sodiumMin.getText());
        }catch (Exception exception){
            return -1;
        }
    }

    public int getSodiumMax() {
        try{
            return Integer.parseInt(sodiumMax.getText());
        }catch (Exception exception){
            return -1;
        }
    }

    public int getPriceMin() {
        try{
            return Integer.parseInt(priceMin.getText());
        }catch (Exception exception){
            return -1;
        }
    }

    public int getPriceMax() {
        try{
            return Integer.parseInt(priceMax.getText());
        }catch (Exception exception){
            return -1;
        }
    }

    public JList getList() {
        return list;
    }

    public JButton getSearch() {
        return search;
    }

    public JButton getOrder() {
        return order;
    }

    public int getIdClient() {
        return idClient;
    }
}
