package com.myBookShow.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myBookShow.Entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
