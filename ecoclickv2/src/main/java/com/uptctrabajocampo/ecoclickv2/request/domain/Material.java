package com.uptctrabajocampo.ecoclickv2.request.domain;

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
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material")
    private int materialId;

    @Column(name = "nombre_material")
    private String materialName;

    @Column(name = "tipo_material")
    private String materialType;

    @Column(name = "recomendacion")
    private String recommendation;

    @Column(name = "procedimiento_recoleccion")
    private String collectionProcedure;

    @Column(name = "instruccion_tratamiento")
    private String treatmentInstruction;

    @Column(name = "imagen_ref")
    private String referenceImage;

    public Material(String materialName, String materialType, String recommendation, String collectionProcedure, String treatmentInstruction, String referenceImage) {
        this.materialName = materialName;
        this.materialType = materialType;
        this.recommendation = recommendation;
        this.collectionProcedure = collectionProcedure;
        this.treatmentInstruction = treatmentInstruction;
        this.referenceImage = referenceImage;
    }
}