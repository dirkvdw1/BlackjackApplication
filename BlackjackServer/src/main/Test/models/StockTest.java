package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class StockTest {

    private Stock stockUnderTest;

    @BeforeEach
    void setUp() {
        stockUnderTest = new Stock();
        stockUnderTest.amount = 0;
    }

    @Test
    void testDrawCard() {

        // Run the test
        final Card result = stockUnderTest.drawCard();

        // Verify the results
        assertNotNull(result);
    }
}
