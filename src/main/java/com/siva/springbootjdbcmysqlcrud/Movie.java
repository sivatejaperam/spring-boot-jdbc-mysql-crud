package com.siva.springbootjdbcmysqlcrud;

import java.util.Date;

public class Movie {
	
	private long id;
	private String name;
	private String director;
	private Date releaseDate;
	
	public Movie() {
	
	}

	
	public Movie(String name, String director, Date releaseDate) {
		super();
		
		this.name = name;
		this.director = director;
		this.releaseDate = releaseDate;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", director=" + director + ", releaseDate=" + releaseDate + "]";
	}
	
	
	

}
