<%@page import="com.microhabitacion.modelo.HabitacionDTO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Habitación</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #e9f0f5;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        main {
            background: #ffffff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 420px;
        }

        h2 {
            margin-top: 0;
            color: #333;
            text-align: center;
        }

        label {
            display: block;
            margin-bottom: 6px;
            color: #444;
            font-weight: 500;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 16px;
            margin-bottom: 20px;
            transition: border-color 0.3s;
        }

        input[type="text"]:focus {
            border-color: #007bff;
            outline: none;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 12px;
            font-size: 16px;
            border: none;
            border-radius: 6px;
            width: 100%;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .cancel-link {
            display: block;
            text-align: center;
            margin-top: 15px;
            text-decoration: none;
            color: #007bff;
            font-size: 14px;
        }

        .cancel-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<main>
    <h2>Editar Habitación</h2>
    <form action="<%= request.getContextPath() %>/habitacion/editar" method="post">
        <input type="hidden" name="id" value="<%= ((HabitacionDTO) request.getAttribute("habitacion")).getId() %>" />
        <label for="descripcion">Descripción:</label>
        <input type="text" id="descripcion" name="descripcion" value="<%= ((HabitacionDTO) request.getAttribute("habitacion")).getDescripcion() %>" required />
        <input type="submit" value="Actualizar">
    </form>
    <a class="cancel-link" href="<%= request.getContextPath() %>/habitacion/listar">Cancelar</a>
</main>

</body>
</html>
