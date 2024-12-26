package com.example.movies.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor
public class MovieDto {

    private Long movieId;

    @NotBlank(message = "Please provide movie's title!") //this is came from the validation dependancy. It testes on columns either is null or empty.
    private String title;

    @NotBlank(message = "Please provide movie's director!")
    private String director;

    @NotBlank(message = "Please provide movie's studio!")
    private String studio;

    private Set<String> movieCast;

    private Integer releaseYear; // the difference between "int" and "Integer". "int" is primitive type, which doesn't accept nullable values, so it is automatically initialized to 0. However, "Integer" is a wrapper class, that wrap data as an object. This provides utility methods like parsing, it enables object-oriented features like usage in collections (ArrayList<ObjectType>), and it can store nullable values as well

    @NotBlank(message = "Please provide movie's poster!")
    private String poster;

    @NotBlank(message = "Please provide poster's url!")
    private String posterUrl;
}
