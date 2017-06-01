package gui;

import gui.forms.MainForm;

public class MainFormWrapper {

    private MainForm mainForm;

    public MainFormWrapper() {
        mainForm = new MainForm();
    }

    public MainForm getMainForm() {
        return mainForm;
    }
}
