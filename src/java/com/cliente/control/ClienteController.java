/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cliente.control;

import com.microhabitacion.dao.HabitacionDAO;
import com.microhabitacion.dao.HabitacionDAOPostgre;
import com.microhabitacion.modelo.HabitacionDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author nella
 */

@WebServlet("/cliente")
public class ClienteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HabitacionDAO dao = new HabitacionDAOPostgre();
        List<HabitacionDTO> habitaciones = dao.obtenerTodasLasHabitaciones();
        request.setAttribute("habitaciones", habitaciones);
        request.getRequestDispatcher("cliente.jsp").forward(request, response);
    }
}
    