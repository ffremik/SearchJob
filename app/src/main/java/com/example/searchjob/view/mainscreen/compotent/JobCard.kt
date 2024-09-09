package com.example.searchjob.view.mainscreen.compotent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.model.Vacancy
import com.example.searchjob.R
import com.example.searchjob.style.ButtonText2
import com.example.searchjob.style.Text1
import com.example.searchjob.style.Title2
import com.example.searchjob.style.Title3
import com.example.searchjob.view.login_one_screen.ButtonItem

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 1L
)
fun PreviewJobCard() {
    // JobCard()
}

@Composable
fun JobCard(
    itemVacancy: Vacancy,
    viewVacancy: (Vacancy) -> Unit,
    navigation: () -> Unit,
    onClickFavorites: () -> Unit,
    text: (Int) -> String,
) {

    Column(
        modifier = Modifier
            .padding(top = 16.dp)
            .background(colorResource(id = R.color.special_black))
            .clickable {
                viewVacancy(itemVacancy)
                navigation()
            }
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .weight(0.9f)

            ) {
                if (itemVacancy.lookingNumber != null) {
                    Text1(
                        color = colorResource(id = R.color.special_green),
                        text = "Сейчас просмотривают ${text(itemVacancy.lookingNumber ?: 0)} "
                    )
                }
                Title3(
                    text = itemVacancy.title
                )
                if (itemVacancy.salary.short != null) {
                    Title2(text = "${itemVacancy.salary.short}")
                }
                Text1(
                    text = itemVacancy.address.town
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text1(
                        text = itemVacancy.company
                    )
                    Icon(
                        modifier = Modifier.padding(start = 2.dp),
                        painter = painterResource(id = R.drawable.icon_confirmed),
                        contentDescription = "confirmed"
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.padding(end = 2.dp),
                        painter = painterResource(id = R.drawable.icon_experience),
                        contentDescription = "experience"
                    )
                    Text1(text = itemVacancy.experience.previewText)
                }
                Text1(
                    color = colorResource(id = R.color.basic_grey),
                    text = "Опубликовано ${itemVacancy.publishedDate}"
                )
            }
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.weight(0.1f)
            ) {
                Icon(
                    modifier = Modifier.clickable {
                        onClickFavorites()
                    },
                    painter = if (itemVacancy.isFavorite) painterResource(id = R.drawable.icon_favorites_active)
                    else painterResource(id = R.drawable.icon_favorites),
                    tint = if(itemVacancy.isFavorite) colorResource(id = R.color.special_blue) else LocalContentColor.current,
                    contentDescription = ""
                )
            }
        }
        ButtonItem(
            colorButton = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.special_green)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onClick = {
                /*TODO*/
            }
        ) {
            ButtonText2(
                color = Color.White,
                text = "Откликнуться"
            )
        }

    }
}