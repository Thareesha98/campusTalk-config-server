package com.example.analytics.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.List;

/**
 * REST Controller for retrieving user activity data and analytics insights.
 * This class is designed to simulate a production data retrieval endpoint 
 * and is self-contained without dependencies on other project files.
 */
@RestController
@RequestMapping("/v1/analytics/user-activity")
public class UserActivityInsightsController {

    /**
     * Data Transfer Object (DTO) for structured weekly activity.
     */
    private record WeeklyActivity(
        LocalDate weekStarting,
        int interactionCount
    ) {}

    /**
     * Data Transfer Object (DTO) for user activity summary and insights.
     */
    private record UserInsights(
        String userId,
        String status,
        Integer totalInteractionsLastYear,
        Integer averageInteractionsPerWeek,
        Integer successfulOutcomes,
        List<WeeklyActivity> activityTrend
    ) {}


    /**
     * Endpoint to get structured activity insights for a specific user ID.
     * The parameter is genericized to 'userId' for realism.
     * * @param userId The identifier for the user (simulated GitHub username).
     * @return A structured UserInsights DTO containing simulated data.
     */
    @GetMapping("/{userId}/insights")
    public UserInsights getUserActivityInsights(@PathVariable String userId) {
        
        // --- Simulated Logic / Data Retrieval ---
        
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
        int successfulOutcomes = 120; // Simulated closed issues/merged PRs

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
