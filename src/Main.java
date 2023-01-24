public class Main {
    public static void main(String[] args) {
        /*FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.solution();*/

        /*LenguajeHacker lenguajeHacker = new LenguajeHacker();
        System.out.println(lenguajeHacker.solution("Hola 13"));*/

        PartidoTenis partidoTenis = new PartidoTenis();
        String[] gameState = {"P2", "P2", "P1", "P1", "P2", "P1", "P2", "P2"};
        partidoTenis.solution(gameState);
    }
}