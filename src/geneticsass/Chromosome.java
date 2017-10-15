/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticsass;

import java.util.ArrayList;

/**
 *
 * @author MrHacker
 */
public class Chromosome {

    int numOfItems;
    //this arraylist is parallel with gene(items) in main
    ArrayList<Boolean> genes;
    int fitness;
    float lowerBound;
    float upperBound;

    public Chromosome(int newSize) {
        numOfItems = newSize;
    }
}
