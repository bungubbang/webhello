import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import shop.domain.Product;
import shop.repository.ShopDBRepository;
import shop.repository.ShopRepository;
import shop.service.ShopService;
import shop.service.ShopServiceImpl;

/**
 * Created by bungubbang
 * Email: bungubbang57@gmail.com
 */
public class TestShopDBRepository {

    ShopRepository shopRepository = null;
    ShopService shopService = new ShopServiceImpl();

    @Before
    public void setUp() {
        shopRepository = ShopDBRepository.getInstance();
    }

    @Test
    public void addProduct() {
        Product product = new Product();
        product.setName("토비의 스프링2");
        product.setPrice(500001);
        product.setStock(1002);
        product.setStatus("판매중");

//        shopRepository.addProduct(product);
        shopService.createProduct(product);
    }

    @Test
    public void updateProduct() {
        Product product = new Product();
        product.setId(1);
        product.setName("토비의 스프링2");
        product.setPrice(10000);
        product.setStock(80);
        product.setStatus("판매중");

//        shopRepository.updateProduct(product);
        System.out.println(shopService.findById(1).toString());
    }

}
