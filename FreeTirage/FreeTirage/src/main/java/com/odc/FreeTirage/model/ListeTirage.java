package com.odc.FreeTirage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ListeTirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_listeTirage;

    @ManyToOne
    @JoinColumn(name = "Tirage")
    private Tirage Tirage;
/*
    @JsonIgnore
    @OneToMany(mappedBy = "ListeTirage")
    List<PostulantTire> PostulantTire = new ArrayList<>();
*/

}
