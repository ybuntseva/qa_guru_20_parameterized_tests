package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CitySelectionTest extends TestBase {

    @ValueSource(strings = {
            "г. Москва",
            "г. Омск",
            "г. Новосибирск"
    })
    @DisplayName("Проверка возможности выбора города для доставки")
    @ParameterizedTest
    void chooseCityForDeliveryTest(String city) {
        $("._root_32s20_2").click();
        $$("._citiesList_rq1gl_34 a").find(text(city)).click();
        $$("._locationTitle_rq1gl_59").should(CollectionCondition.texts(city));
    }
}
