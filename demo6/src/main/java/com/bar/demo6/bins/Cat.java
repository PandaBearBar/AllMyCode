package com.bar.demo6.bins;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cats")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false)
    private float weight;

    @OneToMany(cascade = CascadeType.ALL)
    @Singular
    private List<Toy> toys;

}
