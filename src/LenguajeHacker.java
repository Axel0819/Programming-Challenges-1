import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

/*
 * Escribe un programa que reciba un texto y transforme lenguaje natural a
 * "lenguaje hacker" (conocido realmente como "leet" o "1337"). Este lenguaje
 *  se caracteriza por sustituir caracteres alfanuméricos.
 * - Utiliza esta tabla (https://www.gamehouse.com/blog/leet-speak-cheat-sheet/)
 *   con el alfabeto y los números en "leet".
 *   (Usa la primera opción de cada transformación. Por ejemplo "4" para la "a")
 */
public class LenguajeHacker {
    private Map<Character,String> letters;
    private Map<Character,String> numbers;
    public LenguajeHacker(){
        this.letters = Map.ofEntries(
                entry('a',"4"),
                entry('b',"I3"),
                entry('c',"["),
                entry('d',")"),
                entry('e',"3"),
                entry('f',"|="),
                entry('g',"&"),
                entry('h',"#"),
                entry('i', "1"),
                entry('j',",_|"),
                entry('k',">|"),
                entry('l',"£"),
                entry('m',"^^"),
                entry('n',"^/"),
                entry('o',"0"),
                entry('p',"|*"),
                entry('q',"(_,)"),
                entry('r',"I2"),
                entry('s',"5"),
                entry('t',"7"),
                entry('u',"(_)"),
                entry('v',"'|/"),
                entry('w',"(n)"),
                entry('x',"}{"),
                entry('y',"¥"),
                entry('z',"2")
        );
        this.numbers = Map.ofEntries(
                entry('1',"L"),
                entry('2',"R"),
                entry('3',"E"),
                entry('4',"A"),
                entry('5',"S"),
                entry('6',"b"),
                entry('7',"T"),
                entry('8',"B"),
                entry('9',"g"),
                entry('0',"o")
        );
    }

    public String solution(String lenguajeNatural){
        char[] arrayLetters = lenguajeNatural.toCharArray();
        //System.out.println(arrayLetters[0]);

        //Lambda function
        letters.forEach((k,v)-> {
            for (int i = 0; i < arrayLetters.length; i++){
                if(k.equals(Character.toLowerCase(arrayLetters[i]))) arrayLetters[i] = v.charAt(0);
            }
        });

        numbers.forEach((k,v)-> {
            for (int i = 0; i < arrayLetters.length; i++){
                if(k.equals(Character.toLowerCase(arrayLetters[i]))) arrayLetters[i] = v.charAt(0);
            }
        });

        return String.valueOf(arrayLetters);
    }
}
