package harryPotter;

import java.util.List;

public record Question(int id, String text, List<Answer> answersList) {
}
