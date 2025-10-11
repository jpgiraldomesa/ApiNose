package co.ed.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.ed.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.ed.uco.nose.data.dao.entity.CityDAO;
import co.ed.uco.nose.entity.CityEntity;

public final class CityPostgreSqlDAO extends SqlConnectionHelper implements CityDAO {

	public CityPostgreSqlDAO(final Connection connection) {
		super(connection);
	}
	
	@Override
	public List<CityEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityEntity> findByFilter(CityEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
}