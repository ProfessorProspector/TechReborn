package techreborn.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import techreborn.blocks.*;
import techreborn.client.TechRebornCreativeTab;
import techreborn.itemblocks.ItemBlockMachineCasing;
import techreborn.itemblocks.ItemBlockOre;
import techreborn.itemblocks.ItemBlockQuantumChest;
import techreborn.itemblocks.ItemBlockQuantumTank;
import techreborn.itemblocks.ItemBlockStorage;
import techreborn.tiles.*;
import techreborn.util.LogHelper;

public class ModBlocks {

    public static Block thermalGenerator;
    public static Block quantumTank;
    public static Block quantumChest;
    public static Block centrifuge;
    public static Block RollingMachine;
    public static Block MachineCasing;
    public static Block BlastFurnace;

    public static Block ore;
    public static Block storage;

    public static void init() {
        thermalGenerator = new BlockThermalGenerator().setBlockName("techreborn.thermalGenerator").setBlockTextureName("techreborn:ThermalGenerator_other").setCreativeTab(TechRebornCreativeTab.instance);
        GameRegistry.registerBlock(thermalGenerator, "techreborn.thermalGenerator");
        GameRegistry.registerTileEntity(TileThermalGenerator.class, "TileThermalGenerator");

        quantumTank = new BlockQuantumTank().setBlockName("techreborn.quantumTank").setBlockTextureName("techreborn:quantumTank").setCreativeTab(TechRebornCreativeTab.instance);
        GameRegistry.registerBlock(quantumTank, ItemBlockQuantumTank.class, "techreborn.quantumTank");
        GameRegistry.registerTileEntity(TileQuantumTank.class, "TileQuantumTank");

        quantumChest = new BlockQuantumChest().setBlockName("techreborn.quantumChest").setBlockTextureName("techreborn:quantumChest").setCreativeTab(TechRebornCreativeTab.instance);
        GameRegistry.registerBlock(quantumChest, ItemBlockQuantumChest.class, "techreborn.quantumChest");
        GameRegistry.registerTileEntity(TileQuantumChest.class, "TileQuantumChest");

        centrifuge = new BlockCentrifuge().setBlockName("techreborn.centrifuge").setBlockTextureName("techreborn:centrifuge").setCreativeTab(TechRebornCreativeTab.instance);
        GameRegistry.registerBlock(centrifuge, "techreborn.centrifuge");
        GameRegistry.registerTileEntity(TileCentrifuge.class, "TileCentrifuge");

        RollingMachine = new BlockRollingMachine(Material.piston);
        GameRegistry.registerBlock(RollingMachine, "rollingmachine");
        GameRegistry.registerTileEntity(TileRollingMachine.class, "TileRollingMachine");
        
        BlastFurnace = new BlockBlastFurnace(Material.piston);
        GameRegistry.registerBlock(BlastFurnace, "blastFurnace");
        
        MachineCasing = new BlockMachineCasing(Material.piston);
        GameRegistry.registerBlock(MachineCasing, ItemBlockMachineCasing.class, "machinecasing");

        ore = new BlockOre(Material.rock);
        GameRegistry.registerBlock(ore, ItemBlockOre.class, "techreborn.ore");
        LogHelper.info("TechReborns Blocks Loaded");

        storage = new BlockStorage(Material.rock);
        GameRegistry.registerBlock(storage, ItemBlockStorage.class, "techreborn.storage");
        LogHelper.info("TechReborns Blocks Loaded");

        registerOreDict();
    }

    public static void registerOreDict() {
        OreDictionary.registerOre("oreGalena", new ItemStack(ore, 1, 0));
        OreDictionary.registerOre("oreIridium", new ItemStack(ore, 1, 1));
        OreDictionary.registerOre("oreRuby", new ItemStack(ore, 1, 2));
        OreDictionary.registerOre("oreSapphire", new ItemStack(ore, 1, 3));
        OreDictionary.registerOre("oreBauxite", new ItemStack(ore, 1, 4));
        OreDictionary.registerOre("orePyrite", new ItemStack(ore, 1, 5));
        OreDictionary.registerOre("oreCinnabar", new ItemStack(ore, 1, 6));
        OreDictionary.registerOre("oreSphalerite", new ItemStack(ore, 1, 7));
        OreDictionary.registerOre("oreTungston", new ItemStack(ore, 1, 8));
        OreDictionary.registerOre("oreSheldonite", new ItemStack(ore, 1, 9));
        OreDictionary.registerOre("oreOlivine", new ItemStack(ore, 1, 10));
        OreDictionary.registerOre("oreSodalite", new ItemStack(ore, 1, 11));

        OreDictionary.registerOre("blockSilver", new ItemStack(storage, 1, 0));
        OreDictionary.registerOre("blockAluminium", new ItemStack(storage, 1, 1));
        OreDictionary.registerOre("blockTitanium", new ItemStack(storage, 1, 2));
        OreDictionary.registerOre("blockSapphire", new ItemStack(storage, 1, 3));
        OreDictionary.registerOre("blockRuby", new ItemStack(storage, 1, 4));
        OreDictionary.registerOre("blockGreenSapphire", new ItemStack(storage, 1, 5));
        OreDictionary.registerOre("blockChrome", new ItemStack(storage, 1, 6));
        OreDictionary.registerOre("blockElectrum", new ItemStack(storage, 1, 7));
        OreDictionary.registerOre("blockTungsten", new ItemStack(storage, 1, 8));
        OreDictionary.registerOre("blockLead", new ItemStack(storage, 1, 9));
        OreDictionary.registerOre("blockZinc", new ItemStack(storage, 1, 10));
        OreDictionary.registerOre("blockBrass", new ItemStack(storage, 1, 11));
        OreDictionary.registerOre("blockSteel", new ItemStack(storage, 1, 12));
        OreDictionary.registerOre("blockPlatinum", new ItemStack(storage, 1, 13));
        OreDictionary.registerOre("blockNickel", new ItemStack(storage, 1, 14));
        OreDictionary.registerOre("blockInvar", new ItemStack(storage, 1, 15));

    }

}
