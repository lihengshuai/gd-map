package core.http;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import java.io.IOException;
import java.util.Map;

/**
 * Date: 16/7/20 Time: PM4:38
 *
 * @author Loki
 */
public class ResponseDeserializer extends JsonDeserializer<Response> {

  @Override
  public Response deserialize(JsonParser jp, DeserializationContext context)
      throws IOException {

    ObjectCodec oc = jp.getCodec();
    JsonNode node = oc.readTree(jp);

    JsonNode statusNode = node.get(Response.STATUS);
    if (statusNode == null) {
      throw new RuntimeJsonMappingException(
          "Cannot deserialize json without 'status' field");
    }

    String statusVal = statusNode.asText();
    if (statusVal == null || statusVal.isEmpty()) {
      throw new RuntimeJsonMappingException("Invalid 'status' field");
    }

    Response<?> response;

    if (ResponseStatus.SUCCESS.toString().equalsIgnoreCase(statusVal)) {
      response = Response.instanceSuccess();
    } else if (ResponseStatus.FAIL.toString().equalsIgnoreCase(statusVal)) {
      response = Response.instanceFail();
    } else if (ResponseStatus.ERROR.toString().equalsIgnoreCase(statusVal)) {
      response = Response.instanceError();
    } else {
      throw new RuntimeJsonMappingException(
          "Invalid 'status' value: " + statusVal);
    }

    JsonNode dataNode = node.get(Response.DATA);
    if (dataNode != null) {
      ObjectMapper mapper = new ObjectMapper();
      @SuppressWarnings("unchecked")
      Map<String, Object> dataMap = mapper.convertValue(dataNode, Map.class);
      response.withData(dataMap);
    }

    JsonNode messageNode = node.get(Response.MESSAGE);
    if (messageNode != null) {
      response.withMessage(messageNode.asText());
    }

    JsonNode codeNode = node.get(Response.CODE);
    if (codeNode != null) {
      response.withCode(codeNode.asText());
    }

    return response;
  }
}
