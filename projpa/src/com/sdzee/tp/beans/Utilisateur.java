package com.sdzee.tp.beans;

import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//utilisateur va devenir un EJB
@Entity
public class Utilisateur {

    // les autres c'est pas la peine car ils portent le même nom dans la bdd
    
    // pour lID c la clé primaire et il est autoincremnet
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long      id;
    private String    email;
    @Column( name = "mot_de_passe" )
    private String    motDePasse;
    private String    nom;
    @Column( name = "date_inscription" )
    private Timestamp dateInscription;
    
    

    public Utilisateur() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setMotDePasse( String motDePasse ) {
        this.motDePasse = motDePasse;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public Timestamp getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription( Timestamp dateInscription ) {
        this.dateInscription = dateInscription;
    }
}