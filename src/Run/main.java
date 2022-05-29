package Run;

import DM.Message;
import InputOutput.IO;
import Pack.Save_in_File;
import Users.Connexion;
import Users.Inscription;
import Users.Utilisateur;
import java.util.ArrayList;
import java.util.Date;

import static Users.Connexion.hs;


public class main {
    private static String Verify_username(){

       String username=IO.setString("Username=");
        if(hs.containsKey(username)){
            System.err.println("Le username Existe déjà dans le système!!!!");
            System.exit(1);
        }
            return username;
         }
         static void menu(){
             System.out.println("1.Se connecter");
             System.out.println("2.S'inscrire");
         }
         static void user_inscrit(Connexion con){
             System.out.print("Utilisateur Inscrit =");
             System.out.println(con.key.size());
             System.out.println("*********************************");

             for (int i = 0; i < con.key.size(); i++) {
                 System.out.println("N°:"+i+"=>"+con.key.get(i));

             }
         }
    public static void main(String[] args) {
        Date date=new Date();
      System.out.println("********************------SVA..CHAT------***********************");
     Connexion us=new Connexion();
     us.read();
     us.separation();
   menu();
   int nbr=IO.setINT("Votre choix= ");
   switch (nbr){
       case 2: {Inscription p= new Inscription(new Utilisateur(IO.setString("Votre Nom="),IO.setString("Votre Prenom="),IO.setINT("Votre age="),IO.setString("Sexe="),
               Verify_username(),IO.setString("Password="))/*, IO.setINT("id=")*/);
               ArrayList<String> m=new ArrayList<String>();
               p.create_BD_DM();
               m.add(Inscription.getListes_des_personnes_inscrit().get(0).getUsername());
               m.add(Inscription.getListes_des_personnes_inscrit().get(0).getPassword());
               new Save_in_File().save(m);
               //new Save_in_File().read();
           break;}
       case 1: {
           Connexion con = new Connexion();
           String name=IO.setString("Username:");
           if (con.connect(name, IO.setString("Password:"))) {
               con.key.clear();
               con.separation();
               System.out.println("*********************************");
               System.out.println("1.Envoyer un message");
               System.out.println("2.Boite de Réception");
               System.out.println("3.Deconnection");
               switch (IO.setINT("Votre Choix :")) {
                   case 1:{
                       user_inscrit(con);
                       int DM_recepteur=IO.setINT("Entrer le numéro du recepteur du message:");
                       String DM_text=IO.setString("Ecrivez le message:\n");
                       Message msg=new Message();
                       msg.envoi_message(DM_text,DM_recepteur,name);
                       break;
                   }

                   case 2:{
                       Message sms=new Message();
                       sms.read_message(name);
                       break;
                   }
                   case 3:
                       System.exit(1);
                       break;
               }
               break;
           }else{
               System.out.println("Echec de la connection");
           }
       }

       }
   }
    }

