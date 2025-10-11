package co.ed.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.ed.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.ed.uco.nose.data.dao.entity.CountryDAO;
import co.ed.uco.nose.entity.CountryEntity;

public final class CountryPostgreSqlDAO extends SqlConnectionHelper implements CountryDAO {

	public CountryPostgreSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CountryEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryEntity> findByFilter(CountryEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountryEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
