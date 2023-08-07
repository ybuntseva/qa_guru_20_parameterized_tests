package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class NavigationTabsTest extends TestBase {

    static Stream<Arguments> navigationTabsTest() {
        return Stream.of(
                Arguments.of("Женщинам", List.of("Идеи", "Новинки", "Одежда", "Обувь", "Аксессуары",
                        "Бренды", "Premium", "Спорт","Resale", "Красота", "Дом", "Sale%")),
                Arguments.of("Мужчинам", List.of("Идеи", "Новинки", "Одежда", "Обувь", "Аксессуары",
                        "Бренды", "Premium", "Спорт","Resale", "Красота", "Дом", "Sale%")),
                Arguments.of("Детям", List.of("Школа", "Новинки", "Девочкам", "Мальчикам",
                        "Малышам", "Бренды", "Premium", "Спорт", "Игрушки", "Дом", "Уход", "Resale", "Sale%"))
        );
    }

    @MethodSource
    @DisplayName("Соответствие разделов выбранным категориям покупателей")
    @ParameterizedTest
    void navigationTabsTest(String tabs, List<String> expectedSubTabs) {
        $$("._root_mexq0_2 a").find(text(tabs)).click();
        $$("._root_1416b_2 a").should(CollectionCondition.texts(expectedSubTabs));
    }
}
