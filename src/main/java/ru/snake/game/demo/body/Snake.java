package ru.snake.game.demo.body;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<BodyPart> snake;
    private static final int x = 10;
    private static final int y = 10;
    private static final int size = 10;

    public Snake() {
        snake = new ArrayList<>();
    }

    public void createSnake() {
        snake.add(new BodyPart(x, y, size));
    }

    public int getSize(){
         return snake.size();
    }

    public void drawSnake(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        for (BodyPart bodyPart : snake) {
            bodyPart.draw(graphics);
        }
    }
}
