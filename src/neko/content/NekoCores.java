package neko.content;

import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;

public class NekoCores {
    public static Block menethik, centrum, potronagas;

    public static void load() {
        menethik = new CoreBlock("Menethik") {{
            localizedName = "Core: Menethik platform";
            size = 4;
        }};
    }
}
