import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StqaTests {
    @Test
    void shouldAddProduct() {
        open("https://litecart.stqa.ru/ru/");

        ElementsCollection elements = $(byId("box-most-popular")).$$(byClassName("price"));
       SelenideElement element = elements.find(text("$0"));
       element.parent().parent().pressEnter();
       $(byCssSelector(".stock-available")).shouldHave(text("17"));
       $(byXpath("//button[@name='add_cart_product']")).pressEnter().shouldHave(text("1"));
       $(byXpath("//a[@href='https://litecart.stqa.ru/ru/checkout']")).pressEnter();
       $(By.cssSelector("#customer-service-wrapper")).shouldHave(text("Customer Service"));
       $(byName("quantity")).setValue("2").pressEnter();
       $(byXpath("//button[@name='update_cart_item]")).pressEnter().shouldHave(text("//input[@value='2']"));

       //filling in the Customer Details fields
        $(byName("firstname")).setValue("Eduard").pressEnter();
        $(byName("lastname")).setValue("Shaikhulov").pressEnter();
        $(byName("address1")).setValue("Kazan").pressEnter();
        $(byName("address2")).setValue("Mockow").pressEnter();
        $(byName("postcode")).setValue("1234").pressEnter();
        $(byName("city")).setValue("NewYork").pressEnter();
        $(byName("phone")).setValue("89503232237").pressEnter();
        $(byName("phone")).setValue("89503232237").pressEnter();

        //Confirm order
        $(byXpath("//button[@value='Confirm Order']")).pressEnter();
        $(By.xpath("//h1")).shouldHave(text("Your order is successfully completed!")).shouldHave(text("$0"));






    }
}