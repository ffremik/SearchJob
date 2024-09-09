package com.example.searchjob.view.mainscreen.compotent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.model.Offer
import com.example.searchjob.R
import com.example.searchjob.style.Text1
import com.example.searchjob.style.Title4

val testOffer = Offer(
    title = "Вакансии рядом с вами",
    //  button = Button("тыкни"),
    link = ""
)

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 1L
)
fun PreviewRecommendationItem() {
    RecommendationItem(testOffer)
}

@Composable
fun RecommendationItem(offerItem: Offer) {
    Column(
        modifier = Modifier
            .size(width = 132.dp, height = 120.dp)
            .padding(start = 4.dp, end = 4.dp)
            .background(colorResource(id = R.color.special_black))
    ) {
        Icon(
            modifier = Modifier
                .padding(top = 10.dp, start = 8.dp, bottom = 4.dp),
            imageVector = Icons.Default.Warning,
            contentDescription = "Заменить"
        )

        Title4(
            text = offerItem.title,
            maxLines = if (offerItem.button != null) 2 else 3
        )

        if (offerItem.button != null) {
            Spacer(modifier = Modifier.height(4.dp))
            Text1(
                color = colorResource(id = R.color.special_green),
                text = "${offerItem.button?.text}"
            )
        }
    }


}