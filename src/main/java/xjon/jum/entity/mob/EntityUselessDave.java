package xjon.jum.entity.mob;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xjon.jum.init.UselessItems;
import xjon.jum.util.Reference;

public class EntityUselessDave extends EntityMob {

	public EntityUselessDave(World worldIn) {
		super(worldIn);
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
		this.tasks.addTask(3, new EntityAIPanic(this, 1.2D));
        this.tasks.addTask(4, new EntityAITempt(this, 5.0D, UselessItems.useless_food, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));

        
        this.applyEntityAI();
        this.setSize(0.6F, 1.95F);
    }
	
	protected void applyEntityAI()
    {
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
    }
	
	public boolean isAIEnabled()
	{
		return true;
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(36.0F);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(36.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
	}
	
	protected SoundEvent getAmbientSound()
    {
        return new SoundEvent(new ResourceLocation(Reference.MOD_ID, "hidave"));
    }
	
	protected SoundEvent getHurtSound()
	{
		return new SoundEvent(new ResourceLocation(Reference.MOD_ID, "hitdave"));
	}
	
	protected SoundEvent getDeathSound()
    {
		return new SoundEvent(new ResourceLocation(Reference.MOD_ID, "deathdave"));
    }
	
	protected void playStepSound(BlockPos p_180429_1_, Block p_180429_2_)
	{
        this.playSound(SoundEvents.ENTITY_ZOMBIE_STEP, 0.15F, 1.0F);
	}
	
	protected Item getDropItem()   
	{
		return UselessItems.useless_material;
	}
	
	@Override
	public boolean getCanSpawnHere()
    {
        return true;
    }
}
