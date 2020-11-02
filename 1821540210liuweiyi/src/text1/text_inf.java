package text1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class text_inf {
    public static void main(String[] args) {
        JFrame jf2 =new JFrame();
        jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf2.setBounds(100,300,500,700);

        JPanel panel2 =new JPanel();
        panel2.setLayout(null);

        JTextArea area2 =new JTextArea();
        JScrollPane jsp1 = new JScrollPane();
        jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jsp1.setViewportView(area2);
        jsp1.setBounds(50,50,400,300);
        panel2.add(jsp1);



        jf2.add(panel2);
        jf2.setVisible(true);
    }



}
