package neko.content;

import static mindustry.type.ItemStack.with;
import static neko.content.NekoItemsAndLiquids.*;

import arc.graphics.Color;
import mindustry.content.UnitTypes;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.BuildTurret;
import mindustry.world.blocks.defense.RegenProjector;
import mindustry.world.blocks.defense.ShockwaveTower;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.distribution.BufferedItemBridge;
import mindustry.world.blocks.distribution.Conveyor;
import mindustry.world.blocks.distribution.MassDriver;
import mindustry.world.blocks.distribution.OverflowGate;
import mindustry.world.blocks.distribution.Sorter;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.liquid.LiquidJunction;
import mindustry.world.blocks.liquid.LiquidRouter;
import mindustry.world.blocks.logic.LogicBlock;
import mindustry.world.blocks.logic.LogicDisplay;
import mindustry.world.blocks.logic.MemoryBlock;
import mindustry.world.blocks.logic.MessageBlock;
import mindustry.world.blocks.power.Battery;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.ImpactReactor;
import mindustry.world.blocks.power.NuclearReactor;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.production.BeamDrill;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.SolidPump;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawGlowRegion;
import mindustry.world.draw.DrawLiquidTile;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawPulseShape;
import mindustry.world.draw.DrawRegion;
import mindustry.world.draw.DrawShape;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.Env;

public class NekoBlocks {
    public static Block // drill

    cophalastDrill, farasDrill, xearulaDrill,
            durasBeam, flaxolLaserBeam,
            barbaviorDrill,

            // transport
            cophalastConveyor, farasConveyor, cophalastBridge,
            cophalastFlow, cophalastUnderFlow, cophalastSorter,
            farasDriver, xearulaDriver,

            // liquid
            cophalastConduit, farasConduit, cophalastLiquidBridge,
            cophalastLiquidRouter, cophalastLiquidContainer,
            cophalastLiquidTank,

            // power
            smallNode, largeNode,
            diffGen, flaxolGen, atomicGen, battery,

            // defensive (wall)
            cophalastWall, cophalastBigWall, farasWall, farasBigWall,
            xearulaWall, xearulaBigWall, tentiasWall, tentiasBigWall,
            flukemashWall, vastumBigWall,

            // factorys
            electrolysis, fabrisFactory, tentiasFactory, vastumFactory,

            // effect
            menethik, mantimela, potronagas,
            repairField, bigRepairField, shieldFileld, damageField,
            buildTower, smallContainer, bigContainer, unloader,

            // logic
            smallProcessor, processor, bigProcessor,
            dataCell, dataBank, display, messsge;

