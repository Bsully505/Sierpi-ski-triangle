import java.awt.*;
import java.math.*;

public class FractalTree {
 private double startX,
         startY,
         startTheta,
         startLength,
         lengthChange,
         leftAngle,
         rightAngle,
         minimumLength;
    public FractalTree(
    
        double startX,
        double startY,
        double startTheta,
        double startLength,
        double lengthChange,
        double leftAngle,
        double rightAngle,
        double minimumLength)
    {
        this.startX = startX;
        this.startY = startY;
        this.startTheta = startTheta;
        this.startLength= startLength;
        this.lengthChange= lengthChange;
        this.leftAngle = leftAngle;
        this.rightAngle= rightAngle;
        this.minimumLength = minimumLength;

    }
    public void draw(Graphics g){
       draw(g,this.startX,this.startY,this.startTheta,this.minimumLength);
    }

    public void draw(Graphics g, double x1, double y1, double theta, double length){

        //base case
        if(length<2)
            return;

        //step 0.5 gets new coordanates
        double newLength = length/2;
        double x2 = x1 + (Math.cos(theta)*newLength);
        double y2 = y1 + (Math.sin(theta)*newLength);
        //draw the trunk
        g.setColor(new Color(
                (float)(Math.random()),
                (float)(Math.random()),
                (float)(Math.random())));
        g.drawLine((int)x1,(int)y1,(int)x2,(int)y2);



        //draw the branches
        draw(g,x2,y2,theta+Math.PI/3,newLength);
        draw(g,x2,y2,theta-Math.PI/3, newLength);
    }


}
