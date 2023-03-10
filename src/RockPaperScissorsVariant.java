import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

/*
 * Crea un programa que calcule quien gana mรกs partidas al piedra,
 * papel, tijera, lagarto, spock.
 * - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
 * - La funciรณn recibe un listado que contiene pares, representando cada jugada.
 * - El par puede contener combinaciones de "๐ฟ" (piedra), "๐" (papel),
 *   "โ๏ธ" (tijera), "๐ฆ" (lagarto) o "๐" (spock).
 * - Ejemplo. Entrada: [("๐ฟ","โ๏ธ"), ("โ๏ธ","๐ฟ"), ("๐","โ๏ธ")]. Resultado: "Player 2".
 * - Debes buscar informaciรณn sobre cรณmo se juega con estas 5 posibilidades.
 */
public class RockPaperScissorsVariant {
    private Map<String, List<String>> gameElements;

    public RockPaperScissorsVariant(){
        this.gameElements = Map.ofEntries(
                entry("๐ฟ", Arrays.asList("๐ฆ","โ๏ธ")),
                entry("๐", Arrays.asList("๐ฟ","๐")),
                entry("โ๏ธ", Arrays.asList("๐","๐ฆ")),
                entry("๐ฆ", Arrays.asList("๐","๐")),
                entry("๐", Arrays.asList("โ๏ธ","๐ฟ"))
                );
    }
    public void solution(String[][] gameMove){
        int playerOne = 0, playerTwo = 0;

        for(String[] move : gameMove){
           if(!move[0].equalsIgnoreCase(move[1])){
               if(gameElements.get(move[0]).contains(move[1])) playerOne++;
               else playerTwo++;
           }
        }
        if(playerOne > playerTwo) System.out.println("Player 1");
        else if (playerOne < playerTwo) System.out.println("Player 2");
        else System.out.println("Tie");
    }
}
