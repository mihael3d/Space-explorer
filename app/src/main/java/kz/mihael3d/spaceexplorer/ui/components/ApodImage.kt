package kz.mihael3d.spaceexplorer.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import kz.mihael3d.spaceexplorer.R

@Composable
fun ApodImage(url: String?, title: String?) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val isPreview = LocalInspectionMode.current


        val imageRequest = if (isPreview) {
            ImageRequest.Builder(LocalContext.current)
                .data(R.drawable.plaseholder)  // локальный ресурс для preview
                .crossfade(true)
                .build()
        } else {
            ImageRequest.Builder(LocalContext.current)
                .data(url)  // реальный URL во время работы приложения
                .crossfade(true)
                .build()
        }

        AsyncImage(
            model = imageRequest,
            contentDescription = "Spase image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxSize()
        )
        Text(
            text = title?.takeIf { it.isNotBlank() } ?: "Загрузка...",
            color = Color.White,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 8.dp, bottom = 8.dp)
        )

    }
}