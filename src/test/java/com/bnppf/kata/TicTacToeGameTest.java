package com.bnppf.kata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeGameTest {
    private TicTacToeGame ticTacToeGame;

    @Before
    public void init(){
        ticTacToeGame = new TicTacToeGame();
    }

    @Test
    public void test_main(){
        TicTacToeGame.main(new String[]{"test1", "test2"});
    }
}
