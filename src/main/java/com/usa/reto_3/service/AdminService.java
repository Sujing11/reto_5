package com.usa.reto_3.service;

import com.usa.reto_3.model.AdminModel;
import com.usa.reto_3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public List<AdminModel> obtener(){
        return adminRepository.findAll();
    }

    public Optional<AdminModel> obtenerPorId(int id) {
        return adminRepository. findById(id);
    }

    public void crear(AdminModel admin){
        if (!adminRepository.existsById(admin.getIdAdmin())){
            adminRepository.save(admin);
        }
    }

    public AdminModel actualizar(AdminModel admin) {
        if( adminRepository.existsById(admin.getIdAdmin())) {
            Optional<AdminModel> e= adminRepository.findById(admin.getIdAdmin());
            if(e.isPresent()) {
                if(admin.getName()!=null) {
                    e.get().setName(admin.getName());
                }
                if(admin.getPassword()!=null) {
                    e.get().setPassword(admin.getPassword());
                }
                adminRepository.save(e.get());
                return e.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }

    public void eliminar(int id) {
        adminRepository.deleteById(id);
    }

}
