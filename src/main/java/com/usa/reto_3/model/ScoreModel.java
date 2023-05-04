package com.usa.reto_3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "score")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_score")
    private int idScore;
    @Column(name = "vvalue")
    private Float value;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_reservation", unique = true, nullable = false)
    private ReservationModel reservation;

}
