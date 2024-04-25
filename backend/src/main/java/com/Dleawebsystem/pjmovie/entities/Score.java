package com.Dleawebsystem.pjmovie.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score {

	@EmbeddedId
	private ScorePK id = new ScorePK();

	private Double avalicao;

	public Score() {

	}

	public Score(Movie movie, User user, Double avalicao) {

		id.setMovie(movie);
		id.setUser(user);
		this.avalicao = avalicao;
	}

	public Score(Movie movie, User user) {

		id.setMovie(movie);
		id.setUser(user);

	}

	public Double getAvalicao() {
		return avalicao;
	}

	public void setAvalicao(Double avalicao) {
		this.avalicao = avalicao;
	}

	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

}
