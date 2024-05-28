package com.uptctrabajocampo.ecoclickv2.route.domain;

import com.uptctrabajocampo.ecoclickv2.organization.domain.Organization;
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
@Table(name = "ruta")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ruta")
    private int routeId;

    @Column(name = "nombre_ruta", length = 80)
    private String routeName;

    @Column(name = "estado", length = 45)
    private String status;

    @Column(name = "identificador_organizacion")
    private int organizationIdentifier;

    @Column(name = "descripcion", columnDefinition = "MEDIUMTEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "organizacion", referencedColumnName = "id_organizacion", foreignKey = @ForeignKey(name = "organizacion_ruta"))
    private Organization organization;

    public Route(String routeName, String status, int organizationIdentifier, String description, Organization organization) {
        this.routeName = routeName;
        this.status = status;
        this.organizationIdentifier = organizationIdentifier;
        this.description = description;
        this.organization = organization;
    }

    public Route(String routeName, String status, int organizationIdentifier, String description) {
        this.routeName = routeName;
        this.status = status;
        this.organizationIdentifier = organizationIdentifier;
        this.description = description;
    }
}