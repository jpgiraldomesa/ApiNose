package co.ed.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.ed.uco.nose.crosscuting.exception.NoseException;
import co.ed.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.ed.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.ed.uco.nose.data.dao.entity.UserDAO;
import co.ed.uco.nose.entity.UserEntity;

public final class UserPostgreSqlDAO extends SqlConnectionHelper implements UserDAO {

    public UserPostgreSqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(final UserEntity entity) {
        SqlConnectionHelper.validateConnection(getConnection());
        SqlConnectionHelper.validateIfTransactionWasInitiated(getConnection());

        final StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO usuario (id, tipo_identificacion_id, numero_identificacion, primer_nombre, ");
        sql.append("segundo_nombre, primer_apellido, segundo_apellido, ciudad_residencia_id, correo_electronico, ");
        sql.append("numero_telefono_movil, correo_electronico_confirmado, numero_telefono_movil_confirmado) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, entity.getId());  // UUID con setObject
            preparedStatement.setObject(2, entity.getDocumentType().getId());  // FK UUID con setObject
            preparedStatement.setString(3, entity.getDocumentNumber());
            preparedStatement.setString(4, entity.getFirstName());
            preparedStatement.setString(5, entity.getSecondName());
            preparedStatement.setString(6, entity.getFirstSurname());
            preparedStatement.setString(7, entity.getSecondSurname());
            preparedStatement.setObject(8, entity.getResidenceCity().getId());  // FK UUID con setObject
            preparedStatement.setString(9, entity.getEmail());
            preparedStatement.setString(10, entity.getMobilePhoneNumber());
            preparedStatement.setBoolean(11, entity.isEmailConfirmed());
            preparedStatement.setBoolean(12, entity.isMobilePhoneNumberConfirmed());
            
            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<UserEntity> findAll() {
        SqlConnectionHelper.validateConnection(getConnection());

        final List<UserEntity> users = new ArrayList<>();
        final String sql = "SELECT * FROM usuario";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            while (resultSet.next()) {
                users.add(mapResultSetToUserEntity(resultSet));
            }
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

        return users;
    }

    @Override
    public List<UserEntity> findByFilter(UserEntity filterEntity) {
        SqlConnectionHelper.validateConnection(getConnection());

        final List<UserEntity> users = new ArrayList<>();
        final StringBuilder sql = new StringBuilder("SELECT * FROM usuario WHERE 1=1");
        
        if (filterEntity.getDocumentNumber() != null && !filterEntity.getDocumentNumber().isEmpty()) {
            sql.append(" AND numero_identificacion = ?");
        }
        // Agregue más filtros según necesidades (e.g., por email)

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
            int paramIndex = 1;
            if (filterEntity.getDocumentNumber() != null && !filterEntity.getDocumentNumber().isEmpty()) {
                preparedStatement.setString(paramIndex++, filterEntity.getDocumentNumber());
            }
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    users.add(mapResultSetToUserEntity(resultSet));
                }
            }
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

        return users;
    }

    @Override
    public UserEntity findById(UUID id) {
        SqlConnectionHelper.validateConnection(getConnection());

        final String sql = "SELECT * FROM usuario WHERE id = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setObject(1, id);  // UUID con setObject
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToUserEntity(resultSet);
                }
                return null;  // O lance excepción si no encontrado
            }
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void update(UserEntity entity) {
        SqlConnectionHelper.validateConnection(getConnection());
        SqlConnectionHelper.validateIfTransactionWasInitiated(getConnection());

        final StringBuilder sql = new StringBuilder("UPDATE usuario SET ");
        sql.append("tipo_identificacion_id = ?, numero_identificacion = ?, primer_nombre = ?, ");
        sql.append("segundo_nombre = ?, primer_apellido = ?, segundo_apellido = ?, ciudad_residencia_id = ?, ");
        sql.append("correo_electronico = ?, numero_telefono_movil = ?, correo_electronico_confirmado = ?, ");
        sql.append("numero_telefono_movil_confirmado = ? WHERE id = ?");

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, entity.getDocumentType().getId());  // FK UUID con setObject
            preparedStatement.setString(2, entity.getDocumentNumber());
            preparedStatement.setString(3, entity.getFirstName());
            preparedStatement.setString(4, entity.getSecondName());
            preparedStatement.setString(5, entity.getFirstSurname());
            preparedStatement.setString(6, entity.getSecondSurname());
            preparedStatement.setObject(7, entity.getResidenceCity().getId());  // FK UUID con setObject
            preparedStatement.setString(8, entity.getEmail());
            preparedStatement.setString(9, entity.getMobilePhoneNumber());
            preparedStatement.setBoolean(10, entity.isEmailConfirmed());
            preparedStatement.setBoolean(11, entity.isMobilePhoneNumberConfirmed());
            preparedStatement.setObject(12, entity.getId());  // UUID con setObject en WHERE
            
            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void delete(UUID id) {
        SqlConnectionHelper.validateConnection(getConnection());
        SqlConnectionHelper.validateIfTransactionWasInitiated(getConnection());

        final String sql = "DELETE FROM usuario WHERE id = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setObject(1, id);  // UUID con setObject
            
            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }
    
    // Método auxiliar para mapear ResultSet a UserEntity
    private UserEntity mapResultSetToUserEntity(ResultSet resultSet) throws SQLException {
        final UserEntity entity = new UserEntity();
        entity.setId(UUID.fromString(resultSet.getString("id")));
        // Asuma getters en UserEntity para setear otros campos; ej:
        // entity.setDocumentType(new DocumentTypeEntity()); // Mapear FKs
        // entity.setDocumentNumber(resultSet.getString("numero_identificacion"));
        // entity.setFirstName(resultSet.getString("primer_nombre"));
        // ... (completar según MER)
        return entity;
    }
}