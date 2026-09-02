<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar medición</title>
</head>
<body>
    <h1>Registrar medición</h1>
    <% if (request.getAttribute("errorAlert") != null) { %>
        <p style="color: red"><%= request.getAttribute("errorAlert") %></p>
    <% } %>
    <form method="post" action="<%= request.getContextPath() %>/register-measurement">
        <label>Dispositivo (ID):
            <input type="number" name="deviceId" value="1" required>
        </label><br><br>
        <label>Valor:
            <input type="number" name="value" step="any" required>
        </label><br><br>
        <label>Timestamp:
            <input type="number" name="timeStamp" required>
        </label><br><br>
        <button type="submit">Registrar</button>
    </form>
    <p><a href="<%= request.getContextPath() %>/list-measurements">Ver mediciones</a></p>
</body>
</html>
