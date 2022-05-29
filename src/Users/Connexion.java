package Users;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class Connexion {
    private Inscription ins;
    private Personne prs;
    public Connexion(){}
    public static Hashtable<String,String> hs=new Hashtable<String,String>();
    public static ArrayList<String> key=new ArrayList<>();
    private static ArrayList<String> valeur=new ArrayList<>();
    private static ArrayList<String>key_valeur=new ArrayList<>();
    private  static LinkedList<String>lin=new LinkedList<>();
    public void read(){
        File file=new File("E://JavaProgramm//Messagerie//Chat_SVA//src//Users/List_of_User.txt");
        if(!file.exists()){
            try{
                file.createNewFile();}
            catch (Exception e){
                e.printStackTrace();
            }
        }else{
            try{
                BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
                String line= reader.readLine();

                while (line!=null){
                   // System.out.println(line);
                    if(line.contains("&")){
                       line=line.replaceFirst("&","");
                    key_valeur.add(line);
                 }
                    line=reader.readLine();

                }

                reader.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }

        }}

public void separation(){
      //
    //  read();
    for (int i = 0; i < key_valeur.size(); i++) {
        if(i%2==0){
            key.add(key_valeur.get(i));
         //   System.out.println(key_valeur.get(i));
        }
        if(i%2!=0){
            valeur.add(key_valeur.get(i));
           // System.out.println(key_valeur.get(i));
        }
    }
    for (int i = 0; i < key_valeur.size()/2; i++) {
        hs.put(key.get(i),valeur.get(i));
    }

}
public boolean connect(String username, String Password){
    try{
    if(Connexion.hs.get(username).contentEquals(Password)){
            System.out.println("You have been connected successffuly");

            return true;
        }
    return false;
    }
    catch (NullPointerException e){

        System.out.println("Données saisies Invalides");
        return false;
    }catch (Exception e){
        System.out.println(e.getMessage());
        return false;
    }}

}
