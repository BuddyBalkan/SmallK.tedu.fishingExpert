package com.tedu.fish;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by SmallK on 2017/9/6.
 */
public class FishNet {
    private BufferedImage shape;
    private int X;
    private int Y;
    private boolean isShow = false;

    public FishNet(){
        try {
            shape = ImageIO.read(new File("./images/net09.png"));
            X = (int)(Math.random() * (800 - shape.getWidth()));
            Y = (int)(Math.random() * (640 - shape.getHeight() - 70));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getShape() {
        return shape;
    }

    public int getX() {
        return X;
    }
    public int getCenterX(){
        return getX() + shape.getWidth()/2;
    }

    public int getY() {
        return Y;
    }
    public int getCenterY(){
        return getY() + shape.getHeight()/2;
    }
    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public void moveTo(int mouseX, int mouseY){
        setX(mouseX - shape.getWidth()/2);
        setY(mouseY - shape.getHeight()/2);
    }

}
