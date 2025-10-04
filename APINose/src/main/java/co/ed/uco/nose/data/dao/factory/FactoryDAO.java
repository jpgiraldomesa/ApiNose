package co.ed.uco.nose.data.dao.factory;

import java.sql.Connection;

import co.ed.uco.nose.data.dao.entity.CityDAO;
import co.ed.uco.nose.data.dao.entity.CountryDAO;
import co.ed.uco.nose.data.dao.entity.DocumentTypeDAO;
import co.ed.uco.nose.data.dao.entity.StateDAO;
import co.ed.uco.nose.data.dao.entity.UserDAO;

public abstract class FactoryDAO {
	
	protected Connection connection;
	protected FactoryEnum factory = FactoryEnum.POSTGRESQL;
	
	
	public static FactoryDAO getFactory(FactoryEnum factory) {
		FactoryDAO factoryDAO = null;
		return factoryDAO;
	}
	
	public abstract CityDAO getCityDAO();
	
	public abstract CountryDAO getCountryDAO();
	
	public abstract DocumentTypeDAO getTypeDocumentDAO();
	
	public abstract StateDAO getStateDAO();
	
	public abstract UserDAO getUserDAO();
	
	protected abstract void openConnection();
	
	protected final void initializeTransaction() {
		try {
			connection.setAutoCommit(false);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}
	
	protected final void commitTransaction() {
		try {
			connection.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}
	
	protected final void rollbackTransaction() {
		try {
			connection.rollback();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	protected final void closeConnection() {
		try {
			connection.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
