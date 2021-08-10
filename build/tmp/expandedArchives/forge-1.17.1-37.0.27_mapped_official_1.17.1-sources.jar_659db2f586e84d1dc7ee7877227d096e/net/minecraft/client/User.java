package net.minecraft.client;

import com.mojang.authlib.GameProfile;
import com.mojang.util.UUIDTypeAdapter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class User {
   private final String name;
   private final String uuid;
   private final String accessToken;
   private final User.Type type;
   /** Forge: Cache of the local session's GameProfile properties. */
   private com.mojang.authlib.properties.PropertyMap properties;

   public User(String p_92540_, String p_92541_, String p_92542_, String p_92543_) {
      if (p_92540_ == null || p_92540_.isEmpty()) {
         p_92540_ = "MissingName";
         p_92541_ = p_92542_ = "NotValid";
         org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(getClass().getName());
         logger.warn("=========================================================");
         logger.warn("WARNING!! the username was not set for this session, typically");
         logger.warn("this means you installed Forge incorrectly. We have set your");
         logger.warn("name to \"MissingName\" and your session to nothing. Please");
         logger.warn("check your installation and post a console log from the launcher");
         logger.warn("when asking for help!");
         logger.warn("=========================================================");
      }
      this.name = p_92540_;
      this.uuid = p_92541_;
      this.accessToken = p_92542_;
      this.type = User.Type.byName(p_92543_);
   }

   public String getSessionId() {
      return "token:" + this.accessToken + ":" + this.uuid;
   }

   public String getUuid() {
      return this.uuid;
   }

   public String getName() {
      return this.name;
   }

   public String getAccessToken() {
      return this.accessToken;
   }

   public GameProfile getGameProfile() {
      try {
         UUID uuid = UUIDTypeAdapter.fromString(this.getUuid());
         GameProfile ret = new GameProfile(uuid, this.getName());    //Forge: Adds cached GameProfile properties to returned GameProfile.
         if (properties != null) ret.getProperties().putAll(properties); // Helps to cut down on calls to the session service,
         return ret;                                                     // which helps to fix MC-52974.
      } catch (IllegalArgumentException illegalargumentexception) {
         return new GameProfile((UUID)null, this.getName());
      }
   }

   //For internal use only. Modders should never need to use this.
   public void setProperties(com.mojang.authlib.properties.PropertyMap properties) {
       if (this.properties == null)
           this.properties = properties;
   }

   public boolean hasCachedProperties() {
       return properties != null;
   }

   public User.Type getType() {
      return this.type;
   }

   @OnlyIn(Dist.CLIENT)
   public static enum Type {
      LEGACY("legacy"),
      MOJANG("mojang");

      private static final Map<String, User.Type> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap((p_92560_) -> {
         return p_92560_.name;
      }, Function.identity()));
      private final String name;

      private Type(String p_92558_) {
         this.name = p_92558_;
      }

      @Nullable
      public static User.Type byName(String p_92562_) {
         return BY_NAME.get(p_92562_.toLowerCase(Locale.ROOT));
      }
   }
}
