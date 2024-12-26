package com.example.movies.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @Column(nullable = false, length= 20)
    @NotBlank(message = "Please provide movie's title!") //this is came from the validation dependancy. It testes on columns either is null or empty.
    private String title;

    @Column(nullable = false)
    @NotBlank(message = "Please provide movie's director!")
    private String director;

    @Column(nullable = false)
    @NotBlank(message = "Please provide movie's studio!")
    private String studio;

    @ElementCollection //JPA is designed for relational databases (SQL). So it doesn't accepte a collection within a table's column. As a solution, we create a seperate table for the collection named "movieCast", this table has two columns : "movieId" as a foreign key of the table movie, and "castMember" that store one element of the collection in each row
    private Set<String> movieCast;

    @NotBlank(message = "Please provide movie's release year!")
    private Integer releaseYear; // the difference between "int" and "Integer". "int" is primitive type, which doesn't accept nullable values, so it is automatically initialized to 0. However, "Integer" is a wrapper class, that wrap data as an object. This provides utility methods like parsing, it enables object-oriented features like usage in collections (ArrayList<ObjectType>), and it can store nullable values as well

    @Column(nullable = false, length= 20)
    @NotBlank(message = "Please provide movie's poster!")
    private String poster;
}
