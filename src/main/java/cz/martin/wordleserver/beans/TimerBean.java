package cz.martin.wordleserver.beans;

import cz.martin.wordleserver.services.WordsService;

import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.ejb.Singleton;

@Singleton
@Startup
public class TimerBean {

    @Inject
    private WordsService wordsService;

    @Schedule(hour = "*", minute = "*/5", second = "0", persistent = false)
    private void selectNewWord() {
        wordsService.selectNewWord();
        System.out.println(wordsService.getWord().getWord());
    }
}
