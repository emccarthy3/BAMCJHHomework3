/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mccarthy_hiriak.tags;

/**
 *Custom jsp tag for setting the formats of the investment and results as
 * money amounts
 * @author emccarthy3
 * 
 * Copyright Betsey McCarthy and Colin Hiriak
 */
import mccarthy_hiriak.calculator.Calculator;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;


public class CurrencyFormatTag extends TagSupport {

private String investment;
private String result;

/**
 * Sets the investment as a String
 * @param investment 
 */
  public void setInvesment(String investment){
    this.investment = investment;
  }
/**
 * Sets the result as a String
 * @param result 
 */
  public void setResult(String result){
    this.result = result;
  }
  
/**
 * Calls the start tag for the custom jsp tag
 * @return
 * @throws JspException 
 */
  @Override
  public int doStartTag() throws JspException { 
    try {
      JspWriter out = pageContext.getOut();
      if(investment != null && result != null){
        double investNum = Double.parseDouble(investment);
        double resultNum = Double.parseDouble(result);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        investment = formatter.format(investNum);
        result = formatter.format(resultNum);
        out.print("Investment: " + investment + " " + 
        "Result: " + result);
      }
    } catch (IOException ioe) {
      System.out.println(ioe);
    }
    return SKIP_BODY;
  }
}
    
