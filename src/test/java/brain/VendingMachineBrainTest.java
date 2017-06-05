package brain;

import enums.ECoin;
import enums.EVendingProduct;
import gui.MainFormData;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class VendingMachineBrainTest {

    private VendingMachineBrain vendingMachineBrain;
    private MainFormData mockMainFormData;
    private ScheduledExecutorService mockScheduledExecutorService;
    private ArgumentCaptor<MainFormDataRunnableTask> mainFormDataRunnableTaskCaptor;

    @Before
    public void setUp() {
        mockMainFormData = mock(MainFormData.class);
        mockScheduledExecutorService = mock(ScheduledExecutorService.class);
        mainFormDataRunnableTaskCaptor = ArgumentCaptor.forClass(MainFormDataRunnableTask.class);
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
    public void givenCurrentDollarAmountGreaterThanZeroWhenReturnCoinsThenUpdateMainFormDataWithFormattedCurrentDollarAmountBeforeItIsResetToZero() {
        vendingMachineBrain.setCurrentDollarAmount(0.1);
        vendingMachineBrain.returnCoins();

        verify(mockMainFormData).updateCoinReturnLabel("$0.10");
        assertThat(vendingMachineBrain.getCurrentDollarAmount(), is(0.0));
    }

    @Test
    public void givenCurrentDollarAmountIsZeroWhenReturnCoinsThenDoNotUpdateMainFormData() {
        vendingMachineBrain.returnCoins();

        verify(mockMainFormData, never()).updateVendingDisplayLabel(anyString());
        verify(mockMainFormData, never()).updateCoinReturnLabel(anyString());
    }

    @Test
    public void givenCurrentCoinReturnDollarAmountAndCurrentDollarAmountAreGreaterThanZeroWhenReturnCoinsThenUpdateMainFormDataWithAddedValues() {
        vendingMachineBrain.setCurrentCoinReturnDollarAmount(50.0);
        vendingMachineBrain.setCurrentDollarAmount(25.0);

        vendingMachineBrain.returnCoins();

        verify(mockMainFormData).updateCoinReturnLabel("$75.00");
    }

    @Test
    public void givenCurrentCoinReturnDollarAmountGreaterThanZeroWhenCollectCoinReturnThenCurrentCoinReturnDollarAmountIsSetToZeroAndMainFormDataUpdatesCoinReturnLabel() {
        vendingMachineBrain.setCurrentCoinReturnDollarAmount(1.1);

        vendingMachineBrain.collectCoinReturn();

        verify(mockMainFormData).updateCoinReturnLabel("");
        assertThat(vendingMachineBrain.getCurrentCoinReturnDollarAmount(), is(0.0));
    }

    @Test
    public void whenInsertCoinWithPennyThenUpdateMainFormDataCoinReturnToHaveOneCentAndCurrentCoinReturnDollarAmountToOneCent() {
        vendingMachineBrain.insertCoin(ECoin.PENNY);

        assertThat(vendingMachineBrain.getCurrentCoinReturnDollarAmount(), is(0.01));
        verify(mockMainFormData).updateCoinReturnLabel("$0.01");
    }

    @Test
    public void givenCurrentCoinReturnDollarAmountGreaterThanZeroWhenInsertCoinWithPennyThenAddToCurrentCoinReturnDollarAmountAndUpdateMainFormWithNewValue() {
        vendingMachineBrain.setCurrentCoinReturnDollarAmount(.25);
        vendingMachineBrain.insertCoin(ECoin.PENNY);

        assertThat(vendingMachineBrain.getCurrentCoinReturnDollarAmount(), is(0.26));
        verify(mockMainFormData).updateCoinReturnLabel("$0.26");
    }

    @Test
    public void whenCreatedThenItCreatesAScheduledExecutorService() {
        assertThat(vendingMachineBrain.getScheduledExecutorService(), is(not(nullValue())));
        assertThat(vendingMachineBrain.getScheduledExecutorService(), is(instanceOf(ExecutorService.class)));
    }

    @Test
    public void whenPurchaseProductWithColaThenUpdateVendingDisplayLabelToOneDollarAndScheduleFutureToUpdateVendingDisplayLabel() {
        vendingMachineBrain.setScheduledExecutorService(mockScheduledExecutorService);

        vendingMachineBrain.purchaseProduct(EVendingProduct.COLA);

        verify(mockMainFormData).updateVendingDisplayLabel("$1.00");
        verify(mockScheduledExecutorService).schedule(mainFormDataRunnableTaskCaptor.capture(), eq(1L), eq(TimeUnit.SECONDS));
        assertThat(mainFormDataRunnableTaskCaptor.getValue().getDesiredFutureText(), is("INSERT COIN"));
    }

    @Test
    public void givenLessThanOneDollarButMoreThanZeroWhenPurchaseProductWithColaThenUpdateVendingDisplayLabelToOneDollarAndScheduleFutureToUpdateVendingDisplayLabelToCurrentDollarAmount() {
        vendingMachineBrain.setScheduledExecutorService(mockScheduledExecutorService);
        vendingMachineBrain.setCurrentDollarAmount(.5);

        vendingMachineBrain.purchaseProduct(EVendingProduct.COLA);

        verify(mockMainFormData).updateVendingDisplayLabel("$1.00");
        verify(mockScheduledExecutorService).schedule(mainFormDataRunnableTaskCaptor.capture(), eq(1L), eq(TimeUnit.SECONDS));
        assertThat(mainFormDataRunnableTaskCaptor.getValue().getDesiredFutureText(), is("$0.50"));
    }

}
