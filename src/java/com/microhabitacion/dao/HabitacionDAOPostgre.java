/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microhabitacion.dao;

/**
 *
 * @author nella
 */
import com.microhabitacion.modelo.HabitacionDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabitacionDAOPostgre implements HabitacionDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/sistema_reservas";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    public HabitacionDAOPostgre() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void agregarHabitacion(HabitacionDTO h) {
        String sql = "INSERT INTO habitacion (prestador_id, descripcion) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, h.getPrestadorId());
            stmt.setString(2, h.getDescripcion());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HabitacionDTO> obtenerHabitacionesPorPrestador(int prestadorId) {
        List<HabitacionDTO> lista = new ArrayList<>();
        String sql = "SELECT id, descripcion FROM habitacion WHERE prestador_id = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, prestadorId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                HabitacionDTO hab = new HabitacionDTO();
                hab.setId(rs.getInt("id"));
                hab.setDescripcion(rs.getString("descripcion"));
                lista.add(hab);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void eliminarHabitacion(int id) {
        String sql = "DELETE FROM habitacion WHERE id = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HabitacionDTO obtenerHabitacionPorId(int id) {
        HabitacionDTO hab = null;
        String sql = "SELECT id, descripcion FROM habitacion WHERE id = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                hab = new HabitacionDTO();
                hab.setId(rs.getInt("id"));
                hab.setDescripcion(rs.getString("descripcion"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hab;
    }

    @Override
    public void actualizarHabitacion(HabitacionDTO habitacion) {
        String sql = "UPDATE habitacion SET descripcion = ? WHERE id = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, habitacion.getDescripcion());
            pst.setInt(2, habitacion.getId());
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

@Override
public List<HabitacionDTO> obtenerTodasLasHabitaciones() {
    List<HabitacionDTO> lista = new ArrayList<>();
    try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = con.prepareStatement("SELECT id, descripcion FROM habitacion");
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            HabitacionDTO hab = new HabitacionDTO();
            hab.setId(rs.getInt("id"));
            hab.setDescripcion(rs.getString("descripcion"));
            lista.add(hab);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
}



}
