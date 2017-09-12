package com.tedu.fish;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by SmallK on 2017/9/6.
 */
public class Bullet extends Thread{
    private BufferedImage bulletImage;
    private int width;
    private int height;
    private int X;
    private int Y;
    private double rorate;

    public Bullet(){
        try {
            bulletImage = ImageIO.read(new File("./images/bullet1.png"));
            width = bulletImage.getWidth();
            height = bulletImage.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getBulletImage() {
        return bulletImage;
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

    public void setX(int x){
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y){
        Y = y;
    }

    public double getRorate() {
        return rorate;
    }

    public void setRorate(double rorate) {
        this.rorate = rorate;
    }

    @Override
    public void run() {
        while (true){
            try {
                Y-=10;
                Thread.sleep(24);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
