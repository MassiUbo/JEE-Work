package com.octest.tp.dao;

import java.util.List;

import com.sdzee.tp.beans.Utilisateur;

public interface UtilisateurDao {

    void ajouter( Utilisateur utilisateur ) throws DaoException;

    List<Utilisateur> lister() throws DaoException;

}
