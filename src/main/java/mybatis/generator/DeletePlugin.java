package mybatis.generator;

import java.util.List;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * A plugin that can replace 'delete' operation on DB with 'update' operation.
 * It assumes the DB structure complies the contract that a column named 'deleted_at'
 * exists. It writes current time into this field instead of removing the record.
 * <p>
 * Date: 16/7/4 Time: PM5:10
 *
 * @author Loki
 */
public class DeletePlugin extends PluginAdapter {

  @Override
  public boolean validate(List<String> warnings) {
    return true;
  }

  public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method,
                                                         Interface interfaze, IntrospectedTable introspectedTable) {
    String tblName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
    IntrospectedColumn column = introspectedTable.getColumn("deleted_at");
    if (column == null || column.isJDBCDateColumn()) {
      throw new RuntimeException("Table " + tblName + " should have one column called " +
          "`deleted_at' which is of timestamp type.");
    }

    // TODO below is not fully flexible as it assumes the primary key column is
    // called 'id' and the column type is 'BIGINT'
    List<String> annotations = method.getAnnotations();
    annotations.clear();

    method.addAnnotation("@Update({");
    method.addAnnotation("    \"update " + tblName + "\",");
    method.addAnnotation("    \"set deleted_at = now()\",");
    method.addAnnotation("    \"where id = #{id,jdbcType=BIGINT}\"");
    method.addAnnotation("})");
    return true;
  }

  public boolean sqlMapDeleteByExampleElementGenerated(XmlElement element,
                                                       IntrospectedTable introspectedTable) {
    String tblName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
    IntrospectedColumn column = introspectedTable.getColumn("deleted_at");

    if (column == null || column.isJDBCDateColumn()) {
      throw new RuntimeException("Table " + tblName + " should have one column called " +
          "`deleted_at' which is of timestamp type.");
    }

    element.setName("update");

    int index = -1;
    List<Element> elements = element.getElements();
    for (int i = 0; i < elements.size(); i++) {
      Element e = elements.get(i);
      if (!(e instanceof TextElement)) {
        continue;
      }
      String statement = ((TextElement) e).getContent();
      if (statement.contains("delete from ")) {
        elements.set(i, new TextElement(statement.replace("delete from ", "update ")));
        index = i;
        break;
      }
    }
    element.addElement(index + 1, new TextElement("set deleted_at = now()"));
    return true;
  }
}
