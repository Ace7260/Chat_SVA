package Users;

public class Utilisateur extends Personne{
    private String Username,password;
    public Utilisateur(String nom,String Prenom,int age,String sexe,String username,String password){
        super(nom,Prenom,age,sexe);
        this.Username=username;

        this.password=password;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return password;
    }

}
