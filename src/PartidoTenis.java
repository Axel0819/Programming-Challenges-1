import java.util.Map;

import static java.util.Map.entry;

/*
 * Escribe un programa que muestre cómo transcurre un juego de tenis y quién lo ha ganado.
 * El programa recibirá una secuencia formada por "P1" (Player 1) o "P2" (Player 2), según quien
 * gane cada punto del juego.
 *
 * - Las puntuaciones de un juego son "Love" (cero), 15, 30, 40, "Deuce" (empate), ventaja.
 * - Ante la secuencia [P1, P1, P2, P2, P1, P2, P1, P1], el programa mostraría lo siguiente:
 *   15 - Love
 *   30 - Love
 *   30 - 15
 *   30 - 30
 *   40 - 30
 *   Deuce
 *   Ventaja P1
 *   Ha ganado el P1
 * - Si quieres, puedes controlar errores en la entrada de datos.
 * - Consulta las reglas del juego si tienes dudas sobre el sistema de puntos.
 */
public class PartidoTenis {
    private Map<Integer, Object> points;

    public PartidoTenis(){
        this.points = Map.ofEntries(
                entry(0,"Love"),
                entry(1,15),
                entry(2,30),
                entry(3,40));
    }
    public void solution(String[] gameState){
        var pointsPlayerOne = 0;
        var pointsPlayerTwo = 0;
        var breakPointFlag = false;

        for(int i = 0; i < gameState.length; i++){
            if (gameState[i].equalsIgnoreCase("P1")) pointsPlayerOne++;
            else pointsPlayerTwo++;

            if(i >= 3){
                if(pointsPlayerOne == 4 && pointsPlayerTwo < 4 && !breakPointFlag){
                    System.out.println("Ha ganado el P1");
                    return;
                } else if (pointsPlayerTwo == 4 && pointsPlayerOne < 4 && !breakPointFlag) {
                    System.out.println("Ha ganado el P2");
                    return;
                } else if (pointsPlayerOne == 3 && pointsPlayerTwo == 3) {
                    breakPointFlag = true;
                    System.out.println("Deuce");
                } else if (breakPointFlag) {
                    breakPointSolution(pointsPlayerOne,pointsPlayerTwo);
                    return;
                } else System.out.println("P1: "+points.get(pointsPlayerOne)+" - P2: "+points.get(pointsPlayerTwo));
            }else{
                System.out.println("P1: "+points.get(pointsPlayerOne)+" - P2: "+points.get(pointsPlayerTwo));
            }
        }
    }

    private void breakPointSolution(int pointsPlayerOne, int pointsPlayerTwo){
        if(pointsPlayerOne - pointsPlayerTwo == 1){
            System.out.println("Ventaja P1");
            System.out.println("Ha ganado el P1");
        }else {
            System.out.println("Ventaja P2");
            System.out.println("Ha ganado el P2");
        }
    }
}
