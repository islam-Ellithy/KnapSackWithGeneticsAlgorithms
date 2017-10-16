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
public interface Modification {

    int fitnessFunction(Chromosome chromosome);

    ArrayList<PairOfChromosome> selection(ArrayList<Chromosome> chromosomes);

    ArrayList<PairOfChromosome> crossover(ArrayList<PairOfChromosome> chromosomes);

    ArrayList<PairOfChromosome> mutation(ArrayList<PairOfChromosome> chromosomes);

    ArrayList<Chromosome> replaceOldByNew(ArrayList<PairOfChromosome> chromosomes);

    void PrintPairOfChromosomes(PairOfChromosome chromosomes);
}
