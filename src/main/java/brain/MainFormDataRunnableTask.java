package brain;

import gui.MainFormData;

public class MainFormDataRunnableTask implements Runnable {

    private final MainFormData mainFormData;
    private String desiredFutureText;

    public MainFormDataRunnableTask(MainFormData mainFormData, String desiredFutureText) {
        this.mainFormData = mainFormData;
        this.desiredFutureText = desiredFutureText;
    }

    @Override
    public void run() {
        mainFormData.updateVendingDisplayLabel(desiredFutureText);
    }

    public String getDesiredFutureText() {
        return desiredFutureText;
    }
}
