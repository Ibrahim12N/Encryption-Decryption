package encryptdecrypt;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args)  {
        String type=null;
        String text="";
        String mainText;
        int shift=0;
        String fileIn = null;
        String fileOut = null;
        String algorithm=null;
        for(int i=0;i< args.length;i++){
            switch (args[i]) {
                case "-mode":
                    type = args[i + 1];
                    break;
                case "-data":
                    text = args[i + 1];
                    break;
                case "-key":
                    shift = Integer.parseInt(args[i + 1]);
                    break;
                case "-in":
                    fileIn = args[i + 1];
                    break;
                case "-out":
                    fileOut = args[i + 1];
                    break;
                case "-alg":
                    algorithm = args[i + 1];
                    break;
            }
        }

        String readText=readingFile(fileIn);
        if (text.equals("")){
            mainText=readText;}
        else mainText=text;

EncrypterDecrypter encrypterDecrypter=new EncrypterDecrypter();
        assert algorithm != null;
        if(algorithm.equals("shift")|| algorithm == null)
encrypterDecrypter.setAlgorithm(new ShiftAlgorithm());
else if(algorithm.equals("unicode"))
    encrypterDecrypter.setAlgorithm(new UnicodeAlgorithm());
String output=encrypterDecrypter.encDec(type,mainText,shift);
        writingFile(fileOut, output);
    }

    private static void writingFile(String fileOut, String readText) {
        try (BufferedWriter bw=Files.newBufferedWriter(Paths.get(fileOut))){
            bw.write(readText);
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    private static String readingFile(String fileIn) {
        StringBuilder sb=new StringBuilder();
        try (BufferedReader br=Files.newBufferedReader(Paths.get(fileIn))){
            String intVal;
            while((intVal= br.readLine())!=null){
                sb.append(intVal);}
        } catch (IOException e) {
            System.out.println("error");
        }
        return sb.toString();
    }
}
