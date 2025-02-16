package pl.akademiaqa.modul6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class _10test extends BaseTest {


    @Test
    void checkNamesOfProducts(){
        List<Product> products = getProducts();

        List<String> names = new ArrayList<>();

        products.forEach(p->names.add(p.getName()));
        Assertions.assertThat(names.stream().allMatch(p->p.contains("Printed"))).isTrue();


    }





    private List<Product> getProducts(){

        page.navigate("http://www.automationpractice.pl/index.php?");
        Locator products = page.locator("#block_top_menu");
        products.locator(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dresses"))).click();

        List<Locator> allProducts = page.locator(".product_list .ajax_block_product").all();
        List<Product> productsList = new ArrayList<>();

        allProducts.forEach(p->{
                    Integer price = Integer.valueOf(p.locator(".right-block .price").innerText().replace("$", ""));
                    String name = p.locator(".right-block .product-name").innerText();

        productsList.add(new Product(name, price));
                });
        return productsList;


    }


}