    public static void load() {
        // region drill
        cophalastDrill = new Drill("Cophalast-drill") {
            {
                localizedName = "Cophalast Drill";
                size = 2;
                tier = 2;
                drillTime = 600f;
                requirements(Category.production, with(cophalast, 10));
            }
        };

        durasBeam = new BeamDrill("duras-beam") {
            {
                localizedName = "duras Beam Drill";
                size = 2;
                tier = 2;
                drillTime = 600f;
                requirements(Category.production, with(cophalast, 10, duras, 10, fabris, 10));
                consumePower(1f);
            }
        };

        farasDrill = new Drill("faras-drill") {
            {
                localizedName = "faras Drill";
                size = 3;
                tier = 5;
                drillTime = 600f;
                requirements(Category.production, with(cophalast, 10, duras, 10, fabris, 10, faras, 10));
                consumePower(5f);
            }
        };

        flaxolLaserBeam = new BeamDrill("flaxol-beam") {
            {
                localizedName = "flaxol Laser";
                size = 3;
                tier = 5;
                drillTime = 600f;
                requirements(Category.production, with(cophalast, 10, duras, 10, fabris, 10, flaxol, 10));
                consumePower(5f);
            }
        };

        xearulaDrill = new Drill("xearula-drill") {
            {
                localizedName = "xearula Harderness Drill";
                size = 4;
                tier = 7;
                drillTime = 600f;
                requirements(Category.production, with(cophalast, 10, duras, 10, fabris, 10, faras, 10));
                consumePower(5f);
            }
        };

        barbaviorDrill = new SolidPump("barbavior-extractor") {
            {
                requirements(Category.production, with(cophalast, 10, duras, 10));
                result = barbavior;
                pumpAmount = 1f;
                localizedName = "barbavior extractor";
                size = 2;
                liquidCapacity = 600f;
                attribute = Attribute.water;
                envRequired |= Env.groundWater;
                consumeItem(pausis);
            }
        };

        // region transport
        cophalastConveyor = new Conveyor("Cophalast-conveyor") {
            {
                localizedName = "Cophalast Conveyor";
                requirements(Category.distribution, with(cophalast, 1));
                health = 45;
                speed = 0.1f;
                displayedSpeed = 14f;
            }
        };

        farasConveyor = new Conveyor("faras-conveyor") {
            {
                localizedName = "faras Conveyor";
                requirements(Category.distribution, with(cophalast, 1));
                health = 45;
                speed = 0.15f;
                displayedSpeed = 21f;
            }
        };

        cophalastSorter = new Sorter("Cophalast-sorter") {
            {
                localizedName = "Cophalast Sorter";
                requirements(Category.distribution, with(cophalast, 2));
            }
        };

        cophalastBridge = new BufferedItemBridge("Cophalast-bridge") {
            {
                localizedName = "Cophalast Bridge";
                requirements(Category.distribution, with(cophalast, 10));
                fadeIn = moveArrows = false;
                range = 6;
                speed = 100f;
                arrowSpacing = 6f;
                bufferCapacity = 25;
            }
        };

        cophalastFlow = new OverflowGate("Cophalast-flow") {
            {
                localizedName = "Cophalast Flow Gate";
                requirements(Category.distribution, with(cophalast, 5));
            }
        };

        cophalastUnderFlow = new OverflowGate("Cophalast-underflow") {
            {
                localizedName = "Cophalast Underflow Gate";
                requirements(Category.distribution, with(cophalast, 5));
                invert = true;
            }
        };

        farasDriver = new MassDriver("faras-driver") {
            {
                localizedName = "faras Mass Driver";
                requirements(Category.distribution,
                        with(faras, 100, duras, 50, fabris, 50));
                size = 3;
                itemCapacity = 200;
                reload = 250f;
                range = 440f;
                consumePower(1.75f);
            }
        };

        xearulaDriver = new MassDriver("xearula-driver") {
            {
                localizedName = "xearula Mass Driver";
                requirements(Category.distribution,
                        with(faras, 100, duras, 50, fabris, 50));
                size = 4;
                itemCapacity = 350;
                reload = 350f;
                range = 520f;
                consumePower(2.5f);
            }
        };

        // region liquid

        cophalastConduit = new Conduit("Cophalast-conduit") {
            {
                localizedName = "Cophalast Conduit";
                requirements(Category.liquid, with(cophalast, 2));
            }
        };

        farasConduit = new Conduit("faras-conduit") {
            {
                localizedName = "faras Conduit";
                requirements(Category.liquid, with(faras, 2));
                liquidCapacity = 16f;
                liquidPressure = 1.025f;
            }
        };

        cophalastLiquidRouter = new LiquidRouter("Cophalast-liquid-router") {
            {
                localizedName = "Cophalast Router";
                requirements(Category.liquid, with(cophalast, 10));
                liquidCapacity = 20f;
                underBullets = true;
                solid = false;
            }
        };

        cophalastLiquidBridge = new LiquidJunction("Cophalast-liquid-bridge") {
            {
                localizedName = "Cophalast Bridge";
                requirements(Category.liquid, with(cophalast, 20));
                solid = false;
            }
        };

        cophalastLiquidContainer = new LiquidRouter("Cophalast-liquid-container") {
            {
                localizedName = "Cophalast Container";
                requirements(Category.liquid, with(cophalast, 200));
                liquidCapacity = 2000f;
                size = 2;
                solid = true;
            }
        };

        cophalastLiquidTank = new LiquidRouter("Cophalast-liquid-tank") {
            {
                localizedName = "Cophalast Tank";
                requirements(Category.liquid, with(cophalast, 400));
                liquidCapacity = 3200f;
                size = 3;
                solid = true;
            }
        };

        // region power

        diffGen = new ConsumeGenerator("Diff-gen") {
            {
                localizedName = "Different Generator (f)";
                requirements(Category.power, with(cophalast, 10, duras, 10));
                powerProduction = 18f;
                itemDuration = 60f;
                hasLiquids = true;
                hasItems = true;
                size = 5;

                consumeItem(pausis);
                consumeLiquid(barbavior, 6f / 60f);
            }
        };

        flaxolGen = new NuclearReactor("flaxol-gen") {
            {
                localizedName = "flaxol Energy Core Generator";
                requirements(Category.power, with(cophalast, 10));
                size = 5;
                itemDuration = 600f;
                powerProduction = 50f;

                consumeItem(flaxol);
                itemCapacity = 50;
                consumeLiquid(viscosy, 0.1f);
            }
        };

        atomicGen = new ImpactReactor("Atomic Generator") {
            {
                localizedName = "Atomic Generator";
                requirements(Category.power, with(cophalast, 10));
                size = 6;
                powerProduction = 200f;
                itemDuration = 60f;
                liquidCapacity = 300f;
                itemCapacity = 20;

                consumePower(25f);
                consumeLiquid(horani, 1f);
            }
        };

        battery = new Battery("Battery") {
            {
                requirements(Category.power, with(cophalast, 10, duras, 10));
                consumePowerBuffered(4000f);
                baseExplosiveness = 1f;
            }
        };

        smallNode = new PowerNode("Small-node") {
            {
                localizedName = "Small Node";
                requirements(Category.power, with(cophalast, 1, duras, 3));
                maxNodes = 10;
                laserRange = 10;
            }
        };

        largeNode = new PowerNode("Large-node") {
            {
                localizedName = "Large Node";
                requirements(Category.power, with(cophalast, 10, duras, 5, fabris, 5));
                size = 2;
                maxNodes = 15;
                laserRange = 20f;
            }
        };

        // region defensive

        cophalastWall = new Wall("Cophalast-wall") {
            {
                localizedName = "Cophalast Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                envDisabled |= Env.scorching;
                size = 2;
            }
        };

        cophalastBigWall = new Wall("Cophalast-big-wall") {
            {
                localizedName = "Cophalast Big Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                envDisabled |= Env.scorching;
                size = 3;
            }
        };

        farasWall = new Wall("faras-wall") {
            {
                localizedName = "faras Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                envDisabled |= Env.scorching;
                size = 2;
            }
        };

        farasBigWall = new Wall("faras-big-wall") {
            {
                localizedName = "faras Big Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                envDisabled |= Env.scorching;
                size = 3;
            }
        };

        xearulaWall = new Wall("xearula-wall") {
            {
                localizedName = "xearula Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                absorbLasers = true;
                envDisabled |= Env.scorching;
                size = 2;
            }
        };

        xearulaBigWall = new Wall("xearula-big-wall") {
            {
                localizedName = "xearula Big Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                absorbLasers = true;
                envDisabled |= Env.scorching;
                size = 3;
            }
        };

        tentiasWall = new Wall("tentias-wall") {
            {
                localizedName = "tentias Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                lightningChance = 0.5f;
                envDisabled |= Env.scorching;
                size = 2;
            }
        };

        tentiasBigWall = new Wall("tentias-big-wall") {
            {
                localizedName = "tentias Big Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                lightningChance = 0.75f;
                envDisabled |= Env.scorching;
                size = 3;
            }
        };

        flukemashWall = new Wall("vastum-wall") {
            {
                localizedName = "vastum Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                chanceDeflect = 30f;
                flashHit = true;
                envDisabled |= Env.scorching;
                size = 2;
            }
        };

        vastumBigWall = new Wall("vastum-big-wall") {
            {
                localizedName = "vastum Big Wall";
                requirements(Category.defense, with(cophalast, 10));
                chanceDeflect = 60f;
                flashHit = true;
                health = 80;
                envDisabled |= Env.scorching;
                size = 3;
            }
        };

        // region factory

        electrolysis = new GenericCrafter("Electrolysis") {
            {
                localizedName = "Eletrolysis Plant";
                requirements(Category.crafting, with(cophalast, 10, duras, 10));
                size = 3;
                craftTime = 10f;
                rotate = true;
                invertFlip = true;
                liquidCapacity = 50f;

                consumeLiquid(barbavior, 10f / 60f);
                consumePower(1f);

                regionRotated1 = 3;
                outputLiquids = LiquidStack.with(viscosy, 4f / 60f, horani, 6f / 60f);
                liquidOutputDirections = new int[] { 1, 3 };
            }
        };

        fabrisFactory = new GenericCrafter("fabris-factory") {
            {
                localizedName = "fabris Refining Furnace";
                requirements(Category.crafting, with(cophalast, 10, duras, 10));

                outputItem = new ItemStack(fabris, 3);
                craftTime = 90f;
                size = 3;

                consumeItems(with(pausis, 3, rudis, 5));
                consumePower(1f);
            }
        };

        tentiasFactory = new GenericCrafter("tentias-factory") {
            {
                localizedName = "tentias Alloy Mixer Factory";
                requirements(Category.crafting, with(cophalast, 10, duras, 10));

                outputItem = new ItemStack(tentias, 3);
                craftTime = 90f;
                size = 4;

                consumeItems(with(duras, 2, flaxol, 1, faras, 1, fabris, 1));
                consumePower(1f);
            }
        };

        vastumFactory = new GenericCrafter("vastum-factory") {
            {
                localizedName = "vastum Synthetic Fiber Refining Factory";
                requirements(Category.crafting, with(cophalast, 10, duras, 10));

                outputItem = new ItemStack(vastum, 3);
                craftTime = 90f;
                size = 5;

                consumeItems(with(xearula, 3, rudis, 10));
                consumePower(1f);
            }
        };

        // region effect
        menethik = new CoreBlock("Menethik") {
            {
                localizedName = "Core: Menethik Platform";
                requirements(Category.effect, with(cophalast, 4000));

                isFirstTier = true;
                unitType = UnitTypes.mega;
                health = 8000;
                itemCapacity = 8000;
                size = 5;
                armor = 2000f;

                alwaysUnlocked = true;
                incinerateNonBuildable = true;
                requiresCoreZone = true;
                thrusterLength = 40 / 4f;

                buildCostMultiplier = 1f;

                unitCapModifier = 24;
            }
        };

        mantimela = new CoreBlock("Mantimela") {
            {
                localizedName = "Core: Mantimela HQ";
                requirements(Category.effect, with(cophalast, 4000, faras, 4000, fabris, 4000, tentias, 1000));

                unitType = UnitTypes.mega;
                health = 22000;
                itemCapacity = 16000;
                size = 6;
                armor = 2500f;

                alwaysUnlocked = true;
                incinerateNonBuildable = true;
                requiresCoreZone = true;
                thrusterLength = 48 / 4f;

                buildCostMultiplier = 1f;

                unitCapModifier = 48;
            }
        };

        potronagas = new CoreBlock("Potronagas") {
            {
                localizedName = "Core: Potronagas Planet";
                requirements(Category.effect,
                        with(cophalast, 4000, fabris, 4000, faras, 4000, xearula, 4000, tentias, 2000));

                unitType = UnitTypes.mega;
                health = 38000;
                itemCapacity = 25000;
                size = 7;
                armor = 3000f;

                alwaysUnlocked = true;
                incinerateNonBuildable = true;
                requiresCoreZone = true;
                thrusterLength = 58 / 4f;

                buildCostMultiplier = 1f;

                unitCapModifier = 72;
            }
        };

        repairField = new RegenProjector("Repair-field") {
            {
                localizedName = "Repair Field";
                requirements(Category.effect, with(cophalast, 10, duras, 10));
                size = 3;
                range = 30;
                healPercent = 20f / 60f;

                consumePower(1f);
                consumeLiquid(barbavior, 1f / 60f);
                consumeItem(flaxol).boost();

                Color col = Color.valueOf("8ca9e8");

                drawer = new DrawMulti(new DrawRegion("-bottom"),
                        new DrawLiquidTile(barbavior, 9f / 4f),
                        new DrawDefault(), new DrawGlowRegion() {
                            {
                                color = Color.sky;
                            }
                        }, new DrawPulseShape(false) {
                            {
                                layer = Layer.effect;
                                color = col;
                            }
                        }, new DrawShape() {
                            {
                                layer = Layer.effect;
                                radius = 3.5f;
                                useWarmupRadius = true;
                                timeScl = 2f;
                                color = col;
                            }
                        });
            }
        };

        bigRepairField = new RegenProjector("Big-repair-field") {
            {
                localizedName = "Big Repair Field";
                requirements(Category.effect, with(cophalast, 10, duras, 10));
                size = 4;
                range = 40;
                healPercent = 20f / 60f;

                consumePower(1f);
                consumeLiquid(horani, 1f / 60f);
                consumeItem(flaxol).boost();

                Color col = Color.valueOf("8ca9e8");

                drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(barbavior, 9f / 4f),
                        new DrawDefault(), new DrawGlowRegion() {
                            {
                                color = Color.sky;
                            }
                        }, new DrawPulseShape(false) {
                            {
                                layer = Layer.effect;
                                color = col;
                            }
                        }, new DrawShape() {
                            {
                                layer = Layer.effect;
                                radius = 3.5f;
                                useWarmupRadius = true;
                                timeScl = 2f;
                                color = col;
                            }
                        });
            }
        };

