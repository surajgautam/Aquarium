package aquarium;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;
import javax.swing.Timer;


public class Aquarium extends JPanel implements ActionListener{
    Random r = new Random();
   Timer t = new Timer(10, this);
   int x = 0, y= 30;
   int velX = 1 ,velY =1;
    private ImageIcon fish2image;
    private ImageIcon fish1image;
    ImageIcon image  = new ImageIcon(getClass().getResource("../res/aquarium.gif"));
    ImageIcon image1 = new ImageIcon(getClass().getResource("../res/smallFish.gif"));
    ImageIcon image2 = new ImageIcon(getClass().getResource("../res/new.gif"));
    Aquarium(){
     
    }
 
   @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        image.paintIcon(this, g, 0, 0);
    if (velX > 0) { // moving right when velocity is positive. 
        image1.paintIcon(this, g, x, y);
    } else { // moving left
        
        image2.paintIcon(this, g, x, y);

    }
        t.start();
    }
   @Override
    public void actionPerformed(ActionEvent e){
       if(x<0 || x>465){
        velX = -velX; //velocity is negative when x <0 and x >465 
        }
    x += velX;
    repaint();
}
    
    public static void main(String[] args) {
         Aquarium a = new Aquarium();
         
         JFrame f = new JFrame();
         
        f.setTitle("The Aquarium");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setBounds(500,200,500,300); //left,top,width,height 
        f.add(a);
        f.setVisible(true);
        
    }
}
