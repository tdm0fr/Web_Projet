package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utilisateurs.gestionnaires.GestionnaireArtiste;
import utilisateurs.gestionnaires.GestionnaireInstrument;
import utilisateurs.gestionnaires.GestionnaireMusiques;
import utilisateurs.gestionnaires.GestionnaireUtilisateurs;
import utilisateurs.modeles.Adresse;
import utilisateurs.modeles.Artiste;
import utilisateurs.modeles.Instrument;
import utilisateurs.modeles.Musique;
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author naana_on
 */
@WebServlet(name = "ServletArtists", urlPatterns = {"/ServletArtists"})
public class ServletArtists extends HttpServlet {
    @EJB
    private GestionnaireMusiques gestionnaireMusiques;
    @EJB
    private GestionnaireInstrument gestionnaireInstrument;
    @EJB
    private GestionnaireArtiste gestionnaireArtiste;

    

    public void init() {
        System.out.println("Initialisation de la BD");
        parser();
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
        String page = request.getParameter("page");
        String forwardTo = "";
        String message = "";

        if (action != null) {
            if (action.equals("listeMusiques")) {
                Collection<Musique> liste = gestionnaireMusiques.getAllMusics();
                request.setAttribute("listeMusiques", liste);
                forwardTo = "musiques.jsp?action=listeMusiques";
            } else if (action.equals("listeArtistes")) {
                Collection<Artiste> liste = gestionnaireArtiste.getAllArtists();
                request.setAttribute("listeArtistes", liste);
                forwardTo = "musiques.jsp?action=listeArtistes";
            } 
            else if (action.equals("detailsMusique")) {
                int idmusique;
                idmusique = Integer.parseInt(request.getParameter("id"));
                System.out.println(idmusique);
                Collection<Instrument> liste = gestionnaireInstrument.getInstrumentParMusique(idmusique);
//                   System.out.println(liste);
//               request.setAttribute("detailsMusique", liste);
            } 

        }
        request.setAttribute("length", gestionnaireMusiques.getAllMusics().size());
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo);
        dp.forward(request, response);
    }

    public void parser() {
        try {
            InputStream ips = new FileInputStream("/Users/naana_on/Documents/M1/Web/TP2_Web/src/java/servlets/liste.txt");
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne;
            Musique m = null;
            Artiste a = null;
            while ((ligne = br.readLine()) != null) {

                if (ligne.contains(";")) {
                    if (m != null) {
                        gestionnaireMusiques.ajouterMusique(m);
                    }
                    m = new Musique();
                    
                    a = new Artiste();
                    a.setNomArtiste(ligne.substring(0, ligne.length() - 1));
                    m.setArtiste(a);
                    m.setTitre("nom");
                    System.out.println(a);

                } else if (ligne.contains(":")) {
                    m.setTitre(ligne.substring(0, ligne.length() - 1));

                } else if (ligne.contains(".png")) {
                } else if (ligne.contains(".mp3") || ligne.contains(".ogg") || ligne.contains(".mid") || ligne.contains(".mogg")) {
                   System.out.println(ligne.substring(0, ligne.length()));
                   System.out.println(m);
              //      gestionnaireInstrument.ajouterInstrument(m, ligne.substring(0, ligne.length() - 1));
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }

