package com.slamLine;


import cn.hutool.core.io.FileUtil;

import java.awt.*;
import java.io.File;
import java.io.FileFilter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.swing.*;

public class DrawLine extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        List<Position> positions = readLines();
        int[] xxx = new int[positions.size()];
        int[] yyy = new int[positions.size()];
        for (int i = 0; i < positions.size(); i++) {
            Position position = positions.get(i);
//            Position positionNext = positions.get(i + 1);
//            g.drawLine(position.x, position.y, positionNext.x, positionNext.y);

            xxx[i] = position.x;
            yyy[i] = position.y;
        }

//        g.drawLine(10, 10, 100, 100);
        g.drawPolygon(xxx, yyy, xxx.length-1);


    }

    public static void main(String[] args) {


        JFrame frame = new JFrame("Draw Line");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2000, 2000);
        DrawLine panel = new DrawLine();
        frame.add(panel);
        frame.setVisible(true);
    }

    private final static String dirPath = "/Users/shunlihan/Downloads/位姿错乱";

    private static List<Position> readLines() {
        List<File> files = FileUtil.loopFiles(new File(dirPath), new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().endsWith("_key.txt")) {
                    return true;
                }
                return false;
            }
        });

        File[] filesArray = files.toArray(new File[]{});
        Arrays.sort(filesArray, new Comparator<File>() {

            @Override
            public int compare(File o1, File o2) {
                float v1 = Float.parseFloat(o1.getName().replace("_key.txt", ""));
                float v2 = Float.parseFloat(o2.getName().replace("_key.txt", ""));
                if (v1 > v2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        List<Position> positions = new ArrayList<>();
        for (File file : filesArray) {
            String pos = FileUtil.readLines(file, Charset.defaultCharset()).get(0);
            String[] split = pos.split(",");
            Position position = new Position();
            int size = 20;
            position.x = (int) (Float.parseFloat(split[0]) * size) + 800;
            position.y = (int) (Float.parseFloat(split[1]) * -size) + 500;
            position.z = (int) (Float.parseFloat(split[2]) * size) + 500;
            positions.add(position);
        }


        return positions;
    }


    private static class Position {
        public int x;
        public int y;
        public int z;
    }
}
