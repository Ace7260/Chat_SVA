package DM;
import java.io.*;
import java.util.Date;
import static Users.Connexion.key;
public class Message {
    Date date=new Date();
    public Message() {

    }
    public void envoi_message(String msg,int id_recepteur,String emetteur){
  //  System.out.println(hs.size());//nombre de user inscrit
        Send_message(msg,id_recepteur,emetteur);
    System.out.println("Message Reçu");
}
    public void Send_message(String message,int dest,String emetteur) {
        File file = new File("E://JavaProgramm//Messagerie//Chat_SVA//src//BD_DM/" + "DM_" + key.get(dest) + ".txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else{//con.key.get(i)
            try{
                FileWriter writer=new FileWriter(file,true);
                BufferedWriter bw=new BufferedWriter(writer);
                String[] Parm = new String[] {"username", "password" };
                bw.write("-----------"+date.getDate()+"/"+Integer.parseInt(String.valueOf(date.getMonth()+1))+"/"+"2022 "+"à "+date.getHours()+":"+ date.getMinutes()+":"+date.getSeconds()+"------------");
                bw.write(emetteur);//celui qui envoi
                bw.newLine();
                bw.write(message);
                bw.newLine();
                bw.close();

            }
            catch(IOException e){
                e.printStackTrace();
            }

        }

}
    public void read_message(String message){
        File file = new File("E://JavaProgramm//Messagerie//Chat_SVA//src//BD_DM/" + "DM_" +message+ ".txt");
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
                    System.out.println(line);
                    line=reader.readLine();
                }

                reader.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }

        }}
}
