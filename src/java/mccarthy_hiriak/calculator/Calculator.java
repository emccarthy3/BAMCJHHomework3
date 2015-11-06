/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mccarthy_hiriak.calculator;
import java.io.Serializable;


/**
 *
 * @author emccarthy3
 * copyright (c) Betsey McCarthy & Colin Hiriak
 */
public class Calculator implements Serializable {
    
    private String investment;
    private String rate;
    private String years;
    private String result;
    
    /**
     * Constructor for calculator
     */
    public Calculator(){
        investment = "";
        rate = "";
        years = "";
        result = "";
    }
    /**
     * Constructor for calculator with parameters
     * @param investment - initial investment 
     * @param rate - rate
     * @param years - years
     * @param result - calculated future value 
     */
    public Calculator(String investment, String rate, String years, 
      String result){
        this.investment = investment;
        this.rate = rate;
        this.years = years;
        this.result = result;
    }
    /**
     * Method to get investment as a String
     * @return investment
     */
    public String getInvestment(){
        return investment;
    }
    /**
     * Method to set investment as a String
     * @param investment
     */
    public void setInvestment(String investment){
        this.investment = investment;
    }
    /**
     * Method to get rate as a String
     * @return rate
     */
    public String getRate(){
        return rate;
    }
    /**
     * Method to set rate as a String
     * @param rate
     */
    public void setRate(String rate){
        this.rate = rate;
    }
    /**
     * Method to get years as a String
     * @return years
     */
    public String getYears(){
        return years;
    }
    /**
     * Method to set years as a String
     * @param years
     */
    public void setYears(String years){
        this.years = years;
    }
    /**
     * Method to get result as a String
     * @return result
     */
    public String getResult(){
        return result;
    }
    /**
     * Method to set result as a String
     * @param result
     */
    public void setResult(String result){
        this.result = result;
    }
    
}