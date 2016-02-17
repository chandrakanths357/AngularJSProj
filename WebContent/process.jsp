
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="serverDate" class="java.util.Date" scope="page"  />

<fmt:formatDate value="${serverDate}" pattern="dd/MM/yyyy hh:mm:ss"/>
