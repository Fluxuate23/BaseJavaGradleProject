package gui;

import gui.forms.MainForm;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.hamcrest.core.Is.is;
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

    @Before
    public void setUp() {
        mockMainForm = mock(MainForm.class);
        mainFormWrapper = new MainFormWrapper();
        mainFormWrapper.setMainForm(mockMainForm);
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

}