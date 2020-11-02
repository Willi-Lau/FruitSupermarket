package supermarket;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class playerinf {

	static void write_want_buy(JTextField text1, JComboBox<String> jbox34,
			JButton jb11) {
		jb11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Object select = jbox34.getSelectedItem();
				text1.setText((String) select);
			}
		});
	}

	static void add_fruitinf_quick(String m, String n, String name,
			String nima, JComboBox<String> jbox34) {
		try {
			Class.forName(m);
			Connection conn11 = DriverManager.getConnection(n, name, nima);
			PreparedStatement pre1 = conn11
					.prepareStatement("Select * from fruit_information");
			ResultSet exe1 = pre1.executeQuery();
			while (exe1.next()) {

				String name1 = exe1.getString(2);
				jbox34.addItem(name1);
			}
			// 关闭流
			conn11.close();
			pre1.close();
			exe1.close();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	static void new_shop(String m, String n, String name, String nima,
			JButton jb_new, JTextArea area1, String name2) {
		jb_new.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 刷新屏幕显示
				area1.setText("");
				area1.append("名称         售价           库存量                 单位"
						+ "\r\n"); // 标题

				try {
					Class.forName(m);
					Connection conn11 = DriverManager.getConnection(n, name,
							nima);
					PreparedStatement pre1 = conn11
							.prepareStatement("Select * from fruit_information");
					ResultSet exe1 = pre1.executeQuery();
					while (exe1.next()) {

						String id = exe1.getString(1);
						String name = exe1.getString(2);
						int in = exe1.getInt(3);
						int out = exe1.getInt(4);
						int num1 = exe1.getInt(5);
						String unit = exe1.getString(6);
						area1.append(name + "           " + out
								+ "               " + num1
								+ "                 " + unit + "\r\n");
					}
					// 关闭流
					conn11.close();
					pre1.close();
					exe1.close();
				} catch (ClassNotFoundException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

			}
		});
	}

	static void tuichu(JFrame jf, JMenuItem item_2) {
		item_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jf.dispose();

			}
		});
	}

	static void caidan(String m, String n, String name, String nima, JFrame jf,
			JMenuItem item_1, String name2) {
		item_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jf.dispose(); // 关闭
				welcomeGUI.bbq(m, n, name, nima, name2); // 返回主界面

			}
		});
	}

	static void today_money(String m, String n, String name, String nima,
			JTextField text8, int money4) {
		try {
			Class.forName(m);
			Connection conn1 = DriverManager.getConnection(n, name, nima);
			PreparedStatement pre1 = conn1
					.prepareStatement("Select * from money1 where op = ?");
			pre1.setObject(1, "1");
			ResultSet exe = pre1.executeQuery();
			while (exe.next()) {

				money4 = exe.getInt("money");

			}
			text8.setText(Integer.toString(money4));
			exe.close();
			pre1.close();
			conn1.close();

		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	static void close_sql1(String m, String n, String name, String nima,
			JFrame jf) {
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

			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO 自动生成的方法存根

			}
		});
	}

	static void over_shop(String m, String n, String name, String nima,
			JFrame jf, JTextField text7, JButton jb5, String name2, String name3) {
		jb5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// int money4 =Integer.parseInt(text7.getText());

				JDialog dg1 = new JDialog(jf, "是否营业 ", true);
				dg1.setUndecorated(true);
				dg1.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
				dg1.setBounds(400, 400, 500, 300);

				JPanel panel5 = new JPanel();
				panel5.setLayout(null);

				JTextArea area4 = new JTextArea(5, 5);
				area4.setBounds(0, 0, 500, 150);

				JScrollPane pane2 = new JScrollPane();
				pane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

				pane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				pane2.setViewportView(area4);
				pane2.setBounds(0, 20, 500, 150);
				panel5.add(pane2);
				// 导入欢迎图片
				JLabel jl21 = new JLabel();
				ImageIcon icon = new ImageIcon("abc.jpg");
				// 设置图片大小
				Image im = icon.getImage();
				im = im.getScaledInstance(500, 300, Image.SCALE_DEFAULT);
				icon.setImage(im);
				jl21.setIcon(icon);
				jl21.setBounds(0, 0, 500, 300);

				area4.append(name2 + "送走了一名顾客，请选择继续营业还是关门");
				JButton jb10 = new JButton("继续营业");
				jb10.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						playerGUI.buy(m, n, name, nima, name2, name3);
						dg1.dispose();
						jf.dispose();

					}
				});
				JButton jb11 = new JButton("关门,结算");
				jb11.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						int money4 = 0;
						try {
							Class.forName(m);
							Connection conn1 = DriverManager.getConnection(n,
									name, nima);
							PreparedStatement pre1 = conn1
									.prepareStatement("Select * from money1 where op = ?");
							pre1.setObject(1, "1");
							ResultSet exe = pre1.executeQuery();
							while (exe.next()) {

								money4 = exe.getInt("money");

							}
							exe.close();
							pre1.close();
							conn1.close();

						} catch (ClassNotFoundException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}

						JDialog dg = new JDialog(jf, "盈亏记录", true);
						dg.setUndecorated(true);
						dg.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
						dg.setBounds(400, 400, 500, 300);
						// dg.setLayout(null);
						JTextArea area3 = new JTextArea(5, 5);
						area3.setBounds(0, 0, 500, 150);

						// 导入欢迎图片
						JLabel jl21 = new JLabel();
						ImageIcon icon = new ImageIcon("abc.jpg");
						// 设置图片大小
						Image im = icon.getImage();
						im = im.getScaledInstance(500, 300, Image.SCALE_DEFAULT);
						icon.setImage(im);
						jl21.setIcon(icon);
						jl21.setBounds(0, 0, 500, 300);

						JPanel panel4 = new JPanel();
						panel4.setLayout(null);

						JScrollPane pane1 = new JScrollPane();
						pane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

						pane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						pane1.setViewportView(area3);
						pane1.setBounds(0, 20, 500, 150);
						panel4.add(pane1);
						JLabel jl = new JLabel("员工界面");
						jl.setBounds(10, 0, 150, 20);
						panel4.add(jl);
						int ak = money4 - 5000;
						int sbmoney = 0;
						try { // 分别显示分店销售额
							Class.forName(m);
							Connection conn1 = DriverManager.getConnection(n,
									name, nima);
							PreparedStatement pre4 = conn1
									.prepareStatement("select * from employee where live = ? "); // 获取原来的钱数
							pre4.setObject(1, 1);
							ResultSet exe4 = pre4.executeQuery();
							while (exe4.next()) {
								String name_emp = exe4.getString(1);
								sbmoney = exe4.getInt(3);
								area3.append(name_emp + "今日营业额为："
										+ Integer.toString(sbmoney) + "\r\n");
							}
							exe4.close();
							pre4.close();
							conn1.close();
						} catch (ClassNotFoundException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
						try { // 分别显示分店分店员销售额
							Class.forName(m);
							Connection conn1 = DriverManager.getConnection(n,
									name, nima);
							PreparedStatement pre4 = conn1
									.prepareStatement("select * from men where live = ? order by department,name"); // 获取原来的钱数
							pre4.setObject(1, 1);
							ResultSet exe4 = pre4.executeQuery();
							while (exe4.next()) {
								String name_emp = exe4.getString(1);
								sbmoney = exe4.getInt(4);
								String department = exe4.getString(2);
								area3.append(department + "的员工" + name_emp
										+ "今日营业额为：    "
										+ Integer.toString(sbmoney) + "\r\n");
							}
							exe4.close();
							pre4.close();
							conn1.close();
						} catch (ClassNotFoundException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
						try { // 分别没上班的员工
							Class.forName(m);
							Connection conn1 = DriverManager.getConnection(n,
									name, nima);
							PreparedStatement pre4 = conn1
									.prepareStatement("select * from men where live = ? and department in(select name from employee where live = ?)order by department,name"); // 获取原来的钱数
							pre4.setObject(1, 0);
							pre4.setObject(2, 1);
							ResultSet exe4 = pre4.executeQuery();
							while (exe4.next()) {
								String name_emp = exe4.getString(1);
								sbmoney = exe4.getInt(4);
								String department = exe4.getString(2);
								area3.append(department + "的员工" + name_emp
										+ "今日没上班,这个月奖金没了" + "\r\n");
							}
							exe4.close();
							pre4.close();
							conn1.close();
						} catch (ClassNotFoundException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
						if (ak > 0) {
							area3.append("今日全部店总营业额为：" + Integer.toString(money4)
									+ "\r\n" + "今日房租为：5000" + "\r\n"
									+ "今日总利润为：" + Integer.toString(ak) + "\r\n"
									+ "赚钱了，不错");
						} else if (ak == 0) {
							area3.append("今日全部店总营业额为：" + Integer.toString(money4)
									+ "\r\n" + "今日房租为：5000" + "\r\n"
									+ "今日总利润为：" + Integer.toString(ak) + "\r\n"
									+ "一分没赚，你干啥呢？");
						} else {
							area3.append("今日全部店总营业额为：" + Integer.toString(money4)
									+ "\r\n" + "今日房租为：5000" + "\r\n"
									+ "今日总亏损为：" + Integer.toString(-ak)
									+ "\r\n" + "亏这么多？？？？？？");
						}
						JButton jb1 = new JButton("闭店，退出");
						// JButton jb2 =new JButton("返回仓库");
						// JButton jb3 =new JButton("返回主面板");
						jb1.setBounds(200, 170, 100, 40);
						// jb2.setBounds(200, 170, 100, 40);
						// jb3.setBounds(370, 170, 100, 40);
						panel4.add(jb1);
						// panel4.add(jb2);
						// panel4.add(jb3);

						jb1.addActionListener(new ActionListener() { // 闭店，退出

							@Override
							public void actionPerformed(ActionEvent arg0) {
								dg.dispose();
								jf.dispose();
								try {
									Class.forName(m);
									Connection conn2 = DriverManager
											.getConnection(n, name, nima);

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
									System.exit(0); // 关闭多线程
								} catch (ClassNotFoundException e) {
									// TODO 自动生成的 catch 块
									e.printStackTrace();
								} catch (SQLException e) {
									// TODO 自动生成的 catch 块
									e.printStackTrace();
								}

							}
						});

						panel4.add(jl21);
						dg.add(panel4);
						dg.setVisible(true);

					}
				});
				JButton jb12 = new JButton("返回仓库");
				jb12.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						employeeGUI.fruit(m, n, name, nima, name2, name3);
						jf.dispose();
						dg1.dispose();

					}
				});

				JButton jb13 = new JButton("返回，选择员工");
				jb13.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						welcomeGUI.bbq(m, n, name, nima, name2);
						jf.dispose();
						dg1.dispose();

					}
				});
				jb10.setBounds(50, 230, 180, 40);
				jb11.setBounds(300, 230, 180, 40);
				jb12.setBounds(50, 180, 180, 40);
				jb13.setBounds(300, 180, 180, 40);
				panel5.add(jb10);
				panel5.add(jb11);
				panel5.add(jb12);
				panel5.add(jb13);
				panel5.add(jl21);
				dg1.add(panel5);
				dg1.setVisible(true);

			}
		});
	}

	static void shopcar(String m, String n, String name, String nima,
			ArrayList<ArrayList<String>> buy_car) {
		try {
			Class.forName(m);
			Connection conn1 = DriverManager.getConnection(n, name, nima);
			PreparedStatement pre1 = conn1
					.prepareStatement("Select * from fruit_information");
			ResultSet exe1 = pre1.executeQuery();
			while (exe1.next()) {

				String id = exe1.getString(1);
				String name1 = exe1.getString(2);
				String in = exe1.getString(3);
				String out = exe1.getString(4);
				String num = exe1.getString(5);
				String unit = exe1.getString(6);
				// 单项
				ArrayList<String> p = new ArrayList<String>();
				Collections.addAll(p, name1, "0", out, "0");
				buy_car.add(p); // 添加到你的购物车
			}
			// 关闭流
			conn1.close();
			pre1.close();
			exe1.close();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	static void fruitinf(String m, String n, String name, String nima,
			JTextArea area1) {
		try {
			Class.forName(m);
			Connection conn1 = DriverManager.getConnection(n, name, nima);
			PreparedStatement pre1 = conn1
					.prepareStatement("Select * from fruit_information");
			ResultSet exe1 = pre1.executeQuery();
			while (exe1.next()) {

				String id = exe1.getString(1);
				String name1 = exe1.getString(2);
				int in = exe1.getInt(3);
				int out = exe1.getInt(4);
				int num = exe1.getInt(5);
				String unit = exe1.getString(6);
				area1.append(name1 + "           " + out + "               "
						+ num + "                 " + unit + "\r\n");
			}
			// 关闭流
			conn1.close();
			pre1.close();
			exe1.close();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	static void over(
			// 买单
			JTextArea area2,
			JTextField text5, // 结束
			JTextField text6, JButton jb3,
			ArrayList<ArrayList<String>> buy_car, String m, String n,
			String name, String nima, JFrame jf, JTextField text7,
			JTextField text8, String name2, String name3) {
		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// 读取购物车商品总价值
				int all_money = Integer.parseInt(text5.getText());
				// 读取你的钱包
				int youtake_money = Integer.parseInt(text6.getText());

				if (youtake_money >= all_money) {// 你带的钱比购物车的多
					area2.append("购物成功" + "\r\n");
					text6.setText(Integer.toString((youtake_money - all_money))); // 更新钱数
					area2.append("您此次购买了" + "\r\n");
					area2.append("名称           数量             单品总价" + "\r\n");
					for (ArrayList<String> j : buy_car) {
						if (Integer.parseInt(j.get(1)) != 0) { // 库存不是0再输出
							area2.append(j.get(0) + "                "
									+ j.get(1) + "                "
									+ Integer.parseInt(j.get(1))
									* Integer.parseInt(j.get(2)) + "\r\n");
						}

					}
					area2.append("总消费：" + Integer.toString(all_money) + "\r\n"); // 计算总消费
					try {
						Class.forName(m); // 为商店录入钱数
						Connection conn = DriverManager.getConnection(n, name,
								nima);
						int sbmoney = 0;
						PreparedStatement pre4 = conn
								.prepareStatement("select * from employee where name = ? "); // 获取原来的钱数
						pre4.setObject(1, name2);
						ResultSet exe4 = pre4.executeQuery();
						while (exe4.next()) {
							sbmoney = exe4.getInt(3);

						}
						sbmoney += all_money;
						// System.out.println(sbmoney);
						PreparedStatement pre = conn
								.prepareStatement("update employee set money = ? where name = ? and live = ?"); // 录入钱数
						pre.setObject(1, sbmoney);
						pre.setObject(2, name2);
						pre.setObject(3, 1);
						pre.executeUpdate();
						exe4.close();
						pre4.close();
						pre.close();
						conn.close();
					} catch (ClassNotFoundException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					try {
						Class.forName(m); // 为员工录入钱数
						Connection conn = DriverManager.getConnection(n, name,
								nima);
						int sbmoney = 0;
						PreparedStatement pre4 = conn
								.prepareStatement("select * from men where department = ? and name = ?"); // 获取原来的钱数
						pre4.setObject(1, name2);
						pre4.setObject(2, name3);
						ResultSet exe4 = pre4.executeQuery();
						while (exe4.next()) {
							sbmoney = exe4.getInt(4);

						}
						sbmoney += all_money;
						// System.out.println(sbmoney);
						PreparedStatement pre = conn
								.prepareStatement("update men set money = ? where department = ? and live = ? and name = ?"); // 录入钱数
						pre.setObject(1, sbmoney);
						pre.setObject(2, name2);
						pre.setObject(3, 1);
						pre.setObject(4, name3);
						pre.executeUpdate();
						exe4.close();
						pre4.close();
						pre.close();
						conn.close();
					} catch (ClassNotFoundException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}

					area2.append("欢迎再次光来临" + "\r\n");
					// 清清除金额面板
					text5.setText("0");
					// 清除购物车
					for (ArrayList<String> j : buy_car) {
						if (Integer.parseInt(j.get(1)) != 0) {
							Collections.replaceAll(j, j.get(1), "0");
						}
					}

					int money1 = Integer.parseInt(text7.getText());
					int money2 = money1 + all_money;
					text7.setText(Integer.toString(money2));
					try {
						int sb = 0;
						Class.forName(m);
						Connection conn1 = DriverManager.getConnection(n, name,
								nima);
						PreparedStatement pre1 = conn1
								.prepareStatement("update money1 set money = ? where op = ?");
						PreparedStatement pre2 = conn1
								.prepareStatement("select * from money1 where op =?");
						pre2.setObject(1, "1");
						ResultSet wc = pre2.executeQuery();
						while (wc.next()) {
							sb = wc.getInt("money");
						}

						pre1.setObject(1, money2 + sb);
						pre1.setObject(2, "1");
						pre1.executeUpdate();
						pre2.close();
						wc.close();
						conn1.close();
						pre1.close();
						text7.setText("0");
					} catch (ClassNotFoundException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

					int money8 = 0;
					try {
						Class.forName(m);
						Connection conn1 = DriverManager.getConnection(n, name,
								nima);
						PreparedStatement pre1 = conn1
								.prepareStatement("Select * from money1 where op = ?");
						pre1.setObject(1, "1");
						ResultSet exe = pre1.executeQuery();
						while (exe.next()) {

							money8 = exe.getInt("money");

						}
						text8.setText(Integer.toString(money8));
						exe.close();
						pre1.close();
						conn1.close();

					} catch (ClassNotFoundException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

				} else {
					area2.append("您的钱不够付款，请退还商品" + "\r\n");
				}
			}

		});
	}

	// *****************************************************************************************************************************
	static void listen_car(JTextArea area2,
			JButton jb_all, // 总览购物车
			ArrayList<ArrayList<String>> buy_car, String m, String n,
			String name, String nima) {
		jb_all.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				area2.append("目前购物车信息为" + "\r\n");
				area2.append("名称             数量            商品单价          单品总价"
						+ "\r\n");
				for (ArrayList<String> j : buy_car) {
					if (Integer.parseInt(j.get(1)) != 0) { // 库存不是0再输出，输出名称，数量，单价，总价
						area2.append(j.get(0) + "                " + j.get(1)
								+ "                " + j.get(2)
								+ "                     "
								+ Integer.parseInt(j.get(1))
								* Integer.parseInt(j.get(2)) + "\r\n");
					}

				}

			}
		});
	}

	static void remove(JTextArea area2, JTextArea area1, JTextField text1,
			JTextField text2, JTextField text5, JButton jb4,
			ArrayList<ArrayList<String>> buy_car, String m, String n,
			String name, String nima) {
		jb4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String fruit_name = text1.getText(); // 获取水果名称
				String fruit_num = text2.getText(); // 获取水果数量\
				int sb = 0;
				for (ArrayList<String> i : buy_car) { // 循环购物车

					if (fruit_name.equals(i.get(0)) // 如果输入的信息再购物车
							&& Integer.parseInt(fruit_num) <= Integer // 输入的数量小于购物车数
									.parseInt(i.get(1))
							&& Integer.parseInt(i.get(1)) > 0) { // 删除存在
						sb = 1;
						area2.append("移出购物车：名称：" + fruit_name + "  数量："
								+ fruit_num + "     总金额："
								+ Integer.parseInt(i.get(2))
								* Integer.parseInt(fruit_num) + "\r\n"); // 显示移出信息
						// 重新计算购物车总价
						// 金额显示
						int money_you = Integer.parseInt(text5.getText())
								- Integer.parseInt(i.get(2))
								* Integer.parseInt(fruit_num); // 钱
						text5.setText(Integer.toString(money_you)); // 更新钱
						// 更新你的钱包
						// int money_my = Integer.parseInt(text6.getText()) +
						// Integer.parseInt(i.get(2))*Integer.parseInt(fruit_num);
						// text6.setText(Integer.toString(money_my));
						// 重写buy_car 数字
						// 更新后的数字
						int q = Integer.parseInt(i.get(1))
								- Integer.parseInt(fruit_num); // 购物车库存 - 输入水果量
						// System.out.println("余额为" + q + "\r\n");
						if (q > 0) { // 正常更新

							Collections.replaceAll(i, i.get(1),
									Integer.toString(q));

						} else if (q == 0) { // 再次更新，并提示删光
							Collections.replaceAll(i, i.get(1),
									Integer.toString(q));
							area2.append("正好删光" + "\r\n");

						}

						// 重写fruit2数字
						// 更新fruit2库

						try {
							int num = 0;
							Class.forName(m);

							Connection conn1 = DriverManager.getConnection(n,
									name, nima);
							// 获取原来的内存数量
							PreparedStatement prep2 = conn1
									.prepareStatement("select * from  fruit_information  where name = ?");
							prep2.setObject(1, fruit_name);
							ResultSet exe1 = prep2.executeQuery();
							while (exe1.next()) {
								num = exe1.getInt(5);
							}

							Class.forName(m);

							Connection conn2 = DriverManager.getConnection(n,
									name, nima);

							PreparedStatement prep = conn2
									.prepareStatement("update fruit_information set num = ? where name = ?");
							prep.setObject(1, num + Integer.parseInt(fruit_num));
							prep.setObject(2, fruit_name);

							prep.executeUpdate();

							// 关闭流
							conn1.close();
							conn2.close();
							prep.close();
							prep2.close();
						} catch (NumberFormatException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}

						break;

					}

				}
				if (sb == 0) {
					area2.append("输入有问题" + "\r\n");
				}

				// 刷新更改后的fruit信息
				// 刷新屏幕显示
				area1.setText("");
				area1.append("名称         售价           库存量                 单位"
						+ "\r\n"); // 标题

				try {
					Class.forName(m);
					Connection conn11 = DriverManager.getConnection(n, name,
							nima);
					PreparedStatement pre1 = conn11
							.prepareStatement("Select * from fruit_information");
					ResultSet exe1 = pre1.executeQuery();
					while (exe1.next()) {

						String id = exe1.getString(1);
						String name = exe1.getString(2);
						int in = exe1.getInt(3);
						int out = exe1.getInt(4);
						int num1 = exe1.getInt(5);
						String unit = exe1.getString(6);
						area1.append(name + "           " + out
								+ "               " + num1
								+ "                 " + unit + "\r\n");
					}
					// 关闭流
					conn11.close();
					pre1.close();
					exe1.close();
				} catch (ClassNotFoundException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				area1.append("\r\n");
				text1.setText("");
				text2.setText("");
			}
		});
	}

	static void addcar(JTextArea area2, JTextArea area1, JTextField text1,
			JTextField text2, JTextField text5, JTextField text6, JButton jb2,
			ArrayList<String> car, ArrayList<ArrayList<String>> buy_car,
			String m, String n, String name, String nima) {
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String fruit_name = text1.getText(); // 获取水果名称
				String fruit_num = text2.getText(); // 获取水果数量
				int kkk = 0;
				String number = "";
				int jjj = 0;
				// 检测水果是否存在以及水果库存
				Connection conn;
				PreparedStatement pre;
				ResultSet exe;
				try {
					Class.forName(m);
					conn = DriverManager.getConnection(n, name, nima);
					pre = conn
							.prepareStatement("Select * from fruit_information");
					exe = pre.executeQuery();
					while (exe.next()) {

						String id = exe.getString(1);
						String name = exe.getString(2);
						int in = exe.getInt(3);
						int out = exe.getInt(4);
						int num = exe.getInt(5);
						String unit = exe.getString(6);
						if (name.equals(fruit_name)
								&& num > Integer.parseInt(fruit_num)) {
							kkk = 1;
						}

					}
					// 关闭流
					conn.close();
					pre.close();
					exe.close();
				} catch (NumberFormatException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				if (kkk == 1) // 符合条件
				{
					// 追加到购物车
					// 获得

					for (ArrayList<String> j : buy_car) {
						if (j.get(0).equals(fruit_name)) { // 库存不是0再输出，输出名称，数量，单价，总价
							number = j.get(2);
						}

					}

					// 追加到购物车 ,追加金额
					area2.append("加入购物车：名称："
							+ fruit_name
							+ "  数量："
							+ fruit_num
							+ "单价"
							+ number
							+ "     金额："
							+ Integer.toString(Integer.parseInt(number)
									* Integer.parseInt(fruit_num)) + "\r\n");

					// 判断追加的之前是否存在
					for (ArrayList<String> i : buy_car) {

						if (fruit_name.equals(i.get(0))) { // 如果存在
							jjj = 1;
							String new_num = Integer.toString(Integer
									.parseInt(i.get(1))
									+ Integer.parseInt(fruit_num)); // 吧原来数量进行更新
							String old_name = i.get(0);
							String old_num = i.get(1); // 获取原来的数量
							String old_money = i.get(2);
							Collections.replaceAll(i,
									old_num, // 更新数量
									Integer.toString(Integer.parseInt(old_num)
											+ Integer.parseInt(fruit_num))); // 更新后的数量
							// Collections.replaceAll(i,old_money,Integer.toString(Integer.parseInt(number)));
							// 金额显示 购物车金额
							int money_you = Integer.parseInt(text5.getText())
									+ Integer.parseInt(number)
									* Integer.parseInt(fruit_num); // 钱
							text5.setText(Integer.toString(money_you)); // 更新钱

							// 更新fruit2库

							try {
								int num = 0;
								Class.forName(m);

								Connection conn1 = DriverManager.getConnection(
										n, name, nima);
								// 获取原来的内存数量
								PreparedStatement prep2 = conn1
										.prepareStatement("select * from  fruit_information  where name = ?");
								prep2.setObject(1, fruit_name);
								ResultSet exe1 = prep2.executeQuery();
								while (exe1.next()) {
									num = exe1.getInt(5);
								}

								Class.forName(m);

								Connection conn2 = DriverManager.getConnection(
										n, name, nima);

								PreparedStatement prep = conn2
										.prepareStatement("update fruit_information set num = ? where name = ?");
								prep.setObject(1,
										num - Integer.parseInt(fruit_num));
								prep.setObject(2, fruit_name);

								prep.executeUpdate();

								// 关闭流
								conn1.close();
								conn2.close();
								prep.close();
								prep2.close();
							} catch (NumberFormatException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							} catch (ClassNotFoundException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							} catch (SQLException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}

							// 刷新屏幕显示
							area1.setText("");
							area1.append("名称         售价           库存量                 单位"
									+ "\r\n"); // 标题

							try {
								Class.forName(m);
								Connection conn11 = DriverManager
										.getConnection(n, name, nima);
								PreparedStatement pre1 = conn11
										.prepareStatement("Select * from fruit_information");
								ResultSet exe1 = pre1.executeQuery();
								while (exe1.next()) {

									String id = exe1.getString(1);
									String name = exe1.getString(2);
									int in = exe1.getInt(3);
									int out = exe1.getInt(4);
									int num1 = exe1.getInt(5);
									String unit = exe1.getString(6);
									area1.append(name + "           " + out
											+ "               " + num1
											+ "                 " + unit
											+ "\r\n");
								}
								// 关闭流
								conn11.close();
								pre1.close();
								exe1.close();
							} catch (ClassNotFoundException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							} catch (SQLException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}

							break;
						}

					}

				} else {
					area2.append("输入有误" + "\r\n");
				}

				area2.append("\r\n");
				text1.setText("");
				text2.setText("");
			}
		});
	}

	static void name_money(JTextArea area2, JTextField text1, JTextField text2,
			JTextField text6, JDialog dia, JTextField text3, JTextField text4,
			JButton jb1, String m, String n, String name, String nima,
			String qqq, JFrame jf, String name2, JTextField fw) {
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String text = text3.getText(); // 你的名字

				String money = text4.getText(); // 你的钱
				//
				// if(money == null
				// || money.length() == 0 ||isNumeric(money) == false){ //提示，不是数
				// JDialog dg = new JDialog(jf, "盈亏记录", true);
				// dg.setUndecorated(true);
				// dg.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
				// dg.setBounds(400, 400, 500, 500);
				// JPanel pl =new JPanel();
				// pl.setLayout(null);
				// JLabel k =new JLabel("请输入钱数为数字");
				// k.setBounds(200, 200, 150, 50);
				// JButton jbn =new JButton("确定");
				// jbn.setBounds(200, 300, 150, 50);
				// jbn.addActionListener(new ActionListener() {
				//
				// @Override
				// public void actionPerformed(ActionEvent arg0) {
				//
				//
				// dg.dispose();
				// //dia.dispose();
				// //fw.setText("1");
				// //playerGUI.buy(m, n, name, nima,name2);
				// //welcomeGUI.bbq(m, n, name, nima,name2);
				// //jf.setVisible(false);
				// }
				// });
				// pl.add(k);
				// pl.add(jbn);
				//
				// dg.add(pl);
				// dg.setVisible(true);
				//
				//
				// }
				// else{
				// fw.setText("0");
				// }

				if (text == null || text.length() == 0 || money == null
						|| money.length() == 0 || isNumeric(money) == false) {
					text = "流浪汉无名氏";
					money = "0";
				}

				if (Integer.parseInt(money) >= 100000000 // 从输入的钱判断对你的态度
						&& Integer.parseInt(money) < 2147483647) {
					text6.setText(money);
					area2.append("欢迎亿万富翁" + text + "前来购物，哦我的爸爸，您来了！" + "\r\n"
							+ "全体起立！全部人给我站起来！" + "\r\n" + "现在开始这个广场就叫做" + text
							+ "广场" + "\r\n"
							+ "您的Rolls-Royce Silver Ghost我可以摸一下么" + "\r\n");
				} else if (Integer.parseInt(money) >= 10000000
						&& Integer.parseInt(money) < 100000000) {
					text6.setText(money);
					area2.append("欢迎千万富翁" + text + "前来购物，喝点龙井还是依云还是皇家礼炮？"
							+ "\r\n" + "赵秘书王秘书快来招待" + "\r\n");
				} else if (Integer.parseInt(money) >= 10000
						&& Integer.parseInt(money) < 10000000) {
					text6.setText(money);
					area2.append("欢迎小老板" + text + "前来购物，小李小王快来招待" + "\r\n");
				} else if (Integer.parseInt(money) >= 100
						&& Integer.parseInt(money) < 10000) {
					text6.setText(money);
					area2.append("欢迎" + text + "前来购物，欢迎品尝，欢迎试吃" + "\r\n");
				} else if (Integer.parseInt(money) > 0
						&& Integer.parseInt(money) < 100) {
					text6.setText(money);
					area2.append("欢迎" + text + "，前来购物，不买别动自己拿袋子" + "\r\n");
				} else if (Integer.parseInt(money) <= 0) {
					text6.setText(money);
					area2.append(text + "滚开！" + "\r\n" + "没名字的没钱的要饭的出去！"
							+ "\r\n" + "带钱再进来消费" + "\r\n");
					text1.setEditable(false);
					text2.setEditable(false);
				}

				dia.dispose();

			}
		});
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	// 正则，判断是不是数字
	static void help(JFrame jf, JMenuItem item_3, JTextArea area1) {
		item_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				area1.append("请加vx + liu705195178咨询 ，你太笨了，这都弄不明白" + "\r\n");
				JDialog jd = new JDialog(jf, "请登录www.pornhub.com寻求帮助", true); // 提示框
				jd.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
				jd.setBounds(200, 400, 500, 500);
				jd.setVisible(true);
				// 导入欢迎图片
				JLabel jl = new JLabel();
				ImageIcon icon = new ImageIcon("pornhub.jpg");
				// 设置图片大小
				Image im = icon.getImage();
				im = im.getScaledInstance(500, 500, Image.SCALE_DEFAULT);
				icon.setImage(im);
				jl.setIcon(icon);
				jd.add(jl, BorderLayout.PAGE_START);
				jd.setVisible(true);
			}
		});
	}

	static void domoney(String m, String n, String name, String nima,
			String name2, JFrame jf, String money1, String name3) {
		if (money1 == null || money1.length() == 0
				|| isNumeric(money1) == false) { // 提示，不是数
			// 导入欢迎图片
			JLabel jl2111 = new JLabel();
			ImageIcon icon11 = new ImageIcon("fbi.jpg");
			// 设置图片大小
			Image im11 = icon11.getImage();
			im11 = im11.getScaledInstance(800, 450, Image.SCALE_DEFAULT);
			icon11.setImage(im11);
			jl2111.setIcon(icon11);
			jl2111.setBounds(0, 0, 800, 450);

			JFrame dg = new JFrame("盈亏记录");
			dg.setUndecorated(true);
			dg.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
			dg.setBounds(400, 400, 800, 450);
			JPanel pl = new JPanel();
			pl.setLayout(null);
			JTextField k = new JTextField("请输入钱数为数字");
			k.setBounds(320, 200, 150, 50);
			k.setEditable(false);
			JButton jbn = new JButton("确定");
			jbn.setBounds(320, 300, 150, 50);
			jf.dispose();
			jbn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					jf.dispose();
					dg.dispose();
					// dia.dispose();
					// fw.setText("1");
					playerGUI.buy(m, n, name, nima, name2, name3);
					// welcomeGUI.bbq(m, n, name, nima,name2);
					// jf.setVisible(false);
				}
			});
			pl.add(k);
			pl.add(jbn);
			pl.add(jl2111);

			dg.add(pl);
			dg.setVisible(true);

		} else {
			jf.setVisible(true);
		}
	}
}