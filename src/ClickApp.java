import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;


public class ClickApp extends JFrame implements ActionListener{
    public Timer timer = new Timer (100, this);
    private JButton btClick = new JButton ("Click here!");
    private final int DIST = 20;
    private Dimension ssize = Toolkit.getDefaultToolkit().getScreenSize();


public ClickApp (){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    setTitle("The most annoying program. You are welcome");
    setBounds(ssize.width/2-200, ssize.height/2-150, 400, 300);
    setLayout(new FlowLayout());
    add(btClick);
    setVisible(true);
    timer.addActionListener(this);
    timer.start();
}

public void actionPerformed (ActionEvent e){
        moveButton();
        }

public void moveButton(){
    Point loc = btClick.getLocation();
    int direction = (int) (Math.random()*4);
    switch (direction){
        case 0:
            if (loc.y-DIST>=0)
                loc.y-=DIST; break;
        case 1:
            if (loc.x-DIST>=0)
                loc.x-=DIST; break;
        case 2:
            if (loc.x+btClick.getWidth()+DIST<=getContentPane().getWidth())
                loc.x+=DIST; break;
        case 3:
            if (loc.y+btClick.getHeight()+DIST<=getContentPane().getHeight())
                loc.y+=DIST; break;
    }
    btClick.setLocation(loc);
}

    public static void main(String[] args) {
        new ClickApp();
    }
}