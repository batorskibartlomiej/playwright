package pl.akademiaqa.modul6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class _FinalTest extends BaseTest {

    @Test
    void should_verify_all_product_prices_are_above_15_usd() {
        List<Product> products = getProducts();

        List<Integer>prices = new ArrayList<>();
        products.forEach(p-> prices.add(p.getPrices()));

        Assertions.assertThat(prices.stream().allMatch(p->p>15)).isTrue();


    }

    @Test
    void should_verify_all_product_name_contains_printed() {
        List<Product> products = getProducts();

        List<String>names = new ArrayList<>();
        products.forEach(p->names.add(p.getName()));
        Assertions.assertThat(names.stream().allMatch(p->p.contains("printed"))).isTrue();

    }


    private List<Product>getProducts() {
        page.navigate("http://www.automationpractice.pl/index.php");
        Locator topMenuBlock = page.locator("#block_top_menu");
        topMenuBlock.locator(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("DRESSES"))).click();

        List<Product>products= new ArrayList<>();

        List<Locator> productLocator = page.locator(".product_list .ajax_block_product").all();
        productLocator.forEach(p -> {
            Integer price = Integer.valueOf(p.locator(" .right-block .price").innerText().replace("$", ""));
            String names = p.locator(".right-block .product-name").innerText();

        products.add(new Product(names, price));


        });
    return products;

    }

}

