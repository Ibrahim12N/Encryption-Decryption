package encryptdecrypt;

public class EncrypterDecrypter {
    private EncDecMethod algorithm;

    public void setAlgorithm(EncDecMethod algorithm) {
        this.algorithm = algorithm;
    }
    public String encDec(String type,String text, int shift){
        return this.algorithm.encDec(type,text,shift);
    }
}
