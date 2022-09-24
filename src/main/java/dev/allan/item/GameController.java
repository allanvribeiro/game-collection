package dev.allan.item;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/game")
public class GameController {

    @Inject
    GameService gameService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "List all games")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "List of games"),
            @APIResponse(responseCode = "404", description = "No games were found.")
    })
    public List<Game> list(){
        return gameService.list()
                .orElseThrow(() -> new NotFoundException("No games were found."));
    }
}
