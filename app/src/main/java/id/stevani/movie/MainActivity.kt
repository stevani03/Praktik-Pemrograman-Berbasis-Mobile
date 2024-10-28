package id.stevani.movie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import id.stevani.movie.data.Movie
import id.stevani.movie.data.movies
import id.stevani.movie.ui.theme.MovieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MovieApp()
                }
            }
        }
    }
}

@Composable
fun MovieApp() {
    LazyColumn {
        items(movies) { movie ->
            Surface(
                color = Color(0xFFFFDAB9), // Mengganti warna latar belakang dengan warna peach
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                MovieItem(movie = movie)
            }
        }
    }
}

@Composable
fun MovieItem(
    movie: Movie,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_small))
    ) {
        MovieIcon(movie.imageResourceId) // komponen gambar film
        MovieInformation(movie.title, movie.year) // komponen informasi film
    }
}

// Gambar/foto untuk setiap film
@Composable
fun MovieIcon(
    @DrawableRes movieIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.large_image_size)) // Ukuran lebih besar
            .padding(dimensionResource(R.dimen.padding_small)),
        painter = painterResource(movieIcon),
        contentDescription = null
    )
}

// Teks untuk judul dan tahun rilis film
@Composable
fun MovieInformation(
    @StringRes movieTitle: Int,
    movieYear: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(movieTitle),
            fontWeight = FontWeight.Bold, // Menambahkan ketebalan teks pada judul
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(R.string.release_year, movieYear),
        )
    }
}

@Preview
@Composable
fun MoviePreview() {
    MovieTheme(darkTheme = false) {
        MovieApp()
    }
}
