package bobby.centeredplants.mixin;

import net.minecraft.block.AbstractBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.Settings.class)
public abstract class AbstractBlockMixin {

    @Inject(at = @At("HEAD"), method = "offset", cancellable = true)
    public void offset(AbstractBlock.OffsetType offsetType, CallbackInfoReturnable<AbstractBlock.Settings> cir){
        cir.setReturnValue((AbstractBlock.Settings)(Object)this);
        cir.cancel();
    }
}