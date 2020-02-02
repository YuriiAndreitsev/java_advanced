package ua.compare;

import com.randomizer.App;

/**
 * Found out which Thread randomized bigger integer;
 *
 */
public class CompareApp 
{
    public static void main( String[] args )
    {
        App randomizer1 = new App();
        
        App randomizer2 = new App();
        
        int firstRandomizerSum = randomizer1.getFiveRandomIntegers();
        int secondRandomizerSum = randomizer2.getFiveRandomIntegers();
        
        System.out.println( firstRandomizerSum + " ; "+ secondRandomizerSum);
        if (firstRandomizerSum > secondRandomizerSum) {
        	System.out.println("Randomizer1 has bigger integer");
        } else {
        	System.out.println("Randomizer2 has bigger integer");
        }
    }
}
