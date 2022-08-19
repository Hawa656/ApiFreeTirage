package com.odc.FreeTirage.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
  /*  @JoinTable(name = "ListePostulants_Postulants", joinColumns = { @JoinColumn(name = "idPostulants") }, inverseJoinColumns = {
            @JoinColumn(name = "idListePostulants") })

   */
    private List<ListePostulants> ListePostulants = new ArrayList<>();


}
