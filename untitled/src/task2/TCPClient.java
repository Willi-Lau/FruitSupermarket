package task2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class TCPClient extends JFrame {                         //客户机窗体类
    private static final long serialVersionUID = 2L;
    private JPanel panUp = new JPanel();                        //上方面板
    private JLabel labServerIp = new JLabel("服务器IP:");
    private JTextField tfServerIp = new JTextField("127.0.0.1"); //预置IP
    private JLabel labServerPort = new JLabel("端口:");
    private JTextField tfServerPort = new JTextField("8888"); //预置端口
    private JLabel labNickname = new JLabel("本人昵称:");
    private JTextField tfNickname = new JTextField("A",4);    //预置客户昵称
    private JButton butLink = new JButton("连接服务器");
    private JPanel panMid = new JPanel(new BorderLayout());    //中间面板
    private JPanel panMidLeft = new JPanel(new BorderLayout());//消息区面板
    private TextArea taMsg = new TextArea();                   //消息文本区
    private JList<String> lstUsers = new JList<String>();      //在线用户列表框
    private JScrollPane spUsers = new JScrollPane(lstUsers);   //滚动窗格
    private JPanel panDown = new JPanel();                     //下方面板
    //private JLabel labSend = new JLabel("消息(按回车发送):");
    private JTextField tfSendMsg = new JTextField(24);       //发送消息文本框
    private JButton butSend = new JButton("发送");
    private JButton butCut = new JButton("断开连接");

    private InetAddress serverIp;                            //服务器IP地址
    private int serverPort;                                  //服务器端口
    private String nickname;                                 //客户名（昵称）
    private Socket socket;                                   //客户端套接字
    private Thread rcvThrd;	                              //接收服务器消息线程
    private BufferedReader br;                              //输入缓冲流
    private PrintStream ps;                                 //输出流

    public TCPClient(){                                     //构造方法
        this.setTitle("TCP协议一对多聊天客户端");
        this.setBounds(500, 100, 450, 350);
        init();                                            //调用初始化方法
        this.setVisible(true);
    }

    private void init() {                                  //初始化方法
        panUp.add(labServerIp);
        panUp.add(tfServerIp);
        panUp.add(labServerPort);
        panUp.add(tfServerPort);
        panUp.add(labNickname);
        panUp.add(tfNickname);
        panUp.add(butLink);
        this.add(panUp, BorderLayout.NORTH);
        panMidLeft.setBorder(new TitledBorder("聊天——消息区"));
        taMsg.setEditable(false);
        panMidLeft.add(taMsg);
        panMid.add(panMidLeft, BorderLayout.CENTER);
        spUsers.setBorder(new TitledBorder("在线用户"));
        lstUsers.setFixedCellWidth(92);
        panMid.add(spUsers, BorderLayout.EAST);
        this.add(panMid,BorderLayout.CENTER);
        //panDown.add(labSend);
        panDown.add(tfSendMsg);
        panDown.add(butSend);
        panDown.add(butCut);
        this.add(panDown, BorderLayout.SOUTH);
        butLink.addActionListener(new linkServerHandler());
        butSend.addActionListener(new SendHandler());
        butCut.addActionListener(new CutHandler());
        this.addWindowListener(new WindowHandler());
        tfSendMsg.addActionListener(new SendHandler());
    }

    //“连接服务器”按钮的动作事件监听处理类（私有内部类）：
    private class linkServerHandler implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            linkServer();                               //调用连接服务器方法
        }
    }

    public void linkServer(){                            //连接服务器方法
        try {
            serverIp = InetAddress.getByName(tfServerIp.getText());
            serverPort = Integer.parseInt(tfServerPort.getText());
            socket = new Socket(serverIp, serverPort);  //创建客户端套接字
            InputStream is = socket.getInputStream();   //由套接字获取字节输入流
            br = new BufferedReader(new InputStreamReader(is));//构建缓冲输入流
            OutputStream os = socket.getOutputStream();  //套接字获取字节输出流
            ps = new PrintStream(os);                    //构建数据输出流
            nickname = tfNickname.getText().trim();
            ps.println(nickname);                        //发送用户名（昵称）
            rcvThrd = new Thread(new ReceiveRunnable()); //创建接收消息线程
            rcvThrd.start();                             //启动线程
            taMsg.setText("——本人【"+nickname+"】成功连接到服务器……\n");
            butLink.setEnabled(false);	                 //禁用"连接服务器"按钮
            butSend.setEnabled(true);                   //启用“发送”按钮
            butCut.setEnabled(true);                    //启用“断开连接”按钮
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "服务器IP格式有错！\n"+e);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "连接失败。\n（服务器或未启动！）\n"+e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "异常：\n"+e);
        }
    }

    //接收服务器消息的线程关联类（私有内部类）：
    private class ReceiveRunnable implements Runnable {
        public void run() {                               //线程运行方法
            try{                                          //尝试
                while(true){                             //连续不断
                    String usermsg = br.readLine();     //接收消息
                    if(usermsg.startsWith("|")){        //以"|"开头的为用户名
                        usermsg = usermsg.substring(1); //去掉前面一个"|"
                        String[] users=usermsg.split("[|]"); //获取用户数组
                        lstUsers.setListData(users);      //更新在线用户列表框
                        int n = users.length;           //在线用户数
                        spUsers.setBorder(
                                new TitledBorder("在线用户("+n+"个)"));
                    } else {
                        taMsg.append(usermsg+"\n");
                    }
                }
            } catch(Exception e){                         //捕获到异常
                taMsg.setText("——已断开连接。\n");
                lstUsers.setListData(new String[0]);         //清空所有在线用户
                spUsers.setBorder(new TitledBorder("在线用户"));
                butLink.setEnabled(true);
            }
        }
    }

