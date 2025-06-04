<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.microhabitacion.modelo.HabitacionDTO" %>
<%@ page import="com.microusuario.modelo.UsuarioDTO" %>
<%
    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("registro.jsp");
        return;
    }

    HabitacionDTO habitacion = (HabitacionDTO) request.getAttribute("habitacion");
    if (habitacion == null) {
        response.sendRedirect("cliente");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reservar Habitación</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef2f3;
            padding: 40px;
            text-align: center;
        }

        h2 {
            color: #2c3e50;
        }

        form {
            display: inline-block;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0,0,0,0.2);
            margin-top: 20px;
        }

        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }

        input[type="date"] {
            padding: 7px;
            width: 200px;
            margin-top: 5px;
            margin-bottom: 15px;
        }

        input[type="submit"] {
            background-color: #2ecc71;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #27ae60;
        }

        .volver {
            margin-top: 20px;
            display: inline-block;
            color: #3498db;
            text-decoration: none;
            font-weight: bold;
        }

        .volver:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <h2>Reservar Habitación</h2>

    <h3>Descripción</h3>
    <p><%= habitacion.getDescripcion() %></p>

    <form action="ReservaController" method="post">
        <input type="hidden" name="habitacion_id" value="<%= habitacion.getId() %>" />

        <label for="fecha_inicio">Fecha de inicio:</label>
        <input type="date" name="fecha_inicio" required>

        <label for="fecha_fin">Fecha de fin:</label>
        <input type="date" name="fecha_fin" required>

        <input type="submit" value="Confirmar Reserva">
    </form>

    <br>
    <a href="cliente" class="volver">← Volver al listado</a>

</body>
</html>
