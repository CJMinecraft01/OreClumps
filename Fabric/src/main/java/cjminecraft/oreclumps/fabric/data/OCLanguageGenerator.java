package cjminecraft.oreclumps.fabric.data;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.fabric.common.init.OCBlocks;
import cjminecraft.oreclumps.fabric.common.init.OCItems;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class OCLanguageGenerator implements DataProvider {

    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().setLenient().create();
    
    private final Map<String, String> data = new TreeMap<>();
    
    private final DataGenerator gen;
    private final String locale;

    public OCLanguageGenerator(DataGenerator gen, String locale) {
        this.gen = gen;
        this.locale = locale;
    }
    
    protected void addTranslations() {
        switch (locale) {
            case "en_gb", "en_us" -> {
                add(OCItems.RAW_LEAD, "Raw Lead");
                add(OCItems.RAW_NICKEL, "Raw Nickel");
                add(OCItems.RAW_SILVER, "Raw Silver");
                add(OCItems.RAW_TIN, "Raw Tin");
                add(OCItems.RAW_URANIUM, "Raw Uranium");
                add(OCItems.RAW_OSMIUM, "Raw Osmium");
                add(OCItems.RAW_ZINC, "Raw Zinc");
                add(OCItems.RAW_ALUMINUM, locale.equals("en_us") ? "Raw Aluminum" : "Raw Aluminium");
                add(OCItems.RAW_CHROMIUM, "Raw Chromium");
                add(OCItems.RAW_COBALT, "Raw Cobalt");
                add(OCItems.RAW_PLATINUM, "Raw Platinum");
                add(OCItems.RAW_THORIUM, "Raw Thorium");
                add(OCItems.RAW_TITANIUM, "Raw Titanium");
                add(OCItems.RAW_TUNGSTEN, "Raw Tungsten");
                add(OCItems.RAW_ADAMANTIUM, "Raw Adamantium");
                add(OCItems.RAW_MYTHRIL, "Raw Mythril");
                add(OCItems.RAW_QUICKSILVER, "Raw Quicksilver");
                add(OCItems.RAW_FROSTSTEEL, "Raw Frost Steel");
                add(OCItems.RAW_CLOGGRUM, "Raw Cloggrum");

                add(OCBlocks.RAW_LEAD_BLOCK, "Block of Raw Lead");
                add(OCBlocks.RAW_NICKEL_BLOCK, "Block of Raw Nickel");
                add(OCBlocks.RAW_SILVER_BLOCK, "Block of Raw Silver");
                add(OCBlocks.RAW_TIN_BLOCK, "Block of Raw Tin");
                add(OCBlocks.RAW_URANIUM_BLOCK, "Block of Raw Uranium");
                add(OCBlocks.RAW_OSMIUM_BLOCK, "Block of Raw Osmium");
                add(OCBlocks.RAW_ZINC_BLOCK, "Block of Raw Zinc");
                add(OCBlocks.RAW_ALUMINUM_BLOCK, locale.equals("en_us") ? "Block of Raw Aluminum" : "Block of Raw Aluminium");
                add(OCBlocks.RAW_CHROMIUM_BLOCK, "Block of Raw Chromium");
                add(OCBlocks.RAW_COBALT_BLOCK, "Block of Raw Cobalt");
                add(OCBlocks.RAW_PLATINUM_BLOCK, "Block of Raw Platinum");
                add(OCBlocks.RAW_THORIUM_BLOCK, "Block of Raw Thorium");
                add(OCBlocks.RAW_TITANIUM_BLOCK, "Block of Raw Titanium");
                add(OCBlocks.RAW_TUNGSTEN_BLOCK, "Block of Raw Tungsten");
                add(OCBlocks.RAW_ADAMANTIUM_BLOCK, "Block of Raw Adamantium");
                add(OCBlocks.RAW_MYTHRIL_BLOCK, "Block of Raw Mythril");
                add(OCBlocks.RAW_QUICKSILVER_BLOCK, "Block of Raw Quicksilver");
                add(OCBlocks.RAW_FROSTSTEEL_BLOCK, "Block of Raw Frost Steel");
                add(OCBlocks.RAW_CLOGGRUM_BLOCK, "Block of Raw Cloggrum");
            }
        }
    }

    @Override
    public void run(@NotNull CachedOutput cache) throws IOException {
        addTranslations();
        if (!data.isEmpty())
            save(cache, this.gen.getOutputFolder().resolve("assets/" + Constants.MODID + "/lang/" + locale + ".json"));
    }

    @Override
    public String getName() {
        return "Languages: " + locale;
    }

    private void save(CachedOutput cache, Path target) throws IOException {
        JsonObject json = new JsonObject();
        for (Map.Entry<String, String> pair : data.entrySet()) {
            json.addProperty(pair.getKey(), pair.getValue());
        }

        DataProvider.saveStable(cache, json, target);
    }

    public void add(Item key, String name) {
        add(key.getDescriptionId(), name);
    }

    public void add(Block key, String name) {
        add(key.getDescriptionId(), name);
    }

    public void add(String key, String value) {
        if (data.put(key, value) != null)
            throw new IllegalStateException("Duplicate translation key " + key);
    }
}
