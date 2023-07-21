package net.minecraft.src;

public class InventoryLargeChest implements IInventory {
	private String name;
	private IInventory upperChest;
	private IInventory lowerChest;

	public InventoryLargeChest(String var1, IInventory var2, IInventory var3) {
		this.name = var1;
		this.upperChest = var2;
		this.lowerChest = var3;
	}

	public int getSizeInventory() {
		return this.upperChest.getSizeInventory() + this.lowerChest.getSizeInventory();
	}

	public String getInvName() {
		return this.name;
	}

	public ItemStack getStackInSlot(int var1) {
		return var1 >= this.upperChest.getSizeInventory() ? this.lowerChest.getStackInSlot(var1 - this.upperChest.getSizeInventory()) : this.upperChest.getStackInSlot(var1);
	}

	public ItemStack decrStackSize(int var1, int var2) {
		return var1 >= this.upperChest.getSizeInventory() ? this.lowerChest.decrStackSize(var1 - this.upperChest.getSizeInventory(), var2) : this.upperChest.decrStackSize(var1, var2);
	}

	public void setInventorySlotContents(int var1, ItemStack var2) {
		if(var1 >= this.upperChest.getSizeInventory()) {
			this.lowerChest.setInventorySlotContents(var1 - this.upperChest.getSizeInventory(), var2);
		} else {
			this.upperChest.setInventorySlotContents(var1, var2);
		}

	}

	public int getInventoryStackLimit() {
		return this.upperChest.getInventoryStackLimit();
	}

	public void onInventoryChanged() {
		this.upperChest.onInventoryChanged();
		this.lowerChest.onInventoryChanged();
	}

	public boolean func_20070_a_(EntityPlayer var1) {
		return this.upperChest.func_20070_a_(var1) && this.lowerChest.func_20070_a_(var1);
	}
}
