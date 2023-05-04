package com.usa.reto_3.service;

import com.usa.reto_3.model.GamaModel;
import com.usa.reto_3.repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaService {

    @Autowired
    GamaRepository gamaRepository;

    public List<GamaModel> obtener(){
        return gamaRepository.findAll();
    }

    public Optional<GamaModel> obtenerPorId(int id) {
        return gamaRepository. findById(id);
    }

    public void crear(GamaModel gama){
        if (!gamaRepository.existsById(gama.getIdGama())) {
            gamaRepository.save(gama);
        }
    }

    public void actualizar(GamaModel gama) {
        if( gamaRepository.existsById(gama.getIdGama())) {
            Optional<GamaModel> e= gamaRepository.findById(gama.getIdGama());
            if(e.isPresent()) {
                if(gama.getName()!=null) {
                    e.get().setName(gama.getName());
                }
                if(gama.getDescription()!=null) {
                    e.get().setDescription(gama.getDescription());
                }
                gamaRepository. save(e.get());
            }
        }
    }

    public void eliminar(int id) {
        gamaRepository.deleteById(id);
    }

}
