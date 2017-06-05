package brain;

import enums.ECoin;
import enums.EVendingProduct;
import gui.MainFormData;

import java.text.DecimalFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static constants.CoinConstants.*;

public class VendingMachineBrain {
    public static final double COST_OF_MOST_EXPENSIVE_ITEM_TO_PURCHASE = 1.0;
    private static final String DECIMAL_PATTERN = "0.00";
    private static final String DOLLAR_SIGN_DISPLAY_FORMAT = "$%s";
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
            mainFormData.updateVendingDisplayLabel("INSERT COIN");
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

    public void purchaseProduct(EVendingProduct product) {
        double requiredDollarAmountForPurchase;
        String productName = product.getName();
        if ("Candy".equals(productName)) {
            requiredDollarAmountForPurchase = .5;
        } else if ("Chips".equals(productName)) {
            requiredDollarAmountForPurchase = .65;
        } else {
            requiredDollarAmountForPurchase = 1.0;
        }

        if (currentDollarAmount >= requiredDollarAmountForPurchase) {
            mainFormData.updateVendingDisplayLabel("THANK YOU");
            mainFormData.updateDispensedItemLabel(productName);
            scheduledExecutorService.schedule(new MainFormDataRunnableTask(mainFormData, "INSERT COIN"), 1L, TimeUnit.SECONDS);
        } else {
            mainFormData.updateVendingDisplayLabel(formatDollarAmount(requiredDollarAmountForPurchase));
            String desiredFutureText = currentDollarAmount == 0.0 ? "INSERT COIN" : formatDollarAmount(currentDollarAmount);
            scheduledExecutorService.schedule(new MainFormDataRunnableTask(mainFormData, desiredFutureText), 1L, TimeUnit.SECONDS);
        }
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }

    public void setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = scheduledExecutorService;
    }
}
