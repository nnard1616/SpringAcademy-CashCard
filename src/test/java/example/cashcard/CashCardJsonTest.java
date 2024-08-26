package example.cashcard;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContentAssert;


@JsonTest
class CashCardJsonTest {

    @Autowired
    private JacksonTester<CashCard> json;

    @Test
    void cashCardSerializationTest() throws IOException {
        CashCard cashCard = new CashCard(99L, 123.45);
        JsonContentAssert jsonAssert = assertThat(json.write(cashCard));

        jsonAssert.isStrictlyEqualToJson("expected.json");
        jsonAssert.hasJsonPathNumberValue("@.id");
        jsonAssert.extractingJsonPathNumberValue("@.id")
                .isEqualTo(99);
        jsonAssert.hasJsonPathNumberValue("@.amount");
        jsonAssert.extractingJsonPathNumberValue("@.amount")
                .isEqualTo(123.45);

    }

    @Test
    void cashCardDeserializationTest() throws IOException {
        String expected = """
                {
                "id": "1000",
                "amount": "67.89"
                }""";

        assertThat(json.parse(expected)).isEqualTo(new CashCard(1000L, 67.89));
        assertThat(json.parseObject(expected).id()).isEqualTo(1000);
        assertThat(json.parseObject(expected).amount()).isEqualTo(67.89);
    }

}
