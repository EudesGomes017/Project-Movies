package com.Dleawebsystem.pjmovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Dleawebsystem.pjmovie.dto.MovieDTO;
import com.Dleawebsystem.pjmovie.dto.ScoreDTO;
import com.Dleawebsystem.pjmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
		MovieDTO movieDto = scoreService.saveScore(dto);
		return movieDto;
		
	}

}
