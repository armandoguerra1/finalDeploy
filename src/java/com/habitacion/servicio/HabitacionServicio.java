/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.habitacion.servicio;

import com.microhabitacion.dao.FabricaDAOHabitacion;
import com.microhabitacion.dao.HabitacionDAO;
import com.microhabitacion.modelo.HabitacionDTO;
import java.util.List;

/**
 *
 * @author nella
 */
public class HabitacionServicio {
    private final HabitacionDAO dao;

    public HabitacionServicio() {
        this.dao = FabricaDAOHabitacion.getFabricaPostgre().getHabitacionDao();
    }

    public void agregarHabitacion(int prestadorId, String descripcion) {
        HabitacionDTO h = new HabitacionDTO(0, prestadorId, descripcion);
        dao.agregarHabitacion(h);
    }
    public List<HabitacionDTO> obtenerHabitacionesPorPrestador(int prestadorId) {
        return dao.obtenerHabitacionesPorPrestador(prestadorId);
    }

    public void eliminarHabitacion(int id) {
        dao.eliminarHabitacion(id);
    }

    public HabitacionDTO obtenerHabitacionPorId(int id) {
        return dao.obtenerHabitacionPorId(id);
    }

    public void actualizarHabitacion(HabitacionDTO habitacion) {
        dao.actualizarHabitacion(habitacion);
    }



}
