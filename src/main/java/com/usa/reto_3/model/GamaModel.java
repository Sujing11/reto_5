package com.usa.reto_3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gama")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GamaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gama")
    private int idGama;
    @Column(length = 45)
    private String name;
    @Column(length = 250)
    private String description;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "gama")
    private List<CarModel> cars;
}
