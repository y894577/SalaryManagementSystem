/*
 * Created by JFormDesigner on Fri Mar 13 09:51:07 CST 2020
 */

package viewItem;

import Dao.LoginDao;
import People.User;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class LoginView extends JFrame {
    public LoginView() {
        initComponents();
    }

    private void loginActionPerformed(ActionEvent e) throws SQLException, ClassNotFoundException {
        // TODO add your code here
        String userID = ID.getText();
        String userPwd = new String(pwd.getPassword()).trim();
        User user = new LoginDao().checkedUser(userID, userPwd);
        if (user != null) {
            MainFrame frame = new MainFrame(user);
            frame.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "该用户不存在！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        login = new JButton();
        label1 = new JLabel();
        ID = new JTextField();
        label2 = new JLabel();
        pwd = new JPasswordField();

        //======== this ========
        setTitle("Login");
        var contentPane = getContentPane();

        //======== dialogPane ========
        {
//            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
//            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
//                    swing.border.EmptyBorder(0, 0, 0, 0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax.swing.border
//                    .TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("D\u0069al\u006fg"
//                    , java.awt.Font.BOLD, 12), java.awt.Color.red), dialogPane.getBorder
//                    ()));
//            dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
//                @Override
//                public void propertyChange(java
//                                                   .beans.PropertyChangeEvent e) {
//                    if ("\u0062or\u0064er".equals(e.getPropertyName())) throw new RuntimeException
//                            ();
//                }
//            });
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- login ----
                login.setText("\u767b\u5f55");
                login.addActionListener(e -> {
                    try {
                        loginActionPerformed(e);
                    } catch (SQLException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                });

                //---- label1 ----
                label1.setText("\u7528\u6237ID");

                //---- label2 ----
                label2.setText("\u5bc6\u7801");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGap(146, 146, 146)
                                        .addComponent(login, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(147, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                        .addGap(63, 97, Short.MAX_VALUE)
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(label1)
                                                .addComponent(label2))
                                        .addGap(43, 43, 43)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(ID, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                                .addComponent(pwd, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                                        .addGap(76, 76, 76))
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label1)
                                                .addComponent(ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label2)
                                                .addComponent(pwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                        .addComponent(login)
                                        .addGap(40, 40, 40))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(dialogPane, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE)
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(dialogPane, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JButton login;
    private JLabel label1;
    private JTextField ID;
    private JLabel label2;
    private JPasswordField pwd;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
