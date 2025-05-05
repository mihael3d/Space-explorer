package kz.mihael3d.spaceexplorer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip


import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp


import kz.mihael3d.spaceexplorer.ui.theme.SpaceExplorerTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage


import coil3.compose.rememberAsyncImagePainter
import coil3.compose.rememberConstraintsSizeResolver

import coil3.request.ImageRequest



import kz.mihael3d.spaceexplorer.core.nasaApi.models.ApodItem





class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            SpaceExplorerTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize(),
                    contentWindowInsets = WindowInsets.systemBars
                ) {innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        ApodScreen()
                    }
                }
            }
        }
    }
}


@Composable
fun ApodScreen(viewModel: ApodViewModel = viewModel(), modifier: Modifier = Modifier) {
    val photo by viewModel.photo.collectAsState()
    Box(modifier = modifier.fillMaxSize() ) {
        ApodScreenInternal(photo = photo)
    }
}

@Composable
fun ApodScreenInternal(photo: ApodItem?) {

    ApodImage(
        url = photo?.hdurl,
        title = photo?.title
    )

}


@Composable
fun ApodImage(url: String?, title: String?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = title?.takeIf { it.isNotBlank() } ?: "Загрузка...",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )


        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalPlatformContext.current)
                .data(url)
                .build()
        )
        val state by painter.state.collectAsState()

        when (state) {
            is AsyncImagePainter.State.Empty,
            is AsyncImagePainter.State.Loading -> {
                CircularProgressIndicator()
            }
            is AsyncImagePainter.State.Success -> {
                Image(
                    painter = painter,
                    contentDescription = "Spase image"
                )
            }
            is AsyncImagePainter.State.Error -> {
                // Show some error UI.
            }
        }

     }
}




@Preview()
@Composable
fun ApodScreenPreview() {
    val mockItem = ApodItem(
        title = "Galactic Swirl",
        url = "", // пусто — для заглушки
        date = "2023-10-01",
        explanation = "A beautiful galaxy captured by Hubble.",
        media_type = "image"
    )
    ApodImage(url = mockItem.url!!,title = mockItem.title!!)

}
