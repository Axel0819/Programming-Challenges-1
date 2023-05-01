import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * Crea 3 funciones, cada una encargada de detectar si una cadena de
 * texto es un heterograma, un isograma o un pangrama.
 * - Debes buscar la definición de cada uno de estos términos.
 */
public class HetoIsoPangrama {
    private int[] base(String text){
        int i;
        int textLength = text.length();
        int[] lettersCounter = new int[256];

        for(i = 0; i < textLength; i++){
            lettersCounter[text.charAt(i)]++;
        }
        return lettersCounter;
    }
    public Boolean isHeterogram(String text){
        int i;
        int[] lettersCounter = base(text);

        return Arrays.stream(lettersCounter).noneMatch(c-> c > 1);
    }
    public Boolean isIsogram(String text){
        int[] lettersCounter  = base(text);
        int[] filterLetterCounter = Arrays.stream(lettersCounter).filter(l-> l != 0).toArray();

        return Arrays.stream(filterLetterCounter).allMatch(l-> l == filterLetterCounter[0]);
    }
    public Boolean isPangram(String text){
        int[] lettersCounter = base(text.toUpperCase());

        var filterLetters = IntStream.range(0,lettersCounter.length)
                .filter(i->(char)i >= 'A' && (char)i <= 'Z').toArray();

        return IntStream.range(0,filterLetters.length)
                .allMatch(i-> lettersCounter[filterLetters[i]] >= 1);
    }
}
