package com.myBookShow.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Movie {
    

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

   

    @ManyToMany(mappedBy = "movies")
    private Set<Theater> theaters = new HashSet<>();

    
    public Set<Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(Set<Theater> theaters) {
        this.theaters = theaters;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
