package co.ed.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.ed.uco.nose.data.dao.entity.DocumentTypeDAO;
import co.ed.uco.nose.data.dao.entity.SqlConnection;
import co.ed.uco.nose.entity.DocumentTypeEntity;

public final class DocumentTypePostgreSqlDAO extends SqlConnection implements DocumentTypeDAO {

	protected DocumentTypePostgreSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<DocumentTypeEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DocumentTypeEntity> findByFilter(DocumentTypeEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentTypeEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
