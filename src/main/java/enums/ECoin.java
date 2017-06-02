package enums;

public enum ECoin {
    PENNY(2.5, 19.05, 1.52),
    NICKLE(0, 0, 0),
    DIME(0, 0, 0),
    QUARTER(0, 0, 0);

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
