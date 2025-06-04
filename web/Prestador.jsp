<%@page import="com.microhabitacion.modelo.HabitacionDTO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%
    List<HabitacionDTO> habitaciones = (List<HabitacionDTO>) request.getAttribute("habitaciones");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Panel Prestador</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f2f2f2; }
        header { background-color: #007bff; color: white; padding: 15px; text-align: center; }
        main { margin: 30px auto; width: 80%; max-width: 800px; background-color: white; padding: 25px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 10px; border: 1px solid #ccc; text-align: left; }
        .button { padding: 8px 12px; background-color: #007bff; color: white; border: none; border-radius: 5px; text-decoration: none; }
        .button:hover { background-color: #0056b3; }
        .actions { display: flex; gap: 10px; }
    </style>
</head>
<body>

<header>
    <h1>Bienvenido, Prestador</h1>
</header>

<main>
    <p>Has iniciado sesión exitosamente como prestador.</p>
    <a href="<%= request.getContextPath() %>/formularioHabitacion.jsp" class="button">Agregar Habitación</a>

    <h2>Tus Habitaciones</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Descripción</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
        <%
            if (habitaciones != null && !habitaciones.isEmpty()) {
                for (HabitacionDTO h : habitaciones) {
        %>
            <tr>
                <td><%= h.getId() %></td>
                <td><%= h.getDescripcion() %></td>
                <td class="actions">
                    <form action="<%= request.getContextPath() %>/habitacion/editar" method="get" style="display:inline;">
                        <input type="hidden" name="id" value="<%= h.getId() %>">
                        <button type="submit" class="button">Actualizar</button>
                    </form>
                    <form action="<%= request.getContextPath() %>/habitacion/eliminar" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="<%= h.getId() %>">
                        <button type="submit" class="button" style="background-color: red;">Eliminar</button>
                    </form>
                </td>
            </tr>
        <%
                }
            } else {
        %>
            <tr><td colspan="3">No tienes habitaciones registradas.</td></tr>
        <%
            }
        %>
        </tbody>
    </table>
</main>

</body>
</html>
