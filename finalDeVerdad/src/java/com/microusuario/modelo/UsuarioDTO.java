package com.microusuario.modelo;

public class UsuarioDTO {
    private int id;
    private String nombre;
    private String correo;
    private String contrasena;
    private String tipoUsuario;

    // Constructor vacío
    public UsuarioDTO() {
    }

    // Constructor completo
    public UsuarioDTO(String nombre, String correo, String contrasena, String tipoUsuario) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }
}
