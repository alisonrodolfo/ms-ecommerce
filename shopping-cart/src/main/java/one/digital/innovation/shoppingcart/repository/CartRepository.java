package one.digital.innovation.shoppingcart.repository;

import one.digital.innovation.shoppingcart.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Cart repository.
 */
@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
}
