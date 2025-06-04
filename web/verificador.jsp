<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Panel Verificador</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #fff3cd;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #ffc107;
            color: #212529;
            padding: 15px;
            text-align: center;
        }
        main {
            margin: 30px auto;
            width: 80%;
            max-width: 600px;
            background-color: white;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        a.button {
            display: inline-block;
            margin-top: 15px;
            padding: 10px 15px;
            background-color: #ffc107;
            color: #212529;
            text-decoration: none;
            border-radius: 5px;
        }
        a.button:hover {
            background-color: #e0a800;
            color: white;
        }
    </style>
</head>
<body>

<header>
    <h1>Bienvenido, Verificador</h1>
</header>

<main>
    <p>Has iniciado sesión exitosamente como verificador.</p>

    <p>Aquí puedes revisar y validar registros o informes.</p>

    <a href="perfilVerificador.jsp" class="button">Ver Perfil</a>
    <a href="cerrarSesion" class="button">Cerrar Sesión</a>
</main>

</body>
</html>
