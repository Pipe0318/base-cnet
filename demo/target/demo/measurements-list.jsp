<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sistemas.model.Measurement" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Mediciones</title>
</head>
<body>
    <h1>Mediciones registradas</h1>
    <p><a href="<%= request.getContextPath() %>/measurement-form.jsp">Registrar medición</a></p>
    <table border="1" cellpadding="6">
        <tr>
            <th>ID</th>
            <th>Dispositivo</th>
            <th>Timestamp</th>
            <th>Valor</th>
        </tr>
        <% List<Measurement> measurements = (List<Measurement>) request.getAttribute("measurements");
           if (measurements != null) {
               for (Measurement measurement : measurements) { %>
        <tr>
            <td><%= measurement.getId() %></td>
            <td><%= measurement.getDevice_id() %></td>
            <td><%= measurement.getTimeStamp() %></td>
            <td><%= measurement.getValue() %></td>
        </tr>
        <%     }
           } %>
    </table>
</body>
</html>
