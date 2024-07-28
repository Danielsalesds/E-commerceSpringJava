package com.pw24.calcadatebase.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "calca_tbl")
public class Calca {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @DecimalMin(value = "1900")
    String isDeleted;

    @NotBlank(message = "O nome da Calça não pode ser nulo.")
    String calcaName;
    String CalcaSize;
    String genero;
    String imageUri;
    String qtd;
    //regra de negocio para nome da calça
    public void upperCaseCalcaName(){
        calcaName.toUpperCase();
    }

    
}
