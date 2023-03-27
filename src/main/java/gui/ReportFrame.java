package gui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.util.List;

public class ReportFrame extends JFrame {

    public static final int WIDTH=1100;
    public static final int HEIGHT=665;

    private JPanel panel;
    private JTextField hourMin;
    private JTextField hourMax;
    private JButton generate1;
    private JButton generate2;
    private JButton generate3;
    private JButton generate4;
    private JTextField timesOrdered;
    private JTextField timesOrderedClients;
    private JTextField valueHigher;
    private JTextField day;
    private JTextField month;
    private JTextField year;
    private JScrollPane scrollPane;
    private JList list;

    public ReportFrame(){
        getContentPane().setBackground(Constants.BACKGROUND);

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

        JLabel report1=new JLabel("Report1: Orders performed between");
        report1.setFont(Constants.PLAIN);
        report1.setBounds(50,40,500,30);
        panel.add(report1);

        hourMin=new JTextField();
        hourMin.setFont(Constants.PLAIN);
        hourMin.setBounds(65+(int)report1.getPreferredSize().getWidth(),40,50,30);
        hourMin.setVisible(true);
        hourMin.setBorder(Constants.EMPTY_BORDER);
        panel.add(hourMin);

        JLabel and=new JLabel("and");
        and.setFont(Constants.PLAIN);
        and.setBounds(130+(int)report1.getPreferredSize().getWidth(),40,(int)and.getPreferredSize().getWidth(),30);
        panel.add(and);

        hourMax=new JTextField();
        hourMax.setFont(Constants.PLAIN);
        hourMax.setBounds(130+(int)report1.getPreferredSize().getWidth()+(int)and.getPreferredSize().getWidth()+15,40,50,30);
        hourMax.setVisible(true);
        hourMax.setBorder(Constants.EMPTY_BORDER);
        panel.add(hourMax);

        JPanel line1=new JPanel();
        line1.setBackground(Constants.GRAY);
        line1.setBounds(65+(int)report1.getPreferredSize().getWidth(),70,50,2);
        panel.add(line1);

        JPanel line12=new JPanel();
        line12.setBackground(Constants.GRAY);
        line12.setBounds(185+(int)report1.getPreferredSize().getWidth(),70,50,2);
        panel.add(line12);

        generate1=new JButton("Generate");
        generate1.setForeground(Color.WHITE);
        generate1.setBackground(Constants.GREEN);
        generate1.setFont(Constants.PLAIN);
        generate1.setBounds(850,37,200,36);
        generate1.setBorder(Constants.EMPTY_BORDER);
        panel.add(generate1);

        JLabel report2=new JLabel("Report2: Products ordered more than            times");
        report2.setFont(Constants.PLAIN);
        report2.setBounds(50,90,600,30);
        panel.add(report2);

        timesOrdered=new JTextField();
        timesOrdered.setFont(Constants.PLAIN);
        timesOrdered.setBounds(65+(int)report1.getPreferredSize().getWidth(),90,50,30);
        timesOrdered.setVisible(true);
        timesOrdered.setBorder(Constants.EMPTY_BORDER);
        panel.add(timesOrdered);

        JPanel line2=new JPanel();
        line2.setBackground(Constants.GRAY);
        line2.setBounds(65+(int)report1.getPreferredSize().getWidth(),120,50,1);
        panel.add(line2);

        generate2=new JButton("Generate");
        generate2.setForeground(Color.WHITE);
        generate2.setBackground(Constants.GREEN);
        generate2.setFont(Constants.PLAIN);
        generate2.setBounds(850,87,200,36);
        generate2.setBorder(Constants.EMPTY_BORDER);
        panel.add(generate2);

        JLabel report3=new JLabel("Report3: Clients that ordered            times or more a value of            or higher");
        report3.setFont(Constants.PLAIN);
        report3.setBounds(50,140,800,30);
        panel.add(report3);

        timesOrderedClients=new JTextField();
        timesOrderedClients.setFont(Constants.PLAIN);
        timesOrderedClients.setBounds(337,140,50,30);
        timesOrderedClients.setVisible(true);
        timesOrderedClients.setBorder(Constants.EMPTY_BORDER);
        panel.add(timesOrderedClients);

        valueHigher=new JTextField();
        valueHigher.setFont(Constants.PLAIN);
        valueHigher.setBounds(637,140,50,30);
        valueHigher.setVisible(true);
        valueHigher.setBorder(Constants.EMPTY_BORDER);
        panel.add(valueHigher);

        JPanel line3=new JPanel();
        line3.setBackground(Constants.GRAY);
        line3.setBounds(337,170,50,2);
        panel.add(line3);

        JPanel line4=new JPanel();
        line4.setBackground(Constants.GRAY);
        line4.setBounds(637,170,50,2);
        panel.add(line4);

        generate3=new JButton("Generate");
        generate3.setForeground(Color.WHITE);
        generate3.setBackground(Constants.GREEN);
        generate3.setFont(Constants.PLAIN);
        generate3.setBounds(850,137,200,36);
        generate3.setBorder(Constants.EMPTY_BORDER);
        panel.add(generate3);

        JLabel report4=new JLabel("Report4: Products ordered on         /       /              ");
        report4.setFont(Constants.PLAIN);
        report4.setBounds(50,190,800,30);
        panel.add(report4);

        JPanel line5=new JPanel();
        line5.setBackground(Constants.GRAY);
        line5.setBounds(350,220,30,1);
        panel.add(line5);

        JPanel line6=new JPanel();
        line6.setBackground(Constants.GRAY);
        line6.setBounds(395,220,30,1);
        panel.add(line6);

        JPanel line7=new JPanel();
        line7.setBackground(Constants.GRAY);
        line7.setBounds(450,220,50,1);
        panel.add(line7);

        day=new JTextField();
        day.setFont(Constants.PLAIN);
        day.setBounds(350,190,30,30);
        day.setVisible(true);
        day.setBorder(Constants.EMPTY_BORDER);
        panel.add(day);

        month=new JTextField();
        month.setFont(Constants.PLAIN);
        month.setBounds(395,190,30,30);
        month.setVisible(true);
        month.setBorder(Constants.EMPTY_BORDER);
        panel.add(month);

        year=new JTextField();
        year.setFont(Constants.PLAIN);
        year.setBounds(450,190,50,30);
        year.setVisible(true);
        year.setBorder(Constants.EMPTY_BORDER);
        panel.add(year);

        generate4=new JButton("Generate");
        generate4.setForeground(Color.WHITE);
        generate4.setBackground(Constants.GREEN);
        generate4.setFont(Constants.PLAIN);
        generate4.setBounds(850,187,200,36);
        generate4.setBorder(Constants.EMPTY_BORDER);
        panel.add(generate4);

        JPanel line8=new JPanel();
        line8.setBackground(Constants.GRAY);
        line8.setBounds(50,270,1000,2);
        panel.add(line8);

        scrollPane=new JScrollPane();
        scrollPane.setBounds(50,320,1000,HEIGHT-75-320);
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

        updateList(null);
        revalidate();
        repaint();
    }

