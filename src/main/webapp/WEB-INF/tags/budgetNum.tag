<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:forEach items="${requestScope['bLine']}" var = 'budget_line' end="0">

    <c:out value="${budget_line.id}" />

</c:forEach>
