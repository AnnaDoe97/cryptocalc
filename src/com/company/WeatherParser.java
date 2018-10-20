package com.company;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.util.Scanner;

public class WeatherParser {
    private URL url;
    private Scanner in;
    private JSONObject jsonObject1;
//    public TextView temp;
//    public TextView wind;
//    public TextView humidity;
//    public TextView weather;
//    public String temp;
//    public String wind;
//    public String humidity;
//    public String weather;



    public void stringObj() throws IOException, JSONException{
        this.url = new URL("http://api.openweathermap.org/data/2.5/weather?id=2023469&mode=json&units=metric&appid=1fb6ee9230e69e60ced6b13426419492");
        this.in = new Scanner((InputStream) this.url.getContent());
        String result = "";
        while (this.in.hasNext()){
            result += in.nextLine();
        }
        this.jsonObject1 = new JSONObject(result);
        JSONObject main = jsonObject1.getJSONObject("main");

        JSONArray weatArr = jsonObject1.getJSONArray("weather");
        JSONObject weat = weatArr.getJSONObject(0);
        String weather = weat.getString("description");
        System.out.println("Описание: "+weather);

        double temp = main.getDouble("temp");
        System.out.println("Температура: "+temp);

        double humidity1 = main.getDouble("humidity");
        System.out.println("Влажность: "+humidity1);

        JSONObject wind = jsonObject1.getJSONObject("wind");
        int speed1 = wind.getInt("speed");
        System.out.println("Ветер: "+speed1);

//        return jsonObject1.toString();
    }

    public void stringsObj() throws IOException, JSONException{
        this.url = new URL("http://api.openweathermap.org/data/2.5/forecast?q=Irkutsk,RU&mode=json&units=metric&appid=1fb6ee9230e69e60ced6b13426419492");
        this.in = new Scanner((InputStream) this.url.getContent());
        String result = "";
        while (this.in.hasNext()){
            result += in.nextLine();
        }
        this.jsonObject1 = new JSONObject(result);

//        System.out.println(this.jsonObject1.toString());
        JSONArray jsonArray = jsonObject1.getJSONArray("list");
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject weekd = jsonArray.getJSONObject(i);

            JSONObject maint = weekd.getJSONObject("main");
//                    JSONObject time = weekd.getJSONObject("dt_txt");
            if (weekd.getString("dt_txt").substring(10).equals(" 12:00:00")) {
                System.out.println("Температура: "+maint.getDouble("temp"));
                System.out.println("Дата: "+weekd.getString("dt_txt"));
            }
        }
    }


}
