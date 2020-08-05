package base.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.UserEntity;

public interface SSNRepo extends JpaRepository<UserEntity, Serializable>{
	UserEntity findBySsn(Long ssn);
}
