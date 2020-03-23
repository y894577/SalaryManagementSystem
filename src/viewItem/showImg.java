/*
 * Created by JFormDesigner on Mon Mar 16 22:57:31 CST 2020
 */

package viewItem;

import javafx.stage.FileChooser;
import tool.UpLoad;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class showImg extends JDialog implements ActionListener {

    private String userID;

    public showImg(String userID) throws IOException {
        this.userID = userID;
        initComponents();
        //创建文件夹
        String path = showImg.class.getResource("/").getPath() + "img";
        File f = new File(path);
        f.mkdir();

        contentPanel = new ImagePanel(userID + ".jpg");
        update.addActionListener(this);
        setBounds(0, 0, 400, 530);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        dialogPane = new JPanel();
//        contentPanel = new ImagePanel();
        buttonBar = new JPanel();
        textField1 = new JTextField();
        update = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[]{0, 85, 80};
                ((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[]{1.0, 0.0, 0.0};
                buttonBar.add(textField1, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- update ----
                update.setText("\u66f4\u65b0\u56fe\u50cf");
                buttonBar.add(update, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel dialogPane;
    private ImagePanel contentPanel;
    private JPanel buttonBar;
    private JTextField textField1;
    private JButton update;

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("请选择jpg图片");
        int result = jfc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fFrom = jfc.getSelectedFile();
            String fromPath = fFrom.getAbsolutePath();
            textField1.setText(fromPath);
            String toPath;
            URL imgPath = showImg.class.getResource("/img/");
            if (imgPath == null) {
                String path = showImg.class.getResource("/").getPath() + "img";
                File f = new File(path);
                f.mkdir();
            }
            toPath = showImg.class.getResource("/img/").getPath() + userID + ".jpg";
            int state = UpLoad.UpLoad(fromPath, toPath);
            URL imgUrl = ImagePanel.class.getResource("/img/" + userID + ".jpg");
            if (state == 1) {
//                contentPanel.setImg(Toolkit.getDefaultToolkit().getImage(fromPath));
//                这里是个坑...线程优先级问题
//                传img显示不了图片...只能传url用IO流显示了.......
                contentPanel.setImgurl(imgUrl);
                contentPanel.paint(super.getGraphics());

            } else {
                JOptionPane.showMessageDialog(null, "上传失败");
            }
        }
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
