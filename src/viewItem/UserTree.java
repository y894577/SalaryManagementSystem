/*
 * Created by JFormDesigner on Fri Mar 13 19:18:55 CST 2020
 */

package viewItem;

import java.awt.*;
import java.awt.event.*;

import Dao.BaseDao;
import Dao.UserDao;
import People.User;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

/**
 * @author unknown
 */
public abstract class UserTree extends JPanel implements ActionListener, TreeSelectionListener {

    public JTree tree;

    public UserTree() throws SQLException {
        initComponents();
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("软件学院");
        DefaultMutableTreeNode dep1 = new DefaultMutableTreeNode("学院领导");
        DefaultMutableTreeNode dep2 = new DefaultMutableTreeNode("软件工程系");
        DefaultMutableTreeNode dep3 = new DefaultMutableTreeNode("计算机基础部");
        DefaultMutableTreeNode dep4 = new DefaultMutableTreeNode("数学教学部");
        DefaultMutableTreeNode dep5 = new DefaultMutableTreeNode("学院办公室");
        DefaultMutableTreeNode dep6 = new DefaultMutableTreeNode("学院实验中心");
        DefaultMutableTreeNode dep7 = new DefaultMutableTreeNode("离职退休人员");

        UserDao userDao = new UserDao();
        Vector<User> vectors = new Vector<User>();
        List userIDList = new ArrayList<>();
        vectors = userDao.getUsers(userIDList);
        for (User x : vectors) {
            switch (x.getDepartment()) {
                case "学院领导":
                    dep1.add(new DefaultMutableTreeNode(x.getUserID()));
                    break;
                case "软件工程系":
                    dep2.add(new DefaultMutableTreeNode(x.getUserID()));
                    break;
                case "计算机基础部":
                    dep3.add(new DefaultMutableTreeNode(x.getUserID()));
                    break;
                case "数学教学部":
                    dep4.add(new DefaultMutableTreeNode(x.getUserID()));
                    break;
                case "学院办公室":
                    dep5.add(new DefaultMutableTreeNode(x.getUserID()));
                    break;
                case "学院实验中心":
                    dep6.add(new DefaultMutableTreeNode(x.getUserID()));
                    break;
                case "离职退休人员":
                    dep7.add(new DefaultMutableTreeNode(x.getUserID()));
                    break;
            }
        }

        rootNode.add(dep1);
        rootNode.add(dep2);
        rootNode.add(dep3);
        rootNode.add(dep4);
        rootNode.add(dep5);
        rootNode.add(dep6);
        rootNode.add(dep7);

        tree = new JTree(rootNode);
        tree.addTreeSelectionListener(this);
        this.add(tree);
    }

//    private void freshActionPerformed(ActionEvent e) {
//        // TODO add your code here
//
//    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        fresh = new JButton();
        fresh.addActionListener(this);

        //======== this ========
        setLayout(new BorderLayout());

        //---- fresh ----
        fresh.setText("\u5237\u65b0");
        fresh.addActionListener(this);
        add(fresh, BorderLayout.SOUTH);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    //每个叶子节点都有不同的操作
    //定义不同的操作
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            try {
                leftNodeSelected(node);
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    public abstract void leftNodeSelected(DefaultMutableTreeNode node) throws SQLException, ClassNotFoundException;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton fresh;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
