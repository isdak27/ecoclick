package com.uptctrabajocampo.ecoclickv2.recycler.domain;

import java.util.Date;

import org.springframework.lang.NonNull;

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
@Table(name = "reciclador")
public class Recycler {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reciclador")
    private int recyclerId;

    @Column(name = "licencia_ambiental")
    private String environmentalLicense;

    @Column(name = "nombre")
    @NonNull private String firstName;

    @Column(name = "apellido")
    @NonNull private String lastName;

    @Column(name = "tipo_documento")
    @NonNull private String documentType;

    @Column(name = "numero_documento")
    @NonNull private String documentNumber;

    @Column(name = "fecha_nacimiento")
    @NonNull private Date dateOfBirth;

    @Column(name = "numero_contacto")
    @NonNull private String contactNumber;

    @Column(name = "numero_alternativo")
    private String alternativeNumber;

    @Column(name = "correo_electronico")
    @NonNull private String email;

    @Column(name = "correo_alternativo")
    private String alternativeEmail;

    public Recycler(String environmentalLicense, String firstName, String lastName, 
    String documentType, String documentNumber, Date dateOfBirth, String contactNumber, 
    String alternativeNumber, String email, String alternativeEmail) {
        this.environmentalLicense = environmentalLicense;
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.alternativeNumber = alternativeNumber;
        this.email = email;
        this.alternativeEmail = alternativeEmail;
    }

    public Recycler(String firstName, String lastName, 
    String documentType, String documentNumber, Date dateOfBirth, String contactNumber, 
    String alternativeNumber, String email, String alternativeEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.alternativeNumber = alternativeNumber;
        this.email = email;
        this.alternativeEmail = alternativeEmail;
    }

}
