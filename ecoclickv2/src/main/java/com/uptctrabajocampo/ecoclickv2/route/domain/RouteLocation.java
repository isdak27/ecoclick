package com.uptctrabajocampo.ecoclickv2.route.domain;

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
@Table(name = "ruta_ubicacion")
public class RouteLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ruta_ubicacion")
    private int routeLocationId;

    @ManyToOne
    @JoinColumn(name = "id_ruta", referencedColumnName = "id_ruta", foreignKey = @ForeignKey(name = "ruta_asignada"))
    private Route route;

    @ManyToOne
    @JoinColumn(name = "id_ubicacion", referencedColumnName = "id_ubicacion", foreignKey = @ForeignKey(name = "ubicacion_asignada"))
    private Location location;

    public RouteLocation(Route route, Location location) {
        this.route = route;
        this.location = location;
    }
}