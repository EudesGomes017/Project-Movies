package com.Dleawebsystem.pjmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dleawebsystem.pjmovie.dto.MovieDTO;
import com.Dleawebsystem.pjmovie.dto.ScoreDTO;
import com.Dleawebsystem.pjmovie.entities.Movie;
import com.Dleawebsystem.pjmovie.entities.Score;
import com.Dleawebsystem.pjmovie.entities.User;
import com.Dleawebsystem.pjmovie.repositories.MovieRepository;
import com.Dleawebsystem.pjmovie.repositories.ScoreRepository;
import com.Dleawebsystem.pjmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {

		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}

		Movie movie = movieRepository.findById(dto.getMovieId()).get();

		Score score = new Score(movie, user);
		score.setAvalicao(dto.getScore());

		score = scoreRepository.saveAndFlush(score);

		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getAvalicao();

		}

		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);

	}
}
