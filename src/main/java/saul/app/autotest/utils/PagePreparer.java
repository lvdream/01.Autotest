package saul.app.autotest.utils;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;

/**
 * 页面常量准备
 *
 * @author saul
 * @date 2016-01-20
 */

public class PagePreparer implements ViewPreparer {
    public void execute(Request tilesRequest, AttributeContext attributeContext) throws PreparerException {
        attributeContext.putAttribute("uploadPath", new Attribute(GetProperties.getProperties("system.properties", "upload.file.path")), true);
        attributeContext.putAttribute("uploadExtend", new Attribute(GetProperties.getProperties("system.properties", "upload.file.extend")), true);
        attributeContext.putAttribute("uploadSize", new Attribute(GetProperties.getProperties("system.properties", "upload.file.size")), true);

    }


}
