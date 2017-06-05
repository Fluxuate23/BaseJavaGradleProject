package brain;

import gui.MainFormData;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MainFormDataRunnableTaskTest {

    @Test
    public void whenRunThenUpdateVendingDisplayLabelToDesiredFutureText() {
        MainFormData mockMainFormData = mock(MainFormData.class);
        MainFormDataRunnableTask mainFormDataRunnableTask = new MainFormDataRunnableTask(mockMainFormData, "Let's hope this works!");
        mainFormDataRunnableTask.run();
        verify(mockMainFormData).updateVendingDisplayLabel("Let's hope this works!");
    }

}
