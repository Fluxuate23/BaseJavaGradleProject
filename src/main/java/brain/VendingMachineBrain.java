package brain;

import enums.ECoin;

public class VendingMachineBrain {
    private double currentDollarAmount;

    public void insertCoin(ECoin insertedCoin) {
        currentDollarAmount = .05;
    }

    public double getCurrentDollarAmount() {
        return currentDollarAmount;
    }
}
