package com.usa.reto_3.dbo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDbo {

    private int idClient;
    private String name;
    private String email;
    private String password;
    private Byte age;

}