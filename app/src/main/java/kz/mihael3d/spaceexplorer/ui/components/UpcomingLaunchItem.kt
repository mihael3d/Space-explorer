package kz.mihael3d.spaceexplorer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import kz.mihael3d.spaceexplorer.R

@Preview
@Composable
fun LaunchCard(
//    rocketImage: Painter,
//    missionName: String,
//    agency: String,
//    location: String,
//    countdown: String,
//    launchDate: String,
//    statusText: String,
//    statusColor: Color,
//    onWatchClick: () -> Unit,
//    onInfoClick: () -> Unit,
//    onShareClick: () -> Unit
){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 160.dp)
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1C1C1E)),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row {
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .background(Color.DarkGray) ,
                contentAlignment = Alignment.Center,

            ) {
                Image(
                    painter = painterResource(id = R.drawable.plaseholder),
                    contentDescription = "Rocket",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text="Long March 7A| Unknown Payload",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.Green)
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(text = "GO",
                            color = Color.White,
                            style = MaterialTheme.typography.labelSmall

                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "China Aerospace Science and Technology Corporation",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.LightGray)
                 Text(text = "Wenchang Space Launch Site, People's Republic of China",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = Color.Gray)
                Spacer(modifier = Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.PlayArrow, contentDescription = "Whatch",tint=Color.Red)
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Info, contentDescription = "Info", tint = Color.Gray)
                    }
                    IconButton(onClick ={}) {
                        Icon(Icons.Default.Share, contentDescription = "Share", tint = Color.Gray)
                    }
                }

            }
        }
    }




}