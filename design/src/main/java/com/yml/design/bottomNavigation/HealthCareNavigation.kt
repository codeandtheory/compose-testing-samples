package com.yml.design.bottomNavigation
//TODO https://www.flaticon.com/uicons
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.yml.design.error.TestTag
import com.yml.design.theme.BahamaBlue

/**
 * Reusable Bottom Tab, Can be used from any nav host
 */
@Composable
fun <T : BottomNavDestination> HealthCareBottomNavigation(
    isSelected: (T) -> Boolean,
    items: List<T>,
    navigateTo: (T) -> Unit
) {
    BottomNavigation(
        elevation = 5.dp,// TODO move the dimens to proper classes
        backgroundColor = Color.White,
        contentColor = BahamaBlue,
    ) {
        items.forEach {
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = it.icon()),
                        contentDescription = "" //TODO CDS
                    )
                },
                selected = isSelected(it),
                alwaysShowLabel = false,
                selectedContentColor = BahamaBlue,
                unselectedContentColor = BahamaBlue.copy(alpha = ContentAlpha.disabled),
                onClick = { navigateTo(it)
                    TestTag.ErrorScreenTitle
                }
            )
        }
    }
}

@Composable
internal fun Label(value: String) {
    Text(text = value)
}