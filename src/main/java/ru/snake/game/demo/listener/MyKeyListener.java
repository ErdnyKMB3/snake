package ru.snake.game.demo.listener;

import ru.snake.game.demo.body.Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;


public class MyKeyListener implements KeyListener {


    private Snake snake;

    public MyKeyListener(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT){
                snake.createPart(-1, 0);
            }
        if (key == KeyEvent.VK_RIGHT) {
                snake.createPart(1, 0);
            }
        if (key == KeyEvent.VK_UP) {
                snake.createPart(0, -1);
        }
        if (key == KeyEvent.VK_DOWN) {
                snake.createPart(0, 1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
