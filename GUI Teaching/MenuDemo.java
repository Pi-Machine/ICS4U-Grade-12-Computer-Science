/*
 * ICS4U1
 * 
 * 
 * GUI Teaching
 * JMenu
 * Very interesting program!!!
 * */

import java.awt.*;
import java.awt.event.*;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
 
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
 
public class MenuDemo implements ActionListener, ItemListener {
    JTextArea output;
    JScrollPane scrollPane;
 
    public JMenuBar createMenuBar() {
        //The Objects of the JFrame
        JMenuBar menuBar;
        JMenu menu, submenu, submenu2;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;
 
        //JMenuBar
        menuBar = new JMenuBar();
 
        //First JMenu
        menu = new JMenu("JMenu Example #1");
        menu.setMnemonic(KeyEvent.VK_E);
        menuBar.add(menu);
 
        //JMenuItem
        menuItem = new JMenuItem("Say Hello!", KeyEvent.VK_H);
        menuItem.addActionListener(this);
        menu.add(menuItem);
 
        //JMenu separator
        menu.addSeparator();
        
        //ButtonGroup for 2 JRadioButtonMenuItem
        ButtonGroup group = new ButtonGroup();
        
        //First JRadioButtonMenuItem
        rbMenuItem = new JRadioButtonMenuItem("True (T)");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_T);
        group.add(rbMenuItem);
        rbMenuItem.addActionListener(this);
        menu.add(rbMenuItem);
        
        //Second JRadioButtonMenuItem
        rbMenuItem = new JRadioButtonMenuItem("False (F)");
        rbMenuItem.setMnemonic(KeyEvent.VK_F);
        group.add(rbMenuItem);
        rbMenuItem.addActionListener(this);
        menu.add(rbMenuItem);
 
        //JMenu separator
        menu.addSeparator();
        
        //First JCheckBoxMenuItem
        cbMenuItem = new JCheckBoxMenuItem("Check this!");
        cbMenuItem.setMnemonic(KeyEvent.VK_K);
        cbMenuItem.addItemListener(this);
        menu.add(cbMenuItem); 
        
        //Second JCheckBoxMenuItem
        cbMenuItem = new JCheckBoxMenuItem("Check this too!");
        cbMenuItem.addItemListener(this);
        menu.add(cbMenuItem);
 
        //JMenu Separator
        menu.addSeparator();
        
        //Submenu
        submenu = new JMenu("This is a submenu!");
        submenu.setMnemonic(KeyEvent.VK_U);
 
        //Submenu JMenuItem
        menuItem = new JMenuItem("This is a submenu item!");
        menuItem.addActionListener(this);
        submenu.add(menuItem);
 
        //Submenu in the Submenu
        submenu2 = new JMenu("This is a submenu in the submenu!");
        menuItem.addActionListener(this);
        submenu.add(submenu2);
        menu.add(submenu);
        
        //Submenu in the Submneu JMenuItem
        menuItem = new JMenuItem("This can go on forever!");
        menuItem.addActionListener(this);
        submenu2.add(menuItem);

        //Second JMenu
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);
 
        //JMenuItem
        menuItem = new JMenuItem("New", KeyEvent.VK_N);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);
 
        //JMenuItem
        menuItem = new JMenuItem("Open...", KeyEvent.VK_O);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);
 
        //JMenuItem
        menuItem = new JMenuItem("Save As...", KeyEvent.VK_A);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        //JMenu Separator
        menu.addSeparator();
        
        //JMenuItem
        menuItem = new JMenuItem("Page Setup...", KeyEvent.VK_U);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        //JMenuItem
        menuItem = new JMenuItem("Print...", KeyEvent.VK_P);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        //JMenu Separator
        menu.addSeparator();
        
        //JMenuItem
        menuItem = new JMenuItem("Exit", KeyEvent.VK_X);
        menuItem.addActionListener(this);
        menu.add(menuItem);
 
        return menuBar;
    }
 
    public Container createContentPane() {
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
        output = new JTextArea(5, 30);
        output.setEditable(true);
        scrollPane = new JScrollPane(output);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        return contentPane;
    }
 
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem)(e.getSource());
        String s = source.getText() + "\n";
        output.append(s);
    }
 
    public void itemStateChanged(ItemEvent e) {
        JMenuItem source = (JMenuItem)(e.getSource());
        String s = source.getText() + " " + ((e.getStateChange() == ItemEvent.SELECTED) ?"selected":"unselected") + "\n";
        output.append(s);
    }
 
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("MenuDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        MenuDemo demo = new MenuDemo();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane());
 
        frame.setSize(800, 500);
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        createAndShowGUI();
    }
}