/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticsass;

import java.util.Arrays;

/**
 *
 * @author MrHacker
 */
public class Chromosome {

    static int numOfItems;
    float lowerBound;
    float upperBound;
    //this arraylist is parallel with gene(items) in main
    boolean[] genes;
    int fitness;

    public Chromosome() {
        genes = new boolean[numOfItems];
    }

    public Chromosome clone() {
        Chromosome c = new Chromosome();
        c.genes = genes.clone();
        return c;
    }

    @Override
    public String toString() {
        return "Chromosome{" + "numOfItems=" + numOfItems + ",\n "
                + "genes=" + Arrays.toString(genes) + ",\n fitness=" + fitness + '}';
    }
}
