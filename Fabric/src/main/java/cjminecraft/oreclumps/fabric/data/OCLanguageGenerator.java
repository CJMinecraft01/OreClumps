package cjminecraft.oreclumps.fabric.data;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.fabric.common.init.OCItems;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.world.item.Item;
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

    public void add(String key, String value) {
        if (data.put(key, value) != null)
            throw new IllegalStateException("Duplicate translation key " + key);
    }
}
