<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro Usuario</title>
    <style>
        body {
            background: linear-gradient(135deg, #74ebd5, #9face6);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .container {
            background-color: white;
            padding: 2em 3em;
            border-radius: 16px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 400px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 1.5em;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 0.3em;
            font-weight: bold;
            color: #555;
        }

        input, select {
            padding: 0.6em;
            border: 1px solid #ccc;
            border-radius: 8px;
            margin-bottom: 1.2em;
            font-size: 1em;
        }

        input[type="submit"] {
            background-color: #5a67d8;
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #434190;
        }

        p {
            text-align: center;
            margin-top: 1em;
            color: red;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Formulario de Registro</h2>
        <form action="registrar" method="post">
            <label>Nombre:</label>
            <input type="text" name="nombre" required>

            <label>Correo:</label>
            <input type="email" name="correo" required>

            <label>Contraseña:</label>
            <input type="password" name="contrasena" required>

            <label>Tipo de Usuario:</label>
            <select name="tipo_usuario" required>
                <option value="cliente">Cliente</option>
                <option value="prestador">Prestador</option>
                <option value="verificador">Verificador</option>
            </select>

            <input type="submit" value="Registrar">
        </form>

        <p>
            <%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %>
        </p>
    </div>
</body>
</html>
