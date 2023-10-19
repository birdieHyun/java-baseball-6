package baseball.view;

public class OutputView {

    private final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";
    private final String SPACE = " ";
    private final String THREE_STRIKE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String RESTART_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printStartGame() {

        System.out.println(START_GAME);
    }

    public void printInputNumber() {

        System.out.print(INPUT_NUMBER);
    }

    public void printGameProgress(int strike, int ball) {

        String result = convertResult(strike, ball);

        System.out.println(result);
    }

    public void printDecideGame() {

        System.out.println(THREE_STRIKE);
    }

    public void printRestartGame() {

        System.out.println(RESTART_GAME);
    }

    private String convertResult(int strike, int ball) {
        StringBuilder stringBuilder = new StringBuilder();

        if (ball > 0) {
            stringBuilder.append(ball)
                    .append(BALL)
                    .append(SPACE);
        }
        if (strike > 0) {
            stringBuilder.append(strike)
                    .append(STRIKE);
        }
        if (strike == 0 && ball == 0) {
            stringBuilder.append(NOTHING);
        }

        return stringBuilder.toString();
    }
}
