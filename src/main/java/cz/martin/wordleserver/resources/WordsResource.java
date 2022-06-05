package cz.martin.wordleserver.resources;

import cz.martin.wordleserver.interfaces.IWordsService;
import cz.martin.wordleserver.models.Word;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.HashMap;

@Path("words")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WordsResource {

    @Inject
    private IWordsService wordsService;

    @POST
    public Response getWordStatus(@Valid Word word) {
        return Response.ok().entity(wordsService.getWordStatus(word)).build();
    }

    @GET
    @Path("length")
    public Response getLength() {
        return Response.ok(new HashMap<String, Integer>() {{put("length", wordsService.getWord().getWord().length());}}).build();
    }

    @GET
    @Path("active-word")
    public Response getWord() {
        return Response.ok(wordsService.getWord()).build();
    }

    @GET
    @Path("generatedAt")
    public Response getTime() {
        return Response.ok(new HashMap<String, LocalDateTime >() {{put("time", wordsService.getWord().getSelectedAt());}}).build();
    }
}
