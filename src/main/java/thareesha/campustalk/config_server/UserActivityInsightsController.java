package com.example.analytics.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

/**
 * Service component containing the business logic for fetching user activity data.
 * This class would typically orchestrate calls to the data access layer (Repository).
 */
@Service
public class UserActivityService {

    // --- Public DTO Records (often placed in a separate 'model' or 'dto' package) ---
    
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
     * * @param userId The identifier for the user.
     * @return UserInsights DTO containing simulated data.
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
