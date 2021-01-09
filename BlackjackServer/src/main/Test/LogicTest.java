import models.Dealercards;
import models.PlayerCards;
import models.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LogicTest {

    private Logic logicUnderTest;

    @BeforeEach
    void setUp() {
        logicUnderTest = new Logic();
    }


    List<PlayerCards> Createlist() {
        List<PlayerCards> list = new ArrayList<>();
        list.add(new PlayerCards());
        list.add(new PlayerCards());
        return list;
    }
    @Test
    void testStartNewGame() {
        // Setup
        final List<PlayerCards> playerList = Createlist();
        final Dealercards dealer = new Dealercards();

        // Run the test
        final Table result = logicUnderTest.startNewGame(playerList, dealer);


        // Verify the results
        assertEquals(2,playerList.get(0).getCards().size());
        assertEquals(2,dealer.getCards().size());

    }

    @Test
    void testHitHand() {
        // Setup
        final PlayerCards player = new PlayerCards();

        // Run the test
        final PlayerCards result = logicUnderTest.hitHand(player);

        // Verify the results
        assertEquals(1,result.getCards().size());
    }

    @Test
    void testStandHand() {
        // Setup
        final PlayerCards player = new PlayerCards();

        // Run the test
        final PlayerCards result = logicUnderTest.standHand(player);

        // Verify the results
        assertNotNull(result.getMessage());
    }

    @Test
    void testStartDealer() {
        // Setup
        final Dealercards dealer = new Dealercards();

        // Run the test
        final Dealercards result = logicUnderTest.startDealer(dealer);

        // Verify the results
        
    }

    @Test
    void testEndGame() {
        // Setup
        final List<PlayerCards> players = Arrays.asList(new PlayerCards());
        final Dealercards dealer = new Dealercards();

        // Run the test
        final Table result = logicUnderTest.endGame(players, dealer);

        // Verify the results
    }
}
