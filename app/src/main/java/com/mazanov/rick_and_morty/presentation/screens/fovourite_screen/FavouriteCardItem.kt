package com.mazanov.rick_and_morty.presentation.screens.fovourite_screenimport androidx.compose.foundation.backgroundimport androidx.compose.foundation.clickableimport androidx.compose.foundation.layout.*import androidx.compose.foundation.shape.RoundedCornerShapeimport androidx.compose.material.Cardimport androidx.compose.material.CircularProgressIndicatorimport androidx.compose.material.MaterialThemeimport androidx.compose.material.Textimport androidx.compose.runtime.Composableimport androidx.compose.ui.Alignmentimport androidx.compose.ui.Modifierimport androidx.compose.ui.draw.clipimport androidx.compose.ui.graphics.Colorimport androidx.compose.ui.layout.ContentScaleimport androidx.compose.ui.text.font.FontWeightimport androidx.compose.ui.unit.dpimport androidx.compose.ui.unit.spimport coil.compose.SubcomposeAsyncImageimport com.mazanov.rick_and_morty.assets.fonts.mainFontimport com.mazanov.rick_and_morty.domain.models.PersonModelimport com.mazanov.rick_and_morty.presentation.navigation.NavigationStateimport com.mazanov.rick_and_morty.presentation.navigation.Screenimport com.mazanov.rick_and_morty.presentation.theme.TitleColor@Composablefun FavouriteCardItem(    cardContent: PersonModel,    navigationState: NavigationState) {    Card(        modifier = Modifier            .clickable { navigationState.navigateTo(Screen.Person.getRouteWithArgs(cardContent)) }            .padding(vertical = 6.dp)            .fillMaxWidth()            .height(175.dp)            .clip(RoundedCornerShape(10.dp)),        backgroundColor = MaterialTheme.colors.onPrimary    ) {        Row(modifier = Modifier.fillMaxSize()) {            SubcomposeAsyncImage(                model = cardContent.image,                contentDescription = "avatar",                modifier = Modifier.size(175.dp),                contentScale = ContentScale.Fit,                loading = {                    Box(                        modifier = Modifier.size(10.dp),                        contentAlignment = Alignment.Center                    ){                        CircularProgressIndicator()                    }                },            )            Column(                modifier = Modifier                    .weight(1f)                    .fillMaxHeight()                    .padding(14.dp),                verticalArrangement = Arrangement.SpaceBetween            ) {                Column {                    Text(                        text = cardContent.name,                        fontSize = 19.sp,                        fontFamily = mainFont,                        color = MaterialTheme.colors.primary                    )                    Row(                        verticalAlignment = Alignment.CenterVertically                    ) {                        val statusColor = when (cardContent.status) {                            "Alive" -> Color.Green                            "Dead" -> Color.Red                            else -> Color.White                        }                        Box(                            modifier = Modifier                                .size(8.dp)                                .clip(RoundedCornerShape(100))                                .background(statusColor)                        )                        Spacer(modifier = Modifier.width(8.dp))                        Text(                            text = "${cardContent.status} - ${cardContent.species}",                            fontSize = 13.sp,                            color = MaterialTheme.colors.primary,                            )                    }                }                Column {                    Text(                        text = "Last known location:",                        fontSize = 13.sp,                        color = TitleColor,                        fontWeight = FontWeight.Bold                    )                    Text(                        text = cardContent.location.name,                        fontSize = 13.sp,                        color = MaterialTheme.colors.primary,                        )                }                Column {                    Text(                        text = "Origin:",                        fontSize = 13.sp,                        color = TitleColor,                        fontWeight = FontWeight.Bold                    )                    Text(                        text = cardContent.origin.name,                        fontSize = 13.sp,                        color = Color.White,                    )                }            }        }    }}