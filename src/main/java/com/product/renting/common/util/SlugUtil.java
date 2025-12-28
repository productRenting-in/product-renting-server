package com.product.renting.common.util;

import java.text.Normalizer;
import java.util.Locale;

public final class SlugUtil {

    private SlugUtil() {
    }

    public static String generateSlug(String input) {
        if (input == null || input.isBlank()) {
            return null;
        }

        // 1. Handle camelCase -> camel-Case
        String slug = input.replaceAll("([a-z])([A-Z])", "$1-$2");

        // 2. Normalize accents (é → e)
        slug = Normalizer.normalize(slug, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        // 3. Replace non-alphanumeric with hyphen
        slug = slug.replaceAll("[^a-zA-Z0-9]+", "-");

        // 4. Remove leading/trailing hyphens
        slug = slug.replaceAll("(^-+|-+$)", "");

        // 5. Lowercase
        return slug.toLowerCase(Locale.ENGLISH);
    }
}
