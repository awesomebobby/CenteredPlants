package bobby.centeredplants.mixin;

import net.minecraft.block.AbstractBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(AbstractBlock.Settings.class)
public abstract class AbstractBlockMixin {

    @Accessor
    abstract void setOffsetter(Optional<AbstractBlock.Offsetter> offsetter);

    @Inject(at = @At("HEAD"), method = "offset", cancellable = true)
    public void offset(AbstractBlock.OffsetType offsetType, CallbackInfoReturnable<AbstractBlock.Settings> cir){

            this.setOffsetter(Optional.empty());
            cir.setReturnValue((AbstractBlock.Settings)(Object)this);
            cir.cancel();

    }

}