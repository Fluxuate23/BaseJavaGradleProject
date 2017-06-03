package gui.forms;

import gui.MainFormData;
import org.junit.Test;

import java.beans.PropertyChangeSupport;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class MainFormDataTest {

    @Test
    public void whenCreatedThenItHasPropertyChangeSupport() {
        MainFormData mainFormData = new MainFormData();
        assertThat(mainFormData.getPropertyChangeSupport(), is(not(nullValue())));
        assertThat(mainFormData.getPropertyChangeSupport(), is(instanceOf(PropertyChangeSupport.class)));
    }
}
