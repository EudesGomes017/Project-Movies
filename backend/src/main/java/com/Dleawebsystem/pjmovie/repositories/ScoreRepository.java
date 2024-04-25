package com.Dleawebsystem.pjmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Dleawebsystem.pjmovie.entities.Score;
import com.Dleawebsystem.pjmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}
