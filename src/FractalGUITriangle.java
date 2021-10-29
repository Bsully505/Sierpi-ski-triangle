import javax.swing.*;
import java.awt.*;

public class FractalGUITriangle
    {

        private JFrame frame;
        private JPanel panel;
        private RecurrsedTriangle triangle;

    public FractalGUITriangle() {
        triangle = new RecurrsedTriangle();
        frame = new JFrame();
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                //Draw Fractal
                g.setColor(Color.BLACK);
                triangle.draw(g,200,500,400,-Math.PI/3,false);
            }
        };
        panel.setBackground(Color.BLACK);
        frame.add(panel);
    }
        public static void main(String[] args){
        new FractalGUITriangle();

    }

}
