package com.batynchuk.weatherapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONWeatherParser {

    public static Weather getWeather(String data) throws JSONException {
        Weather weather = new Weather();

        JSONObject jsonObject = new JSONObject(data);

        JSONObject coordObject = jsonObject.getJSONObject("coord");
        weather.coord.setLatitude(coordObject.getDouble("lat"));
        weather.coord.setLongitude(coordObject.getDouble("lon"));

        JSONObject sysObject = jsonObject.getJSONObject("sys");
       // weather.sys.setType(sysObject.getInt("type"));
//        weather.sys.setSysId(sysObject.getInt("id"));
        weather.sys.setMessage(sysObject.getDouble("message"));
        weather.sys.setCountry(sysObject.getString("country"));
        weather.sys.setSunrise(sysObject.getLong("sunrise"));
        weather.sys.setSunset(sysObject.getLong("sunset"));

        JSONArray jsonArray = jsonObject.getJSONArray("weather");

        JSONObject weatherConditionObject = jsonArray.getJSONObject(0);
        weather.weatherCondition.setwId(weatherConditionObject.getInt("id"));
        weather.weatherCondition.setDescription(weatherConditionObject.getString("description"));
        weather.weatherCondition.setMain(weatherConditionObject.getString("main"));

        JSONObject windObject = jsonObject.getJSONObject("wind");
        weather.wind.setWindSpeed(windObject.getDouble("speed"));
        weather.wind.setWindDeg(windObject.getInt("deg"));

        JSONObject weatherMain = jsonObject.getJSONObject("main");
        weather.weatherMain.setTemperature(weatherMain.getDouble("temp"));
        weather.weatherMain.setPressure(weatherMain.getInt("pressure"));
        weather.weatherMain.setHumidity(weatherMain.getInt("humidity"));
        weather.weatherMain.setMinTemperature(weatherMain.getDouble("temp_min"));
        weather.weatherMain.setMaxTemperature(weatherMain.getDouble("temp_max"));

        JSONObject cloudObject = jsonObject.getJSONObject("clouds");
        weather.cloud.setCloudsAll(cloudObject.getInt("all"));

        weather.setBase(jsonObject.getString("base"));
        //weather.setRainTime(jsonObject.getInt("rain"));
        weather.setDt(jsonObject.getLong("dt"));
        weather.setId(jsonObject.getInt("id"));
        weather.setName(jsonObject.getString("name"));
        weather.setCod(jsonObject.getInt("cod"));

        return weather;
    }
}