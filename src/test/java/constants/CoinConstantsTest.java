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

}