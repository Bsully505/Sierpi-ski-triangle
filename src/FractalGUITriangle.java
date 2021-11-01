import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractalGUITriangle
    {

        private JFrame frame;
        private JPanel panel;
        private RecurrsedTriangle triangle;
        public Graphics g;

    public FractalGUITriangle() {

        frame = new JFrame();
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        int len = 600;
        int x = (int)(frame.getWidth()-((frame.getWidth()/2)+len/4));
        int y = (int)(frame.getHeight()- (len/2));
        System.out.println("x: "+ x);
        triangle = new RecurrsedTriangle(g,x,y,len,-Math.PI/3);


        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                //Draw Fractal
                g.setColor(Color.BLACK);
                //Determine the x and y from the length and the
                //triangle.draw(g,200,500,500,-Math.PI/3,false)

                //triangle.draw(g,x,y,len,-Math.PI/3,false);
            }
        };
        this.g = panel.getGraphics();
        panel.setBackground(Color.BLACK);
        Timer timer = new Timer(0,new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<15;i++){

                    panel.updateUI();
                    paint(i);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }


            }
        });
        timer.start();
        frame.add(panel);

    }
    public void paint(int i){

        panel.update(panel.getGraphics());
        triangle.annimate(panel.getGraphics(),i );







    }

        public static void main(String[] args){
        new FractalGUITriangle();

    }

}
