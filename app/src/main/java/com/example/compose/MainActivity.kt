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
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
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
    ) {
        item(
        ) {
            Box(
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = painterResource(id = R.drawable.dota_screen),
                    contentDescription = "dota_screen",
                    contentScale = ContentScale.FillWidth,
                )
            }
        }
        item {
            Box(
                modifier = Modifier
                    .width(212.dp)
                    .height(95.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dota_logo),
                    contentDescription = "dota_logo",
                )
            }
        }
        item {
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
        item {
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
                            modifier = Modifier.clip(RoundedCornerShape(size = 14.dp)),
                            painter = painterResource(id = item),
                            contentDescription = "video_preview$index",
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
        item {
            Box(
                modifier = Modifier.padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 14.dp,
                    bottom = 14.dp,
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

                        ) {

                        }
                    }
                }
            }
        }
    }
}