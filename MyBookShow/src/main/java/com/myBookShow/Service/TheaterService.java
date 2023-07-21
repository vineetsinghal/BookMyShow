package com.myBookShow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBookShow.Entity.Theater;
import com.myBookShow.Repositry.TheaterRepository;

@Service
public class TheaterService {
	
	@Autowired
	private TheaterRepository theaterRepository;

	public Theater getTheaterById(Long theaterId) {
		
		
		return (Theater)theaterRepository.findById(theaterId).get();
	}

}
