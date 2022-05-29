    package Users;
    import java.io.File;
    import java.util.ArrayList;

    import static Users.Connexion.key;

    public class Inscription {
    private Utilisateur us;
    private int key;


    private static ArrayList<Utilisateur> Listes_des_personnes_inscrit=new ArrayList<Utilisateur>();
    public Inscription(Utilisateur u/*,int key*/){
        this.us=u;
        //this.key=key;
        Listes_des_personnes_inscrit.add(u);

    }
    public void create_BD_DM(){
        File file = new File("E://JavaProgramm//Messagerie//Chat_SVA//src//BD_DM/" + "DM_" + this.us.getUsername() + ".txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }}
    }
    public static ArrayList<Utilisateur> getListes_des_personnes_inscrit() {
            return Listes_des_personnes_inscrit;
        }


    }


