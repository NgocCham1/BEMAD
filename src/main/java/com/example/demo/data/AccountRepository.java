package com.example.demo.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Account;

public interface AccountRepository extends CrudRepository<Account, Integer>{
	@Query(value = "SELECT t FROM Account t WHERE email = ?1" )
	public Account getAccountByEmail(@Param("email") String email);
}
