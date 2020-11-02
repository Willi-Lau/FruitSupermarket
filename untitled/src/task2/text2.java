package task2;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class text2 {
    public static void main(String[] args)  {
//        Java 正则表达式和 Perl 的是最为相似的。
//        java.util.regex 包主要包括以下三个类：
//        Pattern 类：
//        pattern 对象是一个正则表达式的编译表示。Pattern 类没有公共构造方法。要创建一个 Pattern 对象，你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象。该方法接受一个正则表达式作为它的第一个参数。
//        Matcher 类：
//        Matcher 对象是对输入字符串进行解释和匹配操作的引擎。与Pattern 类一样，Matcher 也没有公共构造方法。你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象。
//        PatternSyntaxException：
//        PatternSyntaxException 是一个非强制异常类，它表示一个正则表达式模式中的语法错误。

        String line = "apple banana coco";

        String pattern = "[a-z]+";
        //进行条件输出 输出所有的单词
        Matcher m = Pattern.compile(pattern).matcher(line);
        while (m.find()) {
            System.out.println(m.group());

        }


    }


}


