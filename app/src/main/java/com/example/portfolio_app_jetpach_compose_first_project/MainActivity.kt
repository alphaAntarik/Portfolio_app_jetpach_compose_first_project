package com.example.portfolio_app_jetpach_compose_first_project

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.example.portfolio_app_jetpach_compose_first_project.ui.theme.Portfolio_app_jetpach_compose_first_projectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Portfolio_app_jetpach_compose_first_projectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current.density

    val screenWidthInDp = (configuration.screenWidthDp * density).toInt()
    val screenHeightInDp = (configuration.screenHeightDp * density).toInt()
    val buttonbuttonclicked = remember {
        mutableStateOf(false)
    }

        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            Card(modifier = Modifier
                .width(screenWidthInDp * 0.1.dp)
                .height(screenHeightInDp * 0.1.dp)
                .padding(12.dp), elevation = 4.dp,
                shape = RoundedCornerShape(corner = CornerSize(10.dp))) {
                Column(modifier = Modifier.height(screenHeightInDp*0.3.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    CreateProfileImage()
                    Divider()
                    CreateUserInfo()
                    Button(onClick = {
                        buttonbuttonclicked.value=!buttonbuttonclicked.value
                        Log.d("clicked", "CreateBizCard: clicked")
                    }) {
                        Text(text = "Portfolio",
                        style = MaterialTheme.typography.button)
                        
                    }
                    if(buttonbuttonclicked.value){
                        Content()
                    }else{
                        Box(){

                        }
                    }
            }
        }
    }
}

@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(3.dp),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp,
                color = Color.LightGray)
        ) {
            Portfolio(data= listOf<String>(
                "Project 1",
                "Project 2",
                "Project 3",
                "Project 4",
                "Project 5",
                "Project 6",
                "Project 7",
            ))
        }
    }
}
@Preview
@Composable
fun Portfolio(data: List<String> = listOf("hi")) {
    LazyColumn{
        items(data){
            item ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                shape = RectangleShape,
            elevation = 7.dp){
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(16.dp)) {
                   CreateProfileImage(modifier = Modifier.size(100.dp))
                   Column(modifier = Modifier.padding(7.dp).align(Alignment.CenterVertically)) {
                       Text(text=item, fontWeight = FontWeight.Bold)
                       Text(text="A great Project", style = MaterialTheme.typography.body2)
                   }

                }

            }
        }
    }

}

@Composable
private fun CreateUserInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Antarik Pandit",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            text = "Android compose developer",
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = "antarikpanditison@gmail.com",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1
        )

    }
}

@Composable
private fun CreateProfileImage(modifier: Modifier=Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp), shape = CircleShape, border = BorderStroke(
            0.1.dp,
            Color.LightGray,
        ), elevation = 4.dp, color = Color.LightGray
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile Image",
            modifier = modifier.size(145.dp),
            contentScale = ContentScale.Crop
        )

    }
}

@Preview
@Composable
fun DefaultPreview() {
    Portfolio_app_jetpach_compose_first_projectTheme {
        CreateBizCard()
    }
}