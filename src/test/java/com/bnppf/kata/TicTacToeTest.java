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

    @Test
    public void When_playerOplacesAtFirstPosition_Expect_FirstPositionIsBlockedByPlayerX(){
        ticTacToe.blockPosition(1, "playerX");
        ticTacToe.blockPosition(1, "playerO");

        Map<Integer, String> filledBlockStatusMap = ticTacToe.getPositionStatus();
        String playerName =  filledBlockStatusMap.get(1);

        Assert.assertNotNull(playerName);
        Assert.assertEquals("playerX", playerName);
    }

    @Test
    public void When_playersPlaceAtAvailablePositions_Expect_CorrectPlayersNames(){
        ticTacToe.blockPosition(1, "playerX");
        ticTacToe.blockPosition(2, "playerO");
        ticTacToe.blockPosition(5, "playerX");
        ticTacToe.blockPosition(9, "playerO");

        Map<Integer, String> filledBlockStatusMap = ticTacToe.getPositionStatus();

        Assert.assertEquals("playerX", filledBlockStatusMap.get(5));
        Assert.assertEquals("playerO", filledBlockStatusMap.get(2));
    }

    @Test
    public void When_MinMovesAreFinished_Expect_GameResultAsFinished(){
        ticTacToe.blockPosition(1, "playerX");
        ticTacToe.blockPosition(5, "playerO");
        ticTacToe.blockPosition(2, "playerX");
        ticTacToe.blockPosition(9, "playerO");
        ticTacToe.blockPosition(3, "playerX");

        String gameResult = ticTacToe.checkGameResult();

        Assert.assertEquals("finished", gameResult);
    }

    @Test
    public void When_MinMovesAreFinished_Expect_GameResultAsNotFinished(){
        ticTacToe.blockPosition(1, "playerX");
        ticTacToe.blockPosition(5, "playerO");
        ticTacToe.blockPosition(2, "playerX");
        ticTacToe.blockPosition(3, "playerO");
        ticTacToe.blockPosition(4, "playerX");

        String gameResult = ticTacToe.checkGameResult();

        Assert.assertEquals("not finished", gameResult);
    }

    @Test
    public void When_PlayerPositionAtTen_Expect_PositionShouldNotBeFilled(){
        ticTacToe.blockPosition(10, "playerX");

        Map<Integer, String> filledBlockStatusMap = ticTacToe.getPositionStatus();
        String playerName =  filledBlockStatusMap.get(10);

        Assert.assertNull(playerName);
    }
}
