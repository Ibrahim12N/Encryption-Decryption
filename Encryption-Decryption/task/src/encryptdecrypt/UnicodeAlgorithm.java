package encryptdecrypt;

public class UnicodeAlgorithm implements EncDecMethod {
    private String dec(String text, int shift) {
        StringBuilder decText=new StringBuilder();
        int c;
        char shiftedChar;
        for(int i=0;i<text.length();i++){
            c=text.charAt(i);
            shiftedChar= (char) (c-shift);
            decText.append(shiftedChar);
        }
        return decText.toString();
    }

    private String enc(String text, int shift) {
        StringBuilder encText=new StringBuilder();
        int c;
        char shiftedChar;
        for(int i=0;i<text.length();i++){
            c=text.charAt(i);
            shiftedChar= (char) (c+shift);
            encText.append(shiftedChar);
        }
        return encText.toString();
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
