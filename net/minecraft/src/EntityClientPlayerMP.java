package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.commands.CommandManager;
import net.minecraft.src.stever9487.event.EventRegistry;
import net.minecraft.src.stever9487.event.updates.EventMPPlayerUpdate;

import java.util.Random;

public class EntityClientPlayerMP extends EntityPlayerSP {
	public NetClientHandler field_797_bg;
	private int field_9380_bx = 0;
	private double field_9379_by;
	private double field_9378_bz;
	private double field_9377_bA;
	private double field_9376_bB;
	private float field_9385_bC;
	private float field_9384_bD;
	private boolean field_9382_bF = false;
	private boolean field_9381_bG = false;
	private int field_12242_bI = 0;
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+=[]{}|;:'\",.<>?";

	public EntityClientPlayerMP(Minecraft var1, World var2, Session var3, NetClientHandler var4) {
		super(var1, var2, var3, 0);
		this.field_797_bg = var4;
	}

	public boolean attackEntityFrom(Entity var1, int var2) {
		return false;
	}

	public void heal(int var1) {
	}

	public void onUpdate() {
		if(this.worldObj.blockExists(MathHelper.floor_double(this.posX), 64, MathHelper.floor_double(this.posZ))) {
			super.onUpdate();
			this.func_4056_N();
		}
	}

	public void func_6420_o() {
	}

	public void func_4056_N() {
		EventMPPlayerUpdate eventPre = new EventMPPlayerUpdate();
		eventPre.isPre = true;
		EventRegistry.handleEvent(eventPre);
		if(this.field_9380_bx++ == 20) {
			this.sendInventoryChanged();
			this.field_9380_bx = 0;
		}

		boolean var1 = this.isSneaking();
		if(var1 != this.field_9381_bG) {
			if(var1) {
				this.field_797_bg.addToSendQueue(new Packet18ArmAnimation(this, 104));
			} else {
				this.field_797_bg.addToSendQueue(new Packet18ArmAnimation(this, 105));
			}

			this.field_9381_bG = var1;
		}

		double var2 = this.posX - this.field_9379_by;
		double var4 = this.boundingBox.minY - this.field_9378_bz;
		double var6 = this.posY - this.field_9377_bA;
		double var8 = this.posZ - this.field_9376_bB;
		double var10 = (double)(this.rotationYaw - this.field_9385_bC);
		double var12 = (double)(this.rotationPitch - this.field_9384_bD);
		boolean var14 = var4 != 0.0D || var6 != 0.0D || var2 != 0.0D || var8 != 0.0D;
		boolean var15 = var10 != 0.0D || var12 != 0.0D;
		if(this.ridingEntity != null) {
			if(var15) {
				this.field_797_bg.addToSendQueue(new Packet11PlayerPosition(this.motionX, -999.0D, -999.0D, this.motionZ, this.onGround));
			} else {
				this.field_797_bg.addToSendQueue(new Packet13PlayerLookMove(this.motionX, -999.0D, -999.0D, this.motionZ, this.rotationYaw, this.rotationPitch, this.onGround));
			}

			var14 = false;
		} else if(var14 && var15) {
			this.field_797_bg.addToSendQueue(new Packet13PlayerLookMove(this.posX, this.boundingBox.minY, this.posY, this.posZ, this.rotationYaw, this.rotationPitch, this.onGround));
			this.field_12242_bI = 0;
		} else if(var14) {
			this.field_797_bg.addToSendQueue(new Packet11PlayerPosition(this.posX, this.boundingBox.minY, this.posY, this.posZ, this.onGround));
			this.field_12242_bI = 0;
		} else if(var15) {
			this.field_797_bg.addToSendQueue(new Packet12PlayerLook(this.rotationYaw, this.rotationPitch, this.onGround));
			this.field_12242_bI = 0;
		} else {
			this.field_797_bg.addToSendQueue(new Packet10Flying(this.onGround));
			if(this.field_9382_bF == this.onGround && this.field_12242_bI <= 20) {
				++this.field_12242_bI;
			} else {
				this.field_12242_bI = 0;
			}
		}

		this.field_9382_bF = this.onGround;
		if(var14) {
			this.field_9379_by = this.posX;
			this.field_9378_bz = this.boundingBox.minY;
			this.field_9377_bA = this.posY;
			this.field_9376_bB = this.posZ;
		}

		if(var15) {
			this.field_9385_bC = this.rotationYaw;
			this.field_9384_bD = this.rotationPitch;
		}

	}

	public void func_20060_w() {
		this.field_797_bg.addToSendQueue(new Packet14BlockDig(4, 0, 0, 0, 0));
	}

	private void sendInventoryChanged() {
	}

	protected void joinEntityItemWithWorld(EntityItem var1) {
	}

	private static String randomizeCase(String input) {
		Random random = new Random();
		StringBuilder result = new StringBuilder();

		for (char c : input.toCharArray()) {
			boolean convertToUpper = random.nextBoolean();

			if (Character.isLetter(c)) {
				char modifiedChar = convertToUpper ? Character.toUpperCase(c) : Character.toLowerCase(c);
				result.append(modifiedChar);
			} else {
				result.append(c);
			}
		}
		return result.toString();
	}

	private static String generateRandomString(){
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < 5; i++){
			int randomIndex = random.nextInt(CHARACTERS.length());
			char randomChar = CHARACTERS.charAt(randomIndex);
			sb.append(randomChar);
		}

		return sb.toString();
	}

	public void sendChatMessage(String msg) {
		Random random = new Random();
		String[] prefixes = {
				">",
				"<",
				"|",
				":",
				";"
		};
		if(Client.hacks[5].isToggled() && msg.length() + " > shid client aaaaa".length() <= 100){
			msg = msg + " " + prefixes[random.nextInt(prefixes.length)] + " " + randomizeCase("shid client") + " " + generateRandomString();
		}
		this.field_797_bg.addToSendQueue(new Packet3Chat(msg));
	}

	public void swingItem() {
		super.swingItem();
		this.field_797_bg.addToSendQueue(new Packet18ArmAnimation(this, 1));
	}

	public void respawnPlayer() {
		this.sendInventoryChanged();
		this.field_797_bg.addToSendQueue(new Packet9());
	}

	protected void damageEntity(int var1) {
		this.health -= var1;
	}

	public void func_20059_m() {
		this.field_797_bg.addToSendQueue(new Packet101(this.field_20068_h.unusedList));
		this.inventory.func_20076_b((ItemStack)null);
		super.func_20059_m();
	}
}
