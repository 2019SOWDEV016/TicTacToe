package com.bnppf.kata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class TicTacToeTest {
    private TicTacToe ticTacToe;

    @Before
    public void init(){
        ticTacToe = new TicTacToe();
    }

    @Test
    public void When_playerXplacesAtFirstPosition_Expect_FirstPositionIsNotAvailable(){
        ticTacToe.blockPosition(1, "playerX");

        Map<Integer, String> filledBlockStatusMap = ticTacToe.getPositionStatus();
        String playerName =  filledBlockStatusMap.get(1);

        Assert.assertNotNull(playerName);
        Assert.assertEquals("playerX", playerName);
    }



}
