/*
 * Created by JFormDesigner on Thu Mar 19 20:06:31 CST 2020
 */

package viewItem;

import Dao.BaseDao;
import Dao.ParaDao;
import Dao.PaymentDao;
import People.Parameters;
import People.User;
import tool.MyTimer;

import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;

import static javax.swing.JOptionPane.*;

/**
 * @author unknown
 */
public class ModifyParameters extends JPanel {
    private User user;

    public ModifyParameters(User user) throws SQLException, ClassNotFoundException {
        this.user = user;
        initComponents();
        String sql = "select * from parameters where userID = '" + user.getUserID() + "'";
        List<String> list = new ArrayList<>();
        Vector<String> vector = BaseDao.select(sql, list);

        //初始化数值
        if (vector.get(7).equals("true"))
            calculate.setSelected(true);
        if (user.getTeaching().equals("true") && user.getManager().equals("true"))
            calculate.setEnabled(true);
        else
            calculate.setEnabled(false);
        ID.setText(vector.get(0));
        classNum.setText(vector.get(1));
        stuNum.setText(vector.get(2));
        living.setText(vector.get(3));
        title.setText(vector.get(4));
        phone.setText(vector.get(5));
        other.setText(vector.get(6));

    }

    private void changeActionPerformed() throws SQLException, ParseException {
        // TODO add your code here
        List<String> list = new ArrayList<>();
        Parameters parameters = new Parameters();
        parameters.setClassNum(Integer.parseInt(classNum.getText()));
        parameters.setStudentNum(Integer.parseInt(stuNum.getText()));
        parameters.setLivingPara(Float.parseFloat(living.getText()));
        parameters.setTitlePara(Float.parseFloat(title.getText()));
        parameters.setPhonePara(Float.parseFloat(phone.getText()));
        parameters.setOtherPara(Float.parseFloat(other.getText()));
        parameters.setCalculatePara(String.valueOf(calculate.isSelected()));
        parameters.setUser(user);
        int n = ParaDao.updateParameters(parameters, list);
        if (n == 1) {
            showMessageDialog(null, "更新参数成功！", "Success", OK_OPTION);
            //重新执行定时器
            new MyTimer(user, parameters);
        } else
            showMessageDialog(null, "更新参数失败！", "Fail", WARNING_MESSAGE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        calculate = new JCheckBox();
        living = new JTextField();
        title = new JTextField();
        phone = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        other = new JTextField();
        change = new JButton();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        classNum = new JTextField();
        stuNum = new JTextField();
        label8 = new JLabel();
        ID = new JTextField();

        //======== this ========
//        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
//                .EmptyBorder(0, 0, 0, 0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax.swing.border.TitledBorder.CENTER, javax
//                .swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dia\u006cog", java.awt.Font.BOLD,
//                12), java.awt.Color.red), getBorder()));
//        addPropertyChangeListener(new java.beans
//                .PropertyChangeListener() {
//            @Override
//            public void propertyChange(java.beans.PropertyChangeEvent e) {
//                if ("bord\u0065r".equals(e.
//                        getPropertyName())) throw new RuntimeException();
//            }
//        });

        //---- calculate ----
        calculate.setText("\u662f\u5426\u6309\u4e13\u4efb\u6559\u5e08\u5c97\u8ba1\u7b97\u5de5\u8d44");

        //---- label1 ----
        label1.setText("\u751f\u6d3b\u8865\u52a9");

        //---- label2 ----
        label2.setText("\u804c\u52a1\u8865\u52a9");

        //---- label3 ----
        label3.setText("\u7535\u8bdd\u8865\u52a9");

        //---- label4 ----
        label4.setText("\u5176\u4ed6\u8865\u52a9");

        //---- change ----
        change.setText("\u4fee\u6539\u53c2\u6570");
        change.addActionListener(e -> {
            try {
                changeActionPerformed();
            } catch (SQLException | ParseException ex) {
                ex.printStackTrace();
            }
        });

        //---- label5 ----
        label5.setText("\u6ce8\uff1a\u6bcf\u670810\u65e5\u81ea\u52a8\u53d1\u653e\u5de5\u8d44");
        label5.setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 10));

        //---- label6 ----
        label6.setText("\u5b66\u751f\u4eba\u6570");

        //---- label7 ----
        label7.setText("\u8bfe\u7a0b\u6570\u91cf");

        //---- label8 ----
        label8.setText("\u7f16\u53f7");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(label2)
                                                        .addComponent(label1)
                                                        .addComponent(label7))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(title, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                                        .addComponent(living, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                                        .addComponent(classNum, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup()
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(label3)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(phone, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup()
                                                                        .addComponent(label4)
                                                                        .addComponent(label6))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup()
                                                                        .addComponent(other, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(stuNum, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(label5)
                                                                        .addComponent(change)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup()
                                                        .addComponent(calculate)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(label8)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(ID, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label8)
                                        .addComponent(ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(calculate)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(living, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label1)
                                        .addComponent(label3)
                                        .addComponent(phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2)
                                        .addComponent(label4)
                                        .addComponent(other, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(classNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label7)
                                        .addComponent(label6)
                                        .addComponent(stuNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(change)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label5)
                                .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JCheckBox calculate;
    private JTextField living;
    private JTextField title;
    private JTextField phone;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField other;
    private JButton change;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JTextField classNum;
    private JTextField stuNum;
    private JLabel label8;
    private JTextField ID;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
