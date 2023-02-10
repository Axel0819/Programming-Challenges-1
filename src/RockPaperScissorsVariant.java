import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

/*
 * Crea un programa que calcule quien gana más partidas al piedra,
 * papel, tijera, lagarto, spock.
 * - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
 * - La función recibe un listado que contiene pares, representando cada jugada.
 * - El par puede contener combinaciones de "🗿" (piedra), "📄" (papel),
 *   "✂️" (tijera), "🦎" (lagarto) o "🖖" (spock).
 * - Ejemplo. Entrada: [("🗿","✂️"), ("✂️","🗿"), ("📄","✂️")]. Resultado: "Player 2".
 * - Debes buscar información sobre cómo se juega con estas 5 posibilidades.
 */
public class RockPaperScissorsVariant {
    private Map<String, List<String>> gameElements;

    public RockPaperScissorsVariant(){
        this.gameElements = Map.ofEntries(
                entry("🗿", Arrays.asList("🦎","✂️")),
                entry("📄", Arrays.asList("🗿","🖖")),
                entry("✂️", Arrays.asList("📄","🦎")),
                entry("🦎", Arrays.asList("🖖","📄")),
                entry("🖖", Arrays.asList("✂️","🗿"))
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
