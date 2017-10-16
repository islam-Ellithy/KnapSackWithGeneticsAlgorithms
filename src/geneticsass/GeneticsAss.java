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

    public static void main(String[] args) {
        // TODO code application logic here   

        KnapSackProblem ksp = new KnapSackProblem();
        ksp.getInput();
        GeneticsDriver driver = new GeneticsDriver();
        ArrayList<PairOfChromosome> crossoverResult = driver.crossover(ksp.getDummyListOfPairOfChromosome());

        driver.PrintPairOfChromosomes(crossoverResult.get(0));

    }
}
