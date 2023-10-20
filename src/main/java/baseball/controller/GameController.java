package baseball.controller;

import baseball.service.GameProgress;
import baseball.service.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import java.util.Map;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameProgress gameProgress;
    private final RandomNumberGenerator randomNumberGenerator;

    private static final String STRIKE = "strike";
    private static final String BALL = "ball";

    public GameController(InputView inputView, OutputView outputView,
                          GameProgress gameProgress,
                          RandomNumberGenerator randomNumberGenerator) {

        this.inputView = inputView;
        this.outputView = outputView;
        this.gameProgress = gameProgress;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void startGame() {

        outputView.printStartGame();

        do {
            playSingleRound();
        } while (isContinueGame());
    }

    private void playSingleRound() {

        List<Integer> computerNumbers = generateComputerNumbers();
        Map<String, Integer> compareNumbers = initCompareNumbers();

        while (!gameProgress.isEndGame(compareNumbers)) {
            compareNumbers = playAndCompare(computerNumbers);
        }

        outputView.printDecideGame();
    }

    private List<Integer> generateComputerNumbers() {

        List<Integer> computerNumbers = randomNumberGenerator.generateRandomNumber();
        return computerNumbers;
    }

    private Map<String, Integer> initCompareNumbers() {

        return Map.of(STRIKE, 0, BALL, 0);
    }

    private Map<String, Integer> playAndCompare(List<Integer> computerNumbers) {

        outputView.printInputNumber();
        List<Integer> userInputNumber = inputView.userInputNumber();
        Map<String, Integer> compareNumbers = gameProgress.compareNumbers(computerNumbers, userInputNumber);
        outputView.printGameProgress(compareNumbers.get(STRIKE), compareNumbers.get(BALL));
        return compareNumbers;
    }

    private boolean isContinueGame() {

        outputView.printRestartGame();
        return gameProgress.decideGameRestart(inputView.decideGameActionInput());
    }
}
