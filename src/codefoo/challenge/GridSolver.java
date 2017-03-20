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
    HashSet<Stack<Integer>> chainList;
    RandomGrid gameBoard;
    
    public GridSolver(RandomGrid gameBoard){
        currentChain = new Chain();
        chainList = new HashSet<>();
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
        
        for(Stack<Integer> x : chainList){
            System.out.println("Chain: " + x);
        }       
    }
    
    public  boolean isChain(int row, int column, int[][] gameBoard){
        if(row < 0 || column < 0 || row >= gameBoard.length || column >= gameBoard.length || currentChain.getVisited()[row][column]){
            return false;
        }
        
        currentChain.add(gameBoard[row][column]);
        int target = (int) Math.pow(gameBoard.length, 2);
        
        
        if(currentChain.getSum() == target && currentChain.getNumbers().size() >= gameBoard.length-1){
            chainList.add(currentChain.getNumbers());
            currentChain.getVisited()[row][column] = true;
                        
            return true;
        }
        else if(currentChain.getSum() < target){
            currentChain.getVisited()[row][column] = true;
            recursive(row,column,gameBoard);
        }
        else if(currentChain.getSum() > target){
            currentChain.setSum(currentChain.getSum() - currentChain.getNumbers().pop());
        }
        
        return false;        
    }
    
    public void recursive(int row, int column, int[][] gameBoard){
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
    
}
