package base.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.entity.UserEntity;
import base.model.UserModel;
import base.repo.SSNRepo;

@Service
public class SSNServiceImpl implements SSNService {
	@Autowired
	private SSNRepo repo;

	@Override
	public UserEntity saveUser(UserModel model) {
		UserEntity entity=new UserEntity();
		BeanUtils.copyProperties(model, entity);
		return repo.save(entity);
	}
	@Override
	public Boolean findBySSN(String ssn) {
		return (repo.findBySsn(ssn)!=null);
	}

}
