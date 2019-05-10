package com.bnppf.kata;

import java.util.Map;
import java.util.Scanner;

public class TicTacToeGame {

    private static boolean isGameEnd = false;
    public static void main(String[] args) {
        System.out.println("Welcome to Two Player Tic Tac Toe Game...");
        System.out.println("Player 1 will always position X and Player2 will position O");
        System.out.println("Initializing the 3X3 game board....\n");
        Scanner sc = new Scanner(System.in);
        printBoard();
        startGame(sc);
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

    public static int placeMark(TicTacToe ticTacToe, int position, String mark) {
        if(ticTacToe.blockPosition(position, mark)){
            String gameStatus = ticTacToe.checkGameStatus();
            if("not finished".equals(gameStatus)){
                printBoard(ticTacToe);
            } else{
                printBoard(ticTacToe);
                System.out.println("Final Game Result is ----> "+gameStatus);
                isGameEnd = true;
            }
        } else{
            position = -1;
            System.out.println("\n Attention! Please choose a valid position to place "+mark+"\n");
            printBoard(ticTacToe);
        }
        return position;
    }

    public static void startGame(Scanner sc) {
        System.out.println("Lets start the game....\n");
        TicTacToe ticTacToe = new TicTacToe();
        for(int turn = 1; turn <10; turn ++){
            boolean isGameEnd = false;
            if(turn%2 == 1){
                System.out.println("Now its Player 1 turn to position X");
                if(validatePosition(sc, ticTacToe,"X")){
                    break;
                }
            } else {
                System.out.println("Now its Player 2 turn to position O");
                if(validatePosition(sc, ticTacToe, "O")){
                    break;
                }
            }
        }
    }

    private static boolean validatePosition(Scanner sc, TicTacToe ticTacToe,String mark) {
        int position = -1;
        while(position == -1){
            System.out.println("Please enter the position you want to place "+ mark+" : ");
            position = sc.nextInt();
            position = placeMark(ticTacToe, position, mark);
            if(isGameEnd){
                break;
            }
        }
        return isGameEnd;
    }
}
