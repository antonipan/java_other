package ru.anton.lesson01;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    private static Random random = new Random();
    public static final char MOVE_HUMAN = 1;
    public static final char MOVE_ROBOT = 2;
    public static final char EMPTY_FIELD = 0;
    public static int fieldLength_X;
    public static int fieldLength_Y;
    public static int combinationVim;

    public int [][] gamefield;



    // Метод инициализирует игровое поле. Пользователь должен ввести размер игрового поля.
    public void initGame() {
        fieldLength_X = 3;
        fieldLength_Y = 3;
        combinationVim = 3;
        gamefield = new int [fieldLength_Y][fieldLength_X];
        for (int i = 0; i < fieldLength_Y; i++) {
            for (int j = 0; j < fieldLength_X; j++) {
                gamefield[i][j] = EMPTY_FIELD;
            }
        }
    }

    // Проверка на выход за пределы поля для робота.
    public boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldLength_X && y >= 0 && y < fieldLength_Y;
    }

    // Проверка на пустую ячейку
    public boolean isEpmtyCell(int x, int y) {
        return gamefield[y][x] == EMPTY_FIELD;
    }

    /**
     * Метод хода Игрока.
     */
    public void moveHuman(int x, int y) {
        if (!isValidCell(x, y) || !isEpmtyCell(x, y)){
            return;
        }
        gamefield[y][x] = MOVE_HUMAN;
    }

    // Ход робота
    public void moveRobot() {
        int x1 = 0;
        int y1 = 0;
        do {
            x1 = random.nextInt(fieldLength_X);
            y1 = random.nextInt(fieldLength_Y);
        } while (!isValidCell(x1, y1) || !isEpmtyCell(x1, y1));
        gamefield[y1][x1] = MOVE_ROBOT;
    }

    public static boolean isCombination(int x) {
        int min;
        if (fieldLength_X > fieldLength_Y) {
            min = fieldLength_Y;
        } else {
            min = fieldLength_X;
        }
        if (x > 2 && x <= min) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMapFull() {
        for (int i = 0; i < fieldLength_Y; i++) {
            for (int j = 0; j < fieldLength_X; j++) {
                if (gamefield[fieldLength_Y-1][fieldLength_X-1] == EMPTY_FIELD) return false;
            }
        }
        return true;
    }

    public boolean isVictory(int movePlayer) {
        return false;
        //isHorizon(movePlayer) || isVertical(movePlayer) ||
          //      isDiagonalRightUp(movePlayer) || isDiagonalRightDown(movePlayer);
    }


    // Метод проверяет выигрышные комбинации по горизонтали.
    private boolean isHorizon(int movePlayer) {
        int count = 0;
        for (int y = 0; y < fieldLength_Y; y++) {
            for (int x = 0; x < fieldLength_X; x++) {
                if (gamefield[y][x] == movePlayer) {
                    count++;
                    if (count == combinationVim) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
            count = 0;
        }
        return false;
    }

    // Метод проверяет выигрышные комбинации по вертилкалит.
    private boolean isVertical(int movePlayer) {
        int count = 0;
        for (int x = 0; x < fieldLength_X; x++) {
            for (int y = 0; y < fieldLength_Y; y++) {
                if (gamefield[y][x] == movePlayer) {
                    count++;
                    if (count == combinationVim) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
            count = 0;
        }
        return false;
    }

    //Метод проверяет выигрышные комбинации по диагноали - лево-верх - право-низ.
    private boolean isDiagonalRightUp(int movePlayer) {
        int countX;
        int countY;
        int count = 0;
        for (int i = fieldLength_Y - 1; i >= 0; i--) {
            countX = 0;
            countY = i;
            while (countY < fieldLength_Y && countX < fieldLength_X) {
                if (gamefield[countY][countX] == movePlayer) {
                    count++;
                    if (count == combinationVim) {
                        return true;
                    }
                } else {
                    count = 0;
                }
                countX++;
                countY++;
            }
            count = 0;
        }
        for (int i = 1; i < fieldLength_X; i++) {
            count = 0;
            countY = 0;
            countX = i;
            while (countY < fieldLength_Y && countX < fieldLength_X) {
                if (gamefield[countY][countX] == movePlayer) {
                    count++;
                    if (count == combinationVim) {
                        return true;
                    }
                } else {
                    count = 0;
                }
                countX++;
                countY++;
            }
        }
        return false;
    }

    //Метод проверяет выигрышные комбинации по диагноали - лево-низ - право-верх.
    public boolean isDiagonalRightDown(int movePlayer) {
        int countX;
        int countY;
        int count = 0;
        for (int i = 0; i < fieldLength_X; i++) {
            countX = i;
            countY = 0;
            while (countY < fieldLength_Y && countX >= 0) {
                if (gamefield[countY][countX] == movePlayer) {
                    count++;

                    if (count == combinationVim) {
                        return true;
                    }
                } else {
                    count = 0;
                }
                countX--;
                countY++;
            }
        }
        for (int i = 1; i < fieldLength_Y; i++) {
            count = 0;
            countY = 1;
            countX = fieldLength_X - 1;
            while (countY < fieldLength_Y && countX >= 0) {
                if (gamefield[countY][countX] == movePlayer) {
                    count++;

                    if (count == combinationVim) {
                        return true;
                    }
                } else {
                    count = 0;
                }
                countX--;
                countY++;
            }
        }
        return false;
    }

    private boolean isHorizonCheck() {
        int count = 0;
        int countEmpty = 0;
        for (int y = 0; y < fieldLength_Y; y++) {
            // Это цикл проверяет являются ли ячейки по горизонтали в строке - пустыми.
            for (int i = 0; i < fieldLength_X; i++) {
                if (gamefield[y][i] != EMPTY_FIELD) {
                    countEmpty++;
                }
            }
            if (countEmpty == fieldLength_X) {
                return false;
            }
            for (int x = 0; x < fieldLength_X; x++) {
                if (gamefield[y][x] == MOVE_HUMAN) {
                    count++;
                    if (count == combinationVim - 1) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
            count = 0;
        }
        return false;
    }
}


//    private static boolean isVerticalCheck () {
//        int count = 0;
//        for (int x = 0; x < fieldLength_X; x++) {
//            for (int y = 0; y < fieldLength_Y; y++) {
//                if (gamefield[y][x] == MOVE_HUMAN) {
//                    count++;
//                    if (count == combinationVim-1) {
//                        return true;
//                    }
//                } else {
//                    count = 0;
//                }
//            }
//            count = 0;
//        }
//        return false;
//    }
//
//    private static boolean isDiagonalRightUpCheck () {
//        int countX;
//        int countY;
//        int count = 0;
//        for (int i = fieldLength_Y-1; i >= 0; i--) {
//            countX = 0;
//            countY = i;
//            while (countY < fieldLength_Y && countX < fieldLength_X) {
//                if (gamefield[countY][countX] == MOVE_HUMAN) {
//                    count++;
//                    if (count == combinationVim-1) {
//                        return true;
//                    }
//                } else {
//                    count = 0;
//                }
//                countX++;
//                countY++;
//            }
//        }
//        for (int i = 1; i < fieldLength_X; i++) {
//            countY = 0;
//            countX = i;
//            while (countY < fieldLength_Y && countX < fieldLength_X) {
//                if (gamefield[countY][countX] == MOVE_HUMAN) {
//                    count++;
//                    if (count == combinationVim-1) {
//                        return true;
//                    }
//                } else {
//                    count = 0;
//                }
//                countX++;
//                countY++;
//            }
//        }
//        return false;
//    }
//
//    private static boolean isDiagonalRightDownCheck () {
//        int countX;
//        int countY;
//        int count = 0;
//        for (int i = 0; i < fieldLength_X; i++) {
//            countX = i;
//            countY = 0;
//            while (countY < fieldLength_Y && countX >= 0) {
//                if (gamefield[countY][countX] == MOVE_HUMAN) {
//                    count++;
//                    if (count == combinationVim-1) {
//                        return true;
//                    }
//                } else {
//                    count = 0;
//                }
//                countX--;
//                countY++;
//            }
//        }
//        for (int i = 1; i < fieldLength_Y; i++) {
//            countY = 1;
//            countX = fieldLength_X-1;
//            while (countY < fieldLength_Y && countX >= 0) {
//                if (gamefield[countY][countX] == MOVE_HUMAN) {
//                    count++;
//                    if (count == combinationVim-1) {
//                        return true;
//                    }
//                } else {
//                    count = 0;
//                }
//                countX--;
//                countY++;
//            }
//        }
//        return false;
//    }




//    private static void HorizonInsert () {
//        int count = 0;
//        for (int y = 0; y < fieldLength_Y; y++) {
//            for (int x = 0; x < fieldLength_X; x++) {
//                if (gamefield[y][x] == MOVE_HUMAN) {
//                    count++;
//                    if (count == combinationVim-1) {
//                         true;
//                    }
//                } else {
//                    count = 0;
//                }
//            }
//            count = 0;
//        }
//    }



//    private static boolean isVerticalCheck () {
//        int count = 0;
//        for (int x = 0; x < fieldLength_X; x++) {
//            for (int y = 0; y < fieldLength_Y; y++) {
//                if (gamefield[y][x] == MOVE_HUMAN) {
//                    count++;
//                    if (count == combinationVim-1) {
//                        return true;
//                    }
//                } else {
//                    count = 0;
//                }
//            }
//            count = 0;
//        }
//        return false;
//    }
//
//    private static boolean isDiagonalRightUpCheck () {
//        int countX;
//        int countY;
//        int count = 0;
//        for (int i = fieldLength_Y-1; i >= 0; i--) {
//            countX = 0;
//            countY = i;
//            while (countY < fieldLength_Y && countX < fieldLength_X) {
//                if (gamefield[countY][countX] == MOVE_HUMAN) {
//                    count++;
//                    if (count == combinationVim-1) {
//                        return true;
//                    }
//                } else {
//                    count = 0;
//                }
//                countX++;
//                countY++;
//            }
//        }
//        for (int i = 1; i < fieldLength_X; i++) {
//            countY = 0;
//            countX = i;
//            while (countY < fieldLength_Y && countX < fieldLength_X) {
//                if (gamefield[countY][countX] == MOVE_HUMAN) {
//                    count++;
//                    if (count == combinationVim-1) {
//                        return true;
//                    }
//                } else {
//                    count = 0;
//                }
//                countX++;
//                countY++;
//            }
//        }
//        return false;
//    }
//
//    private static boolean isDiagonalRightDownCheck () {
//        int countX;
//        int countY;
//        int count = 0;
//        for (int i = 0; i < fieldLength_X; i++) {
//            countX = i;
//            countY = 0;
//            while (countY < fieldLength_Y && countX >= 0) {
//                if (gamefield[countY][countX] == MOVE_HUMAN) {
//                    count++;
//                    if (count == combinationVim-1) {
//                        return true;
//                    }
//                } else {
//                    count = 0;
//                }
//                countX--;
//                countY++;
//            }
//        }
//        for (int i = 1; i < fieldLength_Y; i++) {
//            countY = 1;
//            countX = fieldLength_X-1;
//            while (countY < fieldLength_Y && countX >= 0) {
//                if (gamefield[countY][countX] == movePlayer) {
//                    count++;
//                    if (count == combinationVim-1) {
//                        return true;
//                    }
//                } else {
//                    count = 0;
//                }
//                countX--;
//                countY++;
//            }
//        }
//        return false;
//    }
//}
