package co.ed.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.ed.uco.nose.data.dao.entity.SqlConnection;
import co.ed.uco.nose.data.dao.entity.UserDAO;
import co.ed.uco.nose.entity.UserEntity;

public final class UserPostgreSqlDAO extends SqlConnection implements UserDAO {

	protected UserPostgreSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(UserEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> findByFilter(UserEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UserEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
