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
    private double radian;
    private int a,b;
    private boolean isContinue = true;

    Pool pool;

    public Bullet(Pool pool){
        try {
            bulletImage = ImageIO.read(new File("./images/bullet1.png"));
            width = bulletImage.getWidth();
            height = bulletImage.getHeight();
            this.pool = pool;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isContinue() {
        return isContinue;
    }

    public void setContinue(boolean aContinue) {
        isContinue = aContinue;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {

        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
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

    public double getRadian() {
        return radian;
    }

    public void setRadian(double radian) {
        this.radian = radian;
    }

    @Override
    public void run() {
        while (isContinue()){
            try {
                setY( Y-10 );
                int r = getB() - getY();
                int xx = getA() + (int)(Math.sin(getRadian()) * r);
                int yy = getB() - (int)(Math.cos(getRadian()) * r);
                Fish[] fishes = pool.fishes;
                for (int i = 0; i < fishes.length; i++){
                    Fish fish = fishes[i];
                    if (xx >= fish.getX() && xx <= fish.getX() + fish.getWidth()
                            && yy >= fish.getY() && yy <= fish.getY() + fish.getHeight()){
                        fish.setLive(false);
                        pool.bullets.remove(this);
                        setContinue(false);
                    }
                }
                Thread.sleep(24);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
