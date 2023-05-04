package com.usa.reto_3.repository;

import com.usa.reto_3.model.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationModel, Integer> {

    //@Query(value = "SELECT * FROM reto5.reservation where start_date BETWEEN ? and ?",nativeQuery = true)
    List<ReservationModel> findByStartDateBetween(Date fechaInicio, Date fechaFin);

    //@Query(value = "SELECT count(*) FROM reto5g33.reservation where status = ?",nativeQuery = true)
    Integer countByStatus(String status);

}
