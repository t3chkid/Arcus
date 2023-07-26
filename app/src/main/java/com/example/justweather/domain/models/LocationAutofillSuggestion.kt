package com.example.justweather.domain.models

/**
 * This is a data class that models an auto-fill suggestion for a location query.
 * @param idOfLocation The id of the location.
 * @param nameOfLocation The name of the location.
 * @param addressOfLocation The address of the location.
 * @param coordinatesOfLocation The [Coordinates] of the location.
 */
data class LocationAutofillSuggestion(
    val idOfLocation: String,
    val nameOfLocation: String,
    val addressOfLocation: String,
    val coordinatesOfLocation: Coordinates
)