        damageField = new ShockwaveTower("Damage-field") {
            {
                localizedName = "Damage Projectile Field";
                requirements(Category.effect, with(faras, 10, flaxol, 10));
                size = 4;
                consumeLiquids(LiquidStack.with(barbavior, 1.5f / 60f));
                consumeItem(flaxol);
                consumePower(100f / 60f);
                range = 300f;
                reload = 80f;
            }
        };

        buildTower = new BuildTurret("Build-tower") {
            {
                localizedName = "Build Tower";
                requirements(Category.effect, with(faras, 10));
                outlineColor = Pal.darkOutline;

                range = 280f;
                size = 4;
                buildSpeed = 1f;

                consumePower(9f);
                consumeLiquid(viscosy, 3f / 60f);
            }
        };

        smallContainer = new StorageBlock("Small-container") {
            {
                localizedName = "Small Container";
                requirements(Category.effect, with(cophalast, 10, fabris, 10));
                size = 2;
                itemCapacity = 1000;
                scaledHealth = 55;
            }
        };

        bigContainer = new StorageBlock("Big-container") {
            {
                localizedName = "Big Container";
                requirements(Category.effect, with(cophalast, 10, fabris, 10, faras, 10));
                size = 3;
                itemCapacity = 2000;
                scaledHealth = 55;
            }
        };

