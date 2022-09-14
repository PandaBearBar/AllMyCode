package com.bar.demo6.bins;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "toys")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 40)
    private String name;

}
