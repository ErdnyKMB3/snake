package ru.snake.game.demo.board;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private Screen screen;
    private final String titleOfTheBoard = "Snake";

    public Frame(Screen screen) throws HeadlessException {
        this.screen = screen;
    }

    public Frame(String titleOfTheBoard, Screen screen) throws HeadlessException {
        super(titleOfTheBoard);
        this.screen = screen;
    }

    public Frame() throws HeadlessException {
    }


    public void init() {
        screen = new Screen();
        screen.createDefaultScreen();
        initParams(screen);
    }

    private void initParams(Screen screen) {
        setLayout(new GridLayout(1, 1, 0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(titleOfTheBoard);
        setResizable(false);
        add(screen);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
