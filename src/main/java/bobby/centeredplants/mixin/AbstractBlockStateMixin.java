package bobby.centeredplants.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.AbstractBlockState.class)
public class AbstractBlockStateMixin {

    @Inject(method = "getModelOffset", at = @At("HEAD"), cancellable = true)
    public void setModdelOffset(BlockView world, BlockPos pos, CallbackInfoReturnable<Vec3d> cir){
        cir.setReturnValue(Vec3d.ZERO);
    }

}
