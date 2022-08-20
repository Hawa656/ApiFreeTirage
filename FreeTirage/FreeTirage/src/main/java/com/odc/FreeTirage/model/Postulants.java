package com.odc.FreeTirage.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Postulants {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idPostulants;
    private String nom;
    private String prenom;
    private String numero;
    private String email;

    public Postulants(String nom, String prenom, String numero, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.email = email;
    }

  /*  @ManyToMany
    @JoinTable(name = "ListePostulants", joinColumns = { @JoinColumn(name = "id_postulants") }, inverseJoinColumns = {
            @JoinColumn(name = "id_listepostulants") })
    List<ListePostulants> listePostulant = new ArrayList<>();*/


    @ManyToOne
    @JoinColumn(name = "idliste_id_listepostulants")
    private ListePostulants idliste;

}
