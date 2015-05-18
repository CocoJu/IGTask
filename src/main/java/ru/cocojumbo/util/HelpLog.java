package ru.cocojumbo.util;

/**
 * Created by ANK on 17.05.2015.
 */
public class HelpLog {
    public static void pringToLog(String artifact, Object str){
        System.out.println("-------------------------------------->> " +
             artifact + " : " + str);
    }
}
