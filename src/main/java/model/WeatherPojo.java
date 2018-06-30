/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Alexy
 */
public class WeatherPojo
{
    private Coord coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private int visibility;
    private Clouds clouds;
    private Wind wind;
    private int dt;
    private Sys sys;
    private int id;
    private String name;
    private int cod;
    
    

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+getId()+", dt = "+getDt()+", clouds = "+getClouds()+", coord = "+getCoord()+", wind = "+getWind()+", cod = "+getCod()+", visibility = "+getVisibility()+", sys = "+getSys()+", name = "+getName()+", base = "+getBase()+", weather = "+getWeather()+", main = "+getMain()+"]";
    }

    /**
     * @return the coord
     */
    public Coord getCoord() {
        return coord;
    }

    /**
     * @param coord the coord to set
     */
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    /**
     * @return the weather
     */
    public List<Weather> getWeather() {
        return weather;
    }

    /**
     * @param weather the weather to set
     */
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    /**
     * @return the base
     */
    public String getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * @return the main
     */
    public Main getMain() {
        return main;
    }

    /**
     * @param main the main to set
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * @return the visibility
     */
    public int getVisibility() {
        return visibility;
    }

    /**
     * @param visibility the visibility to set
     */
    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    /**
     * @return the clouds
     */
    public Clouds getClouds() {
        return clouds;
    }

    /**
     * @param clouds the clouds to set
     */
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    /**
     * @return the wind
     */
    public Wind getWind() {
        return wind;
    }

    /**
     * @param wind the wind to set
     */
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    /**
     * @return the dt
     */
    public int getDt() {
        return dt;
    }

    /**
     * @param dt the dt to set
     */
    public void setDt(int dt) {
        this.dt = dt;
    }

    /**
     * @return the sys
     */
    public Sys getSys() {
        return sys;
    }

    /**
     * @param sys the sys to set
     */
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(int cod) {
        this.cod = cod;
    }
}
