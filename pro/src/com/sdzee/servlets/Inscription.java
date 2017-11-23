package com.sdzee.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.beans.GererInformation;

/**
 * Servlet implementation class Inscription
 */
@WebServlet( "/inscription" )
public class Inscription extends HttpServlet {

    private static final long  serialVersionUID = 1L;

    // données de noes formulaire
    public static final String VUE              = "/WEB-INF/inscription.jsp";
    public static final String CHAMP_EMAIL      = "email";
    public static final String CHAMP_PASS       = "motdepasse";
    public static final String CHAMP_CONF       = "confirmation";
    public static final String CHAMP_NOM        = "nom";

    // attributs erreur et resultats qu'on va envoyer a la VUE
    public static final String ATT_ERREURS      = "erreurs";
    public static final String ATT_RESULTAT     = "resultat";

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Traitement des données du formulaire */

        // attribut ou on va stocker nos resultat avant de les envoyer
        String resultat;
        Map<String, String> erreurs = new HashMap<String, String>();

        // instanciation de la classe gererInfo
        GererInformation gererInfo = new GererInformation();

        /* Récupération des champs du formulaire. */
        String email = request.getParameter( CHAMP_EMAIL );
        String motDePasse = request.getParameter( CHAMP_PASS );
        String confirmation = request.getParameter( CHAMP_CONF );
        String nom = request.getParameter( CHAMP_NOM );

        /* Validation du champ email. */
        try {
            gererInfo.validationEmail( email );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_EMAIL, e.getMessage() );
        }

        /* Validation des champs mot de passe et confirmation. */
        try {
            gererInfo.validationMotsDePasse( motDePasse, confirmation );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_PASS, e.getMessage() );
            erreurs.put( CHAMP_CONF, null );
        }

        /* Validation du champ nom. */
        try {
            gererInfo.validationNom( nom );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_NOM, e.getMessage() );
        }

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }

        /* Stockage du résultat et des messages d'erreur dans l'objet request */
        request.setAttribute( ATT_ERREURS, erreurs );
        request.setAttribute( ATT_RESULTAT, resultat );

        /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

}
