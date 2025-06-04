package com.microusuario.dao;

public abstract class FabricaDAOUsuarios extends FabricaDao {
    public static final String TIPO_POSTGRE = "POSTGRE";
    public static final String TIPO_MONGODB = "MONGODB";
    
    public static FabricaDAOUsuarios getFabrica(String tipo) {
        if (tipo.equalsIgnoreCase(TIPO_POSTGRE)) {
            return new FabricaDAOUsuariosPostgre();
        } else if (tipo.equalsIgnoreCase(TIPO_MONGODB)) {
            return new FabricaDAOUsuariosMongoDB();
        }
        throw new IllegalArgumentException("Tipo de base de datos no soportado: " + tipo);
    }

    public abstract UsuarioDao getUsuarioDAO();
}
