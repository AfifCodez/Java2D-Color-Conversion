/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package color.conversion;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.IOException;
import java.io.File;
import javax.imageio.*;
import java.awt.image.ColorConvertOp;
import java.awt.color.ColorSpace;


/**
 *
 * 
 */
public class ColorConversion extends JApplet{
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame=new JFrame();
        frame.setTitle("hello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet applete =new ColorConversion();
        applete.init();
        frame.getContentPane().add(applete);
        frame.pack();
        frame.setVisible(true);
    }
    public void init(){
        JPanel panel=new JApp1Panel();
        getContentPane().add(panel);
    }
    
}
class JApp1Panel extends JPanel{
     BufferedImage img; 
public JApp1Panel(){
    setPreferredSize(new Dimension(640,480));
    try { 
            img = ImageIO.read(new File("parrot1.png")); 
        } catch (IOException e) {    System.out.println("error loading file");   }     

}
public void paintComponent(Graphics g){
float[] data = {0f, -1f, 0f, -1f, 4f, -1f, 0f, -1f, 0f};
super.paintComponent(g);
Graphics2D g2=(Graphics2D) g;

        g.drawImage(img, 350, 0, null);
        
       ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY); 
       ColorConvertOp op = new ColorConvertOp(cs, null); 
       BufferedImage dstImage=op.filter(img, null);

        
        g2.drawImage(dstImage, img.getWidth(),img.getHeight(), this);
        
}

}// end of JApp1Panel class
