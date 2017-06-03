package brain;

import enums.ECoin;

import static constants.CoinConstants.*;

public class VendingMachineBrain {
    private double currentDollarAmount;

    public void insertCoin(ECoin insertedCoin) {
        double diameterInMillimetersOfInsertedCoin = insertedCoin.getDiameterInMillimeters();
        if (diameterInMillimetersOfInsertedCoin == DIAMETER_IN_MILLIMETERS_OF_NICKLE) {
            currentDollarAmount += DOLLAR_VALUE_OF_NICKLE;
        } else if (diameterInMillimetersOfInsertedCoin == DIAMETER_IN_MILLIMETERS_OF_DIME){
            currentDollarAmount += DOLLAR_VALUE_OF_DIME;
        } else if (diameterInMillimetersOfInsertedCoin == DIAMETER_IN_MILLIMETERS_OF_QUARTER) {
            currentDollarAmount = DOLLAR_VALUE_OF_QUARTER;
        }
    }

    public double getCurrentDollarAmount() {
        return currentDollarAmount;
    }

    public void setCurrentDollarAmount(int currentDollarAmount) {
        this.currentDollarAmount = currentDollarAmount;
    }
}
