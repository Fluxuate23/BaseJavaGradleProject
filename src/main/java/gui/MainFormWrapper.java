package gui;

import gui.forms.MainForm;

public class MainFormWrapper {

    private MainForm mainForm;

    public MainFormWrapper() {
        mainForm = new MainForm();
    }

    public void launchForm() {
        mainForm.setContentPane(mainForm.getHomePanel());
        mainForm.setVisible(true);
        mainForm.pack();
    }

    public MainForm getMainForm() {
        return mainForm;
    }

    public void setMainForm(MainForm mainForm) {
        this.mainForm = mainForm;
    }
}
