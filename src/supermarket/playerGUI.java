package supermarket;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class playerGUI {

	static void buy(String m, String n, String name, String nima, String name2,
			String name3) {

		JFrame jf = new JFrame();
		jf.setTitle("SKP生鲜超市" + name2);
		jf.setBounds(300, 50, 800, 1000);

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel jp = new JPanel();
		jp.setLayout(null);

		// 设置
		// 设置菜单栏
		JMenuBar bar = new JMenuBar();
		// 设置菜单
		JMenu menu = new JMenu("开始");
		JMenu menu_2 = new JMenu("帮助");
		// 菜单项
		JMenuItem item_1 = new JMenuItem("返回主界面");
		JMenuItem item_2 = new JMenuItem("退出");
		JMenuItem item_3 = new JMenuItem("帮助");

		// 设置菜单
		menu.add(item_1);
		menu.addSeparator();
		menu.add(item_2);
		bar.add(menu);

		menu_2.add(item_3);
		bar.add(menu_2);
		bar.setBounds(0, 0, 800, 50);
		jp.add(bar);

		// 返回菜单监听
		playerinf.caidan(m, n, name, nima, jf, item_1, name2);
		// 退出
		playerinf.tuichu(jf, item_2);

		// 2个滚动文字狂
		JScrollPane jsp1 = new JScrollPane();
		JScrollPane jsp2 = new JScrollPane();

		// 设置滚动
		jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// 设置刷新按钮
		JButton jb_new = new JButton("刷新商店信息");
		jb_new.setBounds(50, 520, 150, 40); // 50, 530, 150, 40
		jp.add(jb_new);

		// jp.add(jb_new);
		// 设置多行文字2个
		JTextArea area1 = new JTextArea(10, 10);

		JTextArea area2 = new JTextArea(10, 10);
		// 加入中间
		jsp1.setViewportView(area1);
		String qqq = "1200"; // 面板大小
		jsp2.setViewportView(area2);
		// 位置
		jsp1.setBounds(50, 100, 340, 400); // 50, 100, 300, 400
		jsp2.setBounds(400, 100, 340, 400); // 360, 100, 300, 400
		jp.add(jsp1);
		jp.add(jsp2);
		// 提示
		JLabel jl1 = new JLabel(
				"水果信息显示框                                                                                         购买信息综合显示框(购物车)");
		jl1.setBounds(50, 50, 700, 50); // 50, 50, 500, 50
		jp.add(jl1);
		// 两个输入框
		JTextField text1 = new JTextField(10);
		JTextField text2 = new JTextField(10);
		area2.append(name3 + "为您服务" + "\r\n");
		// 金额提示框
		JTextField text5 = new JTextField(10);
		text5.setEditable(false); // 购物车总金额
		text5.setBounds(400, 520, 150, 40); // 360, 520, 300, 40
		jp.add(text5);
		// 商店挣的钱
		JTextField text7 = new JTextField(10);
		text7.setEditable(false); // 购物车总金额
		text7.setBounds(240, 11780, 200, 40);
		jp.add(text7);
		text7.setText("0");
		// 文字提示
		JLabel jl7 = new JLabel("本次营业额");
		jl7.setBounds(140, 11780, 120, 40);
		jp.add(jl7);
		// 文字提示
		JLabel jl8 = new JLabel("今日营业额");
		jl8.setBounds(230, 780, 120, 40); // 140, 780, 120, 40
		jp.add(jl8);
		// 金额提示框
		JTextField text8 = new JTextField(10);
		text8.setEditable(false); // 购物车总金额
		text8.setBounds(340, 780, 120, 40); // 240, 780, 120, 40
		jp.add(text8);
		int money4 = 0;
		// 今日营业额
		playerinf.today_money(m, n, name, nima, text8, money4);

		// 文字提示
		JLabel jl5 = new JLabel("购物车总金额");
		jl5.setBounds(270, 520, 120, 40); // 240, 520, 120, 40
		jp.add(jl5);
		// 记录金钱
		JTextField text6 = new JTextField(10);
		text6.setEditable(false); // 你带的钱
		text6.setBounds(340, 700, 120, 40); // 240, 700, 200, 40
		jp.add(text6);
		// 文字提示
		JLabel jl6 = new JLabel("你卡的余额");
		jl6.setBounds(230, 700, 100, 40); // 140, 700, 100, 40
		jp.add(jl6);

		// 设置相关属性
		text1.setBounds(230, 610, 150, 50); // 水果名称 50, 610, 150, 50
		text2.setBounds(400, 610, 150, 50); // 数量 250, 610, 150, 50
		jp.add(text1);
		jp.add(text2);
		// 提示
		JLabel jl2 = new JLabel(
				"快捷填入水果名称                                   输入水果名称                                    输入数量");
		jl2.setBounds(60, 560, 500, 50); // 50, 560, 350, 50
		jp.add(jl2);

		// 警告框
		JDialog dia = new JDialog(jf, "输入购买者信息", true);
		dia.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		dia.setBounds(200, 200, 400, 400);

		// 两个输入框
		JTextField text3 = new JTextField(15);
		JTextField text4 = new JTextField(15);
		text3.setBounds(130, 120, 150, 40);
		text4.setBounds(130, 190, 150, 40);
		// 中间体
		JPanel jp2 = new JPanel();
		jp2.setLayout(null);
		jp2.add(text3);
		jp2.add(text4);
		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		// 确定按钮
		JButton jb1 = new JButton("确定");
		jb1.setBounds(160, 240, 70, 30);

		// 提示框
		JLabel jl3 = new JLabel("输入你的名字");
		JLabel jl4 = new JLabel("输入你带的钱(不得超过20亿)");

		jl3.setBounds(130, 90, 100, 40);
		jl4.setBounds(130, 160, 300, 40);

		// 导入欢迎图片
		JLabel jl21 = new JLabel();
		ImageIcon icon = new ImageIcon("abc.jpg");
		// 设置图片大小
		Image im = icon.getImage();
		im = im.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
		icon.setImage(im);
		jl21.setIcon(icon);
		jl21.setBounds(0, 0, 400, 400);

		jp2.add(jl3);
		jp2.add(jl4);
		dia.setUndecorated(true);
		dia.setResizable(false);
		// 外挂
		JTextField fw = new JTextField(10);
		fw.setBounds(1000, 3000, 100, 100);
		jp.add(fw);
		// 监听按钮，输入名字，钱
		playerinf.name_money(area2, text1, text2, text6, dia, text3, text4,
				jb1, m, n, name, nima, qqq, jf, name2, fw);

		jp2.add(jb1);
		// panel3.add(jp2);
		jp2.add(jl21);
		dia.add(jp2);
		dia.setVisible(true);

		// 按钮
		JButton jb2 = new JButton("确定加入购物车");
		jb2.setBounds(600, 630, 150, 40); // 550, 630, 150, 40
		jp.add(jb2);

		JButton jb_all = new JButton("总览购物车");
		jb_all.setBounds(600, 680, 150, 40); // 550, 680, 150, 40
		jp.add(jb_all);

		JButton jb3 = new JButton("买单");
		jb3.setBounds(600, 780, 150, 40); // 550, 780, 150, 40
		jp.add(jb3);

		JButton jb4 = new JButton("确定移出购物车");
		jb4.setBounds(600, 580, 150, 40); // 550, 580, 150, 40)
		jp.add(jb4);

		JButton jb5 = new JButton("离开回家");
		jb5.setBounds(600, 830, 150, 40); // 550, 830, 150, 40
		jp.add(jb5);

		ArrayList<String> car = new ArrayList<String>();

		ArrayList<ArrayList<String>> buy_car = new ArrayList<ArrayList<String>>();
		// 快捷填入购买信息
		JComboBox<String> jbox34 = new JComboBox<String>();
		// 下拉列表中加入购买信息
		playerinf.add_fruitinf_quick(m, n, name, nima, jbox34);

		jbox34.setBounds(60, 610, 120, 50); // 快捷输入
		jp.add(jbox34);

		JButton jb11 = new JButton("快捷填入");
		jb11.setBounds(60, 690, 100, 50); // 快捷输入确定
		jp.add(jb11);
		// 写入快捷填入选择的
		playerinf.write_want_buy(text1, jbox34, jb11);

		// 创建你的购物车集合
		playerinf.shopcar(m, n, name, nima, buy_car);

		text5.setText("0");
		// 按钮监听
		// 监听加入购物车
		playerinf.addcar(area2, area1, text1, text2, text5, text6, jb2, car,
				buy_car, m, n, name, nima);
		// 监听移出购物车
		playerinf.remove(area2, area1, text1, text2, text5, jb4, buy_car, m, n,
				name, nima);
		// 监听总览购物车
		playerinf.listen_car(area2, jb_all, buy_car, m, n, name, nima);
		// 监听闭店
		playerinf.over_shop(m, n, name, nima, jf, text7, jb5, name2, name3);
		// 监听结束购物
		playerinf.over(area2, text5, text6, jb3, buy_car, m, n, name, nima, jf,
				text7, text8, name2, name3);
		// 监听刷新商店
		playerinf.new_shop(m, n, name, nima, jb_new, area1, name2);
		// 显示水果信息
		area1.append("名称         售价           库存量                 单位" + "\r\n"); // 标题
		playerinf.fruitinf(m, n, name, nima, area1);
		// 导入欢迎图片
		JLabel jl211 = new JLabel();
		ImageIcon icon1 = new ImageIcon("q5.png");
		// 设置图片大小
		Image im1 = icon1.getImage();
		im1 = im1.getScaledInstance(800, 1000, Image.SCALE_DEFAULT);
		icon1.setImage(im1);
		jl211.setIcon(icon1);
		jl211.setBounds(0, 0, 1600, 1000);
		// 帮助
		playerinf.help(jf, item_3, area1);
		// 关闭窗体时清空数据库
		playerinf.close_sql1(m, n, name, nima, jf);
		jp.add(jl211);

		area2.append("\r\n" + "选完东西一定要买单！！！！！！！！！！！！" + "\r\n");

		String money = text4.getText();
		jf.setResizable(false);

		jf.add(jp);
		String money1 = text4.getText(); // 你的钱
		// 检测提示是否为数字
		playerinf.domoney(m, n, name, nima, name2, jf, money1, name3);

		// 别找了没有设置窗体可见

	}

}
