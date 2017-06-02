package brain;

import enums.ECoin;

public class VendingMachineBrain {
    private double currentDollarAmount;

    public void insertCoin(ECoin insertedCoin) {
        if (insertedCoin.getDiameterInMillimeters() == 21.21) {
            currentDollarAmount = .05;
        } else if (insertedCoin.getDiameterInMillimeters() == 19.05){
            currentDollarAmount = 0.0;
        } else if (insertedCoin.getDiameterInMillimeters() == 17.9){
            currentDollarAmount = 0.1;
        } else if (insertedCoin.getDiameterInMillimeters() == 24.26) {
            currentDollarAmount = 0.25;
        }
    }

    public double getCurrentDollarAmount() {
        return currentDollarAmount;
    }
}
