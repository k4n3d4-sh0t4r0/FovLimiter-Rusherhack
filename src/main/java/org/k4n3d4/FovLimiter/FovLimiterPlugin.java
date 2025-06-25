package org.k4n3d4.FovLimiter;

import org.rusherhack.client.api.RusherHackAPI;
import org.rusherhack.client.api.plugin.Plugin;

public class FovLimiterPlugin extends Plugin {
	
	public static long minecraftInitTime = 0L;
	public static FovLimiterPlugin INSTANCE;
	
	@Override
	public void onLoad() {
		INSTANCE = this;

		final FovLimiterModule fovLimiterModule = new FovLimiterModule();
		RusherHackAPI.getModuleManager().registerFeature(fovLimiterModule);

		this.getLogger().info("Loading FOV Limiter plugin");
	}

	@Override
	public void onUnload() {
		this.getLogger().info("FOV Limiter plugin unloaded!");
	}
	
}