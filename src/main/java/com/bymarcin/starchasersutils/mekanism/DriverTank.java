package com.bymarcin.starchasersutils.mekanism;

import li.cil.oc.api.driver.NamedBlock;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.prefab.DriverSidedTileEntity;
import li.cil.oc.integration.ManagedTileEntityEnvironment;
import mekanism.api.gas.IGasHandler;
import mekanism.common.tile.TileEntityGasTank;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Marcin on 2017-03-29.
 */
public class DriverTank extends DriverSidedTileEntity {
    @Override
    public Class<?> getTileEntityClass() {
        return TileEntityGasTank.class;
    }

    @Override
    public ManagedEnvironment createEnvironment(World world, BlockPos pos, EnumFacing side) {
        return new EnvironmentGasTank((TileEntityGasTank) world.getTileEntity(pos));
    }

    public static final class EnvironmentGasTank extends ManagedTileEntityEnvironment<TileEntityGasTank> implements NamedBlock {

        public EnvironmentGasTank(final TileEntityGasTank tileEntity) {
            super(tileEntity, "gas_tank");
        }

        @Override
        public String preferredName() {
            return "gas_tank";
        }

        @Override
        public int priority() {
            return 0;
        }

        @Callback(doc = "function():number -- Amount of gas in mb")
        public Object[] getGasAmount(final Context context, final Arguments args) {
            return new Object[]{ tileEntity.gasTank.getStored() };
        }

        @Callback(doc = "function():number -- Max amount of gas in mb")
        public Object[] getGasCapacity(final Context context, final Arguments args) {
           return new Object[]{ tileEntity.gasTank.getMaxGas() };
        }

        @Callback(doc = "function():GasStack -- Current gas type in tank")
        public Object[] getGasType(final Context context, final Arguments args) {
            return new Object[]{ tileEntity.gasTank.getGas() };
        }
    }
}
