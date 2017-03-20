/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefoo.challenge;

/**
 *
 * @author tylerhoward
 */
public class RandomGrid {
    private int[][] grid;
    
    public RandomGrid(int size){
        grid = new int[size][size];
        System.out.println("This is the random grid: \n");
        
        //Initializing the array with random numbers
        for(int rows=0; rows<size; rows++){
            for(int columns=0; columns<size; columns++){
                grid[rows][columns] += Math.random() * 10;
                System.out.print(grid[rows][columns] + " ");
            }
            System.out.println();
        }
    }
    
    public RandomGrid(){
        grid = new int[][]{{8,9,7},{0,6,1},{2,1,5}};
        int size = grid.length;
        System.out.println("This is the random grid: \n");
        for(int rows=0; rows<size; rows++){
            for(int columns=0; columns<size; columns++){
                System.out.print(grid[rows][columns] + " ");
            }
            System.out.println();
        }
    }

    public int[][] getGrid() {
        return grid;
    }    
}
