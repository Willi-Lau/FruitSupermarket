package task2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.io.*;
import java.net.*;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;

public class TCPServer extends JFrame {                       //服务器窗体类
    private static final long serialVersionUID = 1L;
    private JPanel panUp = new JPanel();                       //上方面板
    private JLabel lblLocalPort = new JLabel("本机服务器监听端口:");
    private JTextField tfLocalPort = new JTextField("8888",4); //预设端口8888
    private JButton butStart = new JButton("启动服务器");
    private JPanel panMid = new JPanel(new BorderLayout());    //中间面板
    private TextArea taMsg = new TextArea();                   //监听消息文本区
    private JList<String> lstUsers = new JList<String>();      //在线用户列表框
    private JScrollPane spDown = new JScrollPane(lstUsers);    //下方滚动窗格
    private int localPort;                                     //本机端口
    private ServerSocket ss;                                   //服务器套接字
    private Vector<Client> clients = new Vector<Client>();     //在线客户端集合
    private Vector<String> clientNames = new Vector<String>(); //在线客户名集

    public TCPServer(){                                        //构造方法
        this.setTitle("TCP协议一对多群聊服务器");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 320, 300);
        init();                                                //调用初始化方法
        this.setVisible(true);
    }

    private void init() {                                     //初始化方法
        panUp.add(lblLocalPort);
        panUp.add(tfLocalPort);
        panUp.add(butStart);
        this.add(panUp, BorderLayout.NORTH);
        panMid.setBorder(new TitledBorder("监听消息"));     //中间面板设带标题边界
        taMsg.setEditable(false);
        panMid.add(taMsg);
        this.add(panMid, BorderLayout.CENTER);
        lstUsers.setVisibleRowCount(4);
        spDown.setBorder(new TitledBorder("在线用户"));    //下方滚动窗格设标题
        this.add(spDown, BorderLayout.SOUTH);
        butStart.addActionListener(new startServerHandler());
    }

    //“启动服务器”按钮的动作事件监听处理类（私有内部类）：
    private class startServerHandler implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            try {
                localPort = Integer.parseInt(tfLocalPort.getText());
                ss = new ServerSocket(localPort);    //创建本机服务器套接字对象
                Thread acptThrd=new Thread(new AcceptRunnable());
                //创建监听、接受客户端连接请求的线程
                acptThrd.start();                         //启动线程
                taMsg.append("**** 服务器（端口"+localPort+"）已启动 ****\n");
                butStart.setEnabled(false);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                        "建立服务器套接字出现异常！\n(例如端口已使用，可更换端口重试。)");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "异常：\n"+e);
            }
        }
    }

    //接受客户端连接请求的线程关联类（私有内部类）
    private class AcceptRunnable implements Runnable{
        public void run() {                              //线程运行方法
            while(true) {                                //连续不断
                try {                                   //尝试
                    Socket socket = ss.accept();        //接受连接客户端套接字
                    Client client = new Client(socket); //创建客户对象
                    taMsg.append("——客户【"+ client.nickname +"】加入……\n");
                    Thread clientThread = new Thread(client); //创建客户线程
                    clientThread.start();               //启动线程
                    clients.add(client);                //添加客户端对象到集合
                    updateUsers();                      //调用更新在线用户方法
                } catch (IOException e) {
                    taMsg.append("异常：接受客户端不成功！\n");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "异常：\n"+e);
                }
            }
        }
    }

    public void updateUsers(){                           //更新用户表方法
        clientNames.removeAllElements();
        StringBuffer allname=new StringBuffer();        //存放所有竖线分隔的客户
        for(Client client:clients){
            clientNames.add(0, client.nickname);
            allname.insert(0, "|"+client.nickname);
        }
        for(Client client:clients){                //把所有在线客户名发到各客户端
            client.ps.println(allname);
        }
        spDown.setBorder(new TitledBorder("在线用户("+
                clientNames.size()+"个)"));           //下方面板标题更新在线用户数
        lstUsers.setListData(clientNames);               //更新在线用户列表框
    }

    //服务器端用来存放客户机端对象的客户类（私有内部类、线程关联类）：
    private class Client implements Runnable {
        private Socket socket;                           //客户端套接字
        private BufferedReader br;                       //输入缓冲流
        private PrintStream ps;                          //数据输出流
        private String nickname;                         //客户名（昵称）

        public Client(Socket socket) throws IOException{ //构造方法
            this.socket = socket;
            InputStream is = socket.getInputStream();    //获取套接字输入流
            br = new BufferedReader(new InputStreamReader(is));//构建缓冲输入流
            OutputStream os = socket.getOutputStream();  //获取套接字输出流
            ps = new PrintStream(os);                    //构建PrintStream流
            nickname = br.readLine();                    //获取客户名
            for(Client c: clients){                      //把消息发给所有客户端
                c.ps.println("——客户【"+nickname+"】加入……");
            }
        }

        public void run() {                              //客户类线程运行方法
            try{
                while(true){
                    String usermsg = br.readLine();    //读当前客户端发来消息
                    if(usermsg!=null && usermsg.length()>0){  //如果有消息
                        for(Client c: clients){       //把消息发给所有客户端
                            c.ps.println(usermsg);
                        }
                        if(usermsg.startsWith("……")){ //若是退出消息
                            taMsg.append(usermsg+"\n");
                            break;                     //终止当前线程运行
                        }
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "异常：\n"+e);
            } finally {
                try {
                    clients.remove(this);              //移除当前已退出客户对象
                    updateUsers();                     //调用更新在线用户方法
                    if(br!=null) br.close();           //关闭输入流
                    if(ps!=null) ps.close();           //关闭输出流
                    if(socket!=null && !socket.isClosed()){
                        socket.close();               //关闭套接字
                    }
                    socket = null;
                } catch (IOException e) { }
            }
        }
    }

    public static void main(String[] args) {             //主方法
        new TCPServer();
    }
}
