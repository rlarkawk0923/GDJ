package com.gdu.movie.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.gdu.movie.domain.MovieDTO;

public interface MovieService {
	public List<MovieDTO> getMovieList();
	public void findMovies(HttpServletRequest request, Model model);
}

