package com.preTest.demo8.bins;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cats")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false,length = 40)
    private String name;

    private float weight;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST})
   @Singular
    private List<Toy> toys;

}
