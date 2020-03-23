/*
 * Created by JFormDesigner on Thu Mar 19 20:06:59 CST 2020
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
public class ModifyParametersView extends JPanel {
    public ModifyParametersView(User user) throws SQLException, ClassNotFoundException {
        initComponents();
        splitPane1.setRightComponent(new ModifyParameters(user));
        splitPane1.setLeftComponent(new myTree());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        splitPane1 = new JSplitPane();

        //======== this ========
//        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
//                0, 0, 0, 0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder
//                .BOTTOM, new java.awt.Font("Dia\u006cog", java.awt.Font.BOLD, 12), java.awt.Color.
//                red), getBorder()));
//        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
//            @Override
//            public void propertyChange(java.
//                                               beans.PropertyChangeEvent e) {
//                if ("\u0062ord\u0065r".equals(e.getPropertyName())) throw new RuntimeException();
//            }
//        });
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
            splitPane1.setRightComponent(new ModifyParameters(user));
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
