package gui;

import business.DeliveryService;
import business.MenuItem;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.util.List;

public class EmployeeFrame extends JFrame implements Observer{

    public static final int WIDTH=1200;
    public static final int HEIGHT=665;

    private JPanel panel;
    private JButton orderDone;
    private JList list;
    private JScrollPane scrollPane;
    private DeliveryService deliveryService;

    public EmployeeFrame(DeliveryService deliveryService){
        this.deliveryService=deliveryService;
        getContentPane().setBackground(Constants.BACKGROUND);

        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(WIDTH,HEIGHT);
        this.setVisible(false);
        this.setResizable(false);
        this.setLayout(null);
        this.setResizable(false);
        panel=new JPanel();
        panel.setBackground(Constants.BACKGROUND);
        panel.setBounds(0,0,WIDTH,HEIGHT);
        panel.setLayout(null);
        this.setContentPane(panel);

        JLabel title=new JLabel("Employee");
        title.setFont(Constants.TITLE);
        title.setBounds(300+Constants.center((int)title.getPreferredSize().getWidth(),900),40,300,50);
        panel.add(title);

        scrollPane=new JScrollPane();
        scrollPane.setBounds(300+Constants.center(800,900),120,800,HEIGHT-130-25-50);
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

        JPanel line=new JPanel();
        line.setBackground(Constants.GRAY);
        line.setBounds(300,40,1,540);
        panel.add(line);

        orderDone=new JButton("Order done");
        orderDone.setForeground(Color.WHITE);
        orderDone.setBackground(Constants.GREEN);
        orderDone.setFont(Constants.PLAIN);
        orderDone.setBounds(50,290,200,35);
        orderDone.setBorder(Constants.EMPTY_BORDER);
        panel.add(orderDone);

        revalidate();
        repaint();
    }

    @Override
    public void update(){
        List<MenuItem> menuItems=deliveryService.getCurrentOrders();
        if(menuItems==null||menuItems.size()==0){
            JPanel empty=new JPanel();
            empty.setBackground(Constants.BACKGROUND);
            empty.setBounds(0,0,800,HEIGHT-130-25-50);
            empty.setLayout(null);
            JLabel noItems=new JLabel("No new orders");
            noItems.setFont(Constants.PLAIN);
            noItems.setBounds(Constants.center((int)noItems.getPreferredSize().getWidth(),empty),150,300,50);
            empty.add(noItems);
            scrollPane.setViewportView(empty);
            return;
        }
        JList list=new JList(menuItems.toArray());
        list.setFont(Constants.SMALL);
        list.setBounds(0,0,800,HEIGHT-130-25-50);
        scrollPane.setViewportView(list);
        this.list=list;
        revalidate();
        repaint();
    }

    public JList getList() {
        return list;
    }

    public JButton getOrderDone() {
        return orderDone;
    }


}
