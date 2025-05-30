package kz.mihael3d.spaceexplorer.ui.main
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import kz.mihael3d.spaceexplorer.ui.theme.SpaceExplorerTheme

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



