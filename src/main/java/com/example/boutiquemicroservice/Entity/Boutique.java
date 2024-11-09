package com.example.boutiquemicroservice.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Boutique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idBoutique ;

    String nom ;

    String adresse ;
    @Enumerated(EnumType.STRING)
    TypeBoutique typeBoutique ;
    @Enumerated(EnumType.STRING)
   Categorie categorie ;
}