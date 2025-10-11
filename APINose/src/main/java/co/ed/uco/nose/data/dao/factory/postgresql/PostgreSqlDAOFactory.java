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
        this.connection = null;  // Inicialización segura para evitar NullPointer
        openConnection();
    }

    @Override
    public CityDAO getCityDAO() {
        if (connection == null) {
            throw new IllegalStateException("Conexión no inicializada. Llame a openConnection() primero.");
        }
        return new CityPostgreSqlDAO(connection);
    }

    @Override
    public CountryDAO getCountryDAO() {
        if (connection == null) {
            throw new IllegalStateException("Conexión no inicializada. Llame a openConnection() primero.");
        }
        return new CountryPostgreSqlDAO(connection);
    }

    @Override
    public DocumentTypeDAO getDocumentTypeDAO() {
        if (connection == null) {
            throw new IllegalStateException("Conexión no inicializada. Llame a openConnection() primero.");
        }
        return new DocumentTypePostgreSqlDAO(connection);
    }

    @Override
    public StateDAO getStateDAO() {
        if (connection == null) {
            throw new IllegalStateException("Conexión no inicializada. Llame a openConnection() primero.");
        }
        return new StatePostgreSqlDAO(connection);
    }

    @Override
    public UserDAO getUserDAO() {
        if (connection == null) {
            throw new IllegalStateException("Conexión no inicializada. Llame a openConnection() primero.");
        }
        return new UserPostgreSqlDAO(connection);
    }

    @Override
    protected void openConnection() {
        final String url = "jdbc:postgresql://localhost:5432/Doo";
        final String user = "postgres";
        final String password = "1023";

        try {
            connection = SqlConnectionHelper.openConnection(url, user, password);
            // Validación opcional post-apertura para asegurar estado inicial
            SqlConnectionHelper.validateConnection(connection);
            System.out.println("Conexión a PostgreSQL ('Doo') abierta exitosamente.");  // Log para depuración
        } catch (NoseException e) {
            // Re-lanza la excepción personalizada
            throw e;
        } catch (Exception e) {
            final String userMessage = MessagesEnum.USER_ERROR_CONNECTION_OPEN_FAILED.getContent();
            final String technicalMessage = "Error inesperado al abrir conexión: " + e.getMessage();
            throw NoseException.create(e, userMessage, technicalMessage);
        }
    }
}