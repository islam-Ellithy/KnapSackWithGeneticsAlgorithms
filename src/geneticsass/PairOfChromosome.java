/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticsass;

/**
 *
 * @author MrHacker
 */
public class PairOfChromosome {

    public Chromosome firstChromo;
    public Chromosome secondChromo;

    public PairOfChromosome() {
    }

    public PairOfChromosome(Chromosome firstChromo, Chromosome secondChromo) {
        this.firstChromo = firstChromo;
        this.secondChromo = secondChromo;
    }
}
