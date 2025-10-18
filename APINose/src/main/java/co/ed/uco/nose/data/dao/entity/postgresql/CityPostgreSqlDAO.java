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
import co.ed.uco.nose.data.dao.entity.CityDAO;
import co.ed.uco.nose.entity.CityEntity;
import co.ed.uco.nose.entity.StateEntity;

public final class CityPostgreSqlDAO extends SqlConnectionHelper implements CityDAO {

    public CityPostgreSqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<CityEntity> findAll() {
        SqlConnectionHelper.validateConnection(getConnection());

        final List<CityEntity> cities = new ArrayList<>();
        final String sql = "SELECT * FROM ciudad";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    cities.add(mapResultSetToCityEntity(resultSet));
                }
            } catch (final SQLException exception) {
                var userMessage = MessagesEnum.USER_ERROR_CITY_FIND_ALL.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_FIND_ALL.getContent() + ": Error ejecutando consulta";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_CITY_FIND_ALL.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_FIND_ALL.getContent() + ": Error preparando consulta";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_CITY_FIND_ALL_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_FIND_ALL_UNEXPECTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

        return cities;
    }

    @Override
    public List<CityEntity> findByFilter(CityEntity filterEntity) {
        SqlConnectionHelper.validateConnection(getConnection());

        final List<CityEntity> cities = new ArrayList<>();
        final StringBuilder sql = new StringBuilder("SELECT * FROM ciudad WHERE 1=1");
        final List<Object> params = new ArrayList<>();

        if (filterEntity.getName() != null && !filterEntity.getName().isEmpty()) {
            sql.append(" AND nombre LIKE ?");
            params.add("%" + filterEntity.getName() + "%");
        }
        if (filterEntity.getState() != null && filterEntity.getState().getId() != null) {
            sql.append(" AND departamento_id = ?");
            params.add(filterEntity.getState().getId());
        }

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
            try {
                for (int i = 0; i < params.size(); i++) {
                    preparedStatement.setObject(i + 1, params.get(i));
                }
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        cities.add(mapResultSetToCityEntity(resultSet));
                    }
                } catch (final SQLException exception) {
                    var userMessage = MessagesEnum.USER_ERROR_CITY_FIND_BY_FILTER.getContent();
                    var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_FIND_BY_FILTER.getContent() + ": Error ejecutando consulta";
                    throw NoseException.create(exception, userMessage, technicalMessage);
                }
            } catch (final SQLException exception) {
                var userMessage = MessagesEnum.USER_ERROR_CITY_FIND_BY_FILTER.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_FIND_BY_FILTER.getContent() + ": Error preparando consulta";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_CITY_FIND_BY_FILTER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_FIND_BY_FILTER.getContent() + ": Error en conexión SQL";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_CITY_FIND_BY_FILTER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

        return cities;
    }

    @Override
    public CityEntity findById(UUID id) {
        SqlConnectionHelper.validateConnection(getConnection());

        final String sql = "SELECT * FROM ciudad WHERE id = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            try {
                preparedStatement.setObject(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapResultSetToCityEntity(resultSet);
                    }
                    return null;
                } catch (final SQLException exception) {
                    var userMessage = MessagesEnum.USER_ERROR_CITY_FIND_BY_ID.getContent();
                    var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_FIND_BY_ID.getContent() + ": Error ejecutando consulta";
                    throw NoseException.create(exception, userMessage, technicalMessage);
                }
            } catch (final SQLException exception) {
                var userMessage = MessagesEnum.USER_ERROR_CITY_FIND_BY_ID.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_FIND_BY_ID.getContent() + ": Error preparando consulta";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_CITY_FIND_BY_ID.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_FIND_BY_ID.getContent() + ": Error en conexión SQL";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_CITY_FIND_BY_ID_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_FIND_BY_ID_UNEXPECTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    private CityEntity mapResultSetToCityEntity(ResultSet resultSet) throws SQLException {
        final CityEntity entity = new CityEntity();

        try {
            entity.setId(UUID.fromString(resultSet.getString("id")));
        } catch (IllegalArgumentException exception) {
            var userMessage = MessagesEnum.USER_ERROR_INVALID_UUID.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_INVALID_UUID.getContent() + ": ID inválido en ciudad";
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

        entity.setName(resultSet.getString("nombre"));

        if (resultSet.getString("departamento_id") != null) {
            final StateEntity state = new StateEntity();
            try {
                state.setId(UUID.fromString(resultSet.getString("departamento_id")));
            } catch (IllegalArgumentException exception) {
                var userMessage = MessagesEnum.USER_ERROR_INVALID_UUID.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_INVALID_UUID.getContent() + ": departamento_id inválido";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
            entity.setState(state);
        }

        return entity;
    }
}