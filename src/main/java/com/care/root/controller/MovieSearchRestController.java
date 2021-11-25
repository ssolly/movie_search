package com.care.root.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.care.root.dto.SearchMovieDto;
import com.care.root.service.MovieSearchService;

@RestController
@RequestMapping("search")
@CrossOrigin	//하나의 웹서버에 여러가지가 존재하게 세팅
public class MovieSearchRestController {

	@Autowired MovieSearchService ms;

	/*
	@GetMapping("getMovies")
	public String getMovies() {
		System.out.println("search 연결 되었습니다");
		return "성공";
	}
	*/
	
	@GetMapping("getMovies")
	public List<SearchMovieDto> getMovies() {
		return ms.getMovies();
	}
	
	/*
	@GetMapping("movieinfo/{movieId}")
	public Map<String, Object> movieInfo(@PathVariable String movieId) {
		Map<String, Object> map = new HashMap();
		map.put("result", "success : " + movieId);
		return map;
	}
	*/
	
	@GetMapping("movieinfo/{movieId}")
	public SearchMovieDto movieInfo(@PathVariable String movieId) {
		return ms.getMovieInfo(movieId);
	}
}
