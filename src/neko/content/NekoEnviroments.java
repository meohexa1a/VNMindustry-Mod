package neko.content;

import arc.util.Log;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.StaticWall;

public class NekoEnviroments {
    public static final int total_wall_pack = 5;
    public static final int total_floor_pack = 7;

    public static void load() {
        // Ore loader
        
        // Wall pack loader
        try {
            for (int count = 1; count <= total_wall_pack; count++) {
                int counT = count;
                new StaticWall(count + "_" + 1) {{
                    size = 1;
                    localizedName = "Wall " + counT + " 1x1";
                }};
                new StaticWall(count + "_" + 2) {{
                    size = 2;
                    localizedName = "Wall " + counT + " 2x2";
                }};
            }
        } catch (Exception e) {
            Log.err("Have some trouble loading wall pack", e);
        }

        // Floor pack loader 
        try {
            for (int count = 0; count <= total_floor_pack; count++) {
                int counT = count;
                new Floor(counT + "") {{
                    localizedName = "Floor" + counT;
                }};
            }
        } catch (Exception e) {
            Log.err("Have some trouble loading floor pack", e);
        }
    }
}
