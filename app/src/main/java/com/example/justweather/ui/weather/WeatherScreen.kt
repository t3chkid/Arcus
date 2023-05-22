package com.example.justweather.ui.weather

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.justweather.domain.models.WeatherDetails
import com.example.justweather.ui.weather.components.WeatherDetailsCard

/**
 * A composable that displays the [WeatherDetails] of a specific location.
 * @param background the background over which the contents of the screen would be layed out.By
 * default, the screen has no background.
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WeatherScreen(
    background: @Composable BoxScope.() -> Unit,
    weatherDetails: WeatherDetails,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        background()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .systemBarsPadding(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.weight(1f)) {
                MainWeatherInfoColumn(
                    modifier = Modifier.align(Alignment.Center),
                    nameOfPlace = weatherDetails.nameOfLocation,
                    weatherInDegrees = weatherDetails.temperature.currentTemp,
                    weatherIconResId = weatherDetails.weatherCondition.currentWeatherConditionIcon,
                    weatherCondition = weatherDetails.weatherCondition.oneWordDescription
                )
            }
            WeatherDetailsCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                weatherDetails = weatherDetails,
                shortWeatherDescription = "Feels like 43 with a 33 change of rain and thunderstorm night.",
                cardColors = CardDefaults.cardColors(containerColor = Color(0xff121212))
            )
        }
    }
}

@Composable
private fun MainWeatherInfoColumn(
    nameOfPlace: String,
    weatherInDegrees: String,
    @DrawableRes weatherIconResId: Int,
    weatherCondition: String,
    modifier: Modifier = Modifier
) {
    val weatherInDegreesSpanStyle = MaterialTheme.typography.titleLarge
        .toSpanStyle().copy(baselineShift = BaselineShift.Superscript)
    val weatherInDegreesText = remember(weatherInDegrees) {
        buildAnnotatedString {
            append(weatherInDegrees)
            withStyle(weatherInDegreesSpanStyle) { append("º") }
        }
    }
    val weatherIcon = ImageVector.vectorResource(id = weatherIconResId)

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.offset(y = 24.dp),
            text = nameOfPlace,
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = weatherInDegreesText,
            style = MaterialTheme.typography.displayLarge.copy(fontSize = 80.sp)
        )
        Row(
            modifier = Modifier.offset(y = (-16).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(32.dp),
                imageVector = weatherIcon,
                contentDescription = null
            )
            Text(text = weatherCondition)
        }
    }
}

