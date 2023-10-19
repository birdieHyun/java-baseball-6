package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class InputView {

    public int[] userInputNumber() {

        String userInput = Console.readLine();
        // TODO: 사용자 입력이 숫자만으로 이루어졌는지 검증
        String[] split = userInput.split("");

        return changeUserInputToInt(split);
    }

    private int[] changeUserInputToInt(String[] userInput) {

        // TODO: 3 자리 숫자만 입력했는지 검증 (userInput.length == 3 인지 검증)
        return Arrays.stream(userInput)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
