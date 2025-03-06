package nanokerb.wermaid.ratings;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ratings")
public class Rating {
    @Id
    public String id;
    public String userId;
    public String gameId;
    public int rating;
    public String comment;

    public Rating(String gameId, int rating, String comment) {
        this.gameId = gameId;
        this.rating = rating;
        this.comment = comment;
    }
}
