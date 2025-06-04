/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microhabitacion.dao;

import com.microhabitacion.modelo.HabitacionDTO;
import java.util.List;

/**
 *
 * @author nella
 */
public interface HabitacionDAO {
   public void agregarHabitacion(HabitacionDTO habitacion);
   public List<HabitacionDTO> obtenerHabitacionesPorPrestador(int prestadorId);
   public List<HabitacionDTO> obtenerTodasLasHabitaciones(); // NUEVO MÉTODO
   public void eliminarHabitacion(int id);
   public HabitacionDTO obtenerHabitacionPorId(int id);
   public void actualizarHabitacion(HabitacionDTO habitacion);

}
