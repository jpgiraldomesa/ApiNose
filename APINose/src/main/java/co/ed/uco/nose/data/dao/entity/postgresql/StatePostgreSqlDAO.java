package co.ed.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.ed.uco.nose.data.dao.entity.SqlConnection;
import co.ed.uco.nose.data.dao.entity.StateDAO;
import co.ed.uco.nose.entity.StateEntity;

public final class StatePostgreSqlDAO extends SqlConnection implements StateDAO {

	protected StatePostgreSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<StateEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateEntity> findByFilter(StateEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StateEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
