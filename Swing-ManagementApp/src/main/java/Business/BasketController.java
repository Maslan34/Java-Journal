package Business;

import DAO.BasketDao;
import Entity.Basket;
import Entity.Product;
import java.util.ArrayList;


public class BasketController {
    private final BasketDao basketDao = new BasketDao();

    public ArrayList<Product> findBasket(String basketID) {
        return this.basketDao.findBasket(basketID);
    }

    public String save(Basket basket) {
        return this.basketDao.save(basket);
    }

}
