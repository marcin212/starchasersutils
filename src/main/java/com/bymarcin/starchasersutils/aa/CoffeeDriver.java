package com.bymarcin.starchasersutils.aa;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.bymarcin.starchasersutils.mekanism.DriverTank;
import de.ellpeck.actuallyadditions.mod.tile.TileEntityCoffeeMachine;
import li.cil.oc.api.driver.NamedBlock;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.prefab.DriverSidedTileEntity;
import li.cil.oc.integration.ManagedTileEntityEnvironment;
import mekanism.common.tile.TileEntityGasTank;

public class CoffeeDriver extends DriverSidedTileEntity {
	@Override
	public Class<?> getTileEntityClass() {
		return TileEntityCoffeeMachine.class;
	}

	@Override
	public ManagedEnvironment createEnvironment(World world, BlockPos pos, EnumFacing side) {
		return new EnvironmentCoffeeMachine((TileEntityCoffeeMachine) world.getTileEntity(pos));
	}

	public static final class EnvironmentCoffeeMachine extends ManagedTileEntityEnvironment<TileEntityCoffeeMachine> implements NamedBlock {

		public EnvironmentCoffeeMachine(final TileEntityCoffeeMachine tileEntity) {
			super(tileEntity, "coffee_machine");
		}

		@Override
		public String preferredName() {
			return "coffee_machine";
		}

		@Override
		public int priority() {
			return 1;
		}

		@Callback(doc = "function():bool -- Make a coffee")
		public Object[] makeCoffee(final Context context, final Arguments args) {
			if(tileEntity.brewTime<=0){
				tileEntity.brew();
				return new Object[]{true};
			}
			return new Object[]{false};
		}
	}
}