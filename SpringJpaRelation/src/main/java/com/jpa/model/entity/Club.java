package com.jpa.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
                                                                                                                        //club es dueña de la relacion
    @OneToOne(targetEntity = Coach.class, cascade=CascadeType.PERSIST)                                                  //si se crea un club, se va a incluir el coach, si se elimina el club, no elimina al coach.
    @JoinColumn(name="id_coach")
    private Coach coach;

    @OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY, mappedBy = "club")
    private List<Player>players;

    @ManyToOne(targetEntity = FutbolAssociation.class)
    private FutbolAssociation futbolAssociation;

    @ManyToMany(targetEntity = FutbolCompetition.class, fetch = FetchType.LAZY)
    @JoinTable(name = "club_x_competition", joinColumns = @JoinColumn(name="club"), inverseJoinColumns = @JoinColumn(name="competition"))
    private List<FutbolCompetition>futbolCompetitions;
}
