package org.psw_isa.psw_isa_backend.repository;

import java.time.LocalDate;

import org.psw_isa.psw_isa_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findOneByid(Long id);
	User findOneByemail(String email);
	List<User> findAll();

	@Transactional
	@Modifying
	@Query(value = "UPDATE users SET firstname = :firstname, lastname = :lastname, address = :address, birthday = :birthday, mobile_phone = :mobile_phone, password = :password WHERE id = :id", nativeQuery = true)
	public int updateUser(@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("address") String address, @Param("birthday") LocalDate birthday, @Param("mobile_phone") String mobile_phone, @Param("password") String password, @Param("id") Long id);


}
