package com.example.config;

public interface SauceConfig {

    /**
     * Your Sauce Labs username
     */
    final String USERNAME = "singhsunil3012";

    /**
     * Your Sauce Labs access key
     */
    final String ACCESS_KEY = "2df60e08-1cd4-4b19-bce2-ecb80182f515";

    /**
     * Your Sauce Labs Data Center HUB EndPoint for US WEST
     */
    final String DATA_CENTER_US_WEST_PLUS_HUB_ENDPOINT = "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

    /**
     * Your Sauce Labs HUB EndPoint without specifying any Data Centers
     */
    final String NO_DATA_CENTER_PLUS_HUB_ENDPOINT = "@ondemand.saucelabs.com:80/wd/hub";
}
