package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MainScreen()
        }
    }
}

@Composable
private fun ApplySystemBarColors() {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(color = Color.Transparent)
        systemUiController.setNavigationBarColor(color = Color.Transparent)
    }
}

@Preview
@Composable
fun MainScreen() {
    ApplySystemBarColors()
    Surface {
        DotaScreen()
    }
}

@Composable
fun DotaScreen() {
    LazyColumn(
        state = rememberLazyListState(),
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF050B18))
            .padding(
                bottom = 30.dp,
            )
    ) {
        item {
            headerPreview()
        }
        item {
            description()
        }
        item {
            listVideoPreview()
        }
        item {
            reviewAndRatings()
        }
        item {
            comments()
        }
        item {
            buttonInstall()
        }
    }
}

@Composable
fun headerPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy((-35).dp),
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.dota_screen),
            contentDescription = "dota_screen",
            contentScale = ContentScale.FillWidth,
        )
        Box(
            modifier = Modifier
                .width(240.dp)
                .height(95.dp)
                .background(
                    color = Color(0xFF050B18),
                    shape = RoundedCornerShape(topEnd = 25.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 24.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(
                            space = -25.dp,
                            alignment = Alignment.CenterVertically
                        ),
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                        ) {
                            Column(
                                modifier = Modifier
                                    .width(88.dp)
                                    .height(88.dp)
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFF3A3F39),
                                        shape = RoundedCornerShape(size = 12.dp)
                                    )
                                    .background(
                                        color = Color(0xFF000000),
                                        shape = RoundedCornerShape(size = 12.dp)
                                    ),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Image(
                                    modifier = Modifier
                                        .width(54.dp)
                                        .height(54.dp),
                                    painter = painterResource(id = R.drawable.dota_logo),
                                    contentDescription = "dota_logo",
                                )
                            }
                        }
                        Box {

                        }
                    }
                }
                Box(

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                start = 12.dp,
                            ),
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = "DoTA 2",
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 26.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFFFFFFF),
                                letterSpacing = 0.5.sp,
                            )
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    top = 6.dp
                                )
                        ) {
                            Image(
                                modifier = Modifier
                                    .padding(top = 1.dp)
                                    .width(76.dp)
                                    .height(12.dp),
                                painter = painterResource(id = R.drawable.full_stars),
                                contentDescription = "full_stars",
                            )
                            Text(
                                modifier = Modifier
                                    .padding(
                                        start = 10.dp
                                    ),
                                text = "70M",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF45454D),
                                    letterSpacing = 0.5.sp,
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun description() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(start = 24.dp, end = 24.dp),
        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
    ) {
        itemsIndexed(
            listOf("MOBA", "MULTIPLAYER", "STRATEGY")
        ) { index, item ->
            Box(
                modifier = Modifier
                    .background(
                        color = Color(0x3D44A9F4),
                        shape = RoundedCornerShape(size = 10.dp)
                    )

            ) {
                Text(
                    text = "$item",
                    modifier = Modifier.padding(
                        start = 6.dp,
                        end = 6.dp,
                        top = 1.dp,
                        bottom = 1.dp,
                    ),
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF44A9F4),
                    )
                )
            }
        }
    }
    Text(
        text = "Dota 2 is a multiplayer online battle arena (MOBA) game which has two teams of five players compete to collectively destroy a large structure defended by the opposing team known as the \"Ancient\", whilst defending their own.",
        style = TextStyle(
            fontSize = 12.sp,
            lineHeight = 19.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight(400),
            color = Color(0xB2EEF2FB),
        ),
        modifier = Modifier.padding(
            start = 24.dp,
            end = 24.dp,
            top = 14.dp,
            bottom = 14.dp,
        )
    )
}

