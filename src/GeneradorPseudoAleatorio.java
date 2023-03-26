import java.time.LocalTime;

/*
 * Crea un generador de números pseudoaleatorios entre 0 y 100.
 * - No puedes usar ninguna función "random" (o semejante) del lenguaje de programación seleccionado.
 *
 * Es más complicado de lo que parece...
 */
public class GeneradorPseudoAleatorio {

    public void solution(){
        long timestamp = System.currentTimeMillis();
        System.out.println(timestamp % 100);
    }
}
