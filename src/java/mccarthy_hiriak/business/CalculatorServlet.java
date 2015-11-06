
package mccarthy_hiriak.business;

import mccarthy_hiriak.calculator.Calculator;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.NumberFormat;
import javax.servlet.http.HttpSession;
/**
 * Copyright (c) Betsey McCarthy, Colin Hiriak
 * 
 */
@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculate"})
public class CalculatorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
  protected void doPost(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {
    String url = "/index.jsp";

    // get current action
    String action = request.getParameter("action");

    // print action value to console AND log file
    System.out.println("CalculatorServlet action: " + action);
    log("action=" + action);

    // set default action
    if (action == null) {
      action = "calculate"; 
    }

    if (action.equals("calculate")) {
      url = "/result.jsp";
      String investment = request.getParameter("investment");
      double numInvestment = Double.parseDouble(investment);
      String rate = request.getParameter("rate");
      double numRate = Double.parseDouble(rate);
      String years = request.getParameter("years");
      int numYears = Integer.parseInt(years);
      double numResult = numInvestment * Math.pow(((1 + ((numRate)/100))), 
        numYears);
      NumberFormat formatter = NumberFormat.getCurrencyInstance();
      investment = formatter.format(numInvestment);
      String  result = formatter.format(numResult);
      request.setAttribute("investment", investment);
      request.setAttribute("rate", rate);
      request.setAttribute("years", years);
      request.setAttribute("result", result);   
      Calculator[] calcs = new Calculator[numYears];
      for (int i = 0; i < numYears; i++){
        numYears = i+1;
        years = numYears + "";
        calcs[i] = new Calculator (investment, rate, years, result);
      }
      HttpSession session = request.getSession();
      Calculator calculator = new Calculator(investment, rate, years, result);
      session.setAttribute("calcs", calcs);
      session.setAttribute("calculator", calculator);   
    }
      getServletContext();
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);        
  }  
  /**
   * Calls get method of the servlet
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException 
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    doPost(request, response);
  }
  
  /**
  * Returns a short description of the servlet.
  *
  * @return a String containing servlet description
  */
  @Override
  public String getServletInfo() {
    return "Does investment calculation and returns it to result page";
    }
}
