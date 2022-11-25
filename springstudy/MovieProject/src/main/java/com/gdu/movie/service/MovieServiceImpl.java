package com.gdu.movie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.mapper.MovieMapper;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;
	
	@Override
	public List<MovieDTO> getMovieList() {
		return movieMapper.selectAllMovies();
	}

	@Override
	public void findMovies(HttpServletRequest request, Model model) {
		
		String column = request.getParameter("column"); 
		String searchtext = request.getParameter("searchText");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", column);
		map.put("searchtext", searchtext);
		
		int totalRecord = movieMapper.selectAllMoviesCount(map);
		
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("column", column);
		model.addAttribute("searchtext", searchtext);
	}
	
	
}
