package cz.noxtr.edu.cypher.shift;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CaesarCypherTest {

    private static final Integer SHIFT_COUNT = 3;
    private CaesarCypher caesarCypher;

    @BeforeEach
    void setUp() {
        caesarCypher = new CaesarCypher();
    }

    @CsvSource({
            "asx,DVA",
            "Bty,EWB"
    })
    @ParameterizedTest
    void encode(String plainText, String expectedCypher) {
        String cypher = caesarCypher.encode(plainText, SHIFT_COUNT.toString());
        assertThat(cypher)
                .isEqualTo(expectedCypher);
    }

    @CsvSource({
            "DVA,ASX",
            "EWB,BTY"
    })
    @ParameterizedTest
    void decode(String cypherText, String expectedPlainText) {
        String cypher = caesarCypher.decode(cypherText, SHIFT_COUNT.toString());
        assertThat(cypher)
                .isEqualTo(expectedPlainText);
    }
}
