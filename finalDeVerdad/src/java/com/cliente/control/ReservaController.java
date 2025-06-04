/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cliente.control;

import com.cliente.dao.ReservaDAO;
import com.cliente.modelo.ReservaDTO;
import com.microusuario.modelo.UsuarioDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;


/**
 *
 * @author nella
 */
@WebServlet("/ReservaController")
public class ReservaController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    int clienteId = ((UsuarioDTO) session.getAttribute("usuario")).getId(); // ← usa el ID del cliente autenticado

    int habitacionId = Integer.parseInt(request.getParameter("habitacion_id"));
    Date fechaInicio = Date.valueOf(request.getParameter("fecha_inicio"));
    Date fechaFin = Date.valueOf(request.getParameter("fecha_fin"));

    ReservaDTO reserva = new ReservaDTO();
    reserva.setClienteId(clienteId);
    reserva.setHabitacionId(habitacionId);
    reserva.setFechaInicio(fechaInicio);
    reserva.setFechaFin(fechaFin);

    ReservaDAO dao = new ReservaDAO();
    dao.insertar(reserva);

    response.sendRedirect("cliente");
}}
