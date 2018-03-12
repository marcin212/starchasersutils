package com.bymarcin.starchasersutils;


import com.bymarcin.starchasersutils.aa.CoffeeDriver;
import com.bymarcin.starchasersutils.mekanism.DriverTank;
import li.cil.oc.api.Driver;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "starchasersutils", name = "StarchasersUtils", version = "@VERSION@", dependencies = "required-after:opencomputers")
public class StarchasersUtils{

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Driver.add(new DriverTank());
        Driver.add(new CoffeeDriver());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}