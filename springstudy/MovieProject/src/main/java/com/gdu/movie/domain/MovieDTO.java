package com.gdu.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDTO {
	int no;
	String title;
	String genre;
	String description;
	String star;
}
