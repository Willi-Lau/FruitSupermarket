package supermarket;

import java.awt.BorderLayout;
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
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class employeeinf {
	static void quickadd(JTextField jf_add6, JComboBox<String> jbox34,
			JButton jb9) {
		jb9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Object select = jbox34.getSelectedItem();
				jf_add6.setText((String) select);
			}
		});
	}

	static void maininf(JTextArea area) {
		area.append("此屏幕为主屏幕" + "\r\n");
		area.append("1：按照提示输入水果信息进行操作，最后按确定即可" + "\r\n"
				+ "2 : 可先点击查询再点击确定，查看库存水果信息，在进行操作" + "\r\n"

				+ "\r\n");
	}

	static void open_play(String m, String n, String name, String nima,
			JFrame jf, JButton jb_open, String name2, String name3) {
		jb_open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				playerGUI.buy(m, n, name, nima, name2, name3);
				jf.dispose();

			}
		});
	}

	static void helpbox(JTextArea area1) {
		area1.append("此面板为帮助面板" + "\r\n");
		area1.append("增加模块规则：" + "\r\n");
		area1.append("1：编号名字不可重复" + "\r\n");
		area1.append("2：编号进价售价库存量必须为数字" + "\r\n");
		area1.append("3：输入不能为空" + "\r\n");
		area1.append("\r\n");
		area1.append("删除模块规则：" + "\r\n");
		area1.append("1：编号名字必须存在" + "\r\n");
		area1.append("2：输入不能为空" + "\r\n");
		area1.append("\r\n");
		area1.append("更改模块规则：" + "\r\n");
		area1.append("1：编号名字必须存在" + "\r\n");
		area1.append("2：更改的名字编号不可重复" + "\r\n");
		area1.append("3：更改的进价售价编号库存必须为数字" + "\r\n");
		area1.append("4：输入不能为空" + "\r\n");
		area1.append("\r\n");
		area1.append("精准查询模块规则：" + "\r\n");
		area1.append("1：请先选择模块再查询" + "\r\n");
		area1.append("2：如果选择全部则不需要输入" + "\r\n");
		area1.append("3：查询的内容不能为空（全部除外）" + "\r\n");
		area1.append("4：查询的进价售价编号库存必须为数字" + "\r\n");

		area1.append("\r\n");
		area1.append("模糊查询模块规则：" + "\r\n");
		area1.append("1：请先选择模块，大于小于再查询" + "\r\n");
		area1.append("2：输入不能为空" + "\r\n");
		area1.append("3：模糊查询顾名思义批量查询指定范围的数据" + "\r\n");
		area1.append("4：输入的必须为数字" + "\r\n");
	}

	static void look2(JButton jb2, JTextArea area) {
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				area.setText("");
				maininf(area);

			}
		});
	}

	static void help(JFrame jf, JMenuItem item_3, JTextArea area, String m,
			String n, String name, String nima) { // 帮助模块
		item_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				area.append("请加vx + liu705195178咨询 ，你太笨了，这都弄不明白" + "\r\n");
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

	static void menu(JFrame jf, JMenuItem item_1, JMenuItem item_2, String m,
			String n, String name, String nima, String name2) {
		// 返回菜单
		item_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jf.dispose(); // 关闭
				welcomeGUI.bbq(m, n, name, nima, name2); // 返回主界面

			}
		});
		// 退出
		item_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jf.dispose(); // 关闭

			}
		});
	}

	// ****************************************************************************************************************************************
	// ****************************************************************************************************************************************
	// ****************************************************************************************************************************************
	// 监听
	static void look(JRadioButton jr_1, JRadioButton jr_2, JRadioButton jr_3,
			JRadioButton jr_4, JTextField jf_add1, JTextField jf_add2,
			JTextField jf_add3, JTextField jf_add4, JTextField jf_add5,
			JTextField jf_add6, JTextField jf_cut, JTextField text,
			JTextField jf_change1, JTextField jf_change2, JTextField jf_find,
			JButton jb, JTextArea area, JComboBox jbox1,
			JComboBox<String> jbox, JLabel jl_find2, JTextField jf_find2,
			JRadioButton jr_5, JComboBox<String> jbox2,
			JComboBox<String> jbox3, String m, String n, String name,
			String nima) {
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 连接
				try {
					Class.forName(m);
				} catch (ClassNotFoundException e3) {
					// TODO 自动生成的 catch 块
					e3.printStackTrace();
				}

				Connection conn = null;
				try {
					conn = DriverManager.getConnection(n, name, nima);
				} catch (SQLException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}

				// 增加按钮被选上
				if (jr_1.isSelected()) {

					int kkk = 0;
					if (jf_add1 == null || jf_add1.getText().length() == 0) { // 判断是否为空
						kkk = 1;
					}
					if (jf_add2 == null || jf_add2.getText().length() == 0) { // 判断是否为空
						kkk = 1;
					}
					if (jf_add3 == null || jf_add3.getText().length() == 0) { // 判断是否为空
						kkk = 1;
					}
					if (jf_add4 == null || jf_add4.getText().length() == 0) { // 判断是否为空
						kkk = 1;
					}
					if (jf_add5 == null || jf_add5.getText().length() == 0) { // 判断是否为空
						kkk = 1;
					}
					if (jf_add6 == null || jf_add6.getText().length() == 0) { // 判断是否为空
						kkk = 1;
					}
					if (isInteger(jf_add3.getText()) == false
							|| isInteger(jf_add4.getText()) == false) { // 是否是整数
						kkk = 999;
					}
					if (isInteger(jf_add1.getText()) == false) { // 是否是数
						kkk = 888;
					}
					if (isInteger(jf_add5.getText()) == false) { // 是否是数
						kkk = 666;
					}
					// for (ArrayList<String> j : fruit) { // 判断重复 1.0 Arraylist
					//
					// if (jf_add1.getText().equals(j.get(0))
					// || jf_add2.getText().equals(j.get(1))) { // 判断编号，名称是否重复
					// kkk = 1;
					//
					// }
					//
					// }
					// 判断重复2.0 JDBC fruit_information

					try {

						PreparedStatement pre = conn
								.prepareStatement("Select * from fruit_information");
						ResultSet exe = pre.executeQuery();

						while (exe.next()) {

							String id = exe.getString(1);
							String name = exe.getString(2);
							int in = exe.getInt(3);
							int out = exe.getInt(4);
							int num = exe.getInt(5);
							String unit = exe.getString(6);
							if (jf_add1.getText().equals(id)
									|| jf_add1.getText().equals(name)) { // 姓名和标号不能重复
								kkk = 1;

							}
						}

						pre.close();
						exe.close();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}

					if (kkk == 0) { // 不重复，可以开始添加数据
						// Lint currentTimeMillis = (int) System
						// I.currentTimeMillis();
						// UString string = Integer.toString(currentTimeMillis);
						// WArrayList<String> string1 = new ArrayList<>(); //
						// E新建list
						// ICollections.addAll(string1, jf_add1.getText(),
						// Yjf_add2.getText(), jf_add3.getText(),
						// Ijf_add4.getText(), jf_add5.getText(),
						// jf_add6.getText()); //把接受的数据更新到fruit里
						// Collections.addAll(fruit, string1);
						// area.append("增加数据成功" + "\r\n");

						// 2.0增加数据到数据库

						try {

							PreparedStatement prep = conn
									.prepareStatement("insert into  fruit_information values (?,?,?,?,?,?)");
							prep.setObject(1, jf_add1.getText());
							prep.setObject(2, jf_add2.getText());
							prep.setObject(3,
									Integer.parseInt(jf_add3.getText()));
							prep.setObject(4,
									Integer.parseInt(jf_add4.getText()));
							prep.setObject(5,
									Integer.parseInt(jf_add5.getText()));
							prep.setObject(6, jf_add6.getText());

							prep.executeUpdate();
							// 关闭流

							prep.close();
							area.append("增加成功");
						} catch (SQLException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}

					} else if (kkk == 1) {
						area.append("数据重复或为空，重新输入" + "\r\n"); // 数据重复
					} else if (kkk == 999) {
						area.append("请输入价钱为整数" + "\r\n"); // 不是数
					} else if (kkk == 888) {
						area.append("请输入编号为整数" + "\r\n");// 不是数
					} else if (kkk == 666) {
						area.append("请输入库存量为整数" + "\r\n");// 不是数
					}
					jf_add1.setText(""); // 清空输入界面
					jf_add2.setText("");
					jf_add3.setText("");
					jf_add4.setText("");
					jf_add5.setText("");
					jf_add6.setText("");
					area.append("\r\n"); // 换行
				}
				// ****************************************************************************************************************************************
				// ****************************************************************************************************************************************
				// ****************************************************************************************************************************************
				// 删除按钮被选上
				if (jr_2.isSelected()) {
					int kkk = 0;

					// for (ArrayList<String> j : fruit) {
					//
					// if (jf_cut.getText().equals(j.get(0)) // 判断删除信息是否存在
					// || jf_cut.getText().equals(j.get(1))) { // 判断编号，名称是否存在
					// kkk++;
					//
					// }
					// }
					try {// 判断删除信息是否存在 判断编号，名称是否存在

						PreparedStatement pre = conn
								.prepareStatement("Select * from fruit_information");
						ResultSet exe = pre.executeQuery();

						while (exe.next()) {

							String id = exe.getString(1);
							String name = exe.getString(2);
							int in = exe.getInt(3);
							int out = exe.getInt(4);
							int num = exe.getInt(5);
							String unit = exe.getString(6);
							if (jf_cut.getText().equals(id)
									|| jf_cut.getText().equals(name)) { // 姓名和标号不能重复
								kkk++; // 存在加1

							}
						}

						pre.close();
						exe.close();
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

					if (kkk != 0) { // 存在
						// for (ArrayList<String> j : fruit) {
						// if (j.contains(jf_cut.getText())) { // 定位位置
						//
						// fruit.remove(j); // 删除fruit里的元素
						// area.append("删除成功");
						//
						// break;
						// }
						// }

						// 执行删除

						try {

							String name = "马丁123";
							PreparedStatement prep = conn
									.prepareStatement("delete from  fruit_information  where id = ? or name = ?");
							prep.setObject(1, jf_cut.getText());
							prep.setObject(2, jf_cut.getText());
							area.append("删除成功");
							prep.executeUpdate();
							// 关闭流

							prep.close();
						} catch (SQLException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}

					else { // 不存在
						area.append("删除对象不存在，请重新输入" + "\r\n");
					}
					jf_cut.setText(""); // 清空输入框
					area.append("\r\n");
				}

				// ****************************************************************************************************************************************
				// ****************************************************************************************************************************************
				// ****************************************************************************************************************************************

				if (jr_4.isSelected()) { // 查询模块
					String text2 = jf_find.getText();
					int kkk = 0;

					if (jbox1.getSelectedItem() == "全部") {
						// 存在查询所有

						area.append("编号                         名称                         进价                         售价                         库存量                         单位"
								+ "\r\n"); // 标题
						try {

							PreparedStatement pre1 = conn
									.prepareStatement("Select * from fruit_information");
							ResultSet exe1 = pre1.executeQuery();
							while (exe1.next()) {

								String id = exe1.getString(1);
								String name = exe1.getString(2);
								int in = exe1.getInt(3);
								int out = exe1.getInt(4);
								int num = exe1.getInt(5);
								String unit = exe1.getString(6);
								area.append(id + "                      "
										+ name + "                         "
										+ in + "                           "
										+ out + "                         "
										+ num + "                         "
										+ unit + "\r\n");
							}
							// 关闭流

							pre1.close();
							exe1.close();
							jf_find.setText("");
						} catch (SQLException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}

					}
					if (jbox1.getSelectedItem() == "编号") {
						try {

							PreparedStatement pre = conn
									.prepareStatement("Select * from fruit_information where id = ?");
							pre.setObject(1, text2);
							ResultSet exe = pre.executeQuery();
							while (exe.next()) {

								String id = exe.getString(1);
								String name = exe.getString(2);
								int in = exe.getInt(3);
								int out = exe.getInt(4);
								int num = exe.getInt(5);
								String unit = exe.getString(6);
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n"); // 标题
								area.append(id + "                      "
										+ name + "                         "
										+ in + "                           "
										+ out + "                         "
										+ num + "                         "
										+ unit + "\r\n");
								kkk = 1;
							}
							if (kkk != 1) {
								area.append("输入有误" + "\r\n");
							}
							// 关闭流

							pre.close();
							exe.close();
						} catch (SQLException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();

						} finally {
							jf_find.setText("");
						}

					}
					if (jbox1.getSelectedItem() == "名称") {
						try {
							area.append("\r\n");
							// area.append("777");

							PreparedStatement pre1 = conn
									.prepareStatement("Select * from fruit_information where name = ? ");
							pre1.setObject(1, text2);
							ResultSet exe1 = pre1.executeQuery();
							// area.append("888");
							while (exe1.next()) {
								// area.append("999");
								String id = exe1.getString(1);
								String name = exe1.getString(2);
								int in = exe1.getInt(3);
								int out = exe1.getInt(4);
								int num = exe1.getInt(5);

								String unit = exe1.getString(6);
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n"); // 标题
								area.append(id + "                      "
										+ name + "                         "
										+ in + "                           "
										+ out + "                         "
										+ num + "                         "
										+ unit + "\r\n");
								kkk = 1;
							}
							// 关闭流
							if (kkk == 0) {
								area.append("输入有误" + "\r\n");
							}

							pre1.close();
							exe1.close();
						} catch (SQLException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();

						} finally {
							jf_find.setText("");
						}
					}
					if (jbox1.getSelectedItem() == "进价") {
						try {
							area.append("\r\n");
							// area.append("777");

							PreparedStatement pre1 = conn
									.prepareStatement("Select * from fruit_information where inprice = ? ");
							pre1.setObject(1, text2);
							ResultSet exe1 = pre1.executeQuery();
							// area.append("888");
							while (exe1.next()) {
								// area.append("999");
								String id = exe1.getString(1);
								String name = exe1.getString(2);
								int in = exe1.getInt(3);
								int out = exe1.getInt(4);
								int num = exe1.getInt(5);

								String unit = exe1.getString(6);
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n"); // 标题
								area.append(id + "                      "
										+ name + "                         "
										+ in + "                           "
										+ out + "                         "
										+ num + "                         "
										+ unit + "\r\n");
								kkk = 1;
							}
							// 关闭流
							if (kkk == 0) {
								area.append("输入有误" + "\r\n");
							}

							pre1.close();
							exe1.close();
						} catch (SQLException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();

						} finally {
							jf_find.setText("");
						}
					}
					if (jbox1.getSelectedItem() == "售价") {
						try {
							area.append("\r\n");
							// area.append("777");

							PreparedStatement pre1 = conn
									.prepareStatement("Select * from fruit_information where outprice = ? ");
							pre1.setObject(1, text2);
							ResultSet exe1 = pre1.executeQuery();
							// area.append("888");
							while (exe1.next()) {
								// area.append("999");
								String id = exe1.getString(1);
								String name = exe1.getString(2);
								int in = exe1.getInt(3);
								int out = exe1.getInt(4);
								int num = exe1.getInt(5);

								String unit = exe1.getString(6);
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n"); // 标题
								area.append(id + "                      "
										+ name + "                         "
										+ in + "                           "
										+ out + "                         "
										+ num + "                         "
										+ unit + "\r\n");
								kkk = 1;
							}
							// 关闭流
							if (kkk == 0) {
								area.append("输入有误" + "\r\n");
							}

							pre1.close();
							exe1.close();
						} catch (SQLException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();

						} finally {
							jf_find.setText("");
						}
					}
					if (jbox1.getSelectedItem() == "库存") {
						try {
							for (int i = 0; i < 100; i++) {
								System.out.println("\r\n");
							}
							System.out.println(1);
							area.append("\r\n");
							// area.append("777");

							PreparedStatement pre1 = conn
									.prepareStatement("Select * from fruit_information where num = ? ");
							pre1.setObject(1, text2);
							ResultSet exe1 = pre1.executeQuery();
							// area.append("888");
							while (exe1.next()) {
								// area.append("999");
								String id = exe1.getString(1);
								String name = exe1.getString(2);
								int in = exe1.getInt(3);
								int out = exe1.getInt(4);
								int num = exe1.getInt(5);

								String unit = exe1.getString(6);
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n"); // 标题
								area.append(id + "                      "
										+ name + "                         "
										+ in + "                           "
										+ out + "                         "
										+ num + "                         "
										+ unit + "\r\n");
								kkk = 1;
							}
							// 关闭流
							if (kkk == 0) {
								area.append("输入有误" + "\r\n");
							}

							pre1.close();
							exe1.close();
						} catch (SQLException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();

						} finally {
							jf_find.setText("");
						}
					}
					if (jbox1.getSelectedItem() == "单位") {
						try {
							area.append("\r\n");
							// area.append("777");

							PreparedStatement pre1 = conn
									.prepareStatement("Select * from fruit_information where unit = ? ");
							pre1.setObject(1, text2);
							ResultSet exe1 = pre1.executeQuery();
							// area.append("888");
							while (exe1.next()) {
								// area.append("999");
								String id = exe1.getString(1);
								String name = exe1.getString(2);
								int in = exe1.getInt(3);
								int out = exe1.getInt(4);
								int num = exe1.getInt(5);

								String unit = exe1.getString(6);
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n"); // 标题
								area.append(id + "                      "
										+ name + "                         "
										+ in + "                           "
										+ out + "                         "
										+ num + "                         "
										+ unit + "\r\n");
								kkk = 1;
							}
							// 关闭流
							if (kkk == 0) {
								area.append("输入有误" + "\r\n");
							}

							pre1.close();
							exe1.close();
						} catch (SQLException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();

						} finally {
							jf_find.setText("");
						}
					}

				}

				// ****************************************************************************************************************************************
				// ****************************************************************************************************************************************
				// ****************************************************************************************************************************************
				if (jr_3.isSelected()) { // 更改模块
					try {
						int sb = 0;

						PreparedStatement pre = conn
								.prepareStatement("Select * from fruit_information");
						ResultSet exe = pre.executeQuery();
						while (exe.next()) {

							String id = exe.getString(1);
							String name = exe.getString(2);
							int in = exe.getInt(3);
							int out = exe.getInt(4);
							int num = exe.getInt(5);
							String unit = exe.getString(6);
							if (text.getText().equals(id)
									|| text.getText().equals(name)) {

								sb = 1; // 存在
							}
						}

						if (sb == 1) { // 存在

							// 监听下拉框
							int jj = 0;
							if (jbox.getSelectedItem() == "编号") { // 编号模块

								// 判断是不是数字
								if (isInteger(jf_change2.getText()) == false) {
									jj = 1;
									area.append("输入的编号不是数字，请重新输入" + "\r\n");
								}
								// 判断是否为空
								if (jf_change2.getText() == ""
										|| jf_change2.getText().length() == 0) {
									jj = 1;
									area.append("输入为空，请重新输入" + "\r\n");
								}
								// 判断是否重复
								while (exe.next()) {

									String id = exe.getString(1);
									String name = exe.getString(2);
									int in = exe.getInt(3);
									int out = exe.getInt(4);
									int num = exe.getInt(5);
									String unit = exe.getString(6);
									if (jf_change2.getText().equals(id)) {

										jj = 1; // 重复
										area.append("输入编号重复，请重新输入" + "\r\n");
									}
								}

								if (jj == 0) { // 符合一切标准，进行替换
									try {
										PreparedStatement prep = conn
												.prepareStatement("update fruit_information set  id = ? where name = ? or id = ?");
										prep.setObject(2, text.getText());
										prep.setObject(3, text.getText());
										prep.setObject(1, jf_change2.getText());

										prep.executeUpdate();
										// 关闭流

										prep.close();
										area.append("更改编号成功" + "\r\n");
										text.setText("");
										jf_change2.setText("");
									} catch (Exception e) {
										// TODO 自动生成的 catch 块
										e.printStackTrace();
									}

								}

							}
							if (jbox.getSelectedItem() == "名称") {
								// 判断名称是否重复
								int ob = 0;
								while (exe.next()) {

									String id = exe.getString(1);
									String name = exe.getString(2);
									int in = exe.getInt(3);
									int out = exe.getInt(4);
									int num = exe.getInt(5);
									String unit = exe.getString(6);
									if (jf_change2.getText().equals(name)) {

										ob = 1; // 重复
										area.append("输入编号重复，请重新输入" + "\r\n");
									}
								}
								// 不重复
								if (ob == 0) {
									try {
										PreparedStatement prep = conn
												.prepareStatement("update fruit_information set  name = ? where name = ? or id = ?");
										prep.setObject(2, text.getText());
										prep.setObject(3, text.getText());
										prep.setObject(1, jf_change2.getText());

										prep.executeUpdate();
										// 关闭流

										prep.close();
										area.append("更改名字成功" + "\r\n");
										text.setText("");
										jf_change2.setText("");
									} catch (Exception e) {
										// TODO 自动生成的 catch 块
										e.printStackTrace();
									}

								}

							}
							if (jbox.getSelectedItem() == "进价") { // jinjia模块
								// 判断是不是数字
								if (isInteger(jf_change2.getText()) == false) {
									jj = 1;
									area.append("输入的进价不是数字，请重新输入" + "\r\n");
								}
								// 判断是否为空
								if (jf_change2.getText() == ""
										|| jf_change2.getText().length() == 0) {
									jj = 1;
									area.append("输入为空，请重新输入" + "\r\n");
								}

								if (jj == 0) { // 符合一切标准，进行替换
									try {
										PreparedStatement prep = conn
												.prepareStatement("update fruit_information set  inprice = ? where name = ? or id = ?");
										prep.setObject(2, text.getText());
										prep.setObject(3, text.getText());
										prep.setObject(1, jf_change2.getText());

										prep.executeUpdate();
										// 关闭流

										prep.close();
										area.append("更改进价成功" + "\r\n");
										text.setText("");
										jf_change2.setText("");
									} catch (Exception e) {
										// TODO 自动生成的 catch 块
										e.printStackTrace();
									}

								}

							}
							if (jbox.getSelectedItem() == "售价") {
								// shoujia模块
								// 判断是不是数字
								if (isInteger(jf_change2.getText()) == false) {
									jj = 1;
									area.append("输入的售价不是数字，请重新输入" + "\r\n");
								}
								// 判断是否为空
								if (jf_change2.getText() == ""
										|| jf_change2.getText().length() == 0) {
									jj = 1;
									area.append("输入为空，请重新输入" + "\r\n");
								}

								if (jj == 0) { // 符合一切标准，进行替换
									try {
										PreparedStatement prep = conn
												.prepareStatement("update fruit_information set  outprice = ? where name = ? or id = ?");
										prep.setObject(2, text.getText());
										prep.setObject(3, text.getText());
										prep.setObject(1, jf_change2.getText());

										prep.executeUpdate();
										// 关闭流
										conn.close();
										prep.close();
										area.append("更改售价成功" + "\r\n");
										text.setText("");
										jf_change2.setText("");
									} catch (Exception e) {
										// TODO 自动生成的 catch 块
										e.printStackTrace();
									}

								}

							}
							if (jbox.getSelectedItem() == "库存量") {

								if (isInteger(jf_change2.getText()) == false) {
									jj = 1;
									area.append("输入的库存量不是数字，请重新输入" + "\r\n");
								}
								// 判断是否为空
								if (jf_change2.getText() == ""
										|| jf_change2.getText().length() == 0) {
									jj = 1;
									area.append("输入为空，请重新输入" + "\r\n");
								}

								if (jj == 0) { // 符合一切标准，进行替换
									try {
										PreparedStatement prep = conn
												.prepareStatement("update fruit_information set  num = ? where name = ? or id = ?");
										prep.setObject(2, text.getText());
										prep.setObject(3, text.getText());
										prep.setObject(1, jf_change2.getText());

										prep.executeUpdate();
										// 关闭流

										prep.close();
										area.append("更改库存成功" + "\r\n");
										text.setText("");
										jf_change2.setText("");
									} catch (Exception e) {
										// TODO 自动生成的 catch 块
										e.printStackTrace();
									}

								}

							}
							if (jbox.getSelectedItem() == "单位") {
								try {
									PreparedStatement prep = conn
											.prepareStatement("update fruit_information set  unit = ? where name = ? or id = ?");
									prep.setObject(2, text.getText());
									prep.setObject(3, text.getText());
									prep.setObject(1, jf_change2.getText());

									prep.executeUpdate();
									// 关闭流

									prep.close();
									area.append("更改单位成功" + "\r\n");
									text.setText("");
									jf_change2.setText("");
								} catch (Exception e) {
									// TODO 自动生成的 catch 块
									e.printStackTrace();
								}

							}

						} else {
							area.append("输入有误" + "\r\n");
						}
						// 关闭流

						pre.close();
						exe.close();
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

				}
				if (jr_5.isSelected() && isInteger(jf_find2.getText()) == false) {
					area.append("输入有误" + "\r\n");
					jf_find2.setText("");
				}
				if (jr_5.isSelected() && isInteger(jf_find2.getText())) { // 模糊查询
					if (jbox2.getSelectedItem() == "进价") { // 查询进价
						if (jbox3.getSelectedItem() == "大于") {

							try {
								PreparedStatement pre = conn
										.prepareStatement("Select * from fruit_information where inprice > ?");
								pre.setObject(1, jf_find2.getText());
								ResultSet exe = pre.executeQuery();
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n");
								while (exe.next()) {
									String id = exe.getString(1);
									String name = exe.getString(2);
									int in = exe.getInt(3);
									int out = exe.getInt(4);
									int num = exe.getInt(5);
									String unit = exe.getString(6);
									area.append(id + "                      "
											+ name
											+ "                         " + in
											+ "                           "
											+ out + "                         "
											+ num + "                         "
											+ unit + "\r\n");

								}

								// 关闭流

								pre.close();
								exe.close();

								jf_find2.setText("");

							} catch (SQLException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						}
						if (jbox3.getSelectedItem() == "小于") {

							try {
								PreparedStatement pre = conn
										.prepareStatement("Select * from fruit_information where inprice < ?");
								pre.setObject(1, jf_find2.getText());
								ResultSet exe = pre.executeQuery();
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n");
								while (exe.next()) {
									String id = exe.getString(1);
									String name = exe.getString(2);
									int in = exe.getInt(3);
									int out = exe.getInt(4);
									int num = exe.getInt(5);
									String unit = exe.getString(6);
									area.append(id + "                      "
											+ name
											+ "                         " + in
											+ "                           "
											+ out + "                         "
											+ num + "                         "
											+ unit + "\r\n");

								}
								// l = 10;
								// 关闭流

								pre.close();
								exe.close();

								jf_find2.setText("");

							} catch (SQLException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						}
						if (jbox3.getSelectedItem() == "大于等于") {
							try {
								PreparedStatement pre = conn
										.prepareStatement("Select * from fruit_information where inprice >= ?");
								pre.setObject(1, jf_find2.getText());
								ResultSet exe = pre.executeQuery();
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n");
								while (exe.next()) {
									String id = exe.getString(1);
									String name = exe.getString(2);
									int in = exe.getInt(3);
									int out = exe.getInt(4);
									int num = exe.getInt(5);
									String unit = exe.getString(6);
									area.append(id + "                      "
											+ name
											+ "                         " + in
											+ "                           "
											+ out + "                         "
											+ num + "                         "
											+ unit + "\r\n");

								}
								// l = 10;
								// 关闭流

								pre.close();
								exe.close();

								jf_find2.setText("");

							} catch (SQLException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						}
						if (jbox3.getSelectedItem() == "小于等于") {
							// 注册驱动
							try {
								PreparedStatement pre = conn
										.prepareStatement("Select * from fruit_information where inprice <= ?");
								pre.setObject(1, jf_find2.getText());
								ResultSet exe = pre.executeQuery();
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n");
								while (exe.next()) {
									String id = exe.getString(1);
									String name = exe.getString(2);
									int in = exe.getInt(3);
									int out = exe.getInt(4);
									int num = exe.getInt(5);
									String unit = exe.getString(6);
									area.append(id + "                      "
											+ name
											+ "                         " + in
											+ "                           "
											+ out + "                         "
											+ num + "                         "
											+ unit + "\r\n");

								}
								// l = 10;
								// 关闭流

								pre.close();
								exe.close();

								jf_find2.setText("");

							} catch (SQLException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						}
					}
					if (jbox2.getSelectedItem() == "售价") { // 查询售价
						if (jbox3.getSelectedItem() == "大于") {
							// 注册驱动
							try {
								PreparedStatement pre = conn
										.prepareStatement("Select * from fruit_information where outprice > ?");
								pre.setObject(1, jf_find2.getText());
								ResultSet exe = pre.executeQuery();
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n");
								while (exe.next()) {
									String id = exe.getString(1);
									String name = exe.getString(2);
									int in = exe.getInt(3);
									int out = exe.getInt(4);
									int num = exe.getInt(5);
									String unit = exe.getString(6);
									area.append(id + "                      "
											+ name
											+ "                         " + in
											+ "                           "
											+ out + "                         "
											+ num + "                         "
											+ unit + "\r\n");

								}

								// 关闭流

								pre.close();
								exe.close();

								jf_find2.setText("");

							} catch (SQLException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						}
						if (jbox3.getSelectedItem() == "小于") {
							// 注册驱动
							try {
								PreparedStatement pre = conn
										.prepareStatement("Select * from fruit_information where outprice < ?");
								pre.setObject(1, jf_find2.getText());
								ResultSet exe = pre.executeQuery();
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n");
								while (exe.next()) {
									String id = exe.getString(1);
									String name = exe.getString(2);
									int in = exe.getInt(3);
									int out = exe.getInt(4);
									int num = exe.getInt(5);
									String unit = exe.getString(6);
									area.append(id + "                      "
											+ name
											+ "                         " + in
											+ "                           "
											+ out + "                         "
											+ num + "                         "
											+ unit + "\r\n");

								}
								// l = 10;
								// 关闭流

								pre.close();
								exe.close();

								jf_find2.setText("");

							} catch (SQLException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						}
						if (jbox3.getSelectedItem() == "大于等于") {// 注册驱动
							try {
								PreparedStatement pre = conn
										.prepareStatement("Select * from fruit_information where outprice >= ?");
								pre.setObject(1, jf_find2.getText());
								ResultSet exe = pre.executeQuery();
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n");
								while (exe.next()) {
									String id = exe.getString(1);
									String name = exe.getString(2);
									int in = exe.getInt(3);
									int out = exe.getInt(4);
									int num = exe.getInt(5);
									String unit = exe.getString(6);
									area.append(id + "                      "
											+ name
											+ "                         " + in
											+ "                           "
											+ out + "                         "
											+ num + "                         "
											+ unit + "\r\n");

								}
								// l = 10;
								// 关闭流

								pre.close();
								exe.close();

								jf_find2.setText("");

							} catch (SQLException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						}
						if (jbox3.getSelectedItem() == "小于等于") {
							// 注册驱动
							try {
								PreparedStatement pre = conn
										.prepareStatement("Select * from fruit_information where outprice <= ?");
								pre.setObject(1, jf_find2.getText());
								ResultSet exe = pre.executeQuery();
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n");
								while (exe.next()) {
									String id = exe.getString(1);
									String name = exe.getString(2);
									int in = exe.getInt(3);
									int out = exe.getInt(4);
									int num = exe.getInt(5);
									String unit = exe.getString(6);
									area.append(id + "                      "
											+ name
											+ "                         " + in
											+ "                           "
											+ out + "                         "
											+ num + "                         "
											+ unit + "\r\n");

								}
								// l = 10;
								// 关闭流

								pre.close();
								exe.close();

								jf_find2.setText("");

							} catch (SQLException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						}
					}

					if (jbox2.getSelectedItem() == "库存") { // 查询售价
						if (jbox3.getSelectedItem() == "大于") {
							// 注册驱动
							try {
								PreparedStatement pre = conn
										.prepareStatement("Select * from fruit_information where num > ?");
								pre.setObject(1, jf_find2.getText());
								ResultSet exe = pre.executeQuery();
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n");
								while (exe.next()) {
									String id = exe.getString(1);
									String name = exe.getString(2);
									int in = exe.getInt(3);
									int out = exe.getInt(4);
									int num = exe.getInt(5);
									String unit = exe.getString(6);
									area.append(id + "                      "
											+ name
											+ "                         " + in
											+ "                           "
											+ out + "                         "
											+ num + "                         "
											+ unit + "\r\n");

								}

								// 关闭流

								pre.close();
								exe.close();

								jf_find2.setText("");

							} catch (SQLException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						}
						if (jbox3.getSelectedItem() == "小于") {
							// 注册驱动
							try {
								PreparedStatement pre = conn
										.prepareStatement("Select * from fruit_information where num < ?");
								pre.setObject(1, jf_find2.getText());
								ResultSet exe = pre.executeQuery();
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n");
								while (exe.next()) {
									String id = exe.getString(1);
									String name = exe.getString(2);
									int in = exe.getInt(3);
									int out = exe.getInt(4);
									int num = exe.getInt(5);
									String unit = exe.getString(6);
									area.append(id + "                      "
											+ name
											+ "                         " + in
											+ "                           "
											+ out + "                         "
											+ num + "                         "
											+ unit + "\r\n");

								}
								// l = 10;
								// 关闭流

								pre.close();
								exe.close();

								jf_find2.setText("");

							} catch (SQLException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						}
						if (jbox3.getSelectedItem() == "大于等于") {// 注册驱动
							try {
								PreparedStatement pre = conn
										.prepareStatement("Select * from fruit_information where num >= ?");
								pre.setObject(1, jf_find2.getText());
								ResultSet exe = pre.executeQuery();
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n");
								while (exe.next()) {
									String id = exe.getString(1);
									String name = exe.getString(2);
									int in = exe.getInt(3);
									int out = exe.getInt(4);
									int num = exe.getInt(5);
									String unit = exe.getString(6);
									area.append(id + "                      "
											+ name
											+ "                         " + in
											+ "                           "
											+ out + "                         "
											+ num + "                         "
											+ unit + "\r\n");

								}
								// l = 10;
								// 关闭流

								pre.close();
								exe.close();

								jf_find2.setText("");

							} catch (SQLException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						}
						if (jbox3.getSelectedItem() == "小于等于") {
							// 注册驱动
							try {
								PreparedStatement pre = conn
										.prepareStatement("Select * from fruit_information where num <= ?");
								pre.setObject(1, jf_find2.getText());
								ResultSet exe = pre.executeQuery();
								area.append("编号                         名称                         进价                         售价                         库存量                         单位"
										+ "\r\n");
								while (exe.next()) {
									String id = exe.getString(1);
									String name = exe.getString(2);
									int in = exe.getInt(3);
									int out = exe.getInt(4);
									int num = exe.getInt(5);
									String unit = exe.getString(6);
									area.append(id + "                      "
											+ name
											+ "                         " + in
											+ "                           "
											+ out + "                         "
											+ num + "                         "
											+ unit + "\r\n");

								}
								// l = 10;
								// 关闭流

								pre.close();
								exe.close();

								jf_find2.setText("");

							} catch (SQLException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						}
					}

				}

				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}

		});

	}
       //正则
	private static boolean isInteger(String str) {
		if (null == str || "".equals(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	// 是否为整数
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	// 正则，判断是不是数字
	static void close_sql(String m, String n, String name, String nima,
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

}
