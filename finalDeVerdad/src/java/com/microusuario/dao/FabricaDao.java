package com.microusuario.dao;

import com.microusuario.dao.UsuarioDAOPostgre;

public abstract class FabricaDao {

    public static FabricaDao getFabricaPostgre() {
        return new FabricaPostgreSQL();
    }

    public abstract UsuarioDao getUsuarioDAO();

    private static class FabricaPostgreSQL extends FabricaDao {
        @Override
        public UsuarioDao getUsuarioDAO() {
            return new UsuarioDAOPostgre();
        }
    }
}
