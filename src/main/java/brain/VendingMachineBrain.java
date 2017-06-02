package brain;

import enums.ECoin;

import static constants.CoinConstants.DOLLAR_VALUE_OF_DIME;
import static constants.CoinConstants.DOLLAR_VALUE_OF_NICKLE;
import static constants.CoinConstants.DOLLAR_VALUE_OF_QUARTER;

public class VendingMachineBrain {
    private double currentDollarAmount;

    public void insertCoin(ECoin insertedCoin) {
        if (insertedCoin.getDiameterInMillimeters() == 21.21) {
            currentDollarAmount = DOLLAR_VALUE_OF_NICKLE;
        } else if (insertedCoin.getDiameterInMillimeters() == 17.9){
            currentDollarAmount = DOLLAR_VALUE_OF_DIME;
        } else if (insertedCoin.getDiameterInMillimeters() == 24.26) {
            currentDollarAmount = DOLLAR_VALUE_OF_QUARTER;
        }
    }

    public double getCurrentDollarAmount() {
        return currentDollarAmount;
    }
}
