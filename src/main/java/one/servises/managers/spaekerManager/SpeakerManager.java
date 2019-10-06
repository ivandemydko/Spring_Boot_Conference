package one.servises.managers.spaekerManager;

import one.persistence.data.IUser;
import one.persistence.entity.Speaker;
import one.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * This class is used for execute some logic for {@link Speaker}
 */
@Service
public class SpeakerManager {

    @Autowired
    IUser iUser;

    public int setSpeakerBonuses(int bonuses, Speaker speaker) {
        if (speaker.getRating() == 0) {
            return speaker.getBonuses() + bonuses;
        }
        double result = bonuses + bonuses * (speaker.getRating() / 10.0);
        return speaker.getBonuses() + (int) result;
    }

    public Speaker getSpeakerByEmail(String email) {
        User user = iUser.findUserByEmail(email);
        if (user != null && user.getPosition().getPosition().equals("Speaker"))
            return (Speaker) user;
        return null;
    }

    public void addSpeakerRating(Speaker speaker, int rating) {
        speaker.setRating(rating);
        iUser.saveUser(speaker);
    }

    public User saveSpeaker(Speaker speaker) {
        return iUser.saveUser(speaker);
    }
}