        unloader = new Unloader("Unloader") {
            {
                localizedName = "Unloader";
                requirements(Category.effect, with(cophalast, 10));
                speed = 60f / 11f;
                group = BlockGroup.transportation;
            }
        };

        // region logic
        smallProcessor = new LogicBlock("Small-processor") {
            {
                localizedName = "Small Processor";
                requirements(Category.logic, with(cophalast, 10, duras, 10, fabris, 10));

                instructionsPerTick = 4;
                range = 8 * 22;
                size = 2;
            }
        };

        processor = new LogicBlock("Processor") {
            {
                localizedName = "Standard Processor";
                requirements(Category.logic, with(cophalast, 10, duras, 10, fabris, 10, faras, 10));

                instructionsPerTick = 8;
                range = 8 * 30;
                size = 3;
            }
        };

        bigProcessor = new LogicBlock("Big-processor") {
            {
                localizedName = "Big Processor";
                requirements(Category.logic,
                        with(cophalast, 10, duras, 10, fabris, 10, faras, 10, xearula, 10));

                instructionsPerTick = 16;
                range = 8 * 35;
                size = 4;
            }
        };

        dataCell = new MemoryBlock("Data-cell") {
            {
                localizedName = "Data Cell";
                requirements(Category.logic, with(cophalast, 10, duras, 10, fabris, 10));

                memoryCapacity = 128;
                size = 2;
            }
        };

        dataBank = new MemoryBlock("Data-bank") {
            {
                localizedName = "Data Bank";
                requirements(Category.logic, with(faras, 10, duras, 10, fabris, 10));

                memoryCapacity = 256;
                size = 3;
            }
        };

        display = new LogicDisplay("Display") {
            {
                localizedName = "Display";
                requirements(Category.logic, with(cophalast, 10, duras, 10, fabris, 10));

                displaySize = 360;
                size = 12;
            }
        };

        messsge = new MessageBlock("message") {
            {
                localizedName = "Ice Message";
                requirements(Category.logic, with(cophalast, 1));
            }
        };
    }
}
