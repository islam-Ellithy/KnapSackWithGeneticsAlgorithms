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

    static int numOfTestCases;
    static int sizeOfKnapSack;
    static ArrayList<Item> pairs = new ArrayList<>();

    static ArrayList<PairOfChromosome> getDummyListOfPairOfChromosome() {
        ArrayList<PairOfChromosome> chromosomes = new ArrayList<PairOfChromosome>();

        PairOfChromosome poc = new PairOfChromosome();

        poc.firstChromo = new Chromosome();

        for (int i = 0; i < Chromosome.numOfItems; i++) {
            poc.firstChromo.genes[i] = true;
        }

        poc.secondChromo = new Chromosome();

        for (int i = 0; i < Chromosome.numOfItems; i++) {
            poc.secondChromo.genes[i] = false;
        }
        chromosomes.add(poc);

        return chromosomes;
    }

    static void getInput() {
        numOfTestCases = 1;
        Chromosome.numOfItems = 3;
        sizeOfKnapSack = 10;

        pairs.add(new Item(4, 4));
        pairs.add(new Item(7, 6));
        pairs.add(new Item(5, 3));
    }

    public static void main(String[] args) {
        // TODO code application logic here   
        getInput();
        GeneticsDriver driver = new GeneticsDriver();
        ArrayList<PairOfChromosome> crossoverResult = driver.crossover(getDummyListOfPairOfChromosome());

        driver.PrintPairOfChromosomes(crossoverResult.get(0));

    }
}
