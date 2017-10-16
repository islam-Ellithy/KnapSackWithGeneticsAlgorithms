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
    public int fitnessFunction(Chromosome chromosome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PairOfChromosome> selection(ArrayList<Chromosome> chromosomes) {
        ArrayList<PairOfChromosome> pairs = new ArrayList<>();
        int numOfSelections = 10;
        int totalFitness = 0;
        for (Chromosome chromosome : chromosomes) {
            chromosome.fitness = fitnessFunction(chromosome);
            totalFitness += chromosome.fitness;
        }
        float last = 0;
        for (Chromosome chromosome : chromosomes) {
            chromosome.lowerBound = last;
            chromosome.upperBound = last += ((float) chromosome.fitness / (float) totalFitness);
        }
        for (int i = 0; i < numOfSelections; i++) {
            double rand = Math.random();
            PairOfChromosome pair = new PairOfChromosome();
            for (Chromosome chromosome : chromosomes) {
                if (rand < chromosome.upperBound && rand >= chromosome.lowerBound) {
                    pair.firstChromo = chromosome.clone();
                }
            }
            rand = Math.random();
            for (Chromosome chromosome : chromosomes) {
                if (rand < chromosome.upperBound && rand >= chromosome.lowerBound) {
                    pair.secondChromo = chromosome.clone();
                }
            }
            pairs.add(pair);
        }
        return pairs;

    }

    @Override
    public ArrayList<PairOfChromosome> crossover(ArrayList<PairOfChromosome> chromosomes) {
        //pc is point of crossover
        //random number to check if I can do crossover or not
        float r = 0, probOfCross = 0.55f;//try diffrent probabilities for optimality
        int pc;
        PairOfChromosome pair;
        for (int i = 0; i < chromosomes.size(); i++) {

            pc = (int) (Math.random() * (Chromosome.numOfItems - 2) + 1.5);
            r = (float) Math.random();

            print("R = " + r + "\n" + "Pc = " + pc);
            //if true i will do crossover
            if (r <= probOfCross) {

                pair = doCrossover(chromosomes.get(i), pc);
                //update pair in list after do crossover on them
                chromosomes.set(i, pair);
            }
        }
        return chromosomes;
    }

    private PairOfChromosome doCrossover(PairOfChromosome pairOfChromosome, int pc) {
        Chromosome firstChromo = pairOfChromosome.firstChromo.clone();
        Chromosome secondChromo = pairOfChromosome.secondChromo.clone();
        for (int i = pc; i < firstChromo.genes.length; i++) {
            pairOfChromosome.firstChromo.genes[i] = secondChromo.genes[i];
            pairOfChromosome.secondChromo.genes[i] = firstChromo.genes[i];
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
