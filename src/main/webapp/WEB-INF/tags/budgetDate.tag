<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="budgetDate" value="${requestScope['date']}" />
<p>Data: <fmt:formatDate value="${budgetDate}" pattern="dd-MM-yyyy" /></p>
