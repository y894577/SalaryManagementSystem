import javax.swing.*;

import People.User;
import viewItem.*;

import java.awt.*;
import java.net.URL;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
//        JFrame a = new JFrame();
//        UserManager b = new UserManager();
//        JLabel c = new JLabel("abc");
//        a.setSize(250,250);
//        a.add(b, BorderLayout.NORTH);
//        UserTree b = new UserTree();
//        a.add(b);
//        a.setVisible(true);
        User user = new User();
        LoginView a = new LoginView();
        a.setTitle("用户薪酬管理系统");
        a.setVisible(true);
//        showImg a = new showImg("123456");
//        a.setVisible(true);
//        URL imgUrl = ImagePanel.class.getResource("/img/"+"123456.jpg");
//        JFrame a = new JFrame();
//        JPanel b = new JPanel();
//        Image c = Toolkit.getDefaultToolkit().getImage(imgUrl);
//        c.getGraphics().drawImage(c, 0,0,b);
//        a.add(b);
//        a.setVisible(true);
    }
}
