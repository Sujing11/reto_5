package com.usa.reto_3.dbo;

import com.usa.reto_3.model.GamaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDbo {

    private Integer idCar;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    private GamaModel gama;

}