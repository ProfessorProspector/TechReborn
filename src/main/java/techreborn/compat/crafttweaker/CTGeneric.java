/*
 * This file is part of TechReborn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2017 TechReborn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package techreborn.compat.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.item.ItemStack;
import reborncore.api.recipe.IBaseRecipeType;
import reborncore.api.recipe.RecipeHandler;
import reborncore.common.util.ItemUtils;
import techreborn.api.recipe.BaseRecipe;

import java.util.ArrayList;
import java.util.List;

public class CTGeneric {
	public static String getMachineName() {
		return null;
	}

	public static void addRecipe(BaseRecipe recipe) {
		CraftTweakerAPI.apply(new Add(recipe));
	}

	private static class Add implements IAction {
		private final BaseRecipe recipe;

		public Add(BaseRecipe recipe) {
			this.recipe = recipe;
		}

		@Override
		public void apply() {
			RecipeHandler.addRecipe(recipe);
		}

		@Override
		public String describe() {
			return "Adding " + recipe.getRecipeName() + " recipe for " + recipe.getOutput(0).getDisplayName();
		}
	}

	public static class Remove implements IAction {
		private final ItemStack output;
		List<BaseRecipe> removedRecipes = new ArrayList<BaseRecipe>();
		private final String name;

		public Remove(ItemStack output, String machineName) {
			this.output = output;
			this.name = machineName;
		}

		@Override
		public void apply() {
			for (IBaseRecipeType recipeType : RecipeHandler.getRecipeClassFromName(name)) {
				for (ItemStack stack : recipeType.getOutputs()) {
					if (ItemUtils.isItemEqual(stack, output, true, false)) {
						removedRecipes.add((BaseRecipe) recipeType);
						RecipeHandler.recipeList.remove(recipeType);
						break;
					}
				}
			}
		}

		@Override
		public String describe() {
			return "Removing " + name + " recipe for " + output.getDisplayName();
		}
	}

	public static class RemoveInput implements IAction {
		private final IIngredient output;
		List<BaseRecipe> removedRecipes = new ArrayList<BaseRecipe>();
		private final String name;

		public RemoveInput(IIngredient output, String machineName) {
			this.output = output;
			this.name = machineName;
		}

		@Override
		public void apply() {
			for (IBaseRecipeType recipeType : RecipeHandler.getRecipeClassFromName(name)) {
				for (Object stack : recipeType.getInputs()) {
					if (stack instanceof ItemStack) {
						if (output.matches(CraftTweakerMC.getIItemStack((ItemStack) stack))) {
							removedRecipes.add((BaseRecipe) recipeType);
							RecipeHandler.recipeList.remove(recipeType);
							break;
						}
					}
				}
			}
		}

		@Override
		public String describe() {
			return "Removing " + name + " recipe";
		}

	}
}
