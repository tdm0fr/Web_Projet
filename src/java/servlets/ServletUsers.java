package servlets;

import java.io.IOException;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utilisateurs.gestionnaires.GestionnaireUtilisateurs;
import utilisateurs.modeles.Adresse;
import utilisateurs.modeles.Utilisateur;

@WebServlet(name = "ServletUsers", urlPatterns = {"/ServletUsers"})
public class ServletUsers extends HttpServlet {
    @EJB
    private GestionnaireUtilisateurs gestionnaireUtilisateurs;

    

    public void init() {
        System.out.println("Ajout du premier utilisateur");
        Adresse biot = new Adresse("Biot", "06410");
        gestionnaireUtilisateurs.inscription("grinny", "hermant", "grinny", "password", biot);
        
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String page = request.getParameter("p");
        String forwardTo = "";
        String message = "";
        HttpSession session = request.getSession(true);
        
        if (action != null) {
            if (action.equals("authentifier")) {
                Utilisateur u = gestionnaireUtilisateurs.getUserByLogin(request.getParameter("login"));
                if (u != null) {
                    if (u.getPassword().equals(request.getParameter("password"))) {
                        session.setAttribute("login", request.getParameter("login"));
                        session.setAttribute("connecte", true);
                        forwardTo = "index.jsp?action=";
                        message = "Vous êtes maintenant connecté";
                    } else {
                        /*
                         * Cas password incorrect
                         */
                        session.setAttribute("connecte", false);
                        forwardTo = "index.jsp?action=";
                        message = "Mot de passe incorrect";
                    }
                } else {
                    /*
                     * Cas user non existant
                     */
                    session.setAttribute("connecte", false);
                    forwardTo = "index.jsp?action=";
                    message = "Cet utilisateur n'existe pas";
                }
            } else if (action.equals("deconnexion")) {               
                HttpSession Session=request.getSession();
                Session.invalidate();
                forwardTo = "index.jsp?action=";
                message = "";
            } else if (action.equals("listerLesUtilisateurs")) {
                
                if (page != null) {
                    Collection<Utilisateur> liste = gestionnaireUtilisateurs.getUsersbyPage(Integer.parseInt(page));
                    request.setAttribute("listeDesUsers", liste);
                    request.setAttribute("totalPages", gestionnaireUtilisateurs.getTotalPages());
                    forwardTo = "index.jsp?action=listerLesUtilisateurs&p=" + page;
                    message = "Liste des utilisateurs";
                    
                } else if (action.equals("listerUtilisateursParVille")) {
                    // on récupère le paramètre idVille  
                    int idVille = Integer.parseInt(request.getParameter("idVille"));

                    // On récupère la liste des utilisateurs pour la ville  
                    Collection<Utilisateur> liste = gestionnaireUtilisateurs.getUsersParVille(idVille);

                    // et on passe le résultat à la JSP pour affichage...  
                    request.setAttribute("listeDesUsers", liste);
                    forwardTo = "index.jsp?action=listerLesUtilisateurs";
                    message = "Liste des utilisateurs pour la ville No : " + idVille;
                    
                } else {
                    Collection<Utilisateur> liste = gestionnaireUtilisateurs.getUsersbyPage(1);
                    request.setAttribute("listeDesUsers", liste);
                    request.setAttribute("totalPages", gestionnaireUtilisateurs.getTotalPages());
                    forwardTo = "index.jsp?action=listerLesUtilisateurs&p=1";
                    message = "Liste des utilisateurs";
                }
                
            } else if (action.equals("creerUtilisateursDeTest")) {
                gestionnaireUtilisateurs.creerUtilisateursDeTest();
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getUsersbyPage(1);
                request.setAttribute("listeDesUsers", liste);
                request.setAttribute("totalPages", gestionnaireUtilisateurs.getTotalPages());
                forwardTo = "index.jsp?action=listerLesUtilisateurs";
                message = "Utilisateurs de test créés";
                
            } else if (action.equals("creerUnUtilisateur")) {
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                Adresse adress = new Adresse(request.getParameter("ville"), request.getParameter("postal"));
                gestionnaireUtilisateurs.inscription(nom, prenom, login, password, adress);
                forwardTo = "index.jsp?action=listerLesUtilisateurs&p=" + request.getParameter("page");
                message = "L'utilisateur de login " + login + " a été créé";
                
            } else if (action.equals("supprimer")) {
                gestionnaireUtilisateurs.deleteUtilisateur(request.getParameter("login"));
                forwardTo = "index.jsp?action=listerLesUtilisateurs&p=" + request.getParameter("page");
                message = "L'utilisateur de login " + request.getParameter("login") + " a été supprimé";
                
            } else if (action.equals("chercherParLogin")) {
                System.out.println("lol");
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.showUsersByLogin(request.getParameter("login"));
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "index.jsp?action=chercherParLogin";
                message = "";
            } 
            else {
                forwardTo = "index.jsp?action=todo";
                message = "La fonctionnalité pour le paramètre " + action + " est à  implémenter !";
            }
            
        }
        request.setAttribute("length", gestionnaireUtilisateurs.getAllUsers().size());
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
        dp.forward(request, response);
    }
    

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
