package supermarket;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class welcomeinf {
	static synchronized void go(String m, String n, String name, String nima,
			String name2, JFrame jf, JComboBox<String> go, JButton jb_1,
			String name3) {
		jb_1.addActionListener(new ActionListener() { // 进入方法

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根

				if (go.getSelectedItem() == "管理员登陆") {
					employeeGUI.fruit(m, n, name, nima, name2, name3);
					jf.dispose();
					System.out.println(name3 + name2);
				}
				if (go.getSelectedItem() == "游客登录") {
					playerGUI.buy(m, n, name, nima, name2, name3);
					jf.dispose();
				}

			}
		});
	}

	static void choose_employee(String m, String n, String name, String nima,
			String name2, JFrame jf, JButton jb_1, JRadioButton jr1,
			JRadioButton jr2, JRadioButton jr3, Thread a, Thread b, Thread c) {
		jb_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (jr1.isSelected()) { // 执行员工1

					try {
						a.run();

						// 复活员工
						Class.forName(m);
						Connection conn = DriverManager.getConnection(n, name,
								nima);
						PreparedStatement pre = conn
								.prepareStatement("update men set live = ? where name = ? and department = ?");
						pre.setObject(1, 1);
						pre.setObject(2, "员工1");
						pre.setObject(3, name2);
						pre.executeUpdate();
						pre.close();
						conn.close();

					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				if (jr2.isSelected()) {// 执行员工2
					try {
						b.run();
						// 复活员工
						Class.forName(m);
						Connection conn = DriverManager.getConnection(n, name,
								nima);
						PreparedStatement pre = conn
								.prepareStatement("update men set live = ? where name = ? and department = ?");
						pre.setObject(1, 1);
						pre.setObject(2, "员工2");
						pre.setObject(3, name2);
						pre.executeUpdate();
						pre.close();
						conn.close();

					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

				}
				if (jr3.isSelected()) { // 执行员工3
					try {
						c.run();
						// 复活员工
						Class.forName(m);
						Connection conn = DriverManager.getConnection(n, name,
								nima);
						PreparedStatement pre = conn
								.prepareStatement("update men set live = ? where name = ? and department = ?");
						pre.setObject(1, 1);
						pre.setObject(2, "员工3");
						pre.setObject(3, name2);
						pre.executeUpdate();
						pre.close();
						conn.close();

					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

				}
				if (jr3.isSelected() == false && jr2.isSelected() == false
						&& jr1.isSelected() == false) { // 没选按钮错误提示
					// 导入欢迎图片
					JLabel jl2111 = new JLabel();
					ImageIcon icon11 = new ImageIcon("fbi.jpg");
					// 设置图片大小
					Image im11 = icon11.getImage();
					im11 = im11
							.getScaledInstance(800, 450, Image.SCALE_DEFAULT);
					icon11.setImage(im11);
					jl2111.setIcon(icon11);
					jl2111.setBounds(0, 0, 800, 450);

					JFrame dg = new JFrame("盈亏记录");
					dg.setUndecorated(true);
					dg.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
					dg.setBounds(400, 400, 800, 450);
					JPanel pl = new JPanel();
					pl.setLayout(null);
					JTextField k = new JTextField("请选择店员");
					k.setBounds(320, 200, 150, 50);
					k.setEditable(false);
					JButton jbn = new JButton("确定");
					jbn.setBounds(320, 300, 150, 50);
					jf.dispose();
					jbn.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {

							// f.dispose();
							dg.dispose();
							// dia.dispose();
							// fw.setText("1");
							// playerGUI.buy(m, n, name, nima,name2,name3);
							welcomeGUI.bbq(m, n, name, nima, name2);
							// jf.setVisible(false);
						}
					});
					pl.add(k);
					pl.add(jbn);
					pl.add(jl2111);

					dg.add(pl);
					dg.setVisible(true);

				}

			}
		});
	}

	static void moneyis0(String m, String n, String name, String nima, JFrame jf) {
		jf.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void windowClosing(WindowEvent arg0) {

			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				try {
					Class.forName(m);

					// System.exit(0); //关闭多线程
				} catch (ClassNotFoundException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO 自动生成的方法存根

			}
		});
	}

}
