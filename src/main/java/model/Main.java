/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Alexy
 */
public class Main
{
    private String humidity;

    private String pressure;

    private String temp_max;

    private String temp_min;

    private String temp;

    public String getHumidity ()
    {
        return humidity;
    }

    public void setHumidity (String humidity)
    {
        this.humidity = humidity;
    }

    public String getPressure ()
    {
        return pressure;
    }

    public void setPressure (String pressure)
    {
        this.pressure = pressure;
    }

    public String getTemp_max ()
    {
        return temp_max;
    }

    public void setTemp_max (String temp_max)
    {
        this.temp_max = temp_max;
    }

    public String getTemp_min ()
    {
        return temp_min;
    }

    public void setTemp_min (String temp_min)
    {
        this.temp_min = temp_min;
    }

    public String getTemp ()
    {
        return temp;
    }

    public void setTemp (String temp)
    {
        this.temp = temp;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [humidity = "+humidity+", pressure = "+pressure+", temp_max = "+temp_max+", temp_min = "+temp_min+", temp = "+temp+"]";
    }
}
