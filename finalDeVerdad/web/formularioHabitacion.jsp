<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar Habitación</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; }
        .container { width: 50%; margin: auto; background: white; padding: 20px; border-radius: 8px; margin-top: 40px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        h2 { text-align: center; }
        input[type="text"], textarea { width: 100%; padding: 10px; margin-top: 10px; border: 1px solid #ccc; border-radius: 4px; }
        input[type="submit"], a.button { padding: 10px 15px; background-color: #007bff; color: white; border: none; border-radius: 5px; text-decoration: none; margin-top: 15px; display: inline-block; }
        input[type="submit"]:hover, a.button:hover { background-color: #0056b3; }
    </style>
</head>
<body>

<div class="container">
    <h2>Registrar Nueva Habitación</h2>

    <form action="${pageContext.request.contextPath}/habitacion/registrar" method="post">
        <label for="descripcion">Descripción:</label>
        <textarea name="descripcion" id="descripcion" rows="4" required></textarea>
        <input type="submit" value="Registrar">
    </form>

    <a href="${pageContext.request.contextPath}/Prestador.jsp" class="button">Volver al Panel del Prestador</a>


    <p style="color:green;">
        ${mensaje != null ? mensaje : ""}
    </p>
</div>

</body>
</html>
