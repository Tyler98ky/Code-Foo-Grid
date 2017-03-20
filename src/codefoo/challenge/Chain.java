/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefoo.challenge;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author tylerhoward
 */
public class Chain {
    private int sum;
    private Stack<Integer> numbers;
    private boolean[][] visited;

    public void setVisited(boolean[][] visited) {
        this.visited = visited;
    }
    
    public Chain(){
        int sum = 0;
        numbers = new Stack<>();
    }
    
    public Chain(int initial){
        int sum = 0;
        numbers = new Stack<>();
        numbers.add(initial);
        sum += initial;
    }
    
    public void add(int num){
        numbers.add(num);
        sum += num;
    }

    public Stack<Integer> getNumbers() {
        return numbers;
    }

    public int getSum() {
        return sum;
    }

    public boolean[][] getVisited() {
        return visited;
    }
    
    public void setSum(int sum){
        this.sum = sum;
    }
}
