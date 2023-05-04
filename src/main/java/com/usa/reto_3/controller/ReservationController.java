package com.usa.reto_3.controller;

import com.usa.reto_3.dbo.ReportClientsDbo;
import com.usa.reto_3.dbo.ReportStatusDbo;
import com.usa.reto_3.dbo.ReservationDbo;
import com.usa.reto_3.model.ReservationModel;
import com.usa.reto_3.service.ReservationService;
import com.usa.reto_3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(value = "*")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public List<ReservationModel> obtener(){
        return reservationService.obtener();
    }

    @GetMapping("/{id}")
    public Optional<ReservationModel> obtenerPorId(@PathVariable int id) {
        return reservationService.obtenerPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ReservationModel reservation){
        reservationService.crear(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody ReservationDbo reservationInput){
        reservationService.actualizar(reservationInput);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        reservationService.eliminar(id);
    }

    @GetMapping("/report-dates/{fechaInicio}/{fechaFin}")
    public List<ReservationModel> reportDates(@PathVariable String fechaInicio, @PathVariable String fechaFin) throws ParseException {
        return reservationService.reportDates(fechaInicio,fechaFin);
    }

    @GetMapping("/report-status")
    public ReportStatusDbo reportStatus(){
        return reservationService.reportStatus();
    }

    @GetMapping("/report-clients")
    public List<ReportClientsDbo> reportClients(){
        return clientService.reportClients();
    }

}
