import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang.RandomStringUtils;

import javax.swing.*;
import java.util.Date;

public class User {

    public String remover (String object){
        object = object.replaceAll("\\s", "");
        object = object.replaceAll(",", "");
        object = object.replaceAll("]", "");
        object = object.replaceAll("\\[", "");
        return object;

    }

    public boolean atChk (String object){
        boolean chk;
        int index = object.indexOf("@");
        if(index < 2){
            chk = false;}
        else chk = true;
        return chk;






    }

    public boolean passCompare (String pass1,String pass2){
        boolean chk;
        if(pass1.equals(pass2)){
            chk = true;
        }else chk = false;

        return chk;


    }

    public boolean passLenchk (String password) {

        int lenchk = password.length();
        boolean chk;
        if(lenchk >=8){

            chk = true;}
        else chk = false;
        return  chk;



    }

    public boolean nameLenChk (String name){

        boolean chk;
        int lenchk = name.length();
        if (lenchk>= 4){
            chk = true;

        }
        else chk = false;

        return chk;
    }

    public Date getDate (){

                java.util.Date date = new java.util.Date();
                return date;

    }



    public static final int ID_LENGTH = 10;

    public String generateUniqueId() {
        return RandomStringUtils.randomAlphanumeric(ID_LENGTH);
    }






}


