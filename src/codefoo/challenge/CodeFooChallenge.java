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
public class CodeFooChallenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create the random grid and then solve it
        RandomGrid gameBoard = new RandomGrid(3);
        GridSolver solver = new GridSolver(gameBoard);
        solver.solve();
    }
    
}
