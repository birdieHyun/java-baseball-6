package baseball.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class InputViewTest {

    private InputView inputView;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setup() {
        inputView = new InputView();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @DisplayName("사용자는 세 자리 숫자를 입력해서 int[] 로 반환받을 수 있다.)")
    @Test
    void userThreeNumberInputTest() {
        // given
        String input = "123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        int[] result = inputView.userInputNumber();

        //then
        assertAll(
                () -> assertThat(result).hasSize(3),
                () -> assertThat(result).containsExactly(1, 2, 3)
        );
    }
}
