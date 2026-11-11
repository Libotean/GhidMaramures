package com.example.ghidmaramures.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ghidmaramures.data.PlacesRepository

@Composable
fun FavoritesScreen(
    favoriteIds: Set<Int>,
    onRemove: (Int) -> Unit
) {
    val locuri = PlacesRepository.places.filter { it.id in favoriteIds }

    if (locuri.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize().safeDrawingPadding().padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Nu ai niciun loc la favorite. Deschide un loc din Categorii si apasa „Adauga la favorite”.")
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize().safeDrawingPadding()) {
            items(locuri) { loc ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = loc.nume, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text(text = loc.localitate, fontSize = 14.sp)
                    }
                    TextButton(onClick = { onRemove(loc.id) }) {
                        Text("Elimina")
                    }
                }
            }
        }
    }
}