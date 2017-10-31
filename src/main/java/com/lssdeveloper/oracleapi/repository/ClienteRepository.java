package com.lssdeveloper.oracleapi.repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.lssdeveloper.oracleapi.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	List<Cliente> findByEmail(String email);

	List<Cliente> findByData(Date data);

	// custom query example and return a stream
	@Query("select c from Cliente c where c.email = :email")
	Stream<Cliente> findByEmailReturnStream(@Param("email") String email);

}
