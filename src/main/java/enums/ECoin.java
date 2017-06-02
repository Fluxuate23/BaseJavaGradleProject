package enums;

public enum ECoin {
    PENNY(2.5, 19.05, 1.52),
    NICKLE(5.0, 21.21, 1.95),
    DIME(2.268, 17.9, 1.35),
    QUARTER(5.67, 24.26, 1.75);

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
