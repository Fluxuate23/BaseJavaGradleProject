package gui;

import gui.forms.MainForm;

import javax.swing.*;

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

    public JButton retrieveInsertPennyButton() {
        return mainForm.getInsertPennyButton();
    }

    public JButton retrieveInsertNickleButton() {
        return mainForm.getInsertNickleButton();
    }

    public JButton retrieveInsertDimeButton() {
        return mainForm.getInsertDimeButton();
    }

    public JButton retrieveInsertQuarterButton() {
        return mainForm.getInsertQuarterButton();
    }

    public MainForm getMainForm() {
        return mainForm;
    }

    public void setMainForm(MainForm mainForm) {
        this.mainForm = mainForm;
    }

    public JButton retrievePurchaseColaButton() {
        return mainForm.getPurchaseColaButton();
    }

    public JButton retrievePurchaseChipsButton() {
        return mainForm.getPurchaseChipsButton();
    }

    public JButton retrievePurchaseCandyButton() {
        return mainForm.getPurchaseCandyButton();
    }

    public JButton retrieveRefundButton() {
        return mainForm.getRefundButton();
    }

    public JLabel retrieveVendingDisplayLabel() {
        return mainForm.getVendingDisplayLabel();
    }
}
