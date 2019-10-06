package one.servises.managers.messageManager;

import one.persistence.entity.Language;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class is used for forming messages
 */
@Service
public class MessageManager {
    private Locale locale = new Locale("en", "US");
    private static ResourceBundle resourceBundle;

    public MessageManager() {
        resourceBundle = ResourceBundle.getBundle("messages", locale);
    }

    public String getProperty(String key) {
        return resourceBundle.getString(key);
    }

    public void setLocale(Language lang) {
        String language = lang.getLanguage();
        switch (language) {
            case "UA":
                locale = new Locale("ua", "UA");
                break;
            case "RU":
                locale = new Locale("ru", "RU");
                break;
            default:
                locale = new Locale("en", "US");
        }
        resourceBundle = ResourceBundle.getBundle("messages", locale);
    }

}
