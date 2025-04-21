package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.ExecutorService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.configuration.SpyAnnotationEngine;

import AndrewWebServices.AndrewWebServices.EmailService;

public class AndrewWebServicesTest {
    InMemoryDatabase database;
    SpyAnnotationEngine recommender;
    EmailService mockEmailService;
    AndrewWebServices andrewWebService;

    @Before
    public void setUp() {
        database = new InMemoryDatabase();
        recommender = new SpyAnnotationEngine();
        mockEmailService = mock(EmailService.class); // mock ашиглаж байна

        andrewWebService = new AndrewWebServices(database, recommender, mockEmailService);
    }

    @Test
    public void testLogIn() {
        // This is taking way too long to test
        assertTrue(andrewWebService.logIn("Scotty", 17214));
    }
    @Test
public void testSendPromoEmailWithMock() {
    // 1. Хуурмаг имэйл сервис үүсгэнэ
    EmailService mockEmailService = mock(EmailService.class);

    // 2. Имэйл илгээнэ (жишээ нь: логик функц дуудах)
    mockEmailService.sendPromoEmail("enkhsaruul@example.com");

    // 3. Тухайн имэйл хаяг руу илгээсэн эсэхийг шалгана
    verify(mockEmailService).sendPromoEmail("enkhsaruul@example.com");
}
    @Test
    public void testGetRecommendation() {
        // This is taking way too long to test
        assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
        // How should we test sendEmail() when it doesn't have a return value?
        // Hint: is there something from Mockito that seems useful here?
    }

    @Test
    public void testNoSendEmail() {
        // How should we test that no email has been sent in certain situations (like right after logging in)?
        // Hint: is there something from Mockito that seems useful here?
    }

    @Test
public void testLogInWithFakeDatabaseAndService() {
    InMemoryDatabase db = new InMemoryDatabase();
    db.addUser("enkhsaruul", "1234");

    AndrewWebServices service = new AndrewWebServices(db, null, null);
    assertTrue(service.logIn("enkhsaruul", "1234"));
    assertFalse(service.logIn("someone", "wrongpass"));
}

@Test
public void testGetRecommendationWithStub() {
    RecommendationEngine stubEngine = new RecommendationEngine() {
        @Override
        public String getRecommendation(String user) {
            if ("premiumUser".equals(user)) {
                return "Try our new Premium features!";
            } else {
                return "Check out our basic features.";
            }
        }
    };

    AndrewWebServices service = new AndrewWebServices(null, stubEngine, null);
    assertEquals("Try our new Premium features!", service.getRecommendation("premiumUser"));
    assertEquals("Check out our basic features.", service.getRecommendation("regularUser"));
}

@Test
public void testSendPromoEmailWithMockExecutorService() {
    ExecutorService mockEmailService = mock(ExecutorService.class);

    AndrewWebServices service = new AndrewWebServices(null, null, mockEmailService);
    service.sendPromoEmail("user123");

    ((AndrewWebServices) verify(mockEmailService)).sendPromoEmail("user123");
}

@Test
public void testLogInWithFakeDatabase() {
    // Хуурамч мэдээллийн сан үүсгэнэ
    InMemoryDatabase fakeDb = new InMemoryDatabase();
    
    // Хэрэглэгч нэмнэ
    fakeDb.addUser("enkhsaruul", "pass123");
    
    // Хэрэглэгчийг зөв мэдээллээр шалгана
    assertTrue(fakeDb.validateUser("enkhsaruul", "pass123"));

    // Буруу нууц үгтэй шалгахад false
    assertFalse(fakeDb.validateUser("enkhsaruul", "wrongpass"));

    // Байхгүй хэрэглэгчийг шалгахад false
    assertFalse(fakeDb.validateUser("someone", "pass123"));
}

}
