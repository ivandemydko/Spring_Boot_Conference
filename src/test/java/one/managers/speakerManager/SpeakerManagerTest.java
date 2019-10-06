package one.managers.speakerManager;


import one.persistence.entity.Speaker;
import one.servises.managers.spaekerManager.SpeakerManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpeakerManagerTest {

    private static SpeakerManager speakerManager;

    @Before
    public void init() {
        speakerManager = new SpeakerManager();
    }

    @After
    public void clear() {
        speakerManager = null;
    }

    @Test
    public void setSpeakerBonusesTest() {
        Speaker speaker = new Speaker();
        speaker.setRating(3);
        speaker.setBonuses(0);
        int bonuses = speakerManager.setSpeakerBonuses(100, speaker);
        Assert.assertEquals(130, bonuses);
    }

}
