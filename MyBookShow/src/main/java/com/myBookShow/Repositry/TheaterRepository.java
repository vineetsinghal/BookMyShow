package com.myBookShow.Repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myBookShow.Entity.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

	Optional<Theater> findById(Long theaterId);
	

}
