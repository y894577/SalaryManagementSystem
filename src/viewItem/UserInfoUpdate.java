/*
 * Created by JFormDesigner on Sun Mar 15 17:33:52 CST 2020
 */

package viewItem;

import Dao.UserDao;
import People.User;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;

import static javax.swing.JOptionPane.*;

/**
 * @author unknown
 */
public class UserInfoUpdate extends JPanel {
    public UserInfoUpdate(User user) {
        initComponents(user);
        //用户信息初始化
        ID.setText(user.getUserID());
        name.setText(user.getUserName());
        pwd.setText(user.getUserPwd());
        setCheckBoxValue(isFullTime,user.getFullTime());
        setCheckBoxValue(isTeaching,user.getTeaching());
        setCheckBoxValue(isManager,user.getManager());
        setComboBoxValue(department,user.getDepartment());
        setComboBoxValue(title,user.getTitle());
        setComboBoxValue(position,user.getPosition());
    }

    private void updateActionPerformed(ActionEvent e) throws SQLException {
        // TODO add your code here
        User user = new User();
        user.setUserID(ID.getText());
        user.setUserName(name.getText());
        user.setUserPwd(pwd.getText());
        user.setPosition(position.getSelectedItem().toString());
        user.setDepartment(department.getSelectedItem().toString());
        user.setPosition(position.getSelectedItem().toString());
        user.setTitle(title.getSelectedItem().toString());
        user.setFullTime(new String(String.valueOf(isFullTime.isSelected())));
        user.setTeaching(new String(String.valueOf(isTeaching.isSelected())));
        user.setManager(new String(String.valueOf(isManager.isSelected())));
        user.setAdmin("false");

        UserDao dao = new UserDao();
        int n = dao.updateUser(user);
        if (n == 1)
            showMessageDialog(null, "更新用户成功！", "Success", OK_OPTION);
        else
            showMessageDialog(null, "更新用户失败！", "Fail", WARNING_MESSAGE);
    }

    private void createuserActionPerformed(ActionEvent e) {
        // TODO add your code here

    }

    private void imageActionPerformed() throws IOException {
        // TODO add your code here
        showImg img = new showImg(ID.getText());
        img.setVisible(true);
    }


    private void initComponents(User user) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        ID = new JTextField();
        label2 = new JLabel();
        name = new JTextField();
        label3 = new JLabel();
        pwd = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        isFullTime = new JCheckBox();
        isTeaching = new JCheckBox();
        isManager = new JCheckBox();
        department = new JComboBox<>();
        title = new JComboBox<>();
        position = new JComboBox<>();
        update = new JButton();
        image = new JButton();

        //======== this ========
//        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
//        border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER
//        , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font
//        .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
//        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order"
//        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- label1 ----
        label1.setText("\u7f16\u53f7");
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));

        //---- label2 ----
        label2.setText("\u59d3\u540d");
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));

        //---- label3 ----
        label3.setText("\u5bc6\u7801");
        label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));

        //---- label4 ----
        label4.setText("\u804c\u52a1");
        label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));

        //---- label5 ----
        label5.setText("\u90e8\u95e8");
        label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));

        //---- label6 ----
        label6.setText("\u804c\u79f0");
        label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));

        //---- isFullTime ----
        isFullTime.setText("\u662f\u5426\u4e3a\u5168\u804c\u6559\u5e08");
        isFullTime.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));

        //---- isTeaching ----
        isTeaching.setText("\u662f\u5426\u4ece\u4e8b\u6559\u5b66\u5de5\u4f5c");
        isTeaching.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));

        //---- isManager ----
        isManager.setText("\u662f\u5426\u4ece\u4e8b\u7ba1\u7406\u5de5\u4f5c");
        isManager.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));

        //---- department ----
        department.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u5b66\u9662\u9886\u5bfc",
            "\u8f6f\u4ef6\u5de5\u7a0b\u7cfb",
            "\u8ba1\u7b97\u673a\u57fa\u7840\u90e8",
            "\u6570\u5b66\u6559\u5b66\u90e8",
            "\u5b66\u9662\u529e\u516c\u5ba4",
            "\u5b66\u9662\u5b9e\u9a8c\u4e2d\u5fc3",
            "\u79bb\u804c\u9000\u4f11\u4eba\u5458"
        }));

        //---- title ----
        title.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u6559\u6388",
            "\u526f\u6559\u6388",
            "\u8bb2\u5e08",
            "\u52a9\u6559",
            "\u5176\u4ed6\u4eba\u5458"
        }));

        //---- position ----
        position.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u9662\u957f/\u4e66\u8bb0",
            "\u526f\u9662\u957f/\u526f\u4e66\u8bb0",
            "\u7cfb\\\u90e8\\\u4e2d\u5fc3\u4e3b\u4efb",
            "\u7cfb\\\u90e8\\\u4e2d\u5fc3\u526f\u4e3b\u4efb",
            "\u5176\u4ed6"
        }));

        //---- update ----
        update.setText("\u66f4\u65b0\u7528\u6237\u4fe1\u606f");
        update.addActionListener(e -> {
            try {
                updateActionPerformed(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        //---- image ----
        image.setText("\u66f4\u65b0\u7528\u6237\u5934\u50cf");
        image.addActionListener(e -> {
            try {
                imageActionPerformed();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup()
                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(name, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                            .addComponent(ID, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(pwd, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                                .addComponent(isFullTime)
                                .addComponent(isManager))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(title, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(department, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(position, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(update)
                                        .addComponent(image)))))
                        .addComponent(isTeaching))
                    .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(department, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(pwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                            .addComponent(position, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(update)
                            .addGap(18, 18, 18)
                            .addComponent(image))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(isFullTime)
                            .addGap(14, 14, 14)
                            .addComponent(isManager)
                            .addGap(14, 14, 14)
                            .addComponent(isTeaching)))
                    .addContainerGap(17, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void setCheckBoxValue(JCheckBox ckb, String value) {
        if (value.equals("true")){
            ckb.setSelected(true);
        }else {
            ckb.setSelected(false);
        }
    }

    private void setComboBoxValue(JComboBox<String> cmb, String value) {
        int n = cmb.getItemCount();
        for (int i = 0; i < n; i++) {
            String str = cmb.getItemAt(i).toString();
            if(str.equals(value)){
                cmb.setSelectedIndex(i);
                break;
            }
        }
    }





    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField ID;
    private JLabel label2;
    private JTextField name;
    private JLabel label3;
    private JTextField pwd;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JCheckBox isFullTime;
    private JCheckBox isTeaching;
    private JCheckBox isManager;
    private JComboBox<String> department;
    private JComboBox<String> title;
    private JComboBox<String> position;
    private JButton update;
    private JButton image;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
