/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Alexy
 */
public class Rain {
    
    @JsonProperty("3h")
    private String pluie;

    /**
     * @return the pluie
     */
    public String getPluie() {
        return pluie;
    }

    /**
     * @param pluie the pluie to set
     */
    public void setPluie(String pluie) {
        this.pluie = pluie;
    }
}
