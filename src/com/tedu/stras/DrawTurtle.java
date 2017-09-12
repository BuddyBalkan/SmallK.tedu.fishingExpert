package com.tedu.stras;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by SmallK on 2017/9/5.
 */
public class DrawTurtle {
    public static void main(String[] args) {
        JFrame frame = new TrutleFrame();
        frame.setTitle("Draw-Trutle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
//        Frame frame = new Frame();
//        TrutlePanel panel = new TrutlePanel();
//
//        frame.setBackground(new Color(234,234,234));
//        frame.setSize(600,800);
//        frame.add(panel);
//        frame.setVisible(true);

    }
}
//class TrutlePanel extends Panel{
//    Color WenLu = new Color(60,63,65);
//    Color GuiBei = new Color(70,89,65);
//    Color RouSe = new Color(255,199,31);
//    Color YanZhu = new Color(18,18,18);
//
//    @Override
//    public void paint(Graphics g) {
//        /**
//         * 画四肢以及头
//         */
//        g.setColor(RouSe);
//        g.fillOval(260,100,80,100);//头
//        g.fillOval(100,200,75,75);//左上肢
//        g.fillOval(100,450,75,75);//left_bottom
//        g.fillOval(450,200,75,75);//right_top
//        g.fillOval(450,450,75,75);//right_bottom
//        /**
//         * 画尾巴
//         */
//        g.fillOval(260,100,80,100);//WeiBa_1
//
//        g.setColor(new Color(234,234,234));
//        g.fillOval();//WeiBa_2
//        /**
//         * 画龟背
//         */
//        g.setColor(GuiBei);
//        g.fillOval(125,175,180*2,400);
//        /**
//         * 画眼珠
//         */
//        g.setColor(YanZhu);
//        g.fillOval();//left_eye
//        g.fillOval();//right_eye
//        /**
//         * 画龟背纹路
//         */
//        g.setColor(WenLu);
//        g.drawLine();
//        g.drawLine();
//        g.drawLine();
//        g.drawLine();
//        g.drawLine();
//        g.drawLine();
//        g.drawLine();
//        g.drawLine();
//
//    }
//}
class TrutleFrame extends JFrame{
    public TrutleFrame(){
        add(new TrutleComponent());
        pack();
    }
}
class TrutleComponent extends JComponent{
    private static final int WIDTH = 600;
    private static final int HEIGHT = 800;
    private Color wenLu = new Color(60,63,65);
    private Color guiBeiSe = new Color(70,89,65);
    private Color rouSe = new Color(255,199,31);
    private Color yanZhu = new Color(18,18,18);
    private static int centerX = 300;
    private static int centerY = 400;
    private static int headCenterX = centerX;
    private static int headCenterY = 180;
    private static int limbsRadius = 45;



    public void paintComponent(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D) graphics;
        // 画龟背
        Ellipse2D guiBei = new Ellipse2D.Double(centerX - 100, centerY - 200,100 * 2,200*2);
        // 画头
        Ellipse2D head = new Ellipse2D.Double(headCenterX-200/6, headCenterY-400/6,200/3, 400/3);

        int testWidth = 164;
        int testHeight = 230;
//        Rectangle2D test = new Rectangle2D.Double(guiBei.getCenterX()-testWidth/2, guiBei.getCenterY()- testHeight/2, testWidth, testHeight);
        // 画四肢
        Ellipse2D left_top = new Ellipse2D.Double();
        left_top.setFrameFromCenter(centerX - testWidth/2,centerY - testHeight/2,
                centerX - testWidth/2 + limbsRadius, centerY - testHeight/2 + limbsRadius);
        Ellipse2D right_top = new Ellipse2D.Double();
        right_top.setFrameFromCenter(centerX + testWidth/2,centerY - testHeight/2,
                centerX + testWidth/2 + limbsRadius, centerY - testHeight/2 + limbsRadius);
        Ellipse2D left_bottom = new Ellipse2D.Double();
        left_bottom.setFrameFromCenter(centerX - testWidth/2,centerY + testHeight/2,
                centerX - testWidth/2 + limbsRadius, centerY + testHeight/2 + limbsRadius);
        Ellipse2D right_bottom = new Ellipse2D.Double();
        right_bottom.setFrameFromCenter(centerX + testWidth/2,centerY + testHeight/2,
                centerX + testWidth/2 + limbsRadius, centerY + testHeight/2 + limbsRadius);

