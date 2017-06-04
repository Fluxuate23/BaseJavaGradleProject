package brain;

import enums.ECoin;
import gui.MainFormData;

import java.text.DecimalFormat;

import static constants.CoinConstants.*;

public class VendingMachineBrain {
    private static final String DECIMAL_PATTERN = "0.00";
    private static final String VENDING_DISPLAY_LABEL_FORMAT = "$%s";
    private double currentDollarAmount;
    private MainFormData mainFormData;

    public VendingMachineBrain(MainFormData mainFormData) {
        this.mainFormData = mainFormData;
    }

    public void insertCoin(ECoin insertedCoin) {
        double diameterInMillimetersOfInsertedCoin = insertedCoin.getDiameterInMillimeters();
        if (isDiameterOfANickle(diameterInMillimetersOfInsertedCoin)) {
            currentDollarAmount += DOLLAR_VALUE_OF_NICKLE;
        } else if (isDiameterOfADime(diameterInMillimetersOfInsertedCoin)) {
            currentDollarAmount += DOLLAR_VALUE_OF_DIME;
        } else if (isDiameterOfAQuarter(diameterInMillimetersOfInsertedCoin)) {
            currentDollarAmount += DOLLAR_VALUE_OF_QUARTER;
        }

        if (!isDiameterOfAPenny(diameterInMillimetersOfInsertedCoin)) {
            DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_PATTERN);
            String currentDollarAmountAsString = decimalFormat.format(currentDollarAmount);
            mainFormData.updateVendingDisplayLabel(String.format(VENDING_DISPLAY_LABEL_FORMAT, currentDollarAmountAsString));
        }
    }

    public double getCurrentDollarAmount() {
        return currentDollarAmount;
    }

    public void setCurrentDollarAmount(double currentDollarAmount) {
        this.currentDollarAmount = currentDollarAmount;
    }

    private boolean isDiameterOfAPenny(double diameterInMillimetersOfInsertedCoin) {
        return diameterInMillimetersOfInsertedCoin == DIAMETER_IN_MILLIMETERS_OF_PENNY;
    }

    private boolean isDiameterOfANickle(double diameterInMillimetersOfInsertedCoin) {
        return diameterInMillimetersOfInsertedCoin == DIAMETER_IN_MILLIMETERS_OF_NICKLE;
    }

    private boolean isDiameterOfADime(double diameterInMillimetersOfInsertedCoin) {
        return diameterInMillimetersOfInsertedCoin == DIAMETER_IN_MILLIMETERS_OF_DIME;
    }

    private boolean isDiameterOfAQuarter(double diameterInMillimetersOfInsertedCoin) {
        return diameterInMillimetersOfInsertedCoin == DIAMETER_IN_MILLIMETERS_OF_QUARTER;
    }

    public void returnCoins() {

    }

    public void collectCoinReturn() {

    }
}
