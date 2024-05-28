package com.uptctrabajocampo.ecoclickv2.request.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "carga")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Load {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carga")
    private int loadId;
    
    @ManyToOne
    @JoinColumn(name = "material", referencedColumnName = "id_material", nullable = false)
    private Material material;
    
    @ManyToOne
    @JoinColumn(name = "peticion_asociada", referencedColumnName = "id_peticion", nullable = false)
    private Request associatedPetition;
    
    @Column(name = "descripcion", columnDefinition = "MEDIUMTEXT")
    private String description;
    
    @Column(name = "peso_estimado", columnDefinition = "TINYINT")
    private int estimatedWeight;
    
    @Column(name = "altura_estimada", columnDefinition = "TINYINT")
    private int estimatedHeight;
    
    @Column(name = "ancho_estimado", columnDefinition = "TINYINT")
    private int estimatedWidth;
    
    @Column(name = "imagen_ref", length = 100)
    private String referenceImage;


    public Load(Material material, Request associatedPetition, String description, int estimatedWeight, int estimatedHeight, int estimatedWidth, String referenceImage) {
        this.material = material;
        this.associatedPetition = associatedPetition;
        this.description = description;
        this.estimatedWeight = estimatedWeight;
        this.estimatedHeight = estimatedHeight;
        this.estimatedWidth = estimatedWidth;
        this.referenceImage = referenceImage;
    }

    public Load(String description, int estimatedWeight, int estimatedHeight, int estimatedWidth, String referenceImage) {
        this.description = description;
        this.estimatedWeight = estimatedWeight;
        this.estimatedHeight = estimatedHeight;
        this.estimatedWidth = estimatedWidth;
        this.referenceImage = referenceImage;
    }

}