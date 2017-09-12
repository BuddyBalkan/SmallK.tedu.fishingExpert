package com.tedu.test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by SmallK on 2017/9/6.
 */
public class Snowing {
    public static void main(String[] args){
        JFrame skyWindow;
        Sky sky = new Sky();
        skyWindow = new JFrame();
        skyWindow.setTitle("The Snowing Sky made by SmallK");
        skyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        skyWindow.setResizable(false);
        skyWindow.add(sky);
        skyWindow.pack();
        skyWindow.setVisible(true);
        sky.reflash();
    }
}
class Sky extends JComponent{
    private BufferedImage sky;
    private ArrayList<Snow> snows;

    public Sky(){
        try {
            sky = ImageIO.read(new File("./images/sky.jpg"));
            snows = new ArrayList<Snow>();
            int length = (int)(50 * Math.random());
            for (int i = 0; i <= length; i++) {
                snows.add(new Snow((int) (sky.getWidth() * Math.random()), -100 - new Snow().getHeight(),
                        (int) (10*Math.random() + 1)));
                snows.get(i).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(sky, 0, 0, sky.getWidth(), sky.getHeight(),null);
        for (int i = 0; i < snows.size(); i++) {
            g.drawImage(snows.get(i).getSnow(), snows.get(i).getX(), snows.get(i).getY(),
                    snows.get(i).getWidth(), snows.get(i).getHeight(), null);
        }
    }
    public Dimension getPreferredSize(){
        return new Dimension(sky.getWidth(),sky.getHeight());
    }

    public void reflash(){
        while (true){
            repaint();
        }
    }
}
class Snow extends Thread{
    private BufferedImage snow;
    private int width;
    private int height;
    private int X;
    private int Y;
    private int fallingSpeed;

    public Snow(int x, int y,int fallingSpeed){
        try {
            snow =  ImageIO.read(new File("./images/snow.png"));
            width = snow.getWidth();
            height = snow.getHeight();
            X = x;
            Y = y;
            this.fallingSpeed = fallingSpeed;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Snow(){
        try {
            snow =  ImageIO.read(new File("./images/snow.png"));
            width = snow.getWidth();
            height = snow.getHeight();
            fallingSpeed = (int) (10*Math.random() + 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getSnow() {
        return snow;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public void run() {
        while (true){
            Y+= fallingSpeed;
            if (Y >= 640){
                Y = -height;
                X = (int)((960 - width)*Math.random());
                fallingSpeed = (int) (10*Math.random() + 1);
            }
            try {
                Thread.sleep(24);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
