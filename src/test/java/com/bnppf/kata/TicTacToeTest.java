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
        ticTacToe.blockPosition(1, "X");

        Map<Integer, String> filledBlockStatusMap = ticTacToe.getBoardStatus();
        String playerName =  filledBlockStatusMap.get(1);

        Assert.assertNotNull(playerName);
        Assert.assertEquals("X", playerName);
    }

    @Test
    public void When_playerOplacesAtFirstPosition_Expect_FirstPositionIsBlockedByPlayerX(){
        ticTacToe.blockPosition(1, "X");
        ticTacToe.blockPosition(1, "O");

        Map<Integer, String> filledBlockStatusMap = ticTacToe.getBoardStatus();
        String playerName =  filledBlockStatusMap.get(1);

        Assert.assertNotNull(playerName);
        Assert.assertEquals("X", playerName);
    }

    @Test
    public void When_playersPlaceAtAvailablePositions_Expect_CorrectPlayersNames(){
        ticTacToe.blockPosition(1, "X");
        ticTacToe.blockPosition(2, "O");
        ticTacToe.blockPosition(5, "X");
        ticTacToe.blockPosition(9, "O");

        Map<Integer, String> filledBlockStatusMap = ticTacToe.getBoardStatus();

        Assert.assertEquals("X", filledBlockStatusMap.get(5));
        Assert.assertEquals("O", filledBlockStatusMap.get(2));
    }

    @Test
    public void When_MinMovesAreFinished_Expect_GameStatusAsFinished(){
        ticTacToe.blockPosition(1, "X");
        ticTacToe.blockPosition(5, "O");
        ticTacToe.blockPosition(2, "X");
        ticTacToe.blockPosition(9, "O");
        ticTacToe.blockPosition(3, "X");

        String gameStatus = ticTacToe.checkGameStatus();

        Assert.assertEquals("playerX Win", gameStatus);
    }

    @Test
    public void When_MinMovesAreFinished_Expect_GameStatusAsNotFinished(){
        ticTacToe.blockPosition(1, "X");
        ticTacToe.blockPosition(5, "O");
        ticTacToe.blockPosition(2, "X");
        ticTacToe.blockPosition(3, "O");
        ticTacToe.blockPosition(4, "X");

        String gameStatus = ticTacToe.checkGameStatus();

        Assert.assertEquals("not finished", gameStatus);
    }

    @Test
    public void When_PlayerPositionAtTen_Expect_PositionShouldNotBeFilled(){
        ticTacToe.blockPosition(10, "X");

        Map<Integer, String> filledBlockStatusMap = ticTacToe.getBoardStatus();
        String playerName =  filledBlockStatusMap.get(10);

        Assert.assertNull(playerName);
    }

    @Test
    public void When_PlayerPositionAtNonExistingBlock_Expect_PositionShouldNotBeFilled(){
        ticTacToe.blockPosition(-1, "X");

        Map<Integer, String> filledBlockStatusMap = ticTacToe.getBoardStatus();
        String playerName =  filledBlockStatusMap.get(-1);

        Assert.assertNull(playerName);
    }

    @Test
    public void When_AllMovesAreNotFinished_Expect_GameStatusAsNotFinished(){
        ticTacToe.blockPosition(1, "X");
        ticTacToe.blockPosition(2, "O");
        ticTacToe.blockPosition(5, "X");
        ticTacToe.blockPosition(9, "O");
        ticTacToe.blockPosition(3, "X");
        ticTacToe.blockPosition(7, "O");
        ticTacToe.blockPosition(8, "X");
        ticTacToe.blockPosition(4, "O");

        String gameStatus = ticTacToe.checkGameStatus();

        Assert.assertEquals("not finished", gameStatus);
    }

    @Test
    public void When_AllMovesAreFinished_Expect_GameResultAsDraw(){
        ticTacToe.blockPosition(1, "X");
        ticTacToe.blockPosition(2, "O");
        ticTacToe.blockPosition(5, "X");
        ticTacToe.blockPosition(9, "O");
        ticTacToe.blockPosition(3, "X");
        ticTacToe.blockPosition(7, "O");
        ticTacToe.blockPosition(8, "X");
        ticTacToe.blockPosition(4, "O");
        ticTacToe.blockPosition(6, "X");

        String gameStatus = ticTacToe.checkGameStatus();

        Assert.assertEquals("draw", gameStatus);
    }

    @Test
    public void When_PlayerOplacesAtWinPostions_Expect_WinnerPlayerO(){
        ticTacToe.blockPosition(1, "X");
        ticTacToe.blockPosition(7, "O");
        ticTacToe.blockPosition(2, "X");
        ticTacToe.blockPosition(3, "O");
        ticTacToe.blockPosition(4, "X");
        ticTacToe.blockPosition(5, "O");

        String gameStatus = ticTacToe.checkGameStatus();

        Assert.assertEquals("playerO Win", gameStatus);
    }
}
