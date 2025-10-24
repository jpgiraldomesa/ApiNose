package co.ed.uco.nose.data.dao.factory.postgresql;

import java.sql.Connection;
import java.sql.SQLException;

import co.ed.uco.nose.crosscuting.exception.NoseException;
import co.ed.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.ed.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.ed.uco.nose.data.dao.entity.CityDAO;
import co.ed.uco.nose.data.dao.entity.CountryDAO;
import co.ed.uco.nose.data.dao.entity.DocumentTypeDAO;
import co.ed.uco.nose.data.dao.entity.StateDAO;
import co.ed.uco.nose.data.dao.entity.UserDAO;
import co.ed.uco.nose.data.dao.entity.postgresql.CityPostgreSqlDAO;
import co.ed.uco.nose.data.dao.entity.postgresql.CountryPostgreSqlDAO;
import co.ed.uco.nose.data.dao.entity.postgresql.DocumentTypePostgreSqlDAO;
import co.ed.uco.nose.data.dao.entity.postgresql.StatePostgreSqlDAO;
import co.ed.uco.nose.data.dao.entity.postgresql.UserPostgreSqlDAO;
import co.ed.uco.nose.data.dao.factory.FactoryDAO;

/**
 * Fábrica de DAOs específica para PostgreSQL, extendiendo FactoryDAO.
 * Inicializa la conexión a la base de datos local "Doo" y proporciona instancias de DAOs.
 * Maneja excepciones con NoseException para consistencia.
 */
public final class PostgreSqlDAOFactory extends FactoryDAO {

    // Campo para la conexión, heredado o declarado si no existe en la superclase
    protected Connection connection;

    public PostgreSqlDAOFactory() {
        this.connection = null;
        openConnection();
    }

    @Override
    protected void openConnection() {
        final String url = "jdbc:postgresql://localhost:5432/DOO";
        final String user = "postgres";
        final String password = "1023";

        try {
            this.connection = SqlConnectionHelper.openConnection(url, user, password);
            SqlConnectionHelper.ensureConnectionIsNotNull(connection);
            System.out.println("Conexión a PostgreSQL ('Doo') abierta exitosamente.");  // Log para depuración
        /*} catch (final SQLException exception) {
            var userMessage = "MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent()";
            var technicalMessage = "MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_CONNECTION_STATUS.getContent()";
            throw NoseException.create(exception, userMessage, technicalMessage);*/
        } catch (final Exception exception) {
            var userMessage = "MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent()";
            var technicalMessage = "MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent()";
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public CityDAO getCityDAO() {
       	SqlConnectionHelper.ensureConnectionIsNotNull(connection);
        return new CityPostgreSqlDAO(connection);
    }

    @Override
    public CountryDAO getCountryDAO() {
    	SqlConnectionHelper.ensureConnectionIsNotNull(connection);
        return new CountryPostgreSqlDAO(connection);
    }

    @Override
    public DocumentTypeDAO getDocumentTypeDAO() {
        SqlConnectionHelper.ensureConnectionIsNotNull(connection);
        return new DocumentTypePostgreSqlDAO(connection);
    }

    @Override
    public StateDAO getStateDAO() {
    	SqlConnectionHelper.ensureConnectionIsNotNull(connection);
        return new StatePostgreSqlDAO(connection);
    }

    @Override
    public UserDAO getUserDAO() {
    	SqlConnectionHelper.ensureConnectionIsNotNull(connection);
        return new UserPostgreSqlDAO(connection);
    }
}