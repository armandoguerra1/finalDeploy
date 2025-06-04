/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cliente.dao;

import com.cliente.modelo.ReservaDTO;
import java.sql.*;
/**
 *
 * @author nella
 */
public class ReservaDAO {
    public void insertar(ReservaDTO r) {
        String buscarClienteSQL = "SELECT id FROM cliente WHERE usuario_id = ?";
        String insertarReservaSQL = "INSERT INTO reserva (cliente_id, habitacion_id, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/sistema_reservas", "postgres", "123456")) {

            // Paso 1: obtener el id real del cliente desde su usuario_id
            int clienteId = -1;
            try (PreparedStatement buscarStmt = con.prepareStatement(buscarClienteSQL)) {
                buscarStmt.setInt(1, r.getClienteId()); // ← En realidad es el usuario_id
                try (ResultSet rs = buscarStmt.executeQuery()) {
                    if (rs.next()) {
                        clienteId = rs.getInt("id");
                    } else {
                        throw new SQLException("No se encontró un cliente con usuario_id = " + r.getClienteId());
                    }
                }
            }

            // Paso 2: insertar la reserva con el cliente_id correcto
            try (PreparedStatement insertarStmt = con.prepareStatement(insertarReservaSQL)) {
                insertarStmt.setInt(1, clienteId);
                insertarStmt.setInt(2, r.getHabitacionId());
                insertarStmt.setDate(3, r.getFechaInicio());
                insertarStmt.setDate(4, r.getFechaFin());
                insertarStmt.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
