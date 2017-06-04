package brain;

import enums.ECoin;
import gui.MainFormData;

import java.text.DecimalFormat;

import static constants.CoinConstants.*;

public class VendingMachineBrain {
    private static final String DECIMAL_PATTERN = "0.00";
    private static final String DOLLAR_SIGN_DISPLAY_FORMAT = "$%s";
    private double currentDollarAmount;
    private MainFormData mainFormData;
    private double currentCoinReturnDollarAmount;

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
            mainFormData.updateVendingDisplayLabel(formatDollarAmount(currentDollarAmount));
        }
    }

    public void returnCoins() {
        currentCoinReturnDollarAmount += currentDollarAmount;

        if (currentDollarAmount != 0.0) {
            mainFormData.updateVendingDisplayLabel("INSERT COIN");
            mainFormData.updateCoinReturnLabel(formatDollarAmount(currentCoinReturnDollarAmount));
        }
        currentDollarAmount = 0.0;
    }

    public void collectCoinReturn() {
        mainFormData.updateCoinReturnLabel("");
        currentCoinReturnDollarAmount = 0.0;

    }

    public double getCurrentDollarAmount() {
        return currentDollarAmount;
    }

    public void setCurrentDollarAmount(double currentDollarAmount) {
        this.currentDollarAmount = currentDollarAmount;
    }

    public void setCurrentCoinReturnDollarAmount(double currentCoinReturnDollarAmount) {
        this.currentCoinReturnDollarAmount = currentCoinReturnDollarAmount;
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

    private String formatDollarAmount(double dollarAmountToFormat) {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_PATTERN);
        String dollarAmountAsString = decimalFormat.format(dollarAmountToFormat);
        return String.format(DOLLAR_SIGN_DISPLAY_FORMAT, dollarAmountAsString);
    }

    public double getCurrentCoinReturnDollarAmount() {
        return currentCoinReturnDollarAmount;
    }
}
