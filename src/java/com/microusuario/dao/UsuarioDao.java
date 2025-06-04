package com.microusuario.dao;

import com.microusuario.modelo.UsuarioDTO;

public interface UsuarioDao {
    int insertarUsuario(UsuarioDTO usuario);
    boolean insertarEnTablaTipo(int usuarioId, String tipo);
    int obtenerIdPrestadorPorUsuarioId(int usuarioId);

}
