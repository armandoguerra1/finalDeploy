package com.microusuario.dao;

public class FabricaDAOUsuariosPostgre extends FabricaDAOUsuarios {
    @Override
    public UsuarioDao getUsuarioDAO() {
        return new UsuarioDAOPostgre();
    }
} 