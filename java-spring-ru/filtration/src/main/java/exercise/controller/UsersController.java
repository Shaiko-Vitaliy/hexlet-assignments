package exercise.controller;
import exercise.model.User;
import exercise.model.QUser;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping(path = "")
    public Iterable<User> getUserByFirstNameAndLastName(@RequestParam(defaultValue = "") String firstName,
                                                        @RequestParam(defaultValue = "") String lastName) {
        return userRepository.findAll(QUser.user.firstName.containsIgnoreCase(firstName)
                .and(QUser.user.lastName.containsIgnoreCase(lastName)));
    }
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String getUserByFirstNameAndLastName(Model model, @QuerydslPredicate(root = User.class) Predicate predicate, Pageable pageable) {
//        model.addAttribute("users", userRepository.findAll(predicate, (Sort) pageable));
//        return "index";
//    }
    // END
}

