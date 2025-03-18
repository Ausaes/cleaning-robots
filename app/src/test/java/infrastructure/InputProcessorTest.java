package infrastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

public class InputProcessorTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    private final Scanner scanner = Mockito.mock(Scanner.class);

    @Test
    public void givenValidInputThenItMovesTheRobot() {
        InputProcessor processor = new InputProcessor(scanner);
        given(scanner.nextInt()).willReturn(
                5, 5
        );
        given(scanner.nextLine()).willReturn("", "1 2 N", "M", "");
        processor.process();
        assertEquals("1 3 N", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void givenValidInputThenItMovesTwoRobots() {
        InputProcessor processor = new InputProcessor(scanner);
        given(scanner.nextInt()).willReturn(
                5, 5
        );
        given(scanner.nextLine()).willReturn("", "1 2 N", "LMLMLMLMM", "3 3 N", "MMRMMRMRRM", "");
        processor.process();
        assertEquals("1 3 N" + System.lineSeparator()  + "5 5 N", outputStreamCaptor.toString().trim());

    }
}
