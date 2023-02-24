package harryPotter;

import java.text.MessageFormat;
import java.util.*;

/*
 * Crea un programa que simule el comportamiento del sombrero seleccionador del
 * universo mágico de Harry Potter.
 * - De ser posible realizará 5 preguntas (como mínimo) a través de la terminal.
 * - Cada pregunta tendrá 4 respuestas posibles (también a selecciona una a través de terminal).
 * - En función de las respuestas a las 5 preguntas deberás diseñar un algoritmo que
 *   coloque al alumno en una de las 4 casas de Hogwarts (Gryffindor, Slytherin , Hufflepuff y Ravenclaw)
 * - Ten en cuenta los rasgos de cada casa para hacer las preguntas y crear el algoritmo seleccionador.
 *   Por ejemplo, en Slytherin se premia la ambición y la astucia.
 */
public class SombreroSeleccionador {
    private List<HogwartHouse> hogwartsHouses;
    private List<Question> questionList;
    public SombreroSeleccionador(){
        this.hogwartsHouses = Arrays.asList(
                new HogwartHouse(1,"Gryffindor",0),
                new HogwartHouse(2,"Hufflepuff",0),
                new HogwartHouse(3,"Slytherin",0),
                new HogwartHouse(4,"Ravenclaw",0)
                );
        addQuestions();
    }
    public void solution(){
        int gryffindorCounter = 0, hufflepuffCounter = 0, slytherinCounter = 0, ravenclawCounter = 0;

        for (Question question : questionList) {
            Scanner sc = new Scanner(System.in);
            System.out.println(question.text());
            for (Answer answer: question.answersList()){
                System.out.println(answer.text());
            }
            System.out.println("Select an option:");
            var selectedOption = sc.nextInt();
            System.out.println(MessageFormat.format("Selected option: {0}",selectedOption));
            hogwartsHouses.get(selectedOption -1).setCounter(1);
        }
        var winHouse = hogwartsHouses.stream().max(Comparator.comparing(HogwartHouse::getCounter)).get();
        System.out.println(MessageFormat.format("{0}!",winHouse.getName()));
    }
    public void addQuestions(){
        var answersQuestionOne = Arrays.asList(new Answer(1,"1.Valentía"),new Answer(2,"2.Lealtad"),
                new Answer(3,"3.Astucia"),new Answer(4,"4.Creatividad"));

        var answersQuestionTwo = Arrays.asList(
                new Answer(1,"1.Torre del colegio"),
                new Answer(2,"2.Bodega"),
                new Answer(3,"3.Mazmorras"),
                new Answer(4,"4.En una sala amplia"));

        var answersQuestionThree = Arrays.asList(
                new Answer(1,"1.Defiendes con valentía lo que crees justo sea quien sea"),
                new Answer(2,"2.Defiendes la justicia pero no haces mucho ruido"),
                new Answer(3,"3.Actúas solo si sacas un beneficio propio"),
                new Answer(4,"4.Solo actúas si está involucrado algún amigo o familiar"));

        var answersQuestionFour = Arrays.asList(
                new Answer(1,"1.Gato"),
                new Answer(2,"2.Suricato"),
                new Answer(3,"3.Araña"),
                new Answer(4,"4.Lechuza"));

        var answersQuestionFive = Arrays.asList(
                new Answer(1,"1.Transformaciones"),
                new Answer(2,"2.Herbolistería"),
                new Answer(3,"3.Artes Oscuras"),
                new Answer(4,"4.Adivinación"));

        this.questionList = Arrays.asList(
                new Question(1,"1-¿Qué rasgo te caracteriza más?", answersQuestionOne),
                new Question(2,"2-¿Dónde te gustaría que estuviera tu casa común?", answersQuestionTwo),
                new Question(3,"3-¿Como actúas ante una injusticia?", answersQuestionThree),
                new Question(4,"4-¿Qué eligirias de mascota?", answersQuestionFour),
                new Question(5,"5-¿Qué clase te interesa más?", answersQuestionFive)
        );
    }
}
