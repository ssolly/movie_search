package com.care.root.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.care.root.dao.MovieSearchDao;
import com.care.root.dto.SearchMovieDto;
import com.care.root.movieURL.movieURL;

@Service
public class MovieSearchService implements movieURL {

	@Autowired
	MovieSearchDao dao;

	public List<SearchMovieDto> getMovies() {
		List<SearchMovieDto> list = dao.getMovies();
		for (SearchMovieDto dto : list) { // list에 있는 값을 하나씩 꺼내오고 꺼내오는 이유는 주소를 만들어주기 위해서이다
			Link link = Link.of(movieViewUrl + "movieinfo/" + dto.getMovieId());
			dto.add(link.withRel("movie"));
		}
		return list;
	}

	public SearchMovieDto getMovieInfo(String movieId) {
		return dao.getMovieInfo(movieId);
	}

	public Integer getCount(Integer userId) {
		return dao.getCount(userId);
	}

	public void subCount(Map map) {
		dao.subCount(map);
	}

}
