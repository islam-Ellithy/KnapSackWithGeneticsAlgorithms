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
    ArrayList<Gene> genes;
    int fitness;

    public Chromosome(int newSize) {
        numOfItems = newSize;
        genes = new ArrayList<>(numOfItems);

    }

    @Override
    public String toString() {
        return "Chromosome{" + "numOfItems=" + numOfItems + ",\n "
                + "genes=" + genes + ",\n fitness=" + fitness + '}';
    }
}
