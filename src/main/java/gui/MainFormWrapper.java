package gui;

import brain.VendingMachineBrain;
import enums.ECoin;
import enums.EVendingProduct;
import gui.forms.MainForm;

import javax.swing.*;
import java.beans.PropertyChangeEvent;

public class MainFormWrapper {

    private MainForm mainForm;
    private VendingMachineBrain vendingMachineBrain;
    private MainFormData mainFormData;

    public MainFormWrapper() {
        mainFormData = new MainFormData();
        vendingMachineBrain = new VendingMachineBrain(mainFormData);
        mainForm = new MainForm();
    }

    public void launchForm() {
        mainForm.setContentPane(mainForm.getHomePanel());
        mainForm.setVisible(true);
        mainForm.pack();
        mainForm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        initializeActionListeners();
        initializePropertyChangeListeners();
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

    public JButton retrievePurchaseColaButton() {
        return mainForm.getPurchaseColaButton();
    }

    public JButton retrievePurchaseChipsButton() {
        return mainForm.getPurchaseChipsButton();
    }

    public JButton retrievePurchaseCandyButton() {
        return mainForm.getPurchaseCandyButton();
    }

    public JButton retrieveReturnCoinsButton() {
        return mainForm.getReturnCoinsButton();
    }

    public JLabel retrieveVendingDisplayLabel() {
        return mainForm.getVendingDisplayLabel();
    }

    public JLabel retrieveCoinReturnLabel() {
        return mainForm.getCoinReturnLabel();
    }

    public JButton retrieveCollectCoinReturnButton() {
        return mainForm.getCollectCoinReturnButton();
    }

    public JLabel retrieveDispensedItemLabel() {
        return mainForm.getDispensedItemLabel();
    }

    public MainForm getMainForm() {
        return mainForm;
    }

    public VendingMachineBrain getVendingMachineBrain() {
        return vendingMachineBrain;
    }

    public void setMainForm(MainForm mainForm) {
        this.mainForm = mainForm;
    }

    public void setVendingMachineBrain(VendingMachineBrain vendingMachineBrain) {
        this.vendingMachineBrain = vendingMachineBrain;
    }

    public void setMainFormData(MainFormData mainFormData) {
        this.mainFormData = mainFormData;
    }

    protected void updateVendingDisplayLabel(PropertyChangeEvent propertyChangeEvent) {
        String updatedVendingDisplayLabelText = propertyChangeEvent.getNewValue().toString();
        mainForm.getVendingDisplayLabel().setText(updatedVendingDisplayLabelText);
    }

    protected void updateCoinReturnDisplayLabel(PropertyChangeEvent propertyChangeEvent) {
        String updatedCoinReturnDisplayLabelText = propertyChangeEvent.getNewValue().toString();
        mainForm.getCoinReturnLabel().setText(updatedCoinReturnDisplayLabelText);
    }

    protected void updateDispensedItemLabel(PropertyChangeEvent propertyChangeEvent) {

    }

    private void initializePropertyChangeListeners() {
        mainFormData.addUpdateVendingDisplayLabelListener(this::updateVendingDisplayLabel);
        mainFormData.addUpdateCoinReturnDisplayLabelListener(this::updateCoinReturnDisplayLabel);
        mainFormData.addUpdateDispensedItemLabelListener(this::updateDispensedItemLabel);
    }

    private void initializeActionListeners() {
        mainForm.getInsertPennyButton().addActionListener(e -> vendingMachineBrain.insertCoin(ECoin.PENNY));
        mainForm.getInsertNickleButton().addActionListener(e -> vendingMachineBrain.insertCoin(ECoin.NICKLE));
        mainForm.getInsertDimeButton().addActionListener(e -> vendingMachineBrain.insertCoin(ECoin.DIME));
        mainForm.getInsertQuarterButton().addActionListener(e -> vendingMachineBrain.insertCoin(ECoin.QUARTER));
        mainForm.getReturnCoinsButton().addActionListener(e -> vendingMachineBrain.returnCoins());
        mainForm.getCollectCoinReturnButton().addActionListener(e -> vendingMachineBrain.collectCoinReturn());
        mainForm.getPurchaseColaButton().addActionListener(e -> vendingMachineBrain.purchaseProduct(EVendingProduct.COLA));
        mainForm.getPurchaseChipsButton().addActionListener(e -> vendingMachineBrain.purchaseProduct(EVendingProduct.CHIPS));
        mainForm.getPurchaseCandyButton().addActionListener(e -> vendingMachineBrain.purchaseProduct(EVendingProduct.CANDY));
    }
}
