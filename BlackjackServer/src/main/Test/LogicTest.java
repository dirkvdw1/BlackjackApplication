import Client.Logic;
import models.Dealercards;
import models.PlayerCards;
import models.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class LogicTest {

    private Logic logicUnderTest;
    private List<PlayerCards> playerlist;
    private Dealercards dealer;

    @BeforeEach
    void setUp() {
        logicUnderTest = new Logic();
        playerlist = new ArrayList<>();
        dealer = new Dealercards();
    }


    void Createlist() {
        playerlist.add(new PlayerCards());
        playerlist.add(new PlayerCards());
    }
    @Test
    void testStartNewGame() {
        Createlist();
        // Run the test
      //  final Table result = logicUnderTest.startNewGame(playerlist, dealer);


        // Verify the results
        assertEquals(2,playerlist.get(0).getCards().size());
        assertEquals(2,dealer.getCards().size());

    }

    @Test
    void testHitHandIntegration() {


        // Run the test
        testStartNewGame();
        final PlayerCards result = logicUnderTest.hitHand(playerlist.get(0));

        // Verify the results
        assertEquals(3,result.getCards().size());
    }

    @Test
    void testStandHand() {
        testStartNewGame();
        final PlayerCards result = logicUnderTest.standHand(playerlist.get(1));

        // Verify the results
        assertNotNull(result.getMessage());
    }

    @Test
    void testStartDealer() {
        testStartNewGame();
        testHitHand();
        final Dealercards result = logicUnderTest.startDealer(dealer);

        assertTrue(result.getvalue()  <= 17 );


    }

    @Test
    void testEndGame() {
        // Setup
        testStartNewGame();
        testHitHand();


        final Table result = logicUnderTest.endGame(playerlist, dealer);



    }
    void testHitHand() {

        final PlayerCards result = logicUnderTest.hitHand(playerlist.get(0));


        assertEquals(3,result.getCards().size());
    }
}
