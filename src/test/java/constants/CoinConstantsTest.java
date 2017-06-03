package constants;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CoinConstantsTest {

    @Test
    public void coinConstantsHasCorrectDollarValueForNickleDimeAndQuarter() {
        assertThat(CoinConstants.DOLLAR_VALUE_OF_NICKLE, is(0.05));
        assertThat(CoinConstants.DOLLAR_VALUE_OF_DIME, is(0.1));
        assertThat(CoinConstants.DOLLAR_VALUE_OF_QUARTER, is(0.25));
    }

    @Test
    public void coinConstantsHasCorrectWeightInGramsForPennyNickleDimeAndQuarter() {
        assertThat(CoinConstants.WEIGHT_IN_GRAMS_OF_PENNY, is(2.5));
        assertThat(CoinConstants.WEIGHT_IN_GRAMS_OF_NICKLE, is(5.0));
        assertThat(CoinConstants.WEIGHT_IN_GRAMS_OF_DIME, is(2.268));
        assertThat(CoinConstants.WEIGHT_IN_GRAMS_OF_QUARTER, is(5.67));
    }

    @Test
    public void coinConstantsHasCorrectDiameterInMillimetersForPennyNickleDimeAndQuarter() {
        assertThat(CoinConstants.DIAMETER_IN_MILLIMETERS_OF_PENNY, is(19.05));
        assertThat(CoinConstants.DIAMETER_IN_MILLIMETERS_OF_NICKLE, is(21.21));
        assertThat(CoinConstants.DIAMETER_IN_MILLIMETERS_OF_DIME, is(17.9));
        assertThat(CoinConstants.DIAMETER_IN_MILLIMETERS_OF_QUARTER, is(24.26));
    }

    @Test
    public void coinConstantsHasCorrectThicknessInMillimetersForPennyNickleDimeAndQuarter() {
        assertThat(CoinConstants.THICKNESS_MILLIMETERS_OF_PENNY, is(1.52));
        assertThat(CoinConstants.THICKNESS_MILLIMETERS_OF_NICKLE, is(1.95));
        assertThat(CoinConstants.THICKNESS_MILLIMETERS_OF_DIME, is(1.35));
        assertThat(CoinConstants.THICKNESS_MILLIMETERS_OF_QUARTER, is(1.75));
    }

}
