package com.example.loot.Service;

import com.example.loot.Model.Ingredient;
import com.example.loot.Repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//0 ingredient not found
//1 success
//2 ingredient name already taken

    public class IngredientService {

    private final IngredientRepository ingredientRepository;


    public List<Ingredient> getIngredients(){
        return ingredientRepository.findAll();
    }


    public int addIngredient(Ingredient ingredient){

        Ingredient oldIngredient = ingredientRepository.findIngredientByName(ingredient.getName());

        //name taken
        if(oldIngredient != null){
            return 2;
        }

        ingredientRepository.save(ingredient);
        //added
        return 1;
    }


    public int editIngredient(Integer id, Ingredient ingredient){

        Ingredient oldIngredient = ingredientRepository.findIngredientById(id);

        //ingredient not found
        if(oldIngredient == null){
            return 0;
        }

        //name taken by another ingredient
        Ingredient nameCheck = ingredientRepository.findIngredientByName(ingredient.getName());

        if(nameCheck != null && !nameCheck.getId().equals(id)){
            return 2;
        }

        oldIngredient.setName(ingredient.getName());
        oldIngredient.setUnit(ingredient.getUnit());

        ingredientRepository.save(oldIngredient);
        //updated
        return 1;
    }


    public int deleteIngredient(int id){

        Ingredient oldIngredient = ingredientRepository.findIngredientById(id);

        //ingredient not found
        if(oldIngredient == null){
            return 0;
        }

        ingredientRepository.delete(oldIngredient);
        //deleted
        return 1;
    }
}
