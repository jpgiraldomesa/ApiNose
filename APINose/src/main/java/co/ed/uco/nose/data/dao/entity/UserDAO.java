package co.ed.uco.nose.data.dao.entity;

import java.util.UUID;

import co.ed.uco.nose.data.dao.CreateDAO;
import co.ed.uco.nose.data.dao.DelateDAO;
import co.ed.uco.nose.data.dao.RetrieveDAO;
import co.ed.uco.nose.data.dao.UpdateDAO;
import co.ed.uco.nose.entity.UserEntity;

public interface UserDAO extends CreateDAO<UserEntity>, RetrieveDAO<UserEntity, UUID>, UpdateDAO<UserEntity>, DelateDAO<UUID> {

}
