import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;


public class TestComboControl extends JFrame {
    
     public TestComboControl() {
         this.setSize(200, 150);
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         JTextField t = new JTextField(10);
         JComboBox box = new JComboBox();
         box.addItem(new String("S1"));
         box.addItem(new String("S2"));
        
         this.setLayout(new FlowLayout());
         add(t);
         add(box);
         box.addItemListener(new ComboCtr1(t));
         this.setVisible(true);
     }
    
     public static void main(String[] a) {
         TestComboControl tf = new TestComboControl();
     } 

}

// ItemListener


class ComboCtr1 implements ItemListener {
    
     JTextField t;
    
     public ComboCtr1(JTextField jt) {
         t = jt;
     }
    
     public void itemStateChanged(ItemEvent e) {
         if (t == null) return;
         String txt = (String)e.getItem();
         t.setText(txt);
     }

}