package ru.snake.game.demo.board;

import ru.snake.game.demo.body.Snake;
import ru.snake.game.demo.listener.MyKeyListener;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel implements Runnable{

    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;
    private static int epsilon = 4;
    private Thread thread;
    private static boolean running = false;
    private Snake snake;
    private MyKeyListener keyListener;
    private int ticks = 0;

    public Screen() throws HeadlessException {
        snake = new Snake();
        keyListener = new MyKeyListener(snake);
    }


    public void tick() {
        if (snake.getSizeOfSnake() == 0) {
            snake.createSnake();
        }
        ticks++;
        if (ticks > 25000) {
            ticks = 0;
            if (snake.getSizeOfSnake() > epsilon) {
                snake.move();
            }
        }
    }

    private void setUpScreenDimension() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private void setUpScreenDimension(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }

    public void createDefaultScreen() {
        setFocusable(true);
        addKeyListener(keyListener);
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
        graphics.clearRect(0,0,WIDTH, HEIGHT);
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(0,0, WIDTH, HEIGHT);
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < WIDTH / 10; i++) {
            graphics.drawLine(i * 10, 0, i * 10, HEIGHT);
            graphics.drawLine(0, i * 10, WIDTH, i * 10);
        }
        for (int i = 0; i < snake.getSizeOfSnake(); i++) {
            snake.getPartOfSnake(i).draw(graphics);
        }
    }

    @Override
    public void run() {
        while (running) {
            tick();
            repaint();
        }
    }
}
