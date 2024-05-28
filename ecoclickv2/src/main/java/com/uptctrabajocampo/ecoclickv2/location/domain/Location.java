package com.uptctrabajocampo.ecoclickv2.location.domain;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ubicacion")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubicacion")
    private int locationId;

    @Column(name = "id_google_ubicacion")
    private String googleLocationId;

    @Column(name = "direccion")
    private String address;

    @Column(name = "latitud")
    private double latitude;

    @Column(name = "longitud")
    private double longitude;

    @Column(name = "zona")
    private String area;

    @Column(name = "ciudad")
    private String city;

    @Column(name = "codigo_postal")
    private int postalCode;

    @Column(name = "tipo")
    private String type;

    @Column(name = "foto_url")
    private String photoUrl;

    public Location(String googleLocationId, String address, double latitude, double longitude, 
    String area, String city, int postalCode, String type, String photoUrl) {
        this.googleLocationId = googleLocationId;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.area = area;
        this.city = city;
        this.postalCode = postalCode;
        this.type = type;
        this.photoUrl = photoUrl;
    }

}
