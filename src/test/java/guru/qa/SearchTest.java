package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.*;

public class SearchTest extends TestBase {

    @CsvSource(value = {
            "davines, Ничего не нашли по запросу «davines»",
            "rituals, Ничего не нашли по запросу «rituals»"
    })
    @ParameterizedTest(name = "Отображение текста {1} при поиске товара {0}, отсутствующего в каталоге")
    void verifyDisplayedTextForItemsNotInList(String searchQuery, String expectedMessage) {
        $("._input_1su1z_19").setValue(searchQuery).pressEnter();
        $("._main_1jpla_2").should(Condition.text(expectedMessage));
    }
}
