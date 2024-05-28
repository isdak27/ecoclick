package com.uptctrabajocampo.ecoclickv2.route.domain;

import java.util.Date;

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
@Table(name = "recorrido")
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recorrido")
    private int journeyId;

    @ManyToOne
    @JoinColumn(name = "ruta_asignada", referencedColumnName = "id_ruta")
    private Route assignedRoute;

    @Column(name = "fecha_realizacion")
    @Temporal(TemporalType.DATE)
    private Date executionDate;

    @Column(name = "detalles_recorrido", columnDefinition = "MEDIUMTEXT")
    private String journeyDetails;

    public Journey(Route assignedRoute, Date executionDate, String journeyDetails) {
        this.assignedRoute = assignedRoute;
        this.executionDate = executionDate;
        this.journeyDetails = journeyDetails;
    }
}