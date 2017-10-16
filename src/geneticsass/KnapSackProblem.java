/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticsass;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author MrHacker
 */
class KnapSackProblem {

    int numOfTestCases;
    int numOfItems;
    int sizeOfKnapSack;
    ArrayList<Item> pairs;

    public KnapSackProblem() {
        pairs = new ArrayList<>();
    }

    void getInput() {
        numOfTestCases = 1;
        numOfItems = 3;
        sizeOfKnapSack = 10;

        pairs.add(new Item(4, 4));
        pairs.add(new Item(7, 6));
        pairs.add(new Item(5, 3));
    }

    static float generateRandomNumber() {
        Random rand = new Random();
        return rand.nextFloat();
    }

    ArrayList<PairOfChromosome> getDummyListOfPairOfChromosome() {
        ArrayList<PairOfChromosome> chromosomes = new ArrayList<PairOfChromosome>(1);

        PairOfChromosome poc = new PairOfChromosome();

        poc.firstChromo = new Chromosome(numOfItems);

        float lower = 0;
        float weight = (float) 100 / numOfItems;
        for (int i = 0; i < numOfItems; i++) {
            Gene gene = new Gene(lower, lower + weight, true);
            poc.firstChromo.genes.add(gene);
            lower += weight;
        }

        poc.secondChromo = new Chromosome(numOfItems);
        lower = 0;
        weight = (float) 100 / numOfItems;

        for (int i = 0; i < numOfItems; i++) {
            Gene gene = new Gene(lower, lower + weight, false);
            poc.secondChromo.genes.add(gene);
            lower += weight;
        }
        chromosomes.add(poc);

        return chromosomes;
    }
}
