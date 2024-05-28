package com.uptctrabajocampo.ecoclickv2.drop.domain;

import java.util.Date;
import com.uptctrabajocampo.ecoclickv2.request.domain.Request;
import com.uptctrabajocampo.ecoclickv2.recycler.domain.Recycler;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "entrega")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrega")
    private int deliveryId;

    @ManyToOne
    @JoinColumn(name = "reciclador_asignado", referencedColumnName = "id_reciclador", foreignKey = @ForeignKey(name = "entrega_reciclador"))
    private Recycler assignedRecycler;

    @ManyToOne
    @JoinColumn(name = "peticion_asociada", referencedColumnName = "id_peticion", foreignKey = @ForeignKey(name = "entrega_peticion"))
    private Request associatedRequest;

    @Column(name = "fecha_realizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date executionDate;

    @Column(name = "detalle_entrega", columnDefinition = "MEDIUMTEXT")
    private String deliveryDetails;

    @Column(name = "estado", length = 45)
    private String status;

    @Column(name = "calificacion")
    private int rating;

    @Column(name = "feedback", columnDefinition = "MEDIUMTEXT")
    private String feedback;

    public Delivery(Recycler assignedRecycler, Request associatedRequest, Date executionDate, String deliveryDetails, String status, int rating, String feedback) {
        this.assignedRecycler = assignedRecycler;
        this.associatedRequest = associatedRequest;
        this.executionDate = executionDate;
        this.deliveryDetails = deliveryDetails;
        this.status = status;
        this.rating = rating;
        this.feedback = feedback;
    }
}