package ru.snake.game.demo.body;


import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<BodyPart> snake;

    private static int x = 10;
    private static int y = 10;
    private static int sizeOfPart = 10;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;


    public Snake() {
        up = false;
        down = false;
        left = false;
        right = false;
        snake = new ArrayList<>();
    }


    public void createSnake() {
        snake.add(new BodyPart(x, y, sizeOfPart));
    }

    public void createPart(int xCoord, int yCoord) {
        x += xCoord;
        y += yCoord;
        snake.add(new BodyPart(x, y, sizeOfPart));
    }

    public void move() {
        snake.remove(0);
    }


    public int getSizeOfSnake(){
         return snake.size();
    }

    public BodyPart getPartOfSnake(int index) {
        return snake.get(index);
    }
    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static int getSizeOfPart() {
        return sizeOfPart;
    }

    public static void setX(int x) {
        Snake.x = x;
    }

    public static void setY(int y) {
        Snake.y = y;
    }

    public static void setSizeOfPart(int sizeOfPart) {
        Snake.sizeOfPart = sizeOfPart;
    }

}
