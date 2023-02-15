package com.example.cocktailsappspil.domain

import com.example.cocktailsappspil.rest.model.drinks.DrinkResult
import java.lang.Math.random

/**
 * Data class that defines a drink
 */
data class Drink(
    val drinkId: String,
    val alcoholic: Alcoholic,
    val category: Category,
    val drinkName: String?,
    val drinkThumb: String?,
    val glass: Glass,
    val ingredients: List<Ingredient>?,
    val measures: List<String?>?,
    val instructions: String?,
    val isFavorite: Boolean = false
)

fun DrinkResult?.mapToDrink(): Drink{

    val ingredientsList = mutableListOf(
        Ingredient(this?.strIngredient1,"www.thecocktaildb.com/images/ingredients/${this?.strIngredient1}-Small.png"),
        Ingredient(this?.strIngredient2,"www.thecocktaildb.com/images/ingredients/${this?.strIngredient2}-Small.png"),
        Ingredient(this?.strIngredient3,"www.thecocktaildb.com/images/ingredients/${this?.strIngredient3}-Small.png"),
        Ingredient(this?.strIngredient4,"www.thecocktaildb.com/images/ingredients/${this?.strIngredient4}-Small.png"),
        Ingredient(this?.strIngredient5,"www.thecocktaildb.com/images/ingredients/${this?.strIngredient5}-Small.png"),
        Ingredient(this?.strIngredient6,"www.thecocktaildb.com/images/ingredients/${this?.strIngredient6}-Small.png"),
        Ingredient(this?.strIngredient7,"www.thecocktaildb.com/images/ingredients/${this?.strIngredient7}-Small.png"),
        Ingredient(this?.strIngredient8,"www.thecocktaildb.com/images/ingredients/${this?.strIngredient8}-Small.png"),
        Ingredient(this?.strIngredient9,"www.thecocktaildb.com/images/ingredients/${this?.strIngredient9}-Small.png"),
        Ingredient(this?.strIngredient10,"www.thecocktaildb.com/images/ingredients/${this?.strIngredient10}-Small.png"),
        Ingredient(this?.strIngredient11,"www.thecocktaildb.com/images/ingredients/${this?.strIngredient11}-Small.png"),
        Ingredient(this?.strIngredient12,"www.thecocktaildb.com/images/ingredients/${this?.strIngredient12}-Small.png"),
        Ingredient(this?.strIngredient13,"www.thecocktaildb.com/images/ingredients/${this?.strIngredient13}-Small.png"),
        Ingredient(this?.strIngredient14,"www.thecocktaildb.com/images/ingredients/${this?.strIngredient14}-Small.png"),
        Ingredient(this?.strIngredient15,"www.thecocktaildb.com/images/ingredients/${this?.strIngredient15}-Small.png")
    )
    ingredientsList.forEach{
        if(it.ingredientName == null)
            ingredientsList.remove(it)
    }

    val measuresList = mutableListOf(
        this?.strMeasure1,
        this?.strMeasure2,
        this?.strMeasure3,
        this?.strMeasure4,
        this?.strMeasure5,
        this?.strMeasure6,
        this?.strMeasure7,
        this?.strMeasure8,
        this?.strMeasure9,
        this?.strMeasure10,
        this?.strMeasure11,
        this?.strMeasure12,
        this?.strMeasure13,
        this?.strMeasure14,
        this?.strMeasure15,
    )
    measuresList.forEach{
        if(it == null){
            measuresList.remove(it)
        }
    }

    return Drink(
        this?.idDrink ?: random().toString(),
        Alcoholic(this?.strAlcoholic),
        Category(this?.strCategory),
        this?.strDrink,
        this?.strDrinkThumb+"/preview",
        Glass(this?.strGlass),
        ingredientsList,
        measuresList,
        this?.strInstructions
    )

}