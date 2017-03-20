/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefoo.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 *
 * @author tylerhoward
 */
public class GridSolver {
    Chain currentChain;
    ArrayList<Chain> chainList;
    RandomGrid gameBoard;
    
    public GridSolver(RandomGrid gameBoard){
        currentChain = new Chain();
        chainList = new ArrayList<>();
        this.gameBoard = gameBoard;
    }
    
    public void solve(){
        int[][] grid = gameBoard.getGrid();
        
        
        for(int rows=0; rows<grid.length; rows++){
            for(int columns=0; columns<grid.length; columns++){
                currentChain = new Chain();
                currentChain.setVisited(new boolean[gameBoard.getGrid().length][gameBoard.getGrid().length]);
                if(isChain(rows, columns, grid)){
//                    System.out.println(rows + " " + columns);
                }
            }
        }
                
    }
    
    public  boolean isChain(int row, int column, int[][] gameBoard){
        if(row < 0 || column < 0 || row >= gameBoard.length || column >= gameBoard.length || currentChain.getVisited()[row][column]){
//            System.out.println("Current row and column: " + row + " " + column + " caught at first if statement" + + currentChain.getSum());
            return false;
        }
        
        currentChain.add(gameBoard[row][column]);
        int target = (int) Math.pow(gameBoard.length, 2);
        
        
        if(currentChain.getSum() == target && currentChain.getNumbers().size() >= gameBoard.length-1){
//            System.out.println("Current row and column: " + row + " " + column + " caught at second if statement");
            System.out.println("One chain is: " + currentChain.getNumbers());
            return true;
        }
        else if(currentChain.getSum() < target){
//            System.out.println("Current row and column: " + row + " " + column + " caught at third if statement " + currentChain.getSum());
            currentChain.getVisited()[row][column] = true;
            isChain(row-1, column-1, gameBoard);
            isChain(row-1, column, gameBoard);
            isChain(row-1, column+1, gameBoard);
            isChain(row, column-1, gameBoard);
            isChain(row, column,gameBoard);
            isChain(row, column+1, gameBoard);
            isChain(row+1, column-1, gameBoard);
            isChain(row+1, column, gameBoard);
            isChain(row+1, column+1, gameBoard);
        }
        else if(currentChain.getSum() > target){
//            System.out.println("Popped: " + currentChain.getNumbers().peek());
            currentChain.setSum(currentChain.getSum() - currentChain.getNumbers().pop());
//            System.out.println("Current row and column: " + row + " " + column + " caught at last else statement " + currentChain.getSum());
        }
        
        return false;        
    }
    
}
