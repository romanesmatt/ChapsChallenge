package Application;


import javax.swing.*;
import java.awt.*;

/**
 * SideBar class contains information of
 * */
public class SideBar extends JPanel {

    //numbers shown in side bar
    public int numLevel;
    public int timeLevel;
    public int treasuresToBeCollected;

    //inventory numbers
    public int keysCollected;
    public int treasuresCollected;
    private int inventorySize =8;

    JPanel infoPanel = new JPanel();

    public SideBar() {
        displayInfo();
    }

    public void displayInfo(){
        infoPanel.setBackground(new java.awt.Color(0, 255, 0));
        GridBagConstraints gbc = new GridBagConstraints();

        //LEVEL
        JLabel level = new JLabel("Level");
        level.setFont(new Font(level.getFont().getName(), level.getFont().getStyle(), 30));
        add(level,gbc);
        //NUM OF CHIPS LEFT
        //TIMER
        //INVENTORY
    }

}
