package com.company;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.util.Scanner;


public class CurrencyList {
    private URL url;
    private String currency;
    private Scanner in;
    private JSONObject jsonObject;

    public CurrencyList(String currency){
        this.currency = currency;
    }

    public String stringObj() throws IOException, JSONException {
        currency = this.currency;
        this.url = new URL("https://api.coinmarketcap.com/v2/ticker/?convert="+currency+"&limit=5&structure=array");
        this.in = new Scanner((InputStream) this.url.getContent());
        String result = "";
        while (this.in.hasNext()){
            result += in.nextLine();
        }
        this.jsonObject = new JSONObject(result);
        return jsonObject.toString();
    }

    public void arrCurrency() throws JSONException {
        JSONArray jsonArray = this.jsonObject.getJSONArray("data");
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject one = jsonArray.getJSONObject(i);
            if (!one.getString("symbol").equals(currency)) {
                System.out.println(one.getString("symbol"));
                JSONObject onesQuotes = one.getJSONObject("quotes").getJSONObject(currency);
                System.out.println(String.format(currency + "/" + one.getString("symbol") + " - " + onesQuotes.getDouble("price")));
            }
        }
//        return jsonArray;
    }

}
