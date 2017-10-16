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
class Gene {

    float lowerBound;
    float upperBound;
    boolean geneExist;

    Gene(float newLowerBound, float newUpperBound, boolean geneStatus) {
        lowerBound = newLowerBound;
        upperBound = newUpperBound;
        geneExist = geneStatus;
    }

    @Override
    public String toString() {
        return "Gene{" + "lowerBound=" + lowerBound + ",\nupperBound=" + upperBound + ","
                + "\ngeneExist=" + geneExist + '}';
    }

}
