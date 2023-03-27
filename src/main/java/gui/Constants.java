package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Constants {
    public static final Color BACKGROUND=new Color(255,255,255);
    public static final Color GRAY=new Color(180,180,180);//new Color(163,184,204)
    public static final Color GREEN=new Color(76,188,143);
    public static final Color RED=Color.RED;
    public static final Border EMPTY_BORDER= BorderFactory.createEmptyBorder();
    public static final Font TITLE=new Font("ITC Avant Garde Gothic", Font.PLAIN, 40);
    public static final Font PLAIN=new Font("ITC Avant Garde Gothic", Font.PLAIN, 20);
    public static final Font SMALL=new Font("ITC Avant Garde Gothic", Font.PLAIN, 15);

    public static int center(Component component,Component container){
        return (container.getWidth()-(int)component.getPreferredSize().getWidth())/2;
    }
    public static int center(int width,Component container){
        return (container.getWidth()-width)/2;
    }
    public static int center(int width,int container){
        return (container-width)/2;
    }
}
