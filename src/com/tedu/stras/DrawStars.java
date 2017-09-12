package com.tedu.stras;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

/**
 * Created by SmallK on 2017/9/5.
 */
public class DrawStars {
    public static void main(String[] args){
        Frame frame = new Frame();
        MyPanel panel = new MyPanel();

        frame.setSize(1500, 800);
        frame.setBackground(new Color(43, 43, 43));
        frame.setVisible(true);
//        panel.repaint();
        frame.add(panel);
    }
}
// 自定义的空面板
class MyPanel extends Panel{
    // 使用方法paint()绘画 并使用Graphics画笔
    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(250, 250,187));
        for(int i =0; i < 750 ;i++){
            int x = (int)(1500 * Math.random());
            int y = (int)(800 * Math.random());
            g.drawString("·", x, y);
        }
        g.setColor(new Color(43,43,43));
        g.fillOval(100,150, 300, 300);

        g.setColor(new Color(250, 250,187));
        g.fillOval(175,225,150,150);

        g.setColor(new Color(43,43,43));
        g.fillOval(175,225, 100, 100);


    }
}