package dev.allan.item;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class GameService {

    public Optional<List<Game>> list(){
         List<Game> games = Game.listAll();
         if(games.isEmpty()){
             return Optional.empty();
         }
         return Optional.of(games);
    }
}
