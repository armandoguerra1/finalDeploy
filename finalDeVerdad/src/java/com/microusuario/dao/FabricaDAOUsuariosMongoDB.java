package com.microusuario.dao;

public class FabricaDAOUsuariosMongoDB extends FabricaDAOUsuarios {
    @Override
    public UsuarioDao getUsuarioDAO() {
        return new UsuarioDAOMongoDB();
    }
} 