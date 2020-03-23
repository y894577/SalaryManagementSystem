/*
 * Created by JFormDesigner on Sun Mar 15 15:00:42 CST 2020
 */

package viewItem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.tree.DefaultMutableTreeNode;

import Dao.UserDao;
import People.User;
import org.w3c.dom.Node;

/**
 * @author unknown
 */
public class UserInfoViewFrame extends JPanel {
    public UserInfoViewFrame(User user) throws SQLException {
        initComponents();
        splitPane1.setLeftComponent(new myTree());
        splitPane1.setRightComponent(new UserInfoView(user));
    }

    private void initComponents() throws SQLException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        splitPane1 = new JSplitPane();

        //======== this ========
        setLayout(new BorderLayout());
        add(splitPane1, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JSplitPane splitPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    class myTree extends UserTree {
        public myTree() throws SQLException {
        }

        @Override
        public void leftNodeSelected(DefaultMutableTreeNode node) throws SQLException, ClassNotFoundException {
            User user = new UserDao().getUser(node.toString());
            System.out.println("叶子节点被选中了！");
            splitPane1.setRightComponent(new UserInfoView(user));
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
}
