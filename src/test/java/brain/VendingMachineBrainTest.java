package brain;

import enums.ECoin;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class VendingMachineBrainTest {

    private VendingMachineBrain vendingMachineBrain;

    @Before
    public void setUp() {
        vendingMachineBrain = new VendingMachineBrain();
    }

    @Test
    public void whenInsertCoinWithNickleThenCurrentDollarAmountIsFiveCents() {
        vendingMachineBrain.insertCoin(ECoin.NICKLE);

        assertThat(vendingMachineBrain.getCurrentDollarAmount(), is(0.05));
    }

    @Test
    public void whenInsertCoinWithPennyThenCurrentDollarAmountIsZeroCents() {
        vendingMachineBrain.insertCoin(ECoin.PENNY);

        assertThat(vendingMachineBrain.getCurrentDollarAmount(), is(0.0));
    }

    @Test
    public void whenInsertCoinWithDimeThenCurrentDollarAmountIsTenCents() {
        vendingMachineBrain.insertCoin(ECoin.DIME);

        assertThat(vendingMachineBrain.getCurrentDollarAmount(), is(0.1));
    }

    @Test
    public void whenInsertCoinWithQuarterThenCurrentDollarAmountIsTwentyFiveCents() {
        vendingMachineBrain.insertCoin(ECoin.QUARTER);

        assertThat(vendingMachineBrain.getCurrentDollarAmount(), is(0.25));
    }

    @Test
    public void givenCurrentDollarAmountGreaterThanZeroWhenInsertCoinWithNickleThenIncrementDollarAmountByFiveCents() {
        vendingMachineBrain.setCurrentDollarAmount(350);
        vendingMachineBrain.insertCoin(ECoin.NICKLE);

        assertThat(vendingMachineBrain.getCurrentDollarAmount(), is(350.05));
    }

    @Test
    public void givenCurrentDollarAmountGreaterThanZeroWhenInsertCoinWithDimeThenIncrementDollarAmountByTenCents() {
        vendingMachineBrain.setCurrentDollarAmount(9000);
        vendingMachineBrain.insertCoin(ECoin.DIME);

        assertThat(vendingMachineBrain.getCurrentDollarAmount(), is(9000.1));
    }

}