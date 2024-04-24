package com.Dleawebsystem.pjmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Dleawebsystem.pjmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
