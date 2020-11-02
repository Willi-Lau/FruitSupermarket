package supermarket;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class employeeGUI {

	static void fruit(String m, String n, String name, String nima,
			String name2, String name3) {
		
		// 建立欢迎界面

		JFrame jf = new JFrame("SKP生鲜超市" + name2 + "仓库");
		jf.setBounds(100, 30, 1600, 1000); // 1960:100, 30, 1600, 1000

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 单选按钮
		JRadioButton jr_1 = new JRadioButton("增加");
		JRadioButton jr_2 = new JRadioButton("删除");
		JRadioButton jr_3 = new JRadioButton("更改");
		JRadioButton jr_4 = new JRadioButton("精准查询");
		JRadioButton jr_5 = new JRadioButton("模糊查询");

		ButtonGroup group = new ButtonGroup(); // 单选按钮组
		group.add(jr_1);
		group.add(jr_2);
		group.add(jr_3);
		group.add(jr_4);
		group.add(jr_5);

		// 增加面板
		// 编号，名称，进价，售价，库存量，单位
		JPanel jp_add = new JPanel();

		jp_add.setLayout(null);
		// 菜单
		// 设置菜单栏
		JMenuBar bar = new JMenuBar();
		// 设置菜单
		JMenu menu = new JMenu("开始");
		JMenu menu_2 = new JMenu("帮助");
		// 菜单项
		JMenuItem item_1 = new JMenuItem("返回主界面");
		JMenuItem item_2 = new JMenuItem("退出");
		JMenuItem item_3 = new JMenuItem("帮助");
		// 开业按钮
		JButton jb_open = new JButton("开业");
		jb_open.setBounds(1230, 300, 100, 70); // 1960:1230, 300, 100, 70
		jp_add.add(jb_open);
		// 监听开业
		employeeinf.open_play(m, n, name, nima, jf, jb_open, name2, name3);

		// 设置菜单
		menu.add(item_1);
		menu.addSeparator();
		menu.add(item_2);
		bar.add(menu);
		bar.add(menu_2);
		menu_2.add(item_3);
		// 添加
		bar.setBounds(0, 0, 1600, 40);// 1960:0, 0, 1600, 40
		jp_add.add(bar);
		// 6个输入框
		JTextField jf_add1 = new JTextField(10);
		JTextField jf_add2 = new JTextField(10);
		JTextField jf_add3 = new JTextField(10);
		JTextField jf_add4 = new JTextField(10);
		JTextField jf_add5 = new JTextField(10);
		JTextField jf_add6 = new JTextField(10);
		// 6个提示框
		JLabel jl_1 = new JLabel(
				"                     编号                                 名称                             进价                            售价                           库存量                           单位");

		// 位置
		jr_1.setBounds(30, 70, 70, 50);
		jl_1.setBounds(100, 0, 800, 100);
		jf_add1.setBounds(150, 70, 80, 50);
		jf_add2.setBounds(260, 70, 80, 50);
		jf_add3.setBounds(370, 70, 80, 50);
		jf_add4.setBounds(480, 70, 80, 50);
		jf_add5.setBounds(590, 70, 80, 50);
		jf_add6.setBounds(700, 70, 80, 50);
		// 加
		jp_add.add(jl_1);
		jp_add.add(jr_1);
		jp_add.add(jf_add1);
		jp_add.add(jf_add2);
		jp_add.add(jf_add3);
		jp_add.add(jf_add4);
		jp_add.add(jf_add5);
		jp_add.add(jf_add6);

		// 删除面板

		JLabel jl_cut = new JLabel("请输入要删除的水果元素的编号或名称信息");
		JTextField jf_cut = new JTextField(15);

		jr_2.setBounds(30, 200, 70, 50);
		jf_cut.setBounds(100, 200, 250, 50);
		jl_cut.setBounds(100, 150, 450, 50);
		jp_add.add(jr_2);
		jp_add.add(jl_cut);
		jp_add.add(jf_cut);
		// jp_add.add(jb_open);
		// 改正面板
		JTextField text = new JTextField(15);
		text.setBounds(130, 320, 100, 50);
		jp_add.add(text);

		JComboBox<String> jbox = new JComboBox<String>();
		jbox.addItem("编号");
		jbox.addItem("名称");
		jbox.addItem("进价");
		jbox.addItem("售价");
		jbox.addItem("库存量");
		jbox.addItem("单位");
		JTextField jf_change1 = new JTextField(15);
		JTextField jf_change2 = new JTextField(15);
		JLabel jl_change = new JLabel(
				"      模块选择                           改正后");
		JLabel jl_change2 = new JLabel("输入编号或名称进行精准定位");

		jl_change2.setBounds(130, 270, 200, 50);
		jr_3.setBounds(30, 320, 70, 50);
		jbox.setBounds(350, 320, 70, 50);
		// jf_change1.setBounds(350, 320, 100, 50);
		jf_change2.setBounds(470, 320, 100, 50);
		jl_change.setBounds(350, 270, 250, 50);

		jp_add.add(jr_3);
		jp_add.add(jbox);
		jp_add.add(jf_change1);
		jp_add.add(jf_change2);
		jp_add.add(jl_change);
		jp_add.add(jl_change2);

		// 精准查询
		JLabel jl_find = new JLabel(
				"请输入查询的水果信息（全部时不需要输入）                                      请选择选择信息属性");
		JTextField jf_find = new JTextField(30);
		jr_4.setBounds(800, 70, 90, 50);// 1960:800, 70, 90, 50
		jf_find.setBounds(910, 70, 200, 50);// 1960:910, 70, 200, 50
		jl_find.setBounds(910, 25, 650, 50);// 1960:910, 25, 650, 50

		jp_add.add(jf_find);
		jp_add.add(jr_4);
		jp_add.add(jl_find);

		JComboBox<String> jbox1 = new JComboBox<String>();
		jbox1.addItem("全部");
		jbox1.addItem("编号");
		jbox1.addItem("名称");
		jbox1.addItem("进价");
		jbox1.addItem("售价");
		jbox1.addItem("库存");
		jbox1.addItem("单位");
		jbox1.setBounds(1300, 70, 100, 50); // 1300, 70, 100, 50
		jp_add.add(jbox1);
		// 模糊查询面板

		JLabel jl_find2 = new JLabel(
				"请输入模糊查询的数字                                      请选择信息属性                              请选择大于还是小于");
		JTextField jf_find2 = new JTextField(30);
		jl_find2.setBounds(910, 150, 650, 50);// 910, 150, 650, 50
		jr_5.setBounds(800, 200, 100, 50);// 800, 200, 100, 50
		jf_find2.setBounds(910, 200, 200, 50);// 910, 200, 200, 50

		jp_add.add(jr_5);
		jp_add.add(jf_find2);
		jp_add.add(jl_find2);

		JComboBox<String> jbox2 = new JComboBox<String>();
		// jbox2.addItem("编号");
		jbox2.addItem("进价");
		jbox2.addItem("售价");
		jbox2.addItem("库存");

		jbox2.setBounds(1160, 200, 100, 50);// 1160, 200, 100, 50
		jp_add.add(jbox2);

		JComboBox<String> jbox3 = new JComboBox<String>();
		jbox3.addItem("大于");
		jbox3.addItem("小于");
		jbox3.addItem("大于等于");
		jbox3.addItem("小于等于");

		jbox3.setBounds(1360, 200, 100, 50);// 1360, 200, 100, 50
		jp_add.add(jbox3);
		// 快捷填入

		JComboBox<String> jbox34 = new JComboBox<String>();
		jbox34.addItem("KG/CNY");
		jbox34.addItem("G/CNY");
		jbox34.addItem("MG/CNY");
		jbox34.addItem("个/CNY");
		jbox34.addItem("只/CNY");
		jbox34.addItem("颗/CNY");
		jbox34.addItem("次/CNY");
		jbox34.addItem("吨/CNY");

		jbox34.setBounds(690, 200, 100, 50);// ？
		jp_add.add(jbox34);

		// 快捷填入按钮
		JButton jb9 = new JButton("快捷填入");
		jb9.setBounds(690, 150, 100, 40);// ？
		jp_add.add(jb9);
		// 快捷填入提示
		JLabel jla = new JLabel("点击填入单位");
		jla.setBounds(695, 110, 100, 40);// ？
		jp_add.add(jla);

		// 快捷填入
		employeeinf.quickadd(jf_add6, jbox34, jb9);

		// 确定按钮
		JButton jb = new JButton("确定");
		jb.setBounds(1360, 300, 100, 70);// 1360, 300, 100, 70
		jp_add.add(jb);
		// 刷新屏幕按钮
		JButton jb2 = new JButton("清空主屏幕");
		jb2.setBounds(1100, 300, 100, 70); // 1100, 300, 100, 70
		jp_add.add(jb2);

		// 输出框
		JTextArea area = new JTextArea();
		area.setBounds(30, 400, 1400, 500); // 30, 400, 1400, 500

		// 滚动框
		JScrollPane jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		jsp.setBounds(30, 400, 1000, 500); // 30, 400, 1000, 500

		jsp.setViewportView(area);
		jp_add.add(jsp);

		jf.add(jp_add);

		// 输出框帮助
		JTextArea area1 = new JTextArea();
		area1.setBounds(30, 400, 1400, 500);// 30, 400, 1400, 500
		area1.append("欢迎" + name3 + "\r\n");
		// 滚动框
		JScrollPane jsp1 = new JScrollPane();
		jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		jsp1.setBounds(1100, 400, 400, 550); // 1100,400,400,550

		jsp1.setViewportView(area1);
		jp_add.add(jsp1);

		// 帮助面板
		employeeinf.helpbox(area1);
		// 监听刷新
		employeeinf.look2(jb2, area);

		// 监听模块
		employeeinf.look(jr_1, jr_2, jr_3, jr_4, jf_add1, jf_add2, jf_add3,
				jf_add4, jf_add5, jf_add6, jf_cut, text, jf_change1,
				jf_change2, jf_find, jb, area, jbox1, jbox, jl_find2, jf_find2,
				jr_5, jbox2, jbox3, m, n, name, nima);
		// 监听菜单按钮
		employeeinf.menu(jf, item_1, item_2, m, n, name, nima, name2);
		employeeinf.help(jf, item_3, area, m, n, name, nima);
		// 主屏幕显示
		employeeinf.maininf(area);
		// 导入欢迎图片
		JLabel jl2 = new JLabel();
		ImageIcon icon = new ImageIcon("qwe.png");
		// 设置图片大小
		Image im = icon.getImage();
		im = im.getScaledInstance(1600, 1000, Image.SCALE_DEFAULT);
		icon.setImage(im);
		jl2.setIcon(icon);
		jl2.setBounds(0, 0, 1600, 1000);
		jp_add.add(jl2);

		jf.add(jp_add);
		// 关闭窗体清空数据库
		employeeinf.close_sql(m, n, name, nima, jf);
		jf.setResizable(false);
		jf.setVisible(true);

	}

}
