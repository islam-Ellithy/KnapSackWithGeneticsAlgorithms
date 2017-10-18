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
        for (int i = 0; i < numOfTestCases; i++) {
            ArrayList<PairOfChromosome> pairs;
            for (Chromosome chromosome : population) {
                driver.fitnessFunction(chromosome, items, sizeOfKnapSack);
            }
            pairs = driver.selection(population);
            pairs = driver.crossover(pairs);
            population = driver.mutation(pairs);
            for (Chromosome chromosome : population) {
                driver.fitnessFunction(chromosome, items, sizeOfKnapSack);

            }
            Chromosome currentBest = population.get(0);
            float currentBestFitness = population.get(0).fitness;
            for (Chromosome chromosome : population) {
                if (chromosome.fitness > currentBestFitness) {
                    currentBestFitness = chromosome.fitness;
                    currentBest = chromosome;
                }
            }
            int benefit = 0;
            for (int j = 0; j < Chromosome.numOfItems; j++) {
                benefit += currentBest.genes[j] ? items.get(j).benefit : 0;
            }
            System.out.println("case " + i + ": " + benefit);
            int item = currentBest.genes[0] == true ? 1 : 0;
            for (int j = 1; j < Chromosome.numOfItems; j++) {
                item += currentBest.genes[j] == true ? 1 : 0;
            }
            System.out.println(item);
            for (int j = 0; j < Chromosome.numOfItems; j++) {
                if (currentBest.genes[j] == true) {
                    System.out.println(items.get(j).weight + " " + items.get(j).benefit);
                }
            }
        }
    }

}
