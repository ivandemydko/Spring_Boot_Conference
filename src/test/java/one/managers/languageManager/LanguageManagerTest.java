package one.managers.languageManager;


import one.persistence.entity.Language;
import one.servises.managers.languageManager.LanguageManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LanguageManagerTest {
    private static LanguageManager lm;

    @BeforeClass
    public static void init() {
        lm = new LanguageManager();
    }

    @AfterClass
    public static void clear() {
        lm = null;
    }

    @Test
    public void setLanguageToUserTest() {
        Language lang = new Language();
        lang.setLanguage("ua");
        Language language=lm.setLanguageToUser(lang);
        Assert.assertEquals("UA",language.getLanguage());
    }
}
