package ai.code.mikasa.spring.ns.handlers;

import ai.code.mikasa.spring.parser.MstoneBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MstoneNameSpaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("mstone", new MstoneBeanDefinitionParser());
    }
}
