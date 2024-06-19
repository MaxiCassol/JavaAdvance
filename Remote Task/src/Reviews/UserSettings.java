package Reviews;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// UserPreferences Source
enum Source {
    DB,
    CONTEXT,
    DEFAULT
}

public class UserSettings {
    public static record UserPreferences(boolean lightMode, boolean cookiesEnabled, Instant creationDate,
                                         List<String> preferredTags) {
    }

    private static final Pattern DB_RESPONSE_PATTERN = Pattern
            .compile("^incomplete data:\\[cookies: (yes|no), light: (yes|no), creation: unknown\\]$");

    static Map.Entry<Source, UserPreferences> currentPreferences() {
        // Try to get the user preferences from the DB, retrying up to 3 times
        for (int tries = 0; tries < 3; tries++) {
            // Get the current user preferences from the DB if possible
            try {
                return new SimpleEntry<>(Source.DB, currentPreferencesFromDB());
            } catch (RuntimeException e) {
                // Try to recover the data from the error message
                Matcher matcher = DB_RESPONSE_PATTERN.matcher(e.getMessage());
                if (matcher.matches()) {
                    return new SimpleEntry<>(Source.DB,
                            new UserPreferences("yes".equals(matcher.group(1)), "yes".equals(matcher.group(2)), Instant.now(),
                                    List.of("movies", "books", "games")));
                }
                // Log the error message if it's the third try
                if (tries == 2) {
                    NotificationSystem
                            .ManagedLog("There was an error while fetching the user preferences from the DB, the error message was: "
                                    + e.getMessage());
                }
            }
        }

        // Get the current user preferences from the context if possible
        try {
            return new SimpleEntry<>(Source.CONTEXT, defaultPreferencesFromContext());
        } catch (RuntimeException e) {
            NotificationSystem.ManagedLog(
                    "There was an error while obtaining the user preferences from the context, the error message was: "
                            + e.getMessage());
        }

        // Return the default preferences
        return new SimpleEntry<>(Source.DEFAULT, defaultPreferences());
    }

    static UserPreferences currentPreferencesFromDB() {
        // This is a placeholder for the actual implementation, replace with your own logic
        throw new RuntimeException("Not implemented, implement currentPreferencesFromDB.");
    }

    static UserPreferences defaultPreferencesFromContext() {
        // This is a placeholder for the actual implementation, replace with your own logic
        throw new RuntimeException("Not implemented, implement defaultPreferencesFromContext.");
    }

    static UserPreferences defaultPreferences() {
        return new UserPreferences(true, false, Instant.now(), List.of("movies", "books", "games"));
    }

    public static void main(String[] args) {
        var preferencesAndSource = (UserSettings.currentPreferences());

        var source = preferencesAndSource.getKey();
        var preferences = preferencesAndSource.getValue();

        System.out.println("Source: " + source);
        System.out.println("User preferences: " + preferences);
    }
}

// Example NotificationSystem class
class NotificationSystem {
    public static void ManagedLog(String message) {
        // Implement the logging logic here
    }
}
