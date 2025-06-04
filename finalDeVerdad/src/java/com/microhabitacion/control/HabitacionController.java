/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microhabitacion.control;

import com.habitacion.servicio.HabitacionServicio;
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

@WebServlet(name = "HabitacionController", urlPatterns = {"/habitacion/registrar", "/habitacion/eliminar", "/habitacion/listar",  "/habitacion/editar"})
public class HabitacionController extends HttpServlet {
    private final HabitacionServicio servicio = new HabitacionServicio();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = request.getServletPath();

        switch (path) {
            case "/habitacion/listar":
                listarHabitaciones(request, response);
                break;
            case "/habitacion/eliminar":
                eliminarHabitacion(request, response);
                break;
                
            case "/habitacion/editar":
                mostrarFormularioEdicion(request, response);
                break;
            default:
                response.sendRedirect("vistaPrestador.jsp");
        }
    }

    private void listarHabitaciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer prestadorId = (Integer) request.getSession().getAttribute("prestadorId");
        if (prestadorId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<HabitacionDTO> habitaciones = servicio.obtenerHabitacionesPorPrestador(prestadorId);
        request.setAttribute("habitaciones", habitaciones);
        request.getRequestDispatcher("/Prestador.jsp").forward(request, response);
    }

    private void eliminarHabitacion(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        servicio.eliminarHabitacion(id);
        response.sendRedirect(request.getContextPath() + "/habitacion/listar");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        switch (path) {
            case "/habitacion/registrar":
                registrarHabitacion(request, response);
                break;
            case "/habitacion/editar":
                actualizarHabitacion(request, response);
                break;
            case "/habitacion/eliminar":
                eliminarHabitacion(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }



    private void mostrarFormularioEdicion(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HabitacionDTO habitacion = servicio.obtenerHabitacionPorId(id);
        request.setAttribute("habitacion", habitacion);
        request.getRequestDispatcher("/editarHabitacion.jsp").forward(request, response);
    }

    private void registrarHabitacion(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    try {
        Integer prestadorId = (Integer) request.getSession().getAttribute("prestadorId");

        if (prestadorId == null) {
            request.setAttribute("mensaje", "Error: sesión expirada o prestador no autenticado.");
            request.getRequestDispatcher("/formularioHabitacion.jsp").forward(request, response);
            return;
        }

        String descripcion = request.getParameter("descripcion");
        servicio.agregarHabitacion(prestadorId, descripcion);

        response.sendRedirect(request.getContextPath() + "/habitacion/listar");
    } catch (Exception e) {
        request.setAttribute("mensaje", "Error al registrar habitación: " + e.getMessage());
        request.getRequestDispatcher("/formularioHabitacion.jsp").forward(request, response);
    }
}



    private void actualizarHabitacion(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    String descripcion = request.getParameter("descripcion");

    HabitacionDTO hab = new HabitacionDTO();
    hab.setId(id);
    hab.setDescripcion(descripcion);

    servicio.actualizarHabitacion(hab);
    response.sendRedirect(request.getContextPath() + "/habitacion/listar");
}


}
