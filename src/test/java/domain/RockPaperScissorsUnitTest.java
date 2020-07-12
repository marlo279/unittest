package domain;

import domain.rules.RockPaperScissors;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RockPaperScissorsUnitTest {

    @ParameterizedTest
    @MethodSource("movePossibilities")
    void verifyMovesAndResults(Move mine, Move theirs, Result expectedResult) {
        Rules game = new RockPaperScissors();
        Result result = game.decideMatch(mine, theirs);
        assertEquals(expectedResult, result);


    }

    private static Stream<Arguments> movePossibilities() {
        return Stream.of(

                Arguments.of(Move.PAPER, Move.ROCK, Result.WIN),
                Arguments.of(Move.ROCK, Move.PAPER, Result.LOSE),
                Arguments.of(Move.ROCK, Move.ROCK, Result.DRAW),

                Arguments.of(Move.ROCK, Move.SCISSORS, Result.WIN),
                Arguments.of(Move.SCISSORS, Move.ROCK, Result.LOSE),
                Arguments.of(Move.ROCK, Move.ROCK, Result.DRAW),

                Arguments.of(Move.SCISSORS, Move.PAPER, Result.WIN),
                Arguments.of(Move.PAPER, Move.SCISSORS, Result.LOSE),
                Arguments.of(Move.SCISSORS, Move.SCISSORS, Result.DRAW)
        );
    }


}
