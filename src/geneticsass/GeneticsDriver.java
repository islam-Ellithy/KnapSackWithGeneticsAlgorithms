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

        float r = 0;
        for (int i = 0; i < chromosomes.size(); i++) {
            PairOfChromosome pair = chromosomes.get(i);
            r = KnapSackProblem.generateRandomNumber();
            print(r + "");
        }
        return chromosomes;
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
