package com.microusuario.control;

import com.microusuario.config.DatabaseConfig;
import com.microusuario.dao.FabricaDAOUsuarios;
import com.microusuario.dao.UsuarioDao;
import com.microusuario.modelo.UsuarioDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registrar")
public class UsuarioController extends HttpServlet {
    
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String nombre = request.getParameter("nombre");
    String correo = request.getParameter("correo");
    String contrasena = request.getParameter("contrasena");
    String tipo = request.getParameter("tipo_usuario");

    UsuarioDTO usuario = new UsuarioDTO();
    usuario.setNombre(nombre);
    usuario.setCorreo(correo);
    usuario.setContrasena(contrasena);
    usuario.setTipoUsuario(tipo);

    // Aquí defines directamente el tipo de base de datos: "MONGODB " o "POSTGRE"
    String tipoBD = "MONGODB"; // <-- cámbialo a "POSTGRE" si quieres usar PostgreSQL

    UsuarioDao dao = FabricaDAOUsuarios.getFabrica(tipoBD).getUsuarioDAO();

    int idGenerado = dao.insertarUsuario(usuario);
    boolean exito = false;

    if (idGenerado > 0) {
        usuario.setId(idGenerado);
        exito = dao.insertarEnTablaTipo(idGenerado, tipo);
    }

if (exito) {
    request.setAttribute("mensaje", "Usuario registrado con éxito.");
    
    switch (tipo.toLowerCase()) {
        case "prestador":
            int prestadorId = dao.obtenerIdPrestadorPorUsuarioId(usuario.getId());
            request.getSession().setAttribute("prestadorId", prestadorId);
            response.sendRedirect("Prestador.jsp");
            break;
        case "cliente":
            request.getSession().setAttribute("usuario", usuario);
            response.sendRedirect("cliente.jsp");
            break;
        case "verificador":
            response.sendRedirect("verificador.jsp");
            break;
        default:
            request.getRequestDispatcher("registro.jsp").forward(request, response);
    }
}

}

}