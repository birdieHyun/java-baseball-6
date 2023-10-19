package baseball.validation;

public class GameValidator {

    public void validateIsNumber(String input) {

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public void validateIsThreeNumbers(String input) {

        if (input.length() != 3) {
            throw new IllegalArgumentException("[ERROR] 3자리 숫자만 입력 가능합니다.");
        }
    }

}
