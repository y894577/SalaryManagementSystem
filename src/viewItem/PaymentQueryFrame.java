/*
 * Created by JFormDesigner on Thu Mar 19 15:15:32 CST 2020
 */

package viewItem;

import Dao.UserDao;
import People.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author unknown
 */
public class PaymentQueryFrame extends JPanel {
    public PaymentQueryFrame(String flag, User user) throws SQLException {
        initComponents();
        splitPane1.setLeftComponent(new myTree());
        splitPane1.setRightComponent(new PaymentDetailView("user", user));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        splitPane1 = new JSplitPane();

        //======== this ========

        setLayout(new BorderLayout());
        add(splitPane1, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    class myTree extends UserTree {
        public myTree() throws SQLException {
        }

        @Override
        public void leftNodeSelected(DefaultMutableTreeNode node) throws SQLException, ClassNotFoundException {
            User user = new UserDao().getUser(node.toString());
            System.out.println("叶子节点被选中了！");
            splitPane1.setRightComponent(new PaymentDetailView("user", user));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                splitPane1.setLeftComponent(new myTree());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JSplitPane splitPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
