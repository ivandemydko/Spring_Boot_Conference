package one.servises.managers.languageManager;


import one.internationalization.Internationalization;
import one.persistence.data.ILanguage;
import one.persistence.entity.Language;
import one.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Service
public class LanguageManager {
    @Autowired
    ILanguage iLanguage;
    @Autowired
    Internationalization internationalization;

    /**
     * Sets language to {@link User}
     */
    public Language setLanguageToUser(Language language) {
        Language lang = new Language();
        if (language == null) {
            lang.setLanguage("EN");
            return lang;
        } else if (language.getLanguage().equals("ua")) {
            lang.setLanguage("UA");
            return lang;
        } else if (language.getLanguage().equals("ru")) {
            lang.setLanguage("RU");
            return lang;
        } else {
            lang.setLanguage("EN");
            return lang;
        }
    }

    /**
     * Sets language to session
     */
    public void setLanguageToSession(Language language) {
        if (language == null) {
            return;
        }
        Locale locale;
        SessionLocaleResolver localeResolver =
                (SessionLocaleResolver) internationalization.localeResolver();
        String lang = language.getLanguage();
        switch (lang) {
            case "UA":
                locale = new Locale("ua", "UA");
                localeResolver.setDefaultLocale(locale);
                break;
            case "RU":
                locale = new Locale("ru", "RU");
                localeResolver.setDefaultLocale(locale);
                break;
            default:
                localeResolver.setDefaultLocale(Locale.US);
        }
    }

    public Language getLanguage(Locale locale) {
        String language = getStringLanguage(locale);
        System.out.println("one.managers.languageManager = " + language);
        return iLanguage.getLanguage(language);
    }

   private String getStringLanguage(Locale locale) {
        switch (locale.toString()) {
            case "en_US":
            case "en":
                return "EN";
            case "ua":
                return "UA";
            case "ru":
                return "RU";
        }
        return null;
    }
}
