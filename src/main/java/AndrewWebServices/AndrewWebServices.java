package AndrewWebServices;

/**
 * AndrewWebServices contains the main functionality in our AndrewWS.
 * 
 * DO NOT MODIFY this class.
 */
public class AndrewWebServices {
    Database database;
    RecSys recommender;
    PromoService promoService;

    public AndrewWebServices(Database database2, RecSys recommender, PromoService promoService) {
        this.database = database2;
        this.recommender = recommender;
        this.promoService = promoService;
    }

    public AndrewWebServices(InMemoryDatabase db, Object recommender2, Object promoService2) {
        //TODO Auto-generated constructor stub
    }

    /*
     * Accesses the database to verify the passed account name and password.
     * 
     * Note that the database has a large latency which we don't want to interact with during testing.
     * 
     * TODO: use a fake to test this method
     */
    public boolean logIn(String accountName, String password) {
        long startTime = System.currentTimeMillis();
        if (String.valueOf(this.database.getPassword(accountName)).equals(password)) {
            long endTime = System.currentTimeMillis();
            System.out.println("Login success! Took " + (endTime - startTime) / 1000 + " seconds");
            return true;
        }
        System.out.println("Login failed.");
        return false;
    }

    /*
     * Returns a movie as recommendation to the passed user.
     * 
     * Note that the recommender uses an ultra fancy machine learning algorithm
     * and may take very long to return results.
     * 
     * TODO: use stubs to test this method.
     */
    public String getRecommendation(String accountName) {
        long startTime = System.currentTimeMillis();
        String movie = recommender.getRecommendation(accountName);
        long endTime = System.currentTimeMillis();
        System.out.println("Recommend " + movie + ". Took " + (endTime - startTime) / 1000 + " seconds.");
        return movie;
    }

    /*
     * Sends a promotional email to the given email address using the promoService.
     * 
     * Note that the function has no return value. We want to avoid
     * actually sending emails during testing.
     * 
     * TODO: use mocks to test this method
     */
    public void sendPromoEmail(String email) {
        promoService.mailTo(email);
    }

    // Removed duplicate method logIn(String, String)

    public boolean logIn(String accountName, int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logIn'");
    }
    public interface Database {
        void addUser(String username, String password);
        char[] getPassword(String accountName);
        boolean validateUser(String username, String password);
    }
    
    public interface RecommendationEngine {
        String getRecommendation(String userId);
    }
    
    public interface EmailService {
        void sendPromoEmail(String userId);
    }
    


}
