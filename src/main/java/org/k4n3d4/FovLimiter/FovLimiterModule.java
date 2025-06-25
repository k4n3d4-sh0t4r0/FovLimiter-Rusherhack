package org.k4n3d4.FovLimiter;

import org.rusherhack.client.api.feature.module.ModuleCategory;
import org.rusherhack.client.api.feature.module.ToggleableModule;
import org.rusherhack.core.setting.NumberSetting;

public class FovLimiterModule extends ToggleableModule{
    public static boolean IsEnable = false;

    public static final NumberSetting<Double> minFov = new NumberSetting<>("MinFov", 0.85, 0.0, 1.0) .incremental(0.05);
    public static final NumberSetting<Double> maxFov = new NumberSetting<>("MaxFov", 1.15, 1.0, 2.0) .incremental(0.05);

    public FovLimiterModule() {
        super("FOV Limiter", "Limit the fov multiplier between a max and min value", ModuleCategory.CLIENT);

        this.registerSettings(
                minFov,
                maxFov
        );
    }

    @Override
    public void onEnable() {
        IsEnable = true;
    }

    @Override
    public void onDisable() {
        IsEnable = false;
    }
}
