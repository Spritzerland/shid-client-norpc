package net.minecraft.src;

public class EntityFallingSand extends Entity {
	public int entityID;
	public int fallTime = 0;

	public EntityFallingSand(World var1) {
		super(var1);
	}

	public EntityFallingSand(World var1, double var2, double var4, double var6, int var8) {
		super(var1);
		this.entityID = var8;
		this.preventEntitySpawning = true;
		this.setSize(0.98F, 0.98F);
		this.yOffset = this.height / 2.0F;
		this.setPosition(var2, var4, var6);
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.entityWalks = false;
		this.prevPosX = var2;
		this.prevPosY = var4;
		this.prevPosZ = var6;
	}

	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	public void onUpdate() {
		if(this.entityID == 0) {
			this.setEntityDead();
		} else {
			this.prevPosX = this.posX;
			this.prevPosY = this.posY;
			this.prevPosZ = this.posZ;
			++this.fallTime;
			this.motionY -= (double)0.04F;
			this.moveEntity(this.motionX, this.motionY, this.motionZ);
			this.motionX *= (double)0.98F;
			this.motionY *= (double)0.98F;
			this.motionZ *= (double)0.98F;
			int var1 = MathHelper.floor_double(this.posX);
			int var2 = MathHelper.floor_double(this.posY);
			int var3 = MathHelper.floor_double(this.posZ);
			if(this.worldObj.getBlockId(var1, var2, var3) == this.entityID) {
				this.worldObj.setBlockWithNotify(var1, var2, var3, 0);
			}

			if(this.onGround) {
				this.motionX *= (double)0.7F;
				this.motionZ *= (double)0.7F;
				this.motionY *= -0.5D;
				this.setEntityDead();
				if(!this.worldObj.canBlockBePlacedAt(this.entityID, var1, var2, var3, true) || !this.worldObj.setBlockWithNotify(var1, var2, var3, this.entityID)) {
					this.dropItem(this.entityID, 1);
				}
			} else if(this.fallTime > 100) {
				this.dropItem(this.entityID, 1);
				this.setEntityDead();
			}

		}
	}

	protected void writeEntityToNBT(NBTTagCompound var1) {
		var1.setByte("Tile", (byte)this.entityID);
	}

	protected void readEntityFromNBT(NBTTagCompound var1) {
		this.entityID = var1.getByte("Tile") & 255;
	}

	public float func_392_h_() {
		return 0.0F;
	}

	public World func_465_i() {
		return this.worldObj;
	}
}
