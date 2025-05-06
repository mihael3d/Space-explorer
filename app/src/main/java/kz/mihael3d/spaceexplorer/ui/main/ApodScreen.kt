package kz.mihael3d.spaceexplorer.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kz.mihael3d.spaceexplorer.ui.components.ApodImage
import kz.mihael3d.spaceexplorer.core.nasaApi.models.ApodItem

@Composable
fun ApodScreen(viewModel: ApodViewModel = viewModel()) {
    val photo by viewModel.photo.collectAsState()
    ApodScreenInternal(photo)
  }

@Composable
fun ApodScreenInternal(photo: ApodItem?) {

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            ApodImage(
                url = photo?.hdurl,
                title = photo?.title
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {

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
    ApodScreenInternal(mockItem)
}