package enums;

import static constants.CoinConstants.*;

public enum ECoin {
    PENNY(WEIGHT_IN_GRAMS_OF_PENNY, DIAMETER_IN_MILLIMETERS_OF_PENNY, THICKNESS_MILLIMETERS_OF_PENNY),
    NICKLE(WEIGHT_IN_GRAMS_OF_NICKLE, DIAMETER_IN_MILLIMETERS_OF_NICKLE, THICKNESS_MILLIMETERS_OF_NICKLE),
    DIME(WEIGHT_IN_GRAMS_OF_DIME, DIAMETER_IN_MILLIMETERS_OF_DIME, THICKNESS_MILLIMETERS_OF_DIME),
    QUARTER(WEIGHT_IN_GRAMS_OF_QUARTER, DIAMETER_IN_MILLIMETERS_OF_QUARTER, THICKNESS_MILLIMETERS_OF_QUARTER);

    private double weightInGrams;
    private double diameterInMillimeters;
    private double thicknessInMillimeters;

    ECoin(double weightInGrams, double diameterInMillimeters, double thicknessInMillimeters) {
        this.weightInGrams = weightInGrams;
        this.diameterInMillimeters = diameterInMillimeters;
        this.thicknessInMillimeters = thicknessInMillimeters;
    }

    public double getWeightInGrams() {
        return weightInGrams;
    }

    public double getDiameterInMillimeters() {
        return diameterInMillimeters;
    }

    public double getThicknessInMillimeters() {
        return thicknessInMillimeters;
    }
}
