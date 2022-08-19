package com.odc.FreeTirage.model;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Postulants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPostulants;
    private String nom;
    private String prenom;
    private String numero;
    private String email;


}
