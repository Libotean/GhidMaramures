package com.example.ghidmaramures.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ghidmaramures.data.Category
import com.example.ghidmaramures.data.PlacesRepository

@Composable
fun PlaceListScreen(
    selectedCategory: Category?,
    onCategorySelected: (Category?) -> Unit,
    onPlaceClick: (Int) -> Unit
) {
    val locuri = if (selectedCategory == null) PlacesRepository.places
    else PlacesRepository.places.filter { it.categorie == selectedCategory }

    Column(modifier = Modifier.fillMaxSize().safeDrawingPadding()) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedCategory == null,
                onClick = { onCategorySelected(null) },
                label = { Text("Toate") }
            )
            Category.entries.forEach { categorie ->
                FilterChip(
                    selected = selectedCategory == categorie,
                    onClick = { onCategorySelected(categorie) },
                    label = { Text(categorie.name) }
                )
            }
        }
        LazyColumn(modifier = Modifier.weight(1f).fillMaxWidth()) {
            items(locuri) { loc ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onPlaceClick(loc.id) }
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                ) {
                    Text(text = loc.nume, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = "${loc.categorie.name} · ${loc.localitate}", fontSize = 14.sp)
                }
            }
        }
    }
}