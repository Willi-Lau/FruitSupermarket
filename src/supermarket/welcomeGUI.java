package supermarket;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class welcomeGUI {
	volatile static String exit = "";

	static void bbq(String m, String n, String name, String nima, String name2) {

		JFrame jf = new JFrame("SKP生鲜超市" + name2);
		jf.setBounds(100, 100, 800, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(new BorderLayout());
		jf.setResizable(false);

		// 添加登录界面，选择是游客登陆还是管理人员登录
		// 导入欢迎图片
		JLabel jl2 = new JLabel();
		ImageIcon icon = new ImageIcon("welcome.jpg");
		// 设置图片大小
		Image im = icon.getImage();
		im = im.getScaledInstance(800, 500, Image.SCALE_DEFAULT);
		icon.setImage(im);
		jl2.setIcon(icon);
		jl2.setBounds(0, 0, 800, 400);
		// 添加到主窗口

		JComboBox<String> go = new JComboBox<String>();
		go.addItem("游客登录");
		go.addItem("管理员登陆");

		// 按钮
		JButton jb_1 = new JButton("双击确定");
		// 按钮
		JButton jb_2 = new JButton("老板端");
		// 输入框
		JTextField field = new JTextField(15);
		// 提示
		// JLabel jl = new JLabel("随便输入");
		// 中间类
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);

		jb_1.setBounds(580, 410, 100, 40);
		go.setBounds(440, 410, 90, 40);
		 jb_2.setBounds(700, 410, 90, 40);

		panel_1.add(go);
		panel_1.add(jl2);
		// 提示
		JLabel jl0 = new JLabel("选择上班店员");
		jl0.setBounds(25, 410, 90, 40);
		panel_1.add(jl0);
		// danxuananniu，选择员工
		JRadioButton jr1 = new JRadioButton(name2 + "员工1");
		JRadioButton jr2 = new JRadioButton(name2 + "员工2");
		JRadioButton jr3 = new JRadioButton(name2 + "员工3");

		// JTextField text =new JTextField(10);
		jr1.setBounds(120, 410, 100, 40);
		jr2.setBounds(220, 410, 100, 40);
		jr3.setBounds(320, 410, 100, 40);
		ButtonGroup group = new ButtonGroup();
		group.add(jr1);
		group.add(jr2);
		group.add(jr3);

		panel_1.add(jr1);
		panel_1.add(jr2);
		panel_1.add(jr3);
		panel_1.add(jb_1);
		 panel_1.add(jb_2);

		jb_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name3 = "boss";
				Boss_GUI.boss(m, n, name, nima, name2,name3);
				jf.dispose();
			}
		});

		Thread a = new Thread(new Runnable() { // 员工1线程

					@Override
					public void run() {
						String name3 = "员工1";
						welcomeinf.go(m, n, name, nima, name2, jf, go, jb_1,
								name3);

					}
				});
		Thread b = new Thread(new Runnable() { // 员工2线程

					@Override
					public void run() {
						// 登陆
						String name3 = "员工2";
						welcomeinf.go(m, n, name, nima, name2, jf, go, jb_1,
								(String) name3);

					}
				});
		Thread c = new Thread(new Runnable() { // 员工3线程

					@Override
					public void run() {
						// 登陆
						String name3 = "员工3";
						welcomeinf.go(m, n, name, nima, name2, jf, go, jb_1,
								(String) name3);

					}
				});

		// 选择员工
		welcomeinf.choose_employee(m, n, name, nima, name2, jf, jb_1, jr1, jr2,
				jr3, a, b, c);

		jf.add(panel_1);
		// 关闭时把数据据请0
		welcomeinf.moneyis0(m, n, name, nima, jf);
		jf.setVisible(true);
		// Object select = jbox9.getSelectedItem();

		// return select;
	}

}
