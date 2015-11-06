<%@ taglib prefix="elon" uri="/WEB-INF/Hiriak_McCarthy.tld" %>
<!DOCTYPE html>
<!--
Copyright (c) Betsey McCarthy, Colin Hiriak
-->

<html> 
    <head>
        
        <title>Investment Calculator</title>
        <link rel="stylesheet" href="styles/styles.css" type="text/css"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@ include file="header.jsp" %>
    </head>
    <body>
      <elon:currencyFormat> test</elon:currencyFormat>
      <form action="calculate" method="post">
        <input  class=inputs type="hidden" name="action" value="calculate">        
        <label class="labels">Investment Amount: </label>
        <input class=inputs type="number" min="0" step="0.01" name="investment" 
          value= "${investment}" required><br>
        <label class="labels">Yearly Interest Rate:  </label>
        <input class=inputs type="number" min="0" step="0.01" name="rate" 
          value="${rate}" required><br>
        <label class="labels" id="years">Number of Years: </label>
        <input class=inputs type="number" min="0" name="years" value="${years}" 
          placeholder= "Integer number of years" required><br>        
        <label>&nbsp;</label>
        <input id=button type="submit" value="Calculate" class="margin_left">
      </form>    
      <footer>
          <%@ include file="footer.jsp" %>
      </footer>
    </body>    
</html>
