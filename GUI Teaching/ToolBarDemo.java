/*
 * ICS4U1
 *
 * 
 * GUI Teaching
 * JMenu
 * Very interesting program!!!
 * */
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarDemo extends JPanel implements ActionListener {
    protected JTextArea textArea;

    public ToolBarDemo() {
        super(new BorderLayout());
        JToolBar toolBar = new JToolBar("");
        addButtons(toolBar);
        textArea = new JTextArea(5, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        setPreferredSize(new Dimension(800, 500));
        add(toolBar, BorderLayout.PAGE_START);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void addButtons(JToolBar toolBar) {
        JButton button = null;

        //JButton
        button = new JButton("  Previous ");
        button.setToolTipText("This is a previous toolbar button");
        button.addActionListener(this);
        toolBar.add(button);
        
        //JButton
        button = new JButton("    Up    ");
        button.setToolTipText("This is an up toolbar button");
        button.addActionListener(this);
        toolBar.add(button);

        //JButton
        button = new JButton("   Next   ");
        button.setToolTipText("This is a forward toolbar button");
        button.addActionListener(this);
        toolBar.add(button);

        //separator
        toolBar.addSeparator();

        //JButton
        button = new JButton("YUM YUM YUM");
        button.setToolTipText("Eat");
        button.addActionListener(this);
        toolBar.add(button);
        
        JTextField textField = new JTextField("A text field");
        textField.setColumns(10);
        textField.addActionListener(this);
        toolBar.add(textField);
    }

    public void actionPerformed(ActionEvent e) {
      String text = "";
        try{
          JButton but = (JButton)(e.getSource());
          text = but.getText();
        }catch(Exception e2)
        {
        }
        String out = "";
        
        if (text.equals("  Previous ")) {
            out = "Go to the previous one";
        } else if (text.equals("    Up    ")) {
            out = "Go to the one up above";
        } else if (text.equals("   Next   ")) {
            out = "Go to the next one";
        } else if (text.equals("YUM YUM YUM")) {
            out = "food is yummy.";
        } else {
            JTextField tf = (JTextField)e.getSource();
            out = tf.getText();
            tf.setText("");
            out = "The following text was entered: " + out;
        }
        textArea.append(out + "\n");
    }


    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Exciting ToolBar Demo!!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ToolBarDemo());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createAndShowGUI();
    }
}