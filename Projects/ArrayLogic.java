//display of hardcoded arrays and manipulating their data
//in this application, math functions are performed on the array to calculate mean and variance

public class ArrayLogic {
    public static void main (String args[])
    {
        int testVals[] = {89, 95, 72, 83, 99, 54, 86, 75, 92, 73, 79, 75, 82, 73};
        double variance[] = new double [testVals.length];
        double totalVariance = 0;
        double average = 0;

        System.out.printf("Original values in array: ");
        average = calc_avg(testVals);
        System.out.printf("\nThe average of all values in the array is: %1.2f", average);
        totalVariance = variance(testVals, variance, average);
        System.out.printf("\nThe variance of all values in the array is: %1.2f\n", totalVariance);
    }
    public static double calc_avg(int testVals[])
    {
        double average = 0;

        for (int i=0; i<testVals.length; i++)
        {
            average += testVals[i];
            System.out.printf(testVals[i] + " ");
        }
        average /= testVals.length;
        return average;
    }
    public static double variance(int testVals[], double variance[], double average)
    {
        double totalVariance = 0;

        for (int i=0; i<testVals.length; i++)
        {
            variance[i] = testVals[i] - average;
            variance[i] = Math.pow(variance[i], 2);
            totalVariance += variance[i];
        }
        totalVariance /= testVals.length;
        return totalVariance;
    }
}
