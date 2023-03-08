package exercise.domain;

import io.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import io.ebean.annotation.NotNull;
import io.ebeaninternal.server.util.Str;

@Entity
public class Article extends Model {

    @Id
    private long id;

    private String title;

    @Lob
    private String body;

    @ManyToOne
    @NotNull
    private Category category;

    // BEGIN
    public Article(String inputTitle, String inputBody, Category inputCategory) {
        this.title = inputTitle;
        this.body = inputBody;
        this.category = inputCategory;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return body;
    }

    public Category getCategory() {
        return category;
    }

    public long getId() {
        return id;
    }
    // END
}
