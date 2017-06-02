package brain;

import enums.ECoin;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class VendingMachineBrainTest {

    @Test
    public void whenInsertNickleThenCurrentDollarAmountIsFiveCents() {
        VendingMachineBrain vendingMachineBrain = new VendingMachineBrain();
        vendingMachineBrain.insertCoin(ECoin.NICKLE);

        assertThat(vendingMachineBrain.getCurrentDollarAmount(), is(0.05));
    }

    @Test
    public void whenInsertPennyThenCurrentDollarAmountIsZeroCents() {
        VendingMachineBrain vendingMachineBrain = new VendingMachineBrain();
        vendingMachineBrain.insertCoin(ECoin.PENNY);

        assertThat(vendingMachineBrain.getCurrentDollarAmount(), is(0.0));
    }

}