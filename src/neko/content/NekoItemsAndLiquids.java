package neko.content;

import arc.graphics.Color;
import mindustry.type.Item;
import mindustry.type.Liquid;

public class NekoItemsAndLiquids {
    public static Item cophalast, duras, fabris, faras,
    flaxol, glass, navitas, pausis, 
    rudis, simus, tentias, vastum, xearula;
    public static Liquid barbavior, fortial, horani, viscosy;

    public static void load() {
        cophalast = new Item("Cophalast", Color.valueOf("fab04b")) {{
            localizedName = "Cophalast";
        }};

        duras = new Item("Duras", Color.valueOf("c297f8")) {{
            localizedName = "Duras";
        }};

        fabris = new Item("Fabris", Color.valueOf("99d380")) {{
            localizedName = "Fabris";
        }};

        faras = new Item("Faras", Color.valueOf("77808d")) {{
            localizedName = "Faras";
        }};

        flaxol = new Item("Flaxol", Color.valueOf("afb4ba")) {{
            localizedName = "Flaxol";
        }};

        glass = new Item("Glass", Color.valueOf("d1dfdf")) {{
            localizedName = "Cold Resistant Glass";
        }};

        navitas = new Item("Navitas", Color.valueOf("c9e4ff")) {{
            localizedName = "Navitas";
        }};

        pausis = new Item("Pausis", Color.valueOf("e25c42")) {{
            localizedName = "Pausis";
        }};

        rudis = new Item("Rudis", Color.valueOf("95494f")) {{
            localizedName = "Rudis";
        }};

        simus = new Item("Simus", Color.valueOf("e29e6a")) {{
            localizedName = "Simus";
        }};

        tentias = new Item("Tentias", Color.valueOf("5d6465")) {{
            localizedName = "Tentias";
        }};

        vastum = new Item("Vastum", Color.valueOf("86bead")) {{
            localizedName = "Vastum";
        }};

        xearula = new Item("Xearula", Color.valueOf("abbcfd")) {{
            localizedName = "Xearula";
        }};

        barbavior = new Liquid("Barbavior", Color.valueOf("c5eaa0")) {{
            localizedName = "Barbavior";
        }};

        fortial = new Liquid("Fortial", Color.valueOf("92b8cd")) {{
            localizedName = "Fortial";
        }};

        horani = new Liquid("Horani", Color.valueOf("c4cdce")) {{
            localizedName = "Horani";
        }};

        viscosy = new Liquid("Viscosy", Color.valueOf("ffaab2")) {{
            localizedName = "Viscosy";
        }};
    }
}