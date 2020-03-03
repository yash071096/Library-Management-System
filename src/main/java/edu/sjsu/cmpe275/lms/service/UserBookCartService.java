package edu.sjsu.cmpe275.lms.service;

import edu.sjsu.cmpe275.lms.entity.Book;
import edu.sjsu.cmpe275.lms.entity.UserBookCart;
import edu.sjsu.cmpe275.lms.errors.Err;

import java.util.List;

public interface UserBookCartService {

    /**
     * Adds the given book against the user to card
     *
     * @param ubc UserBookCart
     * @return true if add successful, false if failed
     */
    public Err addUserBookToCart(UserBookCart ubc);

    /**
     * To get the cart for a user
     *
     * @param userid int userid
     * @param isTypeReturn
     * @return List of UserBookCart
     */
    public List<UserBookCart> getUserCart(int userid, boolean isTypeReturn);

    /**
     * Clears the books for user from cart
     *
     * @param userid
     * @param isTypeReturn
     */
    void clearUserCart(int userid, boolean isTypeReturn);

    /**
     * @param userId
     * @param isTypeReturn
     * @return
     */
    List<Book> getUserBooks(int userId, boolean isTypeReturn);
}
