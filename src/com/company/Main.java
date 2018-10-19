package com.company;

import org.json.JSONException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, JSONException {
	CurrencyList currencyList = new CurrencyList("ETH");
        System.out.println(currencyList.stringObj());

        currencyList.arrCurrency();
    }
}
