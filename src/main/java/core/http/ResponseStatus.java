package core.http;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Loki on 7/11/16.
 */
public enum ResponseStatus {

  SUCCESS("success"), FAIL("fail"), ERROR("error");
  private final String status;

  private ResponseStatus(final String status) {
    this.status = status;
  }

  public String getStatus() {
    return this.status;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.status.toLowerCase();
  }
}
