package com.tedu.fish;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by SmallK on 2017/9/6.
 */
public class Fish extends Thread{
    private BufferedImage[] images = new BufferedImage[10];
    private int indexOfimages = 0;
//    private BufferedImage[] struggleImg = new BufferedImage[2];
    private BufferedImage struggleImg01;
    private BufferedImage struggleImg02;
    private BufferedImage fishState;


    private int width;
    private int height;

    private int X;
    private int Y;

    private int speed;

    private boolean isLive = true;


    public Fish(int type){
        try {
            reflash(type);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("图片读取有误");
        }

    }

    public void reflash(int type) throws IOException {
        String tmp ;
        if (type < 10){
            tmp = "0" + type;
        }else {
            Integer integer = type;
            tmp = integer.toString();
        }
        this.X = 800;
        this.speed = (int)(6 * Math.random() + 1);
        for (int i = 0; i < images.length; i++) {
            this.images[i] =(ImageIO.read(new File("./images/fish"+ tmp +"_0" + i + ".png")));
            this.struggleImg01 = ImageIO.read(new File("./images/fish" + tmp + "_catch_01.png"));
            this.struggleImg02 = ImageIO.read(new File("./images/fish" + tmp + "_catch_02.png"));
            this.width = this.images[i].getWidth();
            this.height = this.images[i].getHeight();
        }
        this.Y = (int)((480 - height - 70) * Math.random());
    }

    public void swing(){
        X -= speed;

        indexOfimages++;
        if (indexOfimages == 10){
            indexOfimages = 0;
        }
        fishState = images[getIndexOfimages()];
        try {
            // 判断该fish是否游出窗体 并重新进入池塘中 并且重新定义游速
            if (X <= -width) {
                reflash((int) (11 * Math.random() + 1));
            }
        } catch (IOException e) {
                e.printStackTrace();

        }
    }
    public void struggle(){
        try {
            for (int i = 0; i <= speed + 3;i++){
                fishState = struggleImg01;
                Thread.sleep(60);
                fishState = struggleImg02;
                Thread.sleep(60);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getFishState() {
        return fishState ;
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

    public int getIndexOfimages() {
        return indexOfimages;
    }


    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    @Override
    public void run() {
        while (true){
            try {
                if (isLive()) {
                    swing();
                }else {
                    struggle();
                    reflash((int) (11 * Math.random() + 1));
                    setLive(true);
                }
                Thread.sleep(60);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
