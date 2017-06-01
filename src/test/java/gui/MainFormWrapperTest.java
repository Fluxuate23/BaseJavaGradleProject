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
    public void whenRetrieveInsertPennyButtonThenButtonIsRetreivedFromTheMainForm() {
        JButton expectedButton = new JButton();
        when(mockMainForm.getInsertPennyButton()).thenReturn(expectedButton);
        assertThat(mainFormWrapper.retrieveInsertPennyButton(), is(expectedButton));
    }

}