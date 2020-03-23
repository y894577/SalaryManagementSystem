/*
 * Created by JFormDesigner on Thu Mar 19 14:31:22 CST 2020
 */

package viewItem;

import Dao.DataDao;
import People.User;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import javax.xml.crypto.Data;
import java.sql.SQLException;

/**
 * @author unknown
 */
public class PaymentDetailView extends JPanel {
    private String sql;
    private String[][] t_date;

    public PaymentDetailView(String flag, User user) throws SQLException {
        //根据用户查询
        if ("user".equals(flag)) {
            sql = "select * from payment where userID = '" + user.getUserID() + "' order by datetime desc";
        } else if ("all".equals(flag)) {
            sql = "select * from payment order by userID,datetime desc ";
        } else {
            sql = "select * from payment where userID in(select userID from user where department = '" + flag + "')order by userID,datetime desc";
        }
        t_date = new DataDao().get_t_dates(this.sql);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========


        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                    t_date,
                    new String[]{
                            "\u7f16\u53f7", "\u5c97\u4f4d\u5de5\u8d44", "\u57fa\u7840\u6548\u7ee9", "课酬", "其他补助", "管理效绩", "\u65f6\u95f4", "\u603b\u548c"
                    }
            ));
            scrollPane1.setViewportView(table1);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
