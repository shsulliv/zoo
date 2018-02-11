package controllers;

import javax.annotation.Nullable;
import java.util.UUID;

public class UUIDUtils {
  @Nullable
  public static UUID safeFromString(String name) {
    try {
      return UUID.fromString(name);
    } catch (IllegalArgumentException exception) {
      return null;
    }
  }
}
