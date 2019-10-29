package ru.snake.game.demo.board;

import ru.snake.game.demo.body.Snake;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel implements Runnable{

    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;
    private Thread thread;
    private static boolean running = false;
    private Snake snake;

    public Screen() throws HeadlessException {
        snake = new Snake();
    }


    public void tick() {
        if (snake.getSize() == 0) {
            snake.createSnake();
        }
    }

    private void setUpScreenDimension() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private void setUpScreenDimension(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }

    public void createDefaultScreen() {
        setUpScreenDimension();
        start();
    }

    public void createCustomScreen(int width, int height) {
        setUpScreenDimension(width, height);
        start();
    }

    public void start() {
        running = true;
        thread = new Thread(this, "Game loop");
        thread.start();
    }

    public void stop() {

    }

    public void paint(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < WIDTH / 10; i++) {
            graphics.drawLine(i * 10, 0, i * 10, HEIGHT);
            graphics.drawLine(0, i * 10, WIDTH, i * 10);
        }
        snake.drawSnake(graphics);

    }

    @Override
    public void run() {
        while (running) {
            tick();
            repaint();
        }
    }
}
