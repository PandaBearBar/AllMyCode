package com.preTest.demo8.bins;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cats")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false,length = 40)
    private String name;
}
