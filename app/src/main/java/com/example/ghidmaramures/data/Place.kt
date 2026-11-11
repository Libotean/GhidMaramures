package com.example.ghidmaramures.data

enum class Category { Sport, Muzee, Restaurante}

data class Place (
    val id: Int,
    val nume: String,
    val categorie: Category,
    val localitate: String,
    val descriere: String
)