package trulden.recognition;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NetworkTest {

    // Test of basic functions
    @Test
    public void doesAtLeastRun(){
        Main main = new Main();

        main.forgetTheNetwork();

        main.teachNetwork();

        main.testNetworkOnIdealNumbers();
    }

    @Test
    void calculateIdealOutputTest() {
        double[] right = new double[] {0.3, 0.2, 0.1};
        double[][] weight = new double[][] {{0.2, 0.1, 0.7}, {1.2, 2.1, 1.1}};

        double[] expect = new double[] {(0.3/0.2 + 0.2/0.1 + 0.1/0.7) / 3d, (0.3/1.2 + 0.2/2.1 + 0.1/1.1) / 3d};
        double[] got    = Network.calculateIdealOutput(weight, right);

        System.out.println("Expect: " + Arrays.toString(expect) + "\nGot:    " + Arrays.toString(got));

        assertArrayEquals(expect, got);
    }

    @Test
    void calculateDifferenceTest() {
        assertArrayEquals(new double[]{-0.5, 0.9}, Network.calculateDifference(new double[]{0.2, 1.1}, new double[]{0.7, 0.2}), 0.00001);
    }
}