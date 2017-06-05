package gui;

import brain.VendingMachineBrain;
import enums.ECoin;
import enums.EVendingProduct;
import gui.forms.MainForm;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.beans.PropertyChangeEvent;

import static gui.MainFormData.COIN_RETURN_LABEL_KEY;
import static gui.MainFormData.VENDING_MACHINE_LABEL_KEY;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class MainFormWrapperTest {

    private MainFormWrapper mainFormWrapper;
    private MainForm mockMainForm;
    private VendingMachineBrain mockVendingMachineBrain;
    private MainFormData mockMainFormData;

    @Before
    public void setUp() {
        mockMainForm = mock(MainForm.class);
        mockVendingMachineBrain = mock(VendingMachineBrain.class);
        mockMainFormData = mock(MainFormData.class);
        mainFormWrapper = new MainFormWrapper();
        mainFormWrapper.setMainForm(mockMainForm);
        mainFormWrapper.setVendingMachineBrain(mockVendingMachineBrain);
        mainFormWrapper.setMainFormData(mockMainFormData);
    }

    @Test
    public void whenCreatedThenMainFormIsInstantiated() {
        assertThat(mainFormWrapper.getMainForm(), is(not(nullValue())));
        assertThat(mainFormWrapper.getMainForm(), is(instanceOf(JDialog.class)));
    }

    @Test
    public void whenLaunchFormThenMainFormSetContentPaneSetVisibleAndPackTheForm() {
        JPanel expectedHomePanel = new JPanel();
        when(mockMainForm.getHomePanel()).thenReturn(expectedHomePanel);
        stubMainFormWithMockComponents();
        mainFormWrapper.launchForm();

        verify(mockMainForm).setContentPane(expectedHomePanel);
        verify(mockMainForm).setVisible(true);
        verify(mockMainForm).pack();
    }

    @Test
    public void whenRetrieveInsertPennyButtonThenButtonIsRetrievedFromTheMainForm() {
        JButton expectedButton = new JButton();
        when(mockMainForm.getInsertPennyButton()).thenReturn(expectedButton);
        assertThat(mainFormWrapper.retrieveInsertPennyButton(), is(expectedButton));
    }

    @Test
    public void whenRetrieveInsertNickleButtonThenButtonIsRetrievedFromTheMainForm() {
        JButton expectedButton = new JButton();
        when(mockMainForm.getInsertNickleButton()).thenReturn(expectedButton);
        assertThat(mainFormWrapper.retrieveInsertNickleButton(), is(expectedButton));
    }

    @Test
    public void whenRetrieveInsertDimeButtonThenButtonIsRetrievedFromTheMainForm() {
        JButton expectedButton = new JButton();
        when(mockMainForm.getInsertDimeButton()).thenReturn(expectedButton);
        assertThat(mainFormWrapper.retrieveInsertDimeButton(), is(expectedButton));
    }

    @Test
    public void whenRetrieveInsertQuarterButtonThenButtonIsRetrievedFromTheMainForm() {
        JButton expectedButton = new JButton();
        when(mockMainForm.getInsertQuarterButton()).thenReturn(expectedButton);
        assertThat(mainFormWrapper.retrieveInsertQuarterButton(), is(expectedButton));
    }

    @Test
    public void whenRetrievePurchaseColaButtonThenButtonIsRetrievedFromTheMainForm() {
        JButton expectedButton = new JButton();
        when(mockMainForm.getPurchaseColaButton()).thenReturn(expectedButton);
        assertThat(mainFormWrapper.retrievePurchaseColaButton(), is(expectedButton));
    }

    @Test
    public void whenRetrievePurchaseChipsButtonThenButtonIsRetrievedFromTheMainForm() {
        JButton expectedButton = new JButton();
        when(mockMainForm.getPurchaseChipsButton()).thenReturn(expectedButton);
        assertThat(mainFormWrapper.retrievePurchaseChipsButton(), is(expectedButton));
    }

    @Test
    public void whenRetrievePurchaseCandyButtonThenButtonIsRetrievedFromTheMainForm() {
        JButton expectedButton = new JButton();
        when(mockMainForm.getPurchaseCandyButton()).thenReturn(expectedButton);
        assertThat(mainFormWrapper.retrievePurchaseCandyButton(), is(expectedButton));
    }

    @Test
    public void whenRetrieveRefundButtonThenButtonIsRetrievedFromTheMainForm() {
        JButton expectedButton = new JButton();
        when(mockMainForm.getReturnCoinsButton()).thenReturn(expectedButton);
        assertThat(mainFormWrapper.retrieveReturnCoinsButton(), is(expectedButton));
    }

    @Test
    public void whenRetrieveVendingDisplayLabelThenLabelIsRetrievedFromTheMainForm() {
        JLabel expectedLabel = new JLabel();
        when(mockMainForm.getVendingDisplayLabel()).thenReturn(expectedLabel);
        assertThat(mainFormWrapper.retrieveVendingDisplayLabel(), is(expectedLabel));
    }

    @Test
    public void whenCreatedThenHasVendingMachineComputer() {
        VendingMachineBrain vendingMachineBrain = mainFormWrapper.getVendingMachineBrain();
        assertThat(vendingMachineBrain, is(not(nullValue())));
        assertThat(vendingMachineBrain, is(instanceOf(VendingMachineBrain.class)));
    }

    @Test
    public void givenFormHasBeenLaunchedWhenInsertPennyButtonIsClickedThenVendingMachineBrainHasPennyInserted() {
        stubMainFormWithRealComponents();
        mainFormWrapper.launchForm();
        mainFormWrapper.retrieveInsertPennyButton().doClick();

        verify(mockVendingMachineBrain).insertCoin(ECoin.PENNY);
    }

    @Test
    public void givenFormHasBeenLaunchedWhenInsertNickleButtonIsClickedThenVendingMachineBrainHasNickleInserted() {
        stubMainFormWithRealComponents();
        mainFormWrapper.launchForm();
        mainFormWrapper.retrieveInsertNickleButton().doClick();

        verify(mockVendingMachineBrain).insertCoin(ECoin.NICKLE);
    }

    @Test
    public void givenFormHasBeenLaunchedWhenInsertDimeButtonIsClickedThenVendingMachineBrainHasDimeInserted() {
        stubMainFormWithRealComponents();
        mainFormWrapper.launchForm();
        mainFormWrapper.retrieveInsertDimeButton().doClick();

        verify(mockVendingMachineBrain).insertCoin(ECoin.DIME);
    }

    @Test
    public void givenFormHasBeenLaunchedWhenInsertQuarterButtonIsClickedThenVendingMachineBrainHasQuarterInserted() {
        stubMainFormWithRealComponents();
        mainFormWrapper.launchForm();
        mainFormWrapper.retrieveInsertQuarterButton().doClick();

        verify(mockVendingMachineBrain).insertCoin(ECoin.QUARTER);
    }

    @Test
    public void whenLaunchFormThenAddVendingDisplayLabelListenerToMainFormData() {
        stubMainFormWithMockComponents();
        mainFormWrapper.launchForm();

        verify(mockMainFormData).addUpdateVendingDisplayLabelListener(any());
    }

    @Test
    public void givenFormIsLaunchedWhenUpdateVendingDisplayLabelThenVendingDisplayLabelTextIsSetWithNewValue() {
        stubMainFormWithRealComponents();
        mainFormWrapper.launchForm();
        String expectedNewVendingDisplayLabelText = "The Forge is pretty cool, I guess";
        PropertyChangeEvent propertyChangeEvent = new PropertyChangeEvent(mainFormWrapper, VENDING_MACHINE_LABEL_KEY, "", expectedNewVendingDisplayLabelText);

        mainFormWrapper.updateVendingDisplayLabel(propertyChangeEvent);

        assertThat(mainFormWrapper.retrieveVendingDisplayLabel().getText(), is(expectedNewVendingDisplayLabelText));
    }

    @Test
    public void whenRetrieveCollectCoinReturnButtonThenButtonIsRetrievedFromTheMainForm() {
        JButton expectedButton = new JButton();
        when(mockMainForm.getCollectCoinReturnButton()).thenReturn(expectedButton);
        assertThat(mainFormWrapper.retrieveCollectCoinReturnButton(), is(expectedButton));
    }

    @Test
    public void whenRetrieveCoinReturnLabelThenLabelIsRetrievedFromTheMainForm() {
        JLabel expectedLabel = new JLabel();
        when(mockMainForm.getCoinReturnLabel()).thenReturn(expectedLabel);
        assertThat(mainFormWrapper.retrieveCoinReturnLabel(), is(expectedLabel));
    }

    @Test
    public void givenFormHasBeenLaunchedWhenReturnCoinButtonIsClickedThenVendingMachineBrainReturnsCoins() {
        stubMainFormWithRealComponents();
        mainFormWrapper.launchForm();
        mainFormWrapper.retrieveReturnCoinsButton().doClick();

        verify(mockVendingMachineBrain).returnCoins();
    }

    @Test
    public void givenFormHasBeenLaunchedWhenCollectCoinReturnButtonIsClickedThenVendingMachineBrainIsInformedThatCoinsHaveBeenCollected() {
        stubMainFormWithRealComponents();
        mainFormWrapper.launchForm();
        mainFormWrapper.retrieveCollectCoinReturnButton().doClick();

        verify(mockVendingMachineBrain).collectCoinReturn();
    }

    @Test
    public void whenLaunchFormThenSetDefaultCloseOperationToDisposeOnClose() {
        stubMainFormWithMockComponents();
        mainFormWrapper.launchForm();
        verify(mockMainForm).setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Test
    public void whenLaunchFormThenCoinReturnDisplayLabelListenerToMainFormData() {
        stubMainFormWithMockComponents();
        mainFormWrapper.launchForm();

        verify(mockMainFormData).addUpdateCoinReturnDisplayLabelListener(any());
    }

    @Test
    public void givenFormIsLaunchedWhenUpdateCoinReturnDisplayLabelThenCoinReturnDisplayLabelTextIsSetWithNewValue() {
        stubMainFormWithRealComponents();
        mainFormWrapper.launchForm();
        String expectedNewVendingDisplayLabelText = "In hindsight, the Roman Numeral Kata may have been faster";
        PropertyChangeEvent propertyChangeEvent = new PropertyChangeEvent(mainFormWrapper, COIN_RETURN_LABEL_KEY, "", expectedNewVendingDisplayLabelText);

        mainFormWrapper.updateCoinReturnDisplayLabel(propertyChangeEvent);

        assertThat(mainFormWrapper.retrieveCoinReturnLabel().getText(), is(expectedNewVendingDisplayLabelText));
    }

    @Test
    public void whenRetrieveDispensedItemLabelThenLabelIsRetrievedFromTheMainForm() {
        JLabel expectedLabel = new JLabel();
        when(mockMainForm.getDispensedItemLabel()).thenReturn(expectedLabel);
        assertThat(mainFormWrapper.retrieveDispensedItemLabel(), is(expectedLabel));
    }

    @Test
    public void givenFormHasBeenLaunchedWhenPurchaseColaButtonIsClickedThenVendingMachineBrainIsInformedOfPurchase() {
        stubMainFormWithRealComponents();
        mainFormWrapper.launchForm();
        mainFormWrapper.retrievePurchaseColaButton().doClick();

        verify(mockVendingMachineBrain).purchaseProduct(EVendingProduct.COLA);
    }

    @Test
    public void givenFormHasBeenLaunchedWhenPurchaseChipsButtonIsClickedThenVendingMachineBrainIsInformedOfPurchase() {
        stubMainFormWithRealComponents();
        mainFormWrapper.launchForm();
        mainFormWrapper.retrievePurchaseChipsButton().doClick();

        verify(mockVendingMachineBrain).purchaseProduct(EVendingProduct.CHIPS);
    }

    @Test
    public void givenFormHasBeenLaunchedWhenPurchaseCandyButtonIsClickedThenVendingMachineBrainIsInformedOfPurchase() {
        stubMainFormWithRealComponents();
        mainFormWrapper.launchForm();
        mainFormWrapper.retrievePurchaseCandyButton().doClick();

        verify(mockVendingMachineBrain).purchaseProduct(EVendingProduct.CANDY);
    }

    @Test
    public void whenLaunchFormThenAddDispensedItemDisplayLabelListenerToMainFormData() {
        stubMainFormWithMockComponents();
        mainFormWrapper.launchForm();

        verify(mockMainFormData).addUpdateDispensedItemLabelListener(any());
    }

    private void stubMainFormWithRealComponents() {
        when(mockMainForm.getInsertPennyButton()).thenReturn(new JButton());
        when(mockMainForm.getInsertNickleButton()).thenReturn(new JButton());
        when(mockMainForm.getInsertDimeButton()).thenReturn(new JButton());
        when(mockMainForm.getInsertQuarterButton()).thenReturn(new JButton());
        when(mockMainForm.getVendingDisplayLabel()).thenReturn(new JLabel());
        when(mockMainForm.getReturnCoinsButton()).thenReturn(new JButton());
        when(mockMainForm.getCollectCoinReturnButton()).thenReturn(new JButton());
        when(mockMainForm.getCoinReturnLabel()).thenReturn(new JLabel());
        when(mockMainForm.getPurchaseColaButton()).thenReturn(new JButton());
        when(mockMainForm.getPurchaseChipsButton()).thenReturn(new JButton());
        when(mockMainForm.getPurchaseCandyButton()).thenReturn(new JButton());
    }

    private void stubMainFormWithMockComponents() {
        when(mockMainForm.getInsertPennyButton()).thenReturn(mock(JButton.class));
        when(mockMainForm.getInsertNickleButton()).thenReturn(mock(JButton.class));
        when(mockMainForm.getInsertDimeButton()).thenReturn(mock(JButton.class));
        when(mockMainForm.getInsertQuarterButton()).thenReturn(mock(JButton.class));
        when(mockMainForm.getReturnCoinsButton()).thenReturn(mock(JButton.class));
        when(mockMainForm.getCollectCoinReturnButton()).thenReturn(mock(JButton.class));
        when(mockMainForm.getPurchaseColaButton()).thenReturn(mock(JButton.class));
        when(mockMainForm.getPurchaseChipsButton()).thenReturn(mock(JButton.class));
        when(mockMainForm.getPurchaseCandyButton()).thenReturn(mock(JButton.class));
    }

}