@Composable
fun listVideoPreview() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(start = 24.dp, end = 24.dp),
        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
    ) {
        itemsIndexed(
            listOf(
                R.drawable.video_preview1,
                R.drawable.video_preview2,
            )
        ) { index, item ->
            Box(
                modifier = Modifier
                    .width(240.dp)
                    .height(135.dp)
                    .background(
                        color = Color(0xFFC4C4C4),
                        shape = RoundedCornerShape(size = 14.dp)
                    ),
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(size = 14.dp)),
                    painter = painterResource(id = item),
                    contentDescription = "video_preview$index",
                    contentScale = ContentScale.FillBounds,
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier
                            .width(48.dp)
                            .height(48.dp)
                            .clip(CircleShape)
                    ) {
                        Image(
                            modifier = Modifier
                                .border(width = 0.7.dp, color = Color(0x00FFFFFF))
                                .padding(0.7.dp)
                                .width(48.dp)
                                .height(48.dp)
                                .background(color = Color(0x3DFFFFFF)),
                            painter = painterResource(id = R.drawable.btn_play),
                            contentDescription = "btn_play",
                            contentScale = ContentScale.Crop,
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                modifier = Modifier
                                    .width(10.dp)
                                    .height(12.dp),
                                painter = painterResource(id = R.drawable.btn_play_c),
                                contentDescription = "btn_play",
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun reviewAndRatings() {
    Box(
        modifier = Modifier.padding(
            start = 24.dp,
            end = 24.dp,
            top = 14.dp,
            bottom = 5.dp,
        )
    ) {
        Column {
            Text(
                text = "Review & Ratings",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFEEF2FB),
                    letterSpacing = 0.6.sp,
                ),
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "4.9",
                    style = TextStyle(
                        fontSize = 48.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                    ),
                )

                Column(
                    modifier = Modifier.padding(start = 15.dp, end = 15.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                    ) {
                        Image(
                            modifier = Modifier
                                .width(76.dp)
                                .height(12.dp),
                            painter = painterResource(id = R.drawable.stars_rating),
                            contentDescription = "stars_rating",
                        )
                    }
                    Text(
                        text = "70M Reviews",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFA8ADB7),
                            letterSpacing = 0.5.sp,
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun comments() {
    val playersComment1 = PlayersComment(
        R.drawable.player_comment1,
        "Auguste Conte",
        "February 14, 2019",
        "“Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers.”"
    )
    val playersComment2 = PlayersComment(
        R.drawable.player_comment2,
        "Jang Marcelino",
        "February 14, 2019",
        "“Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers.”"
    )
    val listPlayersComments = listOf(playersComment1, playersComment2)
    Box(
        modifier = Modifier.padding(
            start = 24.dp,
            end = 24.dp,
            top = 3.dp,
            bottom = 3.dp,
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            listPlayersComments.forEachIndexed { index, item ->
                Column(
                    modifier = Modifier
                        .padding(top = 15.dp, bottom = 15.dp),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            modifier = Modifier
                                .width(36.dp)
                                .height(36.dp)
                                .clip(CircleShape)
                        ) {
                            Image(
                                modifier = Modifier
                                    .fillMaxSize(),
                                painter = painterResource(item.idPlayersComment),
                                contentDescription = "image ${item.idPlayersComment}",
                                contentScale = ContentScale.Crop,
                            )
                        }
                        Column(
                            modifier = Modifier.padding(start = 15.dp, end = 15.dp),
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(top = 4.dp, bottom = 4.dp),
                            ) {
                                Text(
                                    text = item.namePlayersComment,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily.Default,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFFFFFFF),
                                        letterSpacing = 0.5.sp,
                                    )
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .padding(top = 4.dp, bottom = 4.dp),
                            ) {
                                Text(
                                    text = item.datePlayersComment,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily.Default,
                                        fontWeight = FontWeight(400),
                                        color = Color(0x66FFFFFF),
                                        letterSpacing = 0.5.sp,
                                    )
                                )
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .padding(top = 8.dp, bottom = 8.dp),
                    ) {
                        Text(
                            text = item.commentPlayersComment,
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 20.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight(400),
                                color = Color(0xFFA8ADB7),
                                letterSpacing = 0.5.sp,
                            )
                        )
                    }
                }
                if ((listPlayersComments.size - 1) > index) {
                    Box(
                        modifier = Modifier
                            .border(width = 1.dp, color = Color(0xFF1A1F29))
                            .padding(1.dp)
                            .width(300.dp)
                            .height(0.dp)
                    ) {

                    }
                }
            }

        }
    }
}

@Composable
fun buttonInstall() {
    val label = remember {
        mutableStateOf("Install")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 24.dp,
                end = 24.dp,
                top = 15.dp,
                bottom = 30.dp,
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .width(327.dp)
                .height(64.dp)
                .background(
                    color = Color(0xFFF4D144),
                    shape = RoundedCornerShape(size = 12.dp)
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {
                    label.value = "Installing..."
                },
                colors = ButtonDefaults
                    .buttonColors(
                        backgroundColor = Color(0xFFF4D144),
                    ),
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = label.value,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF050B18),
                        letterSpacing = 0.6.sp,
                    )
                )
            }
        }
    }
}

class PlayersComment(
    id: Int,
    name: String,
    date: String,
    comment: String,
) {
    val idPlayersComment = id
    val namePlayersComment = name
    val datePlayersComment = date
    val commentPlayersComment = comment
}