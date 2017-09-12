package com.tedu.fish;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Created by SmallK on 2017/9/6.
 */
public class Strat {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        Pool pool = new Pool();
        frame.setTitle("捕鱼达人 of SmallK");
//        frame.setSize(1500,900);
        frame.setLocation(150,50);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(pool);
        frame.pack();

        frame.setVisible(true);

        pool.reflash();
    }
}
