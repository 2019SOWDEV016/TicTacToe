package com.bnppf.kata;

import java.util.HashMap;
import java.util.Map;

public class TicTacToe {

    private Map<Integer, String> positionBlockStatusMap;

    TicTacToe(){
        this.positionBlockStatusMap = new HashMap<Integer, String>();
    }

    protected void blockPosition(int position, String playerName) {
        if(isPositionAvailable((position))){
            positionBlockStatusMap.put(position, playerName);
        }
    }

    protected boolean isPositionAvailable(int position) {
        if(position >= 1 && position < 10 && null == positionBlockStatusMap.get(position)){
            return true;
        }
        return false;
    }

    protected Map<Integer, String> getPositionStatus() {
        return positionBlockStatusMap;
    }

    protected String checkGameStatus() {
        String status, result;
        status = "not finished";
        result = "next move";
        int minMovesForGameResult;
        minMovesForGameResult = 5;
        if(positionBlockStatusMap.size() >= minMovesForGameResult){
            result = checkWinningPatterns();
            if("next move".equalsIgnoreCase(result) && 9 == positionBlockStatusMap.size()){
                status = "draw";
            } else if("playerX Win".equalsIgnoreCase(result) || "playerO Win".equalsIgnoreCase(result)){
                status = result;
            } else {
                status = "not finished";
            }
        }
        return status;
    }

    protected String checkWinningPatterns() {
        String gameResult = "next move";
        for(int patternIdx = 0; patternIdx < 8; patternIdx++){
            String framedString = "";
            switch (patternIdx){
                case 0:
                    framedString = positionBlockStatusMap.get(1)+positionBlockStatusMap.get(2)+positionBlockStatusMap.get(3);
                    break;
                case 1:
                    framedString = positionBlockStatusMap.get(4)+positionBlockStatusMap.get(5)+positionBlockStatusMap.get(6);
                    break;
                case 2:
                    framedString = positionBlockStatusMap.get(7)+positionBlockStatusMap.get(8)+positionBlockStatusMap.get(9);
                    break;
                case 3:
                    framedString = positionBlockStatusMap.get(1)+positionBlockStatusMap.get(4)+positionBlockStatusMap.get(7);
                    break;
                case 4:
                    framedString = positionBlockStatusMap.get(2)+positionBlockStatusMap.get(5)+positionBlockStatusMap.get(8);
                    break;
                case 5:
                    framedString = positionBlockStatusMap.get(3)+positionBlockStatusMap.get(6)+positionBlockStatusMap.get(9);
                    break;
                case 6:
                    framedString = positionBlockStatusMap.get(1)+positionBlockStatusMap.get(5)+positionBlockStatusMap.get(9);
                    break;
                case 7:
                    framedString = positionBlockStatusMap.get(3)+positionBlockStatusMap.get(5)+positionBlockStatusMap.get(7);
                    break;
            }
            if(framedString.equals("playerXplayerXplayerX")){
                gameResult = "playerX Win";
                break;
            }
            if(framedString.equals("playerOplayerOplayerO")){
                gameResult = "playerO Win";
                break;
            }
        }
        return gameResult;
    }
}
