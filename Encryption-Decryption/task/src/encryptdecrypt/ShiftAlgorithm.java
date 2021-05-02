package encryptdecrypt;

public class ShiftAlgorithm implements EncDecMethod {

    static String smallLetters="abcdefghijklmnopqrstuvwxyz";
    static String capitalLetters="ABCDEFGHIGKLMNOPQRSTUVWXYZ";
    private String enc(String text, int shift) {
        StringBuilder encText=new StringBuilder();

        for(int i=0;i<text.length();i++){
            if(!smallLetters.contains(text.charAt(i)+"")&&!capitalLetters.contains(text.charAt(i)+""))
                encText.append(text.charAt(i));
            for(int j=0;j<smallLetters.length();j++) {
                if (text.charAt(i) == smallLetters.charAt(j)){
                    if(j+shift>(smallLetters.length()-1))
                    encText.append(smallLetters.charAt(j+shift-(smallLetters.length())));
                    else
                    encText.append(smallLetters.charAt(j+shift));

                } else if(text.charAt(i) == capitalLetters.charAt(j)){
                    if(j+shift>(capitalLetters.length()-1))
                        encText.append(capitalLetters.charAt(j+shift-(capitalLetters.length())));
                    else
                        encText.append(capitalLetters.charAt(j+shift));

                }


            }
        }
        return encText.toString();
    }
    private String dec(String text, int shift) {
        StringBuilder decText=new StringBuilder();
        for(int i=0;i<text.length();i++){
            if(!smallLetters.contains(text.charAt(i)+"")&&!capitalLetters.contains(text.charAt(i)+""))
                decText.append(text.charAt(i));
            for(int j=0;j<smallLetters.length();j++) {
                if (text.charAt(i) == smallLetters.charAt(j)){
                    if(j-shift<0)
                        decText.append(smallLetters.charAt(j-shift+(smallLetters.length())));
                    else
                        decText.append(smallLetters.charAt(j-shift));

                } else if(text.charAt(i) == capitalLetters.charAt(j)){
                    if(j-shift<0)
                        decText.append(capitalLetters.charAt(j-shift+(capitalLetters.length())));
                    else
                        decText.append(capitalLetters.charAt(j-shift));
                }
            }
        }
        return decText.toString();
    }

    @Override
    public String encDec(String type, String text, int shift) {
    switch (type){
        case "enc":
            return enc(text,shift);
        case "dec":
            return dec(text,shift);
        default:
            return enc(text,shift);
    }
    }
}
