package com.bar.demo2.bins;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.persistence.GenerationType;

import java.util.List;

@Entity
@Table(name = "authors")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 40)
    private String name;

    @OneToMany
    private List<Books> booksList;
}
