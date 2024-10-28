package id.stevani.movie.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import id.stevani.movie.R

data class Movie(
    @StringRes val title: Int,
    val year: Int,
    @DrawableRes val imageResourceId: Int
)

// Daftar movie
val movies = listOf(
    Movie(R.string.movie_title_1, 2021, R.drawable.gamber_1),
    Movie(R.string.movie_title_2, 2020, R.drawable.gamber_2),
    Movie(R.string.movie_title_3, 2019, R.drawable.gamber_3),
    Movie(R.string.movie_title_4, 2022, R.drawable.gamber_4),
    Movie(R.string.movie_title_5, 2023, R.drawable.gamber_5)
)
