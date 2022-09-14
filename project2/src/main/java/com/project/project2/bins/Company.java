package com.project.project2.bins;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name ="company_id",referencedColumnName = "id",foreignKey = @ForeignKey)
    private List<Coupon>coupons = new ArrayList<>();

}
