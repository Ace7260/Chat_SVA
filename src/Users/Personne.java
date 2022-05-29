package Users;


public class Personne {
    private String nom;
    private String Prenom;
    private String sexe;
    private int age;

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Personne(String nom, String Prenom, int age, String sexe){
        this.nom=nom;
        this.Prenom=Prenom;
        this.age=age;
        this.sexe=sexe;

    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
