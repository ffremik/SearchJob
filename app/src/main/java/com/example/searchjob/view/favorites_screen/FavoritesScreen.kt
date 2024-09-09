package com.example.searchjob.view.favorites_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.domain.model.Vacancy
import com.example.searchjob.R
import com.example.searchjob.style.Text1
import com.example.searchjob.style.Title2
import com.example.searchjob.view.favorites_screen.viewmodel.FavoritesVM
import com.example.searchjob.view.mainscreen.compotent.JobCard


@Composable
@Preview(
    showBackground = true,
    backgroundColor = 1L
)
fun PreviewFavoritesScreen() {
    //FavoritesScreen()
}

@Composable
fun FavoritesScreen(
    favoritesVM: FavoritesVM = hiltViewModel(),
    viewVacancy: (Vacancy) -> Unit,
    onClickFavorites: (Vacancy) -> Unit,
    navigation: () -> Unit,
) {
    val listFavorites by favoritesVM.listFavorites.collectAsState(initial = emptyList())
    Spacer(modifier = Modifier.height(16.dp))
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Title2(
            text = "Избранное"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text1(
            color = colorResource(id = R.color.basic_grey3),
            text = favoritesVM.getVacanciesText(listFavorites.size)
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(

        ) {
            items(listFavorites) { vacancy ->
                JobCard(
                    itemVacancy = vacancy,
                    navigation = {
                        navigation()
                    },
                    onClickFavorites = {
                        onClickFavorites(vacancy)
                    },
                    viewVacancy = {
                        viewVacancy(it)
                    },
                    text = {
                        if (vacancy.lookingNumber != null) {
                            favoritesVM.getLookingText(it)
                        } else ""
                    }
                )
            }
        }
    }
}