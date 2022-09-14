package com.bar.demo3.bins;

import lombok.*;
import javax.persistence.*;




@Entity
@Table(name = "books")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Books {
    GenerationType generationType;
    @Id
    @GeneratedValue(strategy = G)
    private int id;

    @Column(nullable = false,length = 40)
    private String name;

    @Column(nullable = false)
    private int year;

}