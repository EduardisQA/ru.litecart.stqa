import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class StqaTests {
    @Test
    void shouldAddProduct() {
        open("https://litecart.stqa.ru/ru/");

        ElementsCollection elements = $(byId("box-most-popular")).$$(byClassName("price"));
        SelenideElement element = elements.find(exactText("0"));
        element.parent().parent().pressEnter();

        $(byCssSelector(".stock-available")).shouldHave(text("17"));
        $(byXpath("//input[@type='number']")).pressEnter();
        $(byClassName("quantity")).shouldHave(text("1"));
        $(byXpath("//a[@href='https://litecart.stqa.ru/ru/checkout']")).pressEnter();
        $(By.cssSelector("#customer-service-wrapper")).shouldHave(text("Customer Service"));
        $(byXpath("//input[@value='1']")).setValue("2");
        $(byXpath("//button[@name='update_cart_item']")).pressEnter();
        $(byXpath("//td[@style='text-align: center;']")).shouldHave(text("2"));
        $(byXpath("//td[@class='sum']")).shouldHave(text("0"));


        //filling in the Customer Details fields
        $(byName("firstname")).setValue("Eduard").pressEnter();
        $(byName("firstname")).shouldHave(value("Eduard"));
        $(byName("lastname")).setValue("Shaikhulov").pressEnter();
        $(byName("lastname")).shouldHave(value("Shaikhulov"));
        $(byName("address1")).setValue("Kazan").pressEnter();
        $(byName("address1")).shouldHave(value("Kazan"));
        $(byName("address2")).setValue("Mockow").pressEnter();
        $(byName("address2")).shouldHave(value("Mockow"));
        $(byName("postcode")).setValue("402000").pressEnter();
        $(byName("postcode")).shouldHave(value("402000"));
        $(byName("city")).setValue("NewYork").pressEnter();
        $(byName("city")).shouldHave(value("NewYork"));
        $(byName("email")).setValue("shaikhulove@gmail.com").pressEnter();
        $(byName("email")).shouldHave(value("shaikhulove@gmail.com"));
        $(byName("phone")).setValue("89503232237").pressEnter();
        $(byName("phone")).shouldHave(value("89503232237"));


        //Confirm order
        $(byXpath("//button[@value='Confirm Order']")).pressEnter();
        $(By.xpath("//h1")).shouldHave(text("Your order is successfully completed!"));
        $(byXpath("//span[@class='quantity']")).shouldHave(text("0"));

    }

}