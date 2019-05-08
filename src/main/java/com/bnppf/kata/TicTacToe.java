package com.bnppf.kata;

import java.util.HashMap;
import java.util.Map;

public class TicTacToe {

    private Map<Integer, String> positionBlockStatusMap = new HashMap<Integer, String>();
    private int minMovesForGameResult = 5;
    protected void blockPosition(int position, String playerName) {
        if(isPositionAvailable((position))){
            positionBlockStatusMap.put(position, playerName);
        }
    }

    private boolean isPositionAvailable(int position) {
        if(null == positionBlockStatusMap.get(position)){
            return true;
        }
        return false;
    }

    protected Map<Integer, String> getPositionStatus() {
        return positionBlockStatusMap;
    }


    public String checkGameResult() {
        if(positionBlockStatusMap.size() >= minMovesForGameResult){
            return "finished";
        }
        return "not finished";
    }
}
