package net.minecraft.src.stever9487.utils;

import net.minecraft.src.*;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL32;

import java.awt.*;

public class RenderUtil {
    public static void drawOutlinedBoundingBox(AxisAlignedBB aa) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawing(3);
        tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.minY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.minY, aa.maxZ);
        tessellator.addVertex(aa.minX, aa.minY, aa.maxZ);
        tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
        tessellator.draw();
        tessellator.startDrawing(3);
        tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.maxY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.maxY, aa.maxZ);
        tessellator.addVertex(aa.minX, aa.maxY, aa.maxZ);
        tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
        tessellator.draw();
        tessellator.startDrawing(1);
        tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
        tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.minY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.maxY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.minY, aa.maxZ);
        tessellator.addVertex(aa.maxX, aa.maxY, aa.maxZ);
        tessellator.addVertex(aa.minX, aa.minY, aa.maxZ);
        tessellator.addVertex(aa.minX, aa.maxY, aa.maxZ);
        tessellator.draw();
    }

    public static void drawBoundingBox(AxisAlignedBB aa)  {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
        tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.minY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.maxY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.minY, aa.maxZ);
        tessellator.addVertex(aa.maxX, aa.maxY, aa.maxZ);
        tessellator.addVertex(aa.minX, aa.minY, aa.maxZ);
        tessellator.addVertex(aa.minX, aa.maxY, aa.maxZ);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.addVertex(aa.maxX, aa.maxY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.minY, aa.minZ);
        tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
        tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
        tessellator.addVertex(aa.minX, aa.maxY, aa.maxZ);
        tessellator.addVertex(aa.minX, aa.minY, aa.maxZ);
        tessellator.addVertex(aa.maxX, aa.maxY, aa.maxZ);
        tessellator.addVertex(aa.maxX, aa.minY, aa.maxZ);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.maxY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.maxY, aa.maxZ);
        tessellator.addVertex(aa.minX, aa.maxY, aa.maxZ);
        tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
        tessellator.addVertex(aa.minX, aa.maxY, aa.maxZ);
        tessellator.addVertex(aa.maxX, aa.maxY, aa.maxZ);
        tessellator.addVertex(aa.maxX, aa.maxY, aa.minZ);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.minY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.minY, aa.maxZ);
        tessellator.addVertex(aa.minX, aa.minY, aa.maxZ);
        tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
        tessellator.addVertex(aa.minX, aa.minY, aa.maxZ);
        tessellator.addVertex(aa.maxX, aa.minY, aa.maxZ);
        tessellator.addVertex(aa.maxX, aa.minY, aa.minZ);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
        tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
        tessellator.addVertex(aa.minX, aa.minY, aa.maxZ);
        tessellator.addVertex(aa.minX, aa.maxY, aa.maxZ);
        tessellator.addVertex(aa.maxX, aa.minY, aa.maxZ);
        tessellator.addVertex(aa.maxX, aa.maxY, aa.maxZ);
        tessellator.addVertex(aa.maxX, aa.minY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.maxY, aa.minZ);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.addVertex(aa.minX, aa.maxY, aa.maxZ);
        tessellator.addVertex(aa.minX, aa.minY, aa.maxZ);
        tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
        tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.maxY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.minY, aa.minZ);
        tessellator.addVertex(aa.maxX, aa.maxY, aa.maxZ);
        tessellator.addVertex(aa.maxX, aa.minY, aa.maxZ);
        tessellator.draw();
    }

    public static void drawOutlinedBlockESP(double x, double y, double z, float red, float green, float blue, float alpha, float lineWidth) {
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        GL11.glLineWidth(lineWidth);
        GL11.glColor4f(red, green, blue, alpha);
        drawOutlinedBoundingBox(new AxisAlignedBB(x, y, z, x + 1D, y + 1D, z + 1D));
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(true);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }

    public static void drawBlockESP(double x, double y, double z, float red, float green, float blue, float alpha, float lineRed, float lineGreen, float lineBlue, float lineAlpha, float lineWidth) {
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(770, 771);
        // GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        GL11.glColor4f(red, green, blue, alpha);
        drawBoundingBox(new AxisAlignedBB(x, y, z, x + 1D, y + 1D, z + 1D));
        GL11.glLineWidth(lineWidth);
        GL11.glColor4f(lineRed, lineGreen, lineBlue, lineAlpha);
        drawOutlinedBoundingBox(new AxisAlignedBB(x, y, z, x + 1D, y + 1D, z + 1D));
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        // GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(true);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();

    }

    public static void drawSolidBlockESP(double x, double y, double z, float red, float green, float blue, float alpha) {
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(770, 771);
        // GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        GL11.glColor4f(red, green, blue, alpha);
        drawBoundingBox(new AxisAlignedBB(x, y, z, x + 1D, y + 1D, z + 1D));
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        // GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(true);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }

    public static void drawOutlinedEntityESP(double x, double y, double z, double width, double height, float red, float green, float blue, float alpha) {
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(770, 771);
        // GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        GL11.glColor4f(red, green, blue, alpha);
        drawOutlinedBoundingBox(new AxisAlignedBB(x - width, y, z - width, x + width , y + height, z + width));
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        // GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(true);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }

    public static void drawSolidEntityESP(double x, double y, double z, double width, double height, float red, float green, float blue, float alpha) {
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(770, 771);
        // GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        GL11.glColor4f(red, green, blue, alpha);
        drawBoundingBox(new AxisAlignedBB(x - width, y, z - width, x + width , y + height, z + width));
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        // GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(true);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }

    public static void drawEntityESP(double x, double y, double z, double width, double height, float red, float green, float blue, float alpha, float lineRed, float lineGreen, float lineBlue, float lineAlpha, float lineWdith) {
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(770, 771);
        // GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        GL11.glColor4f(red, green, blue, alpha);
        drawBoundingBox(new AxisAlignedBB(x - width, y, z - width, x + width , y + height, z + width));
        GL11.glLineWidth(lineWdith);
        GL11.glColor4f(lineRed, lineGreen, lineBlue, lineAlpha);
        drawOutlinedBoundingBox(new AxisAlignedBB(x - width, y, z - width, x + width , y + height, z + width));
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        // GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(true);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }

    public static void drawTracerLine(double x, double y, double z, float red, float green, float blue, float alpha, float lineWdith) {
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        // GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glLineWidth(lineWdith);
        GL11.glColor4f(red, green, blue, alpha);
        GL11.glBegin(2);
        GL11.glVertex3d(0.0D, 0.0D , 0.0D);
        GL11.glVertex3d(x, y, z);
        GL11.glEnd();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_BLEND);
        // GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

    public static void boundingESPBox(AxisAlignedBB box, Color c) {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        int a = c.getAlpha();
        double x =
                box.minX -
                        RenderManager.field_1222_l;
        double y =
                box.minY -
                        RenderManager.field_1221_m;
        double z =
                box.minZ -
                        RenderManager.field_1220_n;
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glLineWidth(2.0F);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glColor4d(0.0D, 1.0D, 0.0D, 0.15000000596046448D);
        AxisAlignedBB bb = new AxisAlignedBB(x, y, z, x - box.minX + box.maxX, y - box.minY + box.maxY, z - box.minZ + box.maxZ);
        RenderGlobal.drawOutlinedBoundingBox(bb, 0.00390625F * r, 0.00390625F * g, 0.00390625F * b, 0.00390625F * a);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
    }

    public static void drawLine3D(float x, float y, float z, float x1, float y1, float z1, float thickness, float red, float green, float blue, float alpha)
    {
        GL11.glPushMatrix();
        GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glDisable(3008 /*GL_ALPHA*/);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glLineWidth(thickness);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glHint(GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST);
        GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
        GL11.glEnable(GL32.GL_DEPTH_CLAMP);
        final Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawing(1);
        tessellator.setColorRGBA_F(red, green, blue, alpha);
        tessellator.addVertex((double) x, (double) y, (double) z);
        tessellator.addVertex((double) x1, (double) y1, (double) z1);
        tessellator.draw();
        GL11.glShadeModel(GL11.GL_FLAT);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
        GL11.glDisable(GL32.GL_DEPTH_CLAMP);
        GL11.glDisable(3042 /*GL_BLEND*/);;
        GL11.glEnable(3008 /*GL_ALPHA*/);
        GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
        GL11.glPopMatrix();
    }

    public static void blockESPBox(Vec3D blockPos, Color c) {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        int a = c.getAlpha();
        double x =
                blockPos.xCoord -
                        RenderManager.field_1222_l;
        double y =
                blockPos.yCoord -
                        RenderManager.field_1221_m;
        double z =
                blockPos.zCoord -
                        RenderManager.field_1220_n;
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glLineWidth(2.0F);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glColor4d(0.0D, 1.0D, 0.0D, 0.15000000596046448D);
        RenderGlobal.drawOutlinedBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D));
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
    }

    public static void blockESPBoxFilled(Vec3D blockPos, Color c) {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        int a = c.getAlpha();
        double x =
                blockPos.xCoord -
                        RenderManager.field_1222_l;
        double y =
                blockPos.yCoord -
                        RenderManager.field_1221_m;
        double z =
                blockPos.zCoord -
                        RenderManager.field_1220_n;
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glLineWidth(2.0F);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glColor4d((0.00390625F * r), (0.00390625F * g), (0.00390625F * b), (0.00390625F * a));
        GL11.glBegin(7);
        AxisAlignedBB bb = new AxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D);
        GL11.glVertex3d(bb.minX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.minZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.minZ);
        GL11.glVertex3d(bb.minX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.minX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.minZ);
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
    }

    public static void bedESPBoxFilled(Vec3D blockPos, Color c) {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        int a = c.getAlpha();
        double x =
                blockPos.xCoord -
                        RenderManager.field_1222_l;
        double y =
                blockPos.yCoord -
                        RenderManager.field_1221_m;
        double z =
                blockPos.zCoord -
                        RenderManager.field_1220_n;
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glLineWidth(2.0F);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glColor4d((0.00390625F * r), (0.00390625F * g), (0.00390625F * b), (0.00390625F * a));
        GL11.glBegin(7);
        AxisAlignedBB bb = new AxisAlignedBB(x, y, z, x + 1.0D, y + 0.5625D, z + 1.0D);
        GL11.glVertex3d(bb.minX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.minZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.minZ);
        GL11.glVertex3d(bb.minX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.minX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.minZ);
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
    }

    public static void boundingESPBoxFilled(AxisAlignedBB box, Color c) {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        int a = c.getAlpha();
        double x =
                box.minX -
                        RenderManager.field_1222_l;
        double y =
                box.minY -
                        RenderManager.field_1221_m;
        double z =
                box.minZ -
                        RenderManager.field_1220_n;
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glLineWidth(2.0F);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glColor4d((0.00390625F * r), (0.00390625F * g), (0.00390625F * b), (0.00390625F * a));
        GL11.glBegin(7);
        AxisAlignedBB bb = new AxisAlignedBB(x, y, z, x - box.minX + box.maxX, y - box.minY + box.maxY, z - box.minZ + box.maxZ);
        GL11.glVertex3d(bb.minX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.minZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.minZ);
        GL11.glVertex3d(bb.minX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.minZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.maxX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.maxX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.minY, bb.minZ);
        GL11.glVertex3d(bb.minX, bb.minY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.maxZ);
        GL11.glVertex3d(bb.minX, bb.maxY, bb.minZ);
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
    }
}
