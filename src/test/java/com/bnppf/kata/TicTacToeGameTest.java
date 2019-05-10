package com.bnppf.kata;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;


public class TicTacToeGameTest {
    private TicTacToeGame ticTacToeGame;

    @Before
    public void init(){
        ticTacToeGame = new TicTacToeGame();
    }

    @Test
    public void test_When_NoPositions_Expect_EmptyGameBoard(){
        ticTacToeGame.printBoard();
    }

    @Test
    public void test_When_PlayerXPostionAtFirstPosition_Expect_XinFirstPosition(){
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToeGame.placeMark(ticTacToe,1, "X");
    }

    @Test
    public void test_When_TryToPositionWhichIsFilled_Expect_Warning(){
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToeGame.placeMark(ticTacToe, 1, "X");
        ticTacToeGame.placeMark(ticTacToe, 1, "O");
    }

    @Test
    public void test_When_PositionsMatchesWinningPattern_Expect_Win(){
        TicTacToe ticTacToe = new TicTacToe();

        ticTacToeGame.placeMark(ticTacToe, 1, "X");
        ticTacToeGame.placeMark(ticTacToe, 7, "O");
        ticTacToeGame.placeMark(ticTacToe, 2, "X");
        ticTacToeGame.placeMark(ticTacToe, 5, "0");
        ticTacToeGame.placeMark(ticTacToe, 3, "X");
    }

    @Test
    public void test_When_StartGameWithGivenInput_Expect_ShowPlayerXAsWinner(){
        System.setIn(new ByteArrayInputStream("1\n2\n3\n3\n4\n5\n6\n7\n8\n9".getBytes()));
        Scanner scanner = new Scanner(System.in);
        ticTacToeGame.startGame(scanner);
    }

    @Test
    public void test_When_StartGameWithGivenInput_Expect_ShowPlayerOAsWinner(){
        System.setIn(new ByteArrayInputStream("1\n4\n2\n5\n7\n6".getBytes()));
        Scanner scanner = new Scanner(System.in);
        ticTacToeGame.startGame(scanner);
    }

}
