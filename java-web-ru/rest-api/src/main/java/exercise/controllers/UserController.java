package exercise.controllers;

import io.javalin.core.validation.BodyValidator;
import io.javalin.http.Context;
import io.javalin.apibuilder.CrudHandler;
import io.ebean.DB;
import java.util.List;

import exercise.domain.User;
import exercise.domain.query.QUser;

import org.apache.commons.validator.routines.EmailValidator;

public class UserController implements CrudHandler {

    public void getAll(Context ctx) {
        // BEGIN
        List<User> users = new QUser()
                .orderBy()
                .id.asc()
                .findList();
        String json = DB.json().toJson(users);
        ctx.json(json);
        // END
    };

    public void getOne(Context ctx, String id) {

        // BEGIN
        User user = new QUser()
                .id.equalTo(Integer.parseInt(id))
                .findOne();
        String json = DB.json().toJson(user);
        ctx.json(json);
        // END
    };

    public void create(Context ctx) {

        // BEGIN
        String body = ctx.body();
        BodyValidator<User> va = ctx.bodyValidator(User.class)
                .check("firstName", obj -> !obj.getFirstName().isEmpty(),"Имя не должно быть пустым")
                .check("lastName",obj -> !obj.getLastName().isEmpty(), "Фамилия не должна быть пустой")
                .check("email", obj -> EmailValidator.getInstance().isValid(obj.getEmail()), "Формат email не верный")
                .check("password", obj -> obj.getPassword().length() >= 4, "Парроль должен содержать более 4 символов");

        if (!va.errors().isEmpty()) {
        ctx.json(va.errors());
        ctx.status(422);
        return;
        }
        User user = DB.json().toBean(User.class, body);
        user.save();
        // END
    };

    public void update(Context ctx, String id) {
        // BEGIN
        String body = ctx.body();
        User user = DB.json().toBean(User.class, body);
        user.setId(id);
        user.update();
        // END
    };

    public void delete(Context ctx, String id) {
        // BEGIN
        new QUser()
                .id.equalTo(Integer.parseInt(id))
                .delete();
        ctx.sessionAttribute("flash", "Статья успешно удалена");
        // END
    };
}
