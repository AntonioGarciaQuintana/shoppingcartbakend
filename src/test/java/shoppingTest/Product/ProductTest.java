package shoppingTest.Product;

import com.shopping.application.Application;
import com.shopping.entities.Book;
import com.shopping.entities.Product;
import com.shopping.enums.CateroryEnum;
import com.shopping.services.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertFalse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProductTest {

    @Autowired
    ProductService productService;

    @Test
    public void saveBookTest() {
        Book book = null;
        Product saveProduct = null;
        book  = new Book();
        book.setName("Product Test");
        book.setDescription("Description of product test");
        book.setCategory(CateroryEnum.BOOK);
        book.setPrice(new BigDecimal(1.0));
        book.setStock(10);
        book.setRegisterDate(new Date());
        book.setActive(true);

        book.setIsbn("123-ISBN");
        book.setTitle("title test");
        book.setAuthor("Autor test");

        saveProduct = this.productService.saveProduct(book);
        Assert.assertNotNull(saveProduct);

    }

    @Test
    public void saveOneHundread() {
        List<Book> books = new ArrayList<>();
        boolean thrown = false;
        for (int i =1; i <= 100; i++ ) {
            Book book = new Book();
            book  = new Book();
            book.setName("Product Test");
            book.setDescription("Description of product test");
            book.setCategory(CateroryEnum.BOOK);
            book.setPrice(new BigDecimal(1.0));
            book.setStock(10);
            book.setRegisterDate(new Date());
            book.setActive(true);

            book.setIsbn("123-ISBN");
            book.setTitle("title test");
            book.setAuthor("Autor test");
            books.add(book);
        }

        try{
            this.productService.saveMaziveBooks(books);
        }
        catch (Exception e) {
            thrown = true;
        }
        Assert.assertFalse(thrown);
    }


    @Test
    public void getProductsTest(){
        List<Product> ret = null;
        ret = this.productService.getAllProducts();
        Assert.assertNotNull(ret);
    }


}
