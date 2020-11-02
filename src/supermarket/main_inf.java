package supermarket;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class main_inf {

	static void die_employee(String m, String n, String name, String nima)
			throws ClassNotFoundException, SQLException {
		Class.forName(m);
		Connection conn = DriverManager.getConnection(n, name, nima);
		PreparedStatement pre = conn
				.prepareStatement("update men set live = ?, money = ?");
		pre.setObject(1, 0);
		pre.setObject(2, 0);

		pre.executeUpdate();
		pre.close();
		conn.close();
	}

	static void a(String m, String n, String name, String nima)
			throws ClassNotFoundException, SQLException {
		Class.forName(m);
		Connection conn2 = DriverManager.getConnection(n, name, nima);

		PreparedStatement pre2 = conn2
				.prepareStatement("update  money1 set money = 0 where op = ?");
		pre2.setObject(1, "1");

		PreparedStatement pre5 = conn2
				.prepareStatement("update  employee set money = ? , live = ? ");
		pre5.setObject(1, "0");
		pre5.setObject(2, 0);

		pre5.executeUpdate();
		pre5.close();

		pre2.executeUpdate();
		pre2.close();

		conn2.close();
		a sja1 = new a(m, n, name, nima);
		b sjb1 = new b(m, n, name, nima);
		c sjc1 = new c(m, n, name, nima);

		// 导入欢迎图片
		JLabel jl2111 = new JLabel();
		ImageIcon icon11 = new ImageIcon("w.jpg");
		// 设置图片大小
		Image im11 = icon11.getImage();
		im11 = im11.getScaledInstance(500, 1000, Image.SCALE_DEFAULT);
		icon11.setImage(im11);
		jl2111.setIcon(icon11);
		jl2111.setBounds(0, 0, 500, 1000);

		JFrame jf = new JFrame("选择界面");
		jf.setBounds(500, 100, 500, 1000);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(null);
       jf.setResizable(false);
		JButton jb1 = new JButton("开启一个店");
		jb1.setBounds(50, 200, 100, 30);
		panel.add(jb1);

		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				ExecutorService pool = Executors.newCachedThreadPool(); // 线程池
				pool.submit(sja1);

				pool.shutdown(); // 关闭池子
				jf.dispose();

			}
		});

		JButton jb2 = new JButton("开启两个店");
		jb2.setBounds(200, 200, 100, 30);
		panel.add(jb2);

		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				ExecutorService pool = Executors.newCachedThreadPool(); // 线程池
				pool.submit(sjb1);
				pool.submit(sja1);

				pool.shutdown(); // 关闭池子
				jf.dispose();
			}
		});

		JButton jb3 = new JButton("开启三个店");
		jb3.setBounds(350, 200, 100, 30);
		panel.add(jb3);
		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				ExecutorService pool = Executors.newCachedThreadPool(); // 线程池
				pool.submit(sjb1);
				pool.submit(sja1);
				pool.submit(sjc1);
				pool.shutdown(); // 关闭池子
				jf.dispose();
			}
		});
		panel.add(jl2111);
		jf.add(panel);
		jf.setVisible(true);
	}

}

class a implements Runnable {

	// 数据访问层基本信息
	String m = ""; // 建立连接基本信息
	String n = ""; // SQL连接具体信息
	String name = ""; // SQL姓名
	String nima = ""; // SQL密码

	public a(String m1, String n1, String name1, String nima1) {
		m = m1;
		n = n1;
		name = name1;
		nima = nima1;
	}

	@Override
	public void run() {

		Thread.currentThread().setName("分店1");
		String name2 = Thread.currentThread().getName();

		try { // 复活
			Class.forName(m);
			Connection conn = DriverManager.getConnection(n, name, nima);
			PreparedStatement pre = conn
					.prepareStatement("update employee set live = ? where name = ?");
			pre.setObject(1, 1);
			pre.setObject(2, "分店1");
			pre.executeUpdate();
			pre.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		abcde(m, n, name, nima, name2);
	}

	private static synchronized void abcde(String m, String n, String name,
			String nima, String name2) { // 多线程锁
		SwingUtilities.invokeLater(() -> welcomeGUI
				.bbq(m, n, name, nima, name2)); // lambda Swing多线程

	}

}

class b implements Runnable {

	// 数据访问层基本信息
	String m = ""; // 建立连接基本信息
	String n = ""; // SQL连接具体信息
	String name = ""; // SQL姓名
	String nima = ""; // SQL密码

	public b(String m1, String n1, String name1, String nima1) {
		m = m1;
		n = n1;
		name = name1;
		nima = nima1;
	}

	@Override
	public void run() {

		Thread.currentThread().setName("分店2");
		String name2 = Thread.currentThread().getName();

		try { // 复活
			Class.forName(m);
			Connection conn = DriverManager.getConnection(n, name, nima);
			PreparedStatement pre = conn
					.prepareStatement("update employee set live = ? where name = ?");
			pre.setObject(1, 1);
			pre.setObject(2, "分店2");
			pre.executeUpdate();
			pre.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		abcde(m, n, name, nima, name2);
	}

	private static synchronized void abcde(String m, String n, String name,
			String nima, String name2) { // 多线程锁
		SwingUtilities.invokeLater(() -> welcomeGUI
				.bbq(m, n, name, nima, name2)); // lambda Swing多线程

	}

}

class c implements Runnable {

	// 数据访问层基本信息
	String m = ""; // 建立连接基本信息
	String n = ""; // SQL连接具体信息
	String name = ""; // SQL姓名
	String nima = ""; // SQL密码

	public c(String m1, String n1, String name1, String nima1) {
		m = m1;
		n = n1;
		name = name1;
		nima = nima1;
	}

	@Override
	public void run() {

		Thread.currentThread().setName("分店3");
		String name2 = Thread.currentThread().getName();

		try { // 复活
			Class.forName(m);
			Connection conn = DriverManager.getConnection(n, name, nima);
			PreparedStatement pre = conn
					.prepareStatement("update employee set live = ? where name = ?");
			pre.setObject(1, 1);
			pre.setObject(2, "分店3");
			pre.executeUpdate();
			pre.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		abcde(m, n, name, nima, name2);
	}

	private static synchronized void abcde(String m, String n, String name,
			String nima, String name2) { // 多线程锁
		SwingUtilities.invokeLater(() -> welcomeGUI
				.bbq(m, n, name, nima, name2)); // lambda Swing多线程

	}

}