package dao;

import dal.Conexion;
import dto.Contacto;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class ContactoDaoMySQL extends ContactoDao {

    @Override
    public int insert(Contacto obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        int id = 0;
        StringBuilder query = new StringBuilder("INSERT INTO contacto (nombre, telefono) VALUES (");
        query.append("'" + obj.getNombre() + "',");
        query.append("'" + obj.getTelefono() + "' ");
        query.append(")");
        id = objConexion.ejecutarInsert(query.toString());
        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(Contacto obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        StringBuilder query = new StringBuilder("UPDATE contacto SET ");
        query.append("nombre = '" + obj.getNombre() + "',");
        query.append("telefono = '" + obj.getTelefono() + "' ");
        query.append("WHERE contactoId = " + obj.getContactoId());
        int upd = objConexion.ejecutarSimple(query.toString());
        if (upd == 0) {
            throw new Exception("El registro no pudo ser actualizado");
        }

        objConexion.desconectar();
    }

    @Override
    public void delete(int id) {
        Conexion objConexion = Conexion.getOrCreate();
        StringBuffer query = new StringBuffer("DELETE FROM contacto ");
        query.append("WHERE contactoId = " + id);
        objConexion.ejecutarSimple(query.toString());
        objConexion.desconectar();
    }

    @Override
    public Contacto get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT contactoId, nombre, telefono FROM contacto WHERE contactoId = " + id;
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            if (objResultSet.next()) {
                Contacto obj = new Contacto();
                int _contactoId = objResultSet.getInt("contactoId");
                obj.setContactoId(_contactoId);

                String _nombre = objResultSet.getString("nombre");
                obj.setNombre(_nombre);

                String _telefono = objResultSet.getString("telefono");
                obj.setTelefono(_telefono);

                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }

    @Override
    public ArrayList<Contacto> getList() {
        ArrayList<Contacto> registros = new ArrayList<Contacto>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT contactoId, nombre, telefono FROM contacto";
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            while (objResultSet.next()) {
                Contacto obj = new Contacto();
                int _contactoId = objResultSet.getInt("contactoId");
                obj.setContactoId(_contactoId);

                String _nombre = objResultSet.getString("nombre");
                obj.setNombre(_nombre);

                String _telefono = objResultSet.getString("telefono");
                obj.setTelefono(_telefono);

                registros.add(obj);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return registros;
    }

}
