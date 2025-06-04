package com.microusuario.dao;

import com.microusuario.modelo.UsuarioDTO;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

public class UsuarioDAOMongoDB implements UsuarioDao {

private static final String CONNECTION_STRING = "mongodb+srv://luisahernandeze902:kGlnbQeQZg6GRdi7@clustersistema.iwaaqe9.mongodb.net/?retryWrites=true&w=majority&appName=ClusterSistema";
private static final String DATABASE = "sistema_reservas";
private static final String COLLECTION = "usuarios";


    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public UsuarioDAOMongoDB() {
        try {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE);
            collection = database.getCollection(COLLECTION);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertarUsuario(UsuarioDTO usuario) {
        Document doc = new Document()
            .append("nombre", usuario.getNombre())
            .append("correo", usuario.getCorreo())
            .append("contrasena", usuario.getContrasena())
            .append("tipo_usuario", usuario.getTipoUsuario());

        collection.insertOne(doc);
        ObjectId id = doc.getObjectId("_id");

        return id.hashCode(); // Devuelve un identificador int basado en el ObjectId
    }

    @Override
    public boolean insertarEnTablaTipo(int usuarioId, String tipo) {
        // Ya no se inserta en otra colección. Actualizamos el campo tipo_usuario
        Document query = new Document("usuario_id", usuarioId);
        Document update = new Document("$set", new Document("tipo_usuario", tipo.toLowerCase()));

        try {
            collection.updateOne(query, update);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int obtenerIdPrestadorPorUsuarioId(int usuarioId) {
        Document query = new Document("usuario_id", usuarioId)
            .append("tipo_usuario", "prestador");

        Document result = collection.find(query).first();

        if (result != null) {
            return result.getObjectId("_id").hashCode();
        }
        return -1;
    }
}
