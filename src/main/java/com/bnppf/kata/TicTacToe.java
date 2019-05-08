package com.bnppf.kata;

import java.util.HashMap;
import java.util.Map;

public class TicTacToe {

    private Map<Integer, String> positionBlockStatusMap = new HashMap<Integer, String>();

    protected void blockPosition(int position, String playerName) {
        positionBlockStatusMap.put(position, playerName);
    }

    public Map<Integer, String> getPositionStatus() {
        return positionBlockStatusMap;
    }
}
