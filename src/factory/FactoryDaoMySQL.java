package factory;

import dal.Configuracion;
import dao.*;

/**
 *
 * @author Jose Carlos Gutierrez
 */
class FactoryDaoMySQL extends FactoryDao {

    private FactoryDaoMySQL() {
        dbEngine = "MySQL";
    }

    public static FactoryDao getFactoryInstance() {
        instancia = new FactoryDaoMySQL();
        return instancia;
    }

    @Override
    public ContactoDao getNewContactoDao() {
        return new ContactoDaoMySQL();
    }

}
