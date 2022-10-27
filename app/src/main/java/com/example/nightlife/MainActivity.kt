package com.example.nightlife

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nightlife.model.NavigationItem
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
    val navController = rememberNavController()
    if (viewModel.loggedIn) {

        Scaffold(
            bottomBar = { NavBar(navController = navController) }
        ) {
            NavigationGraph(navController = navController, viewModel)
        }
    } else Login {
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
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally) {
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
            items(viewModel.favorites) {
                FavoriteComponent(name = it.name)
            }
        }
        Text(text = "Trending in Copenhagen",
        modifier = Modifier.padding(5.dp),
        style = MaterialTheme.typography.h5)
        LazyRow(modifier = Modifier
            .height(250.dp)
            .fillMaxWidth(), 
        horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            items(viewModel.bars.allBars) {
                TrendyComponent(name = it.name)
            }
        }
        Text(text = "Closest to you",
        modifier = Modifier.padding(5.dp),
        style = MaterialTheme.typography.h5)
        LazyRow(modifier = Modifier
            .height(250.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            items(viewModel.bars.allBars) {
                ProximityComponent(name = it.name)
            }
        }
    }
}

@Composable
fun MapPage() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Map")
    }
}
@Composable
fun SettingsPage() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Settings")
    }
}

@Composable
fun SearchPage() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Search")
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, viewModel: HomeViewModel) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
         OverviewPage(viewModel = viewModel)
        }
        composable(NavigationItem.Map.route) {
            MapPage()
        }
        composable(NavigationItem.Search.route) {
            SearchPage()
        }
        composable(NavigationItem.Settings.route) {
            SettingsPage()
        }

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
fun ProximityComponent(name: String) {
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
                text = "69 KM Away",
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
    val configuration = LocalConfiguration.current
    Box(modifier = Modifier
        .height(250.dp)
        .width(configuration.screenWidthDp.dp - 10.dp)
        .clip(RoundedCornerShape(15.dp))
        .background(Color.LightGray)) {
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
                modifier = Modifier
                    .padding(10.dp)
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

@Composable
fun NavBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Map,
        NavigationItem.Search,
        NavigationItem.Settings
    )
    BottomNavigation(
        Modifier.background(Color.LightGray),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach{item ->
            BottomNavigationItem(
                icon = { Icon(imageVector = item.imageVector, contentDescription = item.title) },
                label = { Text(text = item.title)},
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let {route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                } })
        }
    }
}

@Composable
fun ProfileScreen(id: Int) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.LightGray)) {
            Text(text = "Picture")
        }
        Text(text = "Name",
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.h3)
        Text(text = "Some log description",
        modifier = Modifier.padding(10.dp),
        style = MaterialTheme.typography.body1)
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
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { NavBar(navController) },
        content = { OverviewPage(viewModel = viewModel) })
}

@Preview(showBackground = true)
@Composable
fun NavPreview() {
    val navController = rememberNavController()
    NavBar(navController)
}

@Preview(showBackground = true)
@Composable 
fun barPreview() {
    ProfileScreen(id = 1)
}
