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
public class GeneticsAss {

    class KnapSackProblem {

        int numOfTestCases;
        int numOfItems;
        int sizeOfKnapSack;
        ArrayList<Gene> pairs;

        void getInput() {
            numOfTestCases = 1;
            numOfItems = 3;
            sizeOfKnapSack = 10;
            pairs.add(new Gene(4, 4));
            pairs.add(new Gene(7, 6));
            pairs.add(new Gene(5, 3));
        }

        public KnapSackProblem() {

        }

    }

    public static void main(String[] args) {
        // TODO code application logic here   
    }
}

