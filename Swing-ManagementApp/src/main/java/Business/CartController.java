package Business;

import DAO.CartDao;
import DAO.ProductDao;
import Entity.Cart;
import Entity.Product;
import java.util.ArrayList;
import java.util.List;

public class CartController {
    private final CartDao cartDao = new CartDao();
    private final ProductDao productDao = new ProductDao();

    public ArrayList<Cart> findAll() {
        return this.cartDao.findAll();
    }

    public boolean save(Cart cart) {
        int totalPrice = 0;
        List<String> productIDs = new ArrayList<>();


        for (Product product : cart.getProducts()) {
            Product existingProduct = productDao.findById(product.getId());

            if (existingProduct.getStock() > 0) {
                existingProduct.setStock(existingProduct.getStock() - 1);
                productDao.update(existingProduct);

                productIDs.add(product.getId());
                totalPrice += product.getPrice();
            } else {
                System.out.println(" Product is out of stock: " + existingProduct.getName());
                return false;
            }
        }

        cart.setPrice(totalPrice);

        return cartDao.save(cart);
    }
}
