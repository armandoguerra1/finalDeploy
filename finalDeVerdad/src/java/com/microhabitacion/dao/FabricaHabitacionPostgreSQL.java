/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microhabitacion.dao;

/**
 *
 * @author nella
 */
public class FabricaHabitacionPostgreSQL extends FabricaDAOHabitacion {
    @Override
    public HabitacionDAO getHabitacionDao() {
        return new HabitacionDAOPostgre();
    }
}
