package com.uptctrabajocampo.ecoclickv2.organization.domain;

import java.util.Date;
import com.uptctrabajocampo.ecoclickv2.location.domain.Location;
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
@Table(name = "organizacion")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_organizacion")
    private int organizationId;

    @Column(name = "razon_social", length = 110)
    private String businessName;

    @Column(name = "rues", length = 100)
    private String rues;

    @Column(name = "licencia_ambiental", length = 100)
    private String environmentalLicense;

    @Column(name = "descripcion", columnDefinition = "MEDIUMTEXT")
    private String description;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "correo_electronico", length = 120)
    private String email;

    @Column(name = "correo_alternativo", length = 120)
    private String alternativeEmail;

    @Column(name = "telefono_contacto", length = 80)
    private String contactPhone;

    @Column(name = "telefono_alterno", length = 80)
    private String alternativePhone;

    @ManyToOne
    @JoinColumn(name = "direccion", referencedColumnName = "id_ubicacion", foreignKey = @ForeignKey(name = "direccion_organizacion"))
    private Location address;

    public Organization(String businessName, String rues, String environmentalLicense, String description,
                        Date creationDate, String email, String alternativeEmail, String contactPhone,
                        String alternativePhone, Location address) {
        this.businessName = businessName;
        this.rues = rues;
        this.environmentalLicense = environmentalLicense;
        this.description = description;
        this.creationDate = creationDate;
        this.email = email;
        this.alternativeEmail = alternativeEmail;
        this.contactPhone = contactPhone;
        this.alternativePhone = alternativePhone;
        this.address = address;
    }
}