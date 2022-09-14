package com.bar.demo2.bins;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 40)
    private String name;

    @Column(nullable = false)
    private int year;

}
