package gui;

import gui.MainFormData;
import org.junit.Test;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

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

    @Test
    public void whenCreatedThenItHasPropertyChangeSupport() {
        MainFormData mainFormData = new MainFormData();
        assertThat(mainFormData.getPropertyChangeSupport(), is(not(nullValue())));
        assertThat(mainFormData.getPropertyChangeSupport(), is(instanceOf(PropertyChangeSupport.class)));
    }

    @Test
    public void whenAddUpdateVendingDisplayLabelListenerThenPropertyChangeSupportHasPropertyChangeListenerAddedWithVendingDisplayLabelKey() {
        MainFormData mainFormData = new MainFormData();
        mockPropertyChangeSupport = mock(PropertyChangeSupport.class);
        mockPropertyChangeListener = mock(PropertyChangeListener.class);
        mainFormData.setPropertyChangeSupport(mockPropertyChangeSupport);

        mainFormData.addUpdateVendingDisplayLabelListener(mockPropertyChangeListener);

        verify(mockPropertyChangeSupport).addPropertyChangeListener(VENDING_MACHINE_LABEL_KEY, mockPropertyChangeListener);
    }

    @Test
    public void givenVendingDisplayLabelListenerWhenUpdateVendingDisplayLabelThenPropertyChangeSupportPropertyChangeIsFiredWithVendingDisplayLabelKey() {
        MainFormData mainFormData = new MainFormData();
        mockPropertyChangeSupport = mock(PropertyChangeSupport.class);
        mockPropertyChangeListener = mock(PropertyChangeListener.class);
        mainFormData.setPropertyChangeSupport(mockPropertyChangeSupport);
        mainFormData.addUpdateVendingDisplayLabelListener(mockPropertyChangeListener);
        String expectedNewValue = "Test strings are the best part of every PR";

        mainFormData.updateVendingDisplayLabel(expectedNewValue);

        verify(mockPropertyChangeSupport).firePropertyChange(VENDING_MACHINE_LABEL_KEY, "", expectedNewValue);
    }
}
