package com.lf.mimall.mimallcommon.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/9/8
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */

@ConfigurationProperties(prefix = "com.lf.swagger2")
public class SwaggerProperties {

    /**
     * 是否启用swagger,生产环境建议关闭
     */
    private boolean enabled;
    /**
     * 文档标题
     */
    private String title;
    /**
     * 文档描述
     */
    private String description;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SwaggerProperties{" +
                "enabled=" + enabled +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
