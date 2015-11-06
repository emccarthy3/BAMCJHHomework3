<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Copyright (c) Betsey McCarthy, Colin Hiriak
-->
<html>
    <head>
        <title>Investment Result</title>
        <meta charset="UTF-8">
         <link rel="stylesheet" href="styles/styles.css" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@ include file="header.jsp" %>
    </head>
    <body>
      <form action="calculate" method="post">
        <input type="hidden" name="action" value="calculate">        
        <label class="resultLabels">Investment Amount: </label>
         <elon:currencyFormat investment="${calculator.investment}" 
            result = ${calculator.result}/>
        <label class="results">${investment}</label><br> 
        <label class="resultLabels">Yearly Interest Rate: </label>
        <label class="results">${rate}</label><br>
        <label class="resultLabels">Number of Years: </label>
        <label class="results">${years}</label><br>
        <label class="resultLabels">Future Value: </label>  
        <label class="results" id="futureValue"> ${result}</label>
        <div class="columns"> <b> Year &nbsp &nbsp </b> <b> Value </b>  </div>  
        <c:forEach var="calculator" items="${calcs}">
            <div class="nums">
                ${calculator.years} &nbsp; &nbsp; &nbsp; &nbsp;
                ${calculator.result}
            </div>
            <elon:currencyFormat result ="${calculator.result}"/><br>
        </c:forEach>  
        <label>&nbsp;</label>
      </form>
      <footer>
        <%@ include file="footer.jsp" %>
      </footer>
    </body>
</html>
