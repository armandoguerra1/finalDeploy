/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microhabitacion.modelo;

/**
 *
 * @author nella
 */
public class HabitacionDTO {
    private int id;
    private int prestadorId;
    private String descripcion;

    public HabitacionDTO() {}

    public HabitacionDTO(int id, int prestadorId, String descripcion) {
        this.id = id;
        this.prestadorId = prestadorId;
        this.descripcion = descripcion;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPrestadorId() { return prestadorId; }
    public void setPrestadorId(int prestadorId) { this.prestadorId = prestadorId; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public String toString() {
        return "HabitacionDTO{" +
                "id=" + id +
                ", prestadorId=" + prestadorId +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
