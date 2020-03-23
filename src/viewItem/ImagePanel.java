/*
 * Created by JFormDesigner on Sun Mar 15 22:05:17 CST 2020
 */

package viewItem;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author unknown
 */
public class ImagePanel extends JPanel {
    //传了url的话其实这里可以注释掉了，姑且留着吧
    public ImagePanel(String imageName) throws IOException {
        URL imgUrl = ImagePanel.class.getResource("/img/"+imageName);
        System.out.println(imgUrl);
        if(imgUrl!=null){
            imgurl = imgUrl;
            System.out.println("imgurl"+imgurl);
        }else {
            imgUrl = ImagePanel.class.getResource("/img/default.jpg");
            imgurl = imgUrl;
            if (imgUrl!=null){
                JOptionPane.showMessageDialog(null,"default.jpg文件丢失！");
            }
        }

    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(10,20,30,40);
        try {
            Image image = ImageIO.read(this.imgurl);
            g2d.drawImage(image,0,0,400,500,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    private Image img;

    public URL getImgurl() {
        return imgurl;
    }

    public void setImgurl(URL imgurl) {
        this.imgurl = imgurl;
    }

    private URL imgurl;


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
