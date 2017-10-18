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
    public void fitnessFunction(Chromosome chromosome, Item[] items) {
        int fitness = 0;
        for (int i = 0; i < chromosome.genes.length; i++) {
            boolean bool = chromosome.genes[i];
            if (bool) {
                fitness += items[i].weight;
            }
        }
        chromosome.fitness = fitness;
    }

    @Override
    public ArrayList<PairOfChromosome> selection(ArrayList<Chromosome> chromosomes) {
        ArrayList<PairOfChromosome> pairs = new ArrayList<>();
        int numOfSelections = 10;
        
        int totalFitness = 0;
        for (Chromosome chromosome : chromosomes) {
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
        float r, probOfCross = 0.55f;//try diffrent probabilities for optimality
        int pc;
        PairOfChromosome pair;
        for (int i = 0; i < chromosomes.size(); i++) {

            //probability of crossover from 1 to len-1
            pc = (int) (Math.random() * (Chromosome.numOfItems - 2) + 1.5);
            r = (float) Math.random();

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
    public ArrayList<Chromosome> mutation(ArrayList<PairOfChromosome> chromosomes) {
        float rand;
        float fixedValue = (float) 0.1;
        ArrayList<Chromosome> chromArray = new ArrayList<>();
        for (int i = 0; i < chromosomes.size(); i++) {
            for (int k = 0; k < chromosomes.get(i).firstChromo.genes.length; k++) {
                rand = (float) Math.random();
                if (rand >= fixedValue) {
                    chromosomes.get(i).firstChromo.genes[k] = chromosomes.get(i).firstChromo.genes[k] != true;
                }

            }
            chromArray.add(chromosomes.get(i).firstChromo);
            for (int k = 0; k < chromosomes.get(i).secondChromo.genes.length; k++) {
                rand = (float) Math.random();
                if (rand >= fixedValue) {
                    chromosomes.get(i).secondChromo.genes[k] = chromosomes.get(i).secondChromo.genes[k] != true;
                }

            }
            chromArray.add(chromosomes.get(i).secondChromo);
        }

        return chromArray;
    }

    @Override
    public ArrayList<Chromosome> replaceOldByNew(ArrayList<PairOfChromosome> chromosomes) {
        ArrayList<Chromosome> chromo = new ArrayList<>();
        for (PairOfChromosome pair : chromosomes) {
            chromo.add(pair.firstChromo);
            chromo.add(pair.secondChromo);
        }
        return chromo;
    }

    @Override
    public void PrintPairOfChromosomes(PairOfChromosome chromosomes) {

        print(chromosomes.toString());

    }

    private void print(String msg) {
        System.out.println(msg);
    }

}
