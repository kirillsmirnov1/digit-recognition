package trulden.recognition;

import org.junit.jupiter.api.Test;

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

}