package com.odc.FreeTirage.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PostulantTire {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idPostulants;
    private String nom;
    private String prenom;
    private String numero;
    private String email;

    @ManyToOne
    @JoinColumn(name = "idtirageid")
    private Tirage idtirage;

}
