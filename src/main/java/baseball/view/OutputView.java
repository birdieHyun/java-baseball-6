package baseball.view;

public class OutputView {

    private final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

    public void printStartGame() {

        System.out.println(START_GAME);
    }

    public void printInputNumber() {

        System.out.print(INPUT_NUMBER);
    }
}
