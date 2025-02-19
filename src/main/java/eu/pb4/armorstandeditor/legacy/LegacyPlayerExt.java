package eu.pb4.armorstandeditor.legacy;

import eu.pb4.armorstandeditor.EditorActions;
import eu.pb4.armorstandeditor.config.ConfigManager;
import eu.pb4.armorstandeditor.util.ArmorStandData;
import eu.pb4.playerdata.api.PlayerDataApi;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtByte;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;


public interface LegacyPlayerExt {
    Identifier LEGACY_UI = new Identifier("armor_stand_editor", "use_legacy_ui");

    EditorActions aselegacy$getArmorStandEditorAction();
    void aselegacy$setArmorStandEditorAction(EditorActions action);
    float aselegacy$getArmorStandEditorPower();
    void aselegacy$setArmorStandEditorPower(float power);
    int aselegacy$getArmorStandEditorXYZ();
    void aselegacy$setArmorStandEditorXYZ(int xyz);
    ArmorStandData aselegacy$getArmorStandEditorData();
    void aselegacy$setArmorStandEditorData(ArmorStandData data);


    static boolean useLegacy(PlayerEntity player) {
        if (player instanceof ServerPlayerEntity serverPlayerEntity) {
            var data = PlayerDataApi.getGlobalDataFor(serverPlayerEntity, LEGACY_UI, NbtByte.TYPE);

            if (data != null) {
                return data.intValue() > 0;
            }
        }
        return ConfigManager.getConfig().configData.useLegacyUiByDefault;
    }
}
