package supermarket;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.invoke.VolatileCallSite;
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

public class main_GUI_SQL {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		// 数据访问层基本信息

		String m = "com.mysql.jdbc.Driver"; // 建立连接基本信息
		String n = "jdbc:mysql://127.0.0.1:3306/fruit?characterEncoding=utf8"; // SQL连接具体信息
		String name = "root"; // SQL姓名
		String nima = "root"; // SQL密码

		// 进入程序
		main_inf.a(m, n, name, nima);
		// 杀光所有员工，一个不留
		main_inf.die_employee(m, n, name, nima);

				


	}

}