        //画尾巴
        Ellipse2D tailEllipse = new Ellipse2D.Double(headCenterX - 200/3/2 + 15,
                centerY + centerY - headCenterY - 400/3 + 400/3/2 - 15, 200/3, 400/3);
        Ellipse2D tailShadow = new Ellipse2D.Double(tailEllipse.getCenterX() - 15,
                tailEllipse.getCenterY() - (tailEllipse.getHeight()/3) - 20,
                tailEllipse.getWidth()*2/3 + 4,tailEllipse.getHeight()*4/5 + 15);

        //画眼珠
        Ellipse2D leftEye = new Ellipse2D.Double();
        leftEye.setFrameFromCenter(head.getCenterX() - head.getWidth()/2*2/3, head.getCenterY(),
                head.getCenterX() - head.getWidth()/2*2/3 + 5,head.getCenterY() + 5);
        Ellipse2D rightEye = new Ellipse2D.Double();
        rightEye.setFrameFromCenter(head.getCenterX() + head.getWidth()/2*2/3, head.getCenterY(),
                head.getCenterX() + head.getWidth()/2*2/3 + 5,head.getCenterY() + 5);

        //画纹路
        Line2D top = new Line2D.Double(
                new Point2D.Double(guiBei.getCenterX() - guiBei.getWidth()/4 + 10,
                        guiBei.getCenterY() - guiBei.getHeight()/4 + 10),
                new Point2D.Double(guiBei.getCenterX() + guiBei.getWidth()/4 - 10,
                        guiBei.getCenterY() - guiBei.getHeight()/4 + 10)
        );

        Line2D bottom = new Line2D.Double(
                new Point2D.Double(guiBei.getCenterX() - guiBei.getWidth()/4,
                        guiBei.getCenterY() + guiBei.getHeight()/4 - 10),
                new Point2D.Double(guiBei.getCenterX() + guiBei.getWidth()/4,
                        guiBei.getCenterY() + guiBei.getHeight()/4 - 10)
        );
        Line2D leftTop = new Line2D.Double(
                new Point2D.Double(left_top.getCenterX(),left_top.getCenterY()),
                new Point2D.Double(top.getX1(),top.getY1())
        );
        Line2D rightTop = new Line2D.Double(
                new Point2D.Double(right_top.getCenterX(),right_top.getCenterY()),
                new Point2D.Double(top.getX2(),top.getY2())
        );
        Line2D leftBottom = new Line2D.Double(
                new Point2D.Double(left_bottom.getCenterX(),left_bottom.getCenterY()),
                new Point2D.Double(bottom.getX1(),bottom.getY1())
        );
        Line2D rightBottom = new Line2D.Double(
                new Point2D.Double(right_bottom.getCenterX(),right_bottom.getCenterY()),
                new Point2D.Double(bottom.getX2(),bottom.getY2())
        );
        Line2D left = new Line2D.Double(
                new Point2D.Double(top.getX1(),top.getY1()),
                new Point2D.Double(bottom.getX1(),bottom.getY1())
        );
        Line2D right = new Line2D.Double(
                new Point2D.Double(top.getX2(),top.getY2()),
                new Point2D.Double(bottom.getX2(),bottom.getY2())
        );


        graphics2D.setColor(rouSe);
        graphics2D.draw(head);
//        graphics2D.draw(test);
        graphics2D.draw(left_top);
        graphics2D.draw(right_top);
        graphics2D.draw(left_bottom);
        graphics2D.draw(right_bottom);
        graphics2D.draw(tailEllipse);
        graphics2D.fill(head);
        graphics2D.fill(left_top);
        graphics2D.fill(left_bottom);
        graphics2D.fill(right_top);
        graphics2D.fill(right_bottom);
        graphics2D.fill(tailEllipse);
        graphics2D.setColor(TrutleComponent.this.getBackground());
        graphics2D.draw(tailShadow);
        graphics2D.fill(tailShadow);
        graphics2D.setColor(guiBeiSe);
        graphics2D.draw(guiBei);
        graphics2D.fill(guiBei);
        graphics2D.setColor(yanZhu);
        graphics2D.draw(leftEye);
        graphics2D.draw(rightEye);
        graphics2D.fill(leftEye);
        graphics2D.fill(rightEye);
        graphics2D.setColor(wenLu);
        graphics2D.setStroke(new BasicStroke(8,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
        graphics2D.draw(top);
        graphics2D.draw(rightTop);
        graphics2D.draw(leftTop);
        graphics2D.draw(leftBottom);
        graphics2D.draw(bottom);
        graphics2D.draw(rightBottom);
        graphics2D.draw(right);
        graphics2D.draw(left);


    }

    public Dimension getPreferredSize(){
        return new Dimension(WIDTH,HEIGHT);
    }
}
