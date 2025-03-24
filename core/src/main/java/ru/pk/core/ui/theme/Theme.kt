package ru.pk.core.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import ru.pk.core.ui.theme.AppColors.Pink40
import ru.pk.core.ui.theme.AppColors.Pink80
import ru.pk.core.ui.theme.AppColors.Purple40
import ru.pk.core.ui.theme.AppColors.Purple80
import ru.pk.core.ui.theme.AppColors.PurpleGrey40
import ru.pk.core.ui.theme.AppColors.PurpleGrey80
import ru.pk.core.ui.theme.AppColors.White

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    onPrimary = White,
    secondary = PurpleGrey80,
    onSecondary = White,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    onPrimary = White,
    secondary = PurpleGrey40,
    onSecondary = White,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun MonstersTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

internal val LocalTypography = staticCompositionLocalOf { Typography }
internal val LocalColors = staticCompositionLocalOf { DarkColorScheme }