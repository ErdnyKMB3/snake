package ru.snake.game.demo.body;

import java.awt.*;

public class BodyPart {
    private int xCoord, yCoord, WIDTH, HEIGHT;
    private static final int deltaForCoords = 2, deltaForDimensions = 4;

    public BodyPart(int xCoord, int yCoord, int tailSize) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.WIDTH = tailSize;
        this.HEIGHT = tailSize;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(xCoord * WIDTH, yCoord * HEIGHT, WIDTH, HEIGHT);
        graphics.setColor(Color.GREEN);
        graphics.fillRect(xCoord * WIDTH + deltaForCoords, yCoord * HEIGHT + deltaForCoords,
                WIDTH - deltaForDimensions, HEIGHT - deltaForDimensions);
    }



}
