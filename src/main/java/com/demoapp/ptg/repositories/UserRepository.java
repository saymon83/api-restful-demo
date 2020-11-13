package com.demoapp.ptg.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demoapp.ptg.models.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
	
	 @Query(" select usuario " +
	            " from User usuario " +
	            " where usuario.email = ?1" +
	            "   and usuario.password = ?2")
	 Optional<User> findByEmailESenha(@Param("email") String email, @Param("password") String senha);

}
