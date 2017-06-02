package brain;

import enums.ECoin;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class VendingMachineBrainTest {

    @Test
    public void whenInsertCoinWithNickleThenCurrentDollarAmountIsFiveCents() {
        VendingMachineBrain vendingMachineBrain = new VendingMachineBrain();
        vendingMachineBrain.insertCoin(ECoin.NICKLE);

        assertThat(vendingMachineBrain.getCurrentDollarAmount(), is(0.05));
    }

    @Test
    public void whenInsertCoinWithPennyThenCurrentDollarAmountIsZeroCents() {
        VendingMachineBrain vendingMachineBrain = new VendingMachineBrain();
        vendingMachineBrain.insertCoin(ECoin.PENNY);

        assertThat(vendingMachineBrain.getCurrentDollarAmount(), is(0.0));
    }

    @Test
    public void whenInsertCoinWithDimeThenCurrentDollarAmountIsTenCents() {
        VendingMachineBrain vendingMachineBrain = new VendingMachineBrain();
        vendingMachineBrain.insertCoin(ECoin.DIME);

        assertThat(vendingMachineBrain.getCurrentDollarAmount(), is(0.1));
    }

    @Test
    public void whenInsertCoinWithQuarterThenCurrentDollarAmountIsTwentyFiveCents() {
        VendingMachineBrain vendingMachineBrain = new VendingMachineBrain();
        vendingMachineBrain.insertCoin(ECoin.QUARTER);

        assertThat(vendingMachineBrain.getCurrentDollarAmount(), is(0.25));
    }


}