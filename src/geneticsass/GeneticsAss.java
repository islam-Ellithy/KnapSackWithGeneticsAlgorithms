/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticsass;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MrHacker
 */
public class GeneticsAss {

    static int numOfTestCases;
    static int sizeOfKnapSack;
    static ArrayList<Item> items = new ArrayList<>();

    private static void getInput() {
        Scanner keyBoard = new Scanner(System.in);
        numOfTestCases = keyBoard.nextInt();
        Chromosome.numOfItems = keyBoard.nextInt();
        sizeOfKnapSack = keyBoard.nextInt();

        for (int i = 0; i < Chromosome.numOfItems; i++) {
            items.add(new Item(keyBoard.nextInt(), keyBoard.nextInt()));
        }
    }

    private static ArrayList<Chromosome> generatePopulation(int size) {
        ArrayList<Chromosome> population = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            population.add(generateChromosome());
        }

        return population;
    }

    private static Chromosome generateChromosome() {

        Chromosome chromosome = new Chromosome();
        for (int i = 0; i < chromosome.genes.length; i++) {
            chromosome.genes[i] = Math.random() > 0.5;
        }
        return chromosome;
    }

    public static void main(String[] args) {
        // TODO code application logic here   
        getInput();
        GeneticsDriver driver = new GeneticsDriver();
        ArrayList<Chromosome> population = generatePopulation(10);
        for (Chromosome chromosome : population) {
            if (chromosome.fitness>sizeOfKnapSack) {
                chromosome.fitness = 1/chromosome.fitness;
            }
        }
    }

}
