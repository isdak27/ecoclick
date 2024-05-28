package com.uptctrabajocampo.ecoclickv2.drop.domain;

import java.util.Date;
import com.uptctrabajocampo.ecoclickv2.request.domain.Request;
import com.uptctrabajocampo.ecoclickv2.route.domain.Journey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "parada")
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parada")
    private int stopId;

    @ManyToOne
    @JoinColumn(name = "recorrido_asociado", referencedColumnName = "id_recorrido")
    private Journey associatedJourney;

    @ManyToOne
    @JoinColumn(name = "peticion_asociada", referencedColumnName = "id_peticion")
    private Request associatedRequest;

    @Column(name = "fecha_realizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date executionDate;

    @Column(name = "estado", length = 45)
    private String status;

    @Column(name = "calificacion")
    private int rating;

    @Column(name = "detalle_parada", columnDefinition = "MEDIUMTEXT")
    private String stopDetails;

    public Stop(Journey associatedJourney, Request associatedRequest, Date executionDate, String status, int rating, String stopDetails) {
        this.associatedJourney = associatedJourney;
        this.associatedRequest = associatedRequest;
        this.executionDate = executionDate;
        this.status = status;
        this.rating = rating;
        this.stopDetails = stopDetails;
    }
}