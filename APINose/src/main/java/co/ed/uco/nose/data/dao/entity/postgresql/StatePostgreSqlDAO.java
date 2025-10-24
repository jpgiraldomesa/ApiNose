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
import co.ed.uco.nose.data.dao.entity.StateDAO;
import co.ed.uco.nose.entity.StateEntity;
import co.ed.uco.nose.entity.CountryEntity;

public final class StatePostgreSqlDAO extends SqlConnectionHelper implements StateDAO {

    public StatePostgreSqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<StateEntity> findAll() {
        SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());

        final List<StateEntity> states = new ArrayList<>();
        final String sql = "SELECT * FROM departamento";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    states.add(mapResultSetToStateEntity(resultSet));
                }
            } catch (final SQLException exception) {
                var userMessage = MessagesEnum.USER_ERROR_STATE_FIND_ALL.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_FIND_ALL.getContent() + ": Error ejecutando consulta";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_STATE_FIND_ALL.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_FIND_ALL.getContent() + ": Error preparando consulta";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_STATE_FIND_ALL_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_FIND_ALL_UNEXPECTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

        return states;
    }

    @Override
    public List<StateEntity> findByFilter(StateEntity filterEntity) {
        SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());

        final List<StateEntity> states = new ArrayList<>();
        final StringBuilder sql = new StringBuilder("SELECT * FROM departamento WHERE 1=1");
        final List<Object> params = new ArrayList<>();

        if (filterEntity.getName() != null && !filterEntity.getName().isEmpty()) {
            sql.append(" AND nombre LIKE ?");
            params.add("%" + filterEntity.getName() + "%");
        }
        if (filterEntity.getCountry() != null && filterEntity.getCountry().getId() != null) {
            sql.append(" AND pais_id = ?");
            params.add(filterEntity.getCountry().getId());
        }

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
            try {
                for (int i = 0; i < params.size(); i++) {
                    preparedStatement.setObject(i + 1, params.get(i));
                }
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        states.add(mapResultSetToStateEntity(resultSet));
                    }
                } catch (final SQLException exception) {
                    var userMessage = MessagesEnum.USER_ERROR_STATE_FIND_BY_FILTER.getContent();
                    var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_FIND_BY_FILTER.getContent() + ": Error ejecutando consulta";
                    throw NoseException.create(exception, userMessage, technicalMessage);
                }
            } catch (final SQLException exception) {
                var userMessage = MessagesEnum.USER_ERROR_STATE_FIND_BY_FILTER.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_FIND_BY_FILTER.getContent() + ": Error preparando consulta";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_STATE_FIND_BY_FILTER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_FIND_BY_FILTER.getContent() + ": Error en conexión SQL";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_STATE_FIND_BY_FILTER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

        return states;
    }

    @Override
    public StateEntity findById(UUID id) {
        SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());

        final String sql = "SELECT * FROM departamento WHERE id = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            try {
                preparedStatement.setObject(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapResultSetToStateEntity(resultSet);
                    }
                    return null;
                } catch (final SQLException exception) {
                    var userMessage = MessagesEnum.USER_ERROR_STATE_FIND_BY_ID.getContent();
                    var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_FIND_BY_ID.getContent() + ": Error ejecutando consulta";
                    throw NoseException.create(exception, userMessage, technicalMessage);
                }
            } catch (final SQLException exception) {
                var userMessage = MessagesEnum.USER_ERROR_STATE_FIND_BY_ID.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_FIND_BY_ID.getContent() + ": Error preparando consulta";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_STATE_FIND_BY_ID.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_FIND_BY_ID.getContent() + ": Error en conexión SQL";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_STATE_FIND_BY_ID_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_FIND_BY_ID_UNEXPECTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    private StateEntity mapResultSetToStateEntity(ResultSet resultSet) throws SQLException {
        final StateEntity entity = new StateEntity();

        try {
            entity.setId(UUID.fromString(resultSet.getString("id")));
        } catch (IllegalArgumentException exception) {
            var userMessage = MessagesEnum.USER_ERROR_INVALID_UUID.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_INVALID_UUID.getContent() + ": ID inválido en departamento";
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

        entity.setName(resultSet.getString("nombre"));

        if (resultSet.getString("pais_id") != null) {
            final CountryEntity country = new CountryEntity();
            try {
                country.setId(UUID.fromString(resultSet.getString("pais_id")));
            } catch (IllegalArgumentException exception) {
                var userMessage = MessagesEnum.USER_ERROR_INVALID_UUID.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_INVALID_UUID.getContent() + ": pais_id inválido";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
            entity.setCountry(country);
        }

        return entity;
    }
}