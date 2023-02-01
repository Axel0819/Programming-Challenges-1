public class PasswordGenerator {

    private char[] alphabet;
    private int[] numbers;
    private char [] symbols;
    public PasswordGenerator(){
        alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        numbers = new int[]{0,1,2,3,4,5,6,7,8,9};
        symbols = "!@#$%^&*()_+".toCharArray();
    }
    public String solution(int tam, boolean mayusculas, boolean numeros, boolean simbolos){
        var passw = "";

        for(int i = 1; i <= tam; i++){
            var randomIndex = randomIndex(0, alphabet.length -1);
            passw+= alphabet[randomIndex];
        }
        if(mayusculas) passw = passw.replace(passw.charAt(0), Character.toUpperCase(passw.charAt(0)));
        if (numeros) passw = passw.replace(passw.charAt(passw.length() - 1), Character.forDigit(randomIndex(0,numbers.length -1),10));
        if (simbolos) passw = passw.replace(passw.charAt(2), symbols[randomIndex(0,symbols.length -1)]);

        return passw;
    }

    private int randomIndex(int min, int max){
        return (int)Math.floor(Math.random() * (max - min + 1)+ min);
    }
}
