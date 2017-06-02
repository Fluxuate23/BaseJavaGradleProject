package brain;

import enums.ECoin;

public class VendingMachineBrain {
    private double currentDollarAmount;

    public void insertCoin(ECoin insertedCoin) {
        if (insertedCoin.getDiameterInMillimeters() == 21.21) {
            currentDollarAmount = .05;
        } else {
            currentDollarAmount = 0.0;
        }
    }

    public double getCurrentDollarAmount() {
        return currentDollarAmount;
    }
}
