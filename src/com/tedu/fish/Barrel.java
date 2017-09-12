package com.tedu.fish;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by SmallK on 2017/9/6.
 */
public class Barrel {
    private BufferedImage barrel;
    private double rotate;
    private int width;
    private int height;
    private int X;
    private int Y;

    public BufferedImage getBarrel() {
        return barrel;
    }

    public double getRotate() {
        return rotate;
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

    public void setRotate(double rotate) {
        this.rotate = rotate;
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public Barrel(){
        try {
            this.barrel = ImageIO.read(new File("./images/barrel.png"));
            this.width = barrel.getWidth();
            this.height = barrel.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
