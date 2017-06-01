package gui;

import brain.VendingMachineBrain;
import enums.ECoin;
import gui.forms.MainForm;

import javax.swing.*;

public class MainFormWrapper {

    private MainForm mainForm;
    private VendingMachineBrain vendingMachineBrain;

    public MainFormWrapper() {
        vendingMachineBrain = new VendingMachineBrain();
        mainForm = new MainForm();
    }

    public void launchForm() {
        mainForm.setContentPane(mainForm.getHomePanel());
        mainForm.setVisible(true);
        mainForm.pack();

        mainForm.getInsertPennyButton().addActionListener(e -> vendingMachineBrain.insertCoin(ECoin.PENNY));
        mainForm.getInsertNickleButton().addActionListener(e -> vendingMachineBrain.insertCoin(ECoin.NICKLE));
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

    public VendingMachineBrain getVendingMachineBrain() {
        return vendingMachineBrain;
    }

    public void setVendingMachineBrain(VendingMachineBrain vendingMachineBrain) {
        this.vendingMachineBrain = vendingMachineBrain;
    }
}
