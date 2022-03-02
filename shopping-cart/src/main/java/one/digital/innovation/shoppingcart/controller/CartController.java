package one.digital.innovation.shoppingcart.controller;

import one.digital.innovation.shoppingcart.model.Cart;
import one.digital.innovation.shoppingcart.model.Item;
import one.digital.innovation.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * The type Cart controller.
 */
@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    /**
     * Add item cart.
     *
     * @param id    the id
     * @param items the items
     * @return the cart
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Cart addItem(@PathVariable("id") Integer id, @RequestBody Item items) {
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;
        if (savedCart.equals(Optional.empty())) {
            cart = new Cart(id);
        } else {
            cart = savedCart.get();
        }
        cart.getItems().add(items);
        return cartRepository.save(cart);
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Cart> findById(@PathVariable("id") Integer id) {
        return cartRepository.findById(id);
    }

    /**
     * Clear.
     *
     * @param id the id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void clear(@PathVariable("id") Integer id) {
        cartRepository.deleteById(id);
    }
}
