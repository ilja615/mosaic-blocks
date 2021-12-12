package com.mojang.realmsclient.gui.screens;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.datafixers.util.Pair;
import com.mojang.realmsclient.exception.RealmsServiceException;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.MultiLineLabel;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.realms.RealmsScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RealmsGenericErrorScreen extends RealmsScreen {
   private final Screen nextScreen;
   private final Pair<Component, Component> f_200947_;
   private MultiLineLabel f_200948_ = MultiLineLabel.EMPTY;

   public RealmsGenericErrorScreen(RealmsServiceException p_88669_, Screen p_88670_) {
      super(NarratorChatListener.NO_TITLE);
      this.nextScreen = p_88670_;
      this.f_200947_ = m_200949_(p_88669_);
   }

   public RealmsGenericErrorScreen(Component p_88672_, Screen p_88673_) {
      super(NarratorChatListener.NO_TITLE);
      this.nextScreen = p_88673_;
      this.f_200947_ = m_200951_(p_88672_);
   }

   public RealmsGenericErrorScreen(Component p_88675_, Component p_88676_, Screen p_88677_) {
      super(NarratorChatListener.NO_TITLE);
      this.nextScreen = p_88677_;
      this.f_200947_ = m_200953_(p_88675_, p_88676_);
   }

   private static Pair<Component, Component> m_200949_(RealmsServiceException p_200950_) {
      if (p_200950_.f_200941_ == null) {
         return Pair.of(new TextComponent("An error occurred (" + p_200950_.httpResultCode + "):"), new TextComponent(p_200950_.f_200940_));
      } else {
         String s = "mco.errorMessage." + p_200950_.f_200941_.getErrorCode();
         return Pair.of(new TextComponent("Realms (" + p_200950_.f_200941_ + "):"), (Component)(I18n.exists(s) ? new TranslatableComponent(s) : Component.nullToEmpty(p_200950_.f_200941_.getErrorMessage())));
      }
   }

   private static Pair<Component, Component> m_200951_(Component p_200952_) {
      return Pair.of(new TextComponent("An error occurred: "), p_200952_);
   }

   private static Pair<Component, Component> m_200953_(Component p_200954_, Component p_200955_) {
      return Pair.of(p_200954_, p_200955_);
   }

   public void init() {
      this.addRenderableWidget(new Button(this.width / 2 - 100, this.height - 52, 200, 20, new TextComponent("Ok"), (p_88686_) -> {
         this.minecraft.setScreen(this.nextScreen);
      }));
      this.f_200948_ = MultiLineLabel.create(this.font, this.f_200947_.getSecond(), this.width * 3 / 4);
   }

   public Component getNarrationMessage() {
      return (new TextComponent("")).append(this.f_200947_.getFirst()).append(": ").append(this.f_200947_.getSecond());
   }

    @Override
    public boolean keyPressed(int key, int scanCode, int modifiers) {
       if (key == org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE) {
          minecraft.setScreen(this.nextScreen);
          return true;
       }
       return super.keyPressed(key, scanCode, modifiers);
    }

   public void render(PoseStack p_88679_, int p_88680_, int p_88681_, float p_88682_) {
      this.renderBackground(p_88679_);
      drawCenteredString(p_88679_, this.font, this.f_200947_.getFirst(), this.width / 2, 80, 16777215);
      this.f_200948_.renderCentered(p_88679_, this.width / 2, 100, 9, 16711680);
      super.render(p_88679_, p_88680_, p_88681_, p_88682_);
   }
}