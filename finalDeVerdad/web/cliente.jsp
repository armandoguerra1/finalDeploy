<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.microhabitacion.modelo.HabitacionDTO" %>
<%@ page import="com.microusuario.modelo.UsuarioDTO" %>
<%
    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("registro.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Panel del Cliente</title>
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

        table {
            margin: 20px auto;
            border-collapse: collapse;
            width: 80%;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ccc;
        }

        th {
            background-color: #3498db;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        input[type="date"] {
            margin: 5px;
            padding: 5px;
        }

        input[type="submit"] {
            background-color: #2ecc71;
            color: white;
            padding: 7px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #27ae60;
        }
    </style>
</head>
<body>
    <h2>Bienvenido, <%= usuario.getNombre() %> (Cliente)</h2>
    <h3>Habitaciones disponibles</h3>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Descripción</th>
                <th>Acción</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<HabitacionDTO> habitaciones = (List<HabitacionDTO>) request.getAttribute("habitaciones");
                if (habitaciones != null) {
                    for (HabitacionDTO h : habitaciones) {
            %>
            <tr>
                <td><%= h.getId() %></td>
                <td><%= h.getDescripcion() %></td>
                <td>
                    <form action="ReservaController" method="post">
                        <input type="hidden" name="cliente_id" value="<%= usuario.getId() %>">
                        <input type="hidden" name="habitacion_id" value="<%= h.getId() %>">
                        <input type="date" name="fecha_inicio" required>
                        <input type="date" name="fecha_fin" required>
                        <input type="submit" value="Reservar">
                    </form>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="3">No hay habitaciones disponibles.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
