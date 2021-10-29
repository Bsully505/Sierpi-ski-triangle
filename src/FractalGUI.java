import com.sun.source.tree.Tree;
//for the _/\_

import javax.swing.*;
import java.awt.*;

//this will be very similar to sirpinsky triangle

// \ /
//  |
//draw half of the tree and then split in half and continue

//each iteration add a tree

//draw trunk with two smaller trees

//draw function

//recursive calls that draw

//things that can be changed
//the size of the trunk
//the angle of the recussive trees
//starting point and angle of the tree
public class FractalGUI {

    private JFrame frame;
    private JPanel panel;
    private FractalTree tree;

    public FractalGUI() {
        tree = new FractalTree(
                400,
                600,
                -Math.PI/2,
                800,
                0.5,
                Math.PI/3,
                Math.PI/3,
                2.0
        );
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
                tree.draw(g, 400,600,-Math.PI/2,400);
            }
        };
        panel.setBackground(Color.BLACK);
        frame.add(panel);
    }
        public static void main(String[] args){
            new FractalGUI();

    }
}
