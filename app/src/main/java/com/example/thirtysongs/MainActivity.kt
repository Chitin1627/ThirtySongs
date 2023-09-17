package com.example.thirtysongs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtysongs.data.Song
import com.example.thirtysongs.data.songs
import com.example.thirtysongs.ui.theme.ThirtySongsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtySongsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Cards()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Cards() {
    val items = songs
    val pagerState = rememberPagerState()
    HorizontalPager(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.wrapContentHeight(),
        pageCount = items.size,
        state = pagerState,
    ) { currentPage ->
        SongCard(
            song = items[currentPage],
            modifier = Modifier
                .fillMaxWidth())
    }

}
@Composable
fun SongCard(song: Song, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(32.dp),
        modifier = modifier
            .padding(
                start = 16.dp,
                end = 16.dp),
        colors = CardDefaults
            .cardColors(
                containerColor = MaterialTheme
                    .colorScheme
                    .onPrimary),
        elevation = CardDefaults.cardElevation(8.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onTertiaryContainer)
    ) {
        Column {
            Text(
                text = stringResource(song.day),
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Text(
                text = stringResource(id = song.description),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    ThirtySongsTheme(darkTheme = false) {
        Cards()
    }
}