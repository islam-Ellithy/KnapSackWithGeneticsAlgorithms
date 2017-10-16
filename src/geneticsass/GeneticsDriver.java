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
public class GeneticsDriver implements Modification {

    @Override
    public int fitnessFunction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PairOfChromosome> selection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PairOfChromosome> crossover(ArrayList<PairOfChromosome> chromosomes) {
        //pc is point of crossover
        //random number to check if I can do crossover or not
        float r = 0, pc;

        PairOfChromosome pair;
        for (int i = 0; i < chromosomes.size(); i++) {

            pc = KnapSackProblem.generateRandomNumber();
            r = KnapSackProblem.generateRandomNumber();

            print("R = " + r + "\n" + "Pc = " + pc);
            //if true i will do crossover
            if (r <= pc) {

                pair = doCrossover(chromosomes.get(i), pc);
                //update pair in list after do crossover on them
                chromosomes.set(i, pair);
            }
        }
        return chromosomes;
    }

    private PairOfChromosome doCrossover(PairOfChromosome pairOfChromosome, float pc) {

        for (int i = 0; i < pairOfChromosome.firstChromo.genes.size(); i++) {
            Gene firstGene = pairOfChromosome.firstChromo.genes.get(i);
            Gene secondGene = pairOfChromosome.secondChromo.genes.get(i);
            if (firstGene.lowerBound < pc) {
                pairOfChromosome.firstChromo.genes.set(i, secondGene);
                pairOfChromosome.secondChromo.genes.set(i, firstGene);
            }
        }
        return pairOfChromosome;
    }

    @Override
    public ArrayList<PairOfChromosome> mutation(ArrayList<PairOfChromosome> chromosomes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Chromosome> replaceOldByNew(ArrayList<PairOfChromosome> chromosomes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void PrintPairOfChromosomes(PairOfChromosome chromosomes) {

        print(chromosomes.toString());

    }

    private void print(String msg) {
        System.out.println(msg);
    }

}