//	//发送消息文本框的动作事件监听处理类（私有内部类）：
//	private class SendHandler implements ActionListener {
//		public void actionPerformed(ActionEvent ae) {
//			String msg = tfSendMsg.getText();
//			ps.println("【"+nickname+"】："+msg);         //向服务器发送消息
//			tfSendMsg.setText("");                       //清空消息文本框
//		}
//	}

    //“发送”消息按钮的动作事件监听处理类（私有内部类）：
    private class SendHandler implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            String msg = tfSendMsg.getText();
            ps.println("【"+nickname+"】："+msg);   //本客户发出的消息不直接显示，而由服务器发过来再显示在聊天区
            tfSendMsg.setText("");          //清空发送消息文本框
        }
    }


    //“断开连接”按钮的动作事件监听处理类（私有内部类）：
    private class CutHandler implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            butSend.setEnabled(false);       //禁用“发送”按钮
            butCut.setEnabled(false);        //禁用“断开连接”按钮
            cutServer();                      //调用断开连接方法
            butLink.setEnabled(true);        //启用“连接服务器”按钮
        }
    }

    //窗口关闭的动作事件监听处理类（私有内部类）：
    private class WindowHandler extends WindowAdapter {
        public void windowClosing(WindowEvent we) {
            cutServer();                                  //调用断开连接方法
            System.exit(0);                               //退出客户机程序
        }
    }

    private void cutServer(){                              //断开连接方法
        try {
            taMsg.setText("");                         //清空聊天区
            if(ps!=null) {
                ps.println("……【"+nickname+"】退出。"); //发送用户退出消息
            }
            lstUsers.setListData(new String[0]);               //清空所有在线用户
            if(br!=null) br.close();                       //关闭输入流
            if(ps!=null) ps.close();                       //关闭输出流
            if(socket!=null && !socket.isClosed()){
                socket.close();                           //关闭套接字
            }
            socket = null;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "客户端断开连接异常：\n"+e);
        } catch (Exception e) {
            return;
        }
    }

    public static void main(String[] args) {                //主方法
        new TCPClient();
    }
}

