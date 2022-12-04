package com.elikill58.negativity.sponge.impl.location;

import java.util.Locale;

import org.spongepowered.api.world.server.ServerWorld;

import com.elikill58.negativity.api.block.Block;
import com.elikill58.negativity.api.location.Difficulty;
import com.elikill58.negativity.api.location.World;
import com.elikill58.negativity.sponge.impl.block.SpongeBlock;
import com.elikill58.negativity.sponge.utils.Utils;

public class SpongeWorld extends World {

	private final ServerWorld w;
	
	public SpongeWorld(ServerWorld w) {
		this.w = w;
	}

	@Override
	public String getName() {
		return w.key().asString();
	}

	@Override
	public Block getBlockAt0(int x, int y, int z) {
		return new SpongeBlock(w.createSnapshot(x, y, z));
	}

	@Override
	public Difficulty getDifficulty() {
		return Difficulty.valueOf(Utils.getKey(w.difficulty()).value().toUpperCase(Locale.ROOT));
	}
	
	@Override
	public int getMaxHeight() {
		return w.maximumHeight();
	}
	
	@Override
	public int getMinHeight() {
		int min = w.min().y();
		return min > 0 ? 0 : min;
	}

	@Override
	public Object getDefault() {
		return w;
	}

}
