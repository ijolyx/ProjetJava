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
public class Wind
{
    private String speed;

    private String deg;
    private String gust;

    public String getSpeed ()
    {
        return speed;
    }

    public void setSpeed (String speed)
    {
        this.speed = speed;
    }

    public String getDeg ()
    {
        return deg;
    }

    public void setDeg (String deg)
    {
        this.deg = deg;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [speed = "+speed+", deg = "+deg+"]";
    }

    /**
     * @return the gust
     */
    public String getGust() {
        return gust;
    }

    /**
     * @param gust the gust to set
     */
    public void setGust(String gust) {
        this.gust = gust;
    }
}
