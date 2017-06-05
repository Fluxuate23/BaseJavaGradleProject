package brain;

import enums.ECoin;
import enums.EVendingProduct;
import gui.MainFormData;

import java.text.DecimalFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static constants.CoinConstants.*;

public class VendingMachineBrain {

    private static final String DECIMAL_PATTERN = "0.00";
    private static final String DOLLAR_SIGN_DISPLAY_FORMAT = "$%s";
    private static final String CHIPS = "Chips";
    private static final String CANDY = "Candy";
    private static final String THANK_YOU_TEXT = "THANK YOU";
    private static final String INSERT_COIN_TEXT = "INSERT COIN";
    private static final long UPDATE_DISPLAY_DELAY = 1L;
    private static final double DOLLAR_AMOUNT_COST_FOR_CHIPS = .5;
    private static final double DOLLAR_AMOUNT_COST_FOR_CANDY = .65;
    private static final double DOLLAR_AMOUNT_COST_FOR_COLA = 1.0;

    private double currentDollarAmount;
    private double currentCoinReturnDollarAmount;
    private MainFormData mainFormData;
    private ScheduledExecutorService scheduledExecutorService;

    public VendingMachineBrain(MainFormData mainFormData) {
        this.mainFormData = mainFormData;
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    }

    public void insertCoin(ECoin insertedCoin) {
        double diameterInMillimetersOfInsertedCoin = insertedCoin.getDiameterInMillimeters();
        if (isDiameterOfAPenny(diameterInMillimetersOfInsertedCoin)) {
            currentCoinReturnDollarAmount += DOLLAR_VALUE_OF_PENNY;
            mainFormData.updateCoinReturnLabel(formatDollarAmount(currentCoinReturnDollarAmount));
        } else {
            if (isDiameterOfANickle(diameterInMillimetersOfInsertedCoin)) {
                currentDollarAmount += DOLLAR_VALUE_OF_NICKLE;
            } else if (isDiameterOfADime(diameterInMillimetersOfInsertedCoin)) {
                currentDollarAmount += DOLLAR_VALUE_OF_DIME;
            } else if (isDiameterOfAQuarter(diameterInMillimetersOfInsertedCoin)) {
                currentDollarAmount += DOLLAR_VALUE_OF_QUARTER;
            }
            mainFormData.updateVendingDisplayLabel(formatDollarAmount(currentDollarAmount));
        }
    }

    public void returnCoins() {
        currentCoinReturnDollarAmount += currentDollarAmount;

        if (currentDollarAmount != 0.0) {
            mainFormData.updateVendingDisplayLabel(INSERT_COIN_TEXT);
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

    public double getCurrentCoinReturnDollarAmount() {
        return currentCoinReturnDollarAmount;
    }

    public void setCurrentDollarAmount(double currentDollarAmount) {
        this.currentDollarAmount = currentDollarAmount;
    }

    public void setCurrentCoinReturnDollarAmount(double currentCoinReturnDollarAmount) {
        this.currentCoinReturnDollarAmount = currentCoinReturnDollarAmount;
    }

    public void purchaseProduct(EVendingProduct product) {
        double requiredDollarAmountForPurchase;
        String productName = product.getName();
        requiredDollarAmountForPurchase = determineRequiredDollarAmountForProduct(productName);

        if (currentDollarAmount >= requiredDollarAmountForPurchase) {
            double remainderAfterPurchase = currentDollarAmount - requiredDollarAmountForPurchase;
            currentCoinReturnDollarAmount += remainderAfterPurchase;
            currentDollarAmount = 0;
            mainFormData.updateVendingDisplayLabel(THANK_YOU_TEXT);
            mainFormData.updateDispensedItemLabel(productName);
            mainFormData.updateCoinReturnLabel(formatDollarAmount(currentCoinReturnDollarAmount));
            scheduledExecutorService.schedule(new MainFormDataRunnableTask(mainFormData, INSERT_COIN_TEXT), UPDATE_DISPLAY_DELAY, TimeUnit.SECONDS);
        } else {
            mainFormData.updateVendingDisplayLabel(formatDollarAmount(requiredDollarAmountForPurchase));
            String desiredFutureText = currentDollarAmount == 0.0 ? INSERT_COIN_TEXT : formatDollarAmount(currentDollarAmount);
            scheduledExecutorService.schedule(new MainFormDataRunnableTask(mainFormData, desiredFutureText), UPDATE_DISPLAY_DELAY, TimeUnit.SECONDS);
        }
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }

    public void setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = scheduledExecutorService;
    }

    private double determineRequiredDollarAmountForProduct(String productName) {
        double requiredDollarAmountForPurchase;
        if (CHIPS.equals(productName)) {
            requiredDollarAmountForPurchase = DOLLAR_AMOUNT_COST_FOR_CHIPS;
        } else if (CANDY.equals(productName)) {
            requiredDollarAmountForPurchase = DOLLAR_AMOUNT_COST_FOR_CANDY;
        } else {
            requiredDollarAmountForPurchase = DOLLAR_AMOUNT_COST_FOR_COLA;
        }
        return requiredDollarAmountForPurchase;
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
}
