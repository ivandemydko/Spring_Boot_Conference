package one.servises.managers.parameterManager;


import one.persistence.entity.Address;
import one.persistence.entity.User;
import one.servises.managers.userManager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ParameterManager {
    /**
     * Checks if all items are empty
     */
    @Autowired
   private UserManager um;

    public boolean isAllEmpty(String... parameters) {
        int count = 0;
        for (String p : parameters) {
            if (p == null || p.isEmpty())
                count++;
        }
        return count == parameters.length;
    }

    /**
     * Checks if at list one item is empty
     */
    public boolean isEmpty(String... parameters) {
        for (String p : parameters) {
            if (p == null || p.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean isUserExist(String email) {
        User user = um.getUserByEmail(email);
        return user != null;
    }

    public boolean isEmailCorrect(String email) {
        if (email == null) {
            return false;
        }
        Pattern p = Pattern.compile("([\\w%!#$&'*+-/=?^`{|}~]+)@([\\w-]+\\.)(\\w+)(\\.\\w+)?");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public boolean isPasswordCorrect(String password) {
        if (password == null) {
            return false;
        }
        Pattern p = Pattern.compile("[а-яА-Яa-zA-ZЇїЄєІі[0-9]]{5,}");
        Matcher m = p.matcher(password);
        return m.matches();
    }

    public boolean isAddressCorrect(Address address) {
        int count = 0;
        Pattern pattern;
        Matcher matcher;
        if (address.getCity()!=null) {
            pattern = Pattern.compile("[а-яА-Яa-zA-ZЇїЄєІі]{2,30}");
            matcher = pattern.matcher(address.getCity());
            if (matcher.matches())
                count++;
        } else {
            count++;
        }
        if (address.getStreet()!=null) {
            pattern = Pattern.compile("[а-яА-Яa-zA-ZЇїЄєІі\\-\\s]{2,50}");
            matcher = pattern.matcher(address.getStreet());
            if (matcher.matches())
                count++;
        } else {
            count++;
        }
        if (address.getBuilding()!=null) {
            pattern = Pattern.compile("[а-яА-Яa-zA-ZЇїЄєІі0-9\\s/-]{1,10}");
            matcher = pattern.matcher(address.getBuilding());
            if (matcher.matches())
                count++;
        } else {
            count++;
        }
        if (address.getRoom()!=null) {
            pattern = Pattern.compile("[а-яА-Яa-zA-ZЇїЄєІі0-9]{1,5}");
            matcher = pattern.matcher(address.getRoom());
            if (matcher.matches())
                count++;
        } else {
            count++;
        }
        return count == 4;
    }

    public boolean isNameAndSurnameCorrect(String name, String surname) {
        if (name == null || surname == null) {
            return false;
        }
        Pattern p = Pattern.compile("[а-яА-Яa-zA-ZЇїЄєІі-]{1,50}");
        return p.matcher(name).matches() && p.matcher(surname).matches();
    }

    public boolean isThemeCorrect(String theme) {
        Pattern p = Pattern.compile("([^\\s]{1})((.){0,254})");
        return theme != null && p.matcher(theme).matches();
    }

    public boolean isNumberCorrect(String presence) {
        Pattern p = Pattern.compile("[0-9]+");
        return presence != null && p.matcher(presence).matches();
    }

}

