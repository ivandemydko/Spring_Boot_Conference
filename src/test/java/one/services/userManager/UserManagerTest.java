package one.services.userManager;

import one.persistence.entity.Report;
import one.persistence.entity.User;
import one.persistence.repositories.ReportRepository;
import one.persistence.repositories.UserRepository;
import one.servises.managers.mailManager.MailManager;
import one.servises.managers.userManager.UserManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerTest {
    @Autowired
    private UserManager userManager;
    @MockBean
    UserRepository repository;
    @MockBean
    ReportRepository reportRepo;
    @MockBean
    MailManager mailManager;
    private final User user = mock(User.class);

    @Test
    public void saveUserTest() {
        when(repository.save(user)).thenReturn(new User());
        User newUser = userManager.saveUser(user);
        Assert.assertNotNull(newUser);
    }

    @Test
    public void registerToConferenceTest() {
        when(reportRepo.findById((long) 3)).thenReturn(Optional.of(new Report()));
        String result = userManager.registerToConference(new User(), (long) 3);
        Assert.assertEquals("success", result);
    }
}
