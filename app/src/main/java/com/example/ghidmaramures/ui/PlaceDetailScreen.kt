package com.example.ghidmaramures.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ghidmaramures.data.PlacesRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceDetailScreen(
    placeId: Int,
    isFavorite: Boolean,
    onToggleFavorite: () -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalii") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Inapoi")
                    }
                }
            )
        }
    ) { innerPadding ->
        val place = PlacesRepository.getPlace(placeId)

        if (place == null) {
            Text(
                text = "Locul nu a fost gasit",
                modifier = Modifier.padding(innerPadding).padding(16.dp)
            )
        } else {
            Column(
                modifier = Modifier.padding(innerPadding).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = place.nume, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(text = "Categorie: ${place.categorie.name}", fontSize = 16.sp)
                Text(text = "Localitate: ${place.localitate}", fontSize = 16.sp)
                Text(text = place.descriere, fontSize = 16.sp)

                Button(onClick = onToggleFavorite) {
                    Text(if (isFavorite) "Elimina din favorite" else "Adauga la favorite")
                }
            }
        }
    }
}