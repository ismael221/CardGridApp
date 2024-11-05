package com.ismael.grade

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GridApp()
        }
    }
}


@Composable
fun GridCard(
    topic: Topic,
    modifier: Modifier = Modifier,
){
        Card(
            modifier = modifier
                .width(178.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
           Row(
               modifier =  modifier,
           ) {
               Box(
                   modifier = modifier
               ){
                   Image(
                       painter = painterResource(topic.image),
                       contentDescription = "",
                       modifier = modifier
                           .width(68.dp)
                           .height(68.dp)
                   )
               }
               Column(
                   modifier = modifier,
               ) {
                   Text(
                       text = stringResource(topic.name),
                       modifier = modifier
                           .padding(top = 16.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
                   )
                   Row (
                       modifier = modifier
                           .padding(start = 16.dp)
                   ){
                       Image(
                           painter = painterResource(R.drawable.ic_grain),
                           contentDescription = null
                       )
                       Text(
                           text = "321",
                           modifier = modifier
                               .padding(start = 8.dp, top = 4.dp)
                       )
                   }
               }
           }
        }
        Spacer(
            modifier = modifier
                .padding(8.dp)
        )
}

@Composable
fun GridList(
    topicsList: List<Topic>,
    modifier: Modifier = Modifier,
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 178.dp),
        modifier = modifier.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(topicsList){ topic ->
            GridCard(
                topic = topic,
                modifier = modifier
            )
        }
    }
}

@Composable
fun GridApp(){
    val layoutDirection = LocalLayoutDirection.current

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection),
            )
    ) {
        GridList(DataSource.topic)
    }
}

@Preview(showBackground = true)
@Composable
fun GridCardsPreview() {
    GridApp()
}