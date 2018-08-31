package core.http;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Map;

/**
 * Date: 16/6/30 Time: AM12:26
 * <p>
 * serialize response to json
 *
 * @author Loki
 */
public class ResponseSerializer extends JsonSerializer<Response> {

  @Override
  public void serialize(
      Response response,
      JsonGenerator jsonGenerator,
      SerializerProvider provider) throws IOException {
    jsonGenerator.writeStartObject();
    ResponseStatus status = response.getStatus();

    if (status != null) {
      jsonGenerator.writeFieldName(Response.STATUS);
      jsonGenerator.writeString(status.toString());
    } else {
      throw new IOException(Response.STATUS + " field is mandatory");
    }

    @SuppressWarnings("unchecked") Map<String, Object> data = response.getData();

    if (status == ResponseStatus.SUCCESS) {
      if (!response.getData().isEmpty()) {
        writeDataObject(jsonGenerator, data);
      } else {
        writeNullData(jsonGenerator, Response.DATA);
      }
    }

    if (status == ResponseStatus.FAIL) {
      if (!response.getData().isEmpty()) {
        writeDataObject(jsonGenerator, data);
      } else {
        writeNullData(jsonGenerator, Response.DATA);
      }
    }

    if (status == ResponseStatus.ERROR) {
      if (response.getMessage() != null) {
        jsonGenerator.writeFieldName(Response.MESSAGE);
        jsonGenerator.writeString(response.getMessage());
        if (response.getCode() != null) {
          jsonGenerator.writeFieldName(Response.CODE);
          jsonGenerator.writeString(response.getCode());
        }
        if (!response.getData().isEmpty()) {
          writeDataObject(jsonGenerator, data);
        }
      } else {
        throw new IOException(Response.MESSAGE
            + " field is mandatory when " + Response.STATUS
            + " is " + ResponseStatus.ERROR);
      }
    }
    jsonGenerator.writeEndObject();
  }

  private void writeDataObject(
      JsonGenerator arg1,
      Map<String, Object> data) throws IOException {
    arg1.writeFieldName(Response.DATA);
    arg1.writeStartObject();

    for (Map.Entry<String, Object> entry : data.entrySet()) {
      arg1.writeFieldName(entry.getKey());
      arg1.writeObject(entry.getValue());
    }
    arg1.writeEndObject();
  }

  private void writeNullData(
      JsonGenerator jsonGenerator,
      String tag) throws IOException {
    jsonGenerator.writeFieldName(tag);
    jsonGenerator.writeNull();
  }

}
