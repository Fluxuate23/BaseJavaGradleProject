package brain;

import enums.ECoin;
import gui.MainFormData;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class VendingMachineBrainTest {

    private VendingMachineBrain vendingMachineBrain;
    private MainFormData mockMainFormData;

    @Before
    public void setUp() {
        mockMainFormData = mock(MainFormData.class);
        vendingMachineBrain = new VendingMachineBrain(mockMainFormData);
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

    @Test
    public void givenCurrentDollarAmountGreaterThanZeroWhenInsertCoinWithQuarterThenIncrementDollarAmountByTwentyFiveCents() {
        vendingMachineBrain.setCurrentDollarAmount(0.01);
        vendingMachineBrain.insertCoin(ECoin.QUARTER);

        assertThat(vendingMachineBrain.getCurrentDollarAmount(), is(0.26));
    }

    @Test
    public void whenInsertCoinThenUpdateMainFormDataWithCurrentDollarAmount() {
        vendingMachineBrain.insertCoin(ECoin.QUARTER);

        verify(mockMainFormData).updateVendingDisplayLabel("$0.25");
    }

    @Test
    public void givenCurrentDollarAmountGreaterThanZeroWhenInsertCoinThenUpdateMainFormDataWithFormattedCurrentDollarAmount() {
        vendingMachineBrain.setCurrentDollarAmount(0.11111111111);
        vendingMachineBrain.insertCoin(ECoin.DIME);

        verify(mockMainFormData).updateVendingDisplayLabel("$0.21");
    }

    @Test
    public void whenInsertCoinAndDollarAmountHasOneDecimalPointThenUpdateVendingDiplayLabelWithFormatShowingTwoDecimalPoints() {
        vendingMachineBrain.insertCoin(ECoin.DIME);

        verify(mockMainFormData).updateVendingDisplayLabel("$0.10");
    }

    @Test
    public void whenInsertPennyThenDoNotUpdateVendingDisplayLabel() {
        vendingMachineBrain.insertCoin(ECoin.PENNY);

        verify(mockMainFormData, never()).updateVendingDisplayLabel(anyString());
    }

    @Test
    public void givenCurrentDollarAmountIsGreaterThanZeroWhenReturnCoinsThenCurrentDollarAmountIsResetToZero() {
        vendingMachineBrain.setCurrentDollarAmount(100);
        vendingMachineBrain.returnCoins();

        assertThat(vendingMachineBrain.getCurrentDollarAmount(), is(0.0));
    }

    @Test
    public void whenReturnCoinsThenUpdateMainMainFormDataWithInsertCoin() {
        vendingMachineBrain.returnCoins();

        verify(mockMainFormData).updateVendingDisplayLabel("INSERT COIN");
    }

}
