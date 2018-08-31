package mybatis.generator;

import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**
 * The plugin that will replace jdbc time type to JSR 310 type.
 * The following is an example MBG configuration file,
 * <code>
 *   <javaTypeResovler type="cn.xinzhili.xutils.mybatis.generator.DateTypeResolver">
 *     <property name="useJSR310" value="true"/>
 *   </javaTypeResolver>
 * </code>
 * Created by Loki on 26/06/2018.
 */
public class DateTypeResolver extends JavaTypeResolverDefaultImpl {

  private static final String PROP_USE_JSR_310 = "useJSR310";

  private static final String PROP_JAVA_TYPE_BY_COLUMN_NAME_PREFIX = "javaTypeByColumnName.";


  private Map<String, FullyQualifiedJavaType> javaTypeByColumnName = new HashMap<>();

  @Override
  public void addConfigurationProperties(Properties properties) {
    super.addConfigurationProperties(properties);
    if ("true".equalsIgnoreCase(properties.getProperty(PROP_USE_JSR_310))) {
      typeMap.put(Types.DATE,
          new JdbcTypeInformation("DATE", new FullyQualifiedJavaType(LocalDate.class.getName())));
      typeMap.put(Types.TIME,
          new JdbcTypeInformation("TIME", new FullyQualifiedJavaType(LocalTime.class.getName())));
      typeMap.put(Types.TIME_WITH_TIMEZONE,
          new JdbcTypeInformation("TIME_WITH_TIMEZONE",
              new FullyQualifiedJavaType(LocalTime.class.getName())));
      typeMap.put(Types.TIMESTAMP,
          new JdbcTypeInformation("TIMESTAMP",
              new FullyQualifiedJavaType(LocalDateTime.class.getName())));
      typeMap.put(Types.TIMESTAMP_WITH_TIMEZONE,
          new JdbcTypeInformation("TIMESTAMP_WITH_TIMEZONE",
              new FullyQualifiedJavaType(LocalDateTime.class.getName())));
    }
    properties.stringPropertyNames().forEach(propName -> {
      if (propName.startsWith(PROP_JAVA_TYPE_BY_COLUMN_NAME_PREFIX)) {
        String columnName = propName
            .substring(PROP_JAVA_TYPE_BY_COLUMN_NAME_PREFIX
                .length());
        String propValue = properties.getProperty(propName);
        javaTypeByColumnName.put(columnName,
            new FullyQualifiedJavaType(propValue));
      }
    });
  }

}
