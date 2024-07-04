package ru.anton.lesson01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {
    // Отступ
    private static final int DOT_PADING = 6;
    private int panelWidth;
    private int panelHeight;
    private int cellWidth;
    private int cellHeight;

    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_ROBOT = 2;
    private int gameOverType;

    private static final String MSG_WIN_HUMAN = "Победил игрок... ";
    private static final String MSG_WIN_ROBOT = "Победил компьютер... ";
    private static final String MSG_DRAW = "Ничья ";

    private GameLogic gameLogic;
    private boolean isGameOVer;
    private boolean isInitialized;



    Map () {
        setBackground(Color.darkGray);
        gameLogic = new GameLogic();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
        isInitialized = false;

        setVisible(false);
    }

    void startNemGame(int mod, int fsx, int fsy, int vLen) {
        gameLogic.initGame();
        isGameOVer = false;
        isInitialized = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render (Graphics g) {
        if(!isInitialized) return;;
        panelWidth = getWidth();
        panelHeight = getHeight();
        cellWidth = panelWidth / 3;
        cellHeight = panelHeight / 3;
        
        g.setColor(Color.BLACK);
        for (int w = 0; w < 3; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
        for (int h = 0; h < 3; h++) {
            int y = h*cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if(gameLogic.gamefield[y][x] == 0) continue;
                if (gameLogic.gamefield[y][x] == 1) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x * cellWidth + DOT_PADING, y * cellHeight - DOT_PADING,
                            cellWidth - DOT_PADING*2, cellHeight - DOT_PADING*2);
                } else if (gameLogic.gamefield[y][x] == 2) {
                    g.setColor(new Color(0xFFFF00));
                    g.fillOval(x * cellWidth + DOT_PADING, y * cellHeight - DOT_PADING,
                            cellWidth - DOT_PADING*2, cellHeight - DOT_PADING*2);
                } else {
                    throw new RuntimeException("Ошибка отрисовки ячейки: х = " + x + "; y = " + y);
                }
            }
        }

    }

    private void update (MouseEvent e) {
        if(isGameOVer || !isInitialized) return;

        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;
        gameLogic.moveHuman(cellX, cellY);
        repaint();
        if(checkEndGame(STATE_WIN_HUMAN, STATE_WIN_HUMAN)) return;
        gameLogic.moveRobot();
        repaint();
        if(checkEndGame(STATE_WIN_ROBOT, STATE_WIN_ROBOT)) return;
    }
    private boolean checkEndGame (int gamer, int gameOverType) {
        if(gameLogic.isVictory(gamer)) {
            this.gameOverType = gameOverType;
            isGameOVer = true;
            repaint();
            return true;
        }
        if (gameLogic.isMapFull()) {
            this.gameOverType = STATE_DRAW;
            isGameOVer = true;
            repaint();
            return true;
        }
        return false;
    }

    public void showMessageVictory(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        switch (gameOverType) {
            case STATE_DRAW -> g.drawString(MSG_DRAW, 180, getHeight()/2);
            case STATE_WIN_HUMAN -> g.drawString(MSG_WIN_HUMAN, 180, getHeight()/2);
            case STATE_WIN_ROBOT -> g.drawString(MSG_WIN_ROBOT, 180, getHeight()/2);
            default -> throw new RuntimeException();
        }
    }
}
