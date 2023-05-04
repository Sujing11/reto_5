package com.usa.reto_3.service;

import com.usa.reto_3.dbo.ReportStatusDbo;
import com.usa.reto_3.dbo.ReservationDbo;
import com.usa.reto_3.model.ReservationModel;
import com.usa.reto_3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<ReservationModel> obtener(){
        return reservationRepository.findAll();
    }

    public Optional<ReservationModel> obtenerPorId(int id) {
        return reservationRepository. findById(id);
    }

    public void crear(ReservationModel reservation) {
        if (!reservationRepository.existsById(reservation.getIdReservation())) {
            reservationRepository.save(reservation);
        }
    }
    public void actualizar(ReservationDbo reservationInput) {
        Optional<ReservationModel> reservationDb = reservationRepository.findById(reservationInput.getIdReservation());
        if(reservationDb.isPresent()){
            ReservationModel reservation = reservationDb.get();
            if (reservationInput.getStartDate() != null){
                reservation.setStartDate(reservationInput.getStartDate());
            }
            if (reservationInput.getDevolutionDate() != null){
                reservation.setDevolutionDate(reservationInput.getDevolutionDate());
            }
            reservationRepository.save(reservation);
        }
    }
    public void eliminar(int id) {
        reservationRepository.deleteById(id);
    }

    public List<ReservationModel> reportDates(String fechaInicio, String fechaFin) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        Date fechaInicioDate = format.parse(fechaInicio);
        Date fechaFinDate = format.parse(fechaFin);
        if(fechaInicioDate.before(fechaFinDate)){
            return reservationRepository.findByStartDateBetween(fechaInicioDate,fechaFinDate);
        }
        return null;
    }

    public ReportStatusDbo reportStatus() {
        Integer countCompleted = reservationRepository.countByStatus("completed");
        Integer countCancelled = reservationRepository.countByStatus("cancelled");
        return new ReportStatusDbo(countCompleted,countCancelled);
    }

}
