package com.tedu.fish;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by SmallK on 2017/9/6.
 */
public class Pool extends JComponent{
    BufferedImage backgroundImg;
    BufferedImage bottomBar;
    Barrel barrel;
    Fish[] fishes;
    ArrayList<Bullet> bullets = new ArrayList<>();
    FishNet net ;
    Fish fish;
    int count = 0;
    int mouseX,mouseY;
    double radian;
    int rotateCenterX,rotateCenterY;

//    static final int DEFAULT_WIDTH = 800;
//    static final int DEFAULT_HEIGHT = 640;


    public Pool(){
        try {
            backgroundImg = ImageIO.read(new File("./images/bg.jpg"));
            bottomBar = ImageIO.read(new File("./images/bottom-bar.png"));
            barrel = new Barrel();
            barrel.setX(bottomBar.getWidth()/2 + 25);
            barrel.setY(backgroundImg.getHeight() - bottomBar.getHeight() + 10);
            fishes = new Fish[10];
            net = new FishNet();
            for (int i = 0; i < fishes.length; i++) {
                fishes[i] = new Fish((int)(11 * Math.random() + 1));
                fishes[i].start();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取图片失败");
        }
    }


    @Override
    public void paint(Graphics g) {
        /**
         * 1 图片对象
         * 2 3 图片坐标 图片左上角坐标
         * 4 5 图片宽高
         * 6 null
         */
        // 绘画静态效果
        g.drawImage(backgroundImg, 0, 0,backgroundImg.getWidth(),backgroundImg.getHeight(),null);
        g.drawImage(bottomBar, 0, backgroundImg.getHeight() - bottomBar.getHeight(),
                bottomBar.getWidth(),bottomBar.getHeight(),null);
//        g.drawImage(barrel.getBarrel(),bottomBar.getWidth()/2 + 25,backgroundImg.getHeight() - bottomBar.getHeight() + 10,
//                barrel.getWidth(),barrel.getHeight(),null);
        // 绘画动态效果
        // 绘画各条鱼的各个动画效果
        for (int i = 0; i < fishes.length; i++) {
            fish = fishes[i];
            g.drawImage(fish.getFishState(), fish.getX(), fish.getY(),
                    fish.getWidth(), fish.getHeight(), null);
        }
//        int x = net.getX() - net.getShape().getWidth()/2;
//        int y = net.getY() - net.getShape().getHeight()/2;
        // 绘画渔网
        if (net.isShow()) {
            g.drawImage(net.getShape(), net.getX(), net.getY(), net.getShape().getWidth(), net.getShape().getHeight(), null);
        }
        // 绘画旋转的准备
        Graphics2D graphics2D = (Graphics2D) g.create();
        rotateCenterX = barrel.getX() + barrel.getWidth()/2;
        rotateCenterY = barrel.getY() + barrel.getHeight()/2;
        double radianX = mouseX - rotateCenterX;
        double radianY = mouseY - rotateCenterY;
        radian = -Math.atan( radianX / radianY );
        // 绘画旋转的大炮
        graphics2D.rotate(radian, rotateCenterX, rotateCenterY);
        graphics2D.drawImage(barrel.getBarrel(),barrel.getX(), barrel.getY(),
                barrel.getWidth(),barrel.getHeight(),null);
        // 绘画旋转的子弹
        for (int i = 0; i < bullets.size(); i++){
            Bullet bullet = bullets.get(i);
            Graphics2D graphics2D1 = (Graphics2D) g.create();
//            System.out.println(bullet.getRadian()+ "," + rotateCenterX + "," + rotateCenterY);
            graphics2D1.rotate(bullet.getRadian(), rotateCenterX, rotateCenterY);
            graphics2D1.drawImage(bullet.getBulletImage(),bullet.getX(),bullet.getY(),bullet.getWidth(),bullet.getHeight(),null);
        }

    }

    public Dimension getPreferredSize(){
        return new Dimension(backgroundImg.getWidth(),backgroundImg.getHeight());
    }


    public void catchFish(){
        for (int i = 0; i < fishes.length; i++){
             fish = fishes[i];
            if (net.getCenterX() <= fish.getX() + fish.getWidth() && net.getCenterY() <= fish.getY() + fish.getHeight()
                    && net.getCenterX() > fish.getX() && net.getCenterY() > fish.getY()) {
                count++;
//                fish.struggle();
                fish.setLive(false);
            }
        }
    }

    public void reflash(){
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override //渔网显示
            public void mouseEntered(MouseEvent e) {
                    net.setShow(true);
            }

            @Override //渔网隐藏
            public void mouseExited(MouseEvent e) {
                    net.setShow(false);
            }

            @Override //渔网移动
            public void mouseMoved(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                net.moveTo(mouseX, mouseY);
            }

            @Override //渔网捕鱼  子弹捕鱼
            public void mousePressed(MouseEvent e) {
//                catchFish();
                Bullet bullet = new Bullet(Pool.this);
                bullet.setX(rotateCenterX - bullet.getWidth()/2);
                bullet.setY(rotateCenterY - bullet.getHeight()/2);
                bullet.setRadian(radian);
                System.out.println(bullet.getX() +","+bullet.getY() +","+bullet.getRadian());
                bullet.setA(bullet.getX());
                bullet.setB(bullet.getY());
                bullets.add(bullet);
                bullet.start();
            }
        };
        // 配套mouseAdapter使用
        this.addMouseListener(mouseAdapter);
        this.addMouseMotionListener(mouseAdapter);

        while (true){
            repaint();
        }
    }
}
