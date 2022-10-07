package com.example.nightlife

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.nightlife.ui.theme.NightLifeTheme
import com.example.nightlife.viewmodel.HomeViewModel

class MainActivity : ComponentActivity() {

    private val viewModel = HomeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NightLifeTheme {
                Screen(viewModel)
            }
        }
    }
}

@Composable
fun Screen(viewModel: HomeViewModel) {
    if (viewModel.loggedIn) OverviewPage(viewModel) else Login {
        viewModel.logIn()
    }
}

@Composable
fun Login(onButtonClick: () -> Unit) {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {onButtonClick()}) {
            Text(text = "Login")
        }
    }
}

@Composable
fun OverviewPage(viewModel: HomeViewModel) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome to NightLife!",
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.h3)
        Text (text = "Your favorites",
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.h5)
        LazyRow(modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .padding(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            items(viewModel.favoriteBars) {
                FavoriteComponent(name = it)
            }
        }
        Text(text = "Trending in Copenhagen",
        modifier = Modifier.padding(5.dp),
        style = MaterialTheme.typography.h5)
    }
}

@Composable
fun FavoriteComponent(name: String) {
    Box(modifier = Modifier
        .height(100.dp)
        .width(200.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(Color.LightGray)
        .padding()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = name,
                    modifier = Modifier.padding(5.dp),
                    style = MaterialTheme.typography.h4
                )
                Text(
                    text = "4,3",
                    modifier = Modifier
                        .padding(horizontal = 5.dp, vertical = 10.dp)
                        .alpha(0.5f),
                    style = MaterialTheme.typography.h5
                )
            }
            Text(
                text = "Open",
                modifier = Modifier
                    .padding(5.dp)
                    .alpha(0.5f),
                style = MaterialTheme.typography.h6
            )
        }
    }
    // Should be clickable to navigate to company profile.
}

@Composable
fun TrendyComponent(name: String) {
    Box(modifier = Modifier
        .height(250.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(15.dp))) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = name,
                modifier = Modifier
                    .padding(10.dp),
                style = MaterialTheme.typography.h3
            )
            Text(
                text = "Rating: 4,1",
                modifier = Modifier
                    .padding(5.dp)
                    .alpha(0.8f),
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "Address or some shit",
                modifier = Modifier.padding(10.dp)
                    .alpha(0.8f),
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Some description saying some shit about some shit. This is just to fill it out in some way so I can see how it looks like.",
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.caption
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NightLifeTheme {
        Login {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoggedInPreview() {
    val viewModel = HomeViewModel()
    OverviewPage(viewModel)
}

@Preview(showBackground = true)
@Composable
fun FavoritePreview() {
    FavoriteComponent(name = "1656")
}

@Preview(showBackground = true)
@Composable
fun TrendPreview() {
    TrendyComponent(name = "BarKowski")
}
