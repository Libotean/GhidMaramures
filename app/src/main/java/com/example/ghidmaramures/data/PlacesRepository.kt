package com.example.ghidmaramures.data

object PlacesRepository {
    val places = listOf(
        Place(1, "Muzeul Satului Maramuresean", Category.Muzee, "Sighetu Marmatiei", "descriere..."),
        Place(2, "Domeniul schiabil Cavnic", Category.Sport, "Cavnic", "descriere..."),
        Place(3, "Muzeul Judetean de Istorie si Arheologie Maramures", Category.Muzee, "Baia Mare", "descriere..."),
        Place(4, "Statiunea Borsa", Category.Sport, "Borsa", "schi, drumetii"),
        Place(5, "Savoury", Category.Restaurante, "Baia Mare", "descriere..."),
        Place(6, "Memorialul victimelor comunismului si al rezistentei", Category.Muzee, "Sighetu Marmatiei", "descriere..."),
        Place(7, "Parcul National Muntii Rodnei", Category.Sport, "Borsa/Moisei", "descriere..."),
        Place(8, "Buonissimo", Category.Restaurante, "Baia Mare", "descriere..."),
        Place(9, "Bizo", Category.Restaurante, "Baia Mare", "descriere...")
    )

    fun getPlace(id: Int): Place? = places.find { it.id == id }
}