package com.example.justweather.data.repositories.location

import com.example.justweather.domain.models.LocationAutofillSuggestion

/**
 * A repository that is responsible for managing all location related operations.
 */
interface LocationServicesRepository {
    /**
     * Fetches suggested places for a given [query] and returns an instance of [Result] containing
     * a list of [LocationAutofillSuggestion]'s if the fetch was successful.
     */
    suspend fun fetchSuggestedPlacesForQuery(query: String): Result<List<LocationAutofillSuggestion>>
}