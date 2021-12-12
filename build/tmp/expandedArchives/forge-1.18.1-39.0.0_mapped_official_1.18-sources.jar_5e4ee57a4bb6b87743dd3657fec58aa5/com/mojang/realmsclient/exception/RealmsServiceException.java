package com.mojang.realmsclient.exception;

import com.mojang.realmsclient.client.RealmsError;
import javax.annotation.Nullable;
import net.minecraft.client.resources.language.I18n;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RealmsServiceException extends Exception {
   public final int httpResultCode;
   public final String f_200940_;
   @Nullable
   public final RealmsError f_200941_;

   public RealmsServiceException(int p_87783_, String p_87784_, RealmsError p_87785_) {
      super(p_87784_);
      this.httpResultCode = p_87783_;
      this.f_200940_ = p_87784_;
      this.f_200941_ = p_87785_;
   }

   public RealmsServiceException(int p_200943_, String p_200944_) {
      super(p_200944_);
      this.httpResultCode = p_200943_;
      this.f_200940_ = p_200944_;
      this.f_200941_ = null;
   }

   public String toString() {
      if (this.f_200941_ != null) {
         String s = "mco.errorMessage." + this.f_200941_.getErrorCode();
         String s1 = I18n.exists(s) ? I18n.get(s) : this.f_200941_.getErrorMessage();
         return "Realms service error (%d/%d) %s".formatted(this.httpResultCode, this.f_200941_.getErrorCode(), s1);
      } else {
         return "Realms service error (%d) %s".formatted(this.httpResultCode, this.f_200940_);
      }
   }

   public int m_200945_(int p_200946_) {
      return this.f_200941_ != null ? this.f_200941_.getErrorCode() : p_200946_;
   }
}