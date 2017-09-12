package com.tedu.test;

import javax.swing.*;

/**
 * Created by SmallK on 2017/9/5.
 */
public class Test {
    public static void main(String[] args){
        /**
         * 创建
         */
        // 创建一个窗体 JFrame
        JFrame frame = new JFrame();
        // 创建一个面板
        JPanel panel = new JPanel();
        // 标签 主要用来显示文字
        JLabel label = new JLabel("欢迎游玩 祝您捕鱼愉快");
        // ImageIcon 用图标显示图片 该图片以图标的形式显示
        JLabel imageTest = new JLabel(new ImageIcon("./images/fish08_00.png"));
        // 按钮
        JButton button = new JButton("我是个按钮");

        // 设置窗体的不可改变
        frame.setResizable(false);
        // 设置窗体的标题
        frame.setTitle("捕鱼达人 of SmallK");
        // 设置窗体大小
        frame.setSize(1500, 900);
        // 设置窗体位置 距离左边的距离，距离顶部的距离
        frame.setLocation(150, 50);
        // 当关闭窗体的时候，Java运行的后台也关闭。
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗体可见 默认不可见
        frame.setVisible(true);

        // 将标签添加到面板
        panel.add(label);
        panel.add(imageTest);
        panel.add(button);
        // 将面板添加到窗体
        frame.add(panel);
    }
}
