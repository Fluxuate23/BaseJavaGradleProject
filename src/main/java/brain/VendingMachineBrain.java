package brain;

import enums.ECoin;
import gui.MainFormData;

import java.text.DecimalFormat;

import static constants.CoinConstants.*;

public class VendingMachineBrain {
    private double currentDollarAmount;
    private MainFormData mainFormData;

    public VendingMachineBrain(MainFormData mainFormData) {
        this.mainFormData = mainFormData;
    }

    public void insertCoin(ECoin insertedCoin) {
        double diameterInMillimetersOfInsertedCoin = insertedCoin.getDiameterInMillimeters();
        if (diameterInMillimetersOfInsertedCoin == DIAMETER_IN_MILLIMETERS_OF_NICKLE) {
            currentDollarAmount += DOLLAR_VALUE_OF_NICKLE;
        } else if (diameterInMillimetersOfInsertedCoin == DIAMETER_IN_MILLIMETERS_OF_DIME) {
            currentDollarAmount += DOLLAR_VALUE_OF_DIME;
        } else if (diameterInMillimetersOfInsertedCoin == DIAMETER_IN_MILLIMETERS_OF_QUARTER) {
            currentDollarAmount += DOLLAR_VALUE_OF_QUARTER;
        }

        if (diameterInMillimetersOfInsertedCoin != DIAMETER_IN_MILLIMETERS_OF_PENNY) {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            String currentDollarAmountAsString = decimalFormat.format(currentDollarAmount);
            mainFormData.updateVendingDisplayLabel(String.format("$%s", currentDollarAmountAsString));
        }
    }

    public double getCurrentDollarAmount() {
        return currentDollarAmount;
    }

    public void setCurrentDollarAmount(double currentDollarAmount) {
        this.currentDollarAmount = currentDollarAmount;
    }
}
