package Pack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Save_in_File {
    //create file
    Date date=new Date();
    public  Save_in_File(){}
    public void save(ArrayList<String> save){
    File file=new File("E://JavaProgramm//Messagerie//Chat_SVA//src//Users/List_of_User.txt");
                if(!file.exists()){
        try{
            file.createNewFile();}
        catch (Exception e){
            e.printStackTrace();
        }
    }else{
        try{
            FileWriter writer=new FileWriter(file,true);
            BufferedWriter bw=new BufferedWriter(writer);
            String[] Parm = new String[] {"username", "password" };
             bw.write("-----------"+date.getDate()+"/"+Integer.parseInt(String.valueOf(date.getMonth()+1))+"/"+"2022 "+"à "+date.getHours()+":"+ date.getMinutes()+":"+date.getSeconds()+"------------");
            bw.newLine();
            for (int i = 0; i <save.size(); i++) {
                bw.write("&"+save.get(i));
                bw.newLine();
                if(i+1==save.size()){
                   bw.close();}
            }


        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    }



}
