package net.minecraft.world.item;

import net.minecraft.tags.BlockTags;

public class PickaxeItem extends DiggerItem {
   public PickaxeItem(Tier p_42961_, int p_42962_, float p_42963_, Item.Properties p_42964_) {
      super((float)p_42962_, p_42963_, p_42961_, BlockTags.MINEABLE_WITH_PICKAXE, p_42964_);
   }
}