package domain.models;

/*
 * This is my domain object
 */
public class Campaign {
    private final String id;
    private final String storeId;
    private final Long dailyBudget;

    public Campaign(String id, String storeId, Long dailyBudget) {
        this.id = id;
        this.storeId = storeId;
        this.dailyBudget = dailyBudget;
    }
}
