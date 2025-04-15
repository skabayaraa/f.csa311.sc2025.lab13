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
public void testLogInWithFakeDatabase() {
    InMemoryDatabase db = new InMemoryDatabase();
    db.addUser("enkhsaruul", "1234");

    AndrewWebServices service = new AndrewWebServices(db, null, null);
    assertTrue(service.logIn("enkhsaruul", "1234"));
    assertFalse(service.logIn("someone", "wrongpass"));
}

@Test
public void testGetRecommendationWithStub() {
    RecommendationEngine stubEngine = new RecommendationEngine();

    AndrewWebServices service = new AndrewWebServices(null, stubEngine, null);
    assertEquals("Try our new Premium features!", service.getRecommendation("premiumUser"));
    assertEquals("Check out our basic features.", service.getRecommendation("regularUser"));
}

@Test
public void testSendPromoEmailWithMock() {
    ExecutorService mockEmailService = mock(ExecutorService.class);

    AndrewWebServices service = new AndrewWebServices(null, null, mockEmailService);
    service.sendPromoEmail("user123");

    ((AndrewWebServices) verify(mockEmailService)).sendPromoEmail("user123");
}

}
