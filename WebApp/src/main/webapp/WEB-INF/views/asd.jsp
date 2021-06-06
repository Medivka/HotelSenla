<%@ page import="java.util.List" %>
<%@ page import="com.senla.dto.modelDTO.GuestDTO" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="com.senla.api.fasad.IFasadGuest" %><%--
  Created by IntelliJ IDEA.
  User: ispolin1@rambler.ru
  Date: 06.06.2021
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Orders</title>
    <link href="css/order_style.css" rel="stylesheet">
</head>
<body>
<div>
    <h2>Users</h2>
</div>
<%!

    private Object mappingDTOImpl;
    private IFasadGuest fasadGuest;
%><%
    final List<GuestDTO> clients = fasadGuest.showAllGuests().stream().map(mappingDTOImpl::mapGuestToGuestDTO).collect(Collectors.toList());


    if (names != null && !names.isEmpty()) {
        out.println("<ui>");
        for (String s : names) {
            out.println("<li>" + s + "</li>");
        }
        out.println("</ui>");
    } else out.println("<p>There are no users yet!</p>");
%>
</div>
</div>
<table>
    <tr>
        <th>Title</th>
        <th>Price</th>
    </tr>
    <th:block th:each="order : ${orders}">
        <tr>
            <td th:text="${order.id}"></td>

        </tr>
    </th:block>
</table>
</body>
</html>