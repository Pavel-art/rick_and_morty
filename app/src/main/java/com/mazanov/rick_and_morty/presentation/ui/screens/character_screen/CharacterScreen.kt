package com.mazanov.rick_and_morty.presentation.ui.screens.character_screenimport android.annotation.SuppressLintimport androidx.compose.foundation.backgroundimport androidx.compose.foundation.layout.*import androidx.compose.foundation.shape.RoundedCornerShapeimport androidx.compose.material.*import androidx.compose.material.icons.Iconsimport androidx.compose.material.icons.filled.ArrowBackimport androidx.compose.runtime.Composableimport androidx.compose.ui.Alignmentimport androidx.compose.ui.Modifierimport androidx.compose.ui.draw.clipimport androidx.compose.ui.graphics.Colorimport androidx.compose.ui.layout.ContentScaleimport androidx.compose.ui.text.font.FontWeightimport androidx.compose.ui.tooling.preview.Previewimport androidx.compose.ui.unit.dpimport androidx.compose.ui.unit.spimport coil.compose.AsyncImageimport com.mazanov.rick_and_morty.assets.fonts.mainFontimport com.mazanov.rick_and_morty.presentation.theme.AppBarColorimport com.mazanov.rick_and_morty.presentation.theme.PersonBackgroundColorimport com.mazanov.rick_and_morty.presentation.theme.TitleColor@Preview@SuppressLint("UnusedMaterialScaffoldPaddingParameter")@Composablefun CharacterScreen() {    Scaffold(        topBar = {            TopAppBar(                backgroundColor = AppBarColor,                modifier = Modifier.height(55.dp),                contentColor = Color.White            ) {                IconButton(onClick = {}) {                    Icon(                        imageVector = Icons.Filled.ArrowBack,                        contentDescription = "Back"                    )                }                Spacer(modifier = Modifier.width(10.dp))                Text(                    text = "Character",                    fontSize = 20.sp,                )            }        }    ) {        Column(            modifier = Modifier                .padding(it)                .fillMaxSize()                .background(PersonBackgroundColor),            horizontalAlignment = Alignment.CenterHorizontally        ) {            Column(                modifier = Modifier.padding(20.dp),                horizontalAlignment = Alignment.CenterHorizontally            ) {                Text(                    text = "Rick",                    fontSize = 30.sp,                    fontFamily = mainFont,                    color = Color.White                )                AsyncImage(                    model = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",                    contentDescription = null,                    modifier = Modifier                        .padding(vertical = 15.dp)                        .size(270.dp)                        .clip(RoundedCornerShape(10.dp)),                    contentScale = ContentScale.Fit,                )                Row(                    verticalAlignment = Alignment.CenterVertically                ) {                    Box(                        modifier = Modifier                            .size(10.dp)                            .clip(RoundedCornerShape(100))                            .background(Color.Green)                    )                    Spacer(modifier = Modifier.width(8.dp))                    Text(                        text = "Alive",                        fontSize = 18.sp,                        color = Color.White,                    )                }                TextInfo(title = "Gender:", info = "Male")                TextInfo(title = "Number of episodes:", info = "1")                TextInfo(title = "Species:", info = "Human")                TextInfo(title = "Last known location:", info = "Earth(C-137)")                TextInfo(title = "Origin", info = "Earth(C-137)")                TextInfo(title = "Was Created:", info = "2017-11-05 10:22:27.446Z")            }        }    }}@Composableprivate fun TextInfo(title: String, info: String) {    Column(        modifier = Modifier.padding(vertical = 9.dp),        horizontalAlignment = Alignment.CenterHorizontally    ) {        Text(            text = title,            fontSize = 14.sp,            color = TitleColor,            fontWeight = FontWeight.Bold        )        Text(            text = info,            fontSize = 14.sp,            color = Color.White,        )    }}