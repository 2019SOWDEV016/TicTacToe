package com.bnppf.kata;

import java.util.Map;

public class TicTacToeGame {
    public static void main(String[] args) {

    }

    public static void printBoard() {
        System.out.println("+---+---+---+");
        System.out.println("| " + "1" + " | " + "2" + " | " + "3" + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + "4" + " | " + "5" + " | " + "6" + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + "7" + " | " + "8" + " | " + "9" + " |");
        System.out.println("+---+---+---+");
    }

    private static void printBoard(TicTacToe ticTacToe) {
        Map<Integer, String> positionBlockStatusMap = ticTacToe.getBoardStatus();
        String positinOne = ( null != positionBlockStatusMap.get(1) ? positionBlockStatusMap.get(1) : " ");
        String positinTwo = ( null != positionBlockStatusMap.get(2) ? positionBlockStatusMap.get(2) : " ");
        String positinThree = ( null != positionBlockStatusMap.get(3) ? positionBlockStatusMap.get(3) : " ");
        String positinFour = ( null != positionBlockStatusMap.get(4) ? positionBlockStatusMap.get(4) : " ");
        String positinFive = ( null != positionBlockStatusMap.get(5) ? positionBlockStatusMap.get(5) : " ");
        String positinSix = ( null != positionBlockStatusMap.get(6) ? positionBlockStatusMap.get(6) : " ");
        String positinSeven = ( null != positionBlockStatusMap.get(7) ? positionBlockStatusMap.get(7) : " ");
        String positinEight = ( null != positionBlockStatusMap.get(8) ? positionBlockStatusMap.get(8) : " ");
        String positinoneNine = ( null != positionBlockStatusMap.get(9) ? positionBlockStatusMap.get(9) : " ");

        System.out.println("+---+---+---+");
        System.out.println("| " + positinOne + " | " + positinTwo + " | " + positinThree + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + positinFour + " | " + positinFive + " | " + positinSix + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + positinSeven + " | " + positinEight + " | " + positinoneNine + " |");
        System.out.println("+---+---+---+");
    }

    public void placeMark(TicTacToe ticTacToe, int position, String mark) {
        if(ticTacToe.blockPosition(position, mark)){
            String gameStatus = ticTacToe.checkGameStatus();
            if("not finished".equals(gameStatus)){
                printBoard(ticTacToe);
            } else{
                printBoard(ticTacToe);
                System.out.println("Final Game Result is ----> "+gameStatus);
            }
        } else{
            System.out.println("\n Attention! Please choose a valid position to place "+mark+"\n");
            printBoard(ticTacToe);
        }
    }
}
