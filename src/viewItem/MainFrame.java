/*
 * Created by JFormDesigner on Fri Mar 13 20:03:54 CST 2020
 */

package viewItem;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.sql.SQLException;

import People.User;
import viewItem.*;

/**
 * @author unknown
 */
public class MainFrame extends JFrame {
    public MainFrame(User user) throws SQLException, ClassNotFoundException {

        initComponents(user);
    }

    private void initComponents(User user) throws SQLException, ClassNotFoundException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        main = new JTabbedPane();
        userInfo = new UserInfoViewFrame(user);
        searchSalary = new PaymentQueryFrame("user", user);
        paySalary = new ModifyParametersView(user);
        manageUser = new UserManager();

        //======== this ========
        var contentPane = getContentPane();
        setTitle("用户薪酬管理系统");

        //======== main ========
        {

            //======== userInfo ========
//
            main.addTab("\u7528\u6237\u4fe1\u606f", userInfo);

            //======== searchSalary ========

            main.addTab("\u5de5\u8d44\u67e5\u8be2", searchSalary);

            //======== paySalary ========

            main.addTab("\u5de5\u8d44\u53d1\u653e", paySalary);

            //======== manageUser ========

            main.addTab("\u7528\u6237\u7ba1\u7406", manageUser);

            main.setSelectedIndex(0);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(main)
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(main)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTabbedPane main;
    private UserInfoViewFrame userInfo;
    private JPanel searchSalary;
    private JPanel paySalary;
    private JPanel manageUser;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