    public <T> void updateList(List<T> items){
        if(items==null||items.size()==0){
            JPanel empty=new JPanel();
            empty.setBackground(Constants.BACKGROUND);
            empty.setBounds(0,0,1000,HEIGHT-75-320);
            empty.setLayout(null);

            JLabel noItems=new JLabel("No report generated");
            noItems.setFont(Constants.PLAIN);
            noItems.setBounds(Constants.center(noItems,empty),100,300,50);
            empty.add(noItems);
            scrollPane.setViewportView(empty);
            return;
        }
        JList list=new JList(items.toArray());
        list.setFont(Constants.SMALL);
        list.setBounds(0,0,1000,HEIGHT-75-320);
        scrollPane.setViewportView(list);
        this.list=list;
        revalidate();
        repaint();
    }

    public JTextField getHourMin() {
        return hourMin;
    }

    public JTextField getHourMax() {
        return hourMax;
    }

    public JButton getGenerate1() {
        return generate1;
    }

    public JButton getGenerate2() {
        return generate2;
    }

    public JButton getGenerate3() {
        return generate3;
    }

    public JButton getGenerate4() {
        return generate4;
    }

    public JTextField getTimesOrdered() {
        return timesOrdered;
    }

    public JTextField getTimesOrderedClients() {
        return timesOrderedClients;
    }

    public JTextField getValueHigher() {
        return valueHigher;
    }

    public JTextField getDay() {
        return day;
    }

    public JTextField getMonth() {
        return month;
    }

    public JTextField getYear() {
        return year;
    }
}
