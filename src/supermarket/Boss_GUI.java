package supermarket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Calendar;
import java.util.TimeZone;

public class Boss_GUI {
    volatile int live1 = 0;



     static void boss(String m, String n, String name, String nima, String name2, String name3) {


        JFrame jf =new JFrame("欢迎进入老板登陆界面");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setBounds(100,100,600,500);

        //中间体
        JPanel panel =new JPanel();
        panel.setLayout(null);

        //用户名
        JLabel label1 =new JLabel("登陆名字");
        label1.setBounds(40,100,100,40);
        panel.add(label1);
        JTextField text1 =new JTextField(10);
        text1.setBounds(160,100,300,40);
        panel.add(text1);
        //密码
        JLabel label2 =new JLabel("登陆密码");
        label2.setBounds(40,200,100,40);
        panel.add(label2);
        JPasswordField text2 =new JPasswordField();
        text2.setBounds(160,200,300,40);
        panel.add(text2);
        //设置密码
        String mima = "13579";
        //确定按钮
        JButton jb1 =new JButton("确定");
        jb1.setBounds(260,300,120,40);
        panel.add(jb1);
        //返回按钮

        JButton jb3 =new JButton("返回AJ界面");
        jb3.setBounds(260,350,120,40);
        panel.add(jb3);
        int live1 = boss_inf.AJ_BACK(m, n, name, nima, name2, jf, jb3);
         // 导入欢迎图片
        JLabel jl2111 = new JLabel();
        ImageIcon icon11 = new ImageIcon("abc.jpg");
        // 设置图片大小
        Image im11 = icon11.getImage();
        im11 = im11.getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        icon11.setImage(im11);
        jl2111.setIcon(icon11);
        jl2111.setBounds(0, 0, 600, 500);
        panel.add(jl2111);
        //跳转
        boss_inf.dump(m, n, name, nima, jf, text2, jb1, live1,name2,name3);


        jf.add(panel);
        jf.setVisible(true);
    }




}
