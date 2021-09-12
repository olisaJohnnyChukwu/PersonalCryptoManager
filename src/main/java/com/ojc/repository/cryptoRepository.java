package com.ojc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ojc.model.crypto;

public interface cryptoRepository extends JpaRepository<crypto,Long> {
	@Transactional
	@Modifying
	@Query(value="UPDATE crypto c SET c.price = :price WHERE c.name =:name" ,nativeQuery=true)
	void updatePrice(@Param("name")String name,@Param("price")double price);

	

}
