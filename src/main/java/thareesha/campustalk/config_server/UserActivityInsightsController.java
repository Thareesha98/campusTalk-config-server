package com.example.analytics.service;

import com.example.analytics.api.UserActivityInsightsController;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

/**
 * Service layer component containing the business logic for fetching user activity data.
 * In a real application, this layer would call a Repository or an external API.
 */
@Service
public class UserActivityService {

    // Define the DTO records here or in a separate 'model' package for best practice
    // Keeping them here for the "single class" file output, but using the fully 
    // qualified name in the Controller for true separation.
    public record WeeklyActivity(
        LocalDate weekStarting,
        int interactionCount
    ) {}

    public record UserInsights(
        String userId,
        String status,
        Integer totalInteractionsLastYear,
        Integer averageInteractionsPerWeek,
        Integer successfulOutcomes,
        List<WeeklyActivity> activityTrend
    ) {}

    /**
     * Retrieves structured activity insights for a user ID.
     * This method contains the simulated data generation/retrieval logic.
     * * @param userId The identifier for the user.
     * @return UserInsights DTO.
     */
    public UserInsights fetchInsightsByUserId(String userId) {
        
        // --- Simulated Data Retrieval/Business Logic ---
        
        if ("unknownuser".equalsIgnoreCase(userId)) {
            return new UserInsights(
                userId,
                "error",
                null, null, null,
                List.of()
            );
        }
        
        // Simulated Weekly Data
        List<WeeklyActivity> weeklyTrend = List.of(
            new WeeklyActivity(LocalDate.of(2025, 12, 1), 35),
            new WeeklyActivity(LocalDate.of(2025, 12, 8), 42),
            new WeeklyActivity(LocalDate.of(2025, 12, 15), 58),
            new WeeklyActivity(LocalDate.of(2025, 12, 22), 65)
        );

        // Simulated Summary Statistics
        int totalInteractions = 1540;
        int averageInteractions = 29;
        int successfulOutcomes = 120;

        return new UserInsights(
            userId,
            "success",
            totalInteractions,
            averageInteractions,
            successfulOutcomes,
            weeklyTrend
        );
    }
}
