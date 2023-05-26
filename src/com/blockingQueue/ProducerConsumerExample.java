package com.blockingQueue;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        // 创建一个容量为10张缓存图片的的阻塞队列
        BlockingQueue<ImageData> queue = new ArrayBlockingQueue<>(10);

        Thread bitmapLoadThread = new Thread(new BitmapLoader(queue));
        Thread bitmapPlayerThread = new Thread(new BitmapPlayer(queue));
        bitmapLoadThread.start(); // 启动生产者线程
        bitmapPlayerThread.start(); // 启动消费者线程
    }

    // 创建一个生产者线程, 负责预加载图片数据
    private static class BitmapLoader implements Runnable {
        private final BlockingQueue<ImageData> queue;

        public BitmapLoader(BlockingQueue<ImageData> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                long startTime = System.currentTimeMillis();
                //假设一共有 20 张图片
                for (int i = 0; i < 20; i++) {
                    //生成一张图片
                    ImageData imageData = generateImageData(i);
                    // 往队列中添加元素，如果队列已满则会阻塞等待
                    queue.put(imageData);
                }
                long duration = System.currentTimeMillis() - startTime;
                System.out.println("---生产者生产耗时：" + duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private ImageData generateImageData(int index) {
            ImageData imageData = new ImageData();
            try {
                //假设从IO中加载一张图片耗时10ms
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            imageData.bitmap = "图片_" + index;
            imageData.nextFrameTime = 30;
            System.out.println("生产者生产：" + imageData.bitmap);
            return imageData;
        }
    }

    // 创建一个图片播放线程, 作为消费者
    private static class BitmapPlayer implements Runnable {
        private BlockingQueue<ImageData> queue;

        public BitmapPlayer(BlockingQueue<ImageData> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                long startTime = System.currentTimeMillis();
                // 播放20张图片后结束
                for (int i = 0; i < 20; i++) {
                    // 从队列中取出元素，如果队列为空则会阻塞等待
                    ImageData imageData = queue.take();
                    System.out.println("消费者消费：" + imageData.bitmap);
                    //每张图片播放30ms
                    Thread.sleep(30);
                }
                long duration = System.currentTimeMillis() - startTime;
                System.out.println("---消费者耗时：" + duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ImageData {
        String bitmap;
        float shootTime;
        long nextFrameTime;
    }
}

