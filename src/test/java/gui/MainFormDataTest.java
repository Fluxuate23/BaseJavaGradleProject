package gui;

import org.junit.Before;
import org.junit.Test;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import static gui.MainFormData.COIN_RETURN_LABEL_KEY;
import static gui.MainFormData.VENDING_MACHINE_LABEL_KEY;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MainFormDataTest {

    private PropertyChangeSupport mockPropertyChangeSupport;
    private PropertyChangeListener mockPropertyChangeListener;
    private MainFormData mainFormData;

    @Before
    public void setUp() {
        mockPropertyChangeSupport = mock(PropertyChangeSupport.class);
        mockPropertyChangeListener = mock(PropertyChangeListener.class);
        mainFormData = new MainFormData();
        mainFormData.setPropertyChangeSupport(mockPropertyChangeSupport);
    }

    @Test
    public void whenCreatedThenItHasPropertyChangeSupport() {
        mainFormData = new MainFormData();
        assertThat(mainFormData.getPropertyChangeSupport(), is(not(nullValue())));
        assertThat(mainFormData.getPropertyChangeSupport(), is(instanceOf(PropertyChangeSupport.class)));
    }

    @Test
    public void whenAddUpdateVendingDisplayLabelListenerThenPropertyChangeSupportHasPropertyChangeListenerAddedWithVendingDisplayLabelKey() {
        mainFormData.addUpdateVendingDisplayLabelListener(mockPropertyChangeListener);

        verify(mockPropertyChangeSupport).addPropertyChangeListener(VENDING_MACHINE_LABEL_KEY, mockPropertyChangeListener);
    }

    @Test
    public void givenVendingDisplayLabelListenerWhenUpdateVendingDisplayLabelThenPropertyChangeSupportPropertyChangeIsFiredWithVendingDisplayLabelKey() {
        String expectedNewValue = "Test strings are the best part of every PR";
        mainFormData.addUpdateVendingDisplayLabelListener(mockPropertyChangeListener);

        mainFormData.updateVendingDisplayLabel(expectedNewValue);

        verify(mockPropertyChangeSupport).firePropertyChange(VENDING_MACHINE_LABEL_KEY, "", expectedNewValue);
    }

    @Test
    public void whenAddUpdateCoinReturnDisplayLabelListenerThenPropertyChangeSupportHasPropertyChangeListenerAddedWithCoinReturnDisplayLabelKey() {
        mainFormData.addUpdateCoinReturnDisplayLabelListener(mockPropertyChangeListener);

        verify(mockPropertyChangeSupport).addPropertyChangeListener(COIN_RETURN_LABEL_KEY, mockPropertyChangeListener);
    }

    @Test
    public void givenCoinReturnDisplayLabelListenerWhenUpdateVendingDisplayLabelThenPropertyChangeSupportPropertyChangeIsFiredWithCoinReturnLabelKey() {
        String expectedNewValue = "one million dollars";
        mainFormData.addUpdateVendingDisplayLabelListener(mockPropertyChangeListener);

        mainFormData.updateCoinReturnLabel(expectedNewValue);

        verify(mockPropertyChangeSupport).firePropertyChange(COIN_RETURN_LABEL_KEY, "", expectedNewValue);
    }

    @Test
    public void givenCoinReturnDisplayLabelListenerWhenUpdateVendingDisplayLabelTwiceWithDifferentValuesThenPropertyChangeIsFiredWithDifferentOldValues() {
        String expectedNewValue = "my acceptance tests caught this problem";
        String secondExpectedNewValue = "i <3 tdd";
        mainFormData.addUpdateVendingDisplayLabelListener(mockPropertyChangeListener);

        mainFormData.updateCoinReturnLabel(expectedNewValue);
        mainFormData.updateCoinReturnLabel(secondExpectedNewValue);

        verify(mockPropertyChangeSupport).firePropertyChange(COIN_RETURN_LABEL_KEY, "", expectedNewValue);
        verify(mockPropertyChangeSupport).firePropertyChange(COIN_RETURN_LABEL_KEY, expectedNewValue, secondExpectedNewValue);
    }
}
