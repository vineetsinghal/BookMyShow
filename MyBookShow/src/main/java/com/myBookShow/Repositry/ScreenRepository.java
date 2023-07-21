package com.myBookShow.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myBookShow.Entity.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Long> {

}
