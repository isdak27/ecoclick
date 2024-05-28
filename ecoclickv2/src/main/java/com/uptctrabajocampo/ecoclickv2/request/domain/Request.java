package com.uptctrabajocampo.ecoclickv2.request.domain;

import java.util.Date;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;
import com.uptctrabajocampo.ecoclickv2.user.domain.Client;

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
@Table(name = "peticion")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_peticion")
    private int requestId;

    @ManyToOne
    @JoinColumn(name = "cliente_solicitante", referencedColumnName = "id_cliente")
    private Client requestingClient;

    @ManyToOne
    @JoinColumn(name = "ubicacion", referencedColumnName = "id_ubicacion")
    private Location location;

    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.DATE)
    private Date requestDate;

    @Column(name = "estado", length = 45)
    private String status;

    @Column(name = "imagen_ref", length = 100)
    private String imageReference;

    @Column(name = "detalles", columnDefinition = "MEDIUMTEXT")
    private String details;

    public Request(Client requestingClient, Location location, Date requestDate, String status, String imageReference, String details) {
        this.requestingClient = requestingClient;
        this.location = location;
        this.requestDate = requestDate;
        this.status = status;
        this.imageReference = imageReference;
        this.details = details;
    }

    public Request(Date requestDate, String status, String imageReference, String details) {
        this.requestDate = requestDate;
        this.status = status;
        this.imageReference = imageReference;
        this.details = details;
    }
}