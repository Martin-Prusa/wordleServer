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
    @Path("resetAt")
    public Response getTime() {
        LocalDateTime t = LocalDateTime.of(wordsService.getWord().getSelectedAt().getYear(), wordsService.getWord().getSelectedAt().getMonth(), wordsService.getWord().getSelectedAt().getDayOfMonth(), wordsService.getWord().getSelectedAt().getHour(), wordsService.getWord().getSelectedAt().getMinute());
        t = t.plusMinutes(5);
        t = t.minusMinutes(t.getMinute() % 5);
        LocalDateTime finalT = t;
        return Response.ok(new HashMap<String, LocalDateTime >() {{put("time", finalT);}}).build();
    }
}
