package neko;

import mindustry.mod.Mod;
import neko.content.NekoContentLoader;

public class NekoMod extends Mod {
    @Override
    public void loadContent() {
        NekoContentLoader.load();
    }
}
