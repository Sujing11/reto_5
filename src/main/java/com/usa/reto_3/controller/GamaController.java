package com.usa.reto_3.controller;

import com.usa.reto_3.model.GamaModel;
import com.usa.reto_3.service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Gama")
@CrossOrigin(value = "*")
public class GamaController {

    @Autowired
    GamaService gamaService;

    @GetMapping("/all")
    public List<GamaModel> obtener(){
        return gamaService.obtener();
    }

    @GetMapping("/{id}")
    public Optional<GamaModel> obtenerPorId(@PathVariable int id) {
        return gamaService.obtenerPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody GamaModel gama){
        gamaService.crear(gama);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody GamaModel gama){
        gamaService.actualizar(gama);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        gamaService. eliminar(id);
    }

}
