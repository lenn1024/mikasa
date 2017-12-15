package ai.lenn.main;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class I18nMain {
    public static void main(String[] args) throws IOException {
        File file = new File("data/fms.txt");
        BufferedReader fmsReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        BufferedReader translationReader = new BufferedReader(new InputStreamReader(new FileInputStream("data/translation.txt")));

        Set<String> fmsSet = new HashSet<>();
        String line;
        while ((line = fmsReader.readLine()) != null){
            if(!line.trim().equals("") && !line.startsWith("#")){
                fmsSet.add(line.trim());
            }
        }

        Set<String> translationSet = new HashSet<>();
        while ((line = translationReader.readLine()) != null){
            if(!line.trim().equals("") && !line.startsWith("#")){
                translationSet.add(line.trim());
            }
        }

        Set<String> result = new HashSet<>();
        Set<String> contain = new HashSet<>();

        for(String text: fmsSet){
            if(translationSet.contains(text)){
                System.out.println("Contain: " + text);
                contain.add(text);
            }else result.add(text);
        }

        System.out.println("Need to translate:");
        result.stream().forEach(str -> System.out.println(str));

        translationReader.close();
        fmsReader.close();
    }
}
