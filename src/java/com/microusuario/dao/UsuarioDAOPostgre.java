package com.microusuario.dao;


import com.microusuario.dao.UsuarioDao;
import com.microusuario.modelo.UsuarioDTO;

import java.sql.*;

public class UsuarioDAOPostgre implements UsuarioDao {
    private static final String URL = "jdbc:postgresql://localhost:5432/sistema_reservas";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    public UsuarioDAOPostgre() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertarUsuario(UsuarioDTO usuario) {
        int idGenerado = -1;
        String sql = "INSERT INTO usuario(nombre, correo, contrasena, tipo_usuario) VALUES (?, ?, ?, ?) RETURNING id";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getCorreo());
            pst.setString(3, usuario.getContrasena());
            pst.setString(4, usuario.getTipoUsuario());

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                idGenerado = rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idGenerado;
    }

    @Override
    public boolean insertarEnTablaTipo(int usuarioId, String tipo) {
        String sql = switch (tipo.toLowerCase()) {
            case "cliente" -> "INSERT INTO cliente (usuario_id) VALUES (?)";
            case "prestador" -> "INSERT INTO prestador (usuario_id) VALUES (?)";
            case "verificador" -> "INSERT INTO verificador (usuario_id) VALUES (?)";
            default -> null;
        };

        if (sql == null) return false;

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, usuarioId);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
@Override
public int obtenerIdPrestadorPorUsuarioId(int usuarioId) {
    String sql = "SELECT id FROM prestador WHERE usuario_id = ?";
    try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1, usuarioId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return rs.getInt("id");
        }

    } catch (SQLException e) {
        e.printStackTrace(); // o usa logs
    }

    return -1; // No encontrado o error
}


}