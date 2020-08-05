package base.service;

import base.entity.UserEntity;
import base.model.UserModel;

public interface SSNService {
	UserEntity saveUser(UserModel model);
	Boolean findBySSN(Long ssn);
}
