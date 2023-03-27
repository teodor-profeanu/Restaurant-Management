package gui;

import business.MenuItem;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.util.List;

public class AdminFrame extends JFrame {

    public static final int WIDTH=1200;
    public static final int HEIGHT=665;

    private JLabel title;
    private JPanel panel;

    private JButton importProducts;
    private JButton add;
    private JButton delete;
    private JButton modify;
    private JButton compose;
    private JButton report;
    private JButton save;
    private JScrollPane scrollPane;
    private JList list;

    public AdminFrame(){
        getContentPane().setBackground(Constants.BACKGROUND);

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

        title=new JLabel("Administrator");
        title.setFont(Constants.TITLE);
        title.setBounds(50,40,300,50);
        panel.add(title);

        importProducts=new JButton("Import products");
        importProducts.setForeground(Color.WHITE);
        importProducts.setBackground(Constants.GREEN);
        importProducts.setFont(Constants.PLAIN);
        importProducts.setBounds(50+Constants.center(200,(int)title.getPreferredSize().getWidth()),130,200,35);
        importProducts.setBorder(Constants.EMPTY_BORDER);
        panel.add(importProducts);

        add=new JButton("Add item");
        add.setForeground(Color.WHITE);
        add.setBackground(Constants.GREEN);
        add.setFont(Constants.PLAIN);
        add.setBounds(50+Constants.center(200,(int)title.getPreferredSize().getWidth()),200,200,35);
        add.setBorder(Constants.EMPTY_BORDER);
        panel.add(add);

        modify=new JButton("Modify item");
        modify.setForeground(Color.WHITE);
        modify.setBackground(Constants.GREEN);
        modify.setFont(Constants.PLAIN);
        modify.setBounds(50+Constants.center(200,(int)title.getPreferredSize().getWidth()),270,200,35);
        modify.setBorder(Constants.EMPTY_BORDER);
        panel.add(modify);

        delete=new JButton("Delete item");
        delete.setForeground(Color.WHITE);
        delete.setBackground(Constants.GREEN);
        delete.setFont(Constants.PLAIN);
        delete.setBounds(50+Constants.center(200,(int)title.getPreferredSize().getWidth()),340,200,35);
        delete.setBorder(Constants.EMPTY_BORDER);
        panel.add(delete);

        compose=new JButton("Compose menu");
        compose.setForeground(Color.WHITE);
        compose.setBackground(Constants.GREEN);
        compose.setFont(Constants.PLAIN);
        compose.setBounds(50+Constants.center(200,(int)title.getPreferredSize().getWidth()),410,200,35);
        compose.setBorder(Constants.EMPTY_BORDER);
        panel.add(compose);

        report=new JButton("Generate report");
        report.setForeground(Color.WHITE);
        report.setBackground(Constants.GREEN);
        report.setFont(Constants.PLAIN);
        report.setBounds(50+Constants.center(200,(int)title.getPreferredSize().getWidth()),480,200,35);
        report.setBorder(Constants.EMPTY_BORDER);
        panel.add(report);

        save=new JButton("Save changes");
        save.setForeground(Color.WHITE);
        save.setBackground(Constants.GREEN);
        save.setFont(Constants.PLAIN);
        save.setBounds(50+Constants.center(200,(int)title.getPreferredSize().getWidth()),550,200,35);
        save.setBorder(Constants.EMPTY_BORDER);
        panel.add(save);

        JPanel line=new JPanel();
        line.setBackground(Constants.GRAY);
        line.setBounds(100+(int)title.getPreferredSize().getWidth(),50,1,540);
        panel.add(line);

        scrollPane=new JScrollPane();
        scrollPane.setBounds(150+(int)title.getPreferredSize().getWidth(),130,WIDTH-200-(int)title.getPreferredSize().getWidth(),460);
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

        JLabel productsTitle=new JLabel("Menu Items");
        productsTitle.setFont(Constants.TITLE);
        productsTitle.setBounds(100+(int)title.getPreferredSize().getWidth()+Constants.center((int)title.getPreferredSize().getWidth(),(WIDTH-100-(int)title.getPreferredSize().getWidth())),40,300,50);
        panel.add(productsTitle);

        revalidate();
        repaint();
    }

    public void updateList(List<MenuItem> menuItems){
        if(menuItems==null||menuItems.size()==0){
            JPanel empty=new JPanel();
            empty.setBackground(Constants.BACKGROUND);
            empty.setBounds(0,0,WIDTH-200-(int)title.getPreferredSize().getWidth(),460);
            empty.setLayout(null);
            JLabel noItems=new JLabel("No items found");
            noItems.setFont(Constants.PLAIN);
            noItems.setBounds(Constants.center((int)noItems.getPreferredSize().getWidth(),empty)-10,150,300,50);
            empty.add(noItems);
            scrollPane.setViewportView(empty);
            return;
        }
        JList list=new JList(menuItems.toArray());
        list.setFont(Constants.SMALL);
        list.setBounds(0,0,WIDTH-200-(int)title.getPreferredSize().getWidth(),460);
        scrollPane.setViewportView(list);
        this.list=list;

    }

    public JButton getImportProducts() {
        return importProducts;
    }

    public JButton getAdd() {
        return add;
    }

    public JButton getDelete() {
        return delete;
    }

    public JButton getModify() {
        return modify;
    }

    public JButton getCompose() {
        return compose;
    }

    public JButton getReport() {
        return report;
    }

    public JButton getSave() {
        return save;
    }

    public JList getList() {
        return list;
    }
}
