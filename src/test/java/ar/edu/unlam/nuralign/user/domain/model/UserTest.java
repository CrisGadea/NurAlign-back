package ar.edu.unlam.nuralign.user.domain.model;

import ar.edu.unlam.nuralign.utils.enums.Sex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

public class UserTest {

    @Test
    @DisplayName("Should Return The Created User")
    public void testUser() {
        User user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setEmail("john@mail.com");
        user.setPassword("123456");
        user.setBirthdate(new Date());
        user.setSex(Sex.MALE);
        user.setCreatedAt("2021-01-01");
        user.setUpdatedAt("2021-01-01");

        assert user.getId() == 1L;
        assert user.getName().equals("John Doe");
        assert user.getEmail().equals("john@mail.com");
        assert user.getPassword().equals("123456");
        assert user.getBirthdate() != null;
        assert user.getSex().equals(Sex.MALE);
        assert user.getCreatedAt().equals("2021-01-01");
        assert user.getUpdatedAt().equals("2021-01-01");

    }
}
