package com.care.root.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.care.root.dto.SearchMovieDto;

public interface MovieSearchDao {

	@Results(id="searchMovieDto", value={	//spring xml파일에서 설정했던 ResultMap과 같은 역할
		@Result(property="movieId", column="movie_id"),
		@Result(property="movieTitle", column="movie_title"),
		@Result(property="movieDate", column="movie_date"),
		@Result(property="count", column="count")
	})
	@Select("select * from movie_playing")
	public List<SearchMovieDto> getMovies();	//getMovies가 실행되면 위의 명령문이 실행된다
	
	@ResultMap("searchMovieDto")	//results로 지정해놓은 searchMovieDto 값을 가져옴 
	@Select("select * from movie_playing where movie_id = #{movieId}")
	public SearchMovieDto getMovieInfo(String movieID);
}
                              