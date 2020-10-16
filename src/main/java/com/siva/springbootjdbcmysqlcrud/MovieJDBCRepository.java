package com.siva.springbootjdbcmysqlcrud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MovieJDBCRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	JdbcTemplate jdbcTemplate;

	class MovieRowmapper implements RowMapper<Movie> {

		@Override
		public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
			Movie movie = new Movie();
			movie.setId(rs.getLong("id"));
			movie.setName(rs.getString("name"));
			movie.setDirector(rs.getString("directedBy"));
			movie.setReleaseDate(rs.getDate("releasedDate"));
			return movie;
		}
	}

	public List<Movie> findAll() {
		
		return jdbcTemplate.query("SELECT * FROM MOVIES", new MovieRowmapper());
	}

	public Movie findById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM MOVIES WHERE ID=?", new Object[] { id },
				new MovieRowmapper());

	}

	public int insert(Movie movie) {
		return jdbcTemplate.update("INSERT INTO MOVIES (name, directedBy, releasedDate) VALUES (?,?,?)",
				new Object[] { movie.getName(), movie.getDirector(), movie.getReleaseDate() });
	}

	public int updateMovie(Movie movie, long id) {
		return jdbcTemplate.update("UPDATE MOVIES SET NAME= ? , DIRECTEDBY = ?, RELEASEDDATE = ? WHERE ID= ?",
				new Object[] { movie.getName(), movie.getDirector(), movie.getReleaseDate(),id });
	}

	public int deleteByid(long id) {
		return jdbcTemplate.update("DELETE FROM MOVIES WHERE ID=?", new Object[] { id });
	}

}
