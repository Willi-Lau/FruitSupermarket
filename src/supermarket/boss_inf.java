package supermarket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Calendar;
import java.util.TimeZone;

public class boss_inf {
    //密码：开启了几个线程+日期+am（0）或pm（1）
    static void dump(String m, String n, String name, String nima, JFrame jf, JPasswordField text2, JButton jb1, int live1, String name2, String name3) {
        Calendar employeeGUI =  Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        String miss = Integer.toString(live1)+Integer.toString(employeeGUI.get(Calendar.MONTH)+1)+Integer.toString(employeeGUI.get(Calendar.DATE))+Integer.toString(employeeGUI.get(Calendar.AM_PM));
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String mima= text2.getText();
                if(mima.equals(miss)){
                    //跳转界面
                    System.out.println("正确");
                    jf.dispose();
                    JFrame jf2 =new JFrame();
                    jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    jf2.setBounds(100,300,500,700);

                    JPanel panel2 =new JPanel();
                    panel2.setLayout(null);

                    JButton jb1 = new JButton("返回");
                    jb1.setBounds(190,400,60,40);
                    panel2.add(jb1);
                    jb1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jf2.dispose();
                            //返回jf
                            Boss_GUI.boss(m,n,name,nima, name2, name3);
                        }
                    });
                    JTextArea area2 =new JTextArea();
                    JScrollPane jsp1 = new JScrollPane();
                    jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
                    jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                    jsp1.setViewportView(area2);
                    jsp1.setBounds(50,50,400,300);
                    panel2.add(jsp1);
                    // 导入欢迎图片
                    JLabel jlsb = new JLabel();
                    ImageIcon icon11 = new ImageIcon("green.jpg");
                    // 设置图片大小
                    Image im11 = icon11.getImage();
                    im11 = im11.getScaledInstance(500, 700, Image.SCALE_DEFAULT);
                    icon11.setImage(im11);
                    jlsb.setIcon(icon11);
                    jlsb.setBounds(0, 0, 500, 700);
                    panel2.add(jlsb);
                    try {
                        Class.forName(m);
                        Connection conn = DriverManager.getConnection(n, name,
                                nima);
                        PreparedStatement pre = conn
                                .prepareStatement("select   e.*,m.* from employee e ,men m where e.name = m.department order by m.department,m.name");
                        ResultSet exe = pre.executeQuery();
                        area2.append("欢迎老板到来，这是今天实时店铺员工状况"+"\r\n");
                        area2.append("店名"+"    "+"开业否"+"    "+"营业额"+"    "+"店员名"+"        "+"工作状态"+"        "+"营业额"+"\r\n");
                        while(exe.next()){
                            String string1 = exe.getString(1);
                            String string2= exe.getString(2);
                            if(string2.equals("0")){
                                string2 = "未开业";
                            }
                            else{
                                string2 = "开业";
                            }
                            String string3=exe.getString(3);
                            String string4=exe.getString(4);

                            String string6=exe.getString(6);

                            if(string6.equals("0") && string2.equals("开业")){
                                string6 = "未上班";
                            }
                            else if(string6.equals("1") && string2.equals("开业")){
                                string6= "已上班";
                            }
                            else if ( string2.equals("未开业")){
                                string6 = "放假休息中";
                            }
                            String string7=exe.getString(7);
                            area2.append(string1+"    "+string2+"    "+string3+"            "+string4+"       "+string6+"        "+string7+"\r\n");
                        }





                        pre.close();
                        conn.close();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }


                    jf2.add(panel2);
                    jf2.setVisible(true);


                }
                else{//错误提示
                    // 导入欢迎图片
                    JLabel jlsb = new JLabel();
                    ImageIcon icon11 = new ImageIcon("fbi.jpg");
                    // 设置图片大小
                    Image im11 = icon11.getImage();
                    im11 = im11.getScaledInstance(800, 450, Image.SCALE_DEFAULT);
                    icon11.setImage(im11);
                    jlsb.setIcon(icon11);
                    jlsb.setBounds(0, 0, 800, 450);

                    JFrame dg = new JFrame("非法登录");
                    dg.setUndecorated(true);
                    dg.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                    dg.setBounds(400, 400, 800, 450);
                    JPanel pl = new JPanel();
                    pl.setLayout(null);
                    JTextField k = new JTextField("非法登录");
                    k.setBounds(320, 200, 150, 50);
                    k.setEditable(false);
                    JButton jbn = new JButton("返回");
                    jbn.setBounds(320, 300, 150, 50);

                    pl.add(k);
                    pl.add(jbn);
                    pl.add(jlsb);

                    dg.add(pl);

                    jbn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //返回boss
                            Boss_GUI.boss(m,n,name,nima, name2, name3);
                            dg.dispose();
                        }
                    });

                    dg.setVisible(true);
                    jf.dispose();

















                }
            }
        });
    }
    static int AJ_BACK(String m, String n, String name, String nima, String name2, JFrame jf, JButton jb3) {
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                welcomeGUI.bbq(m,n,name,nima,name2);
            }
        });
        int live1 = 0;
        try {
            Class.forName(m);
            Connection conn11 = DriverManager.getConnection(n, name,
                    nima);
            PreparedStatement pre1 = conn11
                    .prepareStatement("Select * from employee");
            ResultSet exe1 = pre1.executeQuery();

            while (exe1.next()) {

                if(exe1.getInt(2) == 1){
                    live1 += 1;
                }}
            // 关闭流
            conn11.close();
            pre1.close();
            exe1.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return live1;
    }

}
