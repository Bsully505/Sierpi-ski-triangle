import java.awt.*;
import java.util.Random;

public class RecurrsedTriangle {
    int x;
    int y;
    int len;
    double theta;
    Graphics g;
    RecurrsedTriangle(Graphics g,int x,int y, int len,double theta){
        this.g = g;
        this.x = x;
        this.y= y;
        this.len = len;
        this.theta = theta;

    }

    public void draw(Graphics g,int x, int y,int len,double theta,Boolean UpsideDown){

      Color pen = new Color((float)(Math.random()),
                (float)(Math.random()),
                (float)(Math.random()));
        if(len< 25){
            return;
        }


        //draw base line
        Point startPos= new Point(x,y);

        //get the point to the right

        //changing the second point to be the top
        double x2 = startPos.x+ (Math.cos(theta)*len);
        double y2 = startPos.y +(Math.sin(theta)*len);
        double newtheta = theta + ((2 * Math.PI) / 3);
        if(UpsideDown) {
             newtheta = theta - ((2 * Math.PI) / 3);
        }
        double halfLen = len/2;
        double x3 = x2+ (Math.cos(newtheta)*len);
        double y3 = y2 +(Math.sin(newtheta)*len);
        //double x3= startPos.x+(len/2);
        //double y3= startPos.y- Math.sqrt( Math.pow(len,2)-Math.pow(halfLen,2));
        Point Right = new Point((int)x3,(int)y3);
        //determine the next point
        Point Top = new Point((int)x2,(int)y2);

        g.setColor(pen);
        g.drawLine(startPos.x,startPos.y,Top.x,Top.y);
        //Determine midpoint of first line and then minus 60 to the angle and restart
        int midX =(Top.x - startPos.x)/2;
        int midY = (Top.y -startPos.y)/2;
        if(UpsideDown) {
            draw(g, startPos.x + midX, startPos.y + midY, (int) halfLen, (theta - (Math.PI / 3)),false);
        }
        else{
            draw(g, startPos.x + midX, startPos.y + midY, (int) halfLen, (theta + (Math.PI / 3)),true);

        }
        g.setColor(pen);
        g.drawLine(Top.x,Top.y,Right.x,Right.y);

        int midX2 =((Right.x - Top.x)/2)+Top.x;
        int midY2 =((Right.y -Top.y)/2)+Top.y;

        if(UpsideDown) {
            draw(g,  midX2,  midY2, (int) halfLen, (newtheta - (Math.PI / 3)),false);
        }
        else{
            draw(g,  midX2,  midY2, (int) halfLen, (newtheta + (Math.PI / 3)),true);

        }

        g.setColor(pen);
        g.drawLine(Right.x,Right.y,startPos.x,startPos.y);

        int midX3 =((startPos.x - Right.x)/2)+Right.x;
        int midY3 =((startPos.y -Right.y)/2)+Right.y;

        if(UpsideDown) {
            draw(g,  midX3,  midY3, (int) halfLen, (theta + (Math.PI / 3)),false);
        }
        else{
            draw(g,  midX3,  midY3, (int) halfLen, (theta - (Math.PI / 3)),true);

        }



        //System.out.println("Distance From Start Point to Top Point"+ Math.sqrt(Math.pow(Top.x-startPos.x,2)+Math.pow(Top.y-startPos.y,2)));
        //rotate direction 360/3 in radians and repeat
    }
    public void annimate(Graphics g,int i ){

        //determine h
        int factor = 100;

        int h = (int)((Math.sqrt(3)/2) *(this.len+(factor*13)));
        //Important to change if the amount of iterations changes
        //System.out.println("h equals "+ h);
        double dif = h/(30);
        //System.out.println("Y equal to "+ this.y+((int)((dif*i))));
        //change for y this.y+((factor*i)/((int)(Math.sqrt(factor))/4))
        // x = this.x-((factor*i)/2)
        double difx = ((this.len+(factor*i))/4);
        System.out.println("This is the x end "+(this.x-difx));
        //draw(g,this.x-(int)(difx),this.y+(int)((dif*i)),this.len+(factor*i),this.theta,false);
        draw(g,this.x,this.y,this.len+(factor*i),this.theta,false);



    }
}
