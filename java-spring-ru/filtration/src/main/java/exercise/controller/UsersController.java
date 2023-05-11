package exercise.controller;
import exercise.model.User;
import exercise.model.QUser;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

// Зависимости для самостоятельной работы
 import org.springframework.data.querydsl.binding.QuerydslPredicate;
 import com.querydsl.core.types.Predicate;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    // BEGIN
        //это одно решение
//    @GetMapping(path = "")
//    public Iterable<User> getUserByFirstNameAndLastName(@RequestParam(defaultValue = "") String firstName,
//                                                        @RequestParam(defaultValue = "") String lastName) {
//        return userRepository.findAll(QUser.user.firstName.containsIgnoreCase(firstName)
//                .and(QUser.user.lastName.containsIgnoreCase(lastName)));
//    }
//это второе решение
    @GetMapping(path = "")
     public Iterable<User> getUsers(@QuerydslPredicate(root = User.class) Predicate predicate) {
         return userRepository.findAll(predicate);
     }
    // END
}

