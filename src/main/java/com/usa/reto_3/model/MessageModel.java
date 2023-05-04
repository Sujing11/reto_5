package com.usa.reto_3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "message")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message")
    private int idMessage;
    @Column(name = "message_text",length = 250)
    private String messageText;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_car")
    @JsonIgnoreProperties({"messages","reservations"})
    private CarModel car;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_client")
    @JsonIgnoreProperties({"messages","reservations"})
    private ClientModel client;

}
