package in.anandm.oj.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class CustomSiteMeshFilter extends ConfigurableSiteMeshFilter {

    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {

        builder.addDecoratorPath("/*", "/decorators/default");
        builder.addExcludedPath("/decorators/*");
        builder.addExcludedPath("/resources/*");
    }
}
