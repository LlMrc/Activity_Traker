package com.example.composeproject.`interface`


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeproject.Feature
import com.example.composeproject.R
import com.example.composeproject.standardQuadFromTo
import com.example.composeproject.ui.theme.Beige1
import com.example.composeproject.ui.theme.Beige2
import com.example.composeproject.ui.theme.Beige3
import com.example.composeproject.ui.theme.BlueViolet1
import com.example.composeproject.ui.theme.BlueViolet2
import com.example.composeproject.ui.theme.BlueViolet3
import com.example.composeproject.ui.theme.ButtonBlue
import com.example.composeproject.ui.theme.DarkerButtonBlue
import com.example.composeproject.ui.theme.DeepBlue
import com.example.composeproject.ui.theme.LightGreen1
import com.example.composeproject.ui.theme.LightGreen2
import com.example.composeproject.ui.theme.LightGreen3
import com.example.composeproject.ui.theme.LightRed
import com.example.composeproject.ui.theme.OrangeYellow1
import com.example.composeproject.ui.theme.OrangeYellow2
import com.example.composeproject.ui.theme.OrangeYellow3
import com.example.composeproject.ui.theme.TextWhite

@Composable
 fun HomeScreen(){
     Box(modifier = Modifier
         .background(DeepBlue)
         .fillMaxSize()
         ){
     Column {
         GreetingSection("louis Marc")
         ChipSection(chips = listOf("Lundi", "Mardi", "Mercredi", "jeudi"))
         Notification()

         FeatureSection(features = listOf(
             Feature(title = "Janvier",
                 R.drawable.ic_headphone,
                 BlueViolet1,
                 BlueViolet2,
                 BlueViolet3),

             Feature(title = "Fevrier",
                 R.drawable.ic_videocam,
                 LightGreen1,
                 LightGreen2,
                 LightGreen3),

             Feature(title = "Mars",
                 R.drawable.ic_headphone,
                 OrangeYellow1,
                 OrangeYellow2,
                 OrangeYellow3),

             Feature(title = "Avril",
                 R.drawable.ic_headphone,
                 Beige1,
                 Beige2,
                 Beige3)
         ))



     }


     }
 }

@Composable
fun GreetingSection(name:String){
    Row(horizontalArrangement =  Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)) {
        Column (verticalArrangement = Arrangement.Center){
              Text(text = "Good Mornings, $name",
                  style = MaterialTheme.typography.bodyLarge,
                  color = TextWhite)
               Text(text = "We wish you have a good day!",
                   color = TextWhite,
                   style = MaterialTheme.typography.bodySmall)
        }

       Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "search" ,
           tint = Color.White,
           modifier = Modifier.size(24.dp))

    }
}


@Composable
fun  ChipSection(
    chips: List<String>
){
     var selectedChips by remember {
         mutableIntStateOf(0)
     }
 LazyRow{
     items(chips.size){
         Box(
             contentAlignment = Alignment.Center,
             modifier = Modifier

                 .padding(top = 15.dp, start = 15.dp, bottom = 15.dp)
                 .clickable { selectedChips = it }
                 .clip(RoundedCornerShape(10.dp))
                 .background(
                     if (selectedChips == it) ButtonBlue
                     else DarkerButtonBlue
                 )
                 .padding(15.dp))
         {
             Text(text = chips[it], color = TextWhite)
         }

     }

 }
}

@Composable
fun Notification(
    color: Color = LightRed
){
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ){

        Column {
            Text(text = "Daily thought",
                color = TextWhite,
                style = MaterialTheme.typography.bodyLarge)
            Text(text = "tree days left for the meeting",
                style = MaterialTheme.typography.bodySmall,
                color = TextWhite)
        }

        Box(modifier = Modifier
            .size(40.dp)
            .align(Alignment.CenterVertically)
            .clip(CircleShape)
            .background(ButtonBlue)
            .padding(10.dp)
        ){
            Icon(painter = painterResource(id = R.drawable.ic_play), contentDescription = "play",
                tint = Color.White,
                modifier = Modifier.size(16.dp))
        }
    }
}


@Composable
fun FeatureSection(features: List<Feature>){
    Column(modifier = Modifier
      ){
        Text(text = "Feature",
            style = MaterialTheme.typography.headlineLarge,
            color = TextWhite,
            modifier = Modifier
                .padding(10.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(2),
            modifier = Modifier.height(360.dp),
            contentPadding =  PaddingValues(
                start = 7.5.dp,
                end = 7.5.dp,
                bottom = 100.dp
            ),
            content = {
                items(features.size){


                           FeatureItem(feature = features[it])


                }
            }
          )


    }
    
}


@Composable
fun FeatureItem(feature: Feature){
    BoxWithConstraints (modifier = Modifier

        .padding(10.dp)
        .aspectRatio(1f)
        .clip(RoundedCornerShape(10.dp))
        .background(feature.darkColor)
       ){
     val width = constraints.maxWidth
         val height = constraints.maxHeight
        // medium colored path
     val   mediumColoredPaint1 = Offset(0f, height * 0.3f)
        val   mediumColoredPaint2 = Offset(width * 0.1f, height * 0.35f)
        val   mediumColoredPaint3 = Offset(width * 0.4f, height * 0.5f)
        val   mediumColoredPaint4 = Offset(width * 0.75f, height * 0.7f)
        val   mediumColoredPaint5 = Offset(width * 1.5f, - height.toFloat())
        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPaint1.x, mediumColoredPaint2.y)
            standardQuadFromTo(mediumColoredPaint1, mediumColoredPaint2)
            standardQuadFromTo(mediumColoredPaint2, mediumColoredPaint3)
            standardQuadFromTo(mediumColoredPaint3, mediumColoredPaint4)
            standardQuadFromTo(mediumColoredPaint4, mediumColoredPaint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(- 100f, height.toFloat() + 100f)
            close()
        }


        // medium colored align
        val   lightToPaint1 = Offset(0f, height * 0.35f)
        val  lightToPaint2 = Offset(width * 0.1f, height * 0.4f)
        val   lightToPaint3 = Offset(width * 0.3f, height * 0.35f)
        val  lightToPaint4 = Offset(width * 0.65f, height.toFloat())
        val   lightToPaint5 = Offset(width * 1.4f, - height.toFloat() /3)

        val lightColoredPath = Path().apply {
            moveTo(lightToPaint1.x, lightToPaint1.y)
            standardQuadFromTo(lightToPaint1, lightToPaint2)
            standardQuadFromTo(lightToPaint2, lightToPaint3)
            standardQuadFromTo(lightToPaint3, lightToPaint4)
            standardQuadFromTo(lightToPaint4, lightToPaint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(- 100f, height.toFloat() + 100f)
            close()
        }
Canvas(modifier = Modifier

    .fillMaxSize()){
    drawPath(
        path = mediumColoredPath,
        color = feature.mediumColor
    )

    drawPath(
        path = lightColoredPath,
        color = feature.lightColor
    )
}

        Box(modifier = Modifier

            .fillMaxSize()
            .padding(15.dp)){
            Text(text = feature.title,
            style = MaterialTheme.typography.bodyMedium,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart))



            Icon(painter = painterResource(id = feature.iconId),

                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart))

            Text(text = "Start",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        //handle click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp))
        }

    }


}



