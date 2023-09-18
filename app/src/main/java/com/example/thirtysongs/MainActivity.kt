package com.example.thirtysongs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
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

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Cards() {
    val items = songs
    val pagerState = rememberPagerState()
    Scaffold(
        topBar = { SongsTopAppBar() },
        content = {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                HorizontalPager(
                    contentPadding = it,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .wrapContentHeight(),
                    pageCount = items.size,
                    state = pagerState
                ) { currentPage ->
                    SongCard(
                        song = items[currentPage],
                        modifier = Modifier
                            .fillMaxWidth())
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SongsTopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    textAlign = TextAlign.Center
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}
@Composable
fun SongCard(song: Song, modifier: Modifier = Modifier) {
    var songName by remember { mutableStateOf("") }
    var artistName by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var textExpanded by remember { mutableStateOf(false) }
    print(textExpanded)
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Text(
                text = stringResource(song.day),
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Image(
                painter = painterResource(song.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(256.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(RoundedCornerShape(16.dp))

            )

            Spacer(modifier = Modifier.padding(4.dp))

            Text(
                text = stringResource(id = song.description),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.padding(4.dp))

            if(textExpanded) {
                TextInputs(songName = songName, artistName = artistName)
            }

            Spacer(modifier = Modifier.padding(4.dp))

            ExpandButton(
                expanded = expanded,
                onClick = {
                    expanded = !expanded
                    textExpanded = false},
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.padding(4.dp))

            if(expanded) {
                InputFields(
                    label = R.string.song_name,
                    leadingIcon = R.drawable.song_icon,
                    value = songName,
                    onValueChanged = { songName = it },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = {
                        expanded = !expanded
                        textExpanded = true
                    },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.padding(4.dp))

                InputFields(
                    label = R.string.artist_name,
                    leadingIcon = R.drawable.mic_icon,
                    value = artistName,
                    onValueChanged = { artistName = it },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = {
                            expanded = !expanded
                            textExpanded = true
                    },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 8.dp)
                )

                Spacer(modifier = Modifier.padding(4.dp))
            }

        }
    }
}

@Composable
private fun ExpandButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if(expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.outlineVariant
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputFields(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    value: String,
    onValueChanged: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    keyboardActions: (KeyboardActionScope) -> Unit,
    modifier: Modifier = Modifier) {

    TextField(
        value = value,
        leadingIcon = { Icon(
            painter = painterResource(id = leadingIcon),
            contentDescription = null,
            modifier = Modifier.size(24.dp)) },
        onValueChange = onValueChanged,
        keyboardActions = KeyboardActions(onDone = keyboardActions),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        label = { Text(stringResource(id = label)) },
        singleLine = true,
        keyboardOptions = keyboardOptions,
        shape = RoundedCornerShape(24.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.surfaceTint,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLeadingIconColor = MaterialTheme.colorScheme.surfaceTint,
            unfocusedLeadingIconColor = MaterialTheme.colorScheme.surfaceTint,
            focusedLabelColor = MaterialTheme.colorScheme.surfaceTint,
            unfocusedLabelColor = MaterialTheme.colorScheme.surfaceTint
        ),
        textStyle = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun TextInputs(
    songName: String,
    artistName: String,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Song: $songName",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )

        Text(
            text = "Artist: $artistName",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    ThirtySongsTheme(darkTheme = false) {
        Cards()
    }
}