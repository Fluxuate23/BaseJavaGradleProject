package gui;

import brain.VendingMachineBrain;
import enums.ECoin;
import gui.MainFormWrapper;
import gui.forms.MainForm;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import javax.swing.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.any;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        when(mockMainForm.getRefundButton()).thenReturn(expectedButton);
        assertThat(mainFormWrapper.retrieveRefundButton(), is(expectedButton));
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

        verify(mockMainFormData).addUpdateVendingDisplayLabelListener(Matchers.any());
    }

    @Test
    public void givenFormIsLaunchedWhenUpdateVendingDisplayLabelThenVendingDisplayLabelTextIsSetWithNewValue() {
        stubMainFormWithRealComponents();
        mainFormWrapper.launchForm();
        String expectedNewVendingDisplayLabelText = "The Forge is pretty cool, I guess";
        PropertyChangeEvent propertyChangeEvent = new PropertyChangeEvent(mainFormWrapper, "VendingMachineLabel", "", expectedNewVendingDisplayLabelText);

        mainFormWrapper.updateVendingDisplayLabel(propertyChangeEvent);

        assertThat(mainFormWrapper.retrieveVendingDisplayLabel().getText(), is(expectedNewVendingDisplayLabelText));
    }

    private void stubMainFormWithRealComponents() {
        when(mockMainForm.getInsertPennyButton()).thenReturn(new JButton());
        when(mockMainForm.getInsertNickleButton()).thenReturn(new JButton());
        when(mockMainForm.getInsertDimeButton()).thenReturn(new JButton());
        when(mockMainForm.getInsertQuarterButton()).thenReturn(new JButton());
        when(mockMainForm.getVendingDisplayLabel()).thenReturn(new JLabel());
    }

    private void stubMainFormWithMockComponents() {
        when(mockMainForm.getInsertPennyButton()).thenReturn(mock(JButton.class));
        when(mockMainForm.getInsertNickleButton()).thenReturn(mock(JButton.class));
        when(mockMainForm.getInsertDimeButton()).thenReturn(mock(JButton.class));
        when(mockMainForm.getInsertQuarterButton()).thenReturn(mock(JButton.class));
    }

}