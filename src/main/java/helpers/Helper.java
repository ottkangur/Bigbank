package helpers;

import common.DriverInitializer;

public class Helper extends DriverInitializer {
    public Helper() {}

    private String MIN_VALUE = "500";
    private String MAX_VALUE = "30000";
    private String FAIL = "Something went wrong";

    public String getMIN_VALUE() {
        return MIN_VALUE;
    }

    public String getMAX_VALUE() {
        return MAX_VALUE;
    }

    public String getFAIL() {
        return FAIL;
    }
}
