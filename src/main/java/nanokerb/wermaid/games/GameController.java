package nanokerb.wermaid.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> getGames(@RequestParam(required = false) String genre) {
        if (genre != null) {

            return new ResponseEntity<>(gameService.getGamesByGenre(genre), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(gameService.getGames(), HttpStatus.OK);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Game>> getGame(@PathVariable String id) {
        return new ResponseEntity<>(gameService.getGame(id), HttpStatus.OK);
    }
}
